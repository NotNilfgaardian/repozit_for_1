package KADIL.food;

import java.util.Objects;

public class IceCream extends Food
{
    private String sirup;

    public IceCream(String sirup)
    {
        super("IceCream");
        if (sirup != null)
        {
            this.sirup = sirup.toLowerCase();
        }
    }

    public IceCream()
    {
        this("caramel");
    }

    @Override
    public String toString()
    {
        return super.toString() + " " + sirup;
    }

    public String getSirup()
    {
        return sirup;
    }

    public void setSirup(String sirup)
    {
        this.sirup = sirup;
    }

    @Override
    public void consume()
    {
        System.out.println(this + " cъедено");
    }

    @Override
    public boolean equals(Object o)
    {
        if (super.equals(o))
        {
            return Objects.equals(sirup, ((IceCream) o).sirup);
        }
        return false;
    }


    @Override
    public int calculateCalories()
    {
        if ("caramel".equals(this.sirup) || "карамель".equals(this.sirup))
        {
            return 25700;
        }
        if ("chocolate".equals(this.sirup) || "шоколад".equals(this.sirup))
        {
            return 269;
        }
        System.out.println("Я таких серопов не знаю (" + sirup  + ")\n...И считать не буду, вот");
        return 0;
    }
}
