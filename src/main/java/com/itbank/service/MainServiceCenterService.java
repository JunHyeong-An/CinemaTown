package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.MainServiceCenterDao;
import com.itbank.model.MasterNoticeDTO;

@Service
public class MainServiceCenterService {

	@Autowired private MainServiceCenterDao dao;

	// 메인페이지 공지사항 한개 페이징
	public int mainselectCount() {
		return dao.mainSelectCount();
	}

	// 메인페이지 공지사항 전체 페이징
	public List<MasterNoticeDTO> mainnoticeSelect(int offset, int perPage) {
		return dao.mainNoticeSelect(offset, perPage);
	}

	// 공지사항 글 한개 읽어오기
	public List<MasterNoticeDTO> noticeModify(int notice_idx) {
		return dao.noticeModify(notice_idx);
	}
	
	
}
