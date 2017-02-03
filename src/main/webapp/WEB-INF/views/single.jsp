<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags"
           prefix="sec" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link href="/resources/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<script type="text/javascript" src="/resources/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="/resources/js/jquery.cookie.js"></script>
<script type="text/javascript" src="/resources/js/cart.js"></script>



<div class="container" style="height: 400px">
    <div class="products-page">
        <div class="products">
        <div class="new-product">
            <div class="col-md-9 product1">
                <div id="box" class=" bottom-product">

                        <div class="col-md-4 bottom-cd simpleCart_shelfItem">
                            <form:form action="buyCommodity" method="post">
                                <div class="product-at ">
                                    <img class="img-responsive" width="260px" height="260px"  src="${commodity.pathToImage}" alt="">
                                    <div class="pro-grid">

                                        <sec:authorize access="hasRole('ROLE_USER')">
                                            <div class="card-action">
                                                <input type="hidden" name="commodityId" value="${commodity.id}">
                                                    <%--<button class="btn" onclick="Materialize.toast('Added', 2000)">Buy Now</button>--%>
                                               <%-- <a class="btn" onclick="buyCommodity(${commodity.id})">Buy Now!</a>--%>
                                                <button class="btn" onclick="Materialize.toast('Added', 2000)">Buy Now</button>
                                            </div>
                                        </sec:authorize>

                                    </div>
                                    <p class="tun">${commodity.model}</p>
                                    <a class="item_add"><p class="number item_price">$<i>${commodity.price}</i></p></a>
                                </div>
                            </form:form>
                        </div>

                </div>

            </div>



            </div>
            <div class="clearfix"></div>

        </div>
        <div class="clearfix"></div>
    </div>
</div>