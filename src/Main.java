import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //Creating file object.
        File file = new File("in.txt");
        //Scanning file.
        Scanner input = new Scanner(file);
        //Ignoring the first line (Header)
        input.nextLine();
        //List that stores the unordered products
        ArrayList<Product> tempProductList = new ArrayList<>();
        //Separating the line and creating products objects and adding it to the list.
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
        //List that stores the ordered products
        ArrayList<Product> productList = new ArrayList<>();
        //Ordering the products and adding it to the product list
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
        //Printing header
        Print.header();
        //Initializing the temp variables
        int count = 0;
        double profit = 0;
        ArrayList<String> items = new ArrayList<>();
        //Joining the products of the same day , discounting on saturdays ,and printing the table lines.
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
        //The bottom line of the table
        Print.line();

    }
}

