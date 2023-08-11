import java.util.*;

public class Restaurant {
    private int ID;
    private String Name;
    private double Score;
    private String Price;
    private String ZIPcode;
    private List<String> Categories;
 
    Restaurant(int ID,String Name,double Score,String Price, String ZIPcode ,List<String> Categories){
        this.Categories=Categories;
        this.ID=ID;
        this.Name=Name;
        this.Score=Score;
        this.Price=Price;
        this.ZIPcode=ZIPcode;
    }

    public String getName() {
        return Name;
    }

    public double getScore() {
        return Score;
    }

    public int getID() {
        return ID;
    }


    public List<String> getCategories() {
        return Categories;
    }

    public String getPrice() {
        return Price;
    }

    public String getZIPcode() {
        return ZIPcode;
    }

    public void getDetails(){
        System.out.println("  Restaurant Name : "+ this.getName());
        System.out.println("  Restaurant ID : "+this.ID);
        System.out.println("  Score : "+this.Score);
        System.out.println("  Price : "+this.Price);
        System.out.println("  ZIP Code : "+this.ZIPcode);
        System.out.print("  Categories : ");
        for(String str: Categories){
            System.out.print(str+", " );
        }
        System.out.println();
        System.out.println();
    }


}
