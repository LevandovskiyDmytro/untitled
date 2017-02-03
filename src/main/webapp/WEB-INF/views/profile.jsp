<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="/resources/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
<%--<br>--%>
<%--<img src="${user.pathImage}" height="150" width="150">--%>
<%--<br>--%>
<%--<form:form action="./saveImage?${_csrf.parameterName}=${_csrf.token}"--%>
           <%--method="post" enctype="multipart/form-data">--%>
    <%--<input type="file" name="image">--%>
    <%--<button>save image</button>--%>
<%--</form:form>--%>
<div class="container" style="height: 100%">
        <h3 style="text-align: center">

            <a class="mdi-content-send brown-text">Your Offers</a>
        </h3>
        <h4 style="text-align: center">
            <a class="mdi-content-send blue-text">${user.name}</a>
        </h4>
        <c:choose>
            <c:when test="${user.commodities.size() != 0}">
                <div class="row">
                    <c:forEach var="commodity" items="${user.commodities}">
                        <div class="col-md-4 bottom-cd simpleCart_shelfItem">
                                <div class="product-at ">
                                    <img class="img-responsive" width="200px" height="150px" src="${commodity.pathToImage}" alt="">
                                    <p class="tun">${commodity.name}</p>
                                    <h5 class="blue-text">${commodity.price}$</h5>
                                    <a href="deleteCommodityFromUser/${commodity.id}"
                                       class="waves-effect waves-light red btn">DELETE</a>
                                </div>
                        </div>
                    </c:forEach>
                </div>
                <c:set var="total" value="${0}"/>
                <c:forEach var="commodity" items="${user.commodities}">
                    <c:set var="total" value="${total + commodity.price}" />
                </c:forEach>



                <h3 style="text-align: center">
                    <a class="mdi-content-send brown-text">Total Price is $ ${total}</a>
                </h3>
            </c:when>
            <c:otherwise>
                <h1 style="text-align: center; margin-top: 10%">
                    <a class="mdi-content-send orange-text">You have no orders to buy </a>
                </h1>
            </c:otherwise>
        </c:choose>

    </div>
</div>
