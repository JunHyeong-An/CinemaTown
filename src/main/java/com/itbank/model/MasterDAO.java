package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface MasterDAO {

	@Select("select * from cinemaLost")
	List<serviceCenterDTO> lostList();

}
