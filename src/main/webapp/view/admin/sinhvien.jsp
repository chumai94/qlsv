<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<%@ include file="layout/head.jsp"%>


<body>

	<%@ include file="layout/header.jsp"%>
	<%@ include file="layout/sidebar.jsp"%>

	<main id="main" class="main">

		<section class="section">
			<div class="row">
				<div class="col-lg-12">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Danh sách sinh viên</h5>
							<div>
								<form>
									<div class="row ">
										<div class="form-group col-md-6">
											<label for="inputEmail4">Mã/Tên/Tài khoản GV</label> <input
												type="email" class="form-control" id="inputEmail4"
												placeholder="Email">
										</div>
										<div class="col-md-1"></div>
										<div class="form-group col-md-5">
											<label for="inputPassword4">Bộ môn</label> <select
												class="form-select" aria-label="Default select example">
												<option selected>Open this select menu</option>
												<option value="1">One</option>
												<option value="2">Two</option>
												<option value="3">Three</option>
											</select>
										</div>
									</div>
									<div class="row mt-2">
										<div class="form-group col-md-5">
											<label for="inputEmail4">Chức vụ</label> <select
												class="form-select" aria-label="Default select example">
												<option selected>Open this select menu</option>
												<option value="1">One</option>
												<option value="2">Two</option>
												<option value="3">Three</option>
											</select>


										</div>
										<div class="col-md-2 text-center">
											<button type="submit" class="btn btn-primary"
												style="margin-top: 23px;">Sign in</button>
										</div>
										<div class="form-group col-md-5">
											<label for="inputPassword4">Trạng thái tài khoản</label> <select
												class="form-select" size="3"
												aria-label="size 3 select example">
												<option selected>Tất cả</option>
												<option value="1">One</option>
												<option value="2">Two</option>
											</select>
										</div>
										<div class="form-group col-md-5 row">
											<div class="col-md-4" style="margin-top: -60px;">
												<a
													href="${pageContext.request.contextPath}/admin/add-sinhvien"
													class="btn btn-primary mt-5 ">Thêm mới</a>
											</div>
											<div class="col-md-4" style="margin-top: -60px;">
												<button type="submit" class="btn btn-primary mt-5 ">Sign
													in</button>
											</div>
											<div class="col-md-4" style="margin-top: -60px;">
												<button type="submit" class="btn btn-primary mt-5 ">Sign
													in</button>
											</div>
										</div>
									</div>

								</form>
							</div>
							<table class="table">
								<thead>
									<tr>
										<th>STT</th>
										<th>Tên</th>
										<th>SĐT</th>
										<th>Email</th>
										<th>Địa chỉ</th>
										<th>Ngày sinh</th>
										<th>Chức vụ</th>
										<th>Vị trí</th>
										<th>Created At</th>
										<th>Last Modified</th>
										<th>khóa tk</th>
										<th>xóa tk</th>
										<th>Thao tác</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${requestScope.usersList}" var="user">
										<tr>

											<td>${user.id}</td>
											<td>${user.name}</td>
											<td>${user.phone}</td>
											<td>${user.email}</td>
											<td>${user.address}</td>
											<td>${user.dateOfBirth}</td>
											<td>${user.type}</td>
											<td>${user.typePosition}</td>
											<td>${user.createAt}</td>
											<td>${user.lastmodified}</td>
											<c:choose>
												<c:when test="${user.lockStatus}">
													<td>da khoa</td>
												</c:when>
												<c:otherwise>
													<td>mo khoa</td>
												</c:otherwise>
											</c:choose>
											<c:choose>
												<c:when test="${user.deleted}">
													<td>da xoa</td>
												</c:when>
												<c:otherwise>
													<td>dag hd</td>
												</c:otherwise>
											</c:choose>
											<td><a
												href="${pageContext.request.contextPath}/admin/update-user?id=${user.id}"
												class="text-success"><i
													class="fa-regular fa-pen-to-square"></i></a> <a
												href="${pageContext.request.contextPath}/admin/delete-user?id=${user.id}"
												class="text-danger"><i class="fa-solid fa-trash"></i></a> <c:choose>
													<c:when test="${user.lockStatus}">
														<a
															href="${pageContext.request.contextPath}/admin/unlock-user?id=${user.id}"
															class="text-danger"><i class="fa-solid fa-lock"></i></a>
													</c:when>
													<c:otherwise>
														<a
															href="${pageContext.request.contextPath}/admin/lock-user?id=${user.id}"
															class="text-success"><i class="fa-solid fa-lock-open"></i></a>
													</c:otherwise>
												</c:choose></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>

							<!-- End Default Table Example -->
							<div class="">
								<nav aria-label="Page navigation example text-end">
									<ul class="pagination">
										<li class="page-item"><a class="page-link" href="#"
											aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
												<span class="sr-only">Previous</span>
										</a></li>
										<li class="page-item"><a class="page-link" href="#">1</a></li>
										<li class="page-item"><a class="page-link" href="#">2</a></li>
										<li class="page-item"><a class="page-link" href="#">3</a></li>
										<li class="page-item"><a class="page-link" href="#"
											aria-label="Next"> <span aria-hidden="true">&raquo;</span>
												<span class="sr-only">Next</span>
										</a></li>
									</ul>
								</nav>
							</div>
						</div>
					</div>
				</div>

			</div>
		</section>

	</main>
	<!-- End #main -->

	<a href="#"
		class="back-to-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a>

	<!-- Vendor JS Files -->
	<script src="/view/assets/vendor/apexcharts/apexcharts.min.js"></script>
	<script src="/view/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="/view/assets/vendor/chart.js/chart.min.js"></script>
	<script src="/view/assets/vendor/echarts/echarts.min.js"></script>
	<script src="/view/assets/vendor/quill/quill.min.js"></script>
	<script
		src="/view/assets/vendor/simple-datatables/simple-datatables.js"></script>
	<script src="/view/assets/vendor/tinymce/tinymce.min.js"></script>
	<script src="/view/assets/vendor/php-email-form/validate.js"></script>

	<!-- Template Main JS File -->
	<script src="/view/assets/js/main.js"></script>

</body>

</html>