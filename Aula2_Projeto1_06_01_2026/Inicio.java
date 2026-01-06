import java.util.Date;
public class Inicio {
	
	   public static void main(String[]args) {
		Date data = new Date();
	
		int mes = data.getMonth();
		int ano = data.getYear();
	
		System.out.print("Mês: " + mes);
		System.out.print("Ano: " + ano);
		
	  }
}