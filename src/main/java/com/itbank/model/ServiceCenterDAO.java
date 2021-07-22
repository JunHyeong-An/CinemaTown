package com.itbank.model;

import org.apache.ibatis.annotations.Insert;

public interface ServiceCenterDAO {

	@Insert("insert into cinemaLost(cinemaLostDateTime, cinemaLostKind,cinemaLostContent,cinemaLostName,cinemaLostBirth,cinemaLostPH) values (#{cinemaLostDateTime},#{cinemaLostKind},#{cinemaLostContent},#{cinemaLostName},#{cinemaLostBirth},#{cinemaLostPH})")
	int addlostList(ServiceCenterDTO dto);

	@Insert("insert into oneToOne(otoKind,otoTitle,otoContent,userId) values(#{otoKind},#{otoTitle},#{otoContent},#{userId})")
	int addOneToOneList(OneToOneDTO dto);

	
	
}
