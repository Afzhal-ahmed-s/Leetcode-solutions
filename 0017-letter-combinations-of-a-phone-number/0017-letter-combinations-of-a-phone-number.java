class Solution {
    public List<String> letterCombinations(String digits) {
        
        List<String> answer = new ArrayList<>();
        
        if(digits.length() == 0)return answer;
        
        HashMap<Character, String> hm = new HashMap<>();
        hm.put('2', "abc");
        hm.put('3', "def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");        
        hm.put('6', "mno");
        hm.put('7', "pqrs");
        hm.put('8', "tuv");
        hm.put('9', "wxyz");
        
        String temp ="";
        int index = 0;
        
        backTrack(index, temp, digits, answer, hm);
        return answer;
    }
    
    public static void backTrack
        (int i, String temp, String digits, List<String> answer, HashMap<Character, String> hm )
    {
        
        if(i == digits.length() ){
            answer.add(temp);
            return;
        }
        char digit = digits.charAt(i);
        String str = hm.get(digit);
        
        for(int j=0; j< str.length(); j++){
            char c = str.charAt(j);
            
            //including
            temp += c;
            
            //recursive call
            backTrack(i + 1, temp, digits, answer, hm);
            
            //excluding
            temp = temp.substring(0,temp.length()-1);
        }
        
    }
}