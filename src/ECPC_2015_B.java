
import java.util.*;
import java.io.*;
public class ECPC_2015_B {
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int T = Integer.parseInt(br.readLine());
StringBuilder sb = new StringBuilder();
while(T-->0){
	StringTokenizer st = new StringTokenizer(br.readLine());
	int Q = Integer.parseInt(st.nextToken());
	int  M = Integer.parseInt(st.nextToken());
	char[] answers = new char[Q];
	Arrays.fill(answers, 'X');
	boolean[][] falseAnswers = new boolean[Q][4];
	int [] falseNumber = new int [Q];
	for(int i =0 ; i<M;i++){
		st = new StringTokenizer(br.readLine());
		
		for(int j = 0 ; st.hasMoreTokens();j++){
		char answer = st.nextToken().charAt(0);
		char status = st.nextToken().charAt(0);
		switch(status){
		case 'F': falseAnswers[j][((int)answer)-65] = true ; falseNumber[j]++;break;
		case 'T': answers[j]=answer;break;
		}
	
		if(falseNumber[j]==3){
			for(int k =0 ; k<4;k++){
				if(!falseAnswers[j][k]){
				answers[j]=(char)(65+k);
				break;
				}
			}
		}
		
		
	}
}
	StringBuilder temp = new StringBuilder();
	for(int i =0 ; i<Q ; i++){
		if(answers[i]=='X')
			temp.append("? ");
		else
			temp.append(answers[i]+" ");
	}
	temp.replace(temp.length()-1, temp.length(), "");
	sb.append(temp+"\n");
	
}
System.out.println(sb.replace(sb.length()-1, sb.length(), "").toString());
}

}
