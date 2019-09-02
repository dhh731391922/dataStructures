package linkedList;

/*
* 双端链表
* */
public class DoubleSide_LinkedList {
    private class Node{
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node() {
        }

        public Node(int i) {
            data=i;
        }
    }
    private Node first;
    private Node last;
    private int size;
    public DoubleSide_LinkedList(){
        first=null;
        last=null;
        size=0;
    }
    public Boolean isEmpty(){
        return first==null;
    }
    /*
    增
    * */
    public void insertFirst(int i){
        Node node = new Node(i);
        node.next=first;
        if (isEmpty())
            last=node;
        first=node;
        size++;
    }
    public void insertLast(int i){
        Node node = new Node(i);
        if (isEmpty())
            first=node;
        else //一定要加else如果不为空
            last.next=node;
        last=node;
        size++;
    }

    /*
    * 删
    * */
    public int removeFirst(){
        int tem=first.data;
        if (first.next==null)
            last=null;
        first=first.next;
        size--;
        return tem;
    }
    /*改
    * */
    public Boolean replace(int old,int ne){
        Node tem=first;
        while (tem!=null){
            if (tem.data==old){
                tem.data=ne;
                return true;
            }
            tem=tem.next;
        }
        return false;
    }
    /*
    * 查
    * */
    public void display(){
        Node tem=first;
        while (tem!=null){
            System.out.print(tem);
            tem=tem.next;
        }
        System.out.println();
    }
}
