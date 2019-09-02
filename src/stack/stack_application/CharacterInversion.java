package stack.stack_application;

import java.util.Stack;

/*
* 字符反转
* StringBuffer和StringBuilder有字符串反转功能
* */
public class CharacterInversion {
    private String in;
    private String out;
    public CharacterInversion(String in){
        this.in=in;
    }
    public String Inversion(){
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<in.length();i++){
            stack.push(in.charAt(i));
        }
        out="";
        while (!stack.isEmpty()){
            out+=stack.pop();
        }
        return out;
    }

}
