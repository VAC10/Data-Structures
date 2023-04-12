
package Graflar_uygulama_labaratuvar;
class dugum{
char etiket;//düğümün adı
boolean visited;

public dugum(char etiket){
this.etiket=etiket;
visited=false;


}



}
class graf{
final int max_dug=20;//max dügüm sayısı
dugum dList[];// düğüm listesi
int komsulukMatris[][]; //komşuluk matrisi
int gdugum;//geçerli düğüm sayısı
public graf(){
dList=new dugum[max_dug];
komsulukMatris=new int [max_dug][max_dug];
gdugum=0;
for(int i=0; i<max_dug;i++)
    for(int j=0; j<dList.length;j++)
        komsulukMatris[i][j]=0;

}
void dugumEkle(char etiket){
dList[gdugum]=new dugum(etiket);
gdugum++;

}
void kenarEkle(int baslangıc,int bitis){
komsulukMatris[baslangıc][bitis]=1;
komsulukMatris [bitis][baslangıc]=1;

}
void dugumGoster(int vertex){
    System.out.println(dList[vertex].etiket);

}
String dereceGoster(int vertex){
int d=0;
    for (int i = 0; i < gdugum; i++) {
        if(komsulukMatris[vertex][i]==1)
            d++;
     
        
    }
        return dList[vertex].etiket+"dugum derecesi:"+d;

}
int ziyaretEdilmemis(int vertex){
    for (int i = 0; i < gdugum; i++) {
        if(komsulukMatris[vertex][i]==1&& dList[i].visited==false)
            return i; 
    }
return -1;
}
void dfs(){//gidilen düğümleri göserecek metod
dList[0].visited=true;
    dugumGoster(0);
    yigit y=new yigit(20);
    y.push(0);
    while(!y.bosMu()){
    int vertex=ziyaretEdilmemis(y.peek());
    if(vertex==-1){
   int cikan= y.pop();
        System.out.println("Çıkan :"+dList[cikan].etiket);
    }
    else{
    dList[vertex].visited=true;
        dugumGoster(vertex);
        y.push(vertex);
    }
    
    }
    for (int i = 0; i < gdugum; i++) {
        dList[i].visited=false;
    }


}











}


public class graf_uygulama {

  
    public static void main(String[] args) {
      graf g= new graf();
      g.dugumEkle('A');
      g.dugumEkle('B');
      g.dugumEkle('C');
      g.dugumEkle('D');
      g.dugumEkle('E');
      g.dugumEkle('F');
      
     g.kenarEkle(0, 1);
     g.kenarEkle(1,3);
     g.kenarEkle(1,5);
     g.kenarEkle(3,5);
     g.kenarEkle(2,3);
     g.kenarEkle(0,2);
     g.kenarEkle(2,4);
        System.out.println(g.dereceGoster(1));
        g.dfs();
     
    }
    
}
