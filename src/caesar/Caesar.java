package caesar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public final class Caesar {
    private static final HashMap<String,Double> LETTER_USAGE_STATS =new HashMap<>(){
        {
            put("A", 8.4966);
            put("B",2.0720);
            put("C",4.5388);
            put("D",3.3844);
            put("E",11.1607);
            put("F",1.8121);
            put("G",2.4705);
            put("H",3.0034);
            put("I",7.5448);
            put("J", 0.1965);
            put("K",1.1016);
            put("L",5.4893);
            put("M",3.0129);
            put("N",6.6544);
            put("O",7.1635);
            put("P",3.1671);
            put("Q",0.1962);
            put("R",7.5809);
        };

    };
    public static final ArrayList<String> MOST_USED_LETTERS;

    static {
        MOST_USED_LETTERS = new ArrayList<>(){{
            add("e");
            add("a");
            add("r");
            add("i");
            add("o");
            add("t");
            add("n");
            add("s");
            add("l");
            add("c");
            add("u");
            add("d");
            add("p");
        }};
    }
    public static final int CASE_DIFF = 32;
    public static String encrypt(String source, int key){
        StringBuilder builder = new StringBuilder(source.length());
        for (int i = 0; i < source.length(); i++) {
            int tmp = source.charAt(i)+key;
            tmp = tmp > 122 ? 32+tmp-122:tmp<32?122-32-tmp:tmp;
            builder.append((char)(tmp));
        }
        return builder.toString();
    }

    public static String decrypt(String encryptText, int key){
        var builder = new StringBuilder(encryptText.length());
        for (int i = 0; i < encryptText.length(); i++) {
            int tmp= encryptText.charAt(i)-key;
            tmp = tmp > 122 ? 32+tmp-122:tmp<32?122-32-tmp:tmp;
            builder.append((char)(tmp));
        }
        return builder.toString();
    }

    public static void hackEncryptedTextBruteForce(String encryptedText){
        boolean isRunning = true;
        int key = 0;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            while (isRunning) {
                System.out.format("current key:%d\ntext is:\"%s\"\nDoes it make sense for you?[y,n]:",key, decrypt(encryptedText,key));
                if (br.readLine().equalsIgnoreCase("y")) isRunning=false;
                else{
                    System.out.println("Modify a key and we'll try again[1 or -1]:");
                    key += Integer.parseInt(br.readLine());
                }
            }
        }catch (Throwable e){
            throw new RuntimeException(e);
        }



    }
//    public static void hackEncryptedTextStatistics(String encryptedText){
//        String tmpText = encryptedText.toLowerCase();
//        ArrayList<Integer> ascii = new ArrayList<>(255);
//        for (int i = 0; i <= 255; i++) {
//            ascii.add(i,0);
//        }
//        ArrayList<Integer> skippedIndx = new ArrayList<>();
//
//        for (int i = 0; i < tmpText.length(); i++) {
//            int i1 = tmpText.charAt(i);
//            System.out.print((char)i1);
//            ascii.set(i1, ascii.get(i1)+1);
//        }
//        System.out.println(ascii);
//        for (int i = 0; i < MOST_USED_LETTERS.size(); i++) {
//            char mostUsedChar = (char) getArrayIndexWithMaxValue(ascii,skippedIndx);
//            System.out.println(mostUsedChar);
//
//
//        }
//
//    }
//
//    private static int getArrayIndexWithMaxValue(ArrayList<Integer> array, ArrayList<Integer> skipIndx){
//        ArrayList<Integer> copy = new ArrayList<>(array);
//        Collections.copy(copy,array);
//        Collections.sort(copy);
//        int max =-1;
//
//
//        for (int i = array.size()-1; i >= 0; i--) {
//            if (skipIndx.contains(i)){
//                continue;
//            }
//            max = copy.get(i);
//            skipIndx.add(i);
//            return max;
//        }
//
//        return max;
//    }



}
