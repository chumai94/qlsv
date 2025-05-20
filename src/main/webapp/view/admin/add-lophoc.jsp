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
				<div class="content-header">
					<h2>Thêm mới lớp học</h2>
				</div>

				<!-- Thông báo nếu có -->
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Thông tin lớp học</h5>

						<form class="row g-3"
							  action="${pageContext.request.contextPath}/admin/add-lophoc"
							  method="post">

							<div class="col-md-6">
								<c:if test="${not empty error}">
									<p style="color: red;">${error}</p>
								</c:if>
								<label class="form-label">Tên lớp</label>
								<input type="text" class="form-control" name="ten" required>
							</div>

							<div class="col-md-6">
								<label class="form-label">Giáo viên</label>
								<select name="teacher" class="form-select" required>
									<option value="" selected>Chọn...</option>
									<c:forEach items="${user}" var="u">
										<option value="${u.id}">${u.name}</option>
									</c:forEach>
								</select>
							</div>

							<div class="col-12 mt-3">
								<input type="submit" class="btn btn-primary" value="Thêm mới">
								<a href="${pageContext.request.contextPath}/admin/lop-hoc" class="btn btn-success">Thoát</a>
							</div>
						</form>

					</div>
				</div>

			</div>
		</div>
	</div>

	<!-- JS & Bootstrap -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
