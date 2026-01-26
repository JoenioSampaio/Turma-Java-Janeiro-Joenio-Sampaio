package sisAnimal;

public class Principal {

	public static void main(String[] args) {
			
			System.out.println("rodou");
			
			Animal animal = new Animal("005", "Caramelo", "Eric");
			
			DaoAnimal daoAnimal = new DaoAnimal();
			daoAnimal.salvarAnimalBanco(animal);
			
			
			

		}

}
