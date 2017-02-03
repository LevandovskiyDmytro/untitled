$(document).ready(function() {
	
	msg = new Array();
	var basket = '';
	var totalprice = 0;
	var totalCountGoods = 0;
	if (!$.cookie("basket")) {
		$.cookie("basket", '', {
			path : "/"
		});
	}
	basket = decodeURI($.cookie("basket"));
	basketArray = basket.split(",");// Находим все товары
	for (var i = 0; i < basketArray.length - 1; i++) {
		goodsId = basketArray[i].split(":"); // Находим id товара, цену и
		// количество
		totalCountGoods += parseInt(goodsId[1]);
		totalprice += parseInt(goodsId[1]) * parseInt(goodsId[2]);
	}
	if (totalprice > 0) {
		$('#clearBasket').show();
		$('#checkOut').show();
		$('.hPb').show();
		$('.hPe').hide();
	}
	if (!totalprice) {
		totalprice = 0;
	}
	$('#totalPrice').text(totalprice);
	$('#totalGoods').text(totalCountGoods);
});

$('a.hvr-shutter-in-vertical').click(function() {
	data = $(this).attr('id').split('-');
	addCart(data[1], data[2], 1, data[3], data[4], data[5]);
	return false;
});




function addCart(p1, p2, p3, p4, p5, p6) {
	if (!p3 || p3 == 0) {
		p3 = 1;
	}
	
	msg.id = p1; // АйДи
	msg.price = parseInt(p2); // Цена
	msg.count = parseInt(p3); // Количество
	msg.umailid = p4; // user mail
	msg.unumberid = p5; // user number
	msg.date = p6; // date
	var check = false;
	var cnt = false;
	var totalCountGoods = 0;
	var totalprice = 0;
	var goodsId = 0;
	var basket = '';
	$('#clearBasket').show();
	$('#checkOut').show();
	$('.hPb').show();
	$('.hPe').hide();
	basket = decodeURI($.cookie("basket"));
	if (basket == 'null') {
		basket = '';
	}
	basketArray = basket.split(",");
	for (var i = 0; i < basketArray.length - 1; i++) {
		goodsId = basketArray[i].split(":");
		if (goodsId[0] == msg.id) // ищем, не покупали ли мы этот товар ранее
		{
			check = true;
			cnt = goodsId[1];
			break;
		}
	}
	if (!check) {
		basket += msg.id + ':' + msg.count + ':' + msg.price + ':' + msg.umailid + ':' + msg.unumberid + ':' + msg.date + ',';
	} else {
		alert("Already there to Cart!");
	}
	if (!check) {
		alert("Added");
		basketArray = basket.split(",");// Находим все товары
		for (var i = 0; i < basketArray.length - 1; i++) {
			goodsId = basketArray[i].split(":"); // Находим id товара, цену и
			// количество
			totalCountGoods += parseInt(goodsId[1]);
			totalprice += parseInt(goodsId[1]) * parseInt(goodsId[2]);
		}
		$('#totalGoods').text(totalCountGoods);
		$('#totalPrice').text(totalprice);
		$.cookie("totalPrice", totalprice, {
			path : "/"
		});
		$.cookie("basket", basket, {
			path : "/"
		});
		
	}
	
}

$('#commForm').submit(function(event) {
	event.preventDefault();
	
	function getCookie(name) {
		var cookie = " " + document.cookie;
		var search = " " + name + "=";
		var setStr = null;
		var offset = 0;
		var end = 0;
		if (cookie.length > 0) {
			offset = cookie.indexOf(search);
			if (offset != -1) {
				offset += search.length;
				end = cookie.indexOf(":", offset)
				if (end == -1) {
					end = cookie.length;
				}
				setStr = unescape(cookie.substring(offset, end));
			}
		}
		return(setStr);
	}
	
	var orderDet = getCookie('basket');
	
	var json = JSON.stringify({
		id:0,
		orderInf:orderDet,
		
	});
	$.ajax({
		url : '/index',
		type : 'PUT',
		data : json,
		contentType : "application/json",
		success : function() {
			location.href = "/successOrder"
				$.cookie('basket', null);
		}
	});
	
});






$('#clearBasket').click(function() {
	$.cookie("totalPrice", '', {
		path : "/"
	});
	$.cookie("basket", '', {
		path : "/"
	});
	
	

	$('#totalPrice').text('0');
	$('#totalGoods').text('0');
	$('.hPb').hide();
	$('.hPe').show();
	$(this).hide();
	$('#checkOut').hide();
	$.jGrowl("Cart is clear");
	return false;
	

});
