class SpecialQueue {
    private Queue<Integer> q;
    private Deque<Integer> minDeque; 
    private Deque<Integer> maxDeque;
    public SpecialQueue() {
        // Define Data Structures
        q = new LinkedList<>();
        minDeque = new LinkedList<>();
        maxDeque = new LinkedList<>();
    }
    public void enqueue(int x) {
        // Insert element into the queue
        q.add(x);
        // Maintain minDeque (increasing order)
        while (!minDeque.isEmpty() && minDeque.peekLast() > x) {
            minDeque.pollLast();
        }
        minDeque.addLast(x);
        // Maintain maxDeque (decreasing order)
        while (!maxDeque.isEmpty() && maxDeque.peekLast() < x) {
            maxDeque.pollLast();
        }
        maxDeque.addLast(x);
    }
    public void dequeue() {
        // Remove element from the queue
        if (q.isEmpty()) return;
        int removed = q.poll();
        if (removed == minDeque.peekFirst()) {
            minDeque.pollFirst();
        }
        if (removed == maxDeque.peekFirst()) {
            maxDeque.pollFirst();
        }
    }
    public int getFront() {
        // Get front element
        return q.peek();
    }
    public int getMin() {
        // Get minimum element
        return minDeque.peekFirst();
    }
    public int getMax() {
        // Get maximum element
        return maxDeque.peekFirst();
    }
}