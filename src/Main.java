import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    Random rand = new Random();
//    ArrayList<Integer> a = new ArrayList<Integer>();
//        for(int i =0 ; i< 10 ; i++ ){
//        a.add(rand.nextInt(10));
//    }
//        System.out.println(a.toString());
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
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the input file name: ");
        String name = in.next();
        File file = new File(name);
        Scanner input = new Scanner(file);

    }
}
