// Exemplo de aplicacao do algoritmo de Dijkstra
// (assumindo um grafo pesado e dirigido, sem pesos negativos)
// (codigo adaptado do codigo em C++ feito na teorica)



//como os nos começam em 0 temos de mudar os limites dos arrays


import java.util.*;

// Classe que representa uma aresta
class Edge {
    int to;     // No destino
    int weight; // Peso da aresta
    
    Edge(int t, int w) {
		to = t;
		weight = w;
    }
}

// Classe que representa um no
class Node {
    public LinkedList<Edge> adj; // Lista de adjacencias
    //public boolean visited;      // No ja foi visitado?
    public int distance;         // Distancia ao no origem da pesquisa
    
    Node() {
		adj = new LinkedList<>();
    } 
};



// Classe que representa um grafo
class Graph {
    int n;          // Numero de nos do grafo
    Node[] nodes;   // Array para conter os nos
    
    Graph(int n) {
		this.n = n;
		nodes = new Node[n];  // +1 se os nos comecam em 1 ao inves de 0
		for (int i=0; i<n; i++)
		    nodes[i] = new Node();
    }
    
    void addLink(int a, int b, int c) {
		nodes[a].adj.add(new Edge(b,c));
    }

    // Algoritmo de Dijkstra
    boolean bell(int s) {
	
		//Inicializar nos como nao visitados e com distancia infinita
		for (int i=0; i<n; i++) {
		    nodes[i].distance = (Integer.MAX_VALUE)/2;
		    //nodes[i].visited  = false;
		}
	
		// Inicializar "fila" com no origem
		nodes[s].distance = 0;

		for(int i=0;i<=n;i++){
			for(int j=0;j<n;j++){
				for (Edge e : nodes[j].adj) {
					int v = e.to;
					int cost = e.weight;
					if (nodes[j].distance + cost < nodes[v].distance) {
					    nodes[v].distance = nodes[j].distance + cost;
					}
		    	}
			}
		}
		for(int i=0;i<n;i++){
		   for (Edge e : nodes[i].adj) {
				int v2 = e.to;
				int cost2 = e.weight;
				if (nodes[i].distance + cost2 < nodes[v2].distance) 
				    return true;
				
		    }
		}
		return false;
	}
    
};


public class Daa034 {
    public static void main(String args[]) {
		Scanner ler = new Scanner(System.in);
		int c2= ler.nextInt(); //numero de casos

		for(int i=0;i<c2;i++){
			int n1= ler.nextInt();//numero de sistemas
			Graph g = new Graph(n1);
			int   e1 = ler.nextInt();//numero de biracos
			for (int j=0; j<e1; j++) {
				int a= ler.nextInt();
				int b= ler.nextInt();
				int c= ler.nextInt();
			    g.addLink(a,b,c);
			}
			if(g.bell(0))
				System.out.println("possivel");
			else System.out.println("impossivel");

	
		}
		
    }
}