package threads;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NormalThread {

    public static void main(String args[]) {
        new NormalThreadExample().usingNormal();
        System.out.println("Program Completed");
    }
}

class NormalThreadExample implements Callable
{
    CopyOnWriteArrayList<String> stringCopyOnWriteArrayList = new CopyOnWriteArrayList<>();

    @Override
    public Object call() throws Exception {
        int sleep = (int) (100 * Math.random());
        String threadName = Thread.currentThread().getName();
        System.out.println(String.format("Thread : %s, sleep for : %s",threadName, sleep));
        Thread.sleep(sleep);
        for (int i = 0; i < 100; i++)
        {
            //just looping to depict some work done
            int a = 1 + 2;
        }
        stringCopyOnWriteArrayList.add(threadName);
        System.out.println(String.format("Thread : %s, executed",threadName));
        return Thread.currentThread().getName();
    }

    public void usingNormal() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        NormalThreadExample callBackExample = new NormalThreadExample();
        for (int i = 0; i < 100; i++) {
            System.out.println("call back submitted : " + i);
            executorService.submit(callBackExample);
        }
        for (String tstr : stringCopyOnWriteArrayList) {
            System.out.println(new Date() + "::" + tstr);
        }
    }
}