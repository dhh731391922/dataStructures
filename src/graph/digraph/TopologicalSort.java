package graph.digraph;
/*
* 有向图的拓扑排序
* */
public class TopologicalSort {
    private class Vertex{
        private char label;

        public Vertex(char label) {
            this.label = label;
        }
    }
    private final int MAX_SIZE=20;
    private Vertex[] vertexList;
    private int[][] sides;
    private int vertexSize;
    private char[] sortedArray;//排序后的结果

    public TopologicalSort() {
        this.vertexList = new Vertex[MAX_SIZE];
        sides=new int[MAX_SIZE][MAX_SIZE];
        for (int i=0;i<MAX_SIZE;i++)
            for (int j=0;j<MAX_SIZE;j++)
                sides[i][j]=0;
            sortedArray=new char[MAX_SIZE];
        vertexSize=0;

    }
    public void addVertex(char lab  ){
        vertexList[vertexSize++]=new Vertex(lab);
    }
    public void addEdge(int start,int end){
        sides[start][end]=1;
    }

    public void dispalyVertex(int v){

        System.out.print(vertexList[v].label);
    }

    public void topo(){//拓扑排序
        int orig_vertexSize=vertexSize;
        while (vertexSize>0){
            int curentVertex=noSuccessors();
            if (curentVertex==-1)
                return;
            sortedArray[vertexSize-1]=vertexList[curentVertex].label;
            deleteVertex(curentVertex);
        }
        for (int i=0;i<orig_vertexSize;i++)
            System.out.print(sortedArray[i]);
    }

    private void deleteVertex(int delVertex) {
        if (delVertex!=vertexSize-1){
            for (int i=delVertex;i<vertexSize-1;i++)
                vertexList[i]=vertexList[i+1];
            for (int row=delVertex;row<vertexSize-1;row++)//把临接矩阵要删除的行的后面行向上移
                moveRowUp(row,vertexSize-1);
            for (int col=delVertex;col<vertexSize-1;col++)
                moveColLeft(col,vertexSize-1);


        }
        vertexSize--;
    }

    private void moveColLeft(int col, int length) {
        for (int row=0;row<length;row++)
            sides[row][col]=sides[row][col+1];
    }

    private void moveRowUp(int row, int length) {//向上移动一行
        for (int col=0;col<length;col++)
            sides[row][col]=sides[row+1][col];
    }

    private int noSuccessors() {//找没有后继顶点的方法
        boolean isEdge;//是否有边
        for (int row=0;row<vertexSize;row++){
            isEdge=false;
            for (int col=0;col<vertexSize;col++ ){
                if (sides[row][col]>0){
                    isEdge=true;
                    break;
                }
            }
            if (!isEdge)
                return row;

        }
        return -1;

    }

}
