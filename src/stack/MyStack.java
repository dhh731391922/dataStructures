package stack;

public class MyStack {
    private final int[] stackArray;
    private int maxSize;
    private int top;

    public MyStack(int s) {
        maxSize=s;
        this.stackArray = new int[maxSize];

        this.top = -1;
    }
    public void push(int value){
        stackArray[++top]=value;
    }
    public int pop(){
        return stackArray[top--];
    }
    public int peek(){
        return stackArray[top];
    }
    public Boolean isEnpty(){
        return top==-1;
    }
    public Boolean isFull(){
        return top==(maxSize-1);
    }
}
