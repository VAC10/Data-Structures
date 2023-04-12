
package TREES;

import static java.lang.Integer.max;

class dugum{
int deger;
int yukseklik;
dugum sol;
dugum sag;
public dugum (int deger){
    this.yukseklik=0;
      this.deger=deger;
}
}
class avlTree{
dugum kok;
dugum ekle(dugum temp,dugum yeni){
    if(temp==null){
    return yeni;  
    }
    else{
    if(temp.deger>yeni.deger){
    temp.sol=ekle(temp.sol, yeni);
    
    }
    else{
    temp.sag=ekle(temp.sag, yeni);
    }
    
    }

temp.yukseklik= max(yukseklik(temp.sol),yukseklik(temp.sag));
int fark=yukseklik(temp.sol)-yukseklik(temp.sag);
if(fark>1&&yeni.deger<temp.sol.deger){
return sagaDondur(temp);
}
if(fark>1&&yeni.deger>temp.sol.deger){
temp.sol=solaDondur(temp.sol);
return sagaDondur(temp);

}
if(fark<-1&&yeni.deger<temp.sol.deger){
return solaDondur(temp);

}
if(fark<-1&&yeni.deger<temp.sol.deger){
temp.sol=solaDondur(temp.sol);
return sagaDondur(temp);
}
return temp;
}

int yukseklik(dugum y){
if(y==null)
return 0;
else
    return y.yukseklik;
}
dugum sagaDondur(dugum a){
dugum b=a.sol;
dugum c=b.sag;
a.sol=c;
b.sag=a;
a.yukseklik=max(yukseklik(a.sol),yukseklik(a.sag))+1;
a.yukseklik=max(yukseklik(b.sol),yukseklik(b.sag))+1;
return b;
}

dugum solaDondur(dugum a){
dugum b=a.sag;
dugum c=b.sol;
b.sol=a;
a.sag=c;
a.yukseklik=max(yukseklik(a.sol),yukseklik(a.sag))+1;
a.yukseklik=max(yukseklik(b.sol),yukseklik(b.sag))+1;
return b;
}
void preorder(dugum temp){
    if(temp!=null){
    System.out.println(temp.deger);
    preorder(temp.sol);
    preorder(temp.sag);}
}
}

public class AVL_Agacları {

   
    public static void main(String[] args) {
       avlTree avl=new avlTree();
       avl.kok=avl.ekle(avl.kok, new dugum(10));
       avl.kok=avl.ekle(avl.kok, new dugum(20));
       avl.kok=avl.ekle(avl.kok, new dugum(30));
       avl.kok=avl.ekle(avl.kok, new dugum(40));
       avl.kok=avl.ekle(avl.kok, new dugum(50));
        avl.kok=avl.ekle(avl.kok, new dugum(25));
       avl.preorder(avl.kok);
    }
    
}
