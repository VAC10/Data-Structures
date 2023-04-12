package STACK;
class dügüm{
int veri;
dügüm ileri;

public dügüm(int veri){
this.veri=veri;
ileri=null;

}   
}
class ygtBgl{
dügüm ust;
public ygtBgl(){
ust=null;

}
void ekle(int veri){
dügüm eleman =new dügüm(veri);
if(bosMu()){
ust=eleman;
}
else{
eleman.ileri=ust;
ust=eleman;
}
}
dügüm cikarma(){//tek yonlu listelerdeki baştan çıkarma işlemiyle aynı.
dügüm eleman=ust;//eleman adındaki nesnem üstü tutacak ki aşağıda döndürebileyim.
if(bosMu()==false)
    ust=ust.ileri;//en ustteki değerin sonrakini göstermesini istedik
return eleman; //ardından çıkarılan elemanı dönderdik


}


boolean bosMu(){
return ust==null;
}

void yazdir(){
dügüm temp=ust;
    System.out.println("Üst->");
while(temp!=null){
     System.out.println(temp.veri+" ");
     
temp=temp.ileri;
   
}




}
int enBuyukBul(){
dügüm tmp=ust;
int enb=ust.veri;
    while(tmp!=null){
        if(tmp.veri>enb){
            enb=tmp.veri;
        }
        tmp=tmp.ileri;
    }
System.out.println("En büyük sayı: "+enb);
    return enb;
}  
void ciftYazdir(){
    dügüm temp=ust;
    int sayac=0;
    while(temp!=null){
    
       if(temp.veri%2==0){
           sayac++;
           if(sayac==1){
         System.out.print("cift sayilar:");
           }
        System.out.print(temp.veri+",");
        }
     
temp=temp.ileri;
}
    
  
}
void tekYazdir(){
    dügüm temp=ust;
    int sayac=0;
    while(temp!=null){
       if(temp.veri%2==1){
           sayac++;
           if(sayac==1){
         System.out.print("  yığıttaki tek sayilar:");
           }
        System.out.print(temp.veri+",");
        } 
temp=temp.ileri;
}
}







}







public class Yigit_Bagli_Liste {

   
    public static void main(String[] args) {
        ygtBgl bagliListe=new ygtBgl();
          
        bagliListe.ekle(2);
        bagliListe.ekle(4);
        bagliListe.ekle(3);
        bagliListe.ekle(8);
        bagliListe.ekle(5);
        bagliListe.ekle(7);
        bagliListe.ekle(9);
        bagliListe.ekle(6);
        bagliListe.enBuyukBul();
   bagliListe.ciftYazdir();
   bagliListe.tekYazdir();
       bagliListe.yazdir();
    /* while(bagliListe.bosMu()==false){
         System.out.println(bagliListe.cikarma().veri);
     
     
     }*/
        
        
        
    }
    
}
