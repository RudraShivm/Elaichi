import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
public class RestaurantDatabase {


    private List<Restaurant> restaurantList;
    private List<Food> foodList;
    private List<String> Categories=new ArrayList<>();
    RestaurantDatabase(List<Restaurant> restaurantList, List<Food> foodList){
        this.restaurantList=restaurantList;
        this.foodList=foodList;
 
        for(Restaurant restaurant: restaurantList){
            for(String str : restaurant.getCategories()) {
                if (!Categories.contains(str)){
                    Categories.add(str);
                }
            }
        }
    }

//    ain Menu:
//            1) Search Restaurants
//2) Search Food Items
//3) Add Restaurant
//4) Add Food Item to the Menu
//5) Exit System
    public void showMenu(){
        System.out.println("Main Menu: ");
        System.out.println("1) Search Restaurants ");
        System.out.println("2) Search Food Items ");
        System.out.println("3) Add Restaurant ");
        System.out.println("4) Add Food Item to the Menu ");
        System.out.println("5) Exit System ");
        System.out.println();
    }

//    Restaurant Searching Options:1) By Name
//2) By Score
//3) By Category
//4) By Price
//5) By Zip Code
//6) Different Category Wise List of Restaurants
//7) Back to Main Menu

    public void sub_menu_Search_Restaurant(){
        System.out.println(" Restaurant Searching Options: ");
        System.out.println(" 1) By Name");
        System.out.println(" 2) By Score");
        System.out.println(" 3) By Category");
        System.out.println(" 4) By Price");
        System.out.println(" 6) Different Category Wise List of Restaurants ");
        System.out.println(" 7) Back to Main Menu");
        System.out.println();
    }

//    Food Item Searching Options:
//            1) By Name
//2) By Name in a Given Restaurant
//3) By Category
//4) By Category in a Given Restaurant
//5) By Price Range
//6) By Price Range in a Given Restaurant
//7) Costliest Food Item(s) on the Menu in a Given Restaurant
//8) List of Restaurants and Total Food Item on the Menu
//9) Back to Main Menu

    public void sub_menu_Search_Food_items(){
        System.out.println(" Food Item Searching Options: ");
        System.out.println(" 1) By Name ");
        System.out.println(" 2) By Name in a Given Restaurant ");
        System.out.println(" 3) By Category ");
        System.out.println(" 4) By Category in a Given Restaurant ");
        System.out.println(" 5) By Price Range");
        System.out.println(" 6) By Price Range in a Given Restaurant ");
        System.out.println(" 7) Costliest Food Item(s) on the Menu in a Given Restaurant ");
        System.out.println(" 8) List of Restaurants and Total Food Item on the Menu ");
        System.out.println(" 9) Back to Main Menu ");
        System.out.println();
    }

    public void sub_menu_Search_Restaurant_In_action(){
        Scanner scn= new Scanner(System.in);
        while(true){
            int menuOption = -1;
            menuOption = scn.nextInt();
            String str;
            double low, high;
            switch (menuOption) {
                case 1:
                    scn.nextLine();
                    System.out.print(" Enter Restaurant Name : ");
                    str=scn.nextLine();
                    searchRestaurantByName(str);
                    sub_menu_Search_Restaurant();
                    break;
                case 2:
                    // scn.nextLine();
                    System.out.print(" Enter lowest and highest price : ");
                    low = scn.nextInt();
                    high = scn.nextInt();
                    System.out.println(low+" "+high);
                    searchRestaurantByScore(low, high);
                    sub_menu_Search_Restaurant();
                    break;
                case 3:
                    scn.nextLine();
                    System.out.print(" Enter Category Name : ");
                    searchRestaurantByCategory(scn.nextLine());
                    sub_menu_Search_Restaurant();
                    break;
                case 4:
                    scn.nextLine();
                    System.out.print(" Enter Desired Price : ");
                    searchRestaurantByPrice(scn.nextLine());
                    sub_menu_Search_Restaurant();
                    break;
                case 5:
                    scn.nextLine();
                    System.out.print(" Enter Desired ZIP Code : ");
                    searchRestaurantByZIPcode(scn.nextLine());
                    sub_menu_Search_Restaurant();
                    break;
                case 6:
                    printCategoryWise();
                    sub_menu_Search_Restaurant();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Choose a valid option (1-7) : ");
                    sub_menu_Search_Restaurant();
                    break;
            }
        }
    }


