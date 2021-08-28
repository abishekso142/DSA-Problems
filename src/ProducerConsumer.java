public class ProducerConsumer
{

    public static void main(final String[] args)
    {
        final MessageQueue queue    = new MessageQueue();
        final Producer     producer = new Producer(queue);
        final Consumer     consumer = new Consumer(queue);

        producer.start();
        consumer.start();
    }

}

class MessageQueue
{

    private int n;

    public int getN()
    {
        synchronized (this)
        {
            try
            {
                wait();
            }
            catch (final InterruptedException e)
            {
                e.printStackTrace();
            }

            System.out.println("Got " + n);
            notify();
            return n;
        }

    }

    public void putN(final int num)
    {
        synchronized (this)
        {

            try
            {
                wait();
            }
            catch (final InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println("Put " + n);
            n = num;
        }

    }

}

class Producer extends Thread
{

    MessageQueue queue;

    public Producer(final MessageQueue queue)
    {
        super();
        this.queue = queue;
    }

    @Override
    public void run()
    {
        int j = 0;

        while (j <= 10)
        {
            queue.putN(j);
            j++;
        }

    }
}

class Consumer extends Thread
{

    MessageQueue queue;

    public Consumer(final MessageQueue queue)
    {
        super();
        this.queue = queue;
    }

    @Override
    public void run()
    {

        while (true)
        {
            queue.getN();
        }
    }
}
