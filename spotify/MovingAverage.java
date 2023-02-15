public class MovingAverage {
    
    private final int windowSize;
    private final LinkedList<Integer> window = new LinkedList<Integer>();
    private int sum = 0;
    
    public MovingAverage(int windowSize) {
        this.windowSize = windowSize;
    }
    
    public double add(int value) {
        if (window.size() >= windowSize) {
            sum -= window.removeLast();
        }        
        window.add(value);
        sum += value;
        return (double) sum / (double) windowSize;
    }
}
