<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="col-md-3 col-lg-3 sidebar">
    <div class="sidebar-item">
        <a href="${pageContext.request.contextPath}/admin" class="${activePage == 'home' ? 'active' : ''}">Trang chủ</a>
    </div>
    <div class="sidebar-item">
            <a href="${pageContext.request.contextPath}/admin/profile" class="${activePage == 'hoso' ? 'active' : ''}">Hồ sơ</a>
    </div>
    <div class="sidebar-item">
        <a href="${pageContext.request.contextPath}/admin/list-user" class="${activePage == 'giaovien' ? 'active' : ''}">Quản lý giáo viên</a>
    </div>
    <div class="sidebar-item">
        <a href="${pageContext.request.contextPath}/admin/sinhvien" class="${activePage == 'sinhvien' ? 'active' : ''}">Quản lý sinh viên</a>
    </div>
    <div class="sidebar-item">
        <a href="${pageContext.request.contextPath}/admin/lop-hoc" class="${activePage == 'lophoc' ? 'active' : ''}">Quản lý lớp học</a>
    </div>
    <div class="sidebar-item">
        <a href="${pageContext.request.contextPath}/admin/mon-hoc" class="${activePage == 'monhoc' ? 'active' : ''}">Quản lý môn học</a>
    </div>
    <div class="sidebar-item">
            <a href="${pageContext.request.contextPath}/admin/thong-ke" class="${activePage == 'thongke' ? 'active' : ''}">Thống kê</a>
    </div>
</div>

