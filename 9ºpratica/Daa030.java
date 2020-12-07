// Exemplo de pesquisa em largura (BFS) num grafo nao dirigido
// (similar ao codigo feito na teorica - inclui calculo de distancias)


//neste exercicio tive a ajuda da colega rita romani q me ajudou a perceber 
//mais na parte dos nos centrais e perfiericos 

import java.io.*;
import java.util.*;

// Classe que representa um no
class Node {
    public LinkedList<Integer> adj; // Lista de adjacencias
    public boolean visited;         // Valor booleano que indica se foi visitado numa pesquisa
    public int distance;            // Distancia ao no origem da pesquisa

    Node() {
	adj = new LinkedList<Integer>();
    }
}

// Classe que representa um grafo
class Graph {
    int n;           // Numero de nos do grafo
    Node nodes[];    // Array para conter os nos


    Graph(int n) {
		this.n = n;
		nodes  = new Node[n+1]; // +1 se nos comecam em 1 ao inves de 0


		for (int i=1; i<=n; i++)
	    nodes[i] = new Node();
    }

    public void addLink(int a, int b) {
		nodes[a].adj.add(b);
		nodes[b].adj.add(a);
    }

    // Algoritmo de pesquisa em largura
    public int bfs(int v) {
		LinkedList<Integer> q = new LinkedList<Integer>();
		for (int i=1; i<=n; i++) nodes[i].visited = false;

		int no_maximo=0; //no maximo

		q.add(v);
		nodes[v].visited = true;
		nodes[v].distance = 0;

		while (q.size() > 0) {
		    int u = q.removeFirst();
		    for (int w : nodes[u].adj)
			if (!nodes[w].visited) {
			    q.add(w);
			    nodes[w].visited  = true;
			    nodes[w].distance = nodes[u].distance + 1; 

			    if(nodes[w].distance > no_maximo) no_maximo= nodes[w].distance;
			}	    
		}
		return no_maximo;
    }
}

public class Daa030 {
    public static void main(String args[]) {
		Scanner ler = new Scanner(System.in);

		int n= ler.nextInt();// nos
		Graph g = new Graph(n);

		int a= ler.nextInt(); //arcos

		int[] valueM= new int[n+1]; //guarda os valores maxinos		
		for (int i=0; i<a; i++) 
		    g.addLink(ler.nextInt(), ler.nextInt());

		int maximo=-1;
		int minimo=-1;

		for(int i=1;i<=n;i++){
			int goBfs= g.bfs(i);
			valueM[i]= goBfs;
			if(goBfs > maximo) maximo= goBfs;
			if(goBfs < minimo || minimo == -1) minimo= goBfs;
		}

		System.out.println(maximo); //diametro
		System.out.println(minimo); //raio

		int notifica=0;
		//nos centrais
		for(int i=0;i<n+1;i++){
			if(valueM[i]==minimo){
				if(notifica==0){
					System.out.print(i);
					notifica=1;
				}
				else
					System.out.print(" " + i);
			}
		}
		System.out.println();
		notifica=0;
		//nos perifericos --> quase a msm coisa q os nos centrais mas verificamos com o maximo
		for(int i=0;i<n+1;i++){
			if(valueM[i]==maximo){
				if(notifica==0){
					System.out.print(i);
					notifica=1;
				}
				else
					System.out.print(" " + i);
			}
		}
		System.out.println();
		notifica=0;


    }
}