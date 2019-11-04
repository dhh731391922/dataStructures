package hashtable;
/*
* 再哈希
* */
public class DoubleHash {
    private Integer[] hashArray;
    private int arrSize;

    public DoubleHash(int arrSize) {
        this.arrSize = arrSize;
        hashArray=new Integer[arrSize];
    }
    /*
    * 查
        * */
    public void display(){
        System.out.println("Table:");
        for (int i=0;i<arrSize;i++){
            if (hashArray[i]!=null)
                System.out.print(i+" ");
            else
                System.out.print("** ");

        }
        System.out.println();
    }
    public int hashFun(int key){//首次哈希
        return key%arrSize;
    }
    public int hashFun2(int key){//再次哈希(不能和第一个哈希函数相同，并且不能返回0)
        //步长stepSize=constant-(key%constant)contant是质数，且小于数组的容量
        return 5-5%key;
    }
    /*
    * 增
    * */
    public void insert(int key){
        int i = hashFun(key);
        int stepSize = hashFun2(key);
        while (hashArray[i]!=null){
            i=i+stepSize;
            i=i%arrSize;
        }
        hashArray[i]=key;
    }
    /*
    * 删
    * */
    public Integer delete(int key){
        int i = hashFun(key);
        int stepSize = hashFun2(key);
        while (hashArray[key]!=null ){
            if (hashArray[key]==key){
                int tem=hashArray[key];
                hashArray[key]=null;
                return tem;
            }
            i+=stepSize;
            i%=arrSize;

        }
        return null;
    }

    /*
    * 查
    * */
    public Integer find(int key){
        int i = hashFun(key);
        int stepSize = hashFun2(key);
        while (hashArray[i]!=null){
            if (hashArray[i]==key)
                return hashArray[i];
            i+=stepSize;
            i%=arrSize;
        }
        return null;
    }
}
