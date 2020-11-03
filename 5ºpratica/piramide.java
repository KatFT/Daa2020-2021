import java.util.*;
import java.lang.*;

public class piramide{
	static int max=105;
	static int n;
	static int[][] p = new int[max][max];


	public static void main(String[] args){
		Scanner ler= new Scanner(System.in);
		int n= ler.nextInt(); //tamanho array


		for(int i=1;i<=n;i++){
			for(int j=1;j<=i;j++){
				p[i][j]=ler.nextInt();
			}
		}
		for(int i=n-1;i>0;i--)
			for(int j=1;j<=i;j++){
				p[i][j]+=Math.max(p[i+1][j],p[i+1][j+1]);
			}
		System.out.println(p[1][1]);

		
	}
}