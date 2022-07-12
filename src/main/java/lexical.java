import java.util.ArrayList;
import java.util.Scanner;

public class lexical {
    private ArrayList<container> output;
    private String code;
    private String doubleQuote = "\0";
    private int count;
    private boolean flag = true;
    private boolean systemFlag = true;
    // Constructor is used to save the code
    public lexical(String code){
        this.code = code;
        output = new ArrayList<>();
        count = 0;

    }
    // Show function is used to output the code
    public void show(){
        //System.out.println(code);
        for (container i: output) {
//            System.out.println(output.get(String.i.show());
            i.show();

        }
        //System.out.println(output.get(0));
    }

    public void addRow(){
        for(container i : output){
            gui.tableModel.addRow(new Object[]{i.getCode(), i.getValue(), i.getIdentify()});
        }
    }

    // Logic function is used to identify the input string
    public void logic(){
        int start = 0;
        int end = 0;
        int peek = 0;
        String codeinput = "";
        String value = "";


        for (int i = 0; i < this.code.length(); i++) {
            start = i;
            end = i;


            if((isalnum(String.valueOf(this.code.charAt(i)))) || !(isalnum(String.valueOf(this.code.charAt(i))))) {
                // START OF READING IF COMMENTS
                if (String.valueOf(this.code.charAt(start)).contains("/") && end != this.code.length() - 1) {
                    end = start + 1;
                    // Check if the next character has "/"
                    if (String.valueOf(this.code.charAt(end)).contains("/")) {

                        // Set peek to end + 1 then loop till the code's end
                        peek = end + 1;
                        while (peek < this.code.length()) {
                            end++;

                            // If peek is currently a newline, add that line into the array
                            if (this.code.charAt(peek) == '\n') {
                                value = this.code.substring(start, end);
                                output.add(new container(value, "n/a", "Single-Line Comment"));
                                System.out.println(start + " " + end);
                                break;
                            }
                            peek = end + 1;

                            // If peek is currently at the last line of the code, add that line into the array
                            if (peek == this.code.length()) {
                                System.out.println(peek + " " + this.code.length());
                                value = this.code.substring(start, peek);
                                output.add(new container(value, "n/a", "Single-Line Comment"));
                                System.out.println(start + " " + end);
                                break;
                            }

                        }

                    }
                    // If the next character is "*"
                    else if (String.valueOf(this.code.charAt(end)).contains("*")) {
                        peek = end + 1;
                        while (peek < this.code.length()) {
                            end++;
                            peek = end + 1;
                            if (this.code.charAt(end) == '*' && this.code.charAt(peek) == '/') {
                                System.out.println(end + " " + peek);
                                System.out.println(this.code.substring(start, peek + 1));
                                output.add(new container(this.code.substring(start, peek + 1), "n/a", "Multi-Line Comment"));
                                break;
                            }
                        }

                    }
                }
            }
//
//                // END OF READING IF COMMENTS
//
//                while((isalnum(String.valueOf(this.code.charAt(end))))){
//                    peek = end + 1;
//                    try {
//                        if (String.valueOf(this.code.charAt(peek)).contains(".") && isalnum(String.valueOf(this.code.charAt(peek + 1)))) {
//                            end = peek + 1;
//                            systemFlag = true;
//                        }
//                        else if (String.valueOf(this.code.charAt(end)).contains(constant.specialCharacter)){
//                            peek = end + 1;
//                            while (peek < this.code.length()){
//                                end++;
//                                peek = end + 1;
//                                if(String.valueOf(this.code.charAt(end)).contains(constant.specialCharacter)){
//                                    systemFlag = true;
//                                    break;
//                                }
//                            }
//                        }
//                        else if (!isalnum(String.valueOf(this.code.charAt(peek))) || this.code.charAt(peek) == '\0') {
//                            flag = true;
//                            break;
//                        }
//                        else {
//                            end++;
//                        }
//                    }
//                    catch (StringIndexOutOfBoundsException e) {
//                        break;
//                    }
//                }
//
//                while(!isalnum(String.valueOf(this.code.charAt(i)))) {
//                    peek = end + 1;
//                    if (String.valueOf(this.code.charAt(end)).contains(" ") || String.valueOf(this.code.charAt(end)).contains("\n")) {
//                        flag = false;
//                        systemFlag = false;
//                        break;
//                    } else {
////                        end++;
//                        flag = true;
//                        systemFlag = false;
////                        System.out.println("daan dito");
////                        end--;
//                        break;
//                    }
//                }
//
//                codeinput = this.code.substring(start, peek);
//                if(constant.keywords.contains(codeinput)) {
//                    output.add(new container(codeinput,"pp","keyword"));
//                }
//                else if(constant.semiKeywords.contains(codeinput)) {
//                    output.add(new container(codeinput,"pp","semiKeywords"));
//                }
//                else if(constant.conditionals.contains(codeinput)) {
//                    output.add(new container(codeinput,"pp","conditionals"));
//                }
//                else if(constant.dataTypes.contains(codeinput)) {
//                    output.add(new container(codeinput,"pp","dataTypes"));
//                }
//                else if (constant.operators.contains(codeinput)) {
//                    output.add(new container(codeinput,"pp","operators"));
//                }
//                else if (constant.punctuators.contains(codeinput)) {
//                    output.add(new container(codeinput,"pp","punctuators"));
//                }
//                else if (constant.separators.contains(codeinput)) {
//                    output.add(new container(codeinput,"pp","separators"));
//                }
//                else if (constant.semicolon.contains(codeinput)) {
//                    output.add(new container(codeinput,"pp","semicolon"));
//                }
//                else if (constant.specialCharacter.contains(codeinput)) {
//                    output.add(new container(codeinput,"pp","special character"));
//                }
//                else {
//                    if(systemFlag) {
//                        output.add(new container(codeinput, "pp", "statement"));
//                    }
//                    else if(flag) {
//                        output.add(new container(codeinput, "pp", "variables"));
//                    }
//                    else{
////                        System.out.println("i am a whitespace");
//                    }
//                }
//            }
            if((isalnum(String.valueOf(this.code.charAt(i))))){
                while((end < this.code.length())){
                    peek = end + 1;
                    try {
                        if (this.code.charAt(peek) == '\0' || this.code.charAt(peek) == ';' || this.code.charAt(peek) == '\n' || this.code.charAt(peek) == ',' || this.code.charAt(peek) == ' ') {
//                            flag = true;
                            break;
                        }
                        else {
                            end++;
                        }
                    }
                    catch (StringIndexOutOfBoundsException e) {
                        break;
                    }

                }
                codeinput = this.code.substring(start, peek);
                if(constant.keywords.contains(codeinput)){
                    peek++;
                    if (this.code.charAt(peek) == '.'){
                        continue;
                    }
                    else if (this.code.charAt(peek) == '('){
                        output.add(new container(codeinput,"pp", "method"));
                        break;
                    }
                }
                else {
                    output.add(new container(codeinput,"pp", "variable"));
                }

            }

            else if(!(isalnum(String.valueOf(this.code.charAt(i))))){
                 //START OF READING IF COMMENTS
                if(String.valueOf(this.code.charAt(start)).contains("/") && end != this.code.length()-1) {
                    end = start + 1;
                    // Check if the next character has "/"
                    if (String.valueOf(this.code.charAt(end)).contains("/")) {

                        // Set peek to end + 1 then loop till the code's end
                        peek = end + 1;
                        while (peek < this.code.length()) {
                            end++;

                            // If peek is currently a newline, add that line into the array
                            if(this.code.charAt(peek) == '\n'){
                                value = this.code.substring(start,end);
                                output.add(new container(value, "n/a", "Single-Line Comment"));
                                System.out.println(start + " " +end);
                                break;
                            }
                            peek = end + 1;

                            // If peek is currently at the last line of the code, add that line into the array
                            if(peek == this.code.length()){
                                System.out.println(peek + " " + this.code.length());
                                value = this.code.substring(start,peek);
                                output.add(new container(value, "n/a", "Single-Line Comment"));
                                System.out.println(start + " " +end);
                                break;
                            }

                        }


                    }
                    // If the next character is "*"
                    else if(String.valueOf(this.code.charAt(end)).contains("*")){
                        peek = end + 1;
                        while(peek < this.code.length()){
                            end++;
                            peek = end + 1;
                            if(this.code.charAt(end) == '*' && this.code.charAt(peek) == '/'){
                                System.out.println(end + " " + peek);
                                System.out.println(this.code.substring(start,peek+1));
                                output.add(new container(this.code.substring(start,peek+1), "n/a", "Multi-Line Comment"));
                                break;
                            }
                        }

                    }
                }

                else if (String.valueOf(this.code.charAt(start)).contains(constant.specialCharacter) && end != this.code.length()-1) {
                    peek = end + 1;
                    while(peek < this.code.length()){
                        end++;
                        peek = end + 1;
                        if(this.code.charAt(end) == '\"'){
                            if(this.code.charAt(peek) == ')') {
                                doubleQuote = "Statement";
                            }
                            else if(this.code.charAt(peek) == ';') {
                                doubleQuote = "String Value";
                            }
                            break;
                        }
                    }

                }

                // END OF READING IF COMMENTS
                while ((end < this.code.length())){
                    peek = end + 1;

                        if (String.valueOf(this.code.charAt(end)).contains(" ")) {
//                        flag = false;
//                        systemFlag = false;
                            break;
                        } else {
//                        end++;
//                        flag = true;
//                        systemFlag = false;
//                        System.out.println("daan dito");
//                        end--;
                            break;
                        }
                }

            }
                    codeinput = this.code.substring(start, peek);
                    if(constant.keywords.contains(codeinput)) {
                        output.add(new container(codeinput,"pp","keyword"));
                    }
                    else if(constant.semiKeywords.contains(codeinput)) {
                        output.add(new container(codeinput,"pp","semiKeywords"));
                    }
                    else if(constant.conditionals.contains(codeinput)) {
                        output.add(new container(codeinput,"pp","conditionals"));
                    }
                    else if(constant.dataTypes.contains(codeinput)) {
                        output.add(new container(codeinput,"pp","dataTypes"));
                    }
//                else if(flag) {
//                    output.add(new container(codeinput, "pp", "variables"));
//                }

                    else if (constant.operators.contains(codeinput)) {
                        output.add(new container(codeinput,"pp","operators"));
                    }
                    else if (constant.punctuators.contains(codeinput)) {
                        output.add(new container(codeinput,"pp","punctuators"));
                    }
                    else if (constant.separators.contains(codeinput)) {
                        output.add(new container(codeinput,"pp","separators"));
                    }
//                    else if (constant.semicolon.contains(codeinput)) {
//                        output.add(new container(codeinput,"pp","semicolon"));
//                    }
                    else if (doubleQuote != "\0") {
                        output.add(new container(codeinput, "n/a", doubleQuote));
                    }
                    else if (codeinput.matches(" ")) {
                        continue;
                    }
                    else {
                        output.add(new container(codeinput, "pp", "Syntax Error"));
                    }
//                    else {
//                        output.add(new container(codeinput,"pp","special character"));
//                    }
            i = end;
        }

    }

    private boolean isalnum(String val){
        return val != null && val.matches("^[a-zA-Z0-9]*$");
    }

}
