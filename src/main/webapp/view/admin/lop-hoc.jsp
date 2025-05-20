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
					<h2>Danh sách lớp học</h2>
				</div>

				<div class="search-container">
                	<form method="get" action="${pageContext.request.contextPath}/admin/lop-hoc">
                		<input type="text" name="keyword" class="search-input"
                			placeholder="Tìm kiếm theo tên lớp..." value="${keyword}">
                		<button type="submit" class="btn-search">Tìm</button>
                		<a href="${pageContext.request.contextPath}/admin/add-lophoc" class="btn btn-success">Thêm mới</a>
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
								<th>Tên lớp</th>
								<th>Giảng viên</th>
								<th>Trạng thái</th>
								<th>Thao tác</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${requestScope.cl}" var="cl" varStatus="status">
								<tr>
									<td>${status.index + 1}</td>
									<td>${cl.name}</td>
									<td>${empty cl.teacher.name ? 'chưa phân công' : cl.teacher.name}</td>
									<c:choose>
										<c:when test="${cl.status}">
											<td class="text-danger">Đã khóa</td>
										</c:when>
										<c:otherwise>
											<td class="text-success">Đang hoạt động</td>
										</c:otherwise>
									</c:choose>
									<td>
										<div class="action-icons">

											<a class="text-success"
												href="${pageContext.request.contextPath}/admin/lop-student?id=${cl.id}">
												<i class="fa-solid fa-table"></i>
											</a>
											<a
												href="${pageContext.request.contextPath}/admin/update-lophoc?id=${cl.id}"
												class="text-success"> <i
												class="fa-regular fa-pen-to-square"></i>
											</a>

											<c:choose>
												<c:when test="${cl.status}">
													<!-- Đang khóa -> mở khóa -->
													<a
														href="${pageContext.request.contextPath}/admin/unlock-lophoc?id=${cl.id}"
														class="text-success"
														onclick="return confirm('Bạn có chắc chắn muốn mở khóa lớp học: ${cl.name}?');">
														<i class="fa-solid fa-lock-open"></i>
													</a>
												</c:when>
												<c:otherwise>
													<!-- Đang hoạt động -> khóa -->
													<a
														href="${pageContext.request.contextPath}/admin/lock-lophoc?id=${cl.id}"
														class="text-danger"
														onclick="return confirm('Bạn có chắc chắn muốn khóa lớp học: ${cl.name}?');">
														<i class="fa-solid fa-lock"></i>
													</a>
												</c:otherwise>
											</c:choose>

													<a
														href="${pageContext.request.contextPath}/admin/delete-lophoc?id=${cl.id}"
														class="text-danger"
														onclick="return confirm('Bạn có chắc chắn muốn xóa lớp học: ${cl.name}?');">
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
	</script>


</body>
</html>
