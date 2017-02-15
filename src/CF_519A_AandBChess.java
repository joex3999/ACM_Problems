

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_519A_AandBChess {
public static void main(String []args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int white = 0 ;
int black = 0 ;
for (int i=0 ; i<8 ; i++){
	StringTokenizer st = new StringTokenizer(br.readLine());
	String temp = st.nextToken();
	for(int j=0 ; j<8 ;j++){
		
	
		 char pos = temp.charAt(j);
		 
		if(pos=='.')
			continue ;
		if(Character.isLowerCase(pos)){
			black += getWeightc(pos);
		}else{
			white+= getWeightC(pos);
		}
	}
	
}
System.out.println(white==black?"Draw":(white>black?"White":"Black"));


}

static int getWeightC(char c ){
	switch(c){
	case 'Q': return 9 ;
	case 'R': return 5 ;
	
	case 'B' : return  3; 
	
	case 'N' :return 3;
	case 'P' : return 1 ;
	case 'K':return 0 ;
	case '.': return 0 ;
	}
	return 0 ;
}
static int getWeightc(char c ){
	switch(c){
	case 'q': return 9 ;
	case 'r': return 5 ;
	
	case 'b' : return  3; 
	
	case 'n' :return 3;
	case 'p' : return 1 ;
	case 'k':return 0 ;
	case '.': return 0 ;
	}
	return 0 ;
}
}
