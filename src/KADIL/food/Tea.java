package KADIL.food;

import java.util.Objects;

public class Tea extends Food
{
    private String color;

    public Tea(String color)
    {
        super("Чай");
        if (color != null)
        {
            this.color = color.toLowerCase();
        }
    }

    public Tea()
    {
        this("чёрный");
    }

    @Override
    public String toString()
    {
        return super.toString() + " " + color;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    @Override
    public void consume()
    {
        System.out.println(this + " выпит");
    }

    @Override
    public boolean equals(Object o)
    {
        if (super.equals(o))
        {
            return Objects.equals(color, ((Tea) o).color);
        }
        return false;
    }

    @Override
    public int calculateCalories()
    {
        if ("black".equals(this.color) || "чёрный".equals(this.color))
        {
            return 0;
        }
        if ("зелёный".equals(this.color) || "green".equals(this.color))
        {
            return 0;
        }
        System.out.println("Да вобщем-то пофиг, если без сахара, они все без калорий");
        return 0;
    }
}
