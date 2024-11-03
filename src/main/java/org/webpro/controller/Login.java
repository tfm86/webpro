package org.webpro.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.webpro.database.USistemaDao;
import org.webpro.modelo.USistema;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/login"})
public class Login extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String login = req.getParameter("login");
        String senha = req.getParameter("senha");

//        System.out.println(new USistemaDao().usuarioExiste(login,senha));
//
//        USistemaDao uDao = new USistemaDao();
//        try {
//            System.out.println(uDao.listaUsuarioSistema());
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }


        if (login != null && senha != null && !login.isEmpty() && !senha.isEmpty()) {

            USistemaDao dao = new USistemaDao();

            if (dao.usuarioExiste(login, senha)) {
                HttpSession session = req.getSession();
                session.setAttribute("usuarioLogado", login);
                RequestDispatcher rd = req.getRequestDispatcher("/home.jsp");
                rd.forward(req, resp);
            } else {
                req.setAttribute("erro", "Usuario/senha incorretos");
                RequestDispatcher rd = req.getRequestDispatcher("/?=login.jsp");
                rd.forward(req, resp);
            }
        } else {
            req.setAttribute("erro", "Usuario/senha incorretos");
            RequestDispatcher rd = req.getRequestDispatcher("/?=login.jsp");
            rd.forward(req, resp);
        }

    }
}