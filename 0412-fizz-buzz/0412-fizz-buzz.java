class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list= new ArrayList<>();
        
        for(int a=1; a<=n; a++){
            if(a%3==0 && a%5==0)list.add("FizzBuzz");
            else if(a%3==0)list.add("Fizz");
            else if(a%5==0)list.add("Buzz");
            else list.add(a+"");
        }
        return list;
    }
}