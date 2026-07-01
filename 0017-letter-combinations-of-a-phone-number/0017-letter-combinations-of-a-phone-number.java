import java.util.*;

public class Solution {
    private String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) return res;
        dfs(0, "", digits, res);
        return res;
    }

    private void dfs(int i, String s, String d, List<String> res) {
        if (i == d.length()) {
            res.add(s);
            return;
        }
        String letters = map[d.charAt(i) - '0'];
        for (char c : letters.toCharArray()) {
            dfs(i + 1, s + c, d, res);
        }
    }
}
