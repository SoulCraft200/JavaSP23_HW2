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

        int count = 0;
        double profit = 0;
        int mon = 0;
        ArrayList<String> items = new ArrayList<>();
        while (count < productList.size()) {
            if (count == 0) {
                Print.Month(productList.get(count).getDate().getMonth());
                items.add(productList.get(count).getName());
                profit += productList.get(count).getPrice();
                count++;
            }
            while ((count < productList.size()) && (productList.get(count).getDate().getMonth() == productList.get(count - 1).getDate().getMonth())) {
                if (productList.get(count).getDate().getDay() == productList.get(count - 1).getDate().getDay()) {
                    items.add(productList.get(count).getName());
                    profit += productList.get(count).getPrice();
                    count++;
                }else {break;}

            }
            System.out.printf("|%-15s|%-15s|%-15s|%-10.2f|", productList.get(count - 1).getDate(), productList.get(count - 1).getDate().dayOfWeek(), items.size(), profit);
            int i;
            for (i = 0; i < items.size(); i++) {
                if (i == 0) {
                    System.out.printf("%-20s", items.get(i));
                } else {
                    System.out.printf(",%-19s", items.get(i));
                }
                if ((i + 1) % 3 == 0) {
                    System.out.println("|");
                    if (items.size() > 3){
                        System.out.print("|"+" ".repeat(58)+"|");
                    }
                }
            }
            if (i < 3) {
                System.out.println(" ".repeat(((3 - i) * 20 )) + "|");
            } else if (i % 3 != 0) {
                System.out.println(" ".repeat(((i % 3) * 20) + i%3) + "|");
            }
            profit = 0;
            items.clear();
            if  ((count < productList.size()) && productList.get(count).getDate().getMonth() == productList.get(count - 1).getDate().getMonth()) {
                if (productList.get(count).getDate().getDay() > productList.get(count - 1).getDate().getDay()) {
                    items.add(productList.get(count).getName());
                    profit += productList.get(count).getPrice();
                    count++;
                }
            } else if ((count < productList.size()) && productList.get(count).getDate().getMonth() > productList.get(count - 1).getDate().getMonth()) {
                Print.Month(productList.get(count).getDate().getMonth());
                items.add(productList.get(count).getName());
                profit += productList.get(count).getPrice();
                count++;
            }


        }
        Print.line();

    }
}

