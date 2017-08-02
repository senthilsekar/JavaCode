public class ThreadLocalExample {


    public static class MyRunnable implements Runnable {
        String name;
        private ThreadLocal<Integer> threadLocal =
               new ThreadLocal<Integer>();

        @Override
        public void run() {
            threadLocal.set( (int) (Math.random() * 100D) );
            name=Thread.currentThread().getName();
            try {
                Thread.sleep(2000);
              
            } catch (InterruptedException e) {
            }
    
            System.out.println(threadLocal.get());
            System.out.println("Non Thread Local (value overwritten) name value : "+name);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        MyRunnable sharedRunnableInstance = new MyRunnable();

        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);
        
        thread1.setName("THREAD-1");
        thread1.setName("THREAD-2");
        
        thread1.start();
        thread2.start();

        thread1.join(); //wait for thread 1 to terminate
        thread2.join(); //wait for thread 2 to terminate
    }

}