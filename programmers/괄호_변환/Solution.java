import java.util.*;
class Solution {
    public String solution(String p) {
        if(isRight(p)) return p;
        else return split(p);
        
    }

    private String split(String p){

        //빈 문자열이면, 빈 문자열 반환
        if(p.length()==0) return "";

        int open = 0;
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();
        StringBuilder s = new StringBuilder();

        int i=0;
        for(char c : p.toCharArray()){
            if(c=='(') open++;
            else open--;
            u.append(c);
            i++;
            if(open==0){
                v.append(p.substring(i));
                break;
            }
        }

        //u가 올바른 문자열이면
        if(isRight(u.toString())){
            u.append(split(v.toString()));

        }
        //올바른 문자열이 아니면
        else{
            s.append('(');
            s.append(split(v.toString()));
            s.append(')');
            String str = u.substring(1,u.length()-1);
            for(char c: str.toCharArray()){
                if(c=='(') s.append(')');
                else s.append('(');
            }
            return s.toString();
        }

        return u.toString();

    }

    //올바른 문자열 확인
    private boolean isRight(String s){
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c=='(') stack.push(c);
            else{
                if(stack.isEmpty()) return false;
                else stack.pop();
            }
        }
        return true;
    }
}