package KADIL;

import KADIL.food.Food;
import KADIL.food.IceCream;
import KADIL.food.Sandwich;
import KADIL.food.Tea;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Comparator;



public class Breackfast
{
    private static final int CAPACITY = 20;
    private Food[] foodList = new Food[CAPACITY];

    private int count = 0;

    public void addFood(Food food)
    {
        if (count < CAPACITY)
        {
            foodList[count] = food;
            count++;
        }
    }

    public void addFood(String foodClassName)
    {
        try
        {
            Class myClass = Class.forName("KADIL.food." + foodClassName);
            Constructor constructor = myClass.getConstructor();
            Food food = (Food) constructor.newInstance();
            addFood(food);
        } catch (ClassNotFoundException e)
        {
            System.err.println("Этот продукт не может быть включён в завтрак: " + foodClassName);
            e.printStackTrace();
        } catch (NoSuchMethodException e)
        {
            System.err.println("У вас нет конструктора без параметров. Ви що? (вот у него нет, если чо) " + foodClassName );
           e.printStackTrace();
        } catch (InstantiationException e)
        {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    public void addFood(String foodClassName, String param1)
    {
        try
        {
            Class myClass = Class.forName("KADIL.food." + foodClassName);
            Constructor constructor = myClass.getConstructor(String.class);
            Food food = (Food) constructor.newInstance(param1);
            addFood(food);
        } catch (ClassNotFoundException e)
        {
            System.err.println("Этот продукт не может быть включён в завтрак: " + foodClassName);
//            e.printStackTrace();
        } catch (NoSuchMethodException e)
        {
            System.err.println("ТУТ НЕТ СТОЛЬКО ПОРАМЕТРОВ(АДЫН ШТУКА), АСТАНАВИТЕС " + foodClassName );
//            e.printStackTrace();
        } catch (InstantiationException e)
        {
//            e.printStackTrace();
        } catch (IllegalAccessException e)
        {
//            e.printStackTrace();
        } catch (InvocationTargetException e)
        {
            e.printStackTrace();
        }

    }

    public void addFood(String foodClassName, String param1, String param2)
    {
        try
        {
            Class myClass = Class.forName("KADIL.food." + foodClassName);
            Constructor constructor = myClass.getConstructor(String.class, String.class);
            Food food = (Food) constructor.newInstance(param1, param2);
            addFood(food);
        } catch (ClassNotFoundException e)
        {
            System.err.println("Этот продукт не может быть включён в завтрак: " + foodClassName);
            e.printStackTrace();
        } catch (NoSuchMethodException e)
        {
            System.err.println("ТУТ НЕТ СТОЛЬКО ПОРАМЕТРОВ(ДВА ШТУКА) " + foodClassName );
            e.printStackTrace();
        } catch (InstantiationException e)
        {
  //          e.printStackTrace();
        } catch (IllegalAccessException e)
        {
  //          e.printStackTrace();
        } catch (InvocationTargetException e)
        {
  //          e.printStackTrace();
        }

    }

    @Override
    public String toString()
    {
        String buff = "Your breackfast: \n{\n";
        for(int i = 0; i<count; i++)
        {
            buff += foodList[i];
            buff += "\n";
        }
        buff += "}\n";
        return buff;
    }

    public Food getFood(int index)
    {
        if (index >= 0 && index < count)
        {
            return foodList[index];
        }
        return null;
    }

    public int countEqualFood(Food food)
    {
        if (food == null)
        {
            return 0;
        }
        int countEq = 0;
        for (int i = 0; i < count; i++)
        {
            if (food.equals(foodList[i]))
            {
                countEq++;
            }
        }
        return countEq;
    }

    public int getCount()
    {
        return count;
    }

    public void setFoodList(Food[] foodList)
    {
        this.foodList = foodList;
    }

    public void sort()
    {
        Arrays.sort(foodList, new Comparator<Food>()
        {
            public int compare(Food f1, Food f2)
            {
                if (f1 == null) return 1;
                if (f2 == null) return -1;
                int rezult = ((Food) f1).getName().compareTo(((Food) f2).getName());
                if (rezult != 0)
                {
                    return rezult;
                }
                if (f1 instanceof IceCream)
                {
                    IceCream ic1 = (IceCream) f1;
                    IceCream ic2 = (IceCream) f2;
                    return (ic1.getSirup().length() - ic2.getSirup().length()) * -1;
                }
                if (f1 instanceof Tea)
                {
                    Tea t1 = (Tea) f1;
                    Tea t2 = (Tea) f2;
                    return (t1.getColor().length() - t2.getColor().length());
                }
                if (f1 instanceof Sandwich)
                {
                    Sandwich sand1 = (Sandwich) f1;
                    Sandwich sand2 = (Sandwich) f2;
                    if (sand1.getFiling1().length() - sand2.getFiling1().length()!=0)
                    {
                        return (sand1.getFiling1().length() - sand2.getFiling1().length());
                    }
                    else
                    {
                        return (sand1.getFiling2().length() - sand2.getFiling2().length());
                    }
                }
                return 0;
            }
        });
    }

}
