<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp"%>
<link rel="stylesheet" href="${cpath }/resources/cinemaUser/myPage/myPageHome.css">

<body>
	<div class="main">
		<div class="peopleInfo">
			<div class="peopleImg">
				<img src="https://media.discordapp.net/attachments/856752011814895645/867672165084299264/myPageImg1.png" width="100px"
					height="100px"></a>
			</div>
			<!--for문 해주세요-->
<%-- 			<c:forEach var="dto" items="${list }"> --%>
			<div class="info">
				<table>
					<tbody>
						<tr>
							<th class="name">${dto.userName }</th>
						</tr>
						<tr>
							<td>User ID</td>
							<td>${dto.userId }</td>
						</tr>
						<tr>
							<td>생년월일</td>
							<td>${dto.userBirth }</td>
						</tr>
						<tr>
							<td>PHONE</td>
							<td>${dto.userPh }</td>
						</tr>
						<tr>
							<td>EMAIL</td>
							<td>${dto.userEmail }</td>
						</tr>
					</tbody>
				</table>
			</div>
<%-- 			</c:forEach> --%>
		</div>
		<div class="goLink">
			<div class="ticketList">
				<a href=""><img
					src="https://media.discordapp.net/attachments/856752011814895645/867672253185392640/myPageTicket.png"
					width="140px" height="80px"></a>
			</div>
			<div class="aear"></div>
			<div class="inquireList">
				<a href=""><img
					src="https://media.discordapp.net/attachments/856752011814895645/867672243009355786/myPageInquiry.png"
					width="140px" height="80px"></a>
			</div>
			<div class="bear"></div>
			<div class="myInfoModify">
				<a href="${cpath }/cinemaUser/myPage/infoModify"><img
					src="https://media.discordapp.net/attachments/856752011814895645/867672225221050378/myPageModify.png"
					width="140px" height="80px"></a>
			</div>
		</div>
	</div>
<%@ include file="../../footer.jsp"%>