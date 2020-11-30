import java.util.*;
import java.io.*;




public class Daa027{

	static boolean adj[][];    // Matriz de adjacencias
    static int colorido[];  // Que nos ja foram coloridos?
    static int nos,arestas,cor;

    public static boolean colorir(int x, int cor){
    	//o 0 e q ainda n foi visitado, o 1 e azul e o 2 e vermelho
    	int newC;
    	if(cor==1) newC=2; 
    	else newC=1;
    	//se ja foi visitado
    	if(colorido[x]!=0){
    		if(colorido[x]!=newC) return false;
    		return true;
    	}

    	if(colorido[x]==0){
    		colorido[x]= newC;
    		for(int i=0;i<nos;i++){
    			if(adj[x][i])
    				if(!colorir(i,newC)) return false;
    		}
    	}
    	return true;

    }

    public static void denovo(int nos){
    	for(int i=0;i<nos;i++){
    		for(int j=0;j<nos;j++)
    			adj[i][j]=false;
    		colorido[i]=0; //vai passar a n ser viditado
    	}
    }


	public static void main(String[] args){
		Scanner ler= new Scanner(System.in);
		int n= ler.nextInt(); //numero de nos

		for(int i=0;i<n;i++){
			nos= ler.nextInt();
			arestas= ler.nextInt();
			adj= new boolean[nos+1][nos+1];
			colorido= new int[nos+1];
			for(int j=0;j<arestas;j++){
				int a= ler.nextInt();
				int b= ler.nextInt();
				a--; b--;
				//define ambas as direçoes como possiveis
				adj[a][b]=true;
				adj[b][a]= true;
			}

			boolean resposta= colorir(0,1);//1 e definido a cor azul

			if(resposta) System.out.println("sim");
			else System.out.println("nao");

			denovo(nos);
		}
	}
}