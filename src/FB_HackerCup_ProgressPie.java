import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class FB_HackerCup_ProgressPie {
	public static  double getAngle ( double Ax,double Ay ,double Bx,double By , double Cx,double Cy ){

		double LAB = Math.sqrt(Math.pow(Bx-Ax, 2)+Math.pow(By-Ay, 2)); 
		double LBC = Math.sqrt(Math.pow(Cx-Bx, 2)+Math.pow(Cy-By, 2)); 

		
		double VABx = Ax-Bx;
		double VABy= Ay-By;
		double VBCx = Cx-Bx;
		double VBCy= Cy-By;

		double angle = Math.acos((VABx*VBCx+VABy*VBCy)/(LAB*LBC));
		double answer = 0 ;
		angle = Math.toDegrees(angle);
		
		if((VABx*VBCx+VABy*VBCy)/(LAB*LBC)<0){
			answer =(180- angle)+180 ;
		}else{
			answer = angle;
		}
return answer ;
	}
public static void main(String[] args) throws Exception {

	FileInputStream in = new FileInputStream("in.txt");
new FileWriter("output.txt");
	Scanner sc = new Scanner(in);
	double Ax= 50;
	double Ay = 100;

	double Bx= 50;
	double By = 50;
int n  = sc.nextInt();
StringBuilder sb = new StringBuilder();
for(int i =0 ; i<n;i++){
	double perc = sc.nextDouble()*3.6;
	double Cx= sc.nextDouble();
	double Cy = sc.nextDouble();
	double length = Math.sqrt(Math.pow(Cx-50, 2)+Math.pow(Cy-50, 2));
	if(length>50){
		sb.append(String.format("Case #%s: %s\n",i+1, "white"));
		continue ;
	}
	
	double angle = getAngle (  Ax, Ay , Bx, By ,  Cx, Cy );

	if(angle>perc){
		sb.append(String.format("Case #%s: %s\n",i+1,"white"));
	}else{
		sb.append(String.format("Case #%s: %s\n",i+1, "black"));
	}

}
System.out.println(sb.toString());
//out.write(sb.toString());
//out.flush();
//out.close();
}
	static class Scanner {
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream s) {
		br = new BufferedReader(new InputStreamReader(s));
	}

	public String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}

	public int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	public long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	public String nextLine() throws IOException {
		return br.readLine();
	}

	public double nextDouble() throws IOException {
		String x = next();
		StringBuilder sb = new StringBuilder("0");
		double res = 0, f = 1;
		boolean dec = false, neg = false;
		int start = 0;
		if (x.charAt(0) == '-') {
			neg = true;
			start++;
		}
		for (int i = start; i < x.length(); i++)
			if (x.charAt(i) == '.') {
				res = Long.parseLong(sb.toString());
				sb = new StringBuilder("0");
				dec = true;
			} else {
				sb.append(x.charAt(i));
				if (dec)
					f *= 10;
			}
		res += Long.parseLong(sb.toString()) / f;
		return res * (neg ? -1 : 1);
	}

	public boolean ready() throws IOException {
		return br.ready();
	}

}
}
