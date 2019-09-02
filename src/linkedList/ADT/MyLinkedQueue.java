package linkedList.ADT;
/*
* 用双端链表实现队列
*
* */
public class MyLinkedQueue {
    private class DoubleSideLinkedList{
        private class Node{
            public int data;
            public Node next;

            public Node(int i){
                data=i;

            }
        }
        private Node frist;
        private Node last;
        private int size;
        public DoubleSideLinkedList(){
            frist=null;
            last=null;
            size=0;
        }
        public Boolean isEmpty(){
            return frist==null;
        }
        public void addLast(int i){
            Node node = new Node(i);
            if (isEmpty())
                frist=node;
            else
                last.next=node;
            last=node;
        }
        public int removeFrist(){
            int tem=frist.data;
            if (frist.next==null)
                last=null;
            frist=frist.next;
            return tem;
        }
        public int findFrist(){
            return frist.data;
        }
    }
    private DoubleSideLinkedList que;
    public MyLinkedQueue(){
        que=new DoubleSideLinkedList();
    }
    public void insert(int i){
        que.addLast(i);
    }
    public int remove(){
        return que.removeFrist();
    }
    public int peekFront(){
        return que.findFrist();
    }
}
