import java.util.*;

public class Daa007{


	static int sms(int[] v, int a, int b){
		if(a==b) return v[a];
		int meio= (a+b)/2; //calcula o meio
		int best1= sms(v, a, meio); //faz o divide de a ao meio
		int best2= sms(v, meio+1, b);//faz o divide de meio a b

		//vamos agora fazer a maior soma do lado esquerdo
		int metade1=v[meio];
		int soma= v[meio];

		for(int i=meio-1;i>=a;i--){
			soma+=v[i]; //vamos somando 
			if(soma>metade1) //verificamos se a soma e maior do q o valor q esta no meio
				metade1=soma; //torna-se a nossa maior soma
		}

		//vamos agora fazer a maior soma do lado direito (msm coisa q em cima mas de range diferetne)
		int metade2= v[meio+1];
		soma=v[meio+1];

		for(int i=meio+2;i<=b;i++){
			soma+= v[i];
			if(soma>metade2)
				metade2=soma;
		}
		int best3= metade1 + metade2; //vai ser a melhor seq da primeira metade + a melhor seq da segunda metade

		return (Math.max(Math.max(best1,best2),best3));//vemos qual e o max desses 3
	}

	public static void main(String[] args){
		FastScanner ler= new FastScanner(System.in);
		int n= ler.nextInt();
		int[] v= new int[n];

		for(int i=0;i<n;i++){
			v[i]=ler.nextInt();
		}
		FastPrint.out.println(sms(v,0,n-1));
		FastPrint.out.close();
	}
}