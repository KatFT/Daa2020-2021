import java.util.*;
//Neste exercicio tive a ajuda da minha colega Catarina Chen que me ajudou na parte
//das adjacencias

public class Daa029{

	static boolean adj[][]= new boolean[26][26];
	static boolean visited[]= new boolean[26];
	static LinkedList<Integer> adjLists= new LinkedList<>();
	static int n;
	static String inicial;
	static String inicial2;


	static void Adj(){
		int j=0;
		while(j<inicial.length() && j<inicial2.length()){
			int palavra= inicial.charAt(j)-'A';
			int palavra2= inicial2.charAt(j)-'A';
			if(palavra!=palavra2){
				adj[palavra][palavra2]=true;
				visited[palavra]=false;
				visited[palavra2]=false;
				break;
			}
			j++;
		}
		inicial=inicial2;
	}

	static void dfs(int v) {
		visited[v] = true;
		for (int i=0; i<26; i++){
		    if (adj[v][i] && !visited[i])
				dfs(i);
		}
		adjLists.add(v);
    }


	public static void main(String args[]){
		Scanner ler= new Scanner(System.in);
		n= ler.nextInt(); //nº palavras

		for(int i=0;i<26;i++)
			visited[i]=true;

		inicial= ler.nextLine();
		for(int i=0;i<n;i++){
			inicial2= ler.nextLine();
			Adj();
		}


		for(int i=0;i<26;i++){
			if(!visited[i])
				dfs(i);
		}

		for(int i= adjLists.size()-1;i>=0;i--)
			System.out.print((char)(adjLists.get(i)+'A'));
		System.out.println();


	}
}