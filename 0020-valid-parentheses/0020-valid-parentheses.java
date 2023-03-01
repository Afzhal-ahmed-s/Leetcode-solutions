class Solution {
    public boolean isValid(String s) {
        Stack stack = new Stack<Character>();
        
        int pointer=0;
        int len = s.length();
        while(pointer < len){
            char c = s.charAt(pointer);
            
            if(c=='{' || c=='(' || c=='[')stack.push(c);
            else{
                if(stack.size()!=0){
                char poped = (char)stack.pop();
                if(poped== '{' && c!= '}' ||
                   poped== '[' && c!= ']' ||
                   poped== '(' && c!= ')')return false;
                }
                else return false;
            }
            
            pointer++;
        }
        if(stack.size()==0)return true;
        else return false;
        
    }
}