import java.util.*;

//neste exercicio tive a ajuda da minha colega cheila que me
//ajudou na parte do racio e ordem que da maneira que estava a 
//fazer anteriormente não ia a lado nenhum.

class Sapateiro implements Comparable<Sapateiro>{
	double racio; //vai ser o valor da multa por dia
	double dia, multa;
	Integer ordem;//vai dizer a ordem por q distribui

	Sapateiro(double dia, double multa, Integer ordem){
		this.dia=dia;
		this.multa=multa; 
		this.racio=racio;
		this.ordem=ordem;

		racio= multa/dia;//calcula aqui o racio
	}

	//temos de ordenar decrecente
	@Override
	public int compareTo(Sapateiro s){
		if(racio < s.racio) return +1;//compara por racio
		if(racio > s.racio) return -1;
		return ordem.compareTo(s.ordem); //comparaçao por ordem
	}
}


public class Daa014{
	public static void main(String[] args){
		Scanner ler=new Scanner(System.in);

		int n= ler.nextInt(); //numero de encomanedas

		Sapateiro[] lista= new Sapateiro[n];

		for(int i=0;i<n;i++){//é por i+1 a ordem pq tem de ser de 1 a N
			lista[i]=new Sapateiro(ler.nextInt(), ler.nextInt(), i+1);
		}

		Arrays.sort(lista);//ordena por ordem decrescente

		for(int i=0;i<n-1;i++)//isto e por organizar com espaço
			System.out.print(lista[i].ordem + " ");
		System.out.println(lista[n-1].ordem);//imprime o ultimo elemento da lista
	}


}