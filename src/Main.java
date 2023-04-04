import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("in.txt");
        Scanner input = new Scanner(file);
        input.nextLine();
        ArrayList<Product> tempProductList = new ArrayList<>();
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
        ArrayList<Product> productList = new ArrayList<>();
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
        Print.header();
        int count = 0;
        double profit = 0;
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
            Print.itemLine(productList,count,items,profit);
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

