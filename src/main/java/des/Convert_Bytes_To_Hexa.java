package des;


public class Convert_Bytes_To_Hexa {
	public Convert_Bytes_To_Hexa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String Bytes_into_Hexa(byte[] Info) {
        if (Info == null) {
            return null;
        } else {
            int len = Info.length;
            String Result = "";
            for (int i = 0; i < len; i++) {
                if ((Info[i] & 0xFF) < 16) {
                    Result = Result + "0"
                            + java.lang.Integer.toHexString(Info[i] & 0xFF);
                } else {
                    Result = Result
                            + java.lang.Integer.toHexString(Info[i] & 0xFF);
                }
            }
            return Result.toUpperCase();
        }
    }

}
