import java.util.*;
import java.io.*;


public class Daa010{

	public static void bsearch(int[] soma, int low, int high, int key){
		int middle;
		//pesquisa binaria num array ordenado
		while(low<=high){
			middle=low+(high-low)/2;
			if(key==soma[middle]){ //verificamos logo se a nossa key corresponde ao meio
				System.out.println(soma[middle]);
				return; //sai da funçao
			}
			else if(key< soma[middle])
				high= middle-1;
			else
				low=middle +1;

		}

		//verificamos agora os casos em q o valor da nossa key sai fora dos limites
		//caso o nosso high atinja valores negativos, sabemos q vai ser o menor valor 
		//do nosso array de somas por isso vai retornar a posiçao do array das somas na 
		//posiçao de low
		if(high<0){
			System.out.println(soma[low]);
			return;//sai da funçao
		}
		//agora testamos o caso em q o nosso low vai ser >= ao tamanho do nosso array
		//ou seja vai retornar o maior valor do nosso array, logo vai retornar a posiçao high
		//do nosso array
		if(low>=soma.length){
			System.out.println(soma[high]);
			return;
		}
		//agora de seguida vamos verificar se a diferença da posiçao no array de low - a key
		//é >, <  ou == da diferença da key com a posiçao no array de high, e tem de ter abs 
		//caso a diferença va para valores negativos
		//isto vai nos dar basicamente qual e a soma mais proxima
		if(Math.abs(soma[low]-key)>Math.abs(key-soma[high])){
			System.out.println(soma[high]);
			return; //sai da funçao
		}
		if(Math.abs(soma[low]-key)<Math.abs(key-soma[high])){
			System.out.println(soma[low]);
			return; //sai da funçao
		}
		if(Math.abs(soma[low]-key)==Math.abs(key-soma[high])){
			System.out.println((soma[high]) + " " + (soma[low]));
			return; //sai da funçao
		}
	}



	public static void main(String[] args){
		Scanner ler= new Scanner(System.in);
		int n= ler.nextInt(); //tamanho do conjunto de numeros

		//ler numeros do conjunto
		int[] s= new int[n];//array de cada numero do conjunto
		for(int i=0;i<n;i++)
			s[i]=ler.nextInt();


		int q= ler.nextInt(); //quantidade de questoes
		
		//ler questoes
		int[] p= new int[q];//array das perguntas
		for(int i=0;i<q;i++)
			p[i]=ler.nextInt();


		
		//somatorio-> vai ser necessário para o tamanho do array soma
		
		int a= n*(n-1)/2;
		int somatorio=a;

		//outra alternativa de somatorio
		/*int somatorio=0;
		for(int i=1;i<=n-1;i++)
			somatorio+=n-i;*/


		int[] soma= new int[somatorio];


		int v=0;
		//0<=i, j<=n-1
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n && v<somatorio;j++){
				soma[v]=s[i]+s[j];//guardamos os pares num novo array
				v++;
			}
		}
		//agora vamos ordenar o arrays das somas pq vai ser utilizado para tds as pesqusias
		Arrays.sort(soma);
		//Agora vamos aplicar pesquisa binária para cada pergunta
		//sendo o low o 0, o max o tamanho da soma-1 e a condiçao p[i]
		for(int i=0;i<q;i++){
			bsearch(soma,0,somatorio-1,p[i]);
		}
	}
}