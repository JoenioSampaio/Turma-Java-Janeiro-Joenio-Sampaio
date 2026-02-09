package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.FuncionarioTerceirizado;
import repository.RepositorioFuncionarioTerceirizadoImplementacao;


@WebServlet("/FuncionarioTerceirizado")
public class FuncionarioTerceirizadoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FuncionarioTerceirizadoController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
		FuncionarioTerceirizado funcionarioTerceirizado = new FuncionarioTerceirizado();
		
		funcionarioTerceirizado.setCpf(request.getParameter("cpf"));
		funcionarioTerceirizado.setNome(request.getParameter("nome"));
		funcionarioTerceirizado.setDataNascimento(request.getParameter("dataNascimento"));
		funcionarioTerceirizado.setFuncao(request.getParameter("funcao"));
		funcionarioTerceirizado.setEmpresa(request.getParameter("empresa"));
	
		
		
		RepositorioFuncionarioTerceirizadoImplementacao repositorioFuncionarioTerceirizadoImplementacao = new RepositorioFuncionarioTerceirizadoImplementacao();
		
		repositorioFuncionarioTerceirizadoImplementacao.salvarFuncionarioTerceirizado(funcionarioTerceirizado);
	}

}
