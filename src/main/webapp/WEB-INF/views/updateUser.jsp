<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="/resources/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
<script src="/resources/js/jquery.min.js"></script>


<div class="container">
    <div style="margin-top: 10%">
        <h3 style="text-align: center">
            <a class="mdi-content-send brown-text">Update user</a>
        </h3>
        <div class="row">
            <form:form class="col s12" action="saveUpdatedUser/${userForUpdate.id}" method="post">
                <div class="row">
                    <div class="input-field col s6"><p>Name:</p>
                        <input id="name" name="newName" type="text" value="${userForUpdate.name}">
                        <label for="name"></label>
                    </div>
                    <div class="input-field col s6"><p>Phone nubmer:</p>
                        <input id="phone" name="newPhone" type="text" value="${userForUpdate.phone}">
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12"><p>Email:</p>
                        <input id="email" name="newEmail" type="email" value="${userForUpdate.email}">
                        <label for="email"></label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <p>Enter new password :</p>
                        <input id="password2" name="newPassword" type="password">

                    </div>
                </div>
                <div class="row center">
                    <div class="modal-footer">
                        <button class="btn waves-effect waves-light">
                            Submit <i class="material-icons right">send</i>
                        </button>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>
