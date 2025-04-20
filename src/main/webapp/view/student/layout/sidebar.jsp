<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<aside id="sidebar" class="sidebar">

	<ul class="sidebar-nav" id="sidebar-nav">

		<li class="nav-item"><a class="nav-link " href="index.html">
				<i class="bi bi-grid"></i> <span>Dashboard</span>
		</a></li>
		<!-- End Dashboard Nav -->

		<li class=""><a class="nav-link collapsed"
			href="${pageContext.request.contextPath}/list-user"> <i
				class="bi bi-menu-button-wide"></i><span>Quản lý giáo viên</span>
		</a></li>
		<!-- End Components Nav -->

		<li class=""><a class="nav-link collapsed"
			href="${pageContext.request.contextPath}/admin/sinhvien"> <i
				class="bi bi-journal-text"></i><span>Quản lý sinh viên</span>
		</a></li>
		<!-- End Forms Nav -->
		<li class=""><a class="nav-link collapsed"
			href="${pageContext.request.contextPath}/admin/mon-hoc"> <i
				class="bi bi-journal-text"></i><span>Quản lý môn học</span>
		</a></li>
		<li class=""><a class="nav-link collapsed"
			href="${pageContext.request.contextPath}/admin/lop-hoc"> <i
				class="bi bi-journal-text"></i><span>Quản lý lớp học</span>
		</a></li>
	</ul>

</aside>
<!-- End Sidebar-->