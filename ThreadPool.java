import java.util.*;
import java.text.*;
import java.util.concurrent.*;
class ThreadpoolMethod implements Runnable{
    String name;
    ThreadpoolMethod(String name){
        this.name=name;
    }
    public void run(){
        try{
            Date d=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss");
            for(int i=0;i<5;i++){
                if(i==0){
                    System.out.println("Initialization time for "+name+": "+sdf.format(d));
                }
                else{
                    System.out.println("Execution time for "+name+": "+sdf.format(d));
                }
                Thread.sleep(1000);
            }
            System.out.println(name+" complete");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
public class ThreadPool{
    public static void main(String[] args){
        int size=2;
        ExecutorService pool=Executors.newFixedThreadPool(size);
        ThreadpoolMethod p1=new ThreadpoolMethod("Task 1");
        ThreadpoolMethod p2=new ThreadpoolMethod("Task 2");
        ThreadpoolMethod p3=new ThreadpoolMethod("Task 3");
        pool.execute(p1);
        pool.execute(p2);
        pool.execute(p3);
        pool.shutdown();
    }
}