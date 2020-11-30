import java.util.*;
import java.io.*;



public class Daa026{
	static int n;              // Numero de nos do grafo
	static int rows;
	static int cols;
    static char m[][];    // Matriz de adjacencias
    static boolean visited[][];  // Que nos ja foram visitados?

    static int dfs(int y,int x) {
    	if(y<0 || y>=rows || x<0 || x>=cols) return 0;
    	if(visited[y][x]) return 0;
    	if(m[y][x]=='#'){
			visited[y][x] = true;
			return 1 + dfs(y+1,x-1)+dfs(y+1,x)+dfs(y+1,x+1) + dfs(y,x-1)
			+ dfs(y,x+1)+dfs(y-1,x-1)+dfs(y-1,x) + dfs(y-1,x+1);
    	}
    	return 0;
    }
    
    public static void main(String args[]) {
		Scanner ler = new Scanner(System.in);
		
		n = ler.nextInt(); //nº pontos de contato

		
		 
		for(int i=0;i<n;i++){
			int cont=0,max=0;
			rows = ler.nextInt();
			cols = ler.nextInt();
	    	m    = new char[rows+1][cols+1];
			visited = new boolean[rows+1][cols+1];	



			for (int j=0; j<rows; j++) { //lemos a matriz
				String str= ler.next();
			    m[j]=str.toCharArray();
			}
			//mete a matriz a false
			for (int j=0; j<rows; j++) {
				for (int l=0; l<cols; l++) {
					visited[j][l]=false;
				}
			}

			
			for(int j=0;j<rows;j++){
				for(int l=0;l<cols;l++){
					if(m[j][l]=='#'){
						cont=0;
						cont=dfs(j,l);
						//verificamos se e o maximo
						if(cont>max) max=cont;
					}
				}
			}
			System.out.println(max);
		} 
    }
}