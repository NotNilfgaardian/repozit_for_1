package KADIL.food;

import java.util.Objects;

public abstract class Food implements Consumable, Nutritious {
    private String name;

    public Food (String  name)
    {
        this.name = name;
    }

    public Food ()
    {

    }

    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return Objects.equals(name, food.name);
    }

}
