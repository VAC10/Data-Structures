
package TREES;
class dugum{
int icerik;
dugum sag;
dugum sol;

    public dugum(int icerik) {
        this.icerik=icerik;
        sol=null;
        sag=null;
    }

}
class agac{
dugum kok;
public agac(){
kok=null;
}

void ekle(int icerik){
dugum yeni=new dugum(icerik);
dugum once=null;
dugum temp =kok;
while(temp!=null){
once=temp;
if(yeni.icerik<temp.icerik){
temp=temp.sol;  
}
else{
temp=temp.sag;
}
}
if(once==null){ //ağacta hiç eleman yoktur, boşsa yeniyi köke ata
kok=yeni; 
}
else if(yeni.icerik<once.icerik){
once.sol=yeni;
}
else{
once.sag=yeni;
}
}
dugum ara( int icerik){
dugum yeni=new dugum(icerik);
dugum k=kok;
while(k!=null){
if(k.icerik==yeni.icerik){ 
return k;
}
else if(k.icerik>yeni.icerik){
k=k.sol;

}
else{
k=k.sag;

}

}
return null;
}
dugum minBul(){
dugum temp=kok;
while(temp.sol!=null){ // temp nın solu null'a düşene kadar sola git.!
temp=temp.sol;
return temp;
}
return null;

}
dugum maxBul(){
dugum temp=kok;
while(temp.sag!=null){ // temp nın solu null'a düşene kadar sola git.!
temp=temp.sag;
return temp;
}
return null;

}
 public void silme(int eleman) {
        kok = sil(kok, eleman);
    }

    public dugum sil(dugum kok, int eleman) {
        if (kok == null)
            return null;
        if (eleman < kok.icerik)
            kok.sol = sil(kok.sol, eleman);
        else if (eleman > kok.icerik) {
            kok.sag = sil(kok.sag, eleman);
        } else {
            if (kok.sol != null && kok.sag != null) {

                dugum MinSag = minBul(kok.sag);
                kok.icerik = MinSag.icerik;
                kok.sag = sil(kok.sag, MinSag.icerik);
                dugum MaxSol = maxBul(kok.sol);
                kok.icerik = MaxSol.icerik;
                kok.sol = sil(kok.sol, MaxSol.icerik);
            } else if (kok.sol != null) {
                kok = kok.sol;
            } else if (kok.sag != null) {
                kok = kok.sag;

            } else {
                kok = null;
            }


        }
        return kok;
    }
    void inorder() {
        inorderDolas(kok);


    }
    void inorderDolas(dugum kok) {
        if (kok!= null) {
            inorderDolas(kok.sol);
            System.out.println(kok.icerik + " ");
            inorderDolas(kok.sag);


        }
    }
void preorder(){


}





}
public class İkili_Arama_Ağacı {

    public static void main(String[] args) {
       agac agacyapisi=new agac();
       agacyapisi.ekle(8);
       agacyapisi.ekle(7);
       agacyapisi.ekle(10);
        agacyapisi.ekle(100);
         agacyapisi.ekle(170);
          agacyapisi.ekle(1);
        System.out.println("kökün solundaki eleman :"+agacyapisi.kok.sol.icerik);
        System.out.println("kök:"+agacyapisi.kok.icerik);
        System.out.println("kökün sağındaki eleman :"+agacyapisi.kok.sag.icerik);
        System.out.println(agacyapisi.ara(7).icerik);
        System.out.println("En küçük değer:"+agacyapisi.minBul().icerik);
           System.out.println("En büyük değer:"+agacyapisi.maxBul().icerik);
    }
    
}
