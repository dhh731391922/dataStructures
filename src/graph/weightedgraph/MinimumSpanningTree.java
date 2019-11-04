package graph.weightedgraph;
/*
* 带权图的最小生成树
* */
public class MinimumSpanningTree {
    private class Edge{
        private int srcVert;
        private int destVert;
        private int weight;

        public Edge(int srcVert, int destVert, int weight) {
            this.srcVert = srcVert;
            this.destVert = destVert;
            this.weight = weight;
        }
    }
    private class PriorityQueue{
        private final int SIZE=20;
        private Edge[] queArray;
        private int size;

        public PriorityQueue() {
            this.queArray = new Edge[SIZE];
            this.size = 0;
        }
        public void insert(Edge item){
            int j;
            for (j=0;j<size;j++ )
                if (queArray[j].weight<=item.weight)
                    break;
            for (int i=size-1;i>=j;i--){
                queArray[i+1]=queArray[i];
            }
            queArray[j]=item;
            size++;
        }
        public Edge removeMin(){
           return queArray[--size];
        }

        public void removeM(int n){//删除指定的边
            for (int i=n;i<size;i++)
                queArray[i]=queArray[i+1];
            size--;
        }

        public Edge peekMin(){
            return queArray[size-1];
        }
        public int size(){
            return size;
        }
        public boolean isEmpty(){
            return size==0;
        }
        public Edge peekN(int n){
            return queArray[n];
        }
        public int find(int finDest){
            for (int i=0;i<size;i++)
                if (queArray[i].weight==finDest)
                    return i;
             return -1;
        }
    }
    private class Vertex{
        private char lab;
        private boolean isInTree;

        public Vertex(char lab) {
            this.lab = lab;
            isInTree=false;
        }
    }

    private final int   MAX_VERTS=20;
    private final int INFINITY=1000000000;
    private Vertex[] vertexList;
    private int[][] adjMat;//邻接矩阵
    private int nVertex;
    private int currentVetex;
    private PriorityQueue theQu;
    private int nTree;

    public MinimumSpanningTree() {
        this.vertexList = new Vertex[MAX_VERTS];
        adjMat=new int[MAX_VERTS][MAX_VERTS];
        nVertex=0;
        for(int i=0;i<MAX_VERTS;i++)
            for (int j=0;j<MAX_VERTS;j++)
                adjMat[i][j]=INFINITY;
        theQu=new PriorityQueue();
    }
    /*
    * 添加顶点
    * */
    public void addVertex(char la){
        vertexList[++nVertex]=new Vertex(la);
    }
    //添加边
    public void addEdge(int start,int end,int weight){
        adjMat[start][end]=weight;
        adjMat[end][start]=weight;
    }
    public void display(int v){
        System.out.print(vertexList[v].lab);
    }
    public void mstw(){//代权图的最小生成树
        currentVetex=0;
        while (nTree<nVertex-1){
            vertexList[currentVetex].isInTree=true;
            nTree++;
            for (int j=0;j<nVertex;j++){
                if(j==currentVetex)continue;
                if (vertexList[j].isInTree)continue;
                int weight=adjMat[currentVetex][j];
                if (weight==INFINITY)continue;
                putInQu(j,weight);//早到边并将其放入优先队列中
            }
            if (this.theQu.size()==0){
                return;//不是连通图
            }
            Edge theEdge = theQu.removeMin();
            int srcVert = theEdge.srcVert;//最小边的源点
            int destVert = theEdge.destVert;
            currentVetex=destVert;

            System.out.print(vertexList[srcVert].lab);
            System.out.print(vertexList[destVert].lab);
            System.out.print(" ");

        }
        for (int i=0;i<nVertex;i++)
            vertexList[i].isInTree=false;
    }

    private void putInQu(int newVert, int newDist) {
        int queueIndex=theQu.find(newVert);
        if (queueIndex!=-1){
            Edge temEdge = theQu.peekN(queueIndex);
            int oldDist = temEdge.weight;
            if (oldDist>newDist){
                theQu.removeM(queueIndex);
                Edge theEdge = new Edge(currentVetex, newVert, newDist);
                theQu.insert(theEdge);
            }
        }else {
            Edge theEdge = new Edge(currentVetex, newVert, newDist);
            theQu.insert(theEdge);
        }
    }
}
