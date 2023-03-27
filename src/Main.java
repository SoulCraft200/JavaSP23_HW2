import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("in.txt");
        Scanner input = new Scanner(file);
        String tile = input.nextLine();
        ArrayList<Product> tempProductList = new ArrayList<Product>();
        while (input.hasNextLine()) {
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
            SaleDate soldDate = new SaleDate(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
            Product product = new Product(soldDate, pName, Double.parseDouble(soldPrice));
            tempProductList.add(product);
        }
        ArrayList<Product> productList = new ArrayList<Product>();
        while (tempProductList.size() != 0) {
            int min = 0;
            for (int k = 0; k < tempProductList.size(); k++) {
                if (tempProductList.get(k).getDate().getMonth() == tempProductList.get(min).getDate().getMonth()) {
                    while (tempProductList.get(k).getDate().getDay() < tempProductList.get(min).getDate().getDay()) {
                        min = k;
                    }
                } else if (tempProductList.get(k).getDate().getMonth() < tempProductList.get(min).getDate().getMonth()) {
                    min = k;
                }
            }
            productList.add(tempProductList.get(min));
            tempProductList.remove(min);
        }
        for (Product element : productList) {
            System.out.println(element);
        }
        float profit = 10.5F;
        Print.header();
        int mon = 1;
        int count = 0;
        int tempCount = 0;
        ArrayList<String> items = new ArrayList<>();
        while (count < productList.size()) {
            while ((count == 0) || (productList.get(count).getDate().getMonth() > productList.get(count - 1).getDate().getMonth())) {
                Print.line();
                System.out.printf("| %-107s |", SaleDate.getMonthName(mon));
                System.out.println("");
                Print.line();
                while ((tempCount == 0) || (productList.get(tempCount).getDate().getMonth() > productList.get(tempCount + 1).getDate().getMonth())) {
                    items.add(productList.get(tempCount).getName());
                    tempCount++;
                }
                System.out.printf("|%-15s|%-15s|%-15s|%-10.2f|", productList.get(count).getDate(), productList.get(count).getDate().dayOfWeek(), count, profit);
                for(int i = 0; i<items.size();i++){
                    if (i == 0) {
                        System.out.printf(items.get(i));
                    }else{
                        System.out.printf(",%s",items.get(i));
                    }
                    if((i+1)%5==0){
                        System.out.println("");
                    }
                    System.out.println("");
                    count++;
                    tempCount = 0;
                }
            }
            while (productList.get(count).getDate().getMonth() == productList.get(count - 1).getDate().getMonth()) {
                while (productList.get(tempCount).getDate().getMonth() == productList.get(tempCount + 1).getDate().getMonth()) {
                    items.add(productList.get(tempCount).getName());
                    tempCount++;

                }
            System.out.printf("|%-15s|%-15s|%-15s|%-10.2f|", productList.get(count).getDate(), productList.get(count).getDate().dayOfWeek(), count, profit);
                System.out.printf("|%-15s|%-15s|%-15s|%-10.2f|", productList.get(count).getDate(), productList.get(count).getDate().dayOfWeek(), count, profit);
                for(int i = 0; i<items.size();i++){
                    if (i == 0) {
                        System.out.printf(items.get(i));
                    }else{
                        System.out.printf(",%s",items.get(i));
                    }
                    if((i+1)%5==0){
                        System.out.println("");
                    }
                    System.out.println("");
                    count++;
                }
            }

            if ((count < productList.size() - 1) && (productList.get(count).getDate().getMonth() - productList.get(count + 1).getDate().getMonth() == 1)) {
                mon++;
            } else if (count < productList.size() - 1) {
                mon = productList.get(count + 1).getDate().getMonth();
            }
            items.clear();
        }
        Print.line();


    }
}
