<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<!DOCTYPE html>
<html lang="pl-PL">
<head>
    <title>$Title$</title>

    <link href="resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="resources/bootstrap-3.3.7-dist/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="resources/jquery-3.2.0.min.js"></script>
    <script type="text/javascript" src="resources/moment-with-locales.js"></script>
    <script type="text/javascript" src="resources/transition.min.js"></script>
    <script type="text/javascript" src="resources/bootstrap-3.3.7-dist/js/bootstrap-collapse.js"></script>
    <script type="text/javascript" src="resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="resources/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.min.js"></script>
</head>
<body>
<header>
    <h1>Planner</h1>
</header>

<div class="container">
    <h2>Book the room</h2>
    <form method="post">
        <div class="container">
            <div class="row">
                <div class="col-md-3">Room:</div>
                <div class="col-md-3">Date:</div>
                <div class="col-md-3">Time:</div>
                <div class="col-md-3">Duration (min):</div>
            </div>
            <div class="row">
                <div class="col-md-3">
                    <select class="form-control" name="room">
                        <c:forEach items="${roomsList}" var="room">
                            <option>${room}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-md-3">
                    <div class="form-group">
                        <div class="input-group date" id="datepicker">
                            <input type="text" class="form-control" name="date"/>
                            <span class="input-group-addon">
                                <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="form-group">
                        <div class="input-group date" id="timepicker">
                            <input type="text" class="form-control" name="time"/>
                            <span class="input-group-addon">
                                <span class="glyphicon glyphicon-time"></span>
                            </span>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <input class="form-control" type="number" min="15" max="120" value="20" name="duration">
                </div>
            </div>
            <div class="row">
                <div class="col-md-2">
                    <button type="submit" name="bookBtn" class="btn btn-default">Book</button>
                </div>
            </div>
        </div>

        <script type="text/javascript">
            $(function () {
                $('#datepicker').datetimepicker({
                    locale: 'pl',
                    format: 'YYYY-MM-DD',
                });
            });
            $(function () {
                $('#timepicker').datetimepicker({
                    format: 'HH:mm:ss'
                });
            });
        </script>
    </form>


    <!--Meetings List-->
    <h2>Meetings</h2>

    <c:if test="${check} == '1'">
        <div class="alert alert-success alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <strong>Success!</strong> The meeting was saved.
        </div>
    </c:if>
    <c:if test="${check} == '-1'">
        <div class="alert alert-warning alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <strong>Warning!</strong> The selected room is occupied during these hours.
        </div>
    </c:if>

    <table class="table table-hover">
        <thead>
        <tr>
            <th>Room</th>
            <th>Start time</th>
            <th>End time</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${meetings}" var="meeting">
            <tr>
                <td>${meeting.room}</td>
                <td>${meeting.startTime}</td>
                <td>${meeting.endTime}</td>
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
</div>


</body>
</html>
