<%@taglib uri="http" prefix="c" %>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="/viewport">
  <title>Dashboard - NiceAdmin Bootstrap Template</title>
  <meta content="" name="description">
  <meta content="" name="keywords">
  <link href="/view/assets/img/favicon.png" rel="icon">
  <link href="/view/assets/img/apple-touch-icon.png" rel="apple-touch-icon">
  <link href="https://fonts.gstatic.com" rel="preconnect">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
  <link href="/view/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="/view/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="/view/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="/view/assets/vendor/quill/quill.snow.css" rel="stylesheet">
  <link href="/view/assets/vendor/quill/quill.bubble.css" rel="stylesheet">
  <link href="/view/assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="/view/assets/vendor/simple-datatables/style.css" rel="stylesheet">
  <link href="/view/assets/css/style.css" rel="stylesheet">
</head>

<body>

  <header id="header" class="header fixed-top d-flex align-items-center">

    <div class="d-flex align-items-center justify-content-between">
      <a href="index.html" class="logo d-flex align-items-center">
        <img src="/view/assets/img/logo.png" alt="">
        <span class="d-none d-lg-block">Ticket Admin</span>
      </a>
      <i class="bi bi-list toggle-sidebar-btn"></i>
    </div><!-- End Logo -->

    

    <nav class="header-nav ms-auto">
      <ul class="d-flex align-items-center">

        <li class="nav-item d-block d-lg-none">
          <a class="nav-link nav-icon search-bar-toggle " href="#">
            <i class="bi bi-search"></i>
          </a>
        </li><!-- End Search Icon-->

        <li class="nav-item dropdown">

          <a class="nav-link nav-icon" href="#" data-bs-toggle="dropdown">
            <i class="bi bi-bell"></i>
            <span class="badge bg-primary badge-number"></span>
          </a><!-- End Notification Icon -->

        </li><!-- End Notification Nav -->

        <li class="nav-item dropdown">

          <a class="nav-link nav-icon" href="#" data-bs-toggle="dropdown">
            <i class="bi bi-chat-left-text"></i>
            <span class="badge bg-success badge-number"></span>
          </a><!-- End Messages Icon -->

        </li><!-- End Messages Nav -->

        <li class="nav-item dropdown pe-3">

          <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown">
            <img src="/view/assets/img/profile-img.jpg" alt="Profile" class="rounded-circle">
            <span class="d-none d-md-block dropdown-toggle ps-2">K. Anderson</span>
          </a><!-- End Profile Iamge Icon -->

          <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
            <li class="dropdown-header">
              <h6>Kevin Anderson</h6>
              <span>Web Designer</span>
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>

            <li>
              <a class="dropdown-item d-flex align-items-center" href="users-profile.html">
                <i class="bi bi-person"></i>
                <span>My Profile</span>
              </a>
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>

            <li>
              <a class="dropdown-item d-flex align-items-center" href="users-profile.html">
                <i class="bi bi-gear"></i>
                <span>Account Settings</span>
              </a>
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>

            <li>
              <a class="dropdown-item d-flex align-items-center" href="pages-faq.html">
                <i class="bi bi-question-circle"></i>
                <span>Need Help?</span>
              </a>
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>

            <li>
              <a class="dropdown-item d-flex align-items-center" href="#">
                <i class="bi bi-box-arrow-right"></i>
                <span>Sign Out</span>
              </a>
            </li>

          </ul><!-- End Profile Dropdown Items -->
        </li><!-- End Profile Nav -->

      </ul>
    </nav><!-- End Icons Navigation -->

  </header><!-- End Header -->

  <!-- ======= Sidebar ======= -->
  <aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">

      <li class="nav-item">
        <a class="nav-link " href="index.html">
          <i class="bi bi-grid"></i>
          <span>Dashboard</span>
        </a>
      </li><!-- End Dashboard Nav -->

      <li class="nav-item">
        <a class="nav-link collapsed" data-bs-target="#components-nav" data-bs-toggle="collapse" href="#">
          <i class="bi bi-menu-button-wide"></i><span>Rap</span>
        </a>
      </li><!-- End Components Nav -->

      <li class="nav-item">
        <a class="nav-link collapsed" data-bs-target="#forms-nav" data-bs-toggle="collapse" href="#">
          <i class="bi bi-journal-text"></i><span>Loai phong</span><i class="bi bi-chevron-down ms-auto"></i>
        </a>
      </li><!-- End Forms Nav -->

      <li class="nav-item">
        <a class="nav-link collapsed" data-bs-target="#tables-nav" data-bs-toggle="collapse" href="#">
          <i class="bi bi-layout-text-window-reverse"></i><span>Phong chieu</span><i class="bi bi-chevron-down ms-auto"></i>
        </a>
      </li><!-- End Tables Nav -->

      <li class="nav-item">
        <a class="nav-link collapsed" data-bs-target="#charts-nav" data-bs-toggle="collapse" href="#">
          <i class="bi bi-bar-chart"></i><span>loai ghe</span><i class="bi bi-chevron-down ms-auto"></i>
        </a>
      </li><!-- End Charts Nav -->

      <li class="nav-item">
        <a class="nav-link collapsed" data-bs-target="#icons-nav" data-bs-toggle="collapse" href="#">
          <i class="bi bi-gem"></i><span>Ghe</span><i class="bi bi-chevron-down ms-auto"></i>
        </a>
      </li><!-- End Icons Nav -->
      <li class="nav-item">
        <a class="nav-link collapsed" data-bs-target="#icons-nav" data-bs-toggle="collapse" href="#">
          <i class="bi bi-gem"></i><span>Ca chieu</span><i class="bi bi-chevron-down ms-auto"></i>
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link collapsed" data-bs-target="#icons-nav" data-bs-toggle="collapse" href="#">
          <i class="bi bi-gem"></i><span>Phim</span><i class="bi bi-chevron-down ms-auto"></i>
        </a>
      </li>
    </ul>

  </aside><!-- End Sidebar-->

  <main id="main" class="main">

    <section class="section">
      <div class="row">
        <div class="col-lg-12">
          <div class="card">
            <div class="card-body">
              <h5 class="card-title">Danh sách giáo viên</h5>
              <div>
                <form>
                  <div class="row ">
                    <div class="form-group col-md-6">
                      <label for="inputEmail4">Mã/Tên/Tài khoản GV</label>
                      <input type="email" class="form-control" id="inputEmail4" placeholder="Email">
                    </div>
                    <div class="col-md-1"></div>
                    <div class="form-group col-md-5">
                      <label for="inputPassword4">Password</label>
                      <select class="form-select" aria-label="Default select example">
                        <option selected>Open this select menu</option>
                        <option value="1">One</option>
                        <option value="2">Two</option>
                        <option value="3">Three</option>
                      </select>
                    </div>
                  </div>
                  <div class="row mt-2">
                    <div class="form-group col-md-5">
                      <label for="inputEmail4">Email</label>
                      <select class="form-select" aria-label="Default select example">
                        <option selected>Open this select menu</option>
                        <option value="1">One</option>
                        <option value="2">Two</option>
                        <option value="3">Three</option>
                      </select>
                      
                      
                    </div>
                    <div class="col-md-2 mt-4 text-center">
                      <button type="submit" class="btn btn-primary mt-5 ">Sign in</button>
                    </div>
                    <div class="form-group col-md-5">
                      <label for="inputPassword4">Password</label>
                      <select class="form-select" size="3" aria-label="size 3 select example">
                        <option selected>Open this select menu</option>
                        <option value="1">One</option>
                        <option value="2">Two</option>
                        <option value="3">Three</option>
                      </select>
                    </div>
                  </div>   
                </form>
                <div class="button-edit row">
                  <div class="col-md-2">
                    <button type="submit" class="btn btn-primary mt-5 ">Sign in</button>
                  </div>
                  <div class="col-md-2">
                    <button type="submit" class="btn btn-primary mt-5 ">Sign in</button>
                  </div>
                  <div class="col-md-2">
                    <button type="submit" class="btn btn-primary mt-5 ">Sign in</button>
                  </div>
                </div>
              </div>

              <table class="table mt-3">
                <thead>
                  <tr>
                    <th scope="col">Ma</th>
                    <th scope="col">Name</th>
                    <th scope="col">phone</th>
                    <th scope="col">email</th>
                    <th scope="col">adresss</th>
                    <th scope="col">type</th>
                    <th scope="col">type teacher</th>
                    <th scope="col">type student</th>
                    <th scope="col">start time</th>
                    <th scope="col">end time</th>
                    <th scope="col">create at</th>
                    <th scope="col">lassmodified</th>

                  </tr>
                </thead>
                <tbody>
                <c:choose>
                    <c:when test="${not empty requestScope.list}">
                        <c:forEach items="${requestScope.list}" var="user">
                            <tr>
                                <td>${user.id }</td>
                                <td>${user.name }</td>
                                <td>${user.phone }</td>
                                <td>${user.email }</td>
                                <td>${user.address }</td>
                                <td>${user.dateOfBirth }</td>
                                <td>${user.type}</td>
                                <td>${user.typeTeacher}</td>
                                <td>${user.typeStudent}</td>
                                <td>${user.startTime}</td>
                                <td>${user.endTime}</td>
                                <td>${user.createAt}</td>
                                <td>${user.lastmodified}</td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr><td colspan="12">No users found.</td></tr>
                    </c:otherwise>
                </c:choose>

                </tbody>
              </table>
              <!-- End Default Table Example -->
               <div class="">
                <nav aria-label="Page navigation example text-end">
                  <ul class="pagination">
                    <li class="page-item">
                      <a class="page-link" href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                        <span class="sr-only">Previous</span>
                      </a>
                    </li>
                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item">
                      <a class="page-link" href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                        <span class="sr-only">Next</span>
                      </a>
                    </li>
                  </ul>
                </nav>
               </div>
            </div>
          </div>
        </div>
        
      </div>
    </section>

  </main><!-- End #main -->

  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <!-- Vendor JS Files -->
  <script src="/view/assets/vendor/apexcharts/apexcharts.min.js"></script>
  <script src="/view/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="/view/assets/vendor/chart.js/chart.min.js"></script>
  <script src="/view/assets/vendor/echarts/echarts.min.js"></script>
  <script src="/view/assets/vendor/quill/quill.min.js"></script>
  <script src="/view/assets/vendor/simple-datatables/simple-datatables.js"></script>
  <script src="/view/assets/vendor/tinymce/tinymce.min.js"></script>
  <script src="/view/assets/vendor/php-email-form/validate.js"></script>

  <!-- Template Main JS File -->
  <script src="/view/assets/js/main.js"></script>

</body>

</html>