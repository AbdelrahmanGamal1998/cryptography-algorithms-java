package des;

import java.math.BigInteger;

public class GetSubKeys {

	 public GetSubKeys() {
		super();
		// TODO Auto-generated constructor stub
	}




	public  byte[][] getSubkeys(byte[] key) {
		 ShiftChar sc=new ShiftChar();
		 Removingzero dz=new Removingzero();
		 Convert_Byt_to_Bit bt=new Convert_Byt_to_Bit();

		        String keyString = bt.Byt_into_bit(key);
		        byte[][] PC_1 = PC_1_table();
		        String key56 = "";

	        
	        
	        
	        for (int i = 0; i < 8; i++) {
	            for (int j = 0; j < 7; j++) {
	                key56 += keyString.charAt(PC_1[i][j] - 1);
	            }
	        }

	        byte[] leftShiftArray = Number_of_left_shifts_table();

	        String[] Lkeys = new String[16];
	        String[] Rkeys = new String[16];

	        String l = key56.substring(0, 28);
	        String r = key56.substring(28, key56.length());

	        Lkeys[0] = sc.shiftChars(l, leftShiftArray[0]);
	        Rkeys[0] = sc.shiftChars(r, leftShiftArray[0]);

	        for (int i = 1; i < leftShiftArray.length; i++) {
	            Lkeys[i] = sc.shiftChars(Lkeys[i - 1], leftShiftArray[i]);
	            Rkeys[i] = sc.shiftChars(Rkeys[i - 1], leftShiftArray[i]);

	        }
	        
	        
	        
	        String[] concKeys = new String[16];
	        for (int i = 0; i < leftShiftArray.length; i++) {
	            concKeys[i] = Lkeys[i] + Rkeys[i];

	        }
	        
	        
	        int[][] PC_2 = PC_2_TABLE();

	        String[] permKeys = new String[16];
	         
	        for (int k = 0; k < 16; k++) {
	            permKeys[k] = "";
	            for (int i = 0; i < 8; i++) {
	                for (int j = 0; j < 6; j++) {
	                    permKeys[k] += concKeys[k].charAt(PC_2[i][j] - 1);
	                }
	               
	            }
	        }
	        byte[][] result = new byte[16][];
	        for (int i = 0; i < 16; i++) {
	            
	            result[i] = new BigInteger(permKeys[i], 2).toByteArray();
	        }

	        result = dz.Remove_zero(result);

	        return result;
	    }

	 
	 
	 
	private static int[][] PC_2_TABLE() {
		int[][] PC_2 = {{14, 17, 11, 24, 1, 5},
		{3, 28, 15, 6, 21, 10},
		{23, 19, 12, 4, 26, 8},
		{16, 7, 27, 20, 13, 2},
		{41, 52, 31, 37, 47, 55},
		{30, 40, 51, 45, 33, 48},
		{44, 49, 39, 56, 34, 53},
		{46, 42, 50, 36, 29, 32}};
		return PC_2;
	}

	private static byte[] Number_of_left_shifts_table() {
		byte[] leftShiftArray = {1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1};
		return leftShiftArray;
	}

	private static byte[][] PC_1_table() {
		byte[][] PC_1 = {{57, 49, 41, 33, 25, 17, 9},
		{1, 58, 50, 42, 34, 26, 18},
		{10, 2, 59, 51, 43, 35, 27},
		{19, 11, 3, 60, 52, 44, 36},
		{63, 55, 47, 39, 31, 23, 15},
		{7, 62, 54, 46, 38, 30, 22},
		{14, 6, 61, 53, 45, 37, 29},
		{21, 13, 5, 28, 20, 12, 4}};
		return PC_1;
	}
}
