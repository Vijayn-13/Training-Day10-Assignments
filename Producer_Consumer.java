import java.util.concurrent.ArrayBlockingQueue;

class Data{
    private ArrayBlockingQueue<String > queue;
    public Data(int size){
        this.queue=new ArrayBlockingQueue<>(size);
    }
    public void add(String str){
        try{
            queue.put(str);
            System.out.println("Item added: "+str);
        }
        catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
    public void get(){
        try{
            String st=queue.take();
            System.out.println("Element removed: "+st);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
class Producer implements Runnable{
    private Data data;
    private String item;
    Producer(Data data,String item){
        this.data=data;
        this.item=item;
    }
    @Override
    public void run() {
        data.add(item);
    }
}

class Consumer implements Runnable{
    private Data data;
    Consumer(Data data){
        this.data=data;
    }
    @Override
    public void run() {
        data.get();
    }
}
public class Producer_Consumer {
    public static void main(String[] args){
        Data data=new Data(10);
        Thread p1=new Thread(new Producer(data,"hel"));
        Thread p2=new Thread(new Producer(data,"ok"));
        Thread p3=new Thread(new Producer(data,"hi"));
        Thread p4=new Thread(new Producer(data,"tell"));
        Thread c1=new Thread(new Consumer(data));
        Thread c2=new Thread(new Consumer(data));
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        c1.start();
        c2.start();
    }
}
