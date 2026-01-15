package crip1v00.pkg1;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.Random;

public class Crip1v001 {

    public static void main(String[] args) {
        
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("Bem vindo ao criptograph 00.2v de FelpsA");

        System.out.println("Digite sua mensagem que deseja criptografar: ");
        String mensagem = sc.nextLine();

        // 1️⃣ Transformar mensagem em códigos
        String codificado = crip1(mensagem); // ex: "016013001"

        // 2️⃣ Gerar binário do código (mantendo zeros)
        String binOriginal = "";
        for (char c : codificado.toCharArray()) {
            binOriginal += String.format("%4s", Integer.toBinaryString(c - '0')).replace(' ', '0');
        }

        int tamanhoOriginal = binOriginal.length();

        // 3️⃣ Gerar chave aleatória do mesmo tamanho
        String result = "";
        for (int i = 0; i < tamanhoOriginal; i++) {
            int n = r.nextInt(2);
            result += n;
        }

        BigInteger binMsg = new BigInteger(binOriginal, 2);
        BigInteger r2 = new BigInteger(result, 2);

        // 4️⃣ Criptografia XOR
        BigInteger crip0 = binMsg.xor(r2);

        String cripStr = crip0.toString();
        String out = crip3(cripStr);

        System.out.println("Mensagem criptografada: " + out);

        // 5️⃣ Descriptografia
        System.out.println("descriptografia agr");

        BigInteger cipher = binMsg.xor(r2); // XOR reverso
        String bin = descripto1(cipher, r2, tamanhoOriginal); // binário recuperado

        // 6️⃣ Reconstruir string de códigos (cada 4 bits → dígito)
        StringBuilder codigoRecuperado = new StringBuilder();
        for (int i = 0; i < bin.length(); i += 4) {
            String bloco = bin.substring(i, i + 4);
            int val = Integer.parseInt(bloco, 2);
            codigoRecuperado.append(val);
        }

        // 7️⃣ Transformar códigos de volta em texto
        String resp = descripto2(codigoRecuperado.toString());
        System.out.println("Mensagem descriptografada: " + resp);

        sc.close();
    }

    public static String crip1(String texto) {
        texto = texto.replace("a", "001");
        texto = texto.replace("b", "002");
        texto = texto.replace("c", "003");
        texto = texto.replace("d", "004");
        texto = texto.replace("e", "005");
        texto = texto.replace("f", "006");
        texto = texto.replace("g", "007");
        texto = texto.replace("h", "008");
        texto = texto.replace("i", "010");
        texto = texto.replace("j", "011");
        texto = texto.replace("k", "012");
        texto = texto.replace("l", "013");
        texto = texto.replace("m", "014");
        texto = texto.replace("n", "015");
        texto = texto.replace("o", "016");
        texto = texto.replace("p", "017");
        texto = texto.replace("q", "018");
        texto = texto.replace("r", "019");
        texto = texto.replace("s", "020");
        texto = texto.replace("t", "021");
        texto = texto.replace("u", "023");
        texto = texto.replace("v", "024");
        texto = texto.replace("w", "025");
        texto = texto.replace("x", "026");
        texto = texto.replace("y", "027");
        texto = texto.replace("z", "028");

        texto = texto.replace("A", "029");
        texto = texto.replace("B", "030");
        texto = texto.replace("C", "031");
        texto = texto.replace("D", "032");
        texto = texto.replace("E", "033");
        texto = texto.replace("F", "034");
        texto = texto.replace("G", "035");
        texto = texto.replace("H", "036");
        texto = texto.replace("I", "037");
        texto = texto.replace("J", "038");
        texto = texto.replace("K", "039");
        texto = texto.replace("L", "040");
        texto = texto.replace("M", "041");
        texto = texto.replace("N", "042");
        texto = texto.replace("O", "043");
        texto = texto.replace("P", "044");
        texto = texto.replace("Q", "045");
        texto = texto.replace("R", "046");
        texto = texto.replace("S", "047");
        texto = texto.replace("T", "048");
        texto = texto.replace("U", "049");
        texto = texto.replace("V", "050");
        texto = texto.replace("W", "051");
        texto = texto.replace("X", "052");
        texto = texto.replace("Y", "053");
        texto = texto.replace("Z", "054");

        texto = texto.replace("!", "065");
        texto = texto.replace("?", "066");
        texto = texto.replace("#", "067");
        texto = texto.replace("$", "068");
        texto = texto.replace("%", "069");
        texto = texto.replace("&", "070");
        texto = texto.replace("*", "071");
        texto = texto.replace("(", "072");
        texto = texto.replace(")", "073");
        texto = texto.replace("[", "074");
        texto = texto.replace("]", "075");
        texto = texto.replace("{", "076");
        texto = texto.replace("}", "077");
        texto = texto.replace(".", "078");
        texto = texto.replace(",", "079");
        texto = texto.replace(" ", "080");

        return texto;
    }

