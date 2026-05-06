import java.util.Arrays;
import java.util.Scanner;

public class MinOperations{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of an array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.print("Enter the elements of an array: ");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.print("Enter the value of k: ");
        int k = sc.nextInt();

        // Check possibility
        for (int i = 1; i < n; i++) {
            if ((arr[i] - arr[0]) % k != 0) {
                System.out.println("Output: -1");
                return;
            }
        }

        System.out.println("The array after dividing by k and sorting the steps to reach the target value is :");
        int[] steps = new int[n];
        for (int i = 0; i < n; i++)
            steps[i] = arr[i] / k;

        Arrays.sort(steps);
        System.out.println("The sorted array: " + Arrays.toString(steps));
        int median = steps[n / 2];
        int ans = 0;

        for (int x : steps)
            ans += Math.abs(x - median);

        System.out.println("The minimum number of operations required to make all elements equal: " + ans);
    }
}