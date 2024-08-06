class Thread_Interruption extends Thread{
    Thread_Interruption(String name){
        super(name);
    }
    public void run(){
        try{
            for(int i=0;i<3;i++){
                System.out.println(Thread.currentThread().getName()+" is running");
                Thread.sleep(1000);
            }
            System.out.println(Thread.currentThread().getName()+" is closed");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
public class ThreadInterrupt
{
    public static void main(String[] args) {
        Thread_Interruption t1=new Thread_Interruption("Thread 1");
        Thread_Interruption t2=new Thread_Interruption("Thread 2");
        Thread_Interruption t3=new Thread_Interruption("Thread 3");
        t1.start();
        t2.start();
        t3.start();
        System.out.println("Thread 1 interrupted? "+t1.isInterrupted());
        System.out.println("Thread 2 interrupted? "+t2.isInterrupted());
        System.out.println("Thread 3 interrupted? "+t3.isInterrupted());
        t1.interrupt();
        System.out.println("Thread 1 interrupted? "+t1.isInterrupted());
        System.out.println("Thread 2 interrupted? "+t2.isInterrupted());
        System.out.println("Thread 3 interrupted? "+t3.isInterrupted());
    }
}