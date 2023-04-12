
package KUYRUK_QUEUE;
class dügüm{
int icerik;
dügüm ileri;
public dügüm(int icerik){
this.icerik=icerik;
ileri=null;
}
}





  

public class kuyruk {
dügüm bas;
dügüm son;
String s;
public kuyruk(){
bas=null;
son=null;
s="";
}
boolean bosmu(){
if(bas==null){
    return true;
}
    return false;
}
void ekle(dügüm eleman){   
if(!bosmu()){// kuyruk boş değilse
son.ileri=eleman;
son=eleman;
    
}
else{//kuyruk boşsa
bas=eleman;
son=eleman;
}
s=s+eleman.icerik;// eklenen elemanın bilgisini s te tuttum. labelda yazdrımak için
}
dügüm cikar(){ // return etmek için bu şekilde tanımladım
dügüm sonuc=bas;
if(!bosmu()){
bas=bas.ileri;
s=s.substring(1, s.length());
if(bas==null){

}
}return sonuc;

}
void basaEkle(){




}
// bu kuyruktaki en büyügünü bulup yazdır 
//girilen Stringi













    public static void main(String[] args) {
       
    }
    
}
        
            