    public void sub_menu_Search_Food_items_In_action(){
        Scanner scn= new Scanner(System.in);
        while(true){
            int menuOption = -1;
            menuOption = scn.nextInt();
            String str1,str2;
            double low, high;
            switch (menuOption) {
                case 1:
                    scn.nextLine();
                    System.out.print(" Enter Food Name : ");
                    str1=scn.nextLine();
                    searchFoodByName(str1);
                    sub_menu_Search_Food_items();
                    break;
                case 2:
                    scn.nextLine();
                    System.out.print(" Enter Restaurant Name : ");
                    str1=scn.nextLine();
                    // System.out.print(str1);
                    System.out.print(" Enter Food Name : ");
                    str2=scn.nextLine();
                    searchFoodByNameInARestaurant(str2, str1);
                    sub_menu_Search_Food_items();
                    break;

                case 3:
                    scn.nextLine();
                    System.out.print(" Enter Category Name : ");
                    str1=scn.nextLine();
                    searchFoodByCategory(str1);
                    sub_menu_Search_Food_items();
                    break;
                case 4:
                    scn.nextLine(); 
                    System.out.print(" Enter Category Name : ");
                    str1=scn.nextLine();
                    System.out.print(" Enter Resturant Name : ");
                    str2=scn.nextLine();
                    searchFoodByCategoryInARestaurant(str1,str2);
                    sub_menu_Search_Food_items();
                    break;
                case 5:
                    System.out.print(" Enter lowest and highest price : ");
                    low=scn.nextInt();
                    high=scn.nextInt();
                    searchFoodwithPrice(low,high);
                    sub_menu_Search_Food_items();
                    break;
                case 6:
                    System.out.print(" Enter lowest and highest price : ");
                    low=scn.nextInt();
                    high=scn.nextInt();
                    scn.nextLine();
                    System.out.print(" Enter Resturant Name : ");
                    str2=scn.nextLine();
                    searchFoodwithPriceInARestaurant(low,high,str2);
                    sub_menu_Search_Food_items();
                    break;
                case 7:
                    scn.nextLine();
                    System.out.print(" Enter Restaurant Name : ");
                    costliestFoodItem(scn.nextLine());
                    sub_menu_Search_Food_items();
                    break;
                case 8:
                    totalItemsInEveryRestaurant();
                    sub_menu_Search_Food_items();
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Choose a valid option (1-9) : ");
                    sub_menu_Search_Restaurant();
                    break;
            }
        }
    }
 
    public boolean restaurantsearch(String Name){
        for(Restaurant restaurant: restaurantList){
            if(restaurant.getName().equals(Name)){
                return true;
            }
        }
        return false;
    }
    public boolean restaurantsearchWithID(int ID){
        for(Restaurant restaurant: restaurantList){
            if(restaurant.getID()==ID){
                return true;
            }
        }
        return false;
    }
    public void addRestaurant(int ID,String Name,double Score,String Price, String ZIPcode ,List<String> Categories){
        if(restaurantsearch(Name)){
            System.out.println("Restaurant with this name already exists ");
            return;
        }
        if(Categories.size()>3){
            System.out.println("A restaurant must have at least one and at most three Categories ");
            return;
        }
        Restaurant restaurant=new Restaurant(ID,Name,Score,Price,ZIPcode,Categories);
        restaurantList.add(restaurant);
        System.out.println("New restaurant added to the list successfully");
        System.out.println();
    }


