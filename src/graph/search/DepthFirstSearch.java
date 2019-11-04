package graph.search;

import java.util.Stack;

/*
* 深度优先搜索
* */
public class DepthFirstSearch {
    private class Vertex{
        public char label;
        public boolean isVisted;

        public Vertex(char label) {
            this.label = label;
            this.isVisted = false;
        }
    }
    private class Queue{
        private final  int SIZE=20;
        private int[] queArray;
        private int front ;
        private int rear;

        public Queue() {
            this.queArray = new int[SIZE];
            front=0;
            rear=-1;
        }

        public void insert(int i){
            if (rear==SIZE-1)
                rear=-1;
            queArray[++rear]=i;

        }

        public int remove(){
            int tem=queArray[front++];
            if (front>SIZE)
                front=0;
            return tem;
        }

        public boolean isEmpty(){
            return (rear==front-1 ||front+SIZE-1==rear);
        }
    }
    private final int MAX_VERTS=20;//顶点数组的总大小

    private Vertex[] vertexList;//顶点
    private int[][] sides;//边（邻接矩阵）
    private int vertexSize;//顶点个数
    private Stack stack;//深度优先搜索
    private Queue queue;//广度优先搜索

    public DepthFirstSearch() {
        vertexList=new Vertex[MAX_VERTS];
        sides=new int[MAX_VERTS][MAX_VERTS];
        vertexSize=0;
        for (int i=0;i<MAX_VERTS;i++){
            for (int j=0;j<MAX_VERTS;j++)
                sides[i][j]=0;
        }
        stack=new Stack();
        queue=new Queue();
    }

    public void addVertex(char lab){//添加顶点
        vertexList[vertexSize++]=new Vertex(lab);
    }

    public void addEdge(int start,int end){//添加边
        sides[start][end]=1;
        sides[end][start]=1;
    }
    public void displayVertex(int v){
        System.out.print(vertexList[v].label);
    }

    public void bfs(){//广度优先搜索
        vertexList[0].isVisted=true;
        displayVertex(0);
        queue.insert(0);
        int v;
        while (!queue.isEmpty()){
            int i = queue.remove();
            while ((v=getAdjUnvisitedVertex(i))!=-1){
                vertexList[v].isVisted=true;
                displayVertex(v);
                queue.insert(v);
            }
        }
        for (int i=0;i<vertexSize;i++)
            vertexList[i].isVisted=false;

    }//广度优先搜索

    public void dfs(){//深度优先搜索
        vertexList[0].isVisted=true;
        displayVertex(0);
        stack.push(0);
        while (!stack.isEmpty()){

            int i = getAdjUnvisitedVertex((int)stack.peek());
            if (i==-1){
                stack.pop();
            }else {
                vertexList[i].isVisted=true;
                displayVertex(i);
                stack.push(i);
            }
        }
        for (int i=0;i<vertexSize;i++)
            vertexList[i].isVisted=false;

    }//深度优先搜索
    /*
    * 最小生成树：将一个图去掉多余的边，用最少的边使得每一个顶点都连通（）
    *           即可基于深度优先也可基于广度优先
    * */
    public void mst(){//Minimum Spanning Tree最小生成树（基于深度优先）

        vertexList[0].isVisted=true;
        stack.push(0);

        while (!stack.isEmpty()){
            int current= (int) stack.peek();
            int v=getAdjUnvisitedVertex(current);
            if (v==-1)
                stack.pop();
            else {
                vertexList[v].isVisted=true;
                stack.push(v);
                displayVertex(current);
                displayVertex(v);
                System.out.print(" ");
            }
        }
        for (int i=0;i<vertexSize;i++)
            vertexList[i].isVisted=false;

    }//Minimum Spanning Tree最小生成树

    public int getAdjUnvisitedVertex(int v){//获取指定顶点相邻的一个未被访问过的顶点
        for (int i=0;i<vertexSize;i++)
            if (sides[v][i]==1&&vertexList[i].isVisted==false)//找到了
                return i;
        return -1;

    }
}
