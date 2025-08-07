package com.helloboot;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;

public class HellobootApplication {

	public static void main(String[] args) {
        ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        WebServer webServer = serverFactory.getWebServer(servletContext -> {

            HelloController helloController = new HelloController();

            servletContext.addServlet("frontController", new HttpServlet() {
                @Override
                protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                    String url = req.getRequestURI();

                    if (url.equals("/hello") && req.getMethod().equals("GET")) {
                        String name = req.getParameter("name");

                        String ret = helloController.hello(name);

                        resp.setStatus(HttpStatus.OK.value());
                        resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
                        resp.getWriter().println(ret);
                    } else if (url.equals("/users")) {

                    } else {
                        resp.setStatus(HttpStatus.NOT_FOUND.value());
                        resp.getWriter().println("Page not found");
                    }
                }
            }).addMapping("/*");
        });
        webServer.start();
    }

}
