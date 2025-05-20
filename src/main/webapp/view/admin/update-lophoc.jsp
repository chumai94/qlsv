<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="vi">
<%@ include file="layout/head.jsp"%>
<body>

	<%@ include file="layout/header.jsp"%>
	<div class="container-fluid p-0">
		<div class="row m-0">
			<%@ include file="layout/sidebar.jsp"%>

			<div class="col-md-9 col-lg-9 main-content">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Thay đổi lớp học</h5>
						<form class="row g-3" action="${pageContext.request.contextPath}/admin/update-lophoc" method="post">
							<div class="col-md-6">
								<c:if test="${not empty error}">
									<p style="color: red;">${error}</p>
								</c:if>
								<input type="hidden" name="id" value="${cl.id}">
								<label class="form-label">Tên lớp</label>
								<input type="text" class="form-control" name="ten" value="${cl.name}">
							</div>
							<div class="col-md-6">
								<label class="form-label">Giáo viên</label>
								<select name="teacher" class="form-select">
									<option value="" selected>Chọn...</option>
									<c:forEach items="${user}" var="u">
										<option value="${u.id}" ${u.id == cl.teacher.id ? 'selected' : ''}>${u.name}</option>
									</c:forEach>
								</select>
							</div>
							<div class="col-12">
								<input type="submit" class="btn btn-primary" value="Cập nhật">
								<a href="${pageContext.request.contextPath}/admin/lop-hoc" class="btn btn-secondary">Thoát</a>
							</div>
						</form>
					</div>
				</div>

			</div>
		</div>
	</div>

	<!-- JS Vendor Files -->
	<script src="/view/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="/view/assets/js/main.js"></script>

</body>
</html>
