package controllers;

import models.Meeting;

import java.io.IOException;
import java.util.ArrayList;

public class Servlet extends javax.servlet.http.HttpServlet {
    ArrayList<Meeting> meetings = new ArrayList<>();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("Hello from the POST Method!");

        String room = request.getParameter("room");
        System.out.println(room);
        Meeting meeting = new Meeting();
        meeting.setSala(room);
        meetings.add(meeting);
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("Hello from the GET Method!");
        request.setAttribute("meetings", meetings);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
