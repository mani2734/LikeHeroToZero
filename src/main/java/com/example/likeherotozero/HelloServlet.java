package com.example.likeherotozero;

import com.example.likeherotozero.controller.Co2AustossController;
import com.example.likeherotozero.entity.Co2Austoss;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message = "Hello World";

    private DBSetup dbSetup = new DBSetup();


    private Co2AustossController controller = new Co2AustossController();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        this.dbSetup.importData();

        for(Co2Austoss co2 : this.controller.getAll()) {
            System.out.println(co2);
        }

        System.out.println(this.controller.getNewestEntryForCountry("Austria"));

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}