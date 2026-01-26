package op;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 * Criptografia XOR + HEX + Cifra de César para hexadecimal
 * Funciona com qualquer string, retorna HEX + key + shift
 */
public class cripto {

    private static final char[] HEX = {
        '0','1','2','3','4','5','6','7',
        '8','9','A','B','C','D','E','F'
    };

    // símbolos temporários (não existem no hexadecimal)
    private static final char[] TMP = {
        'g','h','i','j','k','l','m','n',
        'o','p','q','r','s','t','u','v'
    };

    /**
     * Criptografa uma mensagem
     * @param msg texto puro
     * @return String formatada: HEX + \n chave Base64 + \n shift
     * @throws java.lang.Exception
     */
    public static String car(String msg) throws IOException {
        byte[] dados = msg.getBytes(StandardCharsets.UTF_8);
        SecureRandom random = new SecureRandom();

        // XOR
        byte[] key = new byte[dados.length];
        random.nextBytes(key);
        byte[] crip = new byte[dados.length];
        for(int i = 0; i < dados.length; i++){
            crip[i] = (byte) (dados[i] ^ key[i]);
        }

        // Binário → HEX
        StringBuilder bin = new StringBuilder();
        for(byte b : crip){
            bin.append(String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ','0'));
        }
        BigInteger decimal = new BigInteger(bin.toString(), 2);
        String hex = decimal.toString(16).toUpperCase();

        // Adiciona zero à esquerda se necessário para múltiplo de 2
        if(hex.length() % 2 != 0) hex = "0" + hex;

        // Cifra de César HEX
        int shift = random.nextInt(16);
        char[] chars = hex.toCharArray();
        for(int i = 0; i < chars.length; i++){
            int idx = indexOf(HEX, chars[i]);
            if(idx != -1){
                chars[i] = HEX[(idx + shift) % 16];
            }
        }

        // chave Base64
        String keyBase64 = Base64.getEncoder().encodeToString(key);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        
        
        
        String caminhoArquivo="keys_"+LocalDateTime.now().format(formatter)+".txt";
        String caminhoArquivo1="mensage_"+LocalDateTime.now().format(formatter)+".txt";
        
        FileWriter f = new FileWriter(caminhoArquivo);
        FileWriter f1 = new FileWriter(caminhoArquivo1);
        BufferedWriter bf = new BufferedWriter(f);
        BufferedWriter bf1 = new BufferedWriter(f1);
        bf.write(keyBase64+"   \n:| \n |: \n   "+shift);
        bf1.write(chars);
        bf1.close();
        bf.close();    
        return new String(chars);
    }

    /**
     * Descriptografa a mensagem
     * @param hexShift HEX cifrado com César
     * @param keyB64 chave Base64
     * @param shift shift usado na cifra de César
     * @return String original
     */
    public static String carInverse(String hexShift, String keyB64, int shift) {
        // Desfaz César
        char[] chars = hexShift.toCharArray();
        for(int i = 0; i < chars.length; i++){
            int idx = indexOf(HEX, chars[i]);
            if(idx != -1){
                chars[i] = HEX[(idx - shift + 16) % 16];
            }
        }
        String hex = new String(chars);

        // HEX → binário
        BigInteger decimal = new BigInteger(hex, 16);
        String bin = decimal.toString(2);

        // padding correto
        int totalBytes = Base64.getDecoder().decode(keyB64).length;
        int totalBits = totalBytes * 8;
        bin = String.format("%" + totalBits + "s", bin).replace(' ', '0');

        // binário → bytes
        byte[] descrip = new byte[totalBytes];
        for(int i = 0; i < totalBytes; i++){
            descrip[i] = (byte) Integer.parseInt(bin.substring(i*8, i*8+8), 2);
        }

        // XOR com a chave
        byte[] key = Base64.getDecoder().decode(keyB64);
        byte[] original = new byte[totalBytes];
        for(int i = 0; i < totalBytes; i++){
            original[i] = (byte) (descrip[i] ^ key[i]);
        }

        return new String(original, StandardCharsets.UTF_8);
    }

    // Função auxiliar para encontrar índice em array
    private static int indexOf(char[] arr, char c){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == c) return i;
        }
        return -1;
    }
}
