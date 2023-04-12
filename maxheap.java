class mxheap{
    int heap[]; //heap isimli dizimizi oluşturduk
    int diziBoyut; //dizinin boyutu
    int maxBoyut;//dizinin max boyutu
    public mxheap(int maxBoyut){
        this.maxBoyut=maxBoyut;
        this.diziBoyut=0;
        heap=new int[this.maxBoyut];//boş bir heap yapısı oluşturuldu.

    }
int ebeveyn(int i){
        return(i/2);
    }

    int solCocuk(int i){
        return(2*i);
    }

    int sagCocuk(int i){
        return((2*i)+1);
    }
   void ekle(int eleman){
        if(diziBoyut>=maxBoyut){
return;
        }
        else{//dizi max boyuta ulaşmamışsa:
            heap[diziBoyut]=eleman;//dizinin sonuna yeni elemanı ekledik
            int siraNumara=diziBoyut;//son elemanın sıra numarası SiraNumara adlı değişkene atılmıştır.
            while (heap[siraNumara]>heap[ebeveyn(siraNumara)]){//Döngü içerisinde eklenen düğümün içeriği ile ebeveyninin içeriği karşılaştırılmış ve büyük ise MaxHeap özelliğinin sağlanması için swap metodu ile bu
                  swap(siraNumara,ebeveyn(siraNumara));          //düğümler yer değiştirilmiştir.
                    siraNumara=ebeveyn(siraNumara);


            }
diziBoyut++;

        }


    }
void swap(int icerik,int ebeveynİcerik){//Yer değiştirme yapılan swap metodunda verilen sıra numaralarındaki düğümlerin içerikleri
   // değiştirilmiştir.
        int temp;
        temp=heap[icerik];
        heap[icerik]= heap[ebeveynİcerik];
        heap[ebeveynİcerik]=temp;


}
//MaxHeap için en büyük değer kök düğümündedir. En büyük değeri silmek için ağaçtan kök
//düğümü çıkarmak gerekir. Kök düğüm dizinin 0 sıra numarasındadır. Bu değer bir değişkene
//alınarak geri döndürülür.
int extractMax(){
        int e=heap[0];
        heap[0]=heap[diziBoyut--];
        maxheapify(0);
        return e;



}
void maxheapify(int veri){
        if(yaprakMı(veri))
            return;
//Sıra numarası verilen düğüm yaprak değilse düzenleme yapılır. Eğer ilgili sıra numarasındaki
//düğümün sağ ve sol çocukları kendisinden büyük ise bu çocuklardan daha büyük olanı ile yer
//değiştirilir. Bu işlem sonucunda MaxHeap özelliği korunmuş olur.
        if(heap[veri]<heap[solCocuk(veri)]||heap[veri]<heap[sagCocuk(veri)]){
            if(heap[solCocuk(veri)]>heap[sagCocuk(veri)]){
                swap(veri,solCocuk(veri));
                maxheapify(solCocuk(veri));
            }
else{
    swap(veri,sagCocuk(veri));
    maxheapify(sagCocuk(veri));

            }


        }


}
int kMax(int k){
        for(int i=1;i<k;i++){
            extractMax();

        }
return extractMax();

}
//Kök düğümler yaprak düğümlerden büyük olduğundan minimum eleman yaprak düğümlerde
//aranmıştır. İlk olarak dizinin ortasındaki eleman minimum olarak belirlenmiş daha sonra
//dizinin ikinci yarısındaki elemanlar ile karşılaştırılmıştır. Daha küçük bir eleman bulunuyorsa
//minimum olarak değiştirilmiş ve bu eleman geri döndürülmüştür.
int enKucukElemanBul(){
        int min=heap[diziBoyut/2];
        for(int i=(diziBoyut/2)+1;i<diziBoyut;++i){
            if(heap[i]<min){
                min=heap[i];
            }

        }
    return min;
}
boolean yaprakMı(int veri){
        if(veri >=((diziBoyut-1)/2)&& veri <=(diziBoyut-1)){
        return  true;
        }
    return false;

}


}

public class maxheap {

    
    public static void main(String[] args) {
         mxheap mh=new mxheap(5);
        mh.ekle(7);
        mh.ekle(2);
        mh.ekle(1);
        mh.ekle(12);
        mh.ekle(9);

        System.out.println("dizideki en kucuk eleman:"+mh.enKucukElemanBul());
    }
    
}
