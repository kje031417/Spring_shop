package com.spring.shop.gallery;

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
import com.spring.shop.common.SearchDto.GallerySearchData;
import com.spring.shop.common.SearchDto.SearchRequest;

@Service
public class GalleryServiceImpl implements GalleryService {
	
	@Autowired
	private PageGenerator pageGenerator;
	
	@Autowired
	private PlatformTransactionManager platformTransactionManager;
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private GalleryRepository galleryRepository;
	
	@Autowired
	private FileRepository fileRepository;
	
	@Override
	public GallerySearchData getMainImgList(SearchRequest dto) {
		int totalCnt = galleryRepository.getTotalCnt(dto);
		
		dto = pageGenerator.generatePaging(dto);
		
		List<MainGalleryDto> list = galleryRepository.getMainImgList(dto);
		
		return GallerySearchData.create(totalCnt, list);
	}
	
	@Override
	public GalleryDto getGalleryList(int gb_num) {	
		return galleryRepository.getGalleryList(gb_num);
	}
	
	@Override
	public List<AttachDto> getFilesPath(int gb_num) {
		String board_type = "GALLERY";
		RequestDto requestDto = RequestDto.CreateDto(board_type, gb_num);
		return fileRepository.selectFilesName(requestDto);
	}
	
	@Override
	public int uploadGallery(GalleryDto galleryDto, HttpServletRequest req) throws IOException {
		TransactionStatus status = platformTransactionManager.getTransaction(new DefaultTransactionAttribute());
		
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest) req;
		
		String path = mr.getSession().getServletContext().getRealPath("/resources/file");
		String board_type = "GALLERY";
		String saved_file_name = null;
		List<AttachDto> list = null;
		
		try {
			galleryRepository.uploadGallery(galleryDto);
			
			if(!mr.getFile("file").isEmpty()) {
				list = fileService.multipleUpload(path, mr, board_type, galleryDto.getGb_num());
				
				for(AttachDto dto : list) {
					saved_file_name = dto.getSaved_file_name();
					
					fileRepository.insertFile(dto);
				}		
			}	
			platformTransactionManager.commit(status);
			
			return 1;
		} catch (Exception e) {
			File deleteFile = null;
			
			for(int i = 0; i<list.size(); i++) {
				deleteFile = new File(path+"/"+saved_file_name);
				
				deleteFile.delete();
			}
			platformTransactionManager.rollback(status);
			
			return 0;
		}
	}
	
	@Override
	public int editGallery(GalleryDto galleryDto, HttpServletRequest req) {
		TransactionStatus status = platformTransactionManager.getTransaction(new DefaultTransactionAttribute());
		
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest) req;
		
		String path = req.getSession().getServletContext().getRealPath("/resources/file");
		String board_type = "GALLERY";	
		String saved_file_name = null;	
		List<AttachDto> list = null;	
		File deleteFile = null;			 
		
		try {
			galleryRepository.editGallery(galleryDto);
			
			if(!mr.getFile("file").isEmpty()) {
				RequestDto requestDto = RequestDto.CreateDto(board_type, galleryDto.getGb_num());
				
				if(fileRepository.selectFilesName(requestDto) != null) {
					list = fileRepository.selectFilesName(requestDto);
					
					for(AttachDto dto : list) {
						fileRepository.deleteFile(requestDto);
						
						saved_file_name = dto.getSaved_file_name();
						
						deleteFile = new File(path+"/"+saved_file_name);
						
						deleteFile.delete();
					}			
					list = fileService.multipleUpload(path, mr, board_type, galleryDto.getGb_num());
					
					for(AttachDto dto : list) {
						saved_file_name = dto.getSaved_file_name();
						
						fileRepository.insertFile(dto);
					}		
				} else {
					list = fileService.multipleUpload(path, mr, board_type, galleryDto.getGb_num()); 
					
					for(AttachDto dto : list) {
						saved_file_name = dto.getSaved_file_name();
						
						fileRepository.insertFile(dto);
					}	
				}
			}		
			platformTransactionManager.commit(status);
			
			return 1;
		} catch (Exception e) {
			deleteFile = null;
			
			for(int i = 0; i<list.size(); i++) {
				deleteFile = new File(path+"/"+saved_file_name);
				
				deleteFile.delete();
			}
			platformTransactionManager.rollback(status);
			
			return 0;
		}
	}
	
	@Override
	public int deleteGallery(int gb_num, HttpServletRequest req) {
		TransactionStatus status = platformTransactionManager.getTransaction(new DefaultTransactionAttribute());
		
		String path = req.getSession().getServletContext().getRealPath("/resources/file");
		String board_type="GALLERY";
		
		try {
			galleryRepository.deleteGallery(gb_num);
			RequestDto requestDto = RequestDto.CreateDto(board_type, gb_num);
			File deleteFile = null;
			
			if(fileRepository.selectFilesName(requestDto) != null) {
				List<AttachDto> list_delete = fileRepository.selectFilesName(requestDto);
				
				for(AttachDto dto : list_delete) {
					fileRepository.deleteFile(requestDto);
					
					deleteFile = new File(path + "/" + dto.getSaved_file_name());

					deleteFile.delete();
				}
			}
			platformTransactionManager.commit(status);
			
			return 1;
		} catch (Exception e) {
			platformTransactionManager.rollback(status);
			
			return 0;
		}
	}
}
