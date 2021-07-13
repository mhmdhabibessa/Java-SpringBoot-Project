<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ page isErrorPage="true" %> 
    <!DOCTYPE html>
    <html lang="en">
    
    <head>
    
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
    
        <title>Add Category</title>
    
        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">
    
        <!-- Custom styles for this template-->
        <link href="/css/admin.css" rel="stylesheet">
    
    </head>
    
    <body id="page-top">
    
        <!-- Page Wrapper -->
        <div id="wrapper">
    
            <!-- Sidebar -->
            <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
    
                <!-- Sidebar - Brand -->
                <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
                    <div class="sidebar-brand-icon rotate-n-15">
                        <i class="fas fa-laugh-wink"></i>
                    </div>
                    <div class="sidebar-brand-text mx-3">Artisto Admin</sup></div>
                </a>
    
                <!-- Divider -->
                <hr class="sidebar-divider my-0">
        
                <!-- Divider -->
                <hr class="sidebar-divider">
    
    
                <!-- Nav Item - Pages Collapse Menu -->
                <li class="nav-item active">
                    <p class="nav-link">
                       <span>Pages</span>
                    </p>
                    <div id="collapsePages" class="collapse show" aria-labelledby="headingPages"
                        data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <a class="collapse-item" href="/admin">Admin Page</a>
                            <a class="collapse-item" href="/admin/add_painting">Add Painting</a>
                            <a class="collapse-item active" href="/admin/add_category">Add Category</a>
                            <a class="collapse-item" href="/admin/users">Users</a>
                            <a class="collapse-item" href="/admin/show_paintings">Paintings</a>
                            <a class="collapse-item" href="/admin/show_categories">Categories</a>
                            <div class="collapse-divider"></div>
                            <a class="collapse-item" href="/admin/add_admin">Add Admin</a>
                        </div>
                    </div>
                </li>
            </ul>
            
    
            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">
    
                <!-- Main Content -->
                <div id="content">
    
                    <!-- Topbar -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
    
                        <!-- Sidebar Toggle (Topbar) -->
                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                            <i class="fa fa-bars"></i>
                        </button>
    
                        <!-- Topbar Search -->

    
                        <!-- Topbar Navbar -->
                        <ul class="navbar-nav ml-auto">
    
                            <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                            <li class="nav-item dropdown no-arrow d-sm-none">
                                <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fas fa-search fa-fw"></i>
                                </a>
                                <!-- Dropdown - Messages -->
                                <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                                    aria-labelledby="searchDropdown">
                                    <form class="form-inline mr-auto w-100 navbar-search">
                                        <div class="input-group">
                                            <input type="text" class="form-control bg-light border-0 small"
                                                placeholder="Search for..." aria-label="Search"
                                                aria-describedby="basic-addon2">
                                            <div class="input-group-append">
                                                <button class="btn btn-primary" type="button">
                                                    <i class="fas fa-search fa-sm"></i>
                                                </button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </li>
    
                            <!-- Nav Item - Alerts -->
                            <li>
                                <form id="logoutForm" method="POST" action="/logout">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                    <input type="submit" class="btn btn-danger" value="Logout!" />
                                </form>
                            </li>
                        </ul>
    
                    </nav>
                    <!-- End of Topbar -->
    
                    <!-- Begin Page Content -->
                    <div class="container-fluid">
    
                        <!-- Page Heading -->
                        <h1 class="h3 mb-4 text-gray-800">Add a New Category</h1>
                        

                        <form:form action="/admin/add_category" method="post" modelAttribute="category" enctype="multipart/form-data">
                            <table class="table table-striped">
                                <tr>
                                    <td><form:label path="name">Category Name</form:label></td>
                                    <td> 
                                        <form:input path="name"/>
                                        <form:errors path="name"/>
                                        <c:out value="${er}"/>
                                    </td> 
                                </tr>
                                <tr>
                                    <td><form:label path="pic"> Upload Picture</form:label></td>

                                    <td> 
                                        <form:input type="file" path="pic" name="pic" accept="image/png, image/jpeg, image/jpg" />
                                    </td>
                                </tr>
                                <tr>
                                    <td><form:label path="descreption"> Add a Descreption</form:label></td>

                                    <td> 
                                        <form:input path="descreption"/>
                                        <form:errors path="descreption"/>
                                        <c:out value="${er}"/>
                                    </td>
		           				  </tr>
							 <tr>
                                    <td><form:label path="photos">Uploud photo</form:label></td>
                                    <td> 
                                        <form:input path="photos" type="file" name="photos"/>
                                        <form:errors path="photos"/>
                                        <c:out value="${er}"/>
                                    </td>
		           				  </tr>
		           				   <tr>
                                    <td><form:label path="description">description</form:label></td>
                                    <td> 
                                        <form:input path="description"/>
                                        <form:errors path="description"/>
                                        <c:out value="${er}"/>
                                    </td>
		           				  </tr>
                            </table>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <button type="submit" class="btn btn-primary">Add Category</button>
                        </form:form>
                        
    
                    </div>
                    <!-- /.container-fluid -->
    
                </div>
                <!-- End of Main Content -->
    
                <!-- Footer -->
                <footer class="sticky-footer bg-white">
                    <div class="container my-auto">
                        <div class="copyright text-center my-auto">
                            <span>Copyright &copy; Your Website 2020</span>
                        </div>
                    </div>
                </footer>
                <!-- End of Footer -->
    
            </div>
            <!-- End of Content Wrapper -->
    
        </div>
        <!-- End of Page Wrapper -->
    
        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>
    
        <!-- Logout Modal-->
        <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
            aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">Ã</span>
                        </button>
                    </div>
                    <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                        <a class="btn btn-primary" href="/logout">Logout</a>
                    </div>
                </div>
            </div>
        </div>
    
        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    
        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
    
        <!-- Custom scripts for all pages-->
        <script src="js/sb-admin-2.min.js"></script>
    
    </body>
    
    </html>