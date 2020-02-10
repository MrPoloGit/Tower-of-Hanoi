public class Main {

    public static void main(String[] args) {
        Solve(3,1,3);
    }

    public static void Solve(int n, int start, int target){
        // Base Case of 1 just prints instructions
        if (n == 1) {
            System.out.println("Move disk " + start + " to " + target);
            return;
        }

        // Subtracting from total sum to find move peg
        int helper = 6-start-target;

        // Moving Calls the last is the first reversed to end on the final peg
        Solve(n-1, start, helper);
        Solve(1, start, target);
        Solve(n-1, helper, target);
    }
}
