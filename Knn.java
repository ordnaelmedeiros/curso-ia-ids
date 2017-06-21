import java.util.ArrayList;
import java.util.List;

public class Knn {
	
	public static void main(String[] args) {
		
		int k = 1;
		
		List<Iris> list = new ConjuntoIris().getList();
		
		List<Iris> listTeste = new ArrayList<>();
		List<Iris> listTreino = new ArrayList<>();
		
		list.stream().filter(i -> (verTeste(i))).forEach(item -> {listTeste.add(item);});
		list.stream().filter(i -> (!verTeste(i))).forEach(item -> {listTreino.add(item);});
		
		
		listTeste.forEach(teste -> {
			listTreino.forEach(treino -> {
				treino.calculaDistancia(teste);
			});
			listTreino.sort((Iris o1, Iris o2) -> Double.compare(o1.distancia, o2.distancia));
			
			double acerto = 0;
			for (int i=0; i<k; i++) {
				if (listTreino.get(i).Species.equals(teste.Species)) {
					acerto += 1.0;
				}
			}
			
			acerto = (acerto*100/k);
			acertoTotal += acerto;
			
			System.out.println(teste.id + " - " + teste.Species +" = " + acerto);
			
		});
		
		System.out.println("Acerto Total: " + (acertoTotal/listTeste.size()));
		
		
	}
	
	private static double acertoTotal = 0.0;
	
	private static boolean verTeste(Iris i) {
		return (i.id>=1 && i.id<=5) || (i.id>=51 && i.id<=55) || (i.id>=101 && i.id<=105);
	}
	
}

class Iris {
	
	private static int count = 0;
	
	public int id;
	public double Sepallength;
	public double Sepalwidth;
	public double Petallength;
	public double Petalwidth;
	public String Species;
	public double distancia;
	
	public Iris(double sepallength, double sepalwidth, double petallength, double petalwidth, String species) {
		super();
		id = ++count;
		Sepallength = sepallength;
		Sepalwidth = sepalwidth;
		Petallength = petallength;
		Petalwidth = petalwidth;
		Species = species;
	}
	
	@Override
	public String toString() {
		return "Iris [id=" + id + ", Sepallength=" + Sepallength + ", Sepalwidth=" + Sepalwidth + ", Petallength="
				+ Petallength + ", Petalwidth=" + Petalwidth + ", Species=" + Species + "]";
	}
	
	public void calculaDistancia(Iris iris) {
		this.distancia = (
				Math.abs((this.Sepallength-iris.Sepallength)) +
				Math.abs((this.Sepalwidth-iris.Sepalwidth)) +
				Math.abs((this.Petallength-iris.Petallength)) +
				Math.abs((this.Petalwidth-iris.Petalwidth)));
	}
	
}

class ConjuntoIris {
	