    public static String crip2(BigInteger m1){
        BigInteger aux = m1;
        BigInteger DOIS = BigInteger.valueOf(2);
        BigInteger[] binario = new BigInteger[1024];
        int indice = 0;

        if (aux.equals(BigInteger.ZERO)) {
            return "0";
        }
        while (aux.compareTo(BigInteger.ZERO) > 0) {
            BigInteger resto = aux.mod(DOIS);
            binario[indice] = resto;
            indice++;
            aux = aux.divide(DOIS);
        }

        StringBuilder resultado = new StringBuilder();
        for (int i = indice - 1; i >= 0; i--) {
            resultado.append(binario[i]);
        }

        return resultado.toString();
    }

    public static String crip3 (String num){
        num = num.replace("1", "A");
        num = num.replace("2", "B");
        num = num.replace("3", "C");
        num = num.replace("4", "D");
        num = num.replace("5", "E");
        num = num.replace("6", "F");
        num = num.replace("7", "G");
        num = num.replace("8", "H");
        num = num.replace("9", "I");
        num = num.replace("0", "J");
        return num;     
    }

    public static String descripto1(BigInteger cipher, BigInteger key, int tamanhoOriginal) {
        BigInteger recovered = cipher.xor(key);
        String bin = recovered.toString(2);

        while (bin.length() < tamanhoOriginal) {
            bin = "0" + bin;
        }

        return bin;
    }

    public static String descripto2(String texto){
        // letras minúsculas
        texto = texto.replace("028", "z");
        texto = texto.replace("027", "y");
        texto = texto.replace("026", "x");
        texto = texto.replace("025", "w");
        texto = texto.replace("024", "v");
        texto = texto.replace("023", "u");
        texto = texto.replace("021", "t");
        texto = texto.replace("020", "s");
        texto = texto.replace("016", "o");
        texto = texto.replace("015", "n");
        texto = texto.replace("014", "m");
        texto = texto.replace("013", "l");
        texto = texto.replace("012", "k");
        texto = texto.replace("011", "j");
        texto = texto.replace("010", "i");
        texto = texto.replace("009", "h");
        texto = texto.replace("008", "h");
        texto = texto.replace("007", "g");
        texto = texto.replace("006", "f");
        texto = texto.replace("005", "e");
        texto = texto.replace("004", "d");
        texto = texto.replace("003", "c");
        texto = texto.replace("002", "b");
        texto = texto.replace("001", "a");

        // letras maiúsculas
        texto = texto.replace("054", "Z");
        texto = texto.replace("053", "Y");
        texto = texto.replace("052", "X");
        texto = texto.replace("051", "W");
        texto = texto.replace("050", "V");
        texto = texto.replace("049", "U");
        texto = texto.replace("048", "T");
        texto = texto.replace("047", "S");
        texto = texto.replace("046", "R");
        texto = texto.replace("045", "Q");
        texto = texto.replace("044", "P");
        texto = texto.replace("043", "O");
        texto = texto.replace("042", "N");
        texto = texto.replace("041", "M");
        texto = texto.replace("040", "L");
        texto = texto.replace("039", "K");
        texto = texto.replace("038", "J");
        texto = texto.replace("037", "I");
        texto = texto.replace("036", "H");
        texto = texto.replace("035", "G");
        texto = texto.replace("034", "F");
        texto = texto.replace("033", "E");
        texto = texto.replace("032", "D");
        texto = texto.replace("031", "C");
        texto = texto.replace("030", "B");
        texto = texto.replace("029", "A");

        // símbolos
        texto = texto.replace("080", " "); 
        texto = texto.replace("079", ",");
        texto = texto.replace("078", ".");
        texto = texto.replace("077", "}");
        texto = texto.replace("076", "{");
        texto = texto.replace("075", "]");
        texto = texto.replace("074", "[");
        texto = texto.replace("073", ")");
        texto = texto.replace("072", "(");
        texto = texto.replace("071", "*");
        texto = texto.replace("070", "&");
        texto = texto.replace("069", "%");
        texto = texto.replace("068", "$");
        texto = texto.replace("067", "#");
        texto = texto.replace("066", "?");
        texto = texto.replace("065", "!");

        return texto;
    }

}
