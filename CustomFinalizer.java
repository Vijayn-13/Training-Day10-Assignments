class ResourceWithFinalizer implements AutoCloseable{
    private String resourceName;
    ResourceWithFinalizer(String resource){
        this.resourceName=resource;
        System.out.println(resourceName+" created");
    }
    protected void finalize() throws Throwable{
        try{
            System.out.println(this.resourceName+" finalized");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            super.finalize();
        }
    }
    public void close(){
        System.out.println(this.resourceName+" closed");
    }
}
class CustomFinalizer{
    public static void main(String[] args){
        try(ResourceWithFinalizer r1=new ResourceWithFinalizer("Resource 1");ResourceWithFinalizer r2=new ResourceWithFinalizer("Resource 2")){
            System.out.println("Using try-with resources");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        ResourceWithFinalizer r3=new ResourceWithFinalizer("Resource 3");
        ResourceWithFinalizer r4=new ResourceWithFinalizer("Resource 4");
        r3=null;
        r4=null;
        System.gc();
        try{
            Thread.sleep(1000);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}