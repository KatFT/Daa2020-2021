import java.util.*;

//Neste exercicio tive a ajuda da minha colega Cheila Alves que me ajudou 
//a ver uma maneira de ver cada segmentos e verifica-los a partir de uma linked 
//list e tambem da utilizaçao do override na classe construtor

//esta classe vai darnos os segmentos com inicio e fim e vai compara-los
class Construtor implements Comparable<Construtor>{
	Integer l;//inicio
	Integer r;//fim
	public Construtor(int l, int r){
		this.l=l;
		this.r=r;
	}

	//isto vai ordenar futuramente o array inicialmente pelos inicios
	@Override
	public int compareTo(Construtor s){
		if(l< s.l) return -1;
		if(l>s.l) return +1;
		return r.compareTo(s.r);//ordenar pelos fins
	}
}


public class Daa013{
	public static void main(String[] args){
		Scanner ler= new Scanner(System.in);

		int m= ler.nextInt(); //tamanho do segmento q queremos cobrir

		int n= ler.nextInt(); //qnt de segmentos

		Construtor[] s= new Construtor[n];

		for(int i=0;i<n;i++){
			s[i]= new Construtor(ler.nextInt(),ler.nextInt());//criamos uma instancia com inicio e fim
		}

		Arrays.sort(s);//ordenamos o array

		int end=0;//o nosso end
		int cont=0;// a qnd de segmentos minimo

		while(end < m){//enquanto o nosso end for menor q o tamanho do segmento a cobrir
			int end_esc=0; //end final escolhido

			//Criamos uma linked list q recebe como parametro a classe q criamos
			//e q vai ser utilizado para verificar as condiçoes q queremos
			LinkedList<Construtor> seg=new LinkedList<>();

			//percorremos os segmentos tds
			for(int i=0;i<n;i++){
				//verificamos q se o inicio for <=end
				if(s[i].l<=end)
					seg.addLast(s[i]);//vai adicionando ao final da nossa lista
			}

			//enquanto n for vazia
			while(!seg.isEmpty()){
				Construtor elemento=seg.removeFirst();//removemos o primeiro e verificamos
				if(elemento.r > end_esc)//se o final desse elemento for maior q o end final escolhido
					end_esc=elemento.r;//o nosso end escolhido era o final do q foi removido
			}
			end=end_esc;//depois metiamos o nosso end inicial igual ao end escolhido
			cont++;//e aumenta-se o nº de segmentos
		}
		System.out.println(cont);
	}
}