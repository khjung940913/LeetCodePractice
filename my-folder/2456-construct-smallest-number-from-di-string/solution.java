class Solution {

    private Set<Integer> used = new HashSet<>();
    private String ans = "";

    private boolean smallestNumber(String pattern, int index) {
        // System.out.println(ans);
        if (index == pattern.length() + 1) {
            return true;
        }

        for(int num = 1; num <= 9; num++) {
            if (used.contains(num)) {
                continue;
            }

            if (index > 0 &&
                pattern.charAt(index - 1) == 'I' && 
                Integer.parseInt(ans.charAt(ans.length()-1) + "") > num
            ) {
                continue;
            }
            
            if (index > 0 &&
                pattern.charAt(index - 1) == 'D' && 
                Integer.parseInt(ans.charAt(ans.length()-1) + "") < num
            ) {
                continue;
            }

            used.add(num);
            ans += num;
            if(this.smallestNumber(pattern, index+1)) {
                return true;
            }
            used.remove(num);
            ans = ans.substring(0, ans.length()-1);
        }
        return false;
    }

    public String smallestNumber(String pattern) {
        if (this.smallestNumber(pattern, 0)) {
            return this.ans;
        }
        return this.ans;
    }
}
