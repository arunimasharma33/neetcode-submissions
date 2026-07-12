class MinStack {
    Stack<Integer> stack= new Stack<>();
    Stack<Integer> minStack= new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || minStack.peek()>=val) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        if(!stack.isEmpty() && !minStack.isEmpty() && stack.peek().equals(minStack.peek())){
            stack.pop();
            minStack.pop();
        }else if(!stack.isEmpty()){
            stack.pop();
        }
    }
    
    public int top() {
        if(!stack.isEmpty()){
            return stack.peek();
            
        }
        return -1;
    }
    
    public int getMin() {
        if(!stack.isEmpty() && !minStack.isEmpty()){
            return minStack.peek();
        }
        return -1;
    }
}
