<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro Funcionario Interno</title>
</head>
<body>
	<h2>Funcionario Interno</h2>
	
	<form method="post" action="<%= request.getContextPath() %>/FuncionarioInterno">
	<label>DIGITE O CPF</label>
	<input type="text" name="cpf" required>
	<br></br>
	<label>DIGITE O NOME</label>
	<input type="text" name="NOME" required>
	<br></br>
	<label>DIGITE A DATA NASCIMENTO</label>
	<input type="text" name="dataNascimento" required>
	<br></br>
	<label>DIGITE O CARGO</label>
	<input type="text" name="cargo" required>
	<br></br>
	<label>DIGITE A MATRICULA</label>
	<input type="text" name="matricula" required>
	<br></br>
	<label>DIGITE O SALARIO</label>
	<input type="text" name="salario" required>
	<br></br>
	<button>Enviar</button>
	

	</form>
</body>
</html>