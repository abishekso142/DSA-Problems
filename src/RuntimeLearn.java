public class RuntimeLearn
{

    public static void main(final String[] args)
    {

        final Runtime abc = Runtime.getRuntime();
        System.out.println(abc.availableProcessors());
        System.out.println(abc.freeMemory());
        // abc.gc();
        System.out.println(abc.freeMemory());
        System.out.println(abc.maxMemory());
        System.out.println(abc.totalMemory());
    }
}
