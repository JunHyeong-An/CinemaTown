package com.itbank.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.itbank.model.MasterNoticeDTO;
import com.itbank.model.OneToOneDTO;
import com.itbank.model.ServiceCenterDAO;
import com.itbank.model.ServiceCenterDTO;

@Service
public class seviceCenterService {

	@Autowired private ServiceCenterDAO dao;
	
	// C에 uploadimage파일 생성하기
	private final String uploadPath = "C:\\uploadimage";

	// 파일생성하기
	public seviceCenterService() {
		File dir = new File(uploadPath);
		if(dir.exists() == false) {
			dir.mkdirs();
			System.out.println("업로드 폴더를 생성했습니다 !!");
		}
	}

	public int addlostList(ServiceCenterDTO dto) {
		return dao.addlostList(dto);
	}

	public int addOneToOneList(OneToOneDTO dto) {
		return dao.addOneToOneList(dto);
	}

	public int selectCount() {
		return dao.selectCount();
	}

	// 게시판 페이징 전체
	public List<MasterNoticeDTO> noticeSelect(int offset, int perPage) {
		return dao.noticeSelect(offset, perPage);
	}
	
	// 공지사항 글 올리기
	public int noticeWrite(MasterNoticeDTO dto) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date time = new Date();
		String currentTime = sdf.format(time);
		MultipartFile files = dto.getFiles();
			String fileName ="";
			if(files.getOriginalFilename() != "") {
				
				fileName = currentTime + "-" +
						files.getOriginalFilename();
			}
			
			File dest = new File(uploadPath, fileName);
			System.out.println(fileName);
			dto.setNoticeFileName(fileName);
			try {
				files.transferTo(dest);
			}catch(IllegalStateException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
		
		System.out.println(dto.getNoticeFileName());
		int row = dao.noticeWrite(dto);
		
		return row;
	}

	public List<MasterNoticeDTO> noticeReadOne(int notice_idx) {
		return dao.noticeReandOne(notice_idx);
	}

	public List<MasterNoticeDTO> noticeModify(int notice_idx) {
		return dao.noticeModify(notice_idx);
	}

	// 공지사항 글 수정하기
	public int noticeModifyOne(MasterNoticeDTO dto) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date time = new Date();
		String currentTime = sdf.format(time);
		MultipartFile files = dto.getFiles();
			String fileName ="";
			if(files.getOriginalFilename() != "") {
				
				fileName = currentTime + "-" +
						files.getOriginalFilename();
			}
			
			File dest = new File(uploadPath, fileName);
			System.out.println(fileName);
			dto.setNoticeFileName(fileName);
			try {
				files.transferTo(dest);
			}catch(IllegalStateException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
		
		System.out.println(dto.getNoticeFileName());
		int row = dao.noticeModifyOne(dto);
		
		return row;
	}

	// 공지사항 삭제
	public int noticeDelete(int notice_idx) {
		return dao.noticeDelete(notice_idx);
	}


	
	
}
