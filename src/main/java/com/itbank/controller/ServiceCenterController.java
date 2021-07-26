package com.itbank.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.MasterNoticeDTO;
import com.itbank.model.OneToOneDTO;
import com.itbank.model.Paging;
import com.itbank.model.ServiceCenterDTO;
import com.itbank.service.seviceCenterService;

@Controller
public class ServiceCenterController {

	@Autowired private seviceCenterService scs;
	
	// 분실물문의 페이지 띄워주는 문구
	@GetMapping("/serviceCenter/lost")
	public String lost(ServiceCenterDTO dto) {
		return "serviceCenter/lost";
	}
	
	// 분실물 문의 페이지에서 작성한거 받아오는 문구 
	@PostMapping("/serviceCenter/lost")
	public String addlostList(ServiceCenterDTO dto) {
		System.out.println(dto);
		int row = scs.addlostList(dto);
		return "redirect:/";
	}
	
	// 1:1 문의페이지 불러오기
	@GetMapping("/serviceCenter/oneToOne")
	public void oneToOne() {}
	
	// 1:1 문의 페이지에서 받아오는 문구
	@PostMapping("serviceCenter/oneToOne")
	public String addOneToOneList(OneToOneDTO dto) {
		int row =scs.addOneToOneList(dto);
		return "redirect:/";
	}
	
	
	// 관리자 공지사항 리스트
	@GetMapping("/master/masterServiceCenter/masterNoticeList")
	public List<MasterNoticeDTO> noticeList(Model model, HttpServletRequest request){
		int boardCount = scs.selectCount();

		String page = request.getParameter("page");
		if(page == null) {
			Paging paging = new Paging(1, boardCount);
			List<MasterNoticeDTO> list = scs.noticeSelect(paging.getOffset(),
					paging.getPerPage());
			model.addAttribute("list", list);
			model.addAttribute("paging", paging);
			return list;
		}
		Paging paging = new Paging(Integer.parseInt(page), boardCount);
		List<MasterNoticeDTO> list = scs.noticeSelect(paging.getOffset(),
				paging.getPerPage());
		model.addAttribute("list", list);
		model.addAttribute("paging", paging);
		return list;
	}
	
	// 공지사항 글 쓰기
	@GetMapping("/master/masterServiceCenter/masterNoticeAdd")
	public void noticeAdd() {}
	
	// 공지사항 글 쓰기
	@PostMapping("/master/masterServiceCenter/masterNoticeAdd")
	public String noticeWrite(MasterNoticeDTO dto) {
		int row = scs.noticeWrite(dto);
		return "redirect:/master/masterServiceCenter/masterNoticeList";
	}
	
	// idx값을 이용해서 공지사항의 글 한개 불러오기
	@GetMapping("/master/masterServiceCenter/masterNoticeRead/{notice_idx}")
	public ModelAndView noticeRead(@PathVariable int notice_idx) {
		ModelAndView mav = new ModelAndView("master/masterServiceCenter/masterNoticeRead");
		List<MasterNoticeDTO> list = scs.noticeReadOne(notice_idx);
		mav.addObject("list", list);
		return mav;
	}
	
	// 공지사항 수정할 글 불러오기
	@GetMapping("/master/masterServiceCenter/masterNoticeModify/{notice_idx}")
	public ModelAndView noticeModify(@PathVariable int notice_idx) {
		ModelAndView mav = new ModelAndView("master/masterServiceCenter/masterNoticeModify");
		List<MasterNoticeDTO> list = scs.noticeModify(notice_idx);
		mav.addObject("list", list);
		return mav;
	}
	
	// 공지사항 글 수정하기
	@PostMapping("/master/masterServiceCenter/masterNoticeModify/{notice_idx}")
	public String noticeModifyOne(MasterNoticeDTO dto) {
		int row = scs.noticeModifyOne(dto);
		return "redirect:/master/masterServiceCenter/masterNoticeList";
	}
	
	// 공지사항 삭제
	@GetMapping("/master/masterServiceCenter/masterNoticeDelete/{notice_idx}")
	public String noticeDelete(@PathVariable int notice_idx) {
		int row = scs.noticeDelete(notice_idx);
		return "redirect:/master/masterServiceCenter/masterNoticeList";
	}
}
