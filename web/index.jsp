<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="pl-PL">
<head>
    <title>Meetings Planner</title>
    <link type="text/css" href="resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <link type="text/css" href="resources/bootstrap-3.3.7-dist/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
</head>
<body>

<%--Navbar--%>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/"><span class="glyphicon glyphicon-list" aria-hidden="true"></span> Meeting
                Planner</a>
        </div>
    </div>
</nav>


<%--Form--%>
<h2>Book the room</h2>
<form method="post">
    <div class="container">
        <div class="row">
            <div class="form-group col-md-3 col-sm-6 col-xs-12">
                <label for="room">Room</label>
                <select class="form-control" name="room" id="room">
                    <c:forEach items="${roomsList}" var="room">
                        <option>${room}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group col-md-3 col-sm-6 col-xs-12">
                <label for="datepicker">Date</label>
                <div class="input-group date" id="datepicker">
                    <input type="text" class="form-control" name="date" required="true"/>
                    <span class="input-group-addon">
                                <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                </div>
            </div>
            <div class="form-group col-md-3 col-sm-6 col-xs-12">
                <label for="timepicker">Start Time</label>
                <div class="input-group date" id="timepicker">
                    <input type="text" class="form-control" name="time" required="true"/>
                    <span class="input-group-addon">
                                <span class="glyphicon glyphicon-time"></span>
                            </span>
                </div>
            </div>
            <div class="form-group col-md-3 col-xs-6 col-sm-6 col-xs-12">
                <label for="duration">Duration (min)</label>
                <input id="duration" class="form-control" type="number" min="15" max="120" value="60" step="5"
                       name="duration" required="true">
            </div>
        </div>
        <div class="row">
            <div class="col-md-3">
                <button type="submit" name="bookBtn" class="btn btn-default">Add Meeting</button>
            </div>
        </div>
    </div>
</form>

<div class="container">
    <!--Meetings List-->
    <h2>Meetings</h2>
    <%--Success Alert--%>
    <c:if test="${check eq 'SUCCESS'}">
        <div class="alert alert-success alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                    aria-hidden="true">&times;</span></button>
            <span class="glyphicon glyphicon glyphicon-ok-sign" aria-hidden="true"></span>
            <strong>Success!</strong> The meeting was added.
        </div>
    </c:if>
    <%--Warning Alert--%>
    <c:if test="${check eq 'FAILURE'}">
        <div class="alert alert-warning alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                    aria-hidden="true">&times;</span></button>
            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
            <strong>Warning!</strong> The selected room is occupied during these hours. Please select another date or
            change room.
        </div>
    </c:if>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Room</th>
            <th>Date</th>
            <th>Start time</th>
            <th>End time</th>
            <th style="width: 85px"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${meetings}" var="meeting">
            <tr>
                <td class="">${meeting.room}</td>
                <td>
                    <fmt:parseDate value="${meeting.startTime}" var="startDate" pattern="yyyy-MM-dd HH:mm:ss"/>
                    <fmt:formatDate value="${startDate}" pattern="dd/MM/yyyy"/>
                </td>
                <td>
                    <fmt:parseDate value="${meeting.startTime}" var="startDate" pattern="yyyy-MM-dd HH:mm:ss"/>
                    <fmt:formatDate value="${startDate}" pattern="HH:mm"/>
                </td>
                <td>
                    <fmt:parseDate value="${meeting.endTime}" var="endDate" pattern="yyyy-MM-dd HH:mm:ss"/>
                    <fmt:formatDate value="${endDate}" pattern="HH:mm"/>
                </td>
                <td>
                    <form method="post">
                        <button type="submit" name="deleteBtn" value="${meeting.id}" class="btn btn-default">
                            Delete
                        </button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <%--Footer--%>
    <hr>
    <footer>
        <p>by Michał H.</p>
    </footer>
</div>

<%--Scripts--%>
<script type="text/javascript" src="resources/jquery-3.2.0.min.js"></script>
<script type="text/javascript" src="resources/moment-with-locales.js"></script>
<script type="text/javascript" src="resources/transition.min.js"></script>
<script type="text/javascript" src="resources/bootstrap-3.3.7-dist/js/bootstrap-collapse.js"></script>
<script type="text/javascript" src="resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="resources/scripts.js"></script>
</body>
</html>
