/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
class Tree {
    dugum kok;
    dugum agac;

    public Tree() {
        kok = null;
agac=null;
    }

    void ekle(int icerik) {
        dugum yeni = new dugum(icerik);
        dugum once = null;
        dugum temp = kok;
        while (temp != null) {
            once = temp;
            if (yeni.icerik < temp.icerik) {
                temp = temp.sol;
            } else {
                temp = temp.sag;

            }

        }
        if (once == null) {
            kok = yeni;
        } else if (yeni.icerik < once.icerik) {
            once.sol = yeni;
        } else {
            once.sag = yeni;
        }


    }

    dugum ara(int icerik) {
        dugum yeni = new dugum(icerik);
        dugum k = kok;
        while (k != null) {
            if (k.icerik == yeni.icerik) {
                return k;
            } else if (k.icerik > yeni.icerik) {
                k = k.sol;
            } else {
                k = k.sag;

            }

        }

        return null;
    }

    dugum minEleman(dugum d) {

        while (d.sol != null) {
            d = d.sol;

        }

        return d;
    }


    dugum maxEleman(dugum d) {
            
        while (d.sag != null) {
            d = d.sag;
        }
        return d;
    }


    dugum ataDondur() {// en kucuk elemanın atasını donduren kod
        dugum temp = kok;// en kucuk elemanı tutan gezici
        dugum once = kok;// ebeveyni  tutan gezici
        dugum ata = kok;//atayı tutan gezici
        while (temp.sol != null) {
            ata = once;
            once = temp;
            temp = temp.sol;


        }

        return ata;

    }


    /*
        void elemanSil(int icerik) {
            agac = silme(agac,icerik);
            }
        dugum silme(dugum agac, int icerik)
        {

            if (agac == null)
                return kok;

            // Otherwise, recur down the tree
            if (icerik< agac.icerik)
                agac.sol = silme(agac.sol, icerik);
            else if (icerik > agac.icerik)
                agac.sag = silme(agac.sag, icerik);

            // if key is same as root's
            // key, then This is the
            // node to be deleted
            else {
                // node with only one child or no child
                if (agac.sol == null)
                    return agac.sag;
                else if (agac.sag == null)
                    return agac.sol;

                // node with two children: Get the inorder
                // successor (smallest in the right subtree)
               // kok.icerik = minBul(kok.sag);

                // Delete the inorder successor
                agac.sag = silme(agac.sag, agac.icerik);
            }

            return agac;
        }
        void inorder() {
            inorderDolas(agac);


        }
        void inorderDolas(dugum agac) {
            if(agac!=null) {
                inorderDolas(agac.sol);
                System.out.println(agac.icerik+" ");
                inorderDolas(agac.sag);


            }


        }*/
    public void silme(int eleman) {
        agac= sil(agac, eleman);
    }

    public dugum sil(dugum agac, int eleman) {
        if (agac== null)
            return null;
        if (eleman < agac.icerik)
            agac.sol = sil(agac.sol, eleman);
        else if (eleman > agac.icerik) {
            agac.sag = sil(agac.sag, eleman);
        } 
        else {
            if (agac.sol != null && agac.sag != null) {

                dugum MinSag = minEleman(agac.sag);
                agac.icerik = MinSag.icerik;
                agac.sag = sil(agac.sag, MinSag.icerik);
                dugum MaxSol = maxEleman(agac.sol);
                agac.icerik = MaxSol.icerik;
                agac.sol = sil(agac.sol, MaxSol.icerik);
            } else if (agac.sol != null) {
                agac= agac.sol;
            } else if (agac.sag != null) {
                agac = agac.sag;

            } else {
                agac = null;
            }


        }
        return agac;
    }
    void inorder() {
        inorderDolas(agac);


    }
    void inorderDolas(dugum kok) {
        if (kok!= null) {
            inorderDolas(kok.sol);
            System.out.println(kok.icerik + " ");
            inorderDolas(kok.sag);


        }
    }

}
public class NewMain {

   
    public static void main(String[] args) {
          Tree agacyapisi = new Tree();
            agacyapisi.ekle(65);
            agacyapisi.ekle(30);
            agacyapisi.ekle(20);
            agacyapisi.ekle(40);
            agacyapisi.ekle(70);
            agacyapisi.ekle(60);
            agacyapisi.ekle(80);
            agacyapisi.ekle(25);
            agacyapisi.ekle(15);
            agacyapisi.ekle(9);
            agacyapisi.ekle(16);

            System.out.println("en kucuk elemanın atası:" + agacyapisi.ataDondur().icerik);
            //binary search tree yapısında eğer kok silinirse; kokun sağ alt ağacındaki en kucuk değer kok yerine geçer veya sol alt ağacındaki en buyuk değer gecer
            System.out.println("ağacımızın inorder dolaşım hali:");
            agacyapisi.inorder();
            agacyapisi.silme(65);
            System.out.println("ağacımızın 25 elemanının silindikten sonraki  dolaşım hali:");
            agacyapisi.inorder();

                agacyapisi.silme(50);
            System.out.println("ağacımızın 50 elemanının silindikten sonraki  dolaşım hali:");
            agacyapisi.inorder();
            System.out.println("kök:" + agacyapisi.kok.icerik);
            System.out.println("kökün solundaki eleman :" + agacyapisi.kok.sol.icerik);
            System.out.println("kökün sağındaki eleman :" + agacyapisi.kok.sag.icerik);
          // System.out.println("En küçük değer:" + agacyapisi.minBul().icerik);
            //System.out.println("En büyük değer:" + agacyapisi.maxBul().icerik);
            // System.out.println(agacyapisi.ara(7).icerik);
    }
    
}
