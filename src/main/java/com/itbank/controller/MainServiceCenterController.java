package com.itbank.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.MasterNoticeDTO;
import com.itbank.model.Paging;
import com.itbank.service.MainServiceCenterService;


@Controller
@RequestMapping("/serviceCenter")
public class MainServiceCenterController {

	@Autowired private MainServiceCenterService ms;
	
		//공지사항 게시글 리스트 불러오기
		@GetMapping("/noticeList")
		public List<MasterNoticeDTO> noticeList(Model model, HttpServletRequest request){
			int boardCount = ms.mainselectCount();

			String page = request.getParameter("page");
			if(page == null) {
				Paging paging = new Paging(1, boardCount);
				List<MasterNoticeDTO> list = ms.mainnoticeSelect(paging.getOffset(),
						paging.getPerPage());
				model.addAttribute("list", list);
				model.addAttribute("paging", paging);
				return list;
			}
			Paging paging = new Paging(Integer.parseInt(page), boardCount);
			List<MasterNoticeDTO> list = ms.mainnoticeSelect(paging.getOffset(),
					paging.getPerPage());
			model.addAttribute("list", list);
			model.addAttribute("paging", paging);
			return list;
		}

		// idx값을 이용해서 공지사항의 글 한개 불러오기
		@GetMapping("/noticeRead/{notice_idx}")
		public ModelAndView noticeRead(@PathVariable int notice_idx) {
			ModelAndView mav = new ModelAndView("serviceCenter/noticeRead");
			List<MasterNoticeDTO> list = ms.noticeModify(notice_idx);
			mav.addObject("list", list);
			return mav;
		}
		
}
