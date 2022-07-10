import java.util.ArrayList;
import java.util.Scanner;

public class lexical {
    private ArrayList<container> output;
    private String code;
    private int count;
    private boolean flag = true;
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

            // START OF READING IF COMMENTS
            if(String.valueOf(this.code.charAt(start)).contains("/") && end != this.code.length()-1) {
                end = start + 1;
                // Check if the next character has "/"
                if (String.valueOf(this.code.charAt(end)).contains("/")) {

                    // Set peek to end + 1 then loop till the code's end
                    peek = end + 1;
                    while (peek < this.code.length()) {
//                        System.out.println(this.code.charAt(end) + " - " + end);
//                        System.out.println(this.code.charAt(peek) + " - " + peek);
//                        System.out.println("END BEFORE - " + end);
//                        System.out.println("PEEK BEFORE - " + peek);
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
//                        System.out.println(this.code.charAt(end) + " - " + end);
//                        System.out.println(this.code.charAt(peek) + " - " + peek);
//                        System.out.println("END AFTER - " + end);
//                        System.out.println("PEEK AFTER - " + peek);

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

            // END OF READING IF COMMENTS


            else if((isalnum(String.valueOf(this.code.charAt(i)))) || !(isalnum(String.valueOf(this.code.charAt(i))))) {

                while((isalnum(String.valueOf(this.code.charAt(end))))){
                    peek = end + 1;
                    try {
                        if (!isalnum(String.valueOf(this.code.charAt(peek))) || this.code.charAt(peek) == '\0') {
                            flag = true;
                            break;
                        } else {
                            end++;
                        }
                    }
                    catch (StringIndexOutOfBoundsException e) {
                        break;
                    }
                }

                while(!isalnum(String.valueOf(this.code.charAt(i)))) {
                    peek = end + 1;
                    if (String.valueOf(this.code.charAt(end)).contains(" ")) {
                        flag = false;
                        break;
                    } else {
//                        end++;
                        flag = true;
                        System.out.println("daan dito");
//                        end--;
                        break;
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
                if (constant.operators.contains(codeinput)) {
                    output.add(new container(codeinput,"pp","operators"));
                }
                else if (constant.punctuators.contains(codeinput)) {
                    output.add(new container(codeinput,"pp","punctuators"));
                }
                else if (constant.separators.contains(codeinput)) {
                    output.add(new container(codeinput,"pp","separators"));
                }
                else {
                    if(flag) {
                        output.add(new container(codeinput, "pp", "variables"));
                    }
                    else{
                        System.out.println("i am a whitespace");
                    }

                    }


            }

//            else if(!(isalnum(String.valueOf(this.code.charAt(i))))) {
//                try {
//                    while(!isalnum(String.valueOf(this.code.charAt(i)))) {
//                        peek = end + 1;
//
//                        if(String.valueOf(this.code.charAt(i)).contains(" ")) {
//                            System.out.println("whitespace here");
//                            end++;
//                            break;
//                        }
//                        else if (String.valueOf(this.code.charAt(peek)).contains("\0")) {
//
//                            System.out.println("null");
//                            break;
//                        }
//                        else if (constant.operators.contains(String.valueOf(this.code.charAt(i) + String.valueOf(this.code.charAt(end))))) {
//                            end++;
//                            break;
//                        }
//                        else {
//                            end++;
//                            System.out.println("daan dito");
//                            break;
//                        }
//                    }
//                }
//                catch (StringIndexOutOfBoundsException SIOOB) {
//                    break;
//                }
//                codeinput = this.code.substring(start,end);
//                if (constant.operators.contains(codeinput)) {
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
////                else if (constant.whitespace.contains(codeinput)){
////
////                    System.out.println("ANOTHER WHITESPACE");
////                    break;
////                }
//                else {
//                    System.out.println("YOU ARE NOT SUPPOSED TO BE HERE");
//                    break;
//                }
//                //testing lng toh
//                end--;
//            }

            i = end;
        }


//                if(String.valueOf(this.code.indexOf(end)).contains("*")){
//                    peek = end + 1;
//                    if(String.valueOf(this.code.indexOf(peek)).contains("*")){
//                        peek++;
//                        while(!String.valueOf(this.code.indexOf(peek)).contains("/")){
//                            peek++;
//                        }
//                    }
//
//                }

    }

    private boolean check(String val, ArrayList<String> arr){
        return arr.contains(val);
    }

    private boolean isalnum(String val){
        return val != null && val.matches("^[a-zA-Z0-9]*$");
    }

}



//            if (isalnum(String.valueOf(this.code.indexOf(i)))) {
//                while (isalnum(String.valueOf(this.code.indexOf(end)))) {
////                        peek = end + 1;
////                        if (!isalnum(String.valueOf(this.code.indexOf(peek))) && (String.valueOf(this.code.indexOf(peek)) != "\0")) {
////                            break;
////                        } else {
////
//                  end++;
//                    }
//                }
//                value = value.substring(start, peek - start);
//                if (check(value, constant.keywords)) {
//                    System.out.println(value + " - is a keyword" );
//                } else {
//                    System.out.println(value + " - is an Identifier" );
//                }
//            } else {
//                while (!isalnum(String.valueOf(this.code.indexOf(end)))) {
//                    peek = end;
//                    if ((String.valueOf(this.code.indexOf(peek)) != "\0")) {
//                        break;
//                    } else {
//                        end++;
//                    }
//                }
//                value = value.substring(start, 1);
//                if (check(value, constant.punctuators)) {
//                    System.out.println(value + " - is a Punctuator" );
//                } else if (check(value, constant.operators)) {
//                    System.out.println(value + " - is an Operator" );
//                } else {
//                    System.out.println(value + " -  does not exist" );
//                }
//            }
//            i = end;





//    public static void lexicalSolver(String word[]) {
//        int start = 0;
//        int end = 0;
//        int peek = 0;
//        String value = "";
//
//        for (int i = 0; i < word.length; i++) {
//            start = i;
//            end = i;
//            if (isalnum(word[i])) {
//                while (isalnum(word[end])) {
//                    peek = end + 1;
//                    if (!isalnum(word[peek]) && (word[peek] != "\0")) {
//                        break;
//                    } else {
//                        end++;
//                    }
//                }
//                value = value.substring(start, peek - start);
//                if (check(value, constant.keywords)) {
//                    System.out.println(value + " - is a keyword" );
//                } else {
//                    System.out.println(value + " - is an Identifier" );
//                }
//            } else {
//                while (!isalnum(word[end])) {
//                    peek = end;
//                    if ((word[peek] != "\0")) {
//                        break;
//                    } else {
//                        end++;
//                    }
//                }
//                value = value.substring(start, 1);
//                if (check(value, constant.punctuators)) {
//                    System.out.println(value + " - is a Punctuator" );
//                } else if (check(value, constant.operators)) {
//                    System.out.println(value + " - is an Operator" );
//                } else {
//                    System.out.println(value + " -  does not exist" );
//                }
//            }
//            i = end;
//        }
//    }
//}
