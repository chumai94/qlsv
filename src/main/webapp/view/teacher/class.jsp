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
							<h5 class="card-title">Danh sách lớp học</h5>
							<div>
								<form>
									<div class="row align-items-end">
										<div class="form-group col-md-6">
											<label for="inputEmail4">Mã/Tên/ca dạy</label> <input
												type="text" class="form-control" id="inputEmail4"
												placeholder="Nhập thông tin">
										</div>
										<div class="form-group col-md-1 p-0">
											<label>&nbsp;</label>
											<button type="submit" class="btn btn-success"
												style="margin-left: -20px; height: 37px; width: 47px;">
												<i class="fa-solid fa-magnifying-glass"></i>
											</button>
										</div>
										<div class="form-group col-md-5">
											<label for="inputPassword4">Bộ môn</label> <select
												class="form-select" aria-label="Default select example">
												<option selected>Chọn bộ môn</option>
												<option value="1">One</option>
												<option value="2">Two</option>
												<option value="3">Three</option>
											</select>
										</div>
									</div>

								</form>
							</div>
							<table class="table">
								<thead>
									<tr>
										<th>Mã lớp</th>
										<th>Tên lớp</th>
										<th>Ngày dạy</th>
										<th>Ca dạy</th>
										<th>Trạng thái</th>
										<th>Thao tác</th>
									</tr>
								</thead>
								<c:forEach items="${requestScope.classes}" var="c">
									<tr>
										<td>${c.id}</td>
										<td>${c.name}</td>
										<td>${c.startDate}</td>
										<td>${c.shift}</td>
										<c:choose>
											<c:when test="${c.status}">
												<td class="text-danger">Đã kết thúc</td>
											</c:when>
											<c:otherwise>
												<td class="text-success">Đang hoạt động</td>
											</c:otherwise>
										</c:choose>
										<td>
											<button type="button" class="btn btn-primary"
												data-bs-toggle="modal" data-bs-target="#myModal"
												data-id="${c.id}" data-name="${c.name}"
												data-startDate="${c.startDate}"
												data-shift="${c.shift}"
												data-description="${c.description}"
												data-createat="${c.createdAt}"
												data-lastmodified="${c.lastModified}"
												data-status="${c.status ? 'Đã kết thúc' : 'Đang hoạt động'}">
												Chi tiết</button>
										</td>
									</tr>
								</c:forEach>
							</table>
							<div class="modal fade" id="myModal" tabindex="-1"
								aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">

										<div class="modal-header">
											<h5 class="modal-title" id="myModalLabel">Thông tin lớp
												học</h5>
											<button type="button" class="btn-close"
												data-bs-dismiss="modal" aria-label="Đóng"></button>
										</div>

										<div class="modal-body">
											<p>
												<strong>Mã lớp:</strong> <span id="modal-subject-id"></span>
											</p>
											<p>
												<strong>Tên lớp:</strong> <span id="modal-subject-name"></span>
											</p>
											<p>
												<strong>Ngày dạy:</strong> <span id="modal-subject-start"></span>
											</p>
											<p>
												<strong>Ca dạy:</strong> <span id="modal-subject-shift"></span>
											</p>
											<p>
												<strong>Mô tả:</strong> <span id="modal-subject-description"></span>
											</p>
											<p>
												<strong>Ngày tạo:</strong> <span id="modal-subject-create"></span>
											</p>
											<p>
												<strong>Ngày cập nhật cuối:</strong> <span
													id="modal-subject-last"></span>
											</p>
											<p>
												<strong>Trạng thái:</strong> <span id="modal-subject-status"></span>
											</p>
										</div>

										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-bs-dismiss="modal">Đóng</button>
										</div>

									</div>
								</div>
							</div>

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
	<script src="https://cdn.jsdelivr.net/npm/dayjs@1.10.7/dayjs.min.js"></script>
	<script>
		document
				.addEventListener(
						'DOMContentLoaded',
						function() {
							var myModal = new bootstrap.Modal(document
									.getElementById('myModal'));

							var myModalElement = document
									.getElementById('myModal');
							myModalElement
									.addEventListener(
											'shown.bs.modal',
											function(event) {
												var button = event.relatedTarget; // nút vừa click
												var id = button
														.getAttribute('data-id');
												var name = button
														.getAttribute('data-name');
												var startDate = button
														.getAttribute('data-startDate');
												var shift = button
														.getAttribute('data-shift');
												var description = button
														.getAttribute('data-description');
												var createAt = button
														.getAttribute('data-createat');
												var last = button
														.getAttribute('data-lastmodified');
												var status = button
														.getAttribute('data-status');
												var start = dayjs(startDate)
														.format('DD/MM/YYYY');
												var create = dayjs(createAt)
														.format('DD/MM/YYYY');
												var lastmodified = dayjs(last)
														.format('DD/MM/YYYY');

												document
														.getElementById('modal-subject-id').textContent = id;
												document
														.getElementById('modal-subject-name').textContent = name;
												document
														.getElementById('modal-subject-start').textContent = start;
												document
														.getElementById('modal-subject-shift').textContent = shift;
												document
														.getElementById('modal-subject-description').textContent = description;
												document
														.getElementById('modal-subject-create').textContent = create;
												document
														.getElementById('modal-subject-last').textContent = lastmodified;
												document
														.getElementById('modal-subject-status').textContent = status;
											});
						});
	</script>
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