

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**all test cases from udebug AC! but WA verdict : took sol from : https://mohamedmosamin.wordpress.com/2013/07/15/uva-455-periodic-strings/
 * assumption : spaces in the end ! 
**/
public class UVA_455_PeriodicStrings {
	private static  int[] computeTemporaryArray(char pattern[]){
        int [] lps = new int[pattern.length];
        int index =0;
        for(int i=1; i < pattern.length;){
            if(pattern[i] == pattern[index]){
                lps[i] = index + 1;
                index++;
                i++;
            }else{
                if(index != 0){
                    index = lps[index-1]; // not sure 100% about this line 
                }else{
                    lps[i] =0;
                    i++;
                }
            }
        }
        return lps;
    }
    public static int KMP(char []text, char []pattern){
        int answer = 0 ;
        int lps[] = computeTemporaryArray(pattern);
        int i=0;
        int j=0;
        while(i < text.length && j < pattern.length){
            if(text[i] == pattern[j]){
                i++;
                j++;
                if(j == pattern.length){
                    answer ++;
                    j =0 ;
                 }
            }else{
                if(j!=0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
        }
       
        return answer;
    }
        

    
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int g = Integer.parseInt(br.readLine());
	br.readLine();
StringBuilder finalAnswer = new StringBuilder();
 while(g-->0){
	 String s =br.readLine();
	int [] values = new int [s.length()+1];
char [] arr =s.toCharArray();

for(int i =1 ; i<=arr.length;i++){
	char [] now = s.substring(0, i).toCharArray();
	int result = KMP(arr,now);
values [i] = result ;
if(i*result==s.length()){
	finalAnswer.append(i+"\n\n");
	break;
}
}


 }
 System.out.println(finalAnswer.replace(finalAnswer.length()-2, finalAnswer.length(), ""));
 }
}
