class Pascal{

    public void nCrGetAnswerforSpecificRowAndColumn(int r, int c){
        int res = 1;

        for(int i=0; i<c; i++){
            res *= r-i;
            res /= i + 1;
        }
        print(res);
    }

    public void nCrGetAnswerforSpecificRow(int r){
        print(1);
        int ans = 1;

        for(int i=1; i<r; i++){
            ans *= r-i;
            ans /= i;
            print(ans);
        }

    }

    public void nCrGetAnswerforNumberOfRows(int n){

        for(int i=1; i<=n; i++){
            nCrGetAnswerforSpecificRow(i);
            System.out.println();
        }

    }

    public <T> void print(T number){
        System.out.println(number);
    }

    public static void main(String[] args) {
        
        int n= 5;
        int r= 5; int c= 5;
        Pascal pascal = new Pascal();

        //execution methods below

        //pascal.nCrGetAnswerforSpecificRowAndColumn(r-1, c-1);
        //pascal.nCrGetAnswerforSpecificRow(r);
        //pascal.nCrGetAnswerforNumberOfRows(n);
    }

}