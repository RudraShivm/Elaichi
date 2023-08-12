import java.util.*;
public class Food {
    private int ResturantID;
    private String Category;
    private String Name;
    private double Price;
 
    Food(int ResturantID,String Category,String Name,double Price){
        this.ResturantID=ResturantID;
        this.Name=Name;
        this.Category=Category;
        this.Price=Price;
    }

    public String getName() {
        return Name;
    }

    public double getPrice() {
        return Price;
    }

    public int getRestaurantID() {
        return ResturantID;
    }

    public String getCategory() {
        return Category;
    }
    public void display(){
        System.out.println("  Name : "+this.getName());
        System.out.println("  Category : "+this.getCategory());
        System.out.println("  Price : "+this.getPrice());
        System.out.println();
    }

    public void getDetails(){
        System.out.println("  Name : "+this.getName());
        System.out.println("  Resturant ID : "+this.getRestaurantID());
        System.out.println("  Category : "+this.getCategory());
        System.out.println("  Price : "+this.getPrice());
        System.out.println();
    }
}
