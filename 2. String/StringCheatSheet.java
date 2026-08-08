import java.util.Arrays;
import java.util.List;

public class StringCheatSheet {

    public static void main(String[] args) {

        // =========================================================
        // 1. STRING CREATION
        // =========================================================

        String s1 = "Hello";
        String s2 = new String("Hello");

        System.out.println(s1);
        System.out.println(s2);


        // =========================================================
        // 2. BASIC OPERATIONS
        // =========================================================

        String s = "Hello World";

        System.out.println(s.length());              // 11
        System.out.println(s.charAt(0));             // H
        System.out.println(s.charAt(s.length() - 1));// d

        System.out.println(s.substring(6));          // World
        System.out.println(s.substring(0, 5));       // Hello


        // =========================================================
        // 3. COMPARISON
        // =========================================================

        String a = "hello";
        String b = "hello";
        String c = new String("hello");

        System.out.println(a == b);                  // true
        System.out.println(a == c);                  // false

        System.out.println(a.equals(c));             // true
        System.out.println(a.equalsIgnoreCase("HELLO")); // true


        // =========================================================
        // 4. SEARCHING
        // =========================================================

        String text = "Java Spring Boot";

        System.out.println(text.contains("Spring"));     // true
        System.out.println(text.startsWith("Java"));     // true
        System.out.println(text.endsWith("Boot"));       // true

        System.out.println(text.indexOf("Spring"));      // 5
        System.out.println(text.lastIndexOf("o"));        // 15

        System.out.println(text.indexOf("Python"));      // -1


        // =========================================================
        // 5. MODIFYING STRING
        // =========================================================

        String name = "  Rakib Hasan  ";

        System.out.println(name.toUpperCase());
        System.out.println(name.toLowerCase());

        System.out.println(name.trim());
        System.out.println(name.strip());       // Java 11+

        System.out.println(name.replace("Rakib", "Md Rakib"));

        // Regex
        System.out.println("Java123".replaceAll("\\d", ""));
        // Java


        // =========================================================
        // 6. SPLIT
        // =========================================================

        String skills = "Java,Spring,Redis,Kafka";

        String[] skillArray = skills.split(",");

        for (String skill : skillArray) {
            System.out.println(skill);
        }

        // Split by multiple delimiters
        String data = "Java-Spring Redis";

        String[] parts = data.split("[- ]");

        System.out.println(Arrays.toString(parts));


        // =========================================================
        // 7. STRING <-> CHAR ARRAY
        // =========================================================

        String word = "Hello";

        char[] chars = word.toCharArray();

        for (char ch : chars) {
            System.out.println(ch);
        }

        String newWord = new String(chars);

        System.out.println(newWord);


        // =========================================================
        // 8. STRING <-> NUMBER
        // =========================================================

        int number = Integer.parseInt("123");
        long longNumber = Long.parseLong("100000");
        double decimal = Double.parseDouble("12.5");

        System.out.println(number);
        System.out.println(longNumber);
        System.out.println(decimal);

        String numberString = String.valueOf(123);

        System.out.println(numberString);


        // =========================================================
        // 9. CONCATENATION
        // =========================================================

        String firstName = "Rakib";
        String lastName = "Hasan";

        String fullName = firstName + " " + lastName;

        System.out.println(fullName);


        // =========================================================
        // 10. STRING.JOIN()
        // =========================================================

        String result = String.join(
                ", ",
                "Java",
                "Spring Boot",
                "Redis"
        );

        System.out.println(result);

        List<String> list = List.of(
                "Java",
                "Spring Boot",
                "Kafka"
        );

        String joined = String.join(", ", list);

        System.out.println(joined);


        // =========================================================
        // 11. EMPTY / BLANK
        // =========================================================

        String empty = "";

        System.out.println(empty.isEmpty());      // true

        String spaces = "   ";

        System.out.println(spaces.isEmpty());     // false
        System.out.println(spaces.isBlank());     // true


        // =========================================================
        // 12. STRING.FORMAT
        // =========================================================

        String formatted = String.format(
                "Name: %s, Age: %d",
                "Rakib",
                26
        );

        System.out.println(formatted);

        // Java 15+
        String formatted2 = "Name: %s, Age: %d"
                .formatted("Rakib", 26);

        System.out.println(formatted2);


        // =========================================================
        // 13. STRING BUILDER
        // =========================================================

        StringBuilder sb = new StringBuilder();

        sb.append("Hello");
        sb.append(" ");
        sb.append("World");

        System.out.println(sb);
        System.out.println(sb.toString());


        // =========================================================
        // 14. STRINGBUILDER APPEND
        // =========================================================

        StringBuilder builder = new StringBuilder();

        builder.append("Java");
        builder.append(123);
        builder.append(true);
        builder.append(12.5);

        System.out.println(builder);


        // =========================================================
        // 15. STRINGBUILDER INSERT
        // =========================================================

        StringBuilder sb2 = new StringBuilder("Hello World");

        sb2.insert(6, "Java ");

        System.out.println(sb2);
        // Hello Java World


        // =========================================================
        // 16. STRINGBUILDER DELETE
        // =========================================================

        StringBuilder sb3 = new StringBuilder("Hello World");

        sb3.delete(5, 11);

        System.out.println(sb3);
        // Hello


        // Delete one character
        StringBuilder sb4 = new StringBuilder("Hello");

        sb4.deleteCharAt(1);

        System.out.println(sb4);
        // Helo


        // =========================================================
        // 17. STRINGBUILDER REPLACE
        // =========================================================

        StringBuilder sb5 = new StringBuilder("Hello World");

        sb5.replace(0, 5, "Hi");

        System.out.println(sb5);
        // Hi World


        // =========================================================
        // 18. STRINGBUILDER REVERSE
        // =========================================================

        StringBuilder sb6 = new StringBuilder("Hello");

        sb6.reverse();

        System.out.println(sb6);
        // olleH


        // =========================================================
        // 19. STRINGBUILDER LENGTH / CAPACITY
        // =========================================================

        StringBuilder sb7 = new StringBuilder();

        System.out.println(sb7.length());
        System.out.println(sb7.capacity());

        StringBuilder sb8 = new StringBuilder(100);

        System.out.println(sb8.capacity());


        // =========================================================
        // 20. SET LENGTH
        // =========================================================

        StringBuilder sb9 = new StringBuilder("Hello!");

        sb9.setLength(sb9.length() - 1);

        System.out.println(sb9);
        // Hello


        // =========================================================
        // 21. REMOVE LAST CHARACTER
        // =========================================================

        StringBuilder sb10 = new StringBuilder("Hello!");

        if (sb10.length() > 0) {
            sb10.deleteCharAt(sb10.length() - 1);
        }

        System.out.println(sb10);


        // =========================================================
        // 22. PALINDROME
        // =========================================================

        String palindrome = "madam";

        boolean isPalindrome =
                palindrome.equals(
                        new StringBuilder(palindrome)
                                .reverse()
                                .toString()
                );

        System.out.println(isPalindrome); // true


        // =========================================================
        // 23. REVERSE STRING
        // =========================================================

        String original = "Java";

        String reversed = new StringBuilder(original)
                .reverse()
                .toString();

        System.out.println(reversed);
        // avaJ


        // =========================================================
        // 24. CHARACTER FREQUENCY
        // =========================================================

        String word2 = "hello";

        int[] frequency = new int[256];

        for (char ch : word2.toCharArray()) {
            frequency[ch]++;
        }

        System.out.println(frequency['l']); // 2


        // =========================================================
        // 25. LOWERCASE CHARACTER FREQUENCY
        // =========================================================

        String word3 = "banana";

        int[] freq = new int[26];

        for (char ch : word3.toCharArray()) {
            freq[ch - 'a']++;
        }

        System.out.println(freq['a' - 'a']); // 3
        System.out.println(freq['n' - 'a']); // 2


        // =========================================================
        // 26. STRING POOL
        // =========================================================

        String x = "hello";
        String y = "hello";

        System.out.println(x == y); // true

        String z = new String("hello");

        System.out.println(x == z);       // false
        System.out.println(x.equals(z));  // true


        // =========================================================
        // 27. INTERN()
        // =========================================================

        String p = new String("hello");

        String q = p.intern();

        String r = "hello";

        System.out.println(q == r); // true


        // =========================================================
        // 28. STRINGBUILDER INSIDE LOOP
        // =========================================================

        StringBuilder numbers = new StringBuilder();

        for (int i = 1; i <= 10; i++) {

            if (numbers.length() > 0) {
                numbers.append(", ");
            }

            numbers.append(i);
        }

        System.out.println(numbers);

        // 1, 2, 3, ... 10


        // =========================================================
        // 29. REMOVE TRAILING COMMA
        // =========================================================

        StringBuilder sb11 = new StringBuilder();

        for (int i = 1; i <= 5; i++) {
            sb11.append(i).append(",");
        }

        if (sb11.length() > 0) {
            sb11.deleteCharAt(sb11.length() - 1);
        }

        System.out.println(sb11);
        // 1,2,3,4,5
    }
}