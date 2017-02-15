
import java.util.*;

//taken from : https://tanjinaislam.wordpress.com/2011/06/23/dp-problem-let-me-count-the-ways-2/
public class UVA_357_LetMeCountTheWays{
  public static void main(String args[])throws Exception{
 
    long nWay [] = new long[40000];  // SIZE
    int coin [] = {50,25,10,5,1};  // ORDER
    int types = 5;
    int i,j,taken,change;
    Scanner sc = new Scanner(System.in);
 
    nWay[0] = 1;
    for(i = 0; i<types; i++){
      taken = coin[i];
      for(j = taken; j<=30000; j++){
        nWay[j]+= nWay[j-taken];
 
      }
 
    }
// 
//    while(sc.hasNextInt()){
//      change = sc.nextInt();
// 
//      if(nWay[change] == 1)
//        System.out.println("There is only "+nWay[change]+" way to produce "+change+" cents change.");
//      else
//        System.out.println("There are "+nWay[change]+" ways to produce "+change+" cents change.");
// 
//    }
//  }
}}