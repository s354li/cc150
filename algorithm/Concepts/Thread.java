// extend Thread class or implement Runnable interface
// processes -> thread java.lang.*
Thread iniThread = new Thread();
String name = iniThread.getName();
int priority = iniThread.getPriority();
iniThread.setPriority(1);
boolean alive = iniThread.isAlive();
iniThread.join();  // wait for a thread to terminate
iniThread.run();  // entry point for a thread
iniThread.sleep(1000);  // suspend a thread for a period of time
iniThread.start();   // start a thread by calling the run function

class MultithreadingDemo extends Thread{  
  public void run(){  
    System.out.println("My thread is in running state.");  
  }   
  public static void main(String args[]){  
     MultithreadingDemo obj=new MultithreadingDemo();   
     obj.start();  
  }  
}

class MultithreadingDemo implements Runnable{  
  public void run(){  
    System.out.println("My thread is in running state.");  
  }   
  public static void main(String args[]){  
     MultithreadingDemo obj = new MultithreadingDemo();  
     Thread tobj = new Thread(obj);  
     tobj.start();  
 }  
}

synchronized class MyClass {}

public sychronized void myMethod(args...){}

Synchronized(object)
{
    // statement to be synchronized
}

