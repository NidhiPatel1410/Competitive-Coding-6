// In this problem, keeping an index on the ith element, and running a loop, if index%i or vice-versa is 0, then marking it as 1
// in the path, and making a recursive call for next index. When this recursive call is completed, backtracking and marking it as
// 0 in path. Whenever our index becomes > n, we have one beautiful combination, so increasing the count.

// Time Complexity : 
// Space Complexity : 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 
class BeautifulCombi {
    int count = 0;

    public int countArrangement(int n) {
        // Base case
        if (n == 0) {
            return 0;
        }
        // Call the backtrack method with n, index and path
        backtrack(n, 1, new int[n + 1]);
        return count;
    }

    private void backtrack(int n, int index, int[] path) {
        // Base case
        if (index > n) {
            count++;
            return;
        }
        // Logic
        for (int i = 1; i < n + 1; i++) {
            // If any true, mark it 1 and make other call
            if ((index % i == 0 || i % index == 0) && path[i] == 0) {
                // Action
                path[i] = 1;
                // Recurse
                backtrack(n, index + 1, path);
                // Backtrack
                path[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        BeautifulCombi b = new BeautifulCombi();
        System.out.println(b.countArrangement(3));
    }
}