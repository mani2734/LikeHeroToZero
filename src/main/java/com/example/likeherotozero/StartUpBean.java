package com.example.likeherotozero;

import com.example.likeherotozero.controller.Co2AustossController;
import com.example.likeherotozero.entity.Co2Austoss;
import jakarta.annotation.ManagedBean;
import jakarta.annotation.PostConstruct;
import jakarta.faces.context.FacesContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "helloServlet", value = "/hello-servlet")
@ManagedBean
public class StartUpBean {
    private String message = "Hello World";

    private DBSetup dbSetup = new DBSetup();


    private Co2AustossController controller = new Co2AustossController();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");


        for(Co2Austoss co2 : this.controller.getAll()) {
            System.out.println(co2);
        }

        System.out.println(this.controller.getNewestEntryForCountry("Austria"));

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    @PostConstruct
    public void init() {
        try {
            this.dbSetup.importData();
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
    }
}