    public void addFood(int ResturantID,String Category,String Name,double Price){
        if(!restaurantsearchWithID(ResturantID)){
            System.out.println("No such restaurant with this ID ");
            return;
        }
        Food newFood=new Food(ResturantID,Category,Name,Price);        //repeat possible??
        foodList.add(newFood);
        System.out.println("New food added to the menu successfully");
        System.out.println();
    }

    public void searchRestaurantByName(String Name){
        Name=Name.toLowerCase();
        for(Restaurant res: restaurantList){
            if(res.getName().toLowerCase().equals(Name)){
                res.getDetails();
                return;
            }
        }
        System.out.println(" No such restaurant with this name ");
        return;
    }

    public void searchRestaurantByScore(double low,double high){
        int count=0;
        for(Restaurant res: restaurantList){
            if(res.getScore()<=high && res.getScore()>=low){
                res.getDetails();
                count++;
            }
        }
        if(count==0) {
            System.out.println(" No such restaurant with this score range ");
        }
        return;
    }

    public void searchRestaurantByCategory(String Category){
        Category=Category.toLowerCase();
        int count=0;
        for(Restaurant res: restaurantList){
            for(String str : res.getCategories()) {
                if (str.toLowerCase().equals(Category)) {
                    res.getDetails();
                    count++;
                }
            }
        }
        if(count==0) {
            System.out.println(" No such restaurant with this category ");
        }
        return;
    }

    public void searchRestaurantByPrice(String Price){
        int count=0;
        for(Restaurant res: restaurantList){
            if(res.getPrice().equals(Price)){
                res.getDetails();
                count++;
            }
        }
        if(count==0) {
            System.out.println(" No such restaurant with this price ");
        }
        return;
    }

    public void searchRestaurantByZIPcode(String ZIPcode){
        int count=0;
        for(Restaurant res: restaurantList){
            if(res.getZIPcode().equals(ZIPcode)){
                res.getDetails();
                count++;
            }
        }
        if(count==0) {
            System.out.println(" No such restaurant with this zip code ");
        }
        return;
    }

