import java.util.*;
// neste exercicio tive a ajuda da colega Cheila Alves e da Rita Romani em questão de compreensão e aplicaçao do algoritmo

public class Daa006 {

    public static double resolve (double qx, double qy, double ql, double cx, double cy, double cr){
        double area = 0;
        double pi = 3.1415926535897;//temos de ter o nosso pi para a area do circulo
        
        //vamos agora ver para o caso q o quadrado esta dentro do circulo
        if((  Math.sqrt((qx- cx)*(qx- cx) + (qy- cy)*(qy- cy) ) <cr )&& ( Math.sqrt((qx- cx)*(qx- cx) + ((qy+ ql)- cy)*((qy+ ql)- cy) ) <cr) &&
        ( Math.sqrt(((qx+ql)- cx)*((qx+ql)- cx) + ((qy+ ql)- cy)*((qy+ ql)- cy) ) <cr) &&  ( Math.sqrt(((qx+ql)- cx)*((qx+ql)- cx) + ((qy)- cy)*((qy)- cy) ) <cr) ){
            return ql*ql;
        }
        //agora vemos para o caso do circulo dentro do quadrado
        else if(cx-cr>qx && cx +cr< qx+ql &&  cy-cr>qy && cy +cr< qy+ql  ){
            return pi * cr * cr;
            
        }
        //caso em q n se intersetam de td (vai ser literalmente a negaçao dos casos anteriores)
        
        else if ((  Math.sqrt((qx- cx)*(qx- cx) + (qy- cy)*(qy- cy) ) >cr )&& ( Math.sqrt((qx- cx)*(qx- cx) + ((qy+ ql)- cy)*((qy+ ql)- cy) ) >cr) &&
        ( Math.sqrt(((qx+ql)- cx)*((qx+ql)- cx) + ((qy+ ql)- cy)*((qy+ ql)- cy) ) >cr) &&  ( Math.sqrt(((qx+ql)- cx)*((qx+ql)- cx) + ((qy)- cy)*((qy)- cy) ) >cr) 
         && !(cx>qx && cx < qx+ql) && !(cy>qy && cy < qy+ql )){
            return 0;
        }
	//divisao do quadrado enquanto for grande o suficiente
        else if(ql>=0.001){
            ql /= 2;
            area +=  resolve(qx,qy+ql,ql,cx,cy,cr);//canto superior esquerdo
            area +=  resolve(qx+ql,qy+ql,ql,cx,cy,cr);//canto superior diretiro
            area += resolve(qx,qy,ql,cx,cy,cr);//canto inferior esquerdo
            area += resolve(qx + ql,qy,ql,cx,cy,cr);//canto inferior direito
            return area;
        }
    	return 0;        

    }

    public static void main(String[] args) {
       	Scanner ler=new Scanner(System.in);
		int n= ler.nextInt(); //numero de casos
        double qx,qy,ql,cx,cy,cr;
        double total;
        
        for(int i=0;i < n;i++){
            qx= ler.nextDouble();
	    	qy= ler.nextDouble();
	    	ql= ler.nextDouble();
	    	cx= ler.nextDouble();
	    	cy= ler.nextDouble();
	    	cr= ler.nextDouble();
            total = resolve(qx,qy,ql,cx,cy,cr);
            System.out.println(total);
        }
        
    }
    
}