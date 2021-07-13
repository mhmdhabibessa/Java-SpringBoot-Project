<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel='stylesheet' href='/css/woocommerce-layout.css' type='text/css' media='all'/>
<link rel='stylesheet' href='/css/woocommerce-smallscreen.css' type='text/css' media='only screen and (max-width: 768px)'/>
<link rel='stylesheet' href='/css/woocommerce.css' type='text/css' media='all'/>
<link rel='stylesheet' href='/css/font-awesome.min.css' type='text/css' media='all'/>
<link rel='stylesheet' href='/css/style.css' type='text/css' media='all'/>
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Oswald:400,500,700%7CRoboto:400,500,700%7CHerr+Von+Muellerhoff:400,500,700%7CQuattrocento+Sans:400,500,700' type='text/css' media='all'/>
<link rel='stylesheet' href='css/easy-responsive-shortcodes.css' type='text/css' media='all'/>
 <link href="https://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet" />
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.js"></script>
  <script src="https://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
  <link rel='stylesheet' href='/css/style2.css' type='text/css' media='all'/>  
</head>

    <body class="home page page-template page-template-template-portfolio page-template-template-portfolio-php">
        <div id="page">
            <div class="container">
                <header id="masthead" >
                    <nav id="site-navigation" class="main-navigation">
                        <button class="menu-toggle">Menu</button>
                        <a class="skip-link screen-reader-text" href="#content">Skip to content</a>
                        <div >
                            <ul id="menu-menu-1" class="menu">
                                <li><a href="/">Home</a></li>
                                <li><a href="#">About</a></li>
                                <li><a >Categories</a>
                                <ul class="sub-menu">
                                    <c:forEach items="${categories}" var="category">
                                        <li><a href="category/${category.id}">${category.name}</a></li>
                                    </c:forEach>
                                </ul>
                                </li>
                                <li><a href="/logout">Logout!</a></li>
                            </ul>
                        </div>
                    </nav>
                </header>
                <!-- #masthead -->
                <div id="content" class="site-content">
                    <div id="primary" class="content-area column two-thirds single-portfolio">
                        <main id="main" class="site-main minhight">
                            
                            <article class="portfolio hentry">
                            <header class="entry-header">
                            <div class="entry-thumbnail">
                                <img width="800" height="533" src="../img/wall.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="p1"/>
                            </div>
                            <h1 class="entry-title">Painter</h1> 	
                            <a class='portfoliotype' href='portfolio-category.html'>name : </a>
                            <a class='portfoliotype' href='portfolio-category.html'>Type:</a>
                            </header>
                            <div class="entry-content ">
                                <p>
                                    <c:out value="${painting.descreption}"/>
                                </p>
                            </div>
                            </article> 
                            <div class="painting">
                                <div class="container">
                                    <div class="row">
                                        <div class="col-sm-6">
                                            
                                        <div class="clearfix" style="
                                        width: 135%;">
                                            <div id="thumbcarousel" class="carousel slide" data-interval="false">
                                                <div class="carousel-inner">
                                                    <div class="item active">
                                                        <c:forEach items="${paintings}" var="painting">
                                                            <a href="/category/${painting.getCategory().getId()}/painting/${painting.id}"><div data-target="#carousel"  class="thumb"><img src="" alt="Image"></div></a>
                                                        </c:forEach>
                                                    </div><!-- /item -->
                                                    <div class="item">
                                                        <c:forEach items="${paintings}" var="painting">
                                                            <a href="/category/${painting.getCategory().getId()}/painting/${painting.id}"><div data-target="#carousel"  class="thumb"><img src="" alt="Image"></div></a>
                                                        </c:forEach>
                                                    </div><!-- /item -->
                                                </div><!-- /carousel-inner -->
                                                <a class="left carousel-control" href="#thumbcarousel" role="button" data-slide="prev">
                                                    <span class="glyphicon glyphicon-chevron-left"></span>
                                                </a>
                                                <a class="right carousel-control" href="#thumbcarousel" role="button" data-slide="next">
                                                    <span class="glyphicon glyphicon-chevron-right"></span>
                                                </a>
                                            </div> <!-- /thumbcarousel -->
                                        </div><!-- /clearfix -->
                                        </div> <!-- /col-sm-6 -->

                                    </div> <!-- /row -->
                                </div> <!-- /container -->
                            </div>               
                        </main>
                        <!-- #main -->
                    </div>
                    <!-- #primary -->
                                        
                    <div id="secondary" class="column third">
                        <div class="widget-area">
                            <aside class="widget">
                                <h4 class="widget-title">Request similar project</h4>
                                <form class="wpcf7" method="post" action="#" id="contactform">

                                <form class="wpcf7" method="post" action="contact.php" id="contactform">
                                    <div class="form">
                                        <p><input type="text" name="name" placeholder="Name *"></p>
                                        <p><input type="text" name="email" placeholder="E-mail Address *"></p>
                                        <p><textarea name="comment" rows="3" placeholder="Message *"></textarea></p>
                                        <input type="submit" id="submit" class="clearfix btn" value="Send">
                                    </div>
                                </form> 
                                <div> <br> <br> <br>
                                        <h1>Price:  </h1>
                                        <p class="price"><c:out value="${painting.price}"/></p>
                                        <p>Some text about the jeans. Super slim and comfy lorem ipsum lorem jeansum. Lorem jeamsun denim lorem jeansum.</p>
                                        <div class="container-fluid" style="padding-top: 15px;padding-bottom: 15px;">
                                            <div class="row">
                                                <div class="col">
                                                <div class="form-group mb-2">
                                                    
                                                    <input class="form-control qty" id="quantity" name="quantity" value="1" type="hidden">

                                                </div>
                                                </div>
                                                <div class="col">
                                                    <a href="/cart/add_cart/${category.id}/${painting.id}"><button class="btn btn-primary">Add to cart</button></a>
                                                    <br><br>
                                                    <a  href="/cart">View Chart </a>
                                                </div>

                                            </div>
                                        </div>
                                </div>
                        </div>
                        <div class="done">								
                            Your message has been sent. Thank you!
                        </div>
                    
                    </div>
                </div>
            </div>
                <!-- #content -->
            </div>
            <!-- .container -->
            
        </div>
    <!-- #page -->
        <script src='js/jquery.js'></script>
        <script src='js/plugins.js'></script>
        <script src='js/scripts.js'></script>
        <script src='js/masonry.pkgd.min.js'></script>
        <script src='js/validate.js'></script>
        <script type="text/javascript">
        (function(i,s,o,g,r,a,m){i['SalesCloudObject']=r;i[r]=i[r]||function(){

            (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),

        m=s.getElementsByTagName(o)[0];a.src=g;m.parentNode.insertBefore(a,m)

        })(window,document,'script','https://salescloud.is/js/salescloud.js','salescloud');
        </script>


    </body>
</html>