

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class UVA_10071_BackToHighSchoolPhysics {
public static void main(String []args)throws Exception
{
	BufferedReader  br = new BufferedReader( new InputStreamReader(System.in));
	String line = null ;
	while((line=br.readLine())!=null){
	String[] s = line.split(" ");
	int v = Integer.parseInt(s[0]);
	int t = 2 * Integer.parseInt(s[1]);
	System.out.println(v*t);
}}
	
}
