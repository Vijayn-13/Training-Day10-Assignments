import java.util.*;
public class MemoryUsage_Collection
{   
    static class LargeData{
        private int[] arr;
        LargeData(int size){
            this.arr=new int[size];
            for(int i=0;i<size;i++){
                arr[i]=i;
            }
        }
        static void memory_usage(String msg){
            Runtime runtime=Runtime.getRuntime();
            long memory_usage=runtime.totalMemory()-runtime.freeMemory();
            System.out.println(msg+(memory_usage));
        }
    }
public static void main(String[] args) {
    int n=10;
    int arraysize=1000000;
    List<LargeData> ls=new ArrayList<>();
    for(int i=0;i<n;i++){
        ls.add(new LargeData(arraysize));
        System.out.println("Memory usage for iteration "+(i+1)+" :-");
        LargeData.memory_usage("Before cleaning: ");
        ls.clear();
        System.gc();
       // try{
       //     Thread.sleep(1000);
       // }
       // catch(Exception e){
       //     System.out.println(e.getMessage());
       // }
        LargeData.memory_usage("After cleaning: ");
        System.out.println();
    }
}
}