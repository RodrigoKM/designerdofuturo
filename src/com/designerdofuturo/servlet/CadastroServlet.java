package com.designerdofuturo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designerdofuturo.bean.Cadastro;
import com.designerdofuturo.dao.CadastroDAO;
import com.designerdofuturo.bo.TestaEmail;;

/**
 * Servlet implementation class CadastroServlet
 */
@WebServlet("/cadastro")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CadastroServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doService(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doService(request, response);
	}

	private void doService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nomeCompleto = request.getParameter("nome").concat(" ").concat(request.getParameter("last_name"));
		String email = request.getParameter("email");
		String stack = request.getParameter("stack");
		String ip = request.getRemoteAddr();

		TestaEmail testaEmail = new TestaEmail();
		if (testaEmail.testaEmail(email)) {

			request.getRequestDispatcher("/ErroEmailExistente.jsp?erro=1").forward(request, response);

		} else {

			try {		
				Cadastro CadastroPessoa = new Cadastro(nomeCompleto, email, stack, ip);// cria o objeto cadastro;
				CadastroDAO cadastro = new CadastroDAO();
				cadastro.adicionaCadastro(CadastroPessoa);

			} catch (Exception e) {
				throw new ServletException(e);
			}

		}

	}
}