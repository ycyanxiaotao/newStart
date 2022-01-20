class Solution {
    public int numSteps(String s) {
        int n = s.length();
        int res = 0;
        boolean seeOne = false;
        for (int i = n - 1; i >= 0; i--) {
            // if the current character is 0, we have two cases
            // 1. we haven't seen 1, this 0 is the right most 0, we need only one divide
            // 2. we have seen 1, then this 0 will become 1 because of a plus one from it's right side, so it needs one + 1 and one divide
            if (s.charAt(i) == '0') {
                res += seeOne ? 2 : 1; 
            } else {
                // if the current character is 1, we have two cases:
                // 1. we haven't seen 1, then this 1 needs one +1 and one divide
                //     special case, if this 1 is the left most 1, we don't do anything
                // 2. we have seen 1, then this 1 will become 0 due to a +1 from it's right side, so it needs only one operation
                if (!seeOne) {
                    if (i != 0) {
                        res += 2;
                    }
                    seeOne = true;
                } else {
                    res++;
                }
            }
        }
        return res;
    }
}