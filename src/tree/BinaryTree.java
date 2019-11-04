package tree;

import java.util.Stack;

/*
* 二叉查找树
* */
public class BinaryTree {
    private class Node{
        public int data;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Node(int data) {
            this.data = data;
        }
    }
    private Node root;

    public BinaryTree() {
        this.root = null;
    }
    /*
    * 增
    * */
    public void insert(int i){
        Node node = new Node(i);


        if (root==null)
            root=node;
        else {
            Node current=root;
            Node parent;
            while (true){
                parent=current;
                if (current.data>i){
                    current=current.left;
                    if (current==null){
                        parent.left=node;
                        break;
                    }
                }else {
                    current=current.right;
                    if (current==null){
                        parent.right=node;
                        break;
                    }
                }

            }
        }

    }

    /*
    * 删
    * */
    public boolean delete(int key){
        Node current=root;
        Node parent=root;
        boolean isLeftChild=true;
        while (current.data!=key){
            parent=current;
            if(key<current.data){
                isLeftChild=true;
                current=current.left;
            }else {
                isLeftChild=false;
                current=current.right;
            }
            if (current==null)
                return false;
        }
        if (current.left==null&&current.right==null){//删除的是叶子节点
            if (current==root)
                root=null;
            else if (isLeftChild){  //删除的数据时期父节点的左子节点
                parent.left=null;
            }else {
                parent.right=null;
            }
        }else if (current.right==null){//删除的数据只有一个左子节点
            if (current==root)
                root=current.left;
            else if (isLeftChild)
                parent.left=current.left;
            else
                parent.right=current.left;
        }else if (current.left==null){ //删除的数据只有一个有子节点
            if (current==root)
                root=current.right;
            else if (isLeftChild)
                parent.left=current.right;
            else
                parent.right=current.right;
        }else {//要删除的节点左右都有节点
            Node successor= getSuccessor(current);
            if (current==root){
                root=successor;
            }else if (isLeftChild){
                parent.left=successor;
            }else
                parent.right=successor;
            successor.left=current.left;

        }
        return true;

    }

    private Node getSuccessor(Node current) {
        Node successorParent=current;
        Node successor=current.right;
        while (successor.left!=null){
            successorParent=successor;
            successor=successor.left;
        }
        if (successor!=current.right){
            successorParent.left=successor.right;
            successor.right=current.right;
        }
        return successor;
    }
    /*
    * 查
    * */
    public Node find(int key){
        Node current=root;
        while (current!=null){
            if (current.data==key)
                return current;
            else if (current.data<key)
                current=current.right;
            else
                current=current.left;
        }
        return null;
    }
    public void traverse(int traverseType){
        switch (traverseType){
            case 1:
                preOrder(root);
                break;
            case 2:
                inOrder(root);
                break;
            case 3:
                postOrder(root);
                break;
        }
    }

    private void postOrder(Node root) {//从下到上从右到左(从大到小)
        if (root!=null){
            postOrder(root.right);
            System.out.print(root.data+" ");
            postOrder(root.left);
        }
    }

    private void inOrder(Node root) {//从下到上从左到右(从小到大)
        if (root!=null){
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
    }

    private void preOrder(Node root) {//从上到下，重左到右的便利
        if(root!=null){
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void displyTree(){
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks=32;
        boolean isRowEmpth=false;
        System.out.println("--------------------------------------");
        while (isRowEmpth==false){
            Stack localStack = new Stack();
            isRowEmpth=true;
            for (int j=0;j<nBlanks;j++){
                System.out.print(" ");
                while (globalStack.isEmpty()==false){
                    Node temp=(Node)globalStack.pop();
                    if (temp!=null){
                        System.out.print(temp.data);
                        localStack.push(temp.left);
                        localStack.push(temp.right);
                        if (temp.left!=null||temp.right!=null)
                            isRowEmpth=false;

                    }else {
                        System.out.print("--");
                        localStack.push(null);
                        localStack.push(null);
                    }
                    for (int i=0;i<nBlanks*2-2;i++){
                        System.out.print(" ");
                    }
                }
                System.out.println();
                nBlanks/=2;
                while (localStack.isEmpty()==false){
                     globalStack.push(localStack.pop());
                }
            }
        }
        System.out.println("------------------------------------");
    }
}