	public List<Iris> getList() {
		
		List<Iris> list = new ArrayList<>();
		
		list.add(new Iris(5.1, 3.5, 1.4, 0.2, "I. setosa"));
		list.add(new Iris(4.9, 3.0, 1.4, 0.2, "I. setosa"));
		list.add(new Iris(4.7, 3.2, 1.3, 0.2, "I. setosa"));
		list.add(new Iris(4.6, 3.1, 1.5, 0.2, "I. setosa"));
		list.add(new Iris(5.0, 3.6, 1.4, 0.3, "I. setosa"));
		list.add(new Iris(5.4, 3.9, 1.7, 0.4, "I. setosa"));
		list.add(new Iris(4.6, 3.4, 1.4, 0.3, "I. setosa"));
		list.add(new Iris(5.0, 3.4, 1.5, 0.2, "I. setosa"));
		list.add(new Iris(4.4, 2.9, 1.4, 0.2, "I. setosa"));
		list.add(new Iris(4.9, 3.1, 1.5, 0.1, "I. setosa"));
		list.add(new Iris(5.4, 3.7, 1.5, 0.2, "I. setosa"));
		list.add(new Iris(4.8, 3.4, 1.6, 0.2, "I. setosa"));
		list.add(new Iris(4.8, 3.0, 1.4, 0.1, "I. setosa"));
		list.add(new Iris(4.3, 3.0, 1.1, 0.1, "I. setosa"));
		list.add(new Iris(5.8, 4.0, 1.2, 0.2, "I. setosa"));
		list.add(new Iris(5.7, 4.4, 1.5, 0.4, "I. setosa"));
		list.add(new Iris(5.4, 3.9, 1.3, 0.4, "I. setosa"));
		list.add(new Iris(5.1, 3.5, 1.4, 0.3, "I. setosa"));
		list.add(new Iris(5.7, 3.8, 1.7, 0.3, "I. setosa"));
		list.add(new Iris(5.1, 3.8, 1.5, 0.3, "I. setosa"));
		list.add(new Iris(5.4, 3.4, 1.7, 0.2, "I. setosa"));
		list.add(new Iris(5.1, 3.7, 1.5, 0.4, "I. setosa"));
		list.add(new Iris(4.6, 3.6, 1.0, 0.2, "I. setosa"));
		list.add(new Iris(5.1, 3.3, 1.7, 0.5, "I. setosa"));
		list.add(new Iris(4.8, 3.4, 1.9, 0.2, "I. setosa"));
		list.add(new Iris(5.0, 3.0, 1.6, 0.2, "I. setosa"));
		list.add(new Iris(5.0, 3.4, 1.6, 0.4, "I. setosa"));
		list.add(new Iris(5.2, 3.5, 1.5, 0.2, "I. setosa"));
		list.add(new Iris(5.2, 3.4, 1.4, 0.2, "I. setosa"));
		list.add(new Iris(4.7, 3.2, 1.6, 0.2, "I. setosa"));
		list.add(new Iris(4.8, 3.1, 1.6, 0.2, "I. setosa"));
		list.add(new Iris(5.4, 3.4, 1.5, 0.4, "I. setosa"));
		list.add(new Iris(5.2, 4.1, 1.5, 0.1, "I. setosa"));
		list.add(new Iris(5.5, 4.2, 1.4, 0.2, "I. setosa"));
		list.add(new Iris(4.9, 3.1, 1.5, 0.2, "I. setosa"));
		list.add(new Iris(5.0, 3.2, 1.2, 0.2, "I. setosa"));
		list.add(new Iris(5.5, 3.5, 1.3, 0.2, "I. setosa"));
		list.add(new Iris(4.9, 3.6, 1.4, 0.1, "I. setosa"));
		list.add(new Iris(4.4, 3.0, 1.3, 0.2, "I. setosa"));
		list.add(new Iris(5.1, 3.4, 1.5, 0.2, "I. setosa"));
		list.add(new Iris(5.0, 3.5, 1.3, 0.3, "I. setosa"));
		list.add(new Iris(4.5, 2.3, 1.3, 0.3, "I. setosa"));
		list.add(new Iris(4.4, 3.2, 1.3, 0.2, "I. setosa"));
		list.add(new Iris(5.0, 3.5, 1.6, 0.6, "I. setosa"));
		list.add(new Iris(5.1, 3.8, 1.9, 0.4, "I. setosa"));
		list.add(new Iris(4.8, 3.0, 1.4, 0.3, "I. setosa"));
		list.add(new Iris(5.1, 3.8, 1.6, 0.2, "I. setosa"));
		list.add(new Iris(4.6, 3.2, 1.4, 0.2, "I. setosa"));
		list.add(new Iris(5.3, 3.7, 1.5, 0.2, "I. setosa"));
		list.add(new Iris(5.0, 3.3, 1.4, 0.2, "I. setosa"));
		list.add(new Iris(7.0, 3.2, 4.7, 1.4, "I. versicolor"));
		list.add(new Iris(6.4, 3.2, 4.5, 1.5, "I. versicolor"));
		list.add(new Iris(6.9, 3.1, 4.9, 1.5, "I. versicolor"));
		list.add(new Iris(5.5, 2.3, 4.0, 1.3, "I. versicolor"));
		list.add(new Iris(6.5, 2.8, 4.6, 1.5, "I. versicolor"));
		list.add(new Iris(5.7, 2.8, 4.5, 1.3, "I. versicolor"));
		list.add(new Iris(6.3, 3.3, 4.7, 1.6, "I. versicolor"));
		list.add(new Iris(4.9, 2.4, 3.3, 1.0, "I. versicolor"));
		list.add(new Iris(6.6, 2.9, 4.6, 1.3, "I. versicolor"));
		list.add(new Iris(5.2, 2.7, 3.9, 1.4, "I. versicolor"));
		list.add(new Iris(5.0, 2.0, 3.5, 1.0, "I. versicolor"));
		list.add(new Iris(5.9, 3.0, 4.2, 1.5, "I. versicolor"));
		list.add(new Iris(6.0, 2.2, 4.0, 1.0, "I. versicolor"));
		list.add(new Iris(6.1, 2.9, 4.7, 1.4, "I. versicolor"));
		list.add(new Iris(5.6, 2.9, 3.6, 1.3, "I. versicolor"));
		list.add(new Iris(6.7, 3.1, 4.4, 1.4, "I. versicolor"));
		list.add(new Iris(5.6, 3.0, 4.5, 1.5, "I. versicolor"));
		list.add(new Iris(5.8, 2.7, 4.1, 1.0, "I. versicolor"));
		list.add(new Iris(6.2, 2.2, 4.5, 1.5, "I. versicolor"));
		list.add(new Iris(5.6, 2.5, 3.9, 1.1, "I. versicolor"));
		list.add(new Iris(5.9, 3.2, 4.8, 1.8, "I. versicolor"));
		list.add(new Iris(6.1, 2.8, 4.0, 1.3, "I. versicolor"));
		list.add(new Iris(6.3, 2.5, 4.9, 1.5, "I. versicolor"));
		list.add(new Iris(6.1, 2.8, 4.7, 1.2, "I. versicolor"));
		list.add(new Iris(6.4, 2.9, 4.3, 1.3, "I. versicolor"));
		list.add(new Iris(6.6, 3.0, 4.4, 1.4, "I. versicolor"));
		list.add(new Iris(6.8, 2.8, 4.8, 1.4, "I. versicolor"));
		list.add(new Iris(6.7, 3.0, 5.0, 1.7, "I. versicolor"));
		list.add(new Iris(6.0, 2.9, 4.5, 1.5, "I. versicolor"));
		list.add(new Iris(5.7, 2.6, 3.5, 1.0, "I. versicolor"));
		list.add(new Iris(5.5, 2.4, 3.8, 1.1, "I. versicolor"));
		list.add(new Iris(5.5, 2.4, 3.7, 1.0, "I. versicolor"));
		list.add(new Iris(5.8, 2.7, 3.9, 1.2, "I. versicolor"));
		list.add(new Iris(6.0, 2.7, 5.1, 1.6, "I. versicolor"));
		list.add(new Iris(5.4, 3.0, 4.5, 1.5, "I. versicolor"));
		list.add(new Iris(6.0, 3.4, 4.5, 1.6, "I. versicolor"));
		list.add(new Iris(6.7, 3.1, 4.7, 1.5, "I. versicolor"));
		list.add(new Iris(6.3, 2.3, 4.4, 1.3, "I. versicolor"));
		list.add(new Iris(5.6, 3.0, 4.1, 1.3, "I. versicolor"));
		list.add(new Iris(5.5, 2.5, 4.0, 1.3, "I. versicolor"));
		list.add(new Iris(5.5, 2.6, 4.4, 1.2, "I. versicolor"));
		list.add(new Iris(6.1, 3.0, 4.6, 1.4, "I. versicolor"));
		list.add(new Iris(5.8, 2.6, 4.0, 1.2, "I. versicolor"));
		list.add(new Iris(5.0, 2.3, 3.3, 1.0, "I. versicolor"));
		list.add(new Iris(5.6, 2.7, 4.2, 1.3, "I. versicolor"));
		list.add(new Iris(5.7, 3.0, 4.2, 1.2, "I. versicolor"));
		list.add(new Iris(5.7, 2.9, 4.2, 1.3, "I. versicolor"));
		list.add(new Iris(6.2, 2.9, 4.3, 1.3, "I. versicolor"));
		list.add(new Iris(5.1, 2.5, 3.0, 1.1, "I. versicolor"));
		list.add(new Iris(5.7, 2.8, 4.1, 1.3, "I. versicolor"));
		list.add(new Iris(6.3, 3.3, 6.0, 2.5, "I. virginica"));
		list.add(new Iris(5.8, 2.7, 5.1, 1.9, "I. virginica"));
		list.add(new Iris(7.1, 3.0, 5.9, 2.1, "I. virginica"));
		list.add(new Iris(6.3, 2.9, 5.6, 1.8, "I. virginica"));
		list.add(new Iris(6.5, 3.0, 5.8, 2.2, "I. virginica"));
		list.add(new Iris(7.6, 3.0, 6.6, 2.1, "I. virginica"));
		list.add(new Iris(4.9, 2.5, 4.5, 1.7, "I. virginica"));
		list.add(new Iris(7.3, 2.9, 6.3, 1.8, "I. virginica"));
		list.add(new Iris(6.7, 2.5, 5.8, 1.8, "I. virginica"));
		list.add(new Iris(7.2, 3.6, 6.1, 2.5, "I. virginica"));
		list.add(new Iris(6.5, 3.2, 5.1, 2.0, "I. virginica"));
		list.add(new Iris(6.4, 2.7, 5.3, 1.9, "I. virginica"));
		list.add(new Iris(6.8, 3.0, 5.5, 2.1, "I. virginica"));
		list.add(new Iris(5.7, 2.5, 5.0, 2.0, "I. virginica"));
		list.add(new Iris(5.8, 2.8, 5.1, 2.4, "I. virginica"));
		list.add(new Iris(6.4, 3.2, 5.3, 2.3, "I. virginica"));
		list.add(new Iris(6.5, 3.0, 5.5, 1.8, "I. virginica"));
		list.add(new Iris(7.7, 3.8, 6.7, 2.2, "I. virginica"));
		list.add(new Iris(7.7, 2.6, 6.9, 2.3, "I. virginica"));
		list.add(new Iris(6.0, 2.2, 5.0, 1.5, "I. virginica"));
		list.add(new Iris(6.9, 3.2, 5.7, 2.3, "I. virginica"));
		list.add(new Iris(5.6, 2.8, 4.9, 2.0, "I. virginica"));
		list.add(new Iris(7.7, 2.8, 6.7, 2.0, "I. virginica"));
		list.add(new Iris(6.3, 2.7, 4.9, 1.8, "I. virginica"));
		list.add(new Iris(6.7, 3.3, 5.7, 2.1, "I. virginica"));
		list.add(new Iris(7.2, 3.2, 6.0, 1.8, "I. virginica"));
		list.add(new Iris(6.2, 2.8, 4.8, 1.8, "I. virginica"));
		list.add(new Iris(6.1, 3.0, 4.9, 1.8, "I. virginica"));
		list.add(new Iris(6.4, 2.8, 5.6, 2.1, "I. virginica"));
		list.add(new Iris(7.2, 3.0, 5.8, 1.6, "I. virginica"));
		list.add(new Iris(7.4, 2.8, 6.1, 1.9, "I. virginica"));
		list.add(new Iris(7.9, 3.8, 6.4, 2.0, "I. virginica"));
		list.add(new Iris(6.4, 2.8, 5.6, 2.2, "I. virginica"));
		list.add(new Iris(6.3, 2.8, 5.1, 1.5, "I. virginica"));
		list.add(new Iris(6.1, 2.6, 5.6, 1.4, "I. virginica"));
		list.add(new Iris(7.7, 3.0, 6.1, 2.3, "I. virginica"));
		list.add(new Iris(6.3, 3.4, 5.6, 2.4, "I. virginica"));
		list.add(new Iris(6.4, 3.1, 5.5, 1.8, "I. virginica"));
		list.add(new Iris(6.0, 3.0, 4.8, 1.8, "I. virginica"));
		list.add(new Iris(6.9, 3.1, 5.4, 2.1, "I. virginica"));
		list.add(new Iris(6.7, 3.1, 5.6, 2.4, "I. virginica"));
		list.add(new Iris(6.9, 3.1, 5.1, 2.3, "I. virginica"));
		list.add(new Iris(5.8, 2.7, 5.1, 1.9, "I. virginica"));
		list.add(new Iris(6.8, 3.2, 5.9, 2.3, "I. virginica"));
		list.add(new Iris(6.7, 3.3, 5.7, 2.5, "I. virginica"));
		list.add(new Iris(6.7, 3.0, 5.2, 2.3, "I. virginica"));
		list.add(new Iris(6.3, 2.5, 5.0, 1.9, "I. virginica"));
		list.add(new Iris(6.5, 3.0, 5.2, 2.0, "I. virginica"));
		list.add(new Iris(6.2, 3.4, 5.4, 2.3, "I. virginica"));
		list.add(new Iris(5.9, 3.0, 5.1, 1.8, "I. virginica"));
		
		return list;
		
	}
	
}