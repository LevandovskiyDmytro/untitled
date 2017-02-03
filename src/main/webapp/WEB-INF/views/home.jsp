<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
		   prefix="sec"%>
<link href="/resources/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="/resources/css/slider.css" type="text/css" rel="stylesheet"/>
<script src="/resources/js/Slider.js"></script>
<script type="text/javascript" src="/resources/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="/resources/js/jquery.cookie.js"></script>
<script type="text/javascript" src="/resources/js/cart.js"></script>

<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
	<a href="#head" class="btn-floating btn-large brown">
		<i class="large material-icons">navigation</i>
	</a>
</div>

<%--<c:forEach var="commodity" items="${commodities}">--%>
	<%--${commodity.model} <div  onlick="buy(${commodity.id})"></div>--%>

<%--</c:forEach>--%>
<section id="slider">

	<ul class="slider-wrapper">
		<li class="current-slide , slider-wrapper1">
			<img src="https://i.ytimg.com/vi/MKeHK3_BbjI/maxresdefault.jpg"  alt="">
		</li>

		<li>
			<img src="http://millhouseinn.com/wp-content/uploads/2016/03/coffee-tea-or-me-2.jpg" title="" alt="">
		</li>

		<li>
			<img src="http://cdn.shopify.com/s/files/1/0594/2517/t/4/assets/slide_3.jpg?7869167461649984634" title="" alt="">
		</li>

		<li>
			<img src="https://alternativebrewing.com.au/wp-content/uploads/2016/09/Minipresso-New.jpg" title="" alt="">
		</li>
		<li>
			<img src="https://alternativebrewing.com.au/wp-content/uploads/2016/12/Boxing-Day-Banner.jpg" title="" alt="">
		</li>
	</ul>
	<div class="slider-shadow"></div>
	<ul id="control-buttons" class="control-buttons"></ul>
</section>

