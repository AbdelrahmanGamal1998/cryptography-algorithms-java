package rsa;
import java.io.*;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RSA
{

	static int n;
	static int e=2;
	static int d;
	
	
	private static int gcd(int a, int b) {
        if (a == 0)
          return b;
        if (b == 0)
          return a;
      
        if (a == b)
            return a;
      
        if (a > b)
            return gcd(a-b, b);
        return gcd(a, b-a);

	}


	public static String RES_Encryption (int message ,int p,int q) {
		int c=0;
		n=p*q;
		
		int φn = calculate_e(p, q);
	
		calculate_d(φn);
		c=(int)(Math.pow(message, e)%n);
		return c +"";
	
	}
	
	public static String RES_Decryptian (BigInteger cipher ,int p,int q) {
		BigInteger m;
		 int z=p*q;
		BigInteger new_n=BigInteger.valueOf(z);
				
		
		int φn = calculate_e(p, q);
	
		calculate_d(φn);
		m=(cipher.pow(d)).mod(new_n);
		
		return m+"";
		
	}


	private static int calculate_e(int p, int q) {
		int φn=(p-1)*(q-1);
	
		
		while (e < φn)
	    {
	      
	        if (gcd(e, φn)==1)
	            break;
	        else
	            e++;
	        
	    }
		return φn;
	}


	private static void calculate_d(int φn) {
		int i=1;
		while (true) {
			if (((i*e)%φn)==1) {
				d=i;
				break;
				
			}
			i++;
		}
	}
	
	
////////////////////////////////////////////
	public static int convert_to_ascii(String str) {
		
	int sum = str.chars().reduce(0, Integer::sum);
		return sum;
	}
	
	
	///////////////////////////////////////
	public static int to_integer( String s ) {
	
		String t = "";
		for (int i = 0; i < s.length(); ++i) {
		    char ch = s.charAt(i);
		    if (!t.isEmpty()) {
		        t += "";
		    }
		    int n = (int)ch - (int)'a' + 1;
		    t += String.valueOf(n);
		}
		
		int i = Integer.parseInt(t.trim());
				
		return i;

	}
	
	
	
	
	
	////////////////////////////////////////////////////////////
	public static int to_integer2( String s ) {
    final Map<Character, Integer> map;
    final String str = s;

    map = new HashMap<>();  
    // or map = new HashMap<Character, Integer> if you are using something before Java 7.
    map.put('a', 1);
    map.put('b', 2);
    map.put('c', 3);
    map.put('d', 4);
    map.put('e', 5);
    map.put('f', 6);
    map.put('g', 7);
    map.put('h', 8);
    map.put('i', 9);
    map.put('j', 10);
    map.put('k', 11);
    map.put('l', 12);
    map.put('m', 13);
    map.put('n', 14);
    map.put('o', 15);
    map.put('p', 16);
    map.put('q', 17);
    map.put('r', 18);
    map.put('s', 19);
    map.put('t', 20);
    map.put('u', 21);
    map.put('v', 22);
    map.put('w', 23);
    map.put('x', 24);
    map.put('y', 25);
    map.put('z', 26);

    for(final char c : str.toCharArray())
    {
        final Integer val;

        val = map.get(c);

        if(val == null)
        {   
            // some sort of error
        }
        else
        {
           // System.out.print(val);
            return val;
        }
    }
	return 0;

    
	
}

		
	static int isPrime(int n)
    {
        if (n <= 1 )
            return 0;
 
    
        else if (n == 2  )
            return 1;
 
        else if (n % 2 == 0 )
            return 0;

        for (int i = 3; i <= Math.sqrt(n); i += 2)
        {
            if (n % i == 0 )
                return 0;
        }
        return 1;
    }
		
	
	public static void main(String[] args) {
		
		Scanner readme = new Scanner(System.in);
		System.out.println("you want to use RSA for a 1) word 2) numbers 3) exit : \n");
	     int number = readme.nextInt();
	
		switch (number) {
		  case 1:
		
			    System.out.println("please enter the p and q of the opertion that you want to do for the word :\n");
				int p1= readme.nextInt();
				int q1 =readme.nextInt();
				if (RSA.isPrime(p1)==1&&RSA.isPrime(q1)==1) {
				System.out.println("please enter message  (word) you want to encrypt   : \n");
				String message11 = readme.next();
				System.out.print("the message you entered is :"+message11  );
				System.out.println(" \n ");
				int x=to_integer(message11 );
				System.out.print("the converted ascii code for this message is :" + x);
				System.out.println(" \n ");				
				System.out.print("the encryption  for this message is :" +RSA. RES_Encryption(x,p1,q1));
				System.out.println(" \n ");
				////////////////////////////////////////////////////////////////////
				System.out.println("please enter message  (word) you want to decrypt  : \n");
				String message111 = readme.next();
				
				System.out.print("the message you entered is :"+message111  );
				System.out.println(" \n ");
				int x1=to_integer(message111 );
				BigInteger new_x1=BigInteger.valueOf(x1);
				System.out.print("the converted ascii code for this message is :" + x1);
				System.out.println(" \n ");
				
				System.out.print("the decryption   for this message is :" +RSA.RES_Decryptian(new_x1,p1,q1));
				System.out.println(" \n ");
				}
			else {
					System.out.println("either p or q are not prime for the word  ");
				}
		    break;

		     case 2:
			  
			  System.out.println("please enter the p  of the opertion that you want to do for the number : \n");
				
				int p= readme.nextInt();
				int q =readme.nextInt();
				if (RSA.isPrime(p)==1&&RSA.isPrime(q)==1) {
					System.out.println("please enter message you want to encrypt : \n");
					int message1 = readme.nextInt();
					System.out.print(RSA. RES_Encryption(message1,p,q));
					System.out.println(" \n ");
					System.out.println("please enter message  (word) you want to decrypt  : \n");
					int decrypt = readme.nextInt();
				
					BigInteger new_x1=BigInteger.valueOf(decrypt);
					System.out.print(RSA.RES_Decryptian(new_x1,p,q));
					System.out.println(" \n ");
				}
				else {
					
					System.out.println("either p or q are not prime ");
				}
				
		    break;
		  case 3:
			  System.exit(0);
		  default:
			    System.out.println("wrong number entered ");
		}
		
		
		
		

		
		

	}

}
