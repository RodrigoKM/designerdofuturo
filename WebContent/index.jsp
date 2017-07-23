


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Formulário de cadastro</title>
<meta name="description" content="Formulário de cadastro">


<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="StyleCadastro.css" />

</head>

<body>
	<center>
		<h1>Formulário de cadastro</h1>
		<h2>Preencha o formulário abaixo para se cadastar no site</h2>
		<h5 style="color: #93090c;">Os campos com * são obrigatórios.</h5>
		<br />
	</center>


	<form name="Script_do_Formulario" method="post" action="cadastro">

		<!-- DADOS PESSOAIS-->
		<fieldset>
			<legend>Dados Pessoais</legend>
				<table cellspacing="10">
					<tr>
						<td><label for="nome"><span class="req">*</span> Nome Completo: </label></td>
						<td align="left"><input type="text" name="nome" required></td>
					</tr>
					<tr>	
						<td><label for="email"><span class="req">*</span> E-mail: </label></td>
   						<td align="left"><input type="email" name="email" required></td>
					</tr>	
					<tr>			
						<td><label for="estado"><span class="req">*</span>Área de interesse:</label></td>
						<td align="left">
							<select name="estado" required>
								<option value="">Selecione</option>
								<option value="design">Design</option>
								<option value="programação">Programação</option>
								<option value="marketing">Marketing</option>
								<option value="vendas">Vendas</option>	
							</select>
						</td>
					</tr>
					</table>					
				
			<div>
					<input type="submit" class="submit" value="Enviar">
			</div>
		</form>
	</body>
</html>


