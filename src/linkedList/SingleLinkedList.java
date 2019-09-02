package linkedList;
/*
* 单链表
* 链表的箭头指向哪边，哪边就应该设置一个空节点
* */
public class SingleLinkedList {
    private class Node{
        public int data;
        public Node next;

        public Node(Integer data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(Integer data) {
            this.data = data;
        }
    }
    private Node frist;
    private int size;
    public SingleLinkedList(){
        frist=new Node(null);
        size=0;
    }
    public Boolean isEmpty(){
        return size==0;
    }
    /*
    * 增
    * */
    public void add(int i){
        Node node = new Node(i);
        node.next=frist.next;
        frist.next=node;
        size++;
//        node.next=frist;
//        frist=node;
    }
    /*
    * 删
    * */
    public Integer removeFrist(){
        Node next = frist.next;
        frist.next=frist.next.next;
        return next.data;
//        frist=frist.next;
    }
    public Boolean remove(int i){
        Node tem=frist;
        Node temn=frist.next;
        while (tem.next!=null){
            if (temn.data==i){
                tem.next=tem.next.next;
                return true;
            }
        }
        return false;
    }
    /*
    * 改
    * */
    public Boolean replace(int old ,int ne){
        Node tem=frist;
        while (tem.next!=null){
            if (frist.data==old){
                frist.data=ne;
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
        Node tem=frist;
        while (tem.next!=null){
            System.out.print(tem.data+" ");
            tem=tem.next;
        }
        System.out.println();
    }
}
