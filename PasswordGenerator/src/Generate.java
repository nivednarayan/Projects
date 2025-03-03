import java.util.*;
public class Generate {
    public static String generate(int n){
        Random rand = new Random();
        String capital = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String small = "abcdefghijklmnopqrstuvxyz";
        String symbols = "!@#$%^&*()/";
        StringBuilder password = new StringBuilder();
        int b;
        for(int i = 0; i < n; i++){
            int a = rand.nextInt(4);
            if(a == 0){
                b = rand.nextInt(capital.length());
                password.append(capital.charAt(b));
            }
            else if(a == 1){
                b = rand.nextInt(small.length());
                password.append(small.charAt(b));
            }
            else if(a == 2){
                b = rand.nextInt(10);
                password.append(b);
            }
            else{
                b = rand.nextInt(symbols.length());
                password.append(symbols.charAt(b));
            }
        }
        return password.toString();
    }
}
