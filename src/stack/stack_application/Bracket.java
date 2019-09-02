package stack.stack_application;

import java.util.Stack;

/*
* 检验字符串的合法性
* */
public class Bracket {
    public Boolean checkStr(String s){
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (c=='('||c=='['||c=='{')
                stack.push(c);
            if (c==')'||c==']'||c=='}'){
                if (stack.isEmpty())
                    return false;
                Character pop = stack.pop();
                if (c=='('&&pop!=')'||c=='['&&pop!=']'||c=='{'&&pop!='}')
                    return false;
            }
        }
        return true;
    }
}
