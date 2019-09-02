package linkedList;
/*
* 双向链表
* */
public class DoublyLinkedList {
    private class Node{
        public Node next;
        public Node previous;
        public int data;
        public Node(int i){
            data=i;
        }
    }
    private Node frist;
    private Node last;
    public DoublyLinkedList(){
        frist=null;
        last=null;
    }
    public Boolean isEmpty(){
        return frist==null;
    }

    /*
    * 增
    * */
    public void insertFrist(int i){
        Node node = new Node(i);
        node.next=frist;
        if (isEmpty())
            last=node;
        else
            frist.previous=node;
        frist=node;
    }
    public void insertLast(int i){
        Node node = new Node(i);

        if (isEmpty())
            frist=node;
        else{
            last.next=node;
            node.previous=last;
        }
        last=node;
    }
    /*
    * 在指定位置后插入
    * */
    public Boolean insert(int key,int ne){
        Node tem=frist;
        Node node = new Node(ne);
        while (tem!=null){
            if (tem.data==key){
                if (tem==last){
                    tem.next=node;
                    node.previous=tem;
                    tem=node;
                }else {
                    tem.next.previous=node;
                    node.next=tem.next;
                    tem.next=node;
                    node.previous=tem;
                }
            }
            tem=tem.next;
        }
        return false;
    }
    /*
    * 删
    * */
    public int removeFirst(){
        int tem=frist.data;
        if (frist.next==null)
            last=null;
        else
            frist.next.previous=null;
        frist=frist.next;
        return tem;
    }
    public int removeLast(){
        int tem=last.data;
        if (last.previous==null)
            frist=null;
        else
            last.previous.next=null;
        last=last.previous;
        return tem;
    }
    /*
    删除指定的数
    * */
    public Boolean remove(int key){
        Node tem=frist;
        while (tem!=null){
            if (tem.data==key){
                if (tem==frist){
                    tem.next.previous=null;
                    tem=tem.next;
                    return true;
                }
                if (tem==last){
                    tem.previous.next=null;
                    tem=tem.previous;
                    return true;
                }
                tem.previous.next=tem.next;
                tem.next.previous=tem.previous;
                return true;

            }

        }
        return false;
    }

    /*
    * 迭代器
    * */
    
}
/*
* 在双向链表的前后各加一个空节点；
* */
class version2{
    private class Node{
        public Node next;
        public Node previous;
        public int data;
        public Node(int i){
            data=i;
        }

        public Node(Node next, Node previous, Integer data) {
            this.next = next;
            this.previous = previous;
            this.data = data;
        }
    }
    private Node frist1;
    private Node frist;
    private Node last1;
    private Node last;

    public version2(){
        frist1=new Node(null,last,null);
        last1=new Node(frist,null,null);
        frist=null;
        last=null;
    }
    /*
    * 增
    * */
    public void addFrist(int i){
        Node node = new Node(i);

    }
    public void addLast(int i){

    }
}
