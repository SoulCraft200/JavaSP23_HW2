import java.util.ArrayList;
public class Print {
    private static final String tableLine = "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(10) + "+" + "-".repeat(60) + "+";
    public static String header(){
        String result = "";
        String[] headers = {"Sold Date", "Day" ,"Sold" , "Profit" , "Products"};
        result += tableLine + "\n";
        result += String.format("|%-15s|%-15s|%-15s|%-10s|%-60s|" , headers[0],headers[1],headers[2],headers[3],headers[4]);
        return result;
    }

    public static String line() {
        return tableLine;
    }

    public static String Month(int mon){
        String result = "";
        result += tableLine + "\n";
        result += String.format("| %-117s |", SaleDate.getMonthName(mon)) + "\n";
        result += tableLine;
        return result;
    }

    public static String itemLine(ArrayList<Product> productList,int count,ArrayList<String> items,double profit){
        StringBuilder result = new StringBuilder();
        //Discount on saturdays
        if(productList.get(count - 1).getDate().dayOfWeek().toString().equals("SATURDAY")){ profit = profit - profit*(15/100.0);}
        result.append(String.format("|%-15s|%-15s|%-15s|%-10.2f|", productList.get(count - 1).getDate(), productList.get(count - 1).getDate().dayOfWeek(), items.size(), profit));
        int i;
        for (i = 0; i < items.size(); i++) {
            if (i == 0) {
                result.append(String.format("%-20s", items.get(i)));
            } else {
                result.append(String.format(",%-19s", items.get(i)));
            }
            if ((i + 1) % 3 == 0) {
                result.append("|");
                if (items.size() > 3){
                    result.append("\n|").append(" ".repeat(58)).append("|");
                }
            }
        }
        if (i < 3) {
            result.append(" ".repeat(((3 - i) * 20))).append("|");
        } else if (i % 3 != 0) {
            result.append(" ".repeat((3 - (i % 3)) * 20)).append("|");
        }
        return result.toString();
    }
}
