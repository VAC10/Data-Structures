
package Graflar_uygulama_labaratuvar;
class eleman{
eleman ileri;
int icerik;

    public eleman(int icerik) {
        this.icerik=icerik;
        ileri=null;
    }
}
class Liste{
eleman bas=null;
eleman son=null;

void ListeyeElemanEkleme(int icerik){
eleman yeni=new eleman(icerik);
if(bas==null){
bas=yeni;
son=yeni;

}
else{
son.ileri=yeni;
son=yeni;
}



}
void ListeGoster(){
eleman yeni=bas;
while(yeni!=null){
    System.out.println(yeni.icerik+"");
    yeni=yeni.ileri;

}
}
int ElemanSayisiGoster(){
int elemanSayisi=0;
eleman yeni=bas;
while(yeni!=null){
elemanSayisi++;
yeni=yeni.ileri;

}
return elemanSayisi;

}





}
class Graf{
Liste[]kenar;
int N;
public Graf(int N){
this.N=N;
kenar=new Liste[N];
    for (int i = 0; i < N; i++) {
        kenar[i]=new Liste();
    }
}

 void kenarEkle(int baslangıç, int bitiş) {
        kenar[baslangıç].ListeyeElemanEkleme(bitiş);

    }
 
 
void kenarGoster(){
    for (int i = 0; i < N; i++) {
        System.out.println(">>");
        kenar[i].ListeGoster();
        System.out.println("");
        
    }


}
    void maxDerece() {
int maxderece=0;
int maxdugum=0;
        for (int i = 0; i < N; i++) {
            if(kenar[i].ElemanSayisiGoster()>maxderece){
            maxderece=kenar[i].ElemanSayisiGoster();
            maxdugum=i;
            }
            
        }
    }
boolean tamMı(){

    for (int i = 0; i < N; i++) {
        if(kenar[i].ElemanSayisiGoster()!=N-1)
            return false;
    }

return true;
}




}



public class graf {

 
    public static void main(String[] args) {
       Graf g=new Graf(5);
       g.kenarEkle(0, 1);
        g.kenarEkle(0, 3);
         g.kenarEkle(1, 0);
          g.kenarEkle(1,2);
          g.kenarEkle(0, 1);
                   
    }
    
}
