package Easy;

import java.util.Map;

public class RomanToInteger {

    public int romanToInt (String s){
        Map<Character, Integer> map = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50,
                                             'C', 100, 'D', 500, 'M', 1000);
        var result = 0;
        for (int i = s.length() - 1; i >=0; i--){
            if (i + 1 < s.length() && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                result -= map.get(s.charAt(i));
            } else {
                result += map.get(s.charAt(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RomanToInteger solution = new RomanToInteger();

        String roman1 = "III";
        System.out.println(solution.romanToInt(roman1));
    }
}
