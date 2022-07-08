import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        String[] samp = {"static ArrayList <String> operators = new ArrayList<>"};
        lexicalSolver(samp);
    }
    public class constant{
        static ArrayList <String> keywords = new ArrayList<>(
                Arrays.asList("using", "namespace", "std", "return", "include", "iostream", "int", "main",
                        "float", "bool", "double", "string", "char")
        );
        static ArrayList <String> operators = new ArrayList<>(
                 Arrays.asList("=", "+", "-", "/", "*")
         );
        static ArrayList <String> punctuators = new ArrayList<>(
                 Arrays.asList("!", "%", "^", "&", "(", ")", "{", "}", "|", "~",
                         "[", "]", ";", ":", "<", ">", "?", ",", ".", "#")
         );
    }

    private static boolean check(String val, ArrayList<String> arr){
        return arr.contains(val);
    };

    public static boolean isalnum(String val){
        return val != null && val.matches("^[a-zA-Z0-9]*$");
    }

    public static void lexicalSolver(String word[]) {
        int start = 0;
        int end = 0;
        int peek = 0;
        String value = "";


        for (int i=0;i<word.length;i++){
            System.out.println(word[i]);
        }

        for (int i = 0; i < word.length; i++) {
            start = i;
            end = i;
            if (isalnum(word[i])) {
                while (isalnum(word[end])) {
                    peek = end + 1;
                    if (!isalnum(word[peek]) && (word[peek] != "\0")) {
                        break;
                    } else {
                        end++;
                    }
                }
                value = value.substring(start, peek - start);
                if (check(value, constant.keywords)) {
                    System.out.println(value + " - is a keyword" );
                } else {
                    System.out.println(value + " - is an Identifier" );
                }
            } else {
                while (!isalnum(word[end])) {
                    peek = end;
                    if ((word[peek] != "\0")) {
                        break;
                    } else {
                        end++;
                    }
                }
                value = value.substring(start, 1);
                if (check(value, constant.punctuators)) {
                    System.out.println(value + " - is a Punctuator" );
                } else if (check(value, constant.operators)) {
                    System.out.println(value + " - is an Operator" );
                } else {
                    System.out.println(value + " -  does not exist" );
                }
            }
            i = end;
        }
    }
}