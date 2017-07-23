package com.designerdofuturo.servlet;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.scopus.beans.DadosLogin;
import br.com.scopus.beans.Endereco;
import br.com.scopus.beans.Pessoa;
import br.com.scopus.bo.TestaEmail;
import br.com.scopus.criptografia.Criptografia;
import br.com.scopus.dao.EnderecoDAO;
import br.com.scopus.dao.LoginDAO;
import br.com.scopus.dao.PessoaDAO;


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
	
		String nome  = request.getParameter("nome");
		String Sobrenome  = request.getParameter("sobrenome");
		String sDia  = request.getParameter("dia");
		String sMes= request.getParameter("mes");
		String sAno  = request.getParameter("ano");
		String Sexo  = request.getParameter("sexo");
		String sRg  = request.getParameter("rg");
		String sCPF  = request.getParameter("cpf");
		String sDigitoCPF  = request.getParameter("cpf2");
		String Rua  = request.getParameter("rua");
		String sNumero  = request.getParameter("numero");
		String Complemento  = request.getParameter("complemento");
		String Bairro  = request.getParameter("bairro");
		String Estado  = request.getParameter("estado");
		String Cidade  = request.getParameter("cidade");
		String sCep  = request.getParameter("cep");
		String sDigitoCep  = request.getParameter("cep2");
		String Email  = request.getParameter("email");
		String Apelido  = request.getParameter("apelido");
		
		TestaEmail teste = new TestaEmail();
		if (teste.testa_email(Email)){
			
			request.getRequestDispatcher("/ErroEmailExistente.jsp?erro=1").forward(request, response); 
			
		}
		
		else{
		   
			
		
		Criptografia crip = new Criptografia(); 
		String Senha =null;
		
		try {
			Senha = crip.cripsenha(request.getParameter("pass"));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		Pessoa CadastroPessoa = null;
		Endereco CadastroEndereco = null;
		DadosLogin CadastroLogin = null;
		
		
		DateFormat Data = new SimpleDateFormat("dd/MM/yyyy");
		
		String CompletoCPF = sCPF + sDigitoCPF;
		String CompletoCEP = sCep + sDigitoCep;
		String CompletoData = sDia + "/" + sMes + "/" + sAno;
		
		
	
		
		
		
		
		try{
			Date nascimento = Data.parse(CompletoData);
			
			int Rg = Integer.parseInt(sRg);
			
		
			int Numero = Integer.parseInt(sNumero);
			int CEP = Integer.parseInt(CompletoCEP);
			
			
				
			
			  CadastroPessoa = new Pessoa(nome,  Sobrenome,  nascimento,  Sexo, Rg,  CompletoCPF);//cria o objeto cadastro;
			 
			  CadastroEndereco = new Endereco(Rua, Complemento, Numero, Bairro, Estado, Cidade, CEP);//cria o objeto cadastro;
			 
			  CadastroLogin = new DadosLogin(Email, Apelido, Senha);//cria o objeto cadastro;
			
			  
			  
		}
		catch(Exception e){
			throw new ServletException(e);
		}
		
		
		   
			PessoaDAO pessoa = new PessoaDAO();
			pessoa.AdicionaPessoa(CadastroPessoa); 
			
			EnderecoDAO endereco = new EnderecoDAO();
			endereco.AdicionaEndereco(CadastroEndereco);
			
			LoginDAO Login = new LoginDAO();
			Login.AdicionaLogin(CadastroLogin);
			
			
			
			

			
				
			
			
			

			LoginDAO logar = new LoginDAO();
			DadosLogin login = new DadosLogin();
		
			
			if(pessoa != null){
				login = logar.QueryLogin(Email);
				
				
				HttpSession session = request.getSession();
				//Cria uma nova sessão.

				session.setAttribute("login", login);
				//salva email da sessão
				session.setMaxInactiveInterval(60);  

				request.getRequestDispatcher("/welcolme.jsp").forward(request, response); 
				
	           
	           
				
			}
			else{
				request.getRequestDispatcher("/erro.jsp?erro=1").forward(request, response); 
		}
			

		}
	}

}
