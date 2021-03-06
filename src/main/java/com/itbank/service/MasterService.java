package com.itbank.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.itbank.model.CinemaEventListDTO;
import com.itbank.model.CinemaHallDTO;
import com.itbank.model.CinemaMovieDTO;
import com.itbank.model.CinemaScheduleDTO;
import com.itbank.model.MasterDAO;
import com.itbank.model.OneToOneAnswerDTO;
import com.itbank.model.OneToOneDTO;
import com.itbank.model.ServiceCenterDTO;

@Service
public class MasterService {

	@Autowired private MasterDAO dao;
	
	public List<HashMap<String, Object>> movieSales() {
		return dao.movieSales();
		
	}
	
	public List<HashMap<String, Object>> monthSales() {
		
		return dao.monthSales();
	}
	
	// C에 uploadimage파일 생성하기
		private final String uploadPath = "C:\\uploadimage";
		
		// 파일생성하기
		public MasterService() {
			File dir = new File(uploadPath);
			if(dir.exists() == false) {
				dir.mkdirs();
				System.out.println("업로드 폴더를 생성했습니다 !!");
			}
		}

	public List<ServiceCenterDTO> lostList(int offset,int perPage) {
		return dao.lostList(offset,perPage);
	}

	public List<OneToOneDTO> oneToOneList(int offset,int perPage) {
		return dao.oneToOneList(offset,perPage);
	}

	public OneToOneDTO EachOneToOne(int oneToOne_idx) {
		return dao.EachOneToOne(oneToOne_idx);
	}

	public int oneToOneAnswer(OneToOneAnswerDTO dto) {
		return dao.oneToOneAnswer(dto);
	}

	public List<OneToOneAnswerDTO> replyList() {
		return dao.replyList();
	}

	public int oneToOneAnswerModify(OneToOneAnswerDTO dto) {
		return dao.oneToOneAnswerModify(dto);
	}
	
	public List<CinemaMovieDTO> movieList() {
      return dao.movieList();
   }
	
	public int insert(CinemaMovieDTO dto) {
		return dao.insert(dto);
	}
	
	public List<CinemaHallDTO> hallList() {
		return dao.hallList();
	}
	
	// 상영 일정 추가 시 같은 상영관에 시간 겹치지 않도록 해주기
	public int scheduleCheck(String scheduleTime, String hallName) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("scheduleTime", scheduleTime);
		map.put("hallName", hallName);

		return dao.scheduleCheck(map);
	}
	
	public int insertMovie(CinemaScheduleDTO dto, String hallName) {
		
		CinemaHallDTO hall_dto = dao.hallInfo(hallName);
		dto.setHall_idx(hall_dto.getHall_idx());
		dto.setSeatCountRemain(hall_dto.getSeatCountAll());
		
		Date endTime = new Date(dto.getStartTime().getTime() + 
								dao.runningTime(dto.getMovieName())* 60000);
		dto.setEndTime(endTime);
		return dao.insertMovie(dto);
	}
	
	// 현재날짜를 기준으로 파일명 저장하기
		public int uploadEvent(CinemaEventListDTO dto) {
			System.out.println(dto);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date time = new Date();
			String currentTime = sdf.format(time);
			MultipartFile files = dto.getFiles();
			System.out.println(files);
				System.out.println(files.getOriginalFilename());
				String fileName = currentTime + "-" +
								  files.getOriginalFilename();
				
				File dest = new File(uploadPath, fileName);
				System.out.println(fileName);
				dto.setEventListFileName(fileName);
				try {
					files.transferTo(dest);
				}catch(IllegalStateException e) {
					e.printStackTrace();
				}catch(IOException e) {
					e.printStackTrace();
				}
			
			System.out.println(dto.getEventListFileName());
			int row = dao.insertEvent(dto);
			
			return row;
		}

		public List<CinemaEventListDTO> selectList() {
			return dao.selectList();
		}

		public List<CinemaEventListDTO> selectList2() {
			return dao.selectList2();
		}

		public List<CinemaEventListDTO> selectOne(int event_idx) {
			return dao.selectOne(event_idx);
		}

		public List<CinemaEventListDTO> selectOneList(int event_idx) {
			return dao.selectOneList(event_idx);
		}

		// 수정된 파일명도 현재 날짜로 저장하기
		public int modify(CinemaEventListDTO dto) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date time = new Date();
			String currentTime = sdf.format(time);
			MultipartFile files = dto.getFiles();
				System.out.println(files.getOriginalFilename());
				String fileName = currentTime + "-" +
								  files.getOriginalFilename();
				
				File dest = new File(uploadPath, fileName);
				System.out.println(fileName);
				dto.setEventListFileName(fileName);
				try {
					files.transferTo(dest);
				}catch(IllegalStateException e) {
					e.printStackTrace();
				}catch(IOException e) {
					e.printStackTrace();
				}
			
			System.out.println(dto.getEventListFileName());
			int row = dao.modify(dto);
			
			return row;
		
		}

		public void deleteMovie(String movieName) {
			dao.deleteMovie(movieName);
		}

		public int eventDelete(int event_idx) {
			return dao.eventDelete(event_idx);
		}

		public int selectCount() {
			return dao.selectCount();
		}

		public int selectCount2() {
			return dao.selectCount2();
		}

		public ServiceCenterDTO LostEach(int cinemaLost_idx) {
			return dao.LostEach(cinemaLost_idx);
		}

		public List<HashMap<String, String>> scheduleList() {
			
			return dao.scheduleList();
		}

		

		
}
