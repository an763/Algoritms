public class ValidWordAbbr {


    public static boolean validWordAbbreviation(String word, String abbr) {

        int runningCounter = 0;
        int count = 0;

        while(count < abbr.length()){
            if(Character.isDigit(abbr.charAt(count))){
                char ch = abbr.charAt(count);
                if(ch == '0') return false;
                if(Character.isDigit(abbr.charAt(count+1))){
                    count++;
                    char mychar = abbr.charAt(count);
                    runningCounter += (ch - 'a')*10 + (abbr.charAt(count) - 'a');
                }else{
                    runningCounter += (ch - 'a');
                }
                count++;
            }else{
                if(word.length() <= runningCounter) return false;
                char pr = abbr.charAt(count);
                if(word.charAt(runningCounter) != pr) return false;
                runningCounter++;
                count++;
            }
        }
        return true;

    }

    public static void main(String args[]){
       System.out.println("---> "+ validWordAbbreviation("internationalization","i12iz4n"));
    }
}
