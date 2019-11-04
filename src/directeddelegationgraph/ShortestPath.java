package directeddelegationgraph;
/*
* 有向代权图的最短路径
* */
public class ShortestPath {
    private class Vertex{
        private char lable;
        private boolean isInTree;

        public Vertex(char lable) {
            this.lable = lable;
            isInTree=false;
        }
    }
    private class DistPar{
        private int distance;
        private int parentVert;

        public DistPar(int distance, int parentVert) {
            this.distance = distance;
            this.parentVert = parentVert;
        }
    }
    private final int MAX_VERTS=20;
    private final int INFINITY=1000000000;
    private Vertex[] vertexList;
    private int[][] adjMat;
    private int nVerts;
    private int nTree;
    private DistPar[] sPath;
    private int currentVert;
    private int startToCurrent;

    public ShortestPath( ) {
        this.vertexList = new Vertex[MAX_VERTS];
        adjMat=new int[MAX_VERTS][MAX_VERTS];
        nVerts=0;
        nTree=0;
        for (int i=0;i<MAX_VERTS;i++)
            for (int j=0;j<MAX_VERTS;j++)
                adjMat[i][j]=INFINITY;
        sPath=new DistPar[MAX_VERTS] ;

    }

    public void addVertex(char lab){
        vertexList[nVerts++]=new Vertex(lab);
    }

    public void addEdge(int start,int end,int weight){
        adjMat[start][end]=weight;
    }

    public void path(){//最短路径算法
        int startTree=0;
        vertexList[startTree].isInTree=true;
        nTree=1;
        for (int j=0;j<nVerts;j++){
            int tempDist=adjMat[startTree][j];
            sPath[j]=new DistPar(startTree,tempDist);
        }
        while (nTree<nVerts){
            int indexMin=getMin();
            int minDist=sPath[indexMin].distance;
            if (minDist==INFINITY){
                System.out.println("unrechechable");
                break;
            }else {
                currentVert=indexMin;
                startToCurrent=sPath[indexMin].distance;
            }
            vertexList[currentVert].isInTree=true;
            nTree++;
            adjust_sPath();
        }
        displayPaths();
        nTree=0;
        for (int j=0;j<nTree;j++)
            vertexList[j].isInTree=false;
    }

    private void displayPaths() {

        for (int j=0;j<nVerts;j++){
            System.out.print(vertexList[j].lable+"=");
            if (sPath[j].distance==INFINITY){
                System.out.print("inf");
            }else
                System.out.println(sPath[j].distance);
            char parent=vertexList[sPath[j].parentVert].lable;
            System.out.println("("+parent+")");
        }
        System.out.println();
    }

    private void adjust_sPath() {//核心算法
        int column=1;
        while (column<nVerts){
            if (vertexList[column].isInTree){
                column++;
                continue;
            }
            int currentToFringe=adjMat[currentVert][column];
            int startToFringe=startToCurrent+currentToFringe;
            int sPathDist=sPath[column].distance;
            if (startToFringe<sPathDist){
                sPath[column].parentVert=currentVert;
                sPath[column].distance=startToFringe;
            }
            column++;
        }
    }

    private int getMin() {//从起点开始邻接权值最小的连通的顶点
        int minDist=INFINITY;
        int indexMin=0;
        for (int j=1;j<nVerts;j++){
            if (!vertexList[j].isInTree&&sPath[j].distance<minDist){
                minDist=sPath[j].distance;
                indexMin=j;
            }
        }
        return indexMin;
    }
}
