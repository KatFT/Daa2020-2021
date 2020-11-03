import java.util.*;

public class Daa018{
	public static void main(String[] args){
		Scanner ler= new Scanner(System.in);

		int n= ler.nextInt(); //qnt de tipos de moedas
		
		int[] t= new int[n+1]; //array com as moedas

		for(int i=1;i<=n;i++){
			t[i]= ler.nextInt();
		}

		int p= ler.nextInt(); //qnt de perguntas

		for(int i=0;i<p;i++){
			int q= ler.nextInt();//le cada questao

			int[] coins= new int[q+1];//array vai ter o tamanho da q
			int[] use= new int[q+1];

			for(int l=1;l<=q;l++){
				coins[l]=Integer.MAX_VALUE;
				for(int j=1;j<=n;j++){
					if(t[j]<=l && (1+ coins[l-t[j]]<coins[l])){
						coins[l]= 1+ coins[l-t[j]];
						use[l]=t[j];
					}
				}

			}
			//imprime primeiro o q e os coins minimos nesse q
				System.out.print(q +": [" + coins[q]+"] ");
				//depois imprimes q moedas foram usadas
				/*for(int j=1;j<q;j++){
					System.out.print(" "+use[q]);
					q-=use[q];
				}
				if(use[q]>0)
					System.out.print(" "+use[q]);
				System.out.println();*/
				while(q>0){
					if(q-use[q]==0){
						System.out.println(use[q]);
						break;
					}
					else{
						System.out.print(use[q] + " ");
						q-=use[q];
					}
				}
		}

	}
}