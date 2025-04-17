<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<aside id="sidebar" class="sidebar">
    <ul class="sidebar-nav" id="sidebar-nav">

        <li class="nav-item">
            <a class="nav-link new-class" href="${pageContext.request.contextPath}/teacher">
                <i class="bi bi-grid"></i>
                <span>Tổng quan</span>
            </a>
        </li><!-- End Dashboard Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed new-class" href="${pageContext.request.contextPath}/teacher/lop-hoc">
                <i class="bi bi-person"></i>
                <span>Lớp học</span>
            </a>
        </li><!-- End Components Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed new-class" href="${pageContext.request.contextPath}/teacher/mon-hoc">
                <i class="bi bi-book"></i>
                <span>Môn dạy</span>
            </a>
        </li><!-- End Forms Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed new-class" href="">
                <i class="bi bi-pencil-square"></i>
                <span>Quản lý điểm</span>
            </a>
        </li><!-- End Forms Nav -->

    </ul>
</aside>