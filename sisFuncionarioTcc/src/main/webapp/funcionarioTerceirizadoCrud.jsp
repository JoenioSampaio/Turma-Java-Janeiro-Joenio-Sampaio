<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro Funcionario Terceirizado</title>
</head>
<body>
	<h2>Funcionario Terceirizado</h2>
	
	<form method="post" action="<%= request.getContextPath() %>/FuncionarioTerceirizado">
	
	<label>DIGITE O CPF</label>
	<input type="text" name="cpf" required>
	<br></br>
	<label>DIGITE O NOME</label>
	<input type="text" name="nome" required>
	<br></br>
	<label>DIGITE A DATA NASCIMENTO</label>
	<input type="text" name="dataNascimento" required>
	<br></br>
	<label>DIGITE A FUNÇÃO</label>
	<input type="text" name="funcao" required>
	<br></br>
	<label>DIGITE A EMPRESA</label>
	<input type="text" name="empresa" required>
	<br></br>
	<button>Enviar</button>
	
	</form>
</body>
</html>