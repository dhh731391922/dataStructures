package linkedList.ADT;
/*
* 用单链表实现栈
* */
public class MyLinkedStack {
    private class SingleLinkedList{
        private class Node{
            public int data;
            public Node next;
            public Node(int i){
                data=i;
            }
        }
        private Node first;
        private int size;
        public SingleLinkedList(){
            first=null;
            size=0;
        }

        public Boolean isEmpty(){
            return first==null;
        }
        public void addFirst(int i){
            Node node = new Node(i);
            node.next=first;
            first=node;

        }
        public int removeFirst(){
            int data = first.data;
            first=first.next;
            return data;
        }
        public int findFirst(){
            return first.data;
        }
    }
    private SingleLinkedList stack;
    public MyLinkedStack(){
        stack=new SingleLinkedList();
    }
    public void push(int i){
        stack.addFirst(i);
    }
    public int pop(){
        return stack.removeFirst();
    }
    public Boolean isEmpty(){
        return stack.isEmpty();
    }
    public int peek(){
        return stack.findFirst();
    }
}
