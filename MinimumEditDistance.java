public class MinimumEditDistance {
    public int minDistance(String s, String t) {
        int m = s.length(), n = t.length();
        
        //create a memoization table to store subproblem results
        int[][] memo = new int[m + 1][n + 1];
         //initialize all values to -1 (meaning not yet computed)
        for (int i = 0; i <= m; i++) {      	
        	    Arrays.fill(memo[i], -1);
        	}
        //start the recursive helper function from full lengths of both strings
        return helper(s, t, m, n, memo);
    }

    private int helper(String s, String t, int i, int j, int[][] memo) {
    	//if the first string is empty, insert all characters from the second
        if (i == 0) return j;
        
        //if the second string is empty, delete all characters from the first
        if (j == 0) return i;
        
        //if this subproblem has already been solved, return the stored result
        if (memo[i][j] != -1) 
        	return memo[i][j];
        //if characters match, no operation is needed; move to previous chars
        if (s.charAt(i - 1) == t.charAt(j - 1)) {
            memo[i][j] = helper(s, t, i - 1, j - 1, memo);
        } 
        else {	
        	//try all three operations: insert, delete, replace
            int insert = 1 + helper(s, t, i, j - 1, memo);
            int delete = 1 + helper(s, t, i - 1, j, memo);
            int replace = 1 + helper(s, t, i - 1, j - 1, memo);
            
            //choose the operation with the minimum cost
            memo[i][j] = Math.min(insert, Math.min(delete, replace));
        }
        return memo[i][j];
    }

        
    public static void main(String[] args) {
            
    	MinimumEditDistance solver = new MinimumEditDistance();

        String s1 = "intention";
        String s2 = "execution";

        int result = solver.minDistance(s1, s2);
        System.out.println("Minimum Edit Distance: " + result);
        
    }
}
