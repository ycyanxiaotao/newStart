class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) {https://leetcode.com/problemset/all/
            return 0;
        }
        Set<String> bankSet = new HashSet<>();
        for (String str : bank) {
            bankSet.add(str);
        }
        
        char[] chs = new char[]{'A', 'C', 'T', 'G'};
        
        Queue<String> queue = new LinkedList();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        int len = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String temp = queue.poll();
                if (temp.equals(end)) {
                    return len;
                }
                char[] tempChar = temp.toCharArray();
                for (int j = 0; j < tempChar.length; j++) {
                    char old = tempChar[j];
                    for (char c : chs) {
                        tempChar[j] = c;
                        String next = new String(tempChar);
                        if (!visited.contains(next) && bankSet.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    tempChar[j] = old;
                }
            }
            len++;
        }
        return -1;
    }

}
