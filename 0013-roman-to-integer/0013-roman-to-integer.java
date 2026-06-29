class Solution {
    public int romanToInt(String s) {
        int res=0;
        for (int i = 0; i < s.length(); i++) {
            int val = valueOf(s.charAt(i));
            if (i + 1 < s.length() && val < valueOf(s.charAt(i + 1))) {
                res -= val;
            } else {
                res += val;
            }
        }
        return (res);
    }

    static int valueOf(char ch) {
        if (ch == 'I') return 1;
        if (ch == 'V') return 5;
        if (ch == 'X') return 10;
        if (ch == 'L') return 50;
        if (ch == 'C') return 100;
        if (ch == 'D') return 500;
        if (ch == 'M') return 1000;
        return 0;
    }
}