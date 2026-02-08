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
		
		FuncionarioInterno funcionarioInterno = new FuncionarioInterno();
		
		funcionarioInterno.setCpf("00000000000");
		funcionarioInterno.setNome("Joenio");
		funcionarioInterno.setDataNascimento("11/10/1992");
		funcionarioInterno.setMatricula("001");
		funcionarioInterno.setCargo("Gerente");
		funcionarioInterno.setSalario("1000");
		
		
		RepositorioFuncionarioInternoImplementacao repositorioFuncionarioInternoImplementacao = new RepositorioFuncionarioInternoImplementacao();
		
		repositorioFuncionarioInternoImplementacao.salvarFuncionarioInterno(funcionarioInterno);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
