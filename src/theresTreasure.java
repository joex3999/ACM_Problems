

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class theresTreasure {
public static void main(String []args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   String s = (String )br.readLine();
   int ctr = 1;
   while(!s.equals("END")){
	   double xSoFar = 0 ;
	   double ySoFar = 0 ;
	   	String [] current = s.split(",");

    for(int i =0 ; i < current.length;i++){
    	int pos = 1 ;
    	
    	
    	for(int j =0 ; j<current[i].length();j++){
    		if(!(Character.isDigit(current[i].charAt(j)))){
    			pos = j ; break ;
    		}
    	}

    	double num =  Double.parseDouble(current[i].substring(0, pos));

    	String curr = current[i].substring(pos);
    	
 	switch(curr){
    	case "N": ySoFar += num ;break ;
    	case "E" : xSoFar += num ;break ;
    	case "W":	xSoFar -=num ;break ;
    	case "SW":	ySoFar-= num*Math.cos(Math.PI/4); xSoFar -= num*Math.cos(Math.PI/4);	break ;
    	case "S":		ySoFar -= num ;break ;
    	case"NE":			ySoFar+= num*Math.cos(Math.PI/4); xSoFar += num*Math.cos(Math.PI/4);break ;
    	case "SE":			ySoFar-= num*Math.cos(Math.PI/4); xSoFar += num*Math.cos(Math.PI/4);break ;
    	case "NW": 		ySoFar+= num*Math.cos(Math.PI/4); xSoFar -= num*Math.cos(Math.PI/4);	break ;
   	case "N.": ySoFar += num ;break ;
    	case "E." : xSoFar += num ;break ;
    	case "W.":	xSoFar -=num ;break ;
    	case "SW.":	ySoFar-= num*Math.cos(Math.PI/4); xSoFar -= num*Math.cos(Math.PI/4);	break ;
    	case "S.":		ySoFar -= num ;break ;
    	case"NE.":			ySoFar+= num*Math.cos(Math.PI/4); xSoFar += num*Math.cos(Math.PI/4);break ;
    	case "SE.":			ySoFar-= num*Math.cos(Math.PI/4); xSoFar += num*Math.cos(Math.PI/4);break ;
    	case "NW.": 		ySoFar+= num*Math.cos(Math.PI/4); xSoFar -= num*Math.cos(Math.PI/4);	break ;
    
 	}


    }
    System.out.println("Map #" + ctr++);	
	System.out.printf("The treasure is located at (%.3f,%.3f).",xSoFar,ySoFar);
	double distance = Math.sqrt(xSoFar*xSoFar + ySoFar*ySoFar);
	System.out.println();
	System.out.printf("The distance to the treasure is %.3f.",distance);
	System.out.println();
	System.out.println();
	
s=(String) br.readLine();
   }
}
}
