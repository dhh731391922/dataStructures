package linkedList;
/*
* 有序链表
*
* */
public class OrderLinkedList {
    private class Node{
        public int data;
        public Node next;
        public Node(int i){
            data=i;
        }

    }
    private Node frist;
    public OrderLinkedList(){
        frist=null;
    }
    /*
    * 增
    * */
    public void insert(int i){
        Node node = new Node(i);
        Node current=frist;
        Node previous=null;//frist的前一个是空
        while (current!=null&& current.data<i){
           previous=current;
           current=current.next;
        }
        if (previous==null)
            frist=node;
        else
            previous.next=node;
        node.next=current;
    }
    /*
    * 删
    * */
    public int removeFrist(){
        int tem=frist.data;
        frist=frist.next;
        return tem;
    }
    /*
    * 查
    * */
    public void display(){
        Node tem=frist;
        while (tem!=null){
            System.out.print(tem.data);
            tem=tem.next;
        }
        System.out.println();
    }

}
