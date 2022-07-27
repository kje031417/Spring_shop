package com.spring.shop.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public class FileServiceImpl implements FileService {
	@Override
	public AttachDto singleUpload(String path, MultipartHttpServletRequest mr, String board_type, int num) throws FileNotFoundException, IOException {
		File saveDir = new File(path);
		
		if(!saveDir.exists()) {
			saveDir.mkdirs();
		}
		
		MultipartFile file = mr.getFile("file");
		
		String boardType = board_type;
		String name = file.getOriginalFilename();
		Long size = file.getSize();
		
		File destination = File.createTempFile("F_"+ System.currentTimeMillis(), name.substring(name.lastIndexOf(".")), saveDir);
		
		String saved_file_name = destination.getName();
		
		FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(destination));
		
		AttachDto attachDto = AttachDto.createDto(boardType, num, name, saved_file_name, size);
		
		return attachDto;
	}	
	
	@Override
	public List<AttachDto> multipleUpload(String path, MultipartHttpServletRequest mr, String board_type, int num) throws IOException {
		File saveDir = new File(path);
		
		if(!saveDir.exists()) {
			saveDir.mkdirs();
		}
		
		List<MultipartFile> file = mr.getFiles("file");
		List<AttachDto> list = new ArrayList<AttachDto>();
		
		for(MultipartFile multiFile : file) {
			String boardType = board_type;
			String name = multiFile.getOriginalFilename();
			Long size = multiFile.getSize();
			
			File destination = File.createTempFile("F_" + System.currentTimeMillis(), name.substring(name.lastIndexOf(".")), saveDir);
			
			String saved_file_name = destination.getName();
			
			FileCopyUtils.copy(multiFile.getInputStream(), new FileOutputStream(destination));
			
			AttachDto attachDto = AttachDto.createDto(boardType, num, name, saved_file_name, size);
			
			list.add(attachDto);
		}
		
		return list;
	}
}
