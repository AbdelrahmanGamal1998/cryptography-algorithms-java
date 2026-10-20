package playfair;

import java.awt.Point;
import java.util.Scanner;

public class Playfair {
	 
	// to get input , uppercasing , remove non char 
	static String parseStringtouppercase(Scanner s) {
     String parse =s.nextLine();
     parse = parse.toUpperCase(); 
     parse=parse.replaceAll("[^A-Z]","");
     parse = parse.replace ("J","I");
     
		return parse;
	}
	 
	 
	 //creates the cipher table based on inpt string 
	 static String[][] ciphermatrix(String key) {
		String [][]playfairTable=new String[5][5];
		String keyString= key+"ABCDEFGHIKLMNOPQRSTUVWXYZ";
		   
		
		// FILL STRING ARRAY
		for (int i=0;i<5;i++)
			for(int j=0;j<5;j++)
				playfairTable[i][j]="";
		
		for (int k=0;k<keyString.length();k++) {
			boolean repeat = false;
			boolean used = false;
			for(int i =0;i<5;i++) {
				for (int j=0; j<5;j++) {
				if(playfairTable[i][j].equals(""+keyString.charAt(k))) {
					repeat=true;
				}
				else if (playfairTable[i][j].equals("")&&!repeat &&!used) {
					playfairTable[i][j]=""+keyString.charAt(k);
					used=true;
				}
			}
		}
	}
		return playfairTable;
	}
	 
	/// takes input (al upper case ,encode it and returns output
		static String cipher(String in) {
			 length=(int)in.length()/2+in.length()%2;
			 // insert x between double letter digrapghs &redifine ""lenght"
			 
			 for (int i=0;i<(length-1);i++){
				 if (in.charAt(2*i)==in.charAt(2*i+1)) {
					 in = new StringBuffer(in).insert(2*i+1, 'X').toString();
					 length=(int) in.length()/2+in.length()%2;
				 }
			 }
			 
					// add an x to the last digraph , if nesscasary
			 String [] digrapgh = new String [length];
			 for (int j=0;j<length ;j++) {
				 if(j==(length-1)&&in.length()/2==(length-1))
					 in=in+"X";
				 digrapgh[j]=in.charAt(2*j)+""+in.charAt(2*j+1);
			 }
			 
			 
			 String out="";
			 String[] encDigraphs = new String [length];
			 encDigraphs =encodeDigraph(digrapgh);
			 for(int k =0;k<length;k++) 
				 out=out+encDigraphs[k];
				 return out;
			 }
			 
			 
			
 

	static String[] encodeDigraph(String di[]) {
		String [] enc = new String [length];
		for(int i=0;i<length;i++) {
			char a = di[i].charAt(0);
			char b = di[i].charAt(1);
			int r1 =(int) getpoint(a).getX();
			int r2 =(int) getpoint(b).getX();
			int c1 =(int) getpoint(a).getY();
			int c2 =(int) getpoint(b).getY();
			
			
			if (r1==r2) {
				c1=(c1+1)%5;
				c2=(c2+1)%5;
			}
			else if (c1==c2) {
				r1=(r1+1)%5;
				r2=(r2+1)%5;
			}
			else {
				int temp =c1;
				c1=c2;
				c2=temp;
			}
			enc[i]=table[r1][c1]+"" +table[r2][c2];
			
		}
		
			
			return enc;
		}

static String decode (String out) {
	String decoded ="";
	for (int i=0;i<out.length()/2;i++) {
		char a =out.charAt(2*i);
		char b = out.charAt(2*i+1);
		int r1=(int) getpoint(a).getX();
		int r2=(int) getpoint(b).getX();
		int c1=(int) getpoint(a).getY();
		int c2=(int) getpoint(b).getY();
	if (r1==r2) {
		c1=(c1+4)%5;
		c2=(c2+4)%5;
	}
	else if (c1==c2) {
	r1=(r1+4)%5;
	r2=(r2+4)%5;
		
	}
	else {
		int temp =c1 ;
		c1 =c2;
		c2 =temp;
	}
	decoded = decoded +table [r1][c1]+table [r2][c2];
	}
	return decoded;
	
}



static Point getpoint(char c) {
	Point pt = new Point (0,0);
	for (int i=0;i<5;i++)
		for (int j=0;j<5;j++)
			if (c==table [i][j] .charAt(0))
				pt = new Point (i,j);
return pt;
}

	
	 static void printTable(String[][] printedTable) {
		 System.out.println("this is the cipher table from the given keyword  : ");
		 System.out.print(" ");
		 
		 for (int i= 0 ;i<5 ;i++) {
			 for (int j=0 ;j<5;j++) {
				 System.out.print(printedTable[i][j]+ " ");
				 
			 }
			 System.out.println();
		 }
		 System.out.println();
	 }
	 









	static int length =0;
	static String [][] table;
	public static void main(String[] args) {
		System.out.print("please enter keyword for playfair : ");
	    Scanner sc =new Scanner (System.in);
	    String keyword = parseStringtouppercase(sc);
	    while(keyword.equals(""))
	    	keyword=parseStringtouppercase(sc);
	    
	    table= ciphermatrix(keyword);

	    System.out.print("please enter message to be encoded ");
	    System.out.print("using privios key");
	    String input =parseStringtouppercase(sc);
	    while(input.equals(""))
	    	input=parseStringtouppercase(sc);

	    
	    String output =cipher(input);
	    String decodedOutput=decode(output);
	    
	    printTable(table);
	    System.out.print("this is the encoded message : ");
	    System.out.print(output);
	    System.out.print(" ");
	    System.out.print(" this is the decoded messsage : ");
	    System.out.print(decodedOutput);
	   
	}

		 
	



}
