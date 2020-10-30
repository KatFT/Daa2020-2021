import java.util.*;
import java.io.*;

// neste exercicio tive a ajuda da colega Cheila que me ajudou a perceber
//como processar as partiçoes e na funçao ispossible q "delimita" a partiçao a 
//partir da soma das distancias.
public class Daa011{

	public static int bsearch(int[] d, int k){
		int soma = 0;
		for(int i=0;i<d.length;i++) {
			soma += d[i];
		}
		int low=1, high=soma;
		//pesquisa binaria num array ordenado
		while(low<high){
			int middle=low+(high-low)/2;
			if(isPossible(d, middle, k)){ //verificamos logo se a nossa key corresponde ao meio
				high = middle;
			}
			else
				low=middle +1;

		}
		return low;
	}



	public static boolean isPossible(int[] d, int x, int k){
		int soma=0;
		int nr_particoes=0;
		for(int i=0;i<d.length;i++){

			if(d[i]>x) return false;

			if((soma + d[i]) > x){
				nr_particoes++;
				soma=d[i];
			}
			else
				soma+=d[i];
		}
		return nr_particoes+1<=k;

	}


	public static void main(String[] args){
		Scanner ler= new Scanner(System.in);
		
		int n= ler.nextInt(); //quantidade de distancias

		int[] d=new int[n]; //array de distancias
		for(int i=0;i<n;i++)
			d[i]=ler.nextInt();
		
		int p=ler.nextInt(); //quantidade de perguntas

		int k;
		for(int i=0;i<p;i++){
			k=ler.nextInt();
			System.out.println(bsearch(d,k));
		}
		

		//funçao soma-> nº de partiçao correto com k dado (boolean)
		//for percorre nº tds dado o k dado tem q sempre q vir soma com prox elemente
		//for maior q o k (middle, k)
		//funçao pesquisa binaria



	}	
}