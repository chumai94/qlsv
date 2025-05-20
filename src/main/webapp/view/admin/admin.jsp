<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="vi">
<head>
    <%@ include file="layout/head.jsp"%>
    <style>
        .card {
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            transition: all 0.3s ease;
        }

        .card:hover {
            transform: translateY(-10px);
            box-shadow: 0 6px 15px rgba(0, 0, 0, 0.2);
        }

        .card .card-body {
            padding: 20px;
        }

        .card-title {
            font-size: 18px;
            font-weight: bold;
            margin-bottom: 15px;
        }

        .card-icon {
            background-color: #f4f4f4;
            width: 50px;
            height: 50px;
            border-radius: 50%;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .card .d-flex {
            align-items: center;
        }

        .card h6 {
            font-size: 22px;
            font-weight: bold;
        }

        .info-card {
            background-color: #ffffff;
            border-left: 5px solid #5cb85c; /* Green border */
        }

        .revenue-card {
            background-color: #ffffff;
            border-left: 5px solid #f0ad4e; /* Orange border */
        }

        .customers-card {
            background-color: #ffffff;
            border-left: 5px solid #d9534f; /* Red border */
        }

        .main-content {
            padding-top: 20px;
            padding-left: 20px;
            padding-right: 20px;
        }

        .row {
            margin-bottom: 30px; /* Thêm khoảng cách dưới mỗi hàng */
        }
    </style>
</head>
<body>

    <%@ include file="layout/header.jsp"%>

    <div class="container-fluid p-0">
        <div class="row m-0">
            <%@ include file="layout/sidebar.jsp"%>

            <div class="col-md-9 col-lg-9 main-content">
                <div class="content-header">
                    <h2>Danh sách thống kê</h2>
                </div>

                <div class="table-container">
                    <div class="row">
                        <!-- Thống kê học viên Card -->
                        <div class="col-xxl-4 col-md-6 mb-4">
                            <div class="card info-card sales-card">
                                <div class="card-body">
                                    <h5 class="card-title">Học viên <span>| Tổng số</span></h5>
                                    <div class="d-flex align-items-center">
                                        <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                                            <i class="fa-solid fa-person"></i>
                                        </div>
                                        <div class="ps-3">
                                            <h6>${student}</h6>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Thống kê giáo viên Card -->
                        <div class="col-xxl-4 col-md-6 mb-4">
                            <div class="card info-card revenue-card">
                                <div class="card-body">
                                    <h5 class="card-title">Giáo viên <span>| Tổng số</span></h5>
                                    <div class="d-flex align-items-center">
                                        <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                                           <i class="fa-solid fa-person"></i>
                                        </div>
                                        <div class="ps-3">
                                            <h6>${teacher}</h6>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Thống kê lớp học Card -->
                        <div class="col-xxl-4 col-md-6 mb-4">
                            <div class="card info-card customers-card">
                                <div class="card-body">
                                    <h5 class="card-title">Lớp học <span>| Tổng số</span></h5>
                                    <div class="d-flex align-items-center">
                                        <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                                            <i class="fa-solid fa-landmark"></i>
                                        </div>
                                        <div class="ps-3">
                                            <h6>${clazz}</h6>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>
