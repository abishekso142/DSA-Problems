public class GenericsEx<T extends Number, V extends Animal>
{

    public static void main(final String[] args)
    {
        demoMethod(5, new Dog());
        demoMethod(7.07, new Animal(6));
    }

    public void methodWithSelfTypeArg(final GenericsEx<T, V> ob)
    {
        System.out.println(ob);
    }

    public static <T extends Number, V extends Animal> boolean demoMethod(final T num, final V arg)
    {
        return false;
    }

    @Override
    public String toString()
    {
        return "GenericsEx [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

}

class Animal
{

    private final int numLegs;

    public Animal(final int numLegs)
    {
        super();
        this.numLegs = numLegs;
    }

}

class Dog extends Animal
{

    public Dog()
    {
        super(4);
    }
}
