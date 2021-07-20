package com.itbank.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class KakaoPayController {

	private ObjectMapper mapper = new ObjectMapper();
	
	@GetMapping("/success")
	public String success() {
		return "cinemaMovie/success";
	}
	
	@GetMapping("/cinemaMovie/kakaoPay")
	public String kakaoPay() throws IOException {
	
		URL url = new URL("https://kapi.kakao.com/v1/payment/ready");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Authorization", "KakaoAK d143e83dc154401c679ffe64cae1e360");
		conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		conn.setDoOutput(true);
		String parameter = "cid=TC0ONETIME&" + "partner_order_id=11111&" + "partner_user_id=gildong11&"
				+ "item_name=랑종&" + "quantity=2&" + "total_amount=28000&" + "tax_free_amount=0&"
				+ "approval_url=http://localhost:8080/cinematown/success&" + "cancel_url=http://localhost:8080/cinematown/cancle&"
				+ "fail_url=http://localhost:8080/cinematown/fail";
		OutputStream out = conn.getOutputStream();
		DataOutputStream dos = new DataOutputStream(out);
		dos.writeBytes(parameter);
		dos.close();

		int result = conn.getResponseCode();

		InputStream input;
		if (result == 200) {
			input = conn.getInputStream();
		} else {
			input = conn.getErrorStream();
		}
		InputStreamReader reader = new InputStreamReader(input);
		BufferedReader buffReader = new BufferedReader(reader);
	
		HashMap<String, String> map = mapper.readValue(buffReader.readLine(), HashMap.class);

		return "redirect:"+map.get("next_redirect_pc_url");
	}
	
}
