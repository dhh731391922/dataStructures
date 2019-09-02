package queue;
/*
* 普通队列
* */
public class MyQueue {
    private int[] que;
    private int maxSize;
    private int size;
    private int front;
    private int rear;
    public MyQueue(int s){
        maxSize=s;
        que=new int[maxSize];
        front=0;
        rear=-1;
        size=0;
    }
    public void insert(int value){
        if (rear==maxSize)
            rear=-1;
        que[++rear]=value;
        size++;

    }
    public int remove(){
        int tem=que[front++];
        if (front==maxSize)
            front=0;
        size--;
        return tem;
    }
    public int peekFront(){
        return que[front];
    }
    public Boolean isEmoty(){
        return size==0;
    }
    public Boolean isFull(){
        return size==maxSize;
    }
    public int size(){
        return size;
    }

}
