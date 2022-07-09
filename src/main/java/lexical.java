import java.util.ArrayList;
import java.util.Scanner;

public class lexical {
    private ArrayList<container> output;
    private String code;
    private int count;
    Scanner sc = new Scanner(System.in);
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

    private boolean check(String val, ArrayList<String> arr){
        return arr.contains(val);
    }

    private boolean isalnum(String val){
        return val != null && val.matches("^[a-zA-Z0-9]*$");
    }


    // Logic function is used to identify the input string
    public void logic(){
        int start = 0;
        int end = 0;
        int peek = 0;
        String value = "";
        String concatString;


        for (int i = 0; i < this.code.length(); i++) {
            start = i;
            if(String.valueOf(this.code.charAt(start)).contains("/")) {
                end = start + 1;

                //checks if may katabing backslash
                if (String.valueOf(this.code.charAt(end)).contains("/")) {

                    //if true set peek as end + 1 then loop till the code's end
                    peek = end + 1;
                    while (peek < this.code.length()) {
//                        System.out.println(this.code.charAt(end) + " - " + end);
//                        System.out.println(this.code.charAt(peek) + " - " + peek);
//                        System.out.println("END BEFORE - " + end);
//                        System.out.println("PEEK BEFORE - " + peek);
                        end++;

                        //if peek is currently a newline, add that line into the array
                        if(this.code.charAt(peek) == '\n'){
                            value = this.code.substring(start,end);
                            System.out.println("dumadaan dito promise");
                            output.add(new container(value, "", "Single-Line Comment"));
                            System.out.println(start + " " +end);
                             break;
                        }
                        peek = end + 1;

                        //if peek is currently at the last line of the code, add that line into the array
                        if(peek == this.code.length()){
                            System.out.println(peek + " " + this.code.length());
                            value = this.code.substring(start,peek);
                            System.out.println("dumadaan dito promise");
                            output.add(new container(value, "", "Single-Line Comment"));
                            System.out.println(start + " " +end);
                            break;
                        }
                       // System.out.println(this.code.charAt(end) + " - " + end);
                       // System.out.println(this.code.charAt(peek) + " - " + peek);
//                        System.out.println("END AFTER - " + end);
//                        System.out.println("PEEK AFTER - " + peek);

                    }

                }
                else if(String.valueOf(this.code.charAt(end)).contains("*")){
                    System.out.println("i read the asterisk");
                    peek = end + 1;
//                    while(peek < this.code.length()){
//
//                        if(this.code.endsWith("*/")){
//                            System.out.println("i read the multi line comment");
//                            break;
//                        }
//
//                        peek = end + 1;
//
//

                        //output.add(new container(this.code, "n/a", "Multi-Line Comment"));
                   // }
                }
//                else{
//                    break;
//                }

            }

//            if (String.valueOf(this.code.charAt(i)).contains("/")) {
//                end = i + 1;
//                if(String.valueOf(this.code.charAt(end)).contains("/")) {
//                    peek = end + 1;
//
//                }else {
//
//                }
//
//                while (isalnum(String.valueOf(this.code.indexOf(end)))) {
//                    peek = end + 1;
//                    if (!isalnum(String.valueOf(this.code.indexOf(peek))) && (String.valueOf(this.code.indexOf(peek)) != "\0")) {
//                        break;
//                    } else {
//
//                        end++;
//                    }
//                }
//                value = value.substring(start, peek - start);
//                if (check(value, constant.keywords)) {
//                    System.out.println(value + " - is a keyword" );
//                } else {
//                    System.out.println(value + " - is an Identifier" );
//                }
//            }

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


    private String addString(String string ,int start, int end){
        for(int i = start; i < end; i++){
            string.concat(String.valueOf(i));
        }
        return string;
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
