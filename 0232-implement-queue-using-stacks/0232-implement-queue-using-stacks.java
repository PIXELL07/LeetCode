class MyQueue {
    Stack<Integer>pushStack;
        Stack<Integer>popStack;
        public MyQueue() {
            pushStack=new Stack<>();
            popStack=new Stack<>();
        }

        public void push(int x) {
            pushStack.push(x);
        }

        public int pop() {
            while(!pushStack.isEmpty())popStack.push(pushStack.pop());
            int ans=popStack.pop();
            while(!popStack.isEmpty())pushStack.push(popStack.pop());
            return ans;
        }

        public int peek() {
            while(!pushStack.isEmpty())popStack.push(pushStack.pop());
            int ans=popStack.peek();
            while(!popStack.isEmpty())pushStack.push(popStack.pop());
            return ans;
        }

        public boolean empty() {
            return pushStack.isEmpty();
        }
    
}
