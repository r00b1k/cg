import caesar.Caesar;



public class Main {
    public static void main(String[] args) {

        if (args.length > 1){
            switch (args[0]){
                case "-e" ->{
                    System.out.println(args.length);
                    if (args.length!=3){
                        Main.help();
                        System.exit(1);
                    }
                    int key = Integer.parseInt(args[1]);
                    String textToEncode = args[2];
                    System.out.println(Caesar.encrypt(textToEncode,key));
                    return;
                }
                case "-d" ->{
                    if (args.length!=3){
                        Main.help();
                        System.exit(1);
                    }
                    int key = Integer.parseInt(args[1]);
                    String textToDecode = args[2];
                    System.out.println(Caesar.decrypt(textToDecode,key));
                    return;
                }
                case "-bf" ->{
                    if (args.length!=2 ){
                        Main.help();
                        System.exit(1);
                    }
                    Caesar.hackEncryptedTextBruteForce(args[1]);
                    return;
                }
                default -> Main.help();
            }
        }{
            Main.help();
            System.exit(1);
        }




    }

    private static void help() {
        System.out.printf("""
                USAGE: %s [-param value]
                Parameters:
                -e - Encode mode. Specify key and text to encrypt enclosed in "";
                -d - Decode mode. Specify key and text to decrypt enclosed in "";
                -bf -Decode mode with bruteforce. Specify text encoded in "";
                Example: %s -e 3 "Hello world!"
                """, Main.class.getSimpleName(),Main.class.getSimpleName());
        System.exit(1);

    }

}
