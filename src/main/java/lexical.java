import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class lexical {
    private ArrayList<container> output;
    private ArrayList<String> variableContainer;
    private String code;
    private String doubleQuote = "\0";
    private boolean varFlag = false;
    private boolean multiFlag = false;
    private boolean singleFlag = false;
    private boolean functionFlag = false;
    private boolean methodFlag =false;

    // Constructor is used to save the code
    public lexical(String code){
        this.code = code;
        output = new ArrayList<>();
        variableContainer = new ArrayList<>();


    }
    // addRow function is used to output the code
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
                        if (this.code.charAt(peek) == '\0' || this.code.charAt(peek) == '\n'  || this.code.charAt(peek) == ' ' || this.code.charAt(peek) == '\t') {
                            end++;
                            break;
                        }
                        if(this.code.charAt(peek) == '.'){
                            methodFlag = true;
                        }
                        if(varFlag && this.code.charAt(peek) == '('){
                            functionFlag = true;
                            varFlag = false;
                            break;
                        }
                        if(!isalnum(String.valueOf(this.code.charAt(peek)))){
                            break;
                        }
                        if(this.code.charAt(peek) == ';'){
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
                               // output.add(new container(value, "n/a", "Single-Line Comment"));
                                singleFlag = true;
                                break;
                            }
                            peek = end + 1;



                        }
                        // If peek is currently at the last line of the code, add that line into the array
                        if(peek == this.code.length()){
                            singleFlag = true;
                        }

                    }
                    // If the next character is "*"
                    else if(String.valueOf(this.code.charAt(end)).contains("*")){
                        peek = end + 1; //1

                        while(peek < this.code.length()){
                            end++; //1
                            peek = end + 1;
                            if(this.code.charAt(end) == '*' && this.code.charAt(peek) == '/'){
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
                        varFlag = true;
                        output.add(new container(codeinput,",","Keywords"));
                    }
                    else if(constant.semiKeywords.contains(codeinput)) {
                        output.add(new container(codeinput,",","Keywords"));
                    }
                    else if(constant.conditionals.contains(codeinput)) {
                        output.add(new container(codeinput,",","conditionals"));
                    }
                    //checks if it datatypes contain codeinput and activates varFlag since a data type will have a variable name afterwards
                    else if(constant.dataTypes.contains(codeinput)) {
                        output.add(new container(codeinput,",","dataTypes"));
                        varFlag = true;
                    }
                    else if (constant.operators.contains(codeinput)) {
                        output.add(new container(codeinput,",","operators"));
                    }
                    else if (constant.punctuators.contains(codeinput)) {
                        output.add(new container(codeinput,",","punctuators"));
                    }
                    else if (constant.separators.contains(codeinput)) {
                        if(codeinput.equals("(") || codeinput.equals("[")){
                            varFlag = true;
                        }
                        output.add(new container(codeinput,",","separators"));
                    }
                    else if (constant.boolTypes.contains(codeinput)) {
                        output.add(new container(codeinput, ",", "boolean"));
                    }
                    else if (doubleQuote != "\0") {
                        output.add(new container(codeinput, "n/a", doubleQuote));
                        doubleQuote = "\0";
                    }
                    else if (codeinput.matches(" ") || codeinput.matches("\n") || codeinput.matches("\t")) {
                        continue;
                    }
                    else if(singleFlag){
                        output.add(new container(codeinput, "n/a", "Single-Line Comment"));
                        singleFlag = false;
                    }
                    else if(multiFlag){
                        output.add(new container(this.code.substring(start,peek), "n/a", "Multi-Line Comment"));
                        multiFlag = false;
                    }

                    else if(variableContainer.contains(codeinput)){
                        variableContainer.add(codeinput);
                        output.add(new container(codeinput, "USED", "variable"));
                    }

                    //checks if variable is valid
                    else if(varFlag && Character.isDigit(codeinput.charAt(0)) || codeinput.charAt(0) == '_'){
                        output.add(new container(codeinput, ",", "Invalid Variable Name"));
                        varFlag = false;
                    }

                    //if variable is valid, it will set the value to not used and add the current codeinput to the variable arraylist
                    else if (varFlag){

                        variableContainer.add(codeinput);


                        if(!duplicate(variableContainer)){
                            output.add(new container(codeinput, "Declared", "variable"));
                        }else{
                            output.add(new container(codeinput, "Not Declared", "variable"));
                            variableContainer.add(codeinput);
                        }
                        varFlag = false;

                    }
                    else if(functionFlag){
                        output.add(new container(codeinput, "", "Function Name"));
                        functionFlag = false;
                    }
                    else if(!variableContainer.contains(codeinput)  && !Character.isDigit(codeinput.charAt(0))){
                        if(methodFlag){
                            output.add(new container(codeinput, ",", "Method"));
                            methodFlag = false;
                        }
//                        else{
//                            output.add(new container(codeinput, "Error", "Cannot Resolve Symbol"));
//                        }

                    }
                    else{
                        output.add(new container(codeinput, ",", "identifier"));
                    }
                     //varFlag = false;
                    // multiFlag = false;
                    // singleFlag = false;
                     functionFlag = false;
                    // methodFlag =false;
            i = end;
        }
    }

    private boolean isalnum(String val){
        return val != null && val.matches("^[a-zA-Z0-9_]*$");
    }

    private boolean duplicate(ArrayList<String> words){
        for(int i = 0; i < words.size(); i++) {
            for(int j = i + 1; j < words.size(); j++) {
                if(words.get(i).equals(words.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }
}


