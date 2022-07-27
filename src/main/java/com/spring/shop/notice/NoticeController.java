package com.spring.shop.notice;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.shop.common.AttachDto;
import com.spring.shop.common.SearchDto.SearchCreateResponse;
import com.spring.shop.common.SearchDto.SearchData;
import com.spring.shop.common.SearchDto.SearchRequest;
import com.spring.shop.login.LoginDto;

@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@RequestMapping(value = "/notice", method = RequestMethod.GET)
	public String notice(Model model) {
		NoticeDto lastestNotice = noticeService.getLastestNotice();
		model.addAttribute("lastestNotice", lastestNotice);
		model.addAttribute("content", "notice.jsp");
		return "home";
	}
	
	@RequestMapping(value="/getNoticeList", method = RequestMethod.GET)
	@ResponseBody
	public SearchCreateResponse getNoticeList(SearchRequest dto) {
		SearchData data = noticeService.selectListNotice(dto);
		return new SearchCreateResponse(data);
	}
	
	@RequestMapping(value = "/writeNoticeForm", method = RequestMethod.GET)
	public String writeNoticeForm(Model model) {
		model.addAttribute("content", "writeNotice.jsp");
		return "home";
	}

	@RequestMapping(value = "/writeNotice", method = RequestMethod.POST)
	public String writeNotice(NoticeDto noticeDto, Model model, HttpServletRequest req) throws Exception {
		LoginDto loginDto = (LoginDto) req.getSession().getAttribute("loginUser");
		
		if (loginDto.getMi_id().equals(noticeDto.getNb_id())) {
			int result = noticeService.writeNotice(noticeDto, req);
			
			if (result > 0) {
				model.addAttribute("MSG", "공지를 등록하였습니다.");
				model.addAttribute("content", "main.jsp");
			}
		} else {
			model.addAttribute("MSG", "공지 등록에 실패하였습니다.");
			model.addAttribute("content", "writeNotice.jsp");
		}
		return "home";
	}

	@RequestMapping(value = "/selectOneNotice/{nb_num}", method = RequestMethod.GET)
	public String selectOneNotice(@PathVariable("nb_num") int nb_num, Model model) {
		NoticeDto noticeDto = noticeService.selectOneNotice(nb_num);
		AttachDto attachDto = noticeService.selectFileName(nb_num);
		
		model.addAttribute("noticeDto", noticeDto);
		model.addAttribute("attachDto", attachDto);
		model.addAttribute("content", "detailNotice.jsp");
		return "home";
	}

	@RequestMapping(value = "/editNoticeForm/{nb_num}", method = RequestMethod.GET)
	public String editNoticeForm(@PathVariable("nb_num") int nb_num, Model model) {
		NoticeDto noticeDto = noticeService.selectOneNotice(nb_num);
		AttachDto attachDto = noticeService.selectFileName(nb_num);
		
		model.addAttribute("noticeDto", noticeDto);
		model.addAttribute("attachDto", attachDto);
		model.addAttribute("content", "editNotice.jsp");
		return "home";
	}

	@RequestMapping(value = "/editNotice", method = RequestMethod.POST)
	public String editNotice(NoticeDto noticeDto, Model model, HttpServletRequest req) throws IOException {
		int result = noticeService.editNotice(noticeDto, req);

		if (result > 0) {
			model.addAttribute("MSG", "공지를 수정하였습니다.");
			model.addAttribute("content", "notice.jsp");
		} else {
			model.addAttribute("MSG", "공지 수정에 실패하였습니다.");
			model.addAttribute("content", "editNotice.jsp");
		}
		return "home";
	}

	@RequestMapping(value = "/deleteNotice/{nb_num}", method = RequestMethod.GET)
	public String deleteNotice(@PathVariable("nb_num") int nb_num, Model model, HttpServletRequest req) {
		int result = noticeService.deleteNotice(nb_num, req);

		if (result > 0) {
			model.addAttribute("MSG", "공지를 삭제하였습니다.");
			model.addAttribute("content", "notice.jsp");
		} else {
			model.addAttribute("MSG", "공지 삭제에 실패하였습니다.");
			model.addAttribute("content", "detailNotice.jsp");
		}
		return "home";
	}
}
