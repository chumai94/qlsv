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
					<h2>Thông tin thời gian nhập điểm môn học</h2>
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
								<th>Tên môn</th>
								<th>Ngày bắt đầu</th>
								<th>Ngày kết thúc</th>
								<th>Thao tác</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>${ss.name }</td>

								<c:choose>
									<c:when test="${not empty ss.startDate}">
										<td>${ss.startDate}</td>
									</c:when>
									<c:otherwise>
										<td class="text-success">Chưa xét thời gian</td>
									</c:otherwise>
								</c:choose>


								<c:choose>
									<c:when test="${not empty ss.endDate}">
										<td>${ss.endDate}</td>
									</c:when>
									<c:otherwise>
										<td class="text-success">Chưa xét thời gian</td>
									</c:otherwise>
								</c:choose>

								<td>
									<div class="action-icons">
										<c:choose>
                                                <c:when test="${not empty ss.startDate and not empty ss.endDate}">
                                                    <a class="text-success" href="${pageContext.request.contextPath}/admin/update-score-time?id=${ss.id}&nbd=${ss.startDate}&nkt=${ss.endDate}">
                                                        <i class="fa-regular fa-pen-to-square"></i>
                                                    </a>
                                                </c:when>
                                                <c:otherwise>
                                                    <a class="text-success" href="${pageContext.request.contextPath}/admin/add-score-time?id=${ss.id}">
                                                        <i class="fa-solid fa-plus"></i>
                                                    </a>
                                                </c:otherwise>
                                            </c:choose>
                                        <a
                                        href="${pageContext.request.contextPath}/admin/delete-score-time?id=${ss.id}" class="text-danger"
                                        onclick="return confirm('Bạn có chắc chắn muốn xóa thời gian này không');">
                                        <i class="fa-solid fa-trash"></i>
                                        </a>
									</div>

								</td>
							</tr>

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
