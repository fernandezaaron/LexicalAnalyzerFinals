import java.util.ArrayList;

public class lexical {
    private ArrayList<container> output;
    private ArrayList<String> variableContainer;
    private String code;
    private String doubleQuote = "\0";
    private int count;
    private boolean varflag = false;
    private boolean multiFlag = false;
    private boolean singleFlag = false;
    private boolean isUsed = false;

    // Constructor is used to save the code
    public lexical(String code){
        this.code = code;
        output = new ArrayList<>();
        variableContainer = new ArrayList<>();
        count = 0;

    }
    // Show function is used to output the code
    public void show(){
        //System.out.println(code);
//        for (container i: output) {
////            System.out.println(output.get(String.i.show());
//            i.show();
//
//        }

//        for(String c : variableContainer){
//            System.out.println(variableContainer.get(Integer.parseInt(c)));
//        }

        for(int i=0; i<variableContainer.size(); i++){
            System.out.println(variableContainer.get(i));
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
            if((isalnum(String.valueOf(this.code.charAt(i))))){

                while((end < this.code.length())){
                    peek = end + 1;
                    try {
                        if (this.code.charAt(peek) == '\0' || this.code.charAt(peek) == '\n' || this.code.charAt(peek) == ',' || this.code.charAt(peek) == ' ') {
//                           varflag = true;
                            System.out.println("dumaan");
                            end++;
                            break;
                        }
                        if(!isalnum(String.valueOf(this.code.charAt(peek)))){
                            break;
                        }
                        if(this.code.charAt(peek) == ';'){
                            System.out.println(this.code.charAt(start) + " " + this.code.charAt(peek));
                            output.add(new container(this.code.substring(start,peek+1), "n/a", "Statement"));
                            break;
                        }
                        else {
                            end++;
                        }
                    }
                    catch (StringIndexOutOfBoundsException e) {
                        break;
                    }
                    i = end;
                }
//
               // codeinput = this.code.substring(start, peek);
            }

            else if(!(isalnum(String.valueOf(this.code.charAt(i))))){
                 //START OF READING IF COMMENTS
                if(String.valueOf(this.code.charAt(start)).contains("/") && end != this.code.length()-1) {
                    end = start + 1;
                    // Check if the next character has "/"
                    if (String.valueOf(this.code.charAt(end)).contains("/")) {

                        // Set peek to end + 1 then loop till the code's end
                        peek = end + 1;
                        System.out.println(peek + " < " + this.code.length());
                        while (peek < this.code.length()) {
                            end++;

                            // If peek is currently a newline, add that line into the array
                            if(this.code.charAt(peek) == '\n'){
                                value = this.code.substring(start,end);
                               // output.add(new container(value, "n/a", "Single-Line Comment"));
                                singleFlag = true;
                                System.out.println(start + " " +end);
                                break;
                            }
                            peek = end + 1;



                        }
                        // If peek is currently at the last line of the code, add that line into the array
                        if(peek == this.code.length()){
                            System.out.println(peek + " " + this.code.length());
//                            value = this.code.substring(start,peek);
                            singleFlag = true;
                            System.out.println(start + " " +end);
                        }

                    }
                    // If the next character is "*"
                    else if(String.valueOf(this.code.charAt(end)).contains("*")){
                        peek = end + 1; //1

                        while(peek < this.code.length()){
                            end++; //1
                            peek = end + 1;
                            if(this.code.charAt(end) == '*' && this.code.charAt(peek) == '/'){
                                System.out.println(end + " " + peek);
                                System.out.println(this.code.substring(start,peek+1));
                                multiFlag = true;
                                end++; //1
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
                            break;
                        }
                        else {
                            break;
                        }
                }


            }
                    codeinput = this.code.substring(start, peek);
                    if(constant.keywords.contains(codeinput)) {
                        varflag = true;
                        output.add(new container(codeinput,",","keyword"));
                    }
                    else if(constant.semiKeywords.contains(codeinput)) {
                        output.add(new container(codeinput,",","semiKeywords"));
                    }
                    else if(constant.conditionals.contains(codeinput)) {
                        output.add(new container(codeinput,",","conditionals"));
                    }
                    //checks if it datatypes contain codeinput and activates varflag since a data type will have a variable name afterwards
                    else if(constant.dataTypes.contains(codeinput)) {
                        output.add(new container(codeinput,",","dataTypes"));
                        varflag = true;
                    }
                    else if (constant.operators.contains(codeinput)) {
                        output.add(new container(codeinput,",","operators"));
                    }
                    else if (constant.punctuators.contains(codeinput)) {
                        output.add(new container(codeinput,",","punctuators"));
                    }
                    else if (constant.separators.contains(codeinput)) {
                        output.add(new container(codeinput,",","separators"));
                    }
                    else if (doubleQuote != "\0") {
                        output.add(new container(codeinput, "n/a", doubleQuote));
                    }
                    else if (codeinput.matches(" ") || codeinput.matches("\n")) {
                        continue;
                    }
                    else if(variableContainer.contains(codeinput)){
                        System.out.println("dumaan here");
                        for (container g: output) {
                            System.out.println("code: "+g.getCode() + " " + codeinput);
                            if(g.getCode().equals(codeinput)){
                                g.setValue("USED");
                            }
                        }
                        output.add(new container(codeinput, "USED", "variable"));
                    }

                    //checks if variable is valid
                    else if(varflag && Character.isDigit(codeinput.charAt(0)) || codeinput.charAt(0) == '_'){
                        output.add(new container(codeinput, ",", "Invalid Variable Name"));
                        varflag = false;
                    }

                    //if variable is valid, it will set the value to not used and add the current codeinput to the variable arraylist
                    else if (varflag){
                        output.add(new container(codeinput, "DECLARED BUT NOT USED", "variable"));
                        variableContainer.add(codeinput);
                        varflag = false;
                    }
                    else if(singleFlag){
                        output.add(new container(codeinput, "n/a", "Single-Line Comment"));
                        singleFlag = false;
                    }
                    else if(multiFlag){
                        output.add(new container(this.code.substring(start,peek), "n/a", "Multi-Line Comment"));
                        multiFlag = false;
                    }
                    else{
                        output.add(new container(codeinput, ",", "identifier"));
                    }
            i = end;
        }
    }

    private boolean isalnum(String val){
        return val != null && val.matches("^[a-zA-Z0-9_]*$");
    }

}


