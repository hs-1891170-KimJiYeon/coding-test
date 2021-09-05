class Soultion{



    public int solution(String s) {

        int len = s.length();
 
        String[] digits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] alp = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
 
        for(int i = 0; i < 10; i++){
            s = s.replaceAll(alp[i], digits[i]);
        }
 
         return Integer.parseInt(s);
     }

}