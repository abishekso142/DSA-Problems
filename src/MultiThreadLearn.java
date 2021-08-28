public class MultiThreadLearn
{

    public static void main(final String[] args)
    {
        final Thread t1 = new Thread(new MyThread());
        t1.start();

        final Thread t2 = new MyThread2();
        t2.start();

        for (int i = 0; i < 5; i++)
        {

            try
            {
                if (i == 4)
                {
                    t1.join();
                    t2.join();
                }
                System.out.println("Main thread: " + i);

            }
            catch (final InterruptedException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

class MyThread implements Runnable
{

    @Override
    public void run()
    {
        for (int i = 0; i < 5; i++)
        {
            System.out.println("MyThread1: " + i);
            try
            {
                Thread.sleep(2000);
            }
            catch (final InterruptedException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}

class MyThread2 extends Thread
{

    @Override
    public void run()
    {
        for (int i = 0; i < 5; i++)
        {
            System.out.println("MyThread2: " + i);
            try
            {
                Thread.sleep(1000);
            }
            catch (final InterruptedException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
