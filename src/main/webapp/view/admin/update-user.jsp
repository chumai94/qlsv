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
							<h5 class="card-title">Thay đổi người dùng</h5>
							<form class="row g-3"
								action="${pageContext.request.contextPath}/admin/update-user"
								method="post">
								<div class="col-md-6">
									<label class="form-label">Mã</label> <input type="text"
										class="form-control" name="id" value="${users.id}">
								</div>
								<div class="col-md-6">
									<label class="form-label">Tên</label> <input type="text"
										class="form-control" name="ten" value="${users.name}">
								</div>
								<div class="col-md-6">
									<label class="form-label">SDT</label> <input type="text"
										class="form-control" required="required" name="sdt"
										value="${users.phone}">
								</div>
								<div class="col-md-6">
									<label class="form-label">Email</label> <input type="email"
										class="form-control" required="required" name="email"
										value="${users.email}">
								</div>
								<div class="col-md-6">
									<label class="form-label">Địa chỉ</label> <input type="text"
										class="form-control" required="required" name="diachi"
										value="${users.address}">
								</div>
								<div class="col-md-6">
									<label class="form-label">Ngày sinh</label> <input type="date"
										class="form-control" name="ngaysinh"
										value="${users.dateOfBirth}">
								</div>
								<div class="col-md-6">
									<label class="form-label">Ngày bắt đầu</label> <input
										type="date" class="form-control" name="starttime"
										value="${users.startTime}">
								</div>
								<div class="col-md-6">
									<label class="form-label">Ngày kết thúc</label> <input
										type="date" class="form-control" name="endtime"
										value="${users.endTime}">
								</div>
								<div class="col-md-6">
									<label class="form-label">Chức vụ</label> <select id="chucVu"
										name="chucVu" class="form-select">
										<option value="" ${empty users.type ? "selected" : ""}>Chọn...</option>
										<option value="sinhvien"
											${users.type == 'sinhvien' ? "selected" : ""}>Sinh
											Viên</option>
										<option value="giaovien"
											${users.type == 'giaovien' ? "selected" : ""}>Giáo
											Viên</option>
									</select>

								</div>

								<div class="col-md-6">
									<label class="form-label">Loại chức vụ</label> <select
										id="loaiChucVu" name="loaiChucVu" class="form-select">
										<option selected>Chọn...</option>
										<!-- Các options sẽ được cập nhật từ JavaScript -->
									</select>
								</div>
								<div class="col-12">
									<input type="submit" class="btn btn-primary" value="Thêm mới">
									<a href="${pageContext.request.contextPath}/list-user"
										class="btn btn-success">Thoát</a>
								</div>
							</form>

						</div>
					</div>
				</div>

			</div>
		</section>

	</main>
	<script>
		// Lắng nghe sự kiện thay đổi của dropdown "Chức vụ"
		document
				.getElementById("chucVu")
				.addEventListener(
						"change",
						function() {
							var chucVu = this.value; // Lấy giá trị của "Chức vụ"
							var loaiChucVuSelect = document
									.getElementById("loaiChucVu");

							// Xóa tất cả các option trong "Loại chức vụ"
							loaiChucVuSelect.innerHTML = '<option selected>Chọn...</option>';

							// Cập nhật các options trong "Loại chức vụ" dựa trên "Chức vụ"
							if (chucVu === "sinhvien") {
								// Nếu chọn "Sinh Viên"
								var options = [ {
									name : "Liên thông",
									value : "lien_thong"
								}, {
									name : "Chính quy",
									value : "chinh_quy"
								} ];
							} else if (chucVu === "giaovien") {
								// Nếu chọn "Giáo Viên"
								var options = [ {
									name : "Giảng viên",
									value : "giang_vien"
								}, {
									name : "Thỉnh giảng",
									value : "thinh_giang"
								} ];
							} else {
								var options = [];
							}

							// Thêm các option mới vào dropdown "Loại chức vụ"
							options.forEach(function(option) {
								var newOption = document
										.createElement("option");
								newOption.textContent = option.name;
								newOption.value = option.value;
								loaiChucVuSelect.appendChild(newOption);
							});
						});
	</script>

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