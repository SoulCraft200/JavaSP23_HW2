import java.io.File;
import java.io.FileNotFoundException;
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

        Print.header();
        int mon = 0;
        int count = 0;
        ArrayList<String> items = new ArrayList<String>();
        while (count < productList.size()) {
            float profit = 0;
            int item = 0;
            if (productList.get(count).getDate().getMonth() > mon) {
                Print.Month(productList.get(count).getDate().getMonth());
                mon = productList.get(count).getDate().getMonth();
            }
            if (count == 0) {
                items.add(productList.get(count).getName());
                profit += productList.get(count).getPrice();
                item++;
                count++;
            }
            while (productList.get(count).getDate().getMonth() == productList.get(count - 1).getDate().getMonth()) {
                if (productList.get(count).getDate().getDay() == productList.get(count - 1).getDate().getDay()) {
                    items.add(productList.get(count).getName());
                    profit += productList.get(count).getPrice();
                    item++;
                    count++;
                } else{
                   break;
                }

            }
            System.out.printf("|%-15s|%-15s|%-15s|%-10.2f|", productList.get(count).getDate(), productList.get(count).getDate().dayOfWeek(), count, profit);
            int i;
            for (i = 0; i < items.size(); i++) {
                if (i == 0) {
                    System.out.printf("%-20s", items.get(i));
                } else {
                    System.out.printf(",%-20s", items.get(i));
                }
                if ((i + 1) % 3 == 0) {
                    System.out.println("|");
                }
            }
            if (i < 3){
                System.out.println(" ".repeat( (3 - i) * 20) + "|");
            }else if (i % 3 != 0){
                System.out.println(" ".repeat( (i%3) * 20) + "|");
            }

            items.clear();



        }
    }


}

