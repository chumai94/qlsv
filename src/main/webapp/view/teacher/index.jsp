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
							<h5 class="card-title">Danh sách giáo viên</h5>
							<div></div>
							<table class="table">
								

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