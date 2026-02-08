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
		
		FuncionarioTerceirizado funcionarioTerceirizado = new FuncionarioTerceirizado();
		
		funcionarioTerceirizado.setCpf("cpf");
		funcionarioTerceirizado.setNome("nome");
		funcionarioTerceirizado.setDataNascimento("11/10/1992");
		funcionarioTerceirizado.setFuncao("Auxiliar");
		funcionarioTerceirizado.setEmpresa("teste");
		funcionarioTerceirizado.setSalario("1000");
		
		
		RepositorioFuncionarioTerceirizadoImplementacao repositorioFuncionarioTerceirizadoImplementacao = new RepositorioFuncionarioTerceirizadoImplementacao();
		
		repositorioFuncionarioTerceirizadoImplementacao.salvarFuncionarioTerceirizado(funcionarioTerceirizado);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
