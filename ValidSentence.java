import java.util.Scanner;

public class ValidSentence {

    public static boolean ValidSentence(String input) {
        // 1st Rule = String starts with a capital.

        // Check if the first character of the input string is not an uppercase letter.
        if (!Character.isUpperCase(input.charAt(0))) {
        // If the condition is true, return false, indicating that the string does not start with a capital letter.
            return false;
        }

        // 2nd Rule = String has to have an even number of quotation marks.

        // Initialize a counter to keep track of the number of quotation marks.
        int Quotationmarks = 0;
        // Iterate over each character in the input string.
        for (char a : input.toCharArray()) {
        // Check if the current character is a double quotation mark.
            if (a == '"') {
            // If it does, increment the counter.
                Quotationmarks++;
            }
        }
        // Check if the count of quotation marks is an odd number.
        if (Quotationmarks % 2 != 0) {
        // If it is, return false, indicating that the sentence is not valid.
            return false;
        }

        //3rd Rule = String ends with one of the following sentence termination characters : ".", "?","!"

        // retrieves the last character of the input string, which represents the end of the sentence.
        char LastChar = input.charAt(input.length() - 1);
        // Check if the last character is not one of the specified sentence termination characters.
        if (LastChar != '.' && LastChar != '?' && LastChar != '!') {
        // If it is not, return false, indicating that the sentence is not valid.
            return false;
        }

        // 4th Rule = String has no period characters other than the last character.

        //checks whether there are multiple occurrences of the period character (.) in the input string.
        if (input.indexOf('.') != input.lastIndexOf('.')) {
        // If there are multiple occurences in the string (excluding the last character), return false.
            return false;
        }

        //5th Rule = Numbers bellow 13 are spelled out.
        // Split the input sentence into an array of words based on whitespace.
        String[] Words = input.split("\\s+");
        // Iterate over each word in the array
        for (String Word : Words) {
            // Check if the word is numeric and its integer value is less than 13.
            if (isNumeric(Word) && Integer.parseInt(Word) < 13) {
                // If the condition is true, return false, indicating that the sentence is invalid.
                return false;
            }
        }

        //If all rules are passed as expected, return is valid
        return true;
    }


    // Helper method to check if a string represents a numeric value.
    private static boolean isNumeric (String str){
            try{
            // Attempt to parse the string as an integer.
                Integer.parseInt(str);
            // If successful, return true, indicating that the string is numeric.
                return true;
            } catch (NumberFormatException e){
            // If an exception is caught, return false, indicating that the string is not numeric.
                return false;
            }
        }
        public static void main(String[]args) {
            // Create a Scanner object to read user input.
            Scanner scanner = new Scanner(System.in);

            // Prompt the user to enter a sentence.
            System.out.println("Please Enter a sentence: ");
            // Read the user's input.
            String UserInput = scanner.nextLine();

            // Check if the entered sentence is valid using the ValidSentence method.
            if (ValidSentence(UserInput)) {
                // If the sentence is valid, print a success message
                System.out.println("The Sentence is valid");
            } else {
                // If the sentence is invalid, print an error message.
                System.out.println("The Sentence is Invalid");
            }
        //close the scanner.
        scanner.close();
        }

        }
