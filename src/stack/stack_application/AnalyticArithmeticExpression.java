package stack.stack_application;

import java.util.Stack;
/*
*
* */
public class AnalyticArithmeticExpression {
    private String out="";
    Stack<Character> stack;

    public static void main(String[] args) {
        AnalyticArithmeticExpression a = new AnalyticArithmeticExpression();
        String s = a.doAnalyti("(3+2)/5*9");
        System.out.println(s);
        double calculate = a.calculate(s);
        System.out.println(calculate);
    }
    /*
    * 中缀转后缀
    * */
    public String doAnalyti(String s){
        stack = new Stack<>();
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            switch (c){
                case '+':
                case '-':
                    gotOper(c,1);
                    break;
                case '*':
                case '/':
                    gotOper(c,2);
                    break;
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    gotParen(c);
                    break;
                default:
                    out+=c;
                    break;
            }
        }//for循环结束
        while (!stack.isEmpty()){
            out+=stack.pop();
        }
        return out;
    }

    private void gotParen(char c) {
        while (!stack.isEmpty()){
            Character pop = stack.pop();
            if (pop=='(')
                break;
            else
                out+=pop;
        }

    }

    private void gotOper(char c, int i) {
        int j;
        while (!stack.isEmpty()){
            Character pop = stack.pop();
            if (pop=='('){
                stack.push(pop);
                break;
            }
            if (pop=='+'||pop=='-')
                j=1;
            else
                j=2;
            if (j>i){
                out+=pop;
            }else {
                stack.push(pop);
                break;
            }
        }
        stack.push(c);

    }

    /*
    * 后缀计算
    * */
    public double calculate(String s){
        Stack<Double> stack1 = new Stack<>();
        double v;
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            switch (c){
                case '+':
                    v= stack1.pop() + stack1.pop();
                    stack1.push(v);
                    break;
                case '-':
                     v = stack1.pop() - stack1.pop();
                    stack1.push(v);
                    break;
                case '*':
                     v = stack1.pop() * stack1.pop();
                    stack1.push(v);
                    break;
                case '/':
                    v=stack1.pop()/stack1.pop();
                    stack1.push(v);
                    break;
                default:
                    stack1.push(Double.valueOf(c+""));
                    break;
            }
        }
        return stack1.pop();
    }
}
