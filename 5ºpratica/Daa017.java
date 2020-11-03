import java.util.*;

//neste exercicio tive a ajuda da minha colega Catarina Chen que me 
//fez aperceber q na piramide ac camadas eram representadas de baixo para 
//cima e nao de cima para baixo, dando depois a facilidade de aplicar o bottom up
//ela também me recomendou a fazer a partir de 0 e n de 1 pq haveria uma melhor facilidade
//para calcular os caminhos possiveis

public class Daa017{

	public static void main(String[] args){
		Scanner ler= new Scanner(System.in);
		
		int n= ler.nextInt(); // numero de pedras e nivel da piramide

		long[][] count= new long[n][n];//matriz q vai por os resultados

		int d= ler.nextInt(); //nº pedras em falta ou deterioradas
		
		int reduz= n; //e preciso para depois reduzir a pesquisa
		
		//metemos as defeituosas a -1
		for(int i=0;i<d;i++){
			int c= ler.nextInt();
			int p= ler.nextInt();
			count[c-1][p-1]= -1; //isto marca q e defeituosa ou falta
		}


		//e aqui q fazemos a nossa pesquisa pela piramide
		for(int i=0;i<n;i++){
			for(int j=0;j<reduz;j++){
				if(i==0 && count[i][j]!=-1)//marca a primeira camada como possivel
					count[i][j]=1; //quer dizer q e possivel
				else if(count[i][j]!=-1)//isto e para as seguintes camadas para ir contando os possiveis
					count[i][j]=count[i-1][j]+count[i-1][j+1];
				if(count[i][j]==-1)//quer dizer q esta em falta ou q esta deteriorada
					count[i][j]=0;
			}
			reduz--;
		}
		//isto aqui imprime na posiçao final ou seja count[tamanho-1][0] que neste caso era
		//o elemento de cima da piramide (neste caso em baixo pq a piramide e invertida)
		System.out.println(count[n-1][0]);
	}
}