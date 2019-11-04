package tree;
/*
* 234树（B树）：
*       每个节点最多可以存三个数据项,不存在空节点
*
*   对于非叶子节点：
*       有1个数据项的节点，最多可以有2个子节点；
*       有2个数据项的节点，最多可以有3个子节点；
*       有3个数据项的节点，最多可以有4个子节点；
*   对于非叶节点：
*       L：表示子节点个数
*       D：表示数据项个数
*       L=D+1
*   插入数据时总是插入在叶子节点
*
* */
public class Tree_234 {
    private class Node{
        private static final int ORDER=4;//节点数的最大数
        private int size;//数据的个数
        private Node parent;//父节点
        private Node[] childsNode=new Node[ORDER];//子节点
        private int[] datas=new int[ORDER-1];//数据
        public Node getChild(int childNum){//取子节点
            return childsNode[childNum];
        }
        public Node getParent(){//取父节点
            return parent;
        }
        public boolean isLeafNode(){//是否是叶子节点
            return childsNode[0]==null;
        }
        public int size(){//取数据项个数
            return size;
        }

        public int getData(int index ){
            return datas[index];
        }
        public boolean isFull(){//数据是否满了
            return size==ORDER-1;
        }
        public void connectChild(int childNum,Node child){//连接子节点
            childsNode[childNum]=child;
            if(child!=null)
                child.parent=this;
        }
        public Node disconnectChild(int childNum){//拆分子结点
            Node tem=childsNode[childNum];
            childsNode[childNum]=null;
            return tem;
        }
        public int findData(int key){ //从当前节点找一个数据项的位置
            for (int i=0;i<datas.length;i++){
                if (key==datas[i])
                    return i;
            }
            return -1;
        }
        public int insertData(int key){//插入数据
            size++;
            for (int i=datas.length-1;i>=0;i--){
                if (datas[i]==0)continue;
                else {
                    if (datas[i]>key)
                        datas[i+1]=datas[i];
                    else {
                        datas[i+1]=key;
                        return i+1;
                    }
                }
            }
            datas[0]=key;
            return 0;
        }
        public int removeData(){
            int data = datas[size - 1];
            datas[size-1]=0;
            size--;
            return data;
        }
        public void displayNode(){
            for (int i=0;i<size;i++)
                System.out.print(i+" ");
            System.out.println("/");
        }

    }
    private Node root=new Node();

    /*
    * 查
    * */
    public int find(int key){
        Node current=root;
        int childNum;
        while (true){
            if ((childNum=current.findData(key))!=-1){//找到了
                return childNum;
            }else if (current.isLeafNode()){
                return -1;
            }else {
                current=getNextChild(current,key);
            }
        }
    }

    private Node getNextChild(Node current, int key) {
        int j;
        int size = current.size;
        for (j=0;j<size;j++){
            if (key<current.getData(j))
                return current.getChild(j);
        }
        return current.getChild(j);
    }

    /*
    * 增
    * */
    public void insert(int value){
        Node currnet=root;
        while (true){
            if (currnet.isFull()){//如皋当前数据项满了，就要拆分后再查找


            }
        }
    }
}
