import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner in = new Scanner(System.in);
//        System.out.print("Enter the input file name: ");
//        String name = in.next();
        File file = new File("in.txt");
        Scanner input = new Scanner(file);
        String tile = input.nextLine();
        ArrayList<Product> tempProductList = new ArrayList<Product>();
        while(input.hasNextLine()){
            String line = input.nextLine();
            Scanner inLine = new Scanner(line);
            inLine.useDelimiter(",");
            String date = inLine.next().trim();
            String pName = inLine.next().trim();
            String soldPrice = inLine.next().trim();
            Scanner inDate = new Scanner(date);
            inDate.useDelimiter("-");
            String year = inDate.next().trim();
            String month = inDate.next().trim();
            String day = inDate.next().trim();
            SaleDate soldDate = new SaleDate(Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(day));
            Product product = new Product(soldDate,pName,Double.parseDouble(soldPrice));
            tempProductList.add(product);
        }
        ArrayList<Product> productList = new ArrayList<Product>();
        while(tempProductList.size()  != 0){
            int min = 0;
            for(int k = 0; k < tempProductList.size() ; k++){
                if(tempProductList.get(k).getDate().getMonth() == tempProductList.get(min).getDate().getMonth()){
                    while(tempProductList.get(k).getDate().getDay() <= tempProductList.get(min).getDate().getDay()){
                        min = k;
                    }
                }else if(tempProductList.get(k).getDate().getMonth() < tempProductList.get(min).getDate().getMonth()){
                    min = k;
                }
            }
            productList.add(tempProductList.get(min));
            tempProductList.remove(min);
        }
        for(Product element:productList){
            System.out.println(element);
        }

    }
}
