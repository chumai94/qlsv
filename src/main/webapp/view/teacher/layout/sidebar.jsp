<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="col-md-3 col-lg-3 sidebar">
	<div class="sidebar-item">
		<a href="${pageContext.request.contextPath}/teacher"
		   class="${activePage == 'home' ? 'active' : ''}">Hồ sơ</a>
	</div>
	<div class="sidebar-item">
		<a href="${pageContext.request.contextPath}/teacher/thongtin-lop"
		   class="${activePage == 'lophoc' ? 'active' : ''}">Lớp học</a>
	</div>

</div>
