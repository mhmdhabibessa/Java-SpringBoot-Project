<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link
  href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.6.0/mdb.min.css"
  rel="stylesheet"
/>
<link
  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
  rel="stylesheet"
/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link rel='stylesheet' href='/css/homePage.css' type='text/css' media='all'/>
<style>
    .cat{
	min-height: 400px;
}
.bg-img{
    background-image: url("/images/demo/homePage.jpg");
    min-height: 650px;
    margin-bottom: 30px;
}
</style>
<title>Welcome | Artisto</title>
</head>
<body>
    <!-- Nav Bar -->
    <nav class="navbar navbar-expand-sm navbar-dark bg-dark navbar-collapse">
        <div class="container-fluid">
            <a class="navbar-brand" href="/">Artisto</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"><i class="fas fa-bars"></i></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="/">Home</a>
                </li>
                <li class="nav-item">
                <a class="nav-link" href="#">About us</a>
                </li>
                <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Categories
                </a>
                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <c:forEach items="${categories}" var="category">
                        <li><a class="dropdown-item" href="/category/${category.id}">${category.name}</a></li>
                    </c:forEach>
                </ul>
                </li>
            </ul>
            <div class="d-flex">
                <a href="/login" class="link-light">Login/Registration</a>
            </div>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
            </div>
        </div>
        </nav>
    <!--End Nav Bar -->

<!-- Contents -->
        <div class="container m-4">
            
        </div>


        <div class="row row-cols-1 row-cols-md-3 g-4 container">
            <c:forEach items="${paintings}" var="painting">
                <div class="col">
                    <div class="card h-100">
                        <img src="..." class="card-img-top" alt="...">
                        <div class="card-body">
                        <h5 class="card-title">${painting.title}</h5>
                        <p class="card-text">${painting.descreption}</p>
                        </div>
                        <div class="card-footer">
                        <small class="text-muted"><a class="dropdown-item" href="/category/${painting.getCategory().getId()}/painting/${painting.id}">More Details...</a></small>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
<!-- End Contents -->


    <!-- Footer -->
    <footer class="bg-dark text-center text-white fixed-bottom">
        <!-- Grid container -->
        <div class="container p-1">
        <!-- Section: Social media -->
            <section class="mb-1">
                <!-- Facebook -->
                <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
                ><i class="fab fa-facebook-f"></i
                ></a>

                <!-- Twitter -->
                <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
                ><i class="fab fa-twitter"></i
                ></a>
        
                <!-- Google -->
                <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
                ><i class="fab fa-google"></i
                ></a>
        
                <!-- Instagram -->
                <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
                ><i class="fab fa-instagram"></i
                ></a>
        
                <!-- Linkedin -->
                <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
                ><i class="fab fa-linkedin-in"></i
                ></a>
        
                <!-- Github -->
                <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
                ><i class="fab fa-github"></i
                ></a>
            </section>
        <!-- Section: Social media -->
    
        </div>
        <!-- Grid container -->
    
        <!-- Copyright -->
        <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
        © 2020 Copyright:
        <a class="text-white" href="https://mdbootstrap.com/">MDBootstrap.com</a>
        </div>
        <!-- Copyright -->
    </footer>
    <!-- Footer -->
</body>
</html>