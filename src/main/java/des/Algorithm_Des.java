package des;


import java.math.BigInteger;

public class Algorithm_Des {
	
	public Algorithm_Des() {
		super();
		// TODO Auto-generated constructor stub
	}

	public byte[] des(byte[] Message, byte[][] AllSubKeys, boolean Encrypt) {
		 Convert_Byt_to_Bit Bt=new Convert_Byt_to_Bit();
		 DesFunctions funn=new DesFunctions();

        byte[][] IP = IP();
        
        byte[][] Ipinv = IPinv();
        byte [][][] perm = new byte[2][][];
        if(Encrypt){
            perm[0] = IP;
            perm[1] = Ipinv;
            
        }else{
            perm[0] = IP;
            perm[1] = Ipinv;
            byte [][] subkes2 = new byte[AllSubKeys.length][AllSubKeys[0].length];
            for(int i = 0 ; i < AllSubKeys.length; i++){
                subkes2[i] = AllSubKeys[AllSubKeys.length-i-1];
            }
            AllSubKeys = subkes2;
        }
        String[] s = new String[AllSubKeys.length];

        for (int i = 0; i < 16; i++) {
            s[i] = Bt.Byt_into_bit(AllSubKeys[i]);
        }

        String temp_message = Bt.Byt_into_bit(Message);
        String message = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                message += temp_message.charAt(perm[0][i][j] - 1);
            }
        }

        String[] r = new String[17];
        String[] l = new String[17];
        l[0] = message.substring(0, 32);
        r[0] = message.substring(32, message.length());
     
       
           
                for (int k = 1; k < 17; k++) {
            l[k] = r[k - 1];
            r[k] = funn.xor(l[k - 1], funn.Des_functions(r[k - 1], s[k - 1]));
        
              
        }
                
                       
         
        
        String rl = r[r.length - 1] + l[l.length - 1];


        String m = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                m += rl.charAt(perm[1][i][j] - 1);
            }
        }
        byte[] theMsg2 = new BigInteger(m, 2).toByteArray();
        if (m.charAt(0) == '1') {
            Message = new byte[theMsg2.length - 1];
            for (int i = 0; i < theMsg2.length - 1; i++) {
                Message[i] = theMsg2[i + 1];
            }
            return Message;
        } else {

            return theMsg2;
        }
    }

	private byte[][] IPinv() {
		byte[][] Ipinv = {{40, 8, 48, 16, 56, 24, 64, 32},
        {39, 7, 47, 15, 55, 23, 63, 31},
        {38, 6, 46, 14, 54, 22, 62, 30},
        {37, 5, 45, 13, 53, 21, 61, 29},
        {36, 4, 44, 12, 52, 20, 60, 28},
        {35, 3, 43, 11, 51, 19, 59, 27},
        {34, 2, 42, 10, 50, 18, 58, 26},
        {33, 1, 41, 9, 49, 17, 57, 25}};
		return Ipinv;
	}

	private byte[][] IP() {
		byte[][] IP = {{58, 50, 42, 34, 26, 18, 10, 2},
        {60, 52, 44, 36, 28, 20, 12, 4},
        {62, 54, 46, 38, 30, 22, 14, 6},
        {64, 56, 48, 40, 32, 24, 16, 8},
        {57, 49, 41, 33, 25, 17, 9, 1},
        {59, 51, 43, 35, 27, 19, 11, 3},
        {61, 53, 45, 37, 29, 21, 13, 5},
        {63, 55, 47, 39, 31, 23, 15, 7}};
		return IP;
	}
}
