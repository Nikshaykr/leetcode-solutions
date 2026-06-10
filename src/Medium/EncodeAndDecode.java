package Medium;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecode {

    public String encode(List<String> strs) {
        // To append words use StringBuilder
        StringBuilder sb = new StringBuilder();

        // For each string we append the length of the str with a delimiter like # and return it as a string
        for (String str : strs){
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str){
        List<String> res = new ArrayList<>();

        // Run a loop to find the length store it in i then find the delimiter store it in j, then move i after the
        // delimiter and take characters as the length read in the first place then add that word to res
        int i = 0;
        while (i < str.length()){
            int j = i;
            while (str.charAt(j) != '#') j++;
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            res.add(str.substring(i, i + length));
            i += length;
        }
        return res;
    }

    public static void main(String[] args) {
        EncodeAndDecode solution = new EncodeAndDecode();
        List<String> strs = List.of("Hello", "World");

        String str = solution.encode(strs);
        System.out.println(str);
        List<String> list = solution.decode(str);
        System.out.println(list);
    }
}
