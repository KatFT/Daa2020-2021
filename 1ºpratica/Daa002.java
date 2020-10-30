import java.util.*; 
//criamos um r em q vai ser a soma de digitos que e maior q n e soma ==k

/* uma hipotese q podemos fazer e pegar no nosso numero inicial e fazer uma
auxiliar q ve se a soma dos digitos, then vamos incrementando o nosso n ate ele
chegar a um numero cujo soma dos sigitos da == k 
*/
public class Daa002{

	public static int procura(int n){
		int resp=0;
		while(n!=0){
			resp+=n%10;
			n/=10;
		}
		return resp;
		
	}



 	public static void main(String[] args){
 		Scanner ler= new Scanner(System.in);
 		int t = ler.nextInt(); //numero de casos de teste

 		for(int i=0;i<t;i++){
 			
 			int n= ler.nextInt(); // numero inicial
 			int k= ler.nextInt(); //soma de digitos desejada
 			
 			if(procura(n)==k) n++;

 			while(procura(n)!=k)
 				n++;

 			System.out.println(n);
 			

 			ler.nextLine();

 		}
 	}
 }