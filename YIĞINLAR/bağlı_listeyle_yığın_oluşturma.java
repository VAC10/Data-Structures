
package YIĞINLAR;
class dügüm{
dügüm ileri;
int icerik;
public dügüm(int icerik){
this.icerik=icerik;
ileri=null;
}


}
class yigitBagliListe{
 
dügüm ust; //yığıt yapısını oluşturuyoruz

public yigitBagliListe(){
ust=null;//ilk başta yığınımızın içi boş

}
boolean bosMu(){
if(ust==null){
return true;
}
return false;

}
public void ekle(int icerik){
dügüm eleman=new dügüm(icerik);
if(bosMu()){//eğerki yığıt boşsa
ust=eleman;

}
else{//yığıt doluysa
eleman.ileri=ust; //başa alır gibi yaptık(burada yeni eklediğimiz elemanla üstü bağladık)
ust=eleman;//ardından elemanımızı üste atadık.
 

}


}




dügüm cikarma(){//tek yonlu listelerdeki baştan çıkarma işlemiyle aynı.
dügüm eleman=ust;//eleman adındaki nesnem üstü tutacak ki aşağıda döndürebileyim.
if(bosMu()==false)
    ust=ust.ileri;//en ustteki değerin sonrakini göstermesini istedik

return eleman; //ardından çıkarılan elemanı dönderdik


}

void ciftYazdir(){
    dügüm temp=ust;
    int sayac=0;
    while(temp!=null){
    
       if(temp.icerik%2==0){
           sayac++;
           if(sayac==1){
         System.out.print("cift sayilar:");
           }
        System.out.print(temp.icerik+",");
        }
     
temp=temp.ileri;
}
    
  
}
void tekYazdir(){
    dügüm temp=ust;
    int sayac=0;
    while(temp!=null){
    
       if(temp.icerik%2==1){
           sayac++;
           if(sayac==1){
         System.out.print("  yığıttaki tek sayilar:");
           }
        System.out.print(temp.icerik+",");
        }
     
temp=temp.ileri;
}



}
void yazdir(){
    if(bosMu()){
        System.out.println("yığıt boş");
    }
   dügüm temp=ust;
    System.out.println("Üst->");
while(temp!=null){
    
     System.out.println(temp.icerik+" ");
     
temp=temp.ileri;
   
}


}


    
}


public class bağlı_listeyle_yığın_oluşturma {

  
    public static void main(String[] args) {
     yigitBagliListe yigitbgl =new yigitBagliListe();
     yigitbgl.ekle(10);
      yigitbgl.ekle(20);
         yigitbgl.ekle(8);
           yigitbgl.ekle(13);
           yigitbgl.ekle(7);
       // System.out.println(yigitbgl.cikarma().icerik);
         /* yigitbgl.ekle(8);
           yigitbgl.ekle(13);
           yigitbgl.ekle(7);*/
  yigitbgl.ciftYazdir();
  yigitbgl.tekYazdir();
  yigitbgl.yazdir();
        
          
      while(yigitbgl.bosMu()==false){//yığıtın içi boşalana kadar çıkartma işlemine devam et demektir
          
          
              System.out.println(yigitbgl.cikarma().icerik);
            
        }
      
    }
    
}
