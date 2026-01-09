package codigoFonteBasquete;

public class Utilitario {
	public void verificarNumeroNegativo(Double valor){
        if (valor < 0){
            throw new IllegalArgumentException("O valor não ser valor negativo");
        }
    }
}

