
package Graflar_uygulama_labaratuvar;


public class yigit {
    int y[];
    int ust;
    int N;
    public yigit(int N){
    ust=-1;
    y=new int[N];
    this.N=N;
    
    
    }
    boolean bosMu(){
    return ust==-1;
    
    }
    boolean doluMU(){
    return ust==N-1;
    
    }
    void push(int vertex){
    if(!doluMU()){
    ust++;
    y[ust]=vertex;
    }
     }
    int pop(){
    if(!bosMu()){
        ust--;
        return y[ust+1];
    
    
    }
    
    return -1;
    }
    
    int peek(){
    return y[ust];
    
    }
   
    
    
    
}
