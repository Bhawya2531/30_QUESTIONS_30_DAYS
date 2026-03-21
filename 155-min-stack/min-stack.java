class MinStack {
    static class Pair{
        int value;
        int min;

        Pair(int value, int min){
            this.value=value;
            this.min=min;
        }
    }
    Stack<Pair>s;
    public MinStack() {
        s=new Stack<>();
        
    }
    
    public void push(int val) {
        if(s.isEmpty()){
            s.push(new Pair(val,val));
        }else{
            int minVal=Math.min(val,s.peek().min);
            s.push(new Pair(val,minVal));
        }
    }
    public void pop() {
        s.pop();
    }
    
    public int top() {
        return s.peek().value; 
    }
    public int getMin() {
        return s.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */