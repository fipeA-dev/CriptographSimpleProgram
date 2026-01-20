package op;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;
/**
 *
 * @author fipeA-dev
 */
public class cripto {
      
    public static String car(String msg){
        byte[] dados = msg.getBytes(StandardCharsets.UTF_8);
        SecureRandom random = new SecureRandom();
        byte[] key = new byte[dados.length];
        random.nextBytes(key);
        byte[] crip = new byte[dados.length];
        
        for(int i = 0; i <dados.length; i++){
            crip[i]= (byte) (dados[i]^key[i]);
        }
        StringBuilder bin = new StringBuilder();
        for(byte b : crip){
            bin.append(String.format("%8s", 
                    Integer.toBinaryString(b & 0xFF)).replace(' ','0'));
        }
        String keyBase64 = Base64.getEncoder().encodeToString(key);
        return("<html>"+bin.toString()+" "+keyBase64+"<html>");
        //*tring keyBase64 = Base64.getEncoder().encodeToString(key);
        /*System.out.println("A chave de descriptografia e: "+keyBase64);
        
        */
    }
       
            
     public static String carInverse(String bin, String keyB64){
            byte[] key = Base64.getDecoder().decode(keyB64);
            int n = bin.length()/8;
            byte[] descrip = new byte[n];
            
            for(int i=0; i<n; i++){
                String bloco = bin.substring(i*8, i*8+8);
                descrip[i] = (byte) Integer.parseInt(bloco, 2);
                
            }
            byte[] original = new byte[n];
            for(int i =0;i<n;i++){
                original[i] = (byte) (descrip[i]^key[i]);
            }        
            String result = new String(original, StandardCharsets.UTF_8);
            return result;
     }
            
            
        
        
}


