
// not Done but it is pretty simple . the problems are trivial implementation but you got the idea .
//  https://github.com/Diusrex/UVA-Solutions/blob/master/230%20Borrowers.cpp  was submitted
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
// to be continued 
public class UVA_230_Borrowers {
	static class Book implements Comparable{
		String book ;
		String author ;
		public Book(String x , String y){
			book = x;
			author = y ;
		}
		@Override
		// returns 1 if smaller / -1 if bigger
		public int compareTo(Object o) {
		Book b = (Book) o ;
			if(author.compareTo(b.author)==0){
				if(book.compareTo(b.book)==1){
					return -1 ;
				}
				if(book.compareTo(b.book)==-1){
					return 1 ;
				}
			}
			if(author.compareTo(b.author)==1){
				return -1 ;
			}
			if(author.compareTo(b.author)==-1){
				return 1 ;
			}
			return 0;
		}
		
	}
	
	
	static ArrayList<Book> books ;
	static ArrayList<Book> toBeReturned;
	static ArrayList<Book> borrowed;
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String line = null ;
	books = new ArrayList<Book>();
	toBeReturned = new ArrayList<Book>();
	borrowed = new ArrayList<Book>();
	while(!(line=br.readLine()).equals("END")){
	 String [] temp = line.split(" by ");
	 String book = temp[0];
	 String author = temp[1];
	 books.add(new Book(book,author));
	 
	}
	
	while(!(line=br.readLine()).equals("END")){
		String [] temp = line.split(" ");
		switch(temp[0]){
		case"BORROW": borrow(temp[1]); break;
		case"RETURN": Return(temp[1]); break;
		case"SHELVE": shelve();break;
		}
	}
}
static public Book getEquiv1(String s){
	for(Book g : books){
	if(g.book.equals(s)){
		return g;
	}
	}
	return books.get(0);
}

static public Book getEquiv2(String s){
	for(Book g : borrowed){
	if(g.book.equals(s)){
		return g;
	}
	}
	return borrowed.get(0);
}
static public void borrow(String s){
	Book it  = getEquiv1(s);
	books.remove(it);
	borrowed.add(it);
}
static public void shelve(){
Collections.sort(toBeReturned);
Collections.sort(books);
for(int i =0 ; i<toBeReturned.size();i++){
	Book theone = toBeReturned.get(i);
	for(int j =0 ; j<books.size();j++){
		if(theone.compareTo(books.get(j))==1){
			System.out.println(books.get(j).book);
			continue;
		}
	}
}
	
	
}
static public void Return(String s){
	Book it = getEquiv2(s);
	borrowed.remove(it);
	toBeReturned.add(it);
}
}
