package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FuncionarioInterno;
import repository.RepositorioFuncionarioInternoImplementacao;


@WebServlet("/FuncionarioInterno")
public class FuncionarioInternoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FuncionarioInternoController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
		FuncionarioInterno funcionarioInterno = new FuncionarioInterno();
		
		funcionarioInterno.setCpf(request.getParameter("cpf"));
		funcionarioInterno.setNome(request.getParameter("nome"));
		funcionarioInterno.setDataNascimento(request.getParameter("dataNascimento"));
		funcionarioInterno.setMatricula(request.getParameter("matricula"));
		funcionarioInterno.setCargo(request.getParameter("cargo"));
		funcionarioInterno.setSalario(request.getParameter("salario"));
		
		
		RepositorioFuncionarioInternoImplementacao repositorioFuncionarioInternoImplementacao = new RepositorioFuncionarioInternoImplementacao();
		
		repositorioFuncionarioInternoImplementacao.salvarFuncionarioInterno(funcionarioInterno);
	}

}
