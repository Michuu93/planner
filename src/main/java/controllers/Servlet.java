package controllers;

import hibernate.MeetingDAO;
import hibernate.RoomsDAO;
import models.Meeting;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Timestamp;

public class Servlet extends javax.servlet.http.HttpServlet {
    private enum Status {
        SUCCESS,
        FAILURE
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("Hello from the POST Method!");

        if (request.getParameter("bookBtn") != null) {
            bookButtonClick(request);

        } else if (request.getParameter("deleteBtn") != null) {
            deleteButtonClick(request);
        }
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("Hello from the GET Method!");
        request.setAttribute("roomsList", RoomsDAO.getRooms());
        request.setAttribute("meetings", MeetingDAO.getMeetings());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void bookButtonClick(HttpServletRequest request) {
        String room = request.getParameter("room");
        Timestamp startTime = Timestamp.valueOf(request.getParameter("date") + " " + request.getParameter("time") + ":00");
        int duration = Integer.parseInt(request.getParameter("duration")) * 60;
        Timestamp endTime = Meeting.calculateEndTime(startTime, duration);
        Meeting meeting = new Meeting(room, startTime, endTime);

        if (MeetingDAO.check(meeting)) {
            MeetingDAO.saveMeeting(meeting);
            request.setAttribute("check", Status.SUCCESS);
        } else {
            request.setAttribute("check", Status.FAILURE);
        }
    }

    private void deleteButtonClick(HttpServletRequest request) {
        long id = Long.parseLong(request.getParameter("deleteBtn"));
        MeetingDAO.deleteMeeting(id);
    }
}