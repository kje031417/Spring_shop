package com.spring.shop.gallery;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.shop.common.AttachDto;
import com.spring.shop.common.SearchDto.GallerySearchCreateResponse;
import com.spring.shop.common.SearchDto.GallerySearchData;
import com.spring.shop.common.SearchDto.SearchRequest;
import com.spring.shop.login.LoginDto;

@Controller
public class GalleryController {
	
	@Autowired
	private GalleryService galleryService;
	
	@RequestMapping(value = "/gallery", method = RequestMethod.GET)
	public String gallery(Model model) {
		model.addAttribute("content", "gallery.jsp");
		return "home";
	}
	
	@RequestMapping(value="/getMainImgList", method=RequestMethod.GET)
	@ResponseBody
	public GallerySearchCreateResponse getGalleryList(SearchRequest dto) {
		GallerySearchData data = galleryService.getMainImgList(dto);
		return new GallerySearchCreateResponse(data);
	}
	
	@RequestMapping(value="/selectOneGallery/{board_id}", method=RequestMethod.GET)
	public String goGalleryList(@PathVariable("board_id") int board_id, Model model) {
		GalleryDto galleryDto = galleryService.getGalleryList(board_id);	
		List<AttachDto> imgList = galleryService.getFilesPath(board_id);
		
		model.addAttribute("galleryDto", galleryDto);
		model.addAttribute("imgList", imgList);
		model.addAttribute("content", "detailGallery.jsp");
		return "home";
	}
	
	@RequestMapping(value="/uploadGalleryForm", method=RequestMethod.GET)
	public String uploadGalleryForm(Model model) {
		model.addAttribute("content", "uploadGallery.jsp");
		return "home";
	}
	
	@RequestMapping(value="/uploadGallery", method=RequestMethod.POST)
	public String uploadGallery(GalleryDto galleryDto, HttpServletRequest req, Model model) throws FileNotFoundException, IOException {
		LoginDto loginDto = (LoginDto) req.getSession().getAttribute("loginUser");
		
		if(galleryDto.getGb_id().equals(loginDto.getMi_id())) {
			int result = galleryService.uploadGallery(galleryDto, req);
			if(result > 0) {
				model.addAttribute("MSG", "갤러리에 등록하였습니다.");
			}
		} else {
			model.addAttribute("MSG", "갤러리에 등록하지 못하였습니다.");
		}
		model.addAttribute("content", "gallery.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/editGalleryForm/{gb_num}", method = RequestMethod.GET)
	public String editGalleryForm(@PathVariable("gb_num") int gb_num, Model model) {
		GalleryDto galleryDto = galleryService.getGalleryList(gb_num);
		List<AttachDto> imgList = galleryService.getFilesPath(gb_num);
		
		model.addAttribute("galleryDto", galleryDto);
		model.addAttribute("imgList", imgList);
		model.addAttribute("content", "editGallery.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/editGallery", method = RequestMethod.POST)
	public String editGallery(GalleryDto galleryDto, Model model, HttpServletRequest req) {
		int result = galleryService.editGallery(galleryDto, req);
		
		if(result > 0) {
			model.addAttribute("MSG", "갤러리를 수정하였습니다.");
			model.addAttribute("content", "gallery.jsp");
		} else {
			model.addAttribute("MSG", "갤러리 수정에 실패하였습니다.");
			model.addAttribute("content", "editGallery.jsp");
		}	
		return "home";
	}
	
	@RequestMapping(value = "/deleteGallery/{gb_num}", method = RequestMethod.GET)
	public String deleteGallery(@PathVariable("gb_num") int gb_num, Model model, HttpServletRequest req) {
		int result = galleryService.deleteGallery(gb_num, req);
		
		if(result > 0) {
			model.addAttribute("MSG", "갤러리를 삭제하였습니다.");
			model.addAttribute("content", "gallery.jsp");
		} else {
			model.addAttribute("MSG", "갤러리 삭제에 실패하였습니다.");
			model.addAttribute("content", "detailGallery.jsp");
		}
		return "home";
	}
}
