package calculator;

import java.util.Stack;

import interfaces.iToken;

public abstract class Calculator<T> {
    public T evaluate(Stack<String> expression) {
        if(expression == null || expression.size() == 0) {
            throw new IllegalArgumentException("Invalid Reverse Polish Expression");
        }

//        String[] tokens = expression.split(" ");
        Stack<T> stack = new Stack<>();
        for (String token : expression) {
            parseToken(token).process(stack);
//            System.out.println("Evaluating stack " + stack);
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid Reverse Polish Notation Provided");
        }
        return stack.pop();
    }

    protected abstract iToken<T> parseToken(String token);
}