    public void printCategoryWise(){
        for(String str : Categories){
            System.out.print(" "+str + " : ");
            for(Restaurant restaurant : restaurantList){
                if(restaurant.getCategories().contains(str)){
                    System.out.print(restaurant.getName()+ ", ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    public void searchFoodByName(String Name){
        Name=Name.toLowerCase();
        for(Food foo: foodList){
            if(foo.getName().toLowerCase().equals(Name)){
                foo.getDetails();
                return;
            }
        }
        System.out.println(" No such food item with this name ");
        return;
    }

    int getRestaurantIDFromRestaurantName(String RestaurantName){
        RestaurantName=RestaurantName.toLowerCase();
        int RestaurantID=-1;
        boolean found=false;
        for(Restaurant res : restaurantList){
            if(res.getName().toLowerCase().equals(RestaurantName)){
                found=true;
                RestaurantID=res.getID();
                break;
            }
        }

        return RestaurantID;
    }
    public void searchFoodByNameInARestaurant(String Name,String RestaurantName){
        Name=Name.toLowerCase();
        int RestaurantID=getRestaurantIDFromRestaurantName(RestaurantName);
        if(RestaurantID==-1){
            System.out.println(" No such Restaurant with this name ");
            return;
        }
        for(Food foo: foodList){
            if(foo.getName().toLowerCase().equals(Name) && foo.getRestaurantID()==RestaurantID){
                foo.getDetails();
                return;
            }
        }
        System.out.println(" No such food item with this name on the menu of this restaurant ");
        return;
    }

    public void searchFoodByCategory(String Category){
        Category=Category.toLowerCase();
        int count=0;
        for(Food foo: foodList){
            if (foo.getCategory().toLowerCase().equals(Category)) {
                foo.getDetails();
                count++;
            }
        }
        if(count==0) {
            System.out.println(" No such restaurant with this category ");
        }
        return;
    }

    public void searchFoodByCategoryInARestaurant(String Category,String RestaurantName){
        Category=Category.toLowerCase();
        int RestaurantID=getRestaurantIDFromRestaurantName(RestaurantName);
        if(RestaurantID==-1){
            System.out.println(" No such Restaurant with this name ");
            return;
        }

        int count=0;
        for(Food foo: foodList){
            if (foo.getCategory().toLowerCase().equals(Category) && foo.getRestaurantID()==RestaurantID) {
                foo.getDetails();
                count++;
            }
        }
        if(count==0) {
            System.out.println(" No such food item with this category on the menu of this restaurant ");
        }
        return;
    }

    public void searchFoodwithPrice(double low,double high){
        int count=0;
        for(Food foo : foodList){
            if(foo.getPrice()<=high && foo.getPrice()>=low){
                foo.getDetails();
                count++;
            }
        }
        if(count==0){
            System.out.println(" No such food item with this price range");
        }
        return;
    }

    public void searchFoodwithPriceInARestaurant(double low,double high,String RestaurantName){
        int RestaurantID=getRestaurantIDFromRestaurantName(RestaurantName);
        if(RestaurantID==-1){
            System.out.println(" No such Restaurant with this name ");
            return;
        }

        int count=0;
        for(Food foo : foodList){
            if(foo.getPrice()<=high && foo.getPrice()>=low && foo.getRestaurantID()==RestaurantID){
                foo.getDetails();
                count++;
            }
        }
        if(count==0){
            System.out.println(" No such food item with this price range");
        }
        return;
    }

    public void costliestFoodItem(String RestaurantName){
        int RestaurantID=getRestaurantIDFromRestaurantName(RestaurantName);
        if(RestaurantID==-1){
            System.out.println(" No such Restaurant with this name ");
            return;
        }
        double maxPrice=-1;
        for(Food foo : foodList){
            if(foo.getPrice()>maxPrice && foo.getRestaurantID()==RestaurantID){
                maxPrice=foo.getPrice();
            }
        }
        int i=0;
        for(Food foo: foodList) {
            if (foo.getPrice() == maxPrice && foo.getRestaurantID()==RestaurantID) {
                if(i==0){
                    System.out.println(" Costliest item(s) in "+RestaurantName+" : ");
                }
                foo.getDetails();
                i++;
            }
        }
    }

    // public void totalItemsInEveryRestaurant(){
    //     List<String> ResturantNameArrayUsingID=new ArrayList<>(restaurantList.size()+100);
    //     List<Integer> FoodNumberUsingRestaurantID=new ArrayList<>(restaurantList.size()+100);
    //     for(Restaurant restaurant:restaurantList){
    //         ResturantNameArrayUsingID.set(restaurant.getID(),restaurant.getName());
    //         System.out.print(restaurant.getID()+" ");
    //     }

    //     for(Food foo: foodList){
    //         int num=FoodNumberUsingRestaurantID.get(foo.getRestaurantID());
    //         num++;
    //         FoodNumberUsingRestaurantID.set(foo.getRestaurantID(), num);
    //     }

    //     for(int i=1;i<restaurantList.size()+1;i++){
    //         System.out.println(ResturantNameArrayUsingID.get(i)+" : "+ FoodNumberUsingRestaurantID.get(i));
    //     }
    // }

    public void totalItemsInEveryRestaurant() {
        Map<Integer, String> restaurantNameMap = new HashMap<>();
        Map<Integer, Integer> foodCountMap = new HashMap<>();
    
        for (Restaurant restaurant : restaurantList) {
            restaurantNameMap.put(restaurant.getID(), restaurant.getName());
            foodCountMap.put(restaurant.getID(), 0);
        }
    
        for (Food foo : foodList) {
            int restaurantID = foo.getRestaurantID();
            foodCountMap.put(restaurantID, foodCountMap.getOrDefault(restaurantID, 0) + 1);
        }
    
        for (Map.Entry<Integer, String> entry : restaurantNameMap.entrySet()) {
            int restaurantID = entry.getKey();
            String restaurantName = entry.getValue();
            int foodCount = foodCountMap.getOrDefault(restaurantID, 0);
            System.out.println(restaurantName + " : " + foodCount);
        }
    }
    

}


