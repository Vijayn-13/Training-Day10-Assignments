import java.lang.*;
class GCExample{

    GCExample(){
        System.out.println("Object is created");
    }

    protected void finalize() throws Throwable{
        try{
            System.out.println("Garbage collected");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            super.finalize();
        }
    }
}

public class GarbageCollection
{
    public static void main(String[] args) {
        GCExample ge1=new GCExample();
        GCExample ge2=new GCExample();
        GCExample ge3=new GCExample();
        GCExample ge4=new GCExample();
        GCExample ge5=new GCExample();
        GCExample ge6=new GCExample();
        GCExample ge7=new GCExample();
        GCExample ge8=new GCExample();
        GCExample ge9=new GCExample();
        GCExample ge10=new GCExample();
        ge1=null;
        ge2=null;
        ge3=null;
        ge4=null;
        ge5=null;
        ge6=null;
        ge7=null;
        ge8=null;
        ge9=null;
        ge10=null;
        System.gc();
        try{
            Thread.sleep(1000);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}