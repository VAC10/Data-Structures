
package Graflar_uygulama_labaratuvar;
class dijkstra{ //dijkstra algoritması
int dugum_sayisi=9;
int minMesafe(int [] mesafe,boolean []ziyaret){
int min=Integer.MAX_VALUE,min_indis=-1;
    for (int v = 0; v < dugum_sayisi; v++) {
        if(ziyaret[v]==false&&mesafe[v]<=min){
        min=mesafe[v];
        min_indis=v;
        
        
        }
        
    }
return  min_indis;

}
void cozumGoster(int mesafe[]){
    System.out.println("Çözüm:");
    for (int i = 0; i < dugum_sayisi; i++) {
        System.out.println(i+"\t\t"+mesafe[i]);
    }
}
void dijkstraAlg(int graf[][],int bas){
boolean ziyaret[]=new boolean[dugum_sayisi];
int mesafe[]=new int[dugum_sayisi];
        for (int i = 0; i < dugum_sayisi; i++) {
        mesafe[i]=Integer.MAX_VALUE;
        ziyaret[i]=false;
    }
mesafe[bas]=0;
    for (int sayac = 0; sayac <dugum_sayisi-1 ; sayac++) {
        int u=minMesafe(mesafe, ziyaret);
        ziyaret[u]=true;
        for (int v = 0; v < dugum_sayisi; v++) {
            if(!ziyaret[v]&&graf[u][v]!=0&&mesafe[u]!=Integer.MAX_VALUE&&mesafe[u]+graf[u][v]<mesafe[v])
                mesafe[v]=mesafe[u]+graf[u][v];
        }
    }
    cozumGoster(mesafe);
}




}

public class graf_uygulama2 {

   
    public static void main(String[] args) {
       int graf[][]={{0,4,0,0,0,0,0,8,0},{4,0,8,0,0,0,0,11,0},
          {0,8,0,7,0,4,0,0,2},
          {0,0,7,0,9,14,0,0,0},
          {0,0,0,9,0,10,0,0,0},
          {0,0,4,14,10,0,2,0,0},
          {0,0,0,0,0,2,0,1,6},
          {8,11,0,0,0,0,1,0,7},
           {0,0,2,0,0,0,6,7,0} };
       
          dijkstra d=new dijkstra();
          d.dijkstraAlg(graf, 0);
       }
    }
    

