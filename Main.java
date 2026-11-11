import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
//comment name, lecture & lab section

class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        String errorFile = "error.txt";

        System.out.println("Starting Recursion Program");
        /// Calls method to read the input.txt file
        readfile("input.txt");
        /// Creates array list to store each line from input.txt
        ArrayList<String[]> entries = readfile(inputFile);
        /// Opens output.txt and error.txt for input from the Entriesread method
        try (PrintWriter outputWriter = new PrintWriter(outputFile);
                PrintWriter errorWriter = new PrintWriter(errorFile);) {
            Entriesread(entries, outputWriter, errorWriter);
        }

    }

    /// Method that checks if every charcater in the string is an integer
    public static boolean isDigits(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static ArrayList<String[]> readfile(String filename) throws FileNotFoundException, IOException {
        ArrayList<String[]> entries = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lines = line.split(",", -1);
                for (int i = 0; i < lines.length; i++) {
                    lines[i] = lines[i].trim();
                }
                entries.add(lines);
            }
        }
        return entries;
    }

    public static void Entriesread(ArrayList<String[]> entries, PrintWriter outputWriter, PrintWriter errorWriter) {
        for (String[] entry : entries) {
            if (entry.length < 1)
                continue;
            String Recursiontype = entry[0].toLowerCase();
            switch (Recursiontype) {
                case "factorialr":
                    try {
                        if (Integer.parseInt(entry[1]) >= 0) {
                            long number = Long.parseLong(entry[1]);
                            long result = Recursion.factorialR(number);
                            outputWriter.println("The factorial of " + number + " is "
                                    + result);
                            break;
                        } else {
                            errorWriter.println("Invalid input for factorials: " + entry[1]);
                            break;
                        }
                    } catch (NumberFormatException e) {
                        errorWriter.println("Invalid input for factorials: " + entry[1]);

                    }
                    break;
                case "isprimer":
                    try {
                        int number = Integer.parseInt(entry[1]);
                        boolean result = Recursion.isPrimeR(number, 2);
                        if (result) {
                            outputWriter.println("The value " + entry[1] + " is prime.");
                        } else {
                            outputWriter.println("The value " + entry[1] + " is not prime.");
                        }
                        break;
                    } catch (NumberFormatException e) {
                        errorWriter.println("Invalid input for Primes: " + entry[1]);

                    }
                    break;
                case "palindromer":
                    try {
                        String word = entry[1].trim();
                        Boolean palindrome = Recursion.palindromeR(word, 0, word.length() - 1);
                        if (palindrome) {
                            outputWriter.println("The string " + entry[1] + " is a palindrome.");
                        } else {
                            outputWriter.println("The string " + entry[1] + " is not a palindrome.");
                        }
                        break;
                    } catch (Exception e) {
                        errorWriter.println("Invalid input for palindrome: " + entry[1]);

                    }
                    break;
                case "sumr":
                    ArrayList<Integer> numberlist = new ArrayList<Integer>();
                    boolean value = true;
                    for (int i = 1; i < entry.length; i++) {
                        try {
                            int number = Integer.parseInt(entry[i]);
                            numberlist.add(number);

                        } catch (NumberFormatException e) {
                            errorWriter.println("SumR error: The value " + entry[i] + " is invalid.");
                            value = false;
                            break;

                        }
                    }
                    if (value) {
                        int result = Recursion.sumR(outputWriter, numberlist, 0);
                        outputWriter.println("The sum of " + numberlist + " is "
                                + result);
                        break;
                    }

                    break;
                case "reversestringr":
                    try {
                        String word = entry[1].trim();
                        outputWriter.print("The String " + word + " reversed is: ");
                        Recursion.reverseStringR(outputWriter, word);
                        outputWriter.println();
                        break;
                    } catch (Exception e) {
                        errorWriter.println("inalid input for Reverse String: " + entry[1]);
                    }
                    break;
                default:
                    errorWriter.println("inalid Recursion type: " + Recursiontype);

            }

        }
    }
}
