public class EvenOddThreads
{

    int ctr = 1;

    int MAX = 20;

    public static void main(String[] args)
    {
        EvenOddThreads obj = new EvenOddThreads();

        Thread t1 = new Thread(new Runnable()
                  {

                      public void run()
                      {
                          try
                          {
                              obj.printEven();
                          }
                          catch (InterruptedException e)
                          {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                          }
                      }
                  });
        Thread t2 = new Thread(new Runnable()
                  {

                      public void run()
                      {
                          try
                          {
                              obj.printOdd();
                          }
                          catch (InterruptedException e)
                          {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                          }
                      }
                  });

        t1.start();
        t2.start();
        
        try
        {
            t1.join();
            t2.join();
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

    }

    public synchronized void printEven()
        throws InterruptedException
    {
        while (ctr <= MAX)
        {
            if (ctr % 2 == 0)
            {
                Thread.sleep(5000);
                System.out.println(ctr);
                ctr++;
                notify();
            }
            else
            {
                wait();
            }
        }

    }

    public synchronized void printOdd()
        throws InterruptedException
    {
        
        while (ctr <= MAX)
        {
            if (ctr % 2 != 0)
            {
                Thread.sleep(5000);
                System.out.println(ctr);
                ctr++;
                notify();
            }
            else
            {
                wait();
            }
        }
    }

}
