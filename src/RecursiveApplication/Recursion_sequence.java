package RecursiveApplication;
/*
* 递归_排序
* */
public class Recursion_sequence {
    /*
    * 归并排序
    * O(n*logn)
    * 需要多一倍的空间
    * */
    public static void main(String[] args) {
       int arr[]={1,544,15,66,0,33};

//
//        for (int i:arr)
//            System.out.print(i+" ");
//        new Recursion_sequence().mergerSort(arr);
//        System.out.println();
//        for (int i:arr)
//            System.out.print(i+" ");



//        Recursion_sequence r = new Recursion_sequence();
//        int[] theArray = r.theArray;
//        theArray[0]=1;
//        theArray[1]=0;
//        theArray[3]=88;
//        theArray[4]=77;
//        r.mergerSort();
//        for (int i:theArray)
//            System.out.println(i);
//        shellSort(arr);
//        for (int i:arr)
//            System.out.print(i+" ");

//        divide(arr,0,arr.length-1,16);
//        for (int i:arr)
//            System.out.print(i+" ");

//        quickSort(arr);
//        for (int i:arr)
//            System.out.print(i+" ");




    }
    int[] theArray=new int[10];
    public void mergerSort(int[] arr){
        int[] workSpace=new int[arr.length];
//        int[] workSpace=new int[10];
//        recMargeSort(workSpace,0,theArray.length-1);
        recMargeSort1(arr,workSpace,0,arr.length-1);

    }
    private void recMargeSort1(int[] arr,int[] workSpace,int lowerBound,int upperBound){

        if (lowerBound==upperBound)
            return;
        else {
            int min=(lowerBound+upperBound)/2;
            recMargeSort1(arr,workSpace,lowerBound,min);
            recMargeSort1(arr,workSpace,min+1,upperBound);
            int preStar=lowerBound;
            int preEnd=min;
            int rearStart=min+1;
            int rearEnd=upperBound;
            int j=0;
            while (preStar<=preEnd&&rearStart<=rearEnd)
                if (arr[preStar]<arr[rearStart])
                    workSpace[j++]=arr[preStar++];
                else
                    workSpace[j++]=arr[rearStart++];
            while (preStar<=preEnd)
                workSpace[j++]=arr[preStar++];
            while (rearStart<=rearEnd)
                workSpace[j++]=arr[rearStart++];
            for (int i=0;i<upperBound-lowerBound+1;i++)
                arr[i+lowerBound]=workSpace[i];//i是控制辅助数组的个数；
        }

    }
    private void recMargeSort(int[] workSpace,int lowerBound,int upperBound){
        if (lowerBound==upperBound)
            return;
        else {
            int mind=(lowerBound+upperBound)/2;
            recMargeSort(workSpace,lowerBound,mind);
            recMargeSort(workSpace,mind+1,upperBound);
            merge(workSpace,lowerBound,mind+1,upperBound    );//归并
        }
    }

    private void merge(int[] workSpace, int lowerPtr, int highPtr, int upperBound) {
        int j=0;
        int lowerBound=lowerPtr;
        int mid=highPtr-1;
        int n=upperBound-lowerBound+1;//要归并的数量
        while (lowerPtr<=mid&&highPtr<=upperBound)
            if (theArray[lowerPtr]<theArray[highPtr])
                workSpace[j++]=theArray[lowerPtr++];
            else
                workSpace[j++]=theArray[highPtr++];
        while (lowerPtr<=mid)
            workSpace[j++]=theArray[lowerPtr++];
        while (highPtr<=upperBound)
            workSpace[j++]=theArray[highPtr++];
        for (j=0;j<n;j++)
            theArray[lowerBound+j]=workSpace[j];
    }


    /*
    * 希尔排序：在插入排序的基础上加入一个(每个N的条件)
    * n=n*3+1,n不能大于总数的三分之一
    * */
    public static void shellSort(int[] arr){
        int tem,rear,front;
        int h=1;
        while (h<arr.length/3)
            h=h*3+1;
        while (h>0){
            for (rear=h;rear<arr.length;rear++){
                tem=arr[rear];
                front=rear;
                while (front>h-1&&arr[front-h]>=tem ){//还要和front-n前面的数比
                    arr[front]=arr[front-h];
                    front-=h;
                }
                arr[front]=tem;//把H看成1去带入
            }
            h=(h-1)/3;
        }
    }

    /*
    * 划分        (快速排序的基础)
    * */
    public static int divide(int[] arr,int left,int right,int key){
        int leftbegin=left-1;
        int rightbegin=right+1;
        while (true){
            while (leftbegin<right&&arr[++leftbegin]<key);
            while (rightbegin>left&&arr[--rightbegin]>key);
            if (leftbegin>=rightbegin)break;
            else {
                int tem=arr[leftbegin];
                arr[leftbegin]=arr[rightbegin];
                arr[rightbegin]=tem;
            }

        }
        return leftbegin;

    }

    /*
    * 快速排序O(n*logn)
    * */
    public static void quickSort(int[] arr){
        recQuickSort(arr,0,arr.length-1);
    }
    private static void recQuickSort(int[] arr,int left,int right){
        if (right-left<=0)
            return;                 //插入排序
        else {
            int pointValue = arr[right];//划分值可以进行三选一，开头结尾和中间值，
            // 但递归的最终条件要改为个数小于3.最好是个数小于某数时选择插入排序。
            int postion = divide(arr, left, right, pointValue);
            recQuickSort(arr,left,postion-1);
            recQuickSort(arr,postion,right);
        }
    }
    /*
    * 基数排序（按数的进制数分组，在按重低到高排序）radix sorting
    * */
    public static void radixSort(int[] arr){

    }

}
