package queue;
/*
* 优先队列
* */
public class Priorityqueue {
    private int[] pq;
    private int maxSize;
    private int size;
    public Priorityqueue(int s){
        maxSize=s;
        pq=new int[maxSize];
        size=0;
    }
    public void insert(int value){
        if (size==0)
            pq[size]=value;
        int j;
        for (j=size-1;j>=0;j--){
            if (value>pq[j]){
                pq[j+1]=pq[j];
            }else
                break;
        }
        pq[j+1]=value;
        size++;
    }
    public int remove(){
        return pq[--size];
    }
    public int peekMin(){
        return pq[size-1];
    }

    public Boolean inEmpty(){
        return size==0;
    }

    public Boolean isFull(){
        return size==maxSize;
    }

}
