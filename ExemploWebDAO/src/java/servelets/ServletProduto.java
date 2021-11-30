/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servelets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;
import model.ProdutoDAO;

/**
 *
 * @author Raphael
 */
@WebServlet(name = "ServletProduto", urlPatterns = {"/ServletProduto"})
public class ServletProduto extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if (acao == null) {
            acao = "listar";
        }
        //String paginaDestino = (acao.equals("incluir"))
        //? "ProdutoDados.html" : "ProdutoLista.jsp";
        String paginaDestino;
        if (acao.equals("incluir")) {
            paginaDestino = "ProdutoDados.html";
        } else if (acao.equals("alterar")) {
            paginaDestino = "AlteraProduto.jsp";
        } else {
            paginaDestino = "ProdutoLista.jsp";
        }
        ProdutoDAO dao = new ProdutoDAO();
        int codigo;
        String nome;
        int quantidade;
        switch (acao) {
            case "incluirX":
                codigo = new Integer(request.getParameter("codigo"));
                nome = request.getParameter("nome");
                quantidade = new Integer(
                        request.getParameter("quantidade"));
                dao.incluir(new Produto(codigo, nome, quantidade));
                break;
            case "excluirX":
                dao.excluir(new Integer(request.getParameter("codigo")));
                break;
            case "alterarX":
                codigo = new Integer(request.getParameter("codigo"));
                nome = request.getParameter("nome");
                quantidade = new Integer(
                        request.getParameter("quantidade"));
                dao.alterar(new Produto(codigo, nome, quantidade));
            break;
        }
        if (!acao.equals("incluir") || !acao.equals("alterar")) {
            request.setAttribute("listaProduto", dao.obterTodos());
        }
        request.getRequestDispatcher(paginaDestino).
                forward(request, response);
    }

    // O restante do código foi omitido
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
