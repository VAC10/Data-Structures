
package Hash;
//LİNEAR PROBİNG
class hash{
 int tablo[]=new int[10];
 int hashFonksiyonu (int anahtar){
 return anahtar%10;
 
 
 }
 void veriEkle(int anahtar)
 {
     int indis=hashFonksiyonu(anahtar);// sayının 10 ile bölümünden kalan benim indisimi versin.
 while(tablo[indis]!=0){ //tablonun indisi boş olmadığı sürece indisi bir arttır
 indis=(indis+1)%10;

 }
 tablo[indis]=anahtar;
 } 
 void listele(){
     for (int i = 0; i < 10; i++) {
         System.out.print(tablo[i]+" ");
     }
 
 
 }
int ara(int anahtar){
     int indis=hashFonksiyonu(anahtar);
     if(anahtar==tablo[indis])   {
         return indis;}
     else{
     while(tablo[indis]!=0){
     indis=(indis+1)%10;
     if(anahtar==tablo[indis]){
     return indis;
     }
     
     }
         
         
     }
 return -1;
 }

void sil(int anahtar){
 int indis=ara(anahtar);
 if(tablo[indis]!=-1&&tablo[indis]!=0){
     tablo[indis]=-1;
 
 }
 
 
 
 
 }
}

public class hash_uygulama {


    public static void main(String[] args) {
      hash h=new hash();
      h.veriEkle(15);
      h.veriEkle(18);
      h.veriEkle(8);
       h.veriEkle(19);
       h.veriEkle(5);
        System.out.println("aranan eleman "+h.ara(15)+". indistedir.");
        h.sil(5);
      h.listele();
      //h.veriEkle(15);
    }
    
}
