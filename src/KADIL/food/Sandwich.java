package KADIL.food;

import java.util.Objects;


public class Sandwich extends Food
{
    private String filing1;
    private String filing2;

    public String getFiling1()
    {
        return filing1;
    }

    public void setFiling1(String filing1)
    {
        if (filing1 != null)
        {
            this.filing1 = filing1.toLowerCase();
        }
    }

    public String getFiling2()
    {
        return filing2;
    }

    public void setFiling2(String filing2)
    {
        if(filing2 != null)
        {
            this.filing2 = filing2.toLowerCase();
        }
    }

    public Sandwich(String filing1, String filing2)
    {
        super("sandwich");
        if (filing1 != null)
        {
            this.filing1 = filing1.toLowerCase();
        }
        if (filing2 != null)
        {
            this.filing2 = filing2;
        }
    }

    public Sandwich(String filing1)
    {
            this(filing1, "ham");
    }

    public Sandwich()
    {
        this("mayonnaise", "ham");
    }

    @Override
    public String toString()
    {
        return super.toString() + " " + filing1 + " " + filing2;
    }

    @Override
    public boolean equals(Object o)
    {
        if (super.equals(o))
        {
            return Objects.equals(filing1, ((Sandwich) o).filing1) &&
                    Objects.equals(filing2, ((Sandwich) o).filing2);
        }
        return false;
    }


    @Override
    public void consume()
    {
        System.out.println(this + " cъеден");
    }
    private int calculateCalories(String param)
    {
        if ("ham".equals(param) || "ветчина".equals(param))
        {
            return  135;
        }
        if ("mayonnaise".equals(param) || "майонез".equals(param) || "мазик".equals(param) )
        {
            return  111;
        }
        if ("ketchup".equals(param) || "кетчуп".equals(param) || "кепчук".equals(param) )
        {
            return  28;
        }
        if ("ketones".equals(param) || "кетчунез".equals(param) )
        {
            return  70;
        }
        if ("salami".equals(param) || "колбаса".equals(param) )
        {
            return  284;
        }
        if ("cheese".equals(param) || "сыр".equals(param) )
        {
            return  182;
        }
        System.out.println("Я такой начинки как " + param + " не знаю, калорийность 0");
        return 0;
    }

    @Override
    public int calculateCalories()
    {
        int ccal = 242; // эта буличка
        ccal += calculateCalories(filing1);
        ccal += calculateCalories(filing2);
        return ccal;
    }
}
