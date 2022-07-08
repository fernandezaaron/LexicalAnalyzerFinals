import java.util.ArrayList;
import java.util.Arrays;

public class constant {
    static ArrayList<String> keywords = new ArrayList<>(
            Arrays.asList("abstract", "class", "default", "enum", "extends", "implements",
                    "instanceof", "interface", "native", "package", "public", "static",
                    "strictfp", "super", "synchronized", "transient",  "void", "volatile")
    );

    static ArrayList<String> semiKeywords = new ArrayList<>(
            Arrays.asList("throw", "throws", "return", "break", "continue", "const", "import",
                    "assert", "final", "new", "private", "protected")
    );

    static ArrayList<String> conditionals = new ArrayList<>(
            Arrays.asList("catch", "try", "finally", "do", "while", "if", "else", "switch", "case", "for")
    );

    static ArrayList<String> dataTypes = new ArrayList<>(
            Arrays.asList("this", "boolean", "byte", "int", "char", "long", "double", "float", "short", "String")
    );

    static ArrayList <String> operators = new ArrayList<>(
            Arrays.asList("=", "+", "-", "/", "*")
    );
    static ArrayList <String> punctuators = new ArrayList<>(
            Arrays.asList("!", "%", "^", "&",  "|", "~",
                     ":", "<", ">", "?", ".", "#")
    );
    static ArrayList<String> separators = new ArrayList<>(
            Arrays.asList("{", "}", "[", "]", "(", ")", ",")
    );
    static String semicolon = new String(";");

}

