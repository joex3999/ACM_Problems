
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class CF_722B_VersePattern {
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int n = Integer.parseInt(br.readLine());
StringTokenizer st = new StringTokenizer(br.readLine());
boolean YES = true ;
for(int i =0 ; i<n;i++){
char[] line = br.readLine().toCharArray();
int Vowels = Integer.parseInt(st.nextToken());
int answer = 0 ;
for(int j =0 ;j<line.length;j++){
	if(line[j]=='a'||line[j]=='e'||line[j]=='o'||line[j]=='i'||line[j]=='u'||line[j]=='y')
		answer++;
}
if(answer!=Vowels){
	YES = false ;
	break;
}
}

if(YES)
	System.out.println("YES");
else 
	System.out.println("NO");

}
}
