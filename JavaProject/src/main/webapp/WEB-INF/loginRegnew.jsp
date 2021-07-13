<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/loginRegnew.css">
<script type="text/javascript" src="/js/loginRegnew.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div class="cotn_principal">
        <div class="cont_centrar">

            <div class="cont_login">
                <div class="cont_info_log_sign_up">
                    <div class="col_md_login">
                        <div class="cont_ba_opcitiy">
                            <c:if test="${logoutMessage != null}">
                                <p class="sucess">
                                    <c:out value="${logoutMessage}"></c:out>
                                </p>
                            </c:if>

                            <c:if test="${errorMessage != null}">
                                <p class="error">
                                    <c:out value="${errorMessage}"></c:out>
                                </p>
                            </c:if>
                            <h2>LOGIN</h2>

                            <p></p>
                            <button class="btn_login" onclick="cambiar_login()">LOGIN</button>
                        </div>
                    </div>
                    <div class="col_md_sign_up">
                        <div class="cont_ba_opcitiy">
                            <h2>SIGN UP</h2>


                            <p></p>

                            <button class="btn_sign_up" onclick="cambiar_sign_up()">SIGN UP</button>
                        </div>
                    </div>
                </div>


                <div class="cont_back_info">
                    <div class="cont_img_back_grey">
                        <img src="https://images.unsplash.com/42/U7Fc1sy5SCUDIu4tlJY3_NY_by_PhilippHenzler_philmotion.de.jpg?ixlib=rb-0.3.5&q=50&fm=jpg&crop=entropy&s=7686972873678f32efaf2cd79671673d"
                            alt="" />
                    </div>

                </div>
                <div class="cont_forms">
                    <div class="cont_img_back_">
                        <img src="https://images.unsplash.com/42/U7Fc1sy5SCUDIu4tlJY3_NY_by_PhilippHenzler_philmotion.de.jpg?ixlib=rb-0.3.5&q=50&fm=jpg&crop=entropy&s=7686972873678f32efaf2cd79671673d"
                            alt="" />
                    </div>
                    <div class="cont_form_login">
                        <a href="#" onclick="ocultar_login_sign_up()"><i class="material-icons">&#xE5C4;</i></a>
                        <h2>LOGIN</h2>
                        <form method="POST" action="/login">
                            <p>
                                
                                <input type="email" id="username" name="username" placeholder="Email" />
                            </p>
                            
                            <p>
                              
                                <input type="password" id="password" name="password" placeholder="Password" />
                            </p>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                            <button class="btn_login" onclick="cambiar_login()">LOGIN</button>
                            
                        </form>
                    </div>

                    <div class="cont_form_sign_up">
                        <a href="#" onclick="ocultar_login_sign_up()"><i class="material-icons">&#xE5C4;</i></a>
                        <h2>SIGN UP</h2>
                        <p>
                            <form:errors path="user.*" />
                        </p>
                        <form:form method="POST" action="/registration" modelAttribute="user">
                            <p>
                                <form:label path="firstname"></form:label>
                                <form:input path="firstname" placeholder="First Nmae" />
                            </p>
                            
                            <p>
                                <form:label path="lastname"></form:label>
                                <form:input path="lastname" placeholder="Last Name" />
                            </p>
                          
                            <p>
                                <form:label path="email"></form:label>
                                <form:input path="email" placeholder="Email" />
                            </p>
                            <p>
                                <form:label path="password"></form:label>
                                <form:password path="password" placeholder="Password" />
                            </p>
                         
                            <p>
                                <form:label path="passwordConfirmation"></form:label>
                                <form:password path="passwordConfirmation" placeholder="Confirm Password" />
                            </p>
                       
                            <button class="btn_sign_up" onclick="cambiar_sign_up()">SIGN UP</button>
                            </form:form>
                            

                    </div>
                </div>

            </div>

        </div>
    </div>

</body>
</html>