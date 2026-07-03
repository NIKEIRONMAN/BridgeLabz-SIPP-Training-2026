interface MealPlan{String details();}
class VegetarianMeal implements MealPlan{public String details(){return "Vegetarian";}}
class VeganMeal implements MealPlan{public String details(){return "Vegan";}}
class KetoMeal implements MealPlan{public String details(){return "Keto";}}
class HighProteinMeal implements MealPlan{public String details(){return "High Protein";}}
class Meal<T extends MealPlan>{
    T plan;
    Meal(T p){plan=p;}
}
public class MealPlanDemo{
    public static <T extends MealPlan> void generate(Meal<T> meal){
        System.out.println(meal.plan.details());
    }
}