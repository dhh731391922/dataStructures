package heap;
/*
* 堆排序:
*   原理：
*       将堆中的数据逐个删除然后放到数组中，在将其放到堆数组的最后一个
* */
public class Heapsort {
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
    private int maxSize;
    private int currentSize;

    public Heapsort(int maxSize) {
        this.maxSize = maxSize;
        heapArray=new Node[maxSize];
        currentSize=0;
    }
    public boolean isEmpty(){
        return currentSize==0;
    }

    public void insertAt(int index,Node newNode){
            heapArray[index]=newNode;
    }
    public void incrementSize(){
        currentSize++;
    }
    public Node remove(){
        Node root=heapArray[0];
        root=heapArray[--currentSize];
        sink(0);
        return root;
    }

    private void sink(int root) {
        int largerChild;
        Node top=new Node(root);
        while (root<currentSize/2){
            int leftChild=2*root+1;
            int rightChild=leftChild+1;
            if (rightChild<currentSize&&heapArray[rightChild].getData()>heapArray[leftChild].getData())
                largerChild=rightChild;
            else
                largerChild=leftChild;
            if (top.getData()>=heapArray[largerChild].getData())
                break;
            heapArray[root]=heapArray[largerChild];
            root=largerChild;
        }
        heapArray[root]=top;
    }

    public void displayHeap(){
        int nBlanks=32;//空格的输出
        int itemPerRow=1;//层数
        int column=0;//列
        int j=0;
        String dots=".................";
        System.out.println(dots+dots);
        while (currentSize>0){
            if (column==0)
                for (int k=0;k<nBlanks;k++)
                    System.out.print(" ");
            System.out.print(heapArray[j].getData() );
            if (++j==currentSize)
                break;//显示完了
            if(++column==itemPerRow){
                nBlanks/=2;
                itemPerRow*=2;
                column=0;
                System.out.println();
            }else
                for (int k=0;k<nBlanks*2-2;k++)
                    System.out.print(" ");
        }
        System.out.println("\n"+dots+dots);
    }

    public void displayArray(){
        for (int i=0;i<currentSize;i++)
            System.out.println(heapArray[i]);
        System.out.println();
    }

}
