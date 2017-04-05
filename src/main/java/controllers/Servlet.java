package controllers;

import hibernate.MeetingDAO;
import models.Meeting;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;

public class Servlet extends javax.servlet.http.HttpServlet {
    private ArrayList<String> roomsList = new ArrayList<>(Arrays.asList("8", "112", "BT22", "LAB144"));

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("Hello from the POST Method!");

        if (request.getParameter("bookBtn") != null) {
            String room = request.getParameter("room");
            Timestamp startTime = Timestamp.valueOf(request.getParameter("date") + " " + request.getParameter("time"));
            int duration = Integer.parseInt(request.getParameter("duration")) * 60;
            Timestamp endTime = Meeting.calculateEndTime(startTime, duration);
            Meeting meeting = new Meeting(room, startTime, endTime);
            MeetingDAO.saveMeeting(meeting);

        } else if (request.getParameter("deleteBtn") != null) {
            long id = Long.parseLong(request.getParameter("deleteBtn"));
            MeetingDAO.deleteMeeting(id);
        }
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("Hello from the GET Method!");
        request.setAttribute("roomsList", roomsList);
        request.setAttribute("meetings", MeetingDAO.getMeetings());

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
