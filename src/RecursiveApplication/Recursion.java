package RecursiveApplication;

/*
* 递归应用
* */
public class Recursion {
    /*
    规律表达书求和(三角数字)
    * */
    public int summation(int n){
        if (n==1)
            return 1;
        return n+summation(n-1);
    }

    /*
    * 阶乘  最大公约数  乘方
    * */
    public int factorial(int n){
        if (n==1)
            return 1;
        return n*factorial(n-1);
    }
    /*
    * 变位字（阶乘）有几个字母就有n的阶乘种字母，常用在搜索应用中
    * */
    public static void main(String[] args) {
       new Recursion().toweOfHanoi(3,'A','B','C');
    }
    class a{
        int size;
        char[] arr;
        int count;
        public void deflection(String s){
            size=s.length();
            count=0;
            arr=new char[100];
            for (int i=0;i<size;i++){
                arr[i]=s.charAt(i);
            }
            doAnagram(size);
        }
        //变位颠倒
        //看递归的功能就看其最小数的功能
        public void doAnagram(int newSize){
            if (newSize==1)
                return;
            for (int j=0;j<newSize;j++){
                doAnagram(newSize-1);
                if (newSize==2)
                    displayWord();
                rotate(newSize);
            }
        }

        private void displayWord() {
            if (count<99)
                System.out.print(" ");
            if (count<9)
                System.out.print(" ");
            System.out.print(++count+" ");
            for (int j=0;j<size;j++)
                System.out.print(arr[j]);
            System.out.print("  ");
            System.out.flush();
            if (count%6==0)
                System.out.println();
        }

        //转动的方法
        private void rotate(int newSize) {
            int j;
            int position=size-newSize;
            char tem=arr[position];
            for (j=position+1;j<size;j++)
                arr[j-1]=arr[j];
            arr[j-1]=tem;

        }
    }
    public void deflection2(String s){
        char[] arr = s.toCharArray();
        doAnagram(s.length(),arr);
    }

    private void doAnagram(int size,char[] arr) {
        if (size==1)
            return;
        for (int i=0;i<size;i++){
            doAnagram(size-1,arr);
            if (size==2){
                String j="";
                for (char c:arr){
                    j+=c;
                }
                System.out.println(j);
            }
            int position=arr.length-size;
            char tem=arr[position];
            for (int j=position+1;j<arr.length;j++){
                arr[j-1]=arr[j];
            }
            arr[arr.length-1]=tem;
        }
    }

    /*
    * 分治算法—__二分查找法
    * */
    public int recFind(int key,int beg,int end){
        int min=(beg+end)/2;
        if (min==key)
            return min;
        else if (beg>end){
            return -1;
        }else {
            if (min>key)
                return recFind(key,beg,min-1);
            else
                return recFind(key,min+1,end);
        }
    }

    /*
    * 汉诺塔问题
    * */
    public void toweOfHanoi(int n,char left,char middle,char right){
        if (n==1)
            System.out.println("盘子1从"+left+"到"+right);
        else {
            toweOfHanoi(n-1,left,right,middle);
            System.out.println("盘子"+n+"从"+left+"到"+right);
            toweOfHanoi(n-1,middle,left,right);
        }

    }

}
