public class Print {
    private static final String tline = "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(10) + "+" + "-".repeat(50) + "+";
    public static void header(){
        String[] headers = {"Sold Date", "Day" ,"Sold" , "Profit" , "Products"};
        System.out.println(tline);
        System.out.printf("|%-15s|%-15s|%-15s|%-10s|%-50s|" , headers[0],headers[1],headers[2],headers[3],headers[4]);
        System.out.println();
    }

    public static void line(){
        System.out.println(tline);
    }
}
