package array;
/*
    数据量     所需比较次数
    10          4
    100         7
    1000        10

*有序数组
*   优点：查找速度比无序的快多了
*   缺点：插入时要按排序方式把后面的数据进行移动
* */

/*数组的缺点：
        在删除和插入时要把其删除位后的数据后移或前移
* */
public class OrderedArray {
    private long[] a;
    private int currentSize;
    public OrderedArray(int size){
        a=new long[size];
        currentSize=0;
    }
    public int size(){
        return currentSize;
    }
    /*
    线性插入
    增
    * */
    public void insert(long value){
        int i;
        for (i=0;i<currentSize;i++)
            if (a[i]>value)
                break;
        for (int j=currentSize;j>i;j--)
            a[j]=a[j-1];
        a[i]=value;
    }
    /*
    * 删*/
    public Boolean delete(long value){
        int m=findBinary(value);
        if (m==currentSize)
            return false;
        else {
            for (int i=m;i<currentSize;i++)
                a[i]=a[i+1];
            currentSize--;
            return true;
        }
    }
    /*
    * 二分查找
    * */
    public int findBinary(long key){
        int begin=0;
        int end=currentSize-1;
        int min;
        while (true){
            min=(begin+end)/2;
            if (a[min]==key)
                return min;
            else if (begin>end)
                return currentSize;
            else {
                if (a[min]>key)
                    end=min-1;
                else
                    begin=min+1;
            }
        }
    }

}
