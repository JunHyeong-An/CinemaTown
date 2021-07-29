package com.itbank.model;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface CinemaSalesDAO {

	@Insert("insert into cinemaSales(payment_idx,movieName,price) values(#{payment_idx},(select movieName from cinemaSchedule where schedule_idx=#{schedule_idx}) ,#{price})")
	int sales(@Param("payment_idx")int payment_idx, @Param("schedule_idx")int schedule_idx, @Param("price")int totalAmount);
	
	@Update("update cinemaSales set price = 0 where payment_idx = #{payment_idx}")
	void salesCancel(int payment_idx);
}
