package com.designerdofuturo.bo;

import com.designerdofuturo.bean.*;
import com.designerdofuturo.dao.*;

public class TestaEmail {

	public Boolean testaEmail(String Email) {

		CadastroDAO testarEmail = new CadastroDAO();
		Cadastro cadastro = null;
		cadastro = testarEmail.QueryEmail(Email);
		if (cadastro == null) {
			return false;
		}

		else {
			return true;
		}

	}

}
