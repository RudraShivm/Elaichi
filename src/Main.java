import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
 
    private static final String INPUT_FILE_NAME = "restaurant.txt";
    private static final String INPUT_FILE_NAME_2 = "menu.txt";

    private static final String OUTPUT_FILE_NAME = "out1.txt";
    private static final String OUTPUT_FILE_NAME_2 = "out2.txt";


    public static void main(String[] args) throws Exception {

        List < Restaurant > restaurantList = new ArrayList < > ();
        List < Food > foodList = new ArrayList < > ();


        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        BufferedReader br2 = new BufferedReader(new FileReader(INPUT_FILE_NAME_2));


        while (true) {
            String line = br.readLine();
            if (line == null) break;
            String[] array = line.split(",(?! )", 0);
            List < String > Categories = new ArrayList < > ();
            if (array.length > 5) {
                for (int i = 5; i < array.length; i++) {
                    Categories.add(array[i]);
                }
            }
            Restaurant RestaurantEntry = new Restaurant(Integer.parseInt(array[0]), array[1], Double.parseDouble(array[2]), array[3], array[4], Categories);

            restaurantList.add(RestaurantEntry);

        }
        br.close();

        while (true) {
            String line2 = br2.readLine();
            if (line2 == null) break;
            String[] array = line2.split(",(?! )", 0);
            Food FoodEntry = new Food(Integer.parseInt(array[0]), array[1], array[2], Double.parseDouble(array[3]));
            foodList.add(FoodEntry);

        }
        br2.close();


        RestaurantDatabase RestaurantData = new RestaurantDatabase(restaurantList, foodList);


        RestaurantData.showMenu();

        long j = 0;
        Scanner scn = new Scanner(System.in);
        while (j < 20000000) {
            j++;
            boolean break_loop = false;
            int menuOption = -1;
            menuOption = scn.nextInt();
            switch (menuOption) {
                case 1:
                    RestaurantData.sub_menu_Search_Restaurant();
                    RestaurantData.sub_menu_Search_Restaurant_In_action();
                    RestaurantData.showMenu();
                    break;
                case 2:
                    RestaurantData.sub_menu_Search_Food_items();
                    RestaurantData.sub_menu_Search_Food_items_In_action();
                    RestaurantData.showMenu();
                    break;
                case 3:
                    scn.nextLine();
                    System.out.print("Enter Restaurant Details (ID,Name,Score,Price,ZIP Code,Categories[Upto 3]) : ");
                    String line3 = scn.nextLine();
                    if (line3 == null) break;
                    String[] array1 = line3.split(",(?! )", 0);
                    List < String > Categories1 = new ArrayList < > ();
                    if(array1.length<5){
                        System.out.println("Invalid input..");
                        RestaurantData.showMenu();
                        break;
                    }
                    if (array1.length > 5) {
                        for (int i = 5; i < array1.length; i++) {
                            Categories1.add(array1[i]);
                        }
                    }
                    RestaurantData.addRestaurant(Integer.parseInt(array1[0]), array1[1], Double.parseDouble(array1[2]), array1[3], array1[4], Categories1);
                    RestaurantData.showMenu();
                    break;
                case 4:
                    scn.nextLine();
                    System.out.print("Enter Food Details (Restaurant ID,Category,Name,Price) : ");
                    String line4 = scn.nextLine();
                    if (line4 == null) break;
                    String[] array2 = line4.split(",(?! )", 0);
                    if(array2.length<4){
                        System.out.println("Invalid input..");
                        RestaurantData.showMenu();
                        break;
                    }
                    RestaurantData.addFood(Integer.parseInt(array2[0]), array2[1], array2[2], Double.parseDouble(array2[3]));
                    RestaurantData.showMenu();
                    break;
                case 5:
                    System.out.println("Program Terminated and Database Updated successfully");
                    scn.close();
                    break_loop = true;
                    break;
                default:
                    System.out.println("Choose a valid option (1-5) : ");
                    RestaurantData.showMenu();
                    break;
            }

            if (break_loop) {
                break;
            }
        }
        scn.close();
        BufferedWriter bw3 = new BufferedWriter(new FileWriter(INPUT_FILE_NAME));
        BufferedWriter bw2 = new BufferedWriter(new FileWriter(INPUT_FILE_NAME_2));

        for (Restaurant restaurant: restaurantList) {
            bw3.write(restaurant.getID() + "," + restaurant.getName() + "," + restaurant.getScore() + "," + restaurant.getPrice() + "," + restaurant.getZIPcode());
            for (String str: restaurant.getCategories()) {
                bw3.write("," + str);
            }
            if (restaurant.getCategories().size() != 3) {
                bw3.write(",");
            }
            bw3.write(System.lineSeparator());

        }
        bw3.close();
        for (Food foo: foodList) {
            bw2.write(foo.getRestaurantID() + "," + foo.getCategory() + "," + foo.getName() + "," + foo.getPrice());
            bw2.write(System.lineSeparator());
        }
        bw2.close();


    }

}