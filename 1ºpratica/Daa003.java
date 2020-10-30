import java.util.*;

//neste exercicio tive a ajuda de dois colegas:
//-> Cheila Alves que me deu uma ideia geral de como pegavamos nos carateres da matricula
//e os convertiamos para inteiro para depois os calcular junto com os inteiros
// -> André Cerqueira ajudou me a "compactar" o meu codigo em termos que na parte das geraçoes
//tinha feito muito complexo quando afinal podia por de uma forma mais compreensiva visualmente

public class Daa003{

//descobre a geraçao e devolve o numero de matriculas anteriores

	public static int generation(String str){
		int casos= 5290000; // 10^4 * 23^2
		char ch= str.charAt(0);
		char ch2= str.charAt(3);
		char ch3= str.charAt(7);

		if(Character.isLetter(ch)){
			if(Character.isLetter(ch3)) 
				return casos* 3; //geraçao 4
			else return 0; // geraçao 1
		}
		else{
			if(Character.isLetter(ch3))
				return casos*1; //geraçao 2
			else return casos*2; //geraçao 3
		}
	}

//vai percorrer a matricula da direita para a esquerda e contar 

	public static int solve(String str){
		int base=1;
		int res= generation(str); //da o nº de matriculas anterior
		//começamos a contar da direita para a esquerda
		//sendo q cada digit tem 10 e letra 23

		//Aqui vai contar os números

		for(int i=str.length()-1; i>=0;i--){
			if(Character.isDigit(str.charAt(i))){
				res+= (str.charAt(i) - '0') * base;
				base*=10;
			}
		}

		//Aqui vai contar os carateres

		for(int i=str.length()-1;i>=0;i--){
			if(Character.isLetter(str.charAt(i))){ 
				int val= str.charAt(i) - 'A';
				if(str.charAt(i) > 'K') val--;
				if(str.charAt(i) > 'W') val--;
				if(str.charAt(i) > 'Y') val--;
				res+= val*base;
				base*=23;
			}
		}

		return res;
	}





	public static void main(String[] args){
		Scanner ler= new Scanner(System.in);

		int t= ler.nextInt(); //numero de casos

		for(int i=0;i<t;i++){
			String str= ler.next();
			String str2= ler.next();

			//imprime o modulo da diferença das duas matriculas
			System.out.println(Math.abs(solve(str2) - solve(str)));

		}
	}

}