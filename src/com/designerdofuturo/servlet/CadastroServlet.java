package com.designerdofuturo.servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designerdofuturo.bean.Cadastro;
import com.designerdofuturo.bean.Mail;
import com.designerdofuturo.bo.TestaEmail;
import com.designerdofuturo.dao.CadastroDAO;

/**
 * Servlet implementation class CadastroServlet
 */
@WebServlet("/cadastro")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Mail mail;
	private static String filename;
	private static byte[] data;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CadastroServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doService(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doService(request, response);
	}
	
	private void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeCompleto = request.getParameter("nome").concat(" ").concat(request.getParameter("last_name"));
		String email = request.getParameter("email");
		String stack = request.getParameter("stack");
		String ip = "0";
		String remoteAddr = "";

		if (request != null) {
			remoteAddr = request.getHeader("X-FORWARDED-FOR");
			if (remoteAddr == null || "".equals(remoteAddr)) {
				remoteAddr = request.getRemoteAddr();
			}
			if (remoteAddr.length() <= 15) {
				ip = remoteAddr;
			} else {
				ip = remoteAddr.substring(0, remoteAddr.indexOf(":"));
			}
		}

		TestaEmail testaEmail = new TestaEmail();
		if (testaEmail.testaEmail(email)) {
			// request.getRequestDispatcher("/index.html?status=2").forward(request, response);
			response.sendRedirect("index.html#!/artigos/?status=2");
		} else {
			try {
				Cadastro CadastroPessoa = new Cadastro(nomeCompleto, email, stack, ip);// cria o objeto cadastro;
				CadastroDAO cadastro = new CadastroDAO();
				cadastro.adicionaCadastro(CadastroPessoa);

				// rotina para envio de e-mails
				String[] recipients = new String[] { email };
				String subject = "50 links para o Designer do Futuro";
				String text = "Este e-mail possui um anexo e foi gerado automaticamente. Favor não respondê-lo.";
				convertPDFToByteArray();
				getMail().sendMail(recipients, subject, text, data, filename);
			} catch (Exception e) {
				throw new ServletException(e);
			}
			// request.getRequestDispatcher("/index.html?status=1").forward(request, response);
			response.sendRedirect("index.html#!/artigos/?status=1");
		}
	}

	private static Mail getMail() {
		if (mail == null)
			mail = new Mail("smtp.gmail.com", 587, "designerdofuturocontato@gmail.com", "designer1234");
		return mail;
	}

	private static void convertPDFToByteArray() {
		try {
			String path = new CadastroServlet().getClass().getClassLoader().getResource("").getPath();
			path += "com/designerdofuturo/ebooks/designer do futuro.pdf";
			File file = new File(path);
			filename = file.getName();
			data = Files.readAllBytes(file.toPath());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}