package solution;

public class Wolf extends Canine
{
    public Wolf(Zoo myZoo, String name)
    {
        super(myZoo, name);
    }
    

    public void makeNoise()
    {
        System.out.println("growl...");
    }

/**
 * eats
 */
    public void eat()
    {
        System.out.println("rip with teeth..");
        setHungerLevel(getHungerLevel()-2);
    }


}
