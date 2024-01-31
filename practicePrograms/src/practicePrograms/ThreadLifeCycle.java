package practicePrograms;
//https://medium.com/javarevisited/thread-life-cycle-with-example-java-multithreading-interview-preparation-a2014213e65e
//Common Resource used
class Message {
  String msg;

  public Message(String msg) {
      this.msg = msg;
  }

  public String getMsg() {
      return msg;
  }

  public void setMsg(String msg) {
      this.msg = msg;
  }
}

class ThreadLifeCycle2 implements Runnable {
  Message msg;

  public ThreadLifeCycle2(Message msg) {
      this.msg = msg;
  }

  @Override
  public void run() {
      try {
          synchronized (msg) {
              msg.wait();
          }
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
  }
}


public class ThreadLifeCycle implements Runnable {
  Message msg;

  public ThreadLifeCycle(Message msg) {
      this.msg = msg;
  }

  public static void main(String args[]) throws InterruptedException {
      //Creating first thread
      Message message = new Message("Shared");
      ThreadLifeCycle threadLifeCycle = new ThreadLifeCycle(message);
      Thread thread1 = new Thread(threadLifeCycle, " Thread 1");

      //Creating second thread
      ThreadLifeCycle threadLifeCycle2 = new ThreadLifeCycle(message);
      Thread thread2 = new Thread(threadLifeCycle2, " Thread 2");
      //Creating Third thread
      ThreadLifeCycle2 threadLifeCycle3 = new ThreadLifeCycle2(message);
      Thread thread3 = new Thread(threadLifeCycle3, " Thread 3");


      System.out.println(thread1.getName() + " " + thread1.getState()); // we have not started thread so this will return NEW
      System.out.println(thread2.getName() + " " + thread2.getState());
      System.out.println(thread3.getName() + " " + thread3.getState());
      thread3.start();
      thread1.start();
      thread2.start();
    //  thread3.start();

      while (thread1.isAlive() || thread2.isAlive() || thread3.isAlive()) {
          System.out.println("-------------------------------------------------------");
          System.out.println(thread1.getName() + " : " + thread1.getState());
          System.out.println(thread2.getName() + " : " + thread2.getState());
          System.out.println(thread3.getName() + " : " + thread3.getState());
          Thread.sleep(2000);
      }
      System.out.println("-------------------------------------------------------");
      System.out.println(thread1.getName() + " : " + thread1.getState());
      System.out.println(thread2.getName() + " : " + thread2.getState());
      System.out.println(thread3.getName() + " : " + thread3.getState());
  }

  public Message getMsg() {
      return msg;
  }

  public void setMsg(Message msg) {
      this.msg = msg;
  }

  @Override
  public void run() {
      try {
          synchronized (msg) {
              Thread.sleep(3000);
              msg.setMsg("Message");
              msg.notifyAll();

          }
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
  }
}
