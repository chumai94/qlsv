<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
					<h2>Danh sách môn học</h2>
				</div>

				<div class="search-container">
					<form method="get"
						action="${pageContext.request.contextPath}/admin/mon-hoc">
						<input type="text" name="keyword" class="search-input"
							placeholder="Tìm kiếm theo tên môn học..." value="${keyword}">
						<button type="submit" class="btn-search">Tìm</button>
						<a href="${pageContext.request.contextPath}/admin/add-monhoc"
							class="btn btn-success">Thêm mới</a>
					</form>
				</div>
				<c:if test="${not empty sessionScope.successMessage}">
					<div class="alert alert-success alert-dismissible fade show"
						role="alert">
						<strong>✅</strong> ${sessionScope.successMessage}
						<button type="button" class="btn-close" data-bs-dismiss="alert"
							aria-label="Close"></button>
					</div>
					<c:remove var="successMessage" scope="session" />
				</c:if>
				<div class="table-container">
					<table class="table">
						<thead>
							<tr>
								<th>STT</th>
								<th>Tên môn</th>
								<th>Học kỳ</th>
								<th>Giảng viên</th>
								<th>Hệ số chuyên cần</th>
								<th>Hệ số thi</th>
								<th>Trạng thái</th>
								<th>Thao tác</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${requestScope.subject}" var="subject"
								varStatus="status">
								<tr>
									<td>${status.index + 1}</td>
									<td>${subject.name}</td>
									<td>${empty subject.cycle.name ? 'chưa phân công' : subject.cycle.name}</td>
									<td>${empty subject.teacher.name ? 'chưa phân công' : subject.teacher.name}</td>
									<td>${subject.processCoefficient}</td>
									<td>${subject.examCoefficient}</td>
									<c:choose>
										<c:when test="${subject.status}">
											<td class="text-danger">Đã kết thúc</td>
										</c:when>
										<c:otherwise>
											<td class="text-success">Đang hoạt động</td>
										</c:otherwise>
									</c:choose>
									<td>
										<div class="action-icons">
											<a class="text-success"
												href="${pageContext.request.contextPath}/admin/score-time?id=${subject.id}">
												<i class="fa-solid fa-table"></i>
											</a> <a
												href="${pageContext.request.contextPath}/admin/update-monhoc?id=${subject.id}"
												class="text-success"> <i
												class="fa-regular fa-pen-to-square"></i>
											</a>

											<c:choose>
												<c:when test="${subject.status}">

													<a
														href="${pageContext.request.contextPath}/admin/unlock-subject?id=${subject.id}"
														class="text-danger"
														onclick="return confirm('Bạn có chắc chắn muốn mở khóa môn học: ${subject.name}?');">
														<i class="fa-solid fa-lock"></i>
													</a>
												</c:when>
												<c:otherwise>

													<a
														href="${pageContext.request.contextPath}/admin/lock-subject?id=${subject.id}"
														class="text-success"
														onclick="return confirm('Bạn có chắc chắn muốn khóa môn học: ${subject.name}?');">
														<i class="fa-solid fa-lock-open"></i>
													</a>
												</c:otherwise>
											</c:choose>


											<a
												href="${pageContext.request.contextPath}/admin/delete-subject?id=${subject.id}"
												class="text-danger"
												onclick="return confirm('Bạn có chắc chắn muốn xóa môn học: ${subject.name}?');">
												<i class="fa-solid fa-trash"></i>
											</a>
										</div>

									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>
