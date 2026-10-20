package des;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;



public class Main {
	
	 public static void main(String[] args) {
	    GetSubKeys getkeys=new GetSubKeys();
	    Encryption encrypt=new Encryption();
	    HexToBytes hx =new HexToBytes();
	    Convert_Bytes_To_Hexa Bx=new Convert_Bytes_To_Hexa();
	    Convert_Byt_to_Bit Bt=new Convert_Byt_to_Bit();
		byte[] key = null;
        byte[] Msg = null;
		int choice;
        Scanner scanner = new Scanner(System.in);
			
        
        
        
        
			boolean bExist = true;
			while (bExist) {
				
				
			
				System.out.println("\n ************ Main Menu ***************");
				System.out.println("1. Encrypt data using DES Algorithm :");
				System.out.println("2. Exit: ");
				System.out.println("**************************************");
				System.out.println("Select your choice");
				choice = Integer.parseInt(scanner.nextLine());
				switch (choice) {

				case 1:

					System.out.println("Enter the key :");
					String key1 = scanner.nextLine();
					 key= hx.hexToBytes(key1);
					System.out.println("Enter the message :");
					String message1 = scanner.nextLine();
					 Msg = hx.hexToBytes(message1);
					 byte[][] subKeys = getkeys.getSubkeys(key);
					 String s ="";
					 
					 System.out.println("The subKeys of the 16 rounds in binary :");
					 for(int i = 0 ; i < 16; i ++){
		                  s+= Bt.Byt_into_bit(subKeys[i])+"   \n";		               
		                System.out.println("key "+ i + " : "+Bt.Byt_into_bit(subKeys[i]));
		            }
					 
					
					 byte[] theCph = encrypt.encryption(Msg, subKeys);
			          
			            System.out.println("Key     : " + Bx.Bytes_into_Hexa(key));
			            System.out.println("Message : " + Bx.Bytes_into_Hexa(Msg));
			            System.out.println("Cipher  : " + Bx.Bytes_into_Hexa(theCph));

					
					break;
				case 2:
					bExist = false;

					break;
				}
			}}}
	            
	            
	               
	              

	           
	           
	                
	       
	             
	           
	           


