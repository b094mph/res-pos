package com.res.security;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SHAHashing {
	
public static final int SALT_BYTES = 24;
	
	public static String createHash(String password){
		
		if(password == null) return null;
		
		StringBuffer hexString = new StringBuffer();
		try{		
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes());
			
			byte byteData[] = md.digest();
			
			for(int i=0;i<byteData.length;i++){
				String hex = Integer.toHexString(0xff & byteData[i]);
				if(hex.length() == 1)
					hexString.append("0");
				hexString.append(hex);
			}
			
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		
		return hexString.toString();
	}
	
	public static String createSalt(){
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[SALT_BYTES];
		random.nextBytes(salt);
		return toHex(salt);
	}
	
    /**
     * Converts a byte array into a hexadecimal string.
     *
     * @param   array       the byte array to convert
     * @return              a length*2 character string encoding the byte array
     */
    private static String toHex(byte[] array)
    {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if(paddingLength > 0)
            return String.format("%0" + paddingLength + "d", 0) + hex;
        else
            return hex;
    }

	public static void main(String[] args){
		String salt = SHAHashing.createSalt();
		System.out.println("Salt : " + salt);
		String hash = SHAHashing.createHash(salt + "hello");
		System.out.println("Hash : " + hash);
		
		//verify password
		String authenticatePassword = createHash(salt + "hello");
		System.out.println("       " + authenticatePassword);
		System.out.println(authenticatePassword.equals(hash));
		
	}

}
