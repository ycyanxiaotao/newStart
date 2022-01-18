class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        Map<Character, String> letterMap = new HashMap<Character, String>();
        letterMap.put('2', "abc");
        letterMap.put('3', "def");
        letterMap.put('4', "ghi");
        letterMap.put('5', "jkl");
        letterMap.put('6', "mno");
        letterMap.put('7', "pqrs");
        letterMap.put('8', "tuv");
        letterMap.put('9', "wxyz");
        helper(result, "", 0, letterMap, digits);
        return result;
    }
    
    
    private void helper(List<String> result, String current, int index, Map<Character, String> letterMap, String digits) {
        if (index == digits.length()) {
            result.add(current);
            return;
        }
        
        String letters = letterMap.get(digits.charAt(index));
        for (int j = 0; j < letters.length(); j++) {
            
            helper(result, current + letters.charAt(j), index + 1, letterMap, digits);
        }
        
    }
}