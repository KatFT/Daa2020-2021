import java.util.TreeMap; // Mapas (associar valores a chaves)
import java.util.Map; // Para o tipo Map.Entry

public class Daa021{
	public static void main(String[] args){
		FastScanner ler= new FastScanner(System.in);
		int a= ler.nextInt();//qnt adiçoes
		int r= ler.nextInt();//qnt de remoçoes

		//criaçao treemap
		TreeMap<Integer,Integer> s= new TreeMap<>();
		for(int i=0;i<a+r;i++){
			String m=ler.next();

			if(m.equals("BAK")){
				int e= ler.nextInt();
				if(s.get(e)==null) //se ele ainda n existir pe a 1
					s.put(e,1);
				else{ //se ele existir so incrementa
					int cont= s.get(e);
					s.put(e,cont+1);
				}
			}
			else{
				if(m.equals("MIN")){
					int k= s.firstKey();//recebe key mais pequena
					int cont2=s.get(k);//ve o value dele
					s.put(k, cont2-1);
					System.out.println(k);
					if(s.get(k)==0)
						s.remove(k);
				}
				else if(m.equals("MAX")){
					int k=s.lastKey();//recebe key mais alta
					int cont3=s.get(k);//ve o value dele
					s.put(k,cont3-1);
					System.out.println(k);
					if(s.get(k)==0)
						s.remove(k);
				}
			}
		}
	}
}