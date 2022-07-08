import java.util.ArrayList;

public class lexical extends constant {
    private ArrayList<ArrayList<container>> output = new ArrayList<ArrayList<container>>();
    private String code;
    private int count;


    // Constructor is used to save the code
    public lexical(String code){
        this.code = code;
//        output = new ArrayList<>();
        count = 0;

    }
    // Show function is used to output the code
    public void show(){
        //System.out.println(code);
        System.out.println(output.get(0));
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
            end = i;
            if(String.valueOf(this.code.indexOf(i)).contains("/")){
                end = i + 1;

                if(String.valueOf(this.code.indexOf(end)).contains("/")){
                    peek = end + 1;

                    while(!(String.valueOf(this.code.indexOf(peek)).contains(null))){
                        peek++;
                    }
                    concatString = addString(value, start, end);
                    output.get(count).add(new container(concatString, "n/a", "Single-Line Comment"));
                    i=peek;
                    count++;

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
            // yung pang semicolon
            if(String.valueOf(this.code.indexOf(i)).contains(keywords)) {
                end = i + 1;
            }

        }
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
