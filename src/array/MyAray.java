package array;

public class MyAray {
    private long[] a;
    private int currentSize;
    public MyAray(int  capacity){
        a=new long[ capacity];
        currentSize=0;
    }

    /*
    增
    * */
    public void insert(long value){
        a[currentSize++]=value;
    }
    /*
    * 删*/
    public Boolean delete(long value){
        int i;
        for (i=0;i<currentSize;i++)
            if (a[i]==value)
                break;
        if (i==currentSize)
            return false;
        else{
            for (int j=i;j<currentSize;j++){
                a[i]=a[i+1];
            }
            currentSize--;
            return true;
        }
    }
    /*
    * 查*/
    public void dispaly(){
        for (int i=0;i<currentSize;i++)
            System.out.println(a[i]);
    }

    public Boolean contain(long serchKey){
        int i;
        for ( i=0;i<currentSize;i++)
            if (a[i]==serchKey)
                break;
        if (i==currentSize)
            return false;
        else
            return true;
    }
}
