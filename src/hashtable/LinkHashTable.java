package hashtable;
/*
* 链地址法
* */
public class LinkHashTable {
    private class Node{
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
        public Integer getKey(){
            return data;
        }
        public void displayNode(){
            System.out.println(data+"");
        }
    }
    class SortedList{
        private Node first;
        public void insert(Node node){
            int key = node.getKey();
            Node parent=null;
            Node current=first;
            while (current.getKey()!=null&&key<current.getKey()){
                parent=first;
                current=current.next;
            }
            if (parent==null){

                first=node;
            }else {
                parent.next=node;

            }
            node.next=current;

        }
        public void delete(int key){
            Node parent=null;
            Node current=first;
            while (current.getKey()!=null){
                if(current.getKey()==key){
                    if(parent==null)
                        first=current.next;
                    else
                        parent.next=current.next;
                }
                current=current.next;

            }
        }
        public Node find(int key){
            Node parent=null;
            Node current=first;
            while (current.getKey()!=null){
                if (current.getKey()==key){
                    return current;
                }
                current=current.next;
            }
            return null;
        }
        public void display(){
            System.out.print("List(first-->last):");
            Node current=first;
            while (current!=null){
                current.displayNode();
                current=current.next;
            };
            System.out.println();
        }
    }
    private SortedList[] hashArray;
    private int arrSize;

    public LinkHashTable(int arrSize) {
        this.arrSize = arrSize;
        hashArray=new SortedList[arrSize];
        for (int i=0;i<arrSize;i++){
            hashArray[i]=new SortedList();
        }
    }

    public void displayTable(){
        for (int i=0;i<arrSize;i++){
            System.out.print(i+" ");
            hashArray[i].display();
        }
    }

    public int hashFun(int key){
        return key%arrSize;
    }

    public void insert(int i){
        Node node = new Node(i);
        int i1 = hashFun(i);
        hashArray[i1].insert(node);
    }

    public void delete(int key){
        int i = hashFun(key);
        hashArray[i].delete(key);
    }

    public Node find(int key){
        int i = hashFun(key);
        return hashArray[i].find(key);
    }

}
