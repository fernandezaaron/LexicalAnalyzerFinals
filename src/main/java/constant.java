import java.util.ArrayList;
import java.util.Arrays;

public class constant {
    static ArrayList<String> keywords = new ArrayList<>(
            Arrays.asList("abstract", "assert", "boolean", "break", "byte", "case", "catch", "char",
                    "class", "const", "continue", "default", "do", "double", "else", "enum", "extends",
                    "final", "finally", "float", "for", "goto", "if", "implements", "import", "instanceof",
                    "int", "interface", "long", "native", "new", "package", "private", "protected", "public",
                    "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this",
                    "throw", "throws", "transient", "try", "void", "volatile", "while")
    );
    static ArrayList <String> operators = new ArrayList<>(
            Arrays.asList("=", "+", "-", "/", "*")
    );
    static ArrayList <String> punctuators = new ArrayList<>(
            Arrays.asList("!", "%", "^", "&", "(", ")", "{", "}", "|", "~",
                    "[", "]", ";", ":", "<", ">", "?", ",", ".", "#")
    );
}

