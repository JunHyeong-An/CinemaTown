package com.itbank.model;

import org.apache.ibatis.annotations.Insert;

public interface serviceCenterDAO {

	@Insert("insert into cinemaLost(cinemaLostDateTime, cinemaLostKind,cinemaLostContent,cinemaLostName,cinemaLostBirth,cinemaLostPH) values (#{cinemaLostDateTime},#{cinemaLostKind},#{cinemaLostContent},#{cinemaLostName},#{cinemaLostBirth},#{cinemaLostPH})")
	int addlostList(serviceCenterDTO dto);

	@Insert("insert into oneToOne(otoKind,otoTitle,otoContent,userId) values(#{otoKind},#{otoTitle},#{otoContent},#{userId})")
	int addOneToOneList(OneToOneDTO dto);

	
	
}
