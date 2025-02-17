
import java.util.HashSet;
import java.util.Set;

class Solution {

    private Set<String> allSet = new HashSet<>();

    public void numTilePossibilities(String tiles, Set<Integer> visited, String currStr) {
        if (currStr.length() != 0) this.allSet.add(currStr);
        char[] chars = tiles.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            if (!visited.contains(i)) {
                // Set<Integer> s = new HashSet<Integer>(visited);
                // s.add(i);
                visited.add(i);
                this.numTilePossibilities(tiles, visited, currStr);
                this.numTilePossibilities(tiles, visited, currStr + chars[i]);
                visited.remove(i);
            }
        }
    }

    public int numTilePossibilities(String tiles) {
        this.numTilePossibilities(tiles, new HashSet<>(), "");
        System.out.println(allSet);
        return allSet.size();
    }
}
