<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                    <h2>Cập nhật môn học</h2>
                </div>

                <!-- Form cập nhật môn học -->
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Thông tin môn học</h5>
                        <form class="row g-3" action="${pageContext.request.contextPath}/admin/update-monhoc" method="post">
                            <div class="col-md-12">
                                <c:if test="${not empty error}">
                                    <p style="color: red;">${error}</p>
                                </c:if>
                                <input type="hidden" name="id" value="${ss.id}">
                                <label class="form-label">Tên môn học</label>
                                <input type="text" class="form-control" name="ten" value="${ss.name}">
                            </div>
                            <div class="col-md-6">
                                <label class="form-label">Hệ số 1</label>
                                <input type="number" min="0.1" max="0.6" step="0.1" placeholder="Nhập điểm hệ số (0.1 - 0.6)" class="form-control" name="hs1" value="${ss.processCoefficient}">
                            </div>
                            <div class="col-md-6">
                                <label class="form-label">Hệ số 2</label>
                                <input type="number" min="0.1" max="0.6" step="0.1" placeholder="Nhập điểm hệ số (0.1 - 0.6)" class="form-control" name="hs2" value="${ss.examCoefficient}">
                            </div>
                            <div class="col-md-6">
                                <label class="form-label">Giáo viên</label>
                                <select name="teacher" class="form-select">
                                    <c:forEach items="${user}" var="u">
                                        <option value="${u.id}" ${u.id == ss.teacher.id ? 'selected' : ''}>${u.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-md-6">
                                <label class="form-label">Kỳ học</label>
                                <select name="cycle" class="form-select">
                                    <c:forEach items="${cycle}" var="c">
                                        <option value="${c.id}" ${c.id == ss.cycle.id ? 'selected' : ''}>${c.name}</option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="col-12">
                                <input type="submit" class="btn btn-primary" value="Cập nhật">
                                <a href="${pageContext.request.contextPath}/admin/mon-hoc" class="btn btn-secondary">Thoát</a>
                            </div>
                        </form>
                    </div>
                </div>

            </div>
        </div>
    </div>

    <!-- Script & Main JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
    <script src="/view/assets/js/main.js"></script>
</body>
</html>
