package com.itbank.model;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface CinemaPaymentDAO {
	
	@Insert("insert into cinemaPayment(ticketing_idx, userId, totalAmount) values(#{ticketing_idx}, #{userId}, #{totalAmount})")
	void payment(@Param("ticketing_idx")int ticketing_idx, @Param("userId")String userId, @Param("totalAmount")int totalAmount);

	@Select("select max(payment_idx) from cinemaPayment")
	int getPayment_idx();
	
	// 예매 취소 시 결제 취소 
	int paymentCancel(@Param("ticketing_idx")int ticketing_idx);

	@Select("select PAYMENT_IDX from cinemaPayment where ticketing_idx = #{ticketing_idx}")
	int getPayment_idxCancel(int ticketing_idx);
}
