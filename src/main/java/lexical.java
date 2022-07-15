import java.util.ArrayList;

public class lexical {
    private ArrayList<container> output;
    private ArrayList<String> variableContainer;
    private String code;
    private String doubleQuote;
    private boolean varFlag;
    private boolean multiFlag;
    private boolean singleFlag;
    private boolean functionFlag;
    private boolean methodFlag;
    private boolean semicolonFlag;
    private boolean endStatementFlag;

    // Constructor is used to save the code
    public lexical(String code){
        this.code = code;
        output = new ArrayList<>();
        variableContainer = new ArrayList<>();
        doubleQuote = "\0";
        varFlag = false;
        multiFlag = false;
        singleFlag = false;
        functionFlag = false;
        methodFlag = false;
        semicolonFlag = false;
        endStatementFlag = false;
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
        String stringStatement = "";


        for (int i = 0; i < this.code.length(); i++) {
            start = i;
            end = i;
            if((isAlNum(String.valueOf(this.code.charAt(i))))){
                while((end < this.code.length())){
                    peek = end + 1;
                    try {
//                        if (this.code.charAt(peek) == '\0' || this.code.charAt(peek) == '\n'  || this.code.charAt(peek) == ' ' || this.code.charAt(peek) == '\t') {
//                            end++;
//                            break;
//                        }
//                        if(this.code.charAt(peek) == '.'){
//                            methodFlag = true;
//                        }
//                        if(varFlag && this.code.charAt(peek) == '('){
//                            functionFlag = true;
//                            varFlag = false;
//                            break;
//                        }
//                        if(!isalnum(String.valueOf(this.code.charAt(peek)))){
//                            break;
//                        }
//                        if(this.code.charAt(peek) == ';'){
//                            output.add(new container(this.code.substring(start,peek+1), "n/a", "Statement"));
//                            break;
//                        }
//                        else {
//                            end++;
//                        }
                        if(this.code.substring(start, peek) == "\n") {
                            semicolonFlag = true;
                        }
                        if(semicolonFlag || methodFlag) {
                            varFlag = true;
                        }
                        if(this.code.charAt(peek) == '.'){
                            methodFlag = true;
                            semicolonFlag = true;
                            break;
                        }
                        if(varFlag && this.code.charAt(peek) == '('){
                            functionFlag = true;
                            varFlag = false;
                            semicolonFlag = true;
                            break;
                        }
                        if (this.code.charAt(peek) == '\0' || this.code.charAt(peek) == '\n'  || this.code.charAt(peek) == ' ' || this.code.charAt(peek) == '\t') {
                            end++;
                            if (this.code.charAt(peek) == '\0' || this.code.charAt(peek) == '\n') {
                                endStatementFlag = true;
                            }
                            break;
                        }
                        if(this.code.charAt(peek) == ';'){
                            endStatementFlag = true;
                            semicolonFlag = false;
                            break;
                        }
                        if(!isAlNum(String.valueOf(this.code.charAt(peek)))){
                            break;
                        }
                        else {
                            end++;
                        }
                    }
                    catch (StringIndexOutOfBoundsException e) {
                        endStatementFlag = true;
                        break;
                    }
                    i = end;
                }
            }

            else if(!(isAlNum(String.valueOf(this.code.charAt(i))))){
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
                // END OF READING IF COMMENTS

                // String
                else if (String.valueOf(this.code.charAt(start)).contains(constant.specialCharacter) && end != this.code.length()-1) {
                    peek = end + 1;
                    while(peek < this.code.length()){
                        end++;
                        peek = end + 1;
                        if(this.code.charAt(end) == '\"'){
                            if(this.code.charAt(peek) == ')') {
                                doubleQuote = "Statement";
                            }
                            doubleQuote = "String Value";
                            break;
                        }
                    }
                }
                // End of String


                while ((end < this.code.length())){
                    peek = end + 1;
                    try {
                        if (String.valueOf(this.code.charAt(end)).matches(" ")) {
                            end++;
                            break;
                        }
                        if (this.code.charAt(peek) == '\0' || this.code.charAt(peek) == '\n') {
                            endStatementFlag = true;
                            break;
                        }
                        else {
                            break;
                        }
                    }
                    catch (StringIndexOutOfBoundsException e) {
                        endStatementFlag = true;
                        break;
                    }
                }
            }
            codeinput = this.code.substring(start, peek);
            stringStatement += codeinput;
            if(Character.isDigit(codeinput.charAt(0))) {
                varFlag = false;
            }
            if(constant.keywords.contains(codeinput)) {
                output.add(new container(codeinput,",","Keywords"));
                varFlag = true;
            }
            else if(constant.semiKeywords.contains(codeinput)) {
                output.add(new container(codeinput,",","Keywords"));
            }
            else if(constant.conditionals.contains(codeinput)) {
                varFlag = true;
                functionFlag = false;
                methodFlag = false;
                semicolonFlag = false;
                endStatementFlag = false;
                output.add(new container(codeinput,",","Conditionals"));
            }
            //checks if it datatypes contain codeinput and activates varFlag since a data type will have a variable name afterwards
            else if(constant.dataTypes.contains(codeinput)) {
                output.add(new container(codeinput,",","Data Types"));
                semicolonFlag = true;
                varFlag = true;
                endStatementFlag = false;
            }
            else if (constant.operators.contains(codeinput)) {
                output.add(new container(codeinput,",","operators"));
            }
            else if (constant.punctuators.contains(codeinput)) {
                varFlag = true;
                output.add(new container(codeinput,",","punctuators"));
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
            else if (semicolonFlag && !stringStatement.endsWith(";") && endStatementFlag) {
                output.add(new container(codeinput, "Error", "Semicolon not found."));
                semicolonFlag = false;
                endStatementFlag = false;
                stringStatement = "\0";
            }
            else if (constant.separators.contains(codeinput)) {
                if(codeinput.equals("(") || codeinput.equals("[")){
                    varFlag = true;
                    if(!methodFlag)
                        semicolonFlag = false;
                }
                output.add(new container(codeinput,",","separators"));
            }
            else if(variableContainer.contains(codeinput)){
                variableContainer.add(codeinput);
                output.add(new container(codeinput, "USED", "variable"));
            }
            // Checks if variable is valid
            else if(varFlag && Character.isDigit(codeinput.charAt(0)) || codeinput.charAt(0) == '_'){
                output.add(new container(codeinput, ",", "Invalid Variable Name"));
                varFlag = false;
            }
            // If variable is valid, it will set the value to not used and add the current codeinput to the variable arraylist
            else if (varFlag){
                variableContainer.add(codeinput);
                if(!duplicate(variableContainer)) {
                    output.add(new container(codeinput, "Declared", "variable"));
                }
                else {
                    output.add(new container(codeinput, "Not Declared", "variable"));
                    variableContainer.add(codeinput);
                }
                varFlag = false;

            }
            else if(functionFlag) {
                output.add(new container(codeinput, "", "Function Name"));
                functionFlag = false;
            }
            else if(!variableContainer.contains(codeinput)  && !Character.isDigit(codeinput.charAt(0))){
                if(methodFlag) {
                    output.add(new container(codeinput, ",", "Method"));
                    methodFlag = false;
                }
//                      else{
//                          output.add(new container(codeinput, "Error", "Cannot Resolve Symbol"));
//                      }
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

    // isAlNum function is used to check if the current character is an alpha-numeric value
    private boolean isAlNum(String val){
        return val != null && val.matches("^[a-zA-Z0-9_]*$");
    }

    // duplicate function is used to check if the Array List has a duplicate String
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


