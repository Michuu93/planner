<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <title>$Title$</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
        integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<header>
  <h1>Planner</h1>
</header>

<div class="container">
  <h2>Book the room</h2>
  <form class="form-inline" method="post">
    <div class="form-group">
      <label for="room">Room</label>
      <input type="text" class="form-control" id="room" name="room" placeholder="Sala">
    </div>
    <div class="form-group">
      <label for="hour">Start hour</label>
      <input type="email" class="form-control" id="hour" name="hour" placeholder="Godzina rozpoczęcia">
    </div>
    <div class="form-group">
      <label for="time">Time</label>
      <input type="email" class="form-control" id="time" name="time" placeholder="Czas trwania w min">
    </div>
    <button type="submit" class="btn btn-default">Book</button>
  </form>

  <h2>Meetings</h2>
  <table class="table table-hover">
    <thead>
    <tr>
      <th>#</th>
      <th>Sala</th>
      <th>Od</th>
      <th>Do</th>
    </tr>
    </thead>
    <tbody>

      <c:forEach items="${meetings}" var="meeting">
      <tr>
        <td>${meeting.sala}</td>
      </tr>
      </c:forEach>





    </tbody>
  </table>
</div>
</body>
</html>
