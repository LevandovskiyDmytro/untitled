<%--
  Created by IntelliJ IDEA.
  User: buriedsinner
  Date: 12/15/16
  Time: 6:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!--  Scripts-->



<div class="container">
    <div class="contact">
        <h2>Contact</h2>

        <div class="col-md-4 contact-in">
            <h4>Address</h4>
            <p>New Shop</p>
            <p>Lorem ipsum dolor,</p>
            <p>Lviv, Franko street </p>
        </div>
        <div class="address-more">
            <h4>Address1</h4>
            <p>Tel:1115550001</p>
            <p>Fax:190-4509-494</p>
            <p>Email:<a href="mailto:contact@example.com"> contact@example.com</a></p>
        </div>

        </div>


    </div>


    <div style="margin: 20px">
        <div id="map"></div>
    </div>
</div>



<script>
    function initMap() {
        var myLatLng = {lat: 49.842, lng: 24.027};

        var map = new google.maps.Map(document.getElementById('map'), {
            center: myLatLng,
            scrollwheel: false,
            zoom: 13
        });

        var marker = new google.maps.Marker({
            map: map,
            position: myLatLng,
            title: 'Hello World!'
        });
    }

</script>
</div>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAxUPMvM28WmtRrTT4wBcV2Olq8y9UPlzk&callback=initMap"
        async defer></script>
<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>