import java.util.*;


public class Daa035{

	public static boolean adj[][]= new boolean[30][30];
	public static int dist[][]= new int[30][30];
	public static int n; 


	public static void floyd(){
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(i==j) 
					dist[i][j]=1;
				else if(adj[i][j]) 
					dist[i][j]=1;
				else dist[i][j]=0;
			}
		}

		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				for(int l=0;l<n;l++){
					if(adj[j][i] && adj[i][l]){
						dist[j][l]=1;
						adj[j][l]=true;
					}
				}
			}
		}
	}
	//printa a tabela na forma como o stor quer
//o meu colega André Cerqueira ajudou-me na impressao da tabela
	public static void printar(){
		for(int i=-1;i<n;i++){
			for(int j=-1;j<n;j++){
				if(i==-1){
					if(j==-1) System.out.print(" ");
					else System.out.print(" "+(char)(j+'A'));
				}
				else if(j==-1)
					System.out.print((char)(i+'A'));
				else System.out.print(" "+dist[i][j]);
			}
			System.out.println();
		}
	}




	public static void main(String[] args){
		Scanner ler= new Scanner(System.in);
		n= ler.nextInt();
		char s,s1;
		String str,str1;
		int a;
		for(int i=0;i<n;i++){
			str= ler.next();//primeiro carater
			s=str.charAt(0);
			a= ler.nextInt();//inteiro
			for(int j=0;j<a;j++){
				str1= ler.next();
				s1= str1.charAt(0);
				adj[s-'A'][s1-'A']=true;
			}
		}

		floyd();
		printar();
	}
}