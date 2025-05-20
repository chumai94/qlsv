<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="vi">
<%@ include file="layout/head.jsp"%>
<body>

	<%@ include file="layout/header.jsp"%>

	<div class="container-fluid p-0">
		<div class="row m-0">
			<%@ include file="layout/sidebar.jsp"%>

			<div class="col-md-9 col-lg-9 main-content">
				<div class="content-header">
					<h2>Cập nhật người dùng</h2>
				</div>
				<div class="card">
					<div class="card-body">
						<form class="row g-3"
							action="${pageContext.request.contextPath}/admin/update-user"
							method="post">
							<div class="col-md-6">
								<label class="form-label">Mã</label> <input type="text"
									class="form-control" name="id" value="${users.id}" readonly>
							</div>
							<div class="col-md-6">
								<label class="form-label">Tên</label> <input type="text"
									class="form-control" name="ten" value="${users.name}">
							</div>
							<div class="col-md-6">
								<label class="form-label">SDT</label> <input type="text"
									class="form-control" pattern="^0\d{9}$" title="Số điện thoại phải bắt đầu bằng 0 và có 10 chữ số." name="sdt" required value="${users.phone}">
							</div>
							<div class="col-md-6">
								<label class="form-label">Email</label> <input type="email"
									class="form-control" name="email" required
									value="${users.email}">
							</div>
							<div class="col-md-6">
								<label class="form-label">Địa chỉ</label> <input type="text"
									class="form-control" name="diachi" required
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
										viên</option>
									<option value="giaovien"
										${users.type == 'giaovien' ? "selected" : ""}>Giáo
										viên</option>
								</select>
							</div>
							<div class="col-md-6">
								<label class="form-label">Loại chức vụ</label> <select
									id="loaiChucVu" name="loaiChucVu" class="form-select">
									<option value="">Chọn...</option>

									<c:choose>
										<c:when test="${users.type == 'sinhvien'}">
											<option value="lien_thong"
												${users.typePosition == 'lien_thong' ? 'selected' : ''}>Liên
												thông</option>
											<option value="chinh_quy"
												${users.typePosition == 'chinh_quy' ? 'selected' : ''}>Chính
												quy</option>
										</c:when>
										<c:when test="${users.type == 'giaovien'}">
											<option value="giang_vien"
												${users.typePosition == 'giang_vien' ? 'selected' : ''}>Giảng
												viên</option>
											<option value="thinh_giang"
												${users.typePosition == 'thinh_giang' ? 'selected' : ''}>Thỉnh
												giảng</option>
										</c:when>
									</c:choose>
								</select>
							</div>
							<div class="col-12">
								<input type="submit" class="btn btn-primary"
									value="Lưu thay đổi">
								<c:choose>
									<c:when test="${users.type == 'sinhvien'}">
										<a href="${pageContext.request.contextPath}/admin/sinhvien"
											class="btn btn-success">Thoát</a>
									</c:when>
									<c:when test="${users.type == 'giaovien'}">
										<a href="${pageContext.request.contextPath}/admin/list-user"
											class="btn btn-success">Thoát</a>
									</c:when>
								</c:choose>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap Bundle -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
