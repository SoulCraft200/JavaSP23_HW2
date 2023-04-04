import java.util.ArrayList;
public class Print {
    private static final String tline = "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(10) + "+" + "-".repeat(60) + "+";
    public static void header(){
        String[] headers = {"Sold Date", "Day" ,"Sold" , "Profit" , "Products"};
        System.out.println(tline);
        System.out.printf("|%-15s|%-15s|%-15s|%-10s|%-60s|" , headers[0],headers[1],headers[2],headers[3],headers[4]);
        System.out.println();
    }

    public static void line(){
        System.out.println(tline);
    }

    public static void Month(int mon){
        Print.line();
        System.out.printf("| %-117s |", SaleDate.getMonthName(mon));
        System.out.println();
        Print.line();
    }

    public static void itemLine(ArrayList<Product> productList,int count,ArrayList<String> items,double profit){
        if(productList.get(count - 1).getDate().dayOfWeek().toString().equals("SATURDAY")){ profit = profit - profit*(15/100.0);}
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
            System.out.println(" ".repeat((3 -(i % 3)) * 20) + "|");
        }
    }
}
