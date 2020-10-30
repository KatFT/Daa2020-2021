import java.util.*;

public class Daa005{



	public static void main(String[] args){
		FastScanner ler= new FastScanner(System.in);
		//Scanner ler=new Scanner(System.in);
		int n= ler.nextInt(); //numero de bakugans
		//int[] v= new int[limite];
		int[] v= new int[n+1];
		for(int i=1;i<n+1;i++){
			v[i]= ler.nextInt();

		}
		int[] resposta= new int[v.length];
		resposta[0]=v[0];
		for(int i=1;i<v.length;i++){
			resposta[i]=resposta[i-1]+v[i];
		}


		int f= ler.nextInt(); //numero de fotots

		for(int i=0;i<f;i++){
			int a= ler.nextInt();//posiçao inicial
			int b=ler.nextInt();//posiçao final
			//System.out.println(resposta[b]-resposta[a-1]);
			FastPrint.out.println(resposta[b]- resposta[a-1]);
		}
		FastPrint.out.close();
	}
}