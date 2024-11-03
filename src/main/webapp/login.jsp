<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<%
  String erro = (String) request.getAttribute("erro");
%>

<title>WebPro Login</title>

    <body>

        </br></br></br></br></br></br></br></br></br></br></br></br></br></br>
        <form action="login" method="post">

            <table style="border:1px solid black;margin-left:auto;margin-right:auto;">

            <tr><th colspan="3">WebPro Login</th></tr>

            <tr>
                <td>Usuário<td>
                <td><input type="text" name="login"><td>
            </tr>

            <tr>
                <td>Senha<td>
                <td><input type="password" name="senha" required><td>
            </tr>

            <tr>
                <th scope="col" colspan="3">
                       <p style="font-size:11px">
                            <%
                                if (erro != null) {
                                    out.println(erro);
                                }
                             %>
                       </p>
                </th>
            </tr>

            <tr>
                <th scope="col" colspan="3"><button type="submit" >Entrar</button><th>
            </tr>

            <tr>
                <th scope="col" colspan="3"><p style="font-size:11px">&copy; 2024</p></th>
            </tr>

                <!--
                    <input type="hidden" name="acao" value=<% out.println(request.getRequestURI()); %>>
                -->

           </table>

        </form>

    </body>

</html>