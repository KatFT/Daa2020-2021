import java.util.*;
import java.io.*;

//neste exercicio tive a ajuda da colega cheila alves que me ajudou
//nas linhas 38-43 porque estava com dificuldade na parte da posiçao

class Transform implements Comparable<Transform>{
	public int freq;
	public Integer posicao; //trandformar para tipo primitivo
	public char a;

	Transform(char a){ //inicializa letra e posiçao
		this.a=a;
		freq=0;
		posicao=-1;

	}
	@Override
	//primeiro criteiro de acaliaçao e a frequencia e em caso de empate a posiçao
	public int compareTo(Transform p){
		if(freq > p.freq) return -1;
		if(freq < p.freq) return +1;
		return posicao.compareTo(p.posicao);
	}
}



public class Daa009{
	public static void main(String[] args){
		Scanner ler= new Scanner(System.in);
		String n= ler.nextLine(); //string 
		Transform v[]= new Transform[26]; //para as letras

		for(int i=0;i<26;i++)
			v[i]= new Transform((char)('A'+i));//inicializa td o abecedario

		for(int i=0;i<n.length();i++){
			int ind= (int)(n.charAt(i)-'A'); //cria o indice
			if(v[ind].freq==0)
				v[ind].posicao=i;//define a posicao

			v[ind].freq++;//aumenta a frequencia

		}

		Arrays.sort(v);

		for(int i=0;i<26;i++){
			if(v[i].freq>0)
				System.out.println(v[i].a + " " + v[i].freq);
		}
	}
}