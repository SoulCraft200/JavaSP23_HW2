import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    Random rand = new Random();
//    int j = 0;
//        while(a.size()  != 0){
//        int min = 0;
//        for(int k = 0; k < a.size() ; k++){
//            if (a.get(k) < a.get(min)){
//                min = k;
//            }
//        }
//        System.out.println(a.get(min));
//        a.remove(min);
//    }
//        System.out.println(a.toString());
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner in = new Scanner(System.in);
//        System.out.print("Enter the input file name: ");
//        String name = in.next();
        File file = new File("in.txt");
        Scanner input = new Scanner(file);
        String tile = input.nextLine();
        ArrayList<Product> productList = new ArrayList<Product>();
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
            productList.add(product);
        }
        System.out.println(productList.toString());
    }
}
