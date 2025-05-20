
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="col-md-3 col-lg-3 sidebar">
	<div class="sidebar-item">
		<a href="${pageContext.request.contextPath}/student"
		   class="${activePage == 'home' ? 'active' : ''}">Hồ sơ</a>
	</div>
	<div class="sidebar-item">
		<a href="${pageContext.request.contextPath}/student/student-score"
		class="${activePage == 'tongdiem' ? 'active' : ''}">Kết quả học tập</a>
	</div>

</div>
