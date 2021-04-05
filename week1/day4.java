class MyCircularQueue {
    int[] cq;
    int cur, k;
    int front;

    public MyCircularQueue(int k) {
        this.k = k;
        cq = new int[k];
        Arrays.fill(cq, -1);
        cur = -1;
        front = 0;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false; 
        cur = (cur+1)%k;
        cq[cur] = value;
        return true;  
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false; 
        cq[front] = -1;
        front = (front+1)%k;
        return true;
    }
    
    public int Front() {
        if(isEmpty()) return -1;
        return cq[front];
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        return cq[cur];
    }
    
    public boolean isEmpty() {
        for(int i = 0; i < k; i++){
            if(cq[i] != -1) return false;
        }
        return true;
    }
    
    public boolean isFull() {
        for(int i = 0; i < k; i++){
            if(cq[i] == -1) return false;
        }
        return true;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
