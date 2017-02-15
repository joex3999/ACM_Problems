

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CF_550A_TwoSubStrings {

    public static void main(String args[])
    {
        Scanner z=new Scanner(System.in);
        String a=z.next();
        
        if(a.contains("AB") && a.contains("BA"))
        {
            if(a.replaceFirst("AB", "Z").contains("BA") || a.replaceFirst("BA", "Z").contains("AB"))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        else
        {
            if(a.replaceFirst("AB", "Z").contains("BA") && a.replaceFirst("BA", "Z").contains("AB"))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }}
