
package STACK;
class yigitlar{
int dizi[];
int ust;
int n;
public yigitlar(int n){
    this.n=n;
dizi=new int[n];
ust=-1;
}
boolean bosmu(){
    return ust==-1;
}
boolean doluMu(){
return ust==n-1;
}
void ekle(int yeni){

if (!doluMu()){
ust++;
dizi[ust]=yeni;
}
}
int cikar(){

if(!bosmu()){
 ust--;
return dizi[ust+1];// çıkarttığım elemanı return ettim
}
return -1;//eğerki dizi boşsa boş değeri döndür! ! !
}
int top(){//elemanı silmeden en üstteki elemanı gösterir
    if(!bosmu()){
    return dizi[ust];   
    }
  else return 0;

}

void enbbuyukBul(){
int enbuyuk=dizi[0];
for(int i=0;i<n;i++){
if(dizi[i]>enbuyuk){
enbuyuk=dizi[i];
}
}
    System.out.println("yığıt dizisnin en buyuk elemanı:"+enbuyuk);

}

void ciftbul(){
  
 for (int i =ust; i>=0; i--) {
     
            if(dizi[i]%2==0){
               
                System.out.print("cift sayılar:");
               
            }
           System.out.println(dizi[i]);
            
        }
        

}

    void yazdir(){
        for (int i =ust; i>=0; i--) {
            System.out.println(dizi[i]+" ");
        }
    }
    


}
 


   

public class yigit_DİZİ_İLE {

    
    public static void main(String[] args) {
        
        yigitlar ygt=new yigitlar(10);
        ygt.ekle(1);
        ygt.ekle(5);
        ygt.ekle(7);
        ygt.ekle(10);
        ygt.ekle(20);
        ygt.ciftbul();
        ygt.enbbuyukBul();
       ygt.cikar();
       
        ygt.yazdir();
        
       
       
        /*
        for(int i=0;i<10;i++){
            ygt.ekle(i);
        }
        
        while(!ygt.bosmu()){
            System.out.println(ygt.cikar().icerik);
         
        }
        System.out.println("elemanlar"+ygt.top());//yiğıt doluyken yazar*/
    }
    
}

