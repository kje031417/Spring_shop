package com.spring.shop.notice;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.shop.common.AttachDto;
import com.spring.shop.common.FileRepository;
import com.spring.shop.common.FileService;
import com.spring.shop.common.PageGenerator;
import com.spring.shop.common.RequestDto;
import com.spring.shop.common.SearchDto.SearchData;
import com.spring.shop.common.SearchDto.SearchRequest;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private PageGenerator pageGenerator;
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private NoticeRepository noticeRepository;
	
	@Autowired
	private FileRepository fileRepository;
	
	@Autowired
	private PlatformTransactionManager platformTransactionManager;
	
	@Override
	public SearchData selectListNotice(SearchRequest dto) {
		int totalCnt = noticeRepository.getTotalCnt(dto);
		
		dto = pageGenerator.generatePaging(dto);

		List<NoticeDto> list = noticeRepository.selectListNotice(dto);
		
		return SearchData.create(totalCnt, list);
	}
	
	@Override
	public NoticeDto getLastestNotice() {
		return noticeRepository.getLastestNotice();
	}
	
	@Override
	public int getTotalCnt(SearchRequest dto) {
		return noticeRepository.getTotalCnt(dto);
	}
	
	@Override
	public int writeNotice(NoticeDto noticeDto, HttpServletRequest req) throws IOException {
		TransactionStatus status = platformTransactionManager.getTransaction(new DefaultTransactionAttribute());
		
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest) req;

		String path = mr.getSession().getServletContext().getRealPath("/resources/file");
		String board_type = "NOTICE";
		String saved_file_name = null;
		
		try {
			noticeRepository.writeNotice(noticeDto);
			
			if(!mr.getFile("file").isEmpty()) {
				AttachDto attachDto = fileService.singleUpload(path, mr, board_type, noticeDto.getNb_num());
				saved_file_name = attachDto.getSaved_file_name();
				
				fileRepository.insertFile(attachDto);
			}
			
			platformTransactionManager.commit(status);
			
			return 1;
		} catch (Exception e) {
			File deleteFile = new File(path+"/"+saved_file_name);
			
			deleteFile.delete();
			
			platformTransactionManager.rollback(status);
			return 0;
		}
	}

	@Override
	public NoticeDto selectOneNotice(int nb_num) {
		return noticeRepository.selectOneNotice(nb_num);
	}
	
	@Override
	public AttachDto selectFileName(int nb_num) {
		String board_type = "NOTICE";
		RequestDto requestDto = RequestDto.CreateDto(board_type, nb_num);
		return fileRepository.selectFileName(requestDto);
	}
	
	@Override
	public int editNotice(NoticeDto noticeDto, HttpServletRequest req) throws IOException {
		TransactionStatus status = platformTransactionManager.getTransaction(new DefaultTransactionAttribute());
		
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest) req;
			
		String path = mr.getSession().getServletContext().getRealPath("/resources/file");
		String board_type = "NOTICE";
		String saved_file_name = null;		
		
		try {
			noticeRepository.editNotice(noticeDto);	
			
			if(!mr.getFile("file").isEmpty()) {
				AttachDto attachDto = null;
				RequestDto requestDto = RequestDto.CreateDto(board_type, noticeDto.getNb_num());
				
				if(fileRepository.selectFileName(requestDto) != null) {
					attachDto = fileRepository.selectFileName(requestDto);
					saved_file_name = attachDto.getSaved_file_name();
					
					File deleteFile = new File(path+"/"+saved_file_name);
					
					deleteFile.delete();
					
					attachDto = fileService.singleUpload(path, mr, board_type, noticeDto.getNb_num());
					
					fileRepository.editFile(attachDto);
				} else {
					attachDto = fileService.singleUpload(path, mr, board_type, noticeDto.getNb_num());
					
					fileRepository.insertFile(attachDto);
				}	
			} 
			
			platformTransactionManager.commit(status);	
			
			return 1;
		} catch (Exception e) {
			File deleteFile = new File(path+"/"+saved_file_name);
			
			deleteFile.delete();
			
			platformTransactionManager.rollback(status);	
			
			return 0;
		}		
	}

	@Override
	public int deleteNotice(int nb_num, HttpServletRequest req) {
		TransactionStatus status = platformTransactionManager.getTransaction(new DefaultTransactionAttribute());
		
		String path = req.getSession().getServletContext().getRealPath("resources/file");
		String board_type="NOTICE";
		
		try {
			noticeRepository.deleteNotice(nb_num);
			RequestDto requestDto = RequestDto.CreateDto(board_type, nb_num);
			
			if(fileRepository.selectFileName(requestDto) != null) {
				AttachDto attachDto_delete = fileRepository.selectFileName(requestDto);
				
				fileRepository.deleteFile(requestDto);
				
				File deleteFile = new File(path+"/"+attachDto_delete.getSaved_file_name());
				
				deleteFile.delete();
			}
			platformTransactionManager.commit(status);
			
			return 1;
		} catch (Exception e) {
			platformTransactionManager.rollback(status);
			
			return 0;
		}
	}
	
}
