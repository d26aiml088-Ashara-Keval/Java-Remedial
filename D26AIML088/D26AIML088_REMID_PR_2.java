// Problem 2: Notice Cleaner (Unit 3)
// Students type notices quickly, so they often contain extra spaces and mixed letter case. 
// Write a program that cleans one line of notice text and reports some statistics about it.

// Task
// Remove leading and trailing spaces and split the line into words. 
// Words may be separated by one or more spaces.

// Cleaned sentence: write the whole sentence in lowercase, 
// except that the first letter of the first word is uppercase, and join the words with single spaces. Build it using a StringBuilder.
// Word count: the number of words.
// Shortest word: the shortest word in lowercase. If two or more words have the same shortest length, print the first one.
// Keyword count: how many words are equal to the given keyword, ignoring case. Only whole words count, so theory does not match the.
// Vowel count: the total number of vowels (a, e, i, o, u in either case) in the original line, counted using a loop over its characters.
// Input Format
// Line 1: the notice sentence. It may contain leading, trailing or repeated spaces, and contains only letters and spaces.
// Line 2: the keyword (a single word).

class Cleaner {
    public static String cleanSentence(String sentence) {
        String cleaned = sentence.trim().replaceAll("\\s+", " ");
        String[] words = cleaned.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (i == 0) {
                sb.append(Character.toUpperCase(words[i].charAt(0)))
                  .append(words[i].substring(1).toLowerCase());
            } else {
                sb.append(" ").append(words[i].toLowerCase());
            }
        }
        return sb.toString();
    }

    public static int countWords(String sentence) {
        String[] words = sentence.trim().split("\\s+");
        return words.length;
    }

    public static String findShortestWord(String[] words) {
        String shortest = words[0].toLowerCase();
        for (String word : words) {
            if (word.length() < shortest.length()) {
                shortest = word.toLowerCase();
            }
        }
        return shortest;
    }

    public static int countKeywordOccurrences(String[] words, String keyword) {
        int count = 0;
        for (String word : words) {
            if (word.equalsIgnoreCase(keyword)) {
                count++;
            }
        }
        return count;
    }

    public static int countVowels(String sentence) {
        int count = 0;
        for (char c : sentence.toCharArray()) {
            if ("aeiouAEIOU".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }
}




// Output Format (exactly five lines)
// Sentence: <cleaned sentence>
// Words: <count>
// Shortest word: <word>
// Keyword count: <count>
// Vowels: <count>
// Constraints
// The sentence contains at least 1 word and at most 100 characters.
// The keyword contains only letters.

// Sample Input 0
//   spring SEMESTER exam is   near and exam is TOUGH  
// EXAM
// Sample Output 0
// Sentence: Spring semester exam is near and exam is tough
// Words: 9
// Shortest word: is
// Keyword count: 2
// Vowels: 15
// Explanation: Only the first letter of the sentence stays uppercase. "exam" appears twice when case is ignored, and "is" is the shortest word.

// Sample Input 1
//    The  theory is OK  the theme  
// the
// Sample Output 1
// Sentence: The theory is ok the theme
// Words: 6
// Shortest word: is
// Keyword count: 2
// Vowels: 8
// Explanation: "is" and "OK" both have 2 letters, so the first one, "is", is printed. "theory" and "theme" are not the same whole word as "the", 
// so the keyword count is 2 (the first and fifth words only).

public class INTERNAL_REMEDIAL_pr_2 {
    public static void main(String[] args){
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String sentence = scanner.nextLine();
        String keyword = scanner.nextLine();

        String cleanedSentence = Cleaner.cleanSentence(sentence);
        System.out.println("Sentence: " + cleanedSentence);

        String[] words = cleanedSentence.split(" ");
        int wordCount = words.length;
        System.out.println("Words: " + wordCount);

        String shortestWord = Cleaner.findShortestWord(words);
        System.out.println("Shortest word: " + shortestWord);

        int keywordCount = Cleaner.countKeywordOccurrences(words, keyword);
        System.out.println("Keyword count: " + keywordCount);

        int vowelCount = Cleaner.countVowels(sentence);
        System.out.println("Vowels: " + vowelCount);
    }    
}
