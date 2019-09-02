package array;

public class SimpleRanking {
    /*
    * 冒泡排序
    * O(n^2)
    * */
    public void  bubbleSort(int[] arr){
        for (int i=arr.length-1;i>1;i--){
            for (int j=0;j<arr.length-i-1;j++){
                if (arr[j]>arr[j+1]){
                    int tem=arr[j+1];
                    arr[j+i]=arr[j];
                    arr[j]=tem;
                }
            }
        }
    }

    /*
    * 选择排序
    * */
    public void selectionSort(int[] arr){
        int min=0;
        for (int i=0;i<arr.length-1;i++){
            min=i;
            for (int j=i+1;j<arr.length;j++){
                if (arr[i]>arr[j]){
                    min=j;
                }
            }
            int tem=arr[i];
            arr[i]=arr[min];
            arr[min]=tem;
        }
    }

    /*
    * 插入排序
    * */
    public void insertionSort(int[] arr){
        int t,in;
        for (int i=1;i<arr.length;i++){
           t=arr[i];
           in=i;
           while (in>0&&arr[in-1]>t){

               arr[in]=arr[in-1];

               in--;
           }
           arr[in]=t;
        }
    }
}