<div class="product">

	<input type="hidden" name="csrf_name"
		   value="${_csrf.parameterName}" />
	<input type="hidden" name="csrf_value"
		   value="${_csrf.token}" />


	<div class="container">
	<div class="col-md-3 product-price">
		<h3 style="text-align: center; margin-bottom: 5px;color: #333333 !important;">Exclusive</h3>
		<div class="col-lg-12 bottom-cd simpleCart_shelfItem" style="margin-bottom: 35px">
			<div class="product-at ">
				<a href="single.html"><img class="img-responsive" src="/resources/images/coffee10.jpg" alt="">
					<sec:authorize access="hasRole('ROLE_USER')">
						<div class="pro-grid">
							<button class="btn">Buy Now</button>
						</div>
					</sec:authorize>
				</a>
			</div>
			<p class="tun">It is a long established fact that a reader</p>
			<a class="item_add"><p class="number item_price"><i> </i>$431.00</p></a>
		</div>

		<div class="col-lg-12 bottom-cd simpleCart_shelfItem" style="margin-bottom: 35px">
			<div class="product-at ">
				<a href="single.html"><img class="img-responsive" src="/resources/images/exclusive2.jpg" alt="">
					<sec:authorize access="hasRole('ROLE_USER')">
						<div class="pro-grid">
							<button class="btn">Buy Now</button>
						</div>
					</sec:authorize>
				</a>
			</div>
			<p class="tun">It is a long established fact that a reader</p>

			<a class="item_add"><p class="number item_price"><i> </i>$976.00</p></a>
		</div>

		<div class="col-lg-12 bottom-cd simpleCart_shelfItem" style="margin-bottom: 35px">
			<div class="product-at ">
				<a href="single.html"><img class="img-responsive" src="/resources/images/exclusive3.jpg" alt="">
					<sec:authorize access="hasRole('ROLE_USER')">
					<div class="pro-grid">
						<button class="btn">Buy Now</button>
					</div>
					</sec:authorize>
				</a>
			</div>
			<p class="tun">It is a long established fact that a reader</p>
			<a class="item_add"><p class="number item_price"><i> </i>$887.00</p></a>
		</div>

		<!--initiate accordion-->
		<script type="text/javascript">
            $(function() {
                var menu_ul = $('.menu > li > ul'),
                    menu_a  = $('.menu > li > a');
                menu_ul.hide();
                menu_a.click(function(e) {
                    e.preventDefault();
                    if(!$(this).hasClass('active')) {
                        menu_a.removeClass('active');
                        menu_ul.filter(':visible').slideUp('normal');
                        $(this).addClass('active').next().stop(true,true).slideDown('normal');
                    } else {
                        $(this).removeClass('active');
                        $(this).next().stop(true,true).slideUp('normal');
                    }
                });

            });
		</script>
		<!---->



	</div>
	<div class="col-md-9 product1">
		<div id="box" class=" bottom-product">
			<c:forEach var="commodity" items="${commodities}">
				<div class="col-md-4 bottom-cd simpleCart_shelfItem">

					<div class="product-at ">
						<img class="img-responsive"  width="260px" height="260px"  src="${commodity.pathToImage}" alt="">
							<div class="pro-grid">

								<sec:authorize access="hasRole('ROLE_USER')">
									<div class="card-action">
									<input type="hidden" name="commodityId" value="${commodity.id}">
										<button class="btn" href="single${commodity.id}" onclick="Materialize.toast('Added', 2000)"><a>Buy Now</a></button>
										<%--<a class="btn" &lt;%&ndash;href="single${commodity.id}" &ndash;%&gt;onclick="buyCommodity(${commodity.id})">Buy Now!</a>--%>
									</div>
								</sec:authorize>

							</div>
						<p class="tun">${commodity.model}</p>
						<a class="item_add"><p class="number item_price">$<i>${commodity.price}</i></p></a>
					</div>

				</div>
			</c:forEach>
		</div>

	</div>
	<div class="clearfix"> </div>
	<nav class="in">
		<ul class="pagination">
			<li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
			<li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
			<li><a href="#">2 <span class="sr-only"></span></a></li>
			<li><a href="#">3 <span class="sr-only"></span></a></li>
			<li><a href="#">4 <span class="sr-only"></span></a></li>
			<li><a href="#">5 <span class="sr-only"></span></a></li>
			<li> <a href="#" aria-label="Next"><span aria-hidden="true">»</span> </a> </li>
		</ul>
	</nav>
</div>

</div>
<script src="/resources/js/materialize.js"></script>
<%--<script>--%>


    <%--function buyCommodity(index){--%>
        <%--console.log(11111111111);--%>
        <%--$.ajax({--%>
            <%--url: 'buyCommodity?' +$('input[name=csrf_name]').val()+ "="+--%>
            <%--$('input[name=csrf_value]').val(),--%>
            <%--method:'POST',--%>
            <%--contentType: 'application/json; charset=UTF-8',--%>
            <%--dataType: 'json',--%>
            <%--data: ''+ index,--%>
            <%--success: function (res) {--%>
                <%--var all= '';--%>

                <%--for (var i = 0; i<res.length; i++){--%>

                    <%--all+= '<div class="col-md-4 bottom-cd simpleCart_shelfItem">'+--%>
                        <%--'<div class="product-at ">'+--%>
                        <%--' <img class="img-responsive" width="260px" height="260px" src="' + res[i].pathToImage + '">'+--%>
                        <%--'<div class="pro-grid">'+--%>
                        <%--'<sec:authorize access="hasRole('ROLE_USER')">'+--%>
                        <%--'<div class="card-action">'+--%>
                        <%--'<a class="btn" onclick="buyCommodity(' + res[i].id + ')">Buy Now</a>'+--%>
                        <%--'</div></div></sec:authorize>'+--%>
                        <%--'<p class="tun">' + res[i].model + '</p>'+--%>
                        <%--'<a class="item_add"><p class="number item_price">$<i>' + res[i].price + '</i></p></a>'--%>
                    <%--'</div>'--%>
                <%--}--%>
                <%--document.getElementById('box').innerHTML = all;--%>
            <%--}--%>


        <%--})--%>
    <%--}--%>

<%--//buyCommodity(1)--%>

<%--</script>--%>


<!---->