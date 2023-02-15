/**
 * After having added at least two numbers to our data structure, find may return true.
 * find() needs to figure out if we have stored some pair (n, m),
 * s.t. n + m = target.
 * 
 * Multiple solutions possible:
 * 1) O(1) find and O(n) write time complexity + O(n^2) space: Store lookup table
 * 2) O(n) find O(1) write and O(n) space: Store flat list
 * 
 * We'll implement the latter.
 */
public class TwoSum {
    
    private final List<Integer> numbers = new LinkedList<Integer>();

    public void add(int num) {
        numbers.add(num);
    }
    
    public boolean find(int target) {
        if (numbers.size() < 2) {
            return false;
        }
        
        var seen = new HashSet<Integer>();
        for (var n : numbers) {
            if (seen.contains(target - n)) {
                return true;
            }
            seen.add(n);
        }
        return false;
    }
}
