import java.util.ArrayList;
import java.util.Arrays;

public class constant {
    static ArrayList<String> keywords = new ArrayList<>(
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

