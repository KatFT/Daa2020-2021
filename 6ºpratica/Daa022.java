// Codigo inicial para o problema [DAA 022] Arvores Red-Black
// Pedro Ribeiro (DCC/FCUP)

import java.util.Scanner;

// Estrutura para representar um no da arvore
class Node {
    boolean isBlack;  // No preto?
    boolean isNull;   // No nulo?
    int value;        // Valor
    Node left, right; // Filhos

    Node(int v) {
		isNull  = (v==0);
		isBlack = (v>=0);
		value   = Math.abs(v);
    }
}

public class Daa022 {

    // Ler input em preorder
    static Node readPreOrder(Scanner in) {
		int v = in.nextInt();
		Node aux = new Node(v);
		if (v!=0) {
		    aux.left  = readPreOrder(in);
		    aux.right = readPreOrder(in);
		}
		return aux;
    }

    // Menor valor da arvore
    static int minimum(Node t) {
		if (t.isNull) return Integer.MAX_VALUE;
		int minLeft  = minimum(t.left);
		int minRight = minimum(t.right);
		return Math.min(t.value, Math.min(minLeft, minRight));
    }

    // Maior valor da arvore
    static int maximum(Node t) {
		if (t.isNull) return Integer.MIN_VALUE;
		int minLeft  = maximum(t.left);
		int minRight = maximum(t.right);
		return Math.max(t.value, Math.max(minLeft, minRight));
    }

    // Quantidade de nos (internos)
    static int size(Node t) {
		if (t.isNull) return 0;
		return 1 + size(t.left) + size(t.right);
    }

    // ---------------------------------------------------
    //verifica root property
    public static boolean rootProperty(Node t){
    	if(t.isBlack) //raiz tem de ser preta
    		return true;
    	return false;
    }

    //verifica red property
    public static boolean redProperty(Node t){
    	if(t.isNull) return true;
    	//como n ha isREd usamos o !isBlack
    	if(!(t.isBlack)){ //verificamos se o da esq e prto e a direita e preto
    		if(!(t.left.isNull) && !(t.left.isBlack)) return false;
    		if(!(t.right.isNull) && !(t.right.isBlack)) return false;

    	}
    	return true && redProperty(t.left) && redProperty(t.right);
    }

    public static boolean blackProperty(Node t, int blackH, int cont){
    	//qnd chega a um null
    	if(t.isNull) return cont==blackH;//verifica se o cont tem o msm q o bh
    	if(t.isBlack) cont++; //encontra um preto incrementa
    	return blackProperty(t.left,blackH,cont) && blackProperty(t.right, blackH,cont);

    }

    public static boolean binaryST(Node t, int max, int min){
    	if(t.isNull) return true;
    	if(t.value<min || t.value>max)
    		return false;
    	//para left o max vai ser maior valor menor q o value e para right o min vai ser primeiro maior valor
    	return binaryST(t.left, t.value-1, min) && binaryST(t.right,max,t.value+1);
    }

    //calcula bh
    public static int blackHeight(Node t){
    	int cont=0;
    	while(!(t.isNull)){//enquanto n chegar as leafs
    		t= t.left; //seguimos para a esquerda
    		if(t.isBlack) cont++; //se encontramos um no preto aumenta
    	}
    	return cont;
    }


    public static void main(String args[]) {
		Scanner ler = new Scanner(System.in);
		
		int n =  ler.nextInt(); //qnt de arv a considerar
		for (int i=0; i<n; i++) {
		    Node root = readPreOrder(ler);
		    int blackH= blackHeight(root); //da-nos o nº de nos pretos de um caminho ate a raiz
		    //agora verificamos as regras
		    //se e root property, red property, black property e BST
		    if(rootProperty(root) && redProperty(root) && blackProperty(root,blackH,0) && binaryST(root,Integer.MAX_VALUE,Integer.MIN_VALUE))
		    	System.out.println("SIM");
		    else
		    	System.out.println("NAO");
		}	
    }
}