<%-- 
    Document   : AlteraProduto
    Created on : 06/11/2021, 20:45:40
    Author     : Raphael
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Alterando Produto</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="ServletProduto" method="post">
            Codigo: <input type="text" name="codigo" readonly=”readonly” value=<%=request.getParameter("codigo") %>> <br/>
            Nome antigo: <input type="text" name="nome_antigo" disabled="" value=<%=request.getParameter("nome").replace(" ", "&nbsp;")%>><br/>
            Nome novo: <input type="text" name="nome" value=""><br/>
            Quantidade antiga: <input type="text" name="quantidade_antiga" disabled="" value=<%=request.getParameter("quantidade")%>><br/>
            Quantidade nova: <input type="text" name="quantidade" value=""><br/>
            <% try{%>
            <input type="hidden" name="acao" value="alterarX"/>
            <input type="submit" value="alterar"/>
            <%}catch (Exception error){
                System.out.println("Erro: "+error);
            }%>
        </form>
    </body>
</html>
