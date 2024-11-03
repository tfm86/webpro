package org.webpro.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class Audit implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String uri = req.getRequestURI();
        String usuario = (String) req.getSession().getAttribute("usuarioLogado");

        System.out.println("Página: " + uri);
        System.out.println("Usuário: " + usuario);


        //chain.doFilter(request, response);
        if (usuario != null) {
            chain.doFilter(request, response);
        } else {
            RequestDispatcher rd = req.getRequestDispatcher("login");
            rd.forward(req, resp);
        }


    }
}