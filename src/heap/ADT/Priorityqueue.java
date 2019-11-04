package heap.ADT;
/*
* 用堆来实现优先级对列:
*       堆特点：
*           1.是一个完全二叉树（除了最底层不是满的，其他层都是满的）
*           2.常常是用一个数组实现的
*           3.父节点的关键字要大于所有子节点（堆是弱序的）
*           O(log(n))
* */
public class Priorityqueue {
    private class Node{
        private int data;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }
    private Node[] heapArray;
    private  int maxSize;
    private int currentSize;

    public Priorityqueue(int maxSize) {
        this.maxSize = maxSize;
        heapArray=new Node[maxSize];
        currentSize=0;
    }

    public boolean isEmpty(){
        return currentSize==0;
    }

    public boolean insert(int key){
        if (currentSize==maxSize)return false;
        Node node = new Node(key);
        heapArray[currentSize]=node;//新加的节点放到数组的最后的位置
        floating(currentSize);//上浮
        currentSize++;
        return true;

    }

    private void floating(int currentSize) {
        int parent=(currentSize-1)/2;
        int current=currentSize;
        while (current>0&&heapArray[current].getData()>heapArray[parent].getData()){

            heapArray[current]=heapArray[parent];

            current=parent;
        }
        heapArray[current]=heapArray[currentSize];
    }

    public Node remove(){
        Node root=heapArray[0];
        heapArray[0]=heapArray[--currentSize];
        sink(0);
        return root;
    }

    private void sink(int index) {
        int largeChild;
        Node top=heapArray[index];
        while (index<currentSize/2){//如果为找到最后一层
            int leftChild=2*index+1;
            int rightChild=leftChild+1;
            if (rightChild<currentSize&&heapArray[rightChild].getData()>heapArray[leftChild].getData())
                largeChild=rightChild;
            else
                largeChild=leftChild;
            if (top.getData()>=heapArray[largeChild].getData())
                break;
            heapArray[index]=heapArray[largeChild];
            index=largeChild;
        }
        heapArray[index]=top;
    }
    public boolean change(int index,int newValue){
        if (index<0||index>=currentSize)
            return false;
        int old=heapArray[index].getData();
        heapArray[index].setData(newValue);
        if (old<newValue)
            sink(newValue);
        else
            floating(newValue);
        return true;
    }
    public void displayHeap(){
        System.out.print("HeapArray:");
        for (int m=0;m<currentSize;m++)
            if (heapArray[m]!=null)
                System.out.print(heapArray[m].getData()+" ");
            else
                System.out.print("--");
        System.out.println();


    }
}
