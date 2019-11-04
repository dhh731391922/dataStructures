package hashtable;

/*
* 哈希表：
*       优点：速度快（查询和插入）
*       缺点：基于数组，不能有序的遍历
* 冲突：不同关键字通过哈希化得到的数组下标出现了重复
* 解决冲突的方式：
*               1.开放地址法（线性探测    二次探测    再哈希
*               2.链地址法
* */
public class MyHashTable {

    /*
    * 线性探测
    * */
    private Integer[] hashArray;
    private int arrSize;
    public MyHashTable(int size){
        arrSize=size;
        hashArray=new Integer[arrSize];

    }
    /*
    * 查
    * */
    public void displayTable(){
        System.out.println("Table:");
        for (int i=0;i<arrSize-1;i++){
            if (hashArray[i]!=null)
                System.out.print(hashArray[i]+" ");
            else
                System.out.print("** ");
        }
        System.out.println();
    }

    public int find(int key){
        int i = hashFun(key);
        while (hashArray[i]!=null){
            if (hashArray[i]==key)
                return hashArray[i];
            else {
                i++;
                i=i%arrSize;
            }
        }
        return -1;
    }
    //哈希函数
    public int hashFun(int ket){
        return ket%arrSize;
    }
    /*
    * 增
    * */
    public void insert(int value){
        int key=value%arrSize;
        while (hashArray[key]!=null){//位置被占用
            key++;
            key=key%arrSize;
        }
        hashArray[key]=value;

    }

    /*
    * 删
    * */
    public Integer detele(int key){
        while (Integer.valueOf(hashFun(key))!=null){
            if (hashArray[hashFun(key)]==key){
                int tem=hashArray[hashFun(key)];
                hashArray[hashFun(key)]=null;
                return tem;
            }
            key++;
            key=key%arrSize;
        }
       return null;
    }
    /*
    *
    * */

}
