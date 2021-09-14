
class Soultion{

    public String solution(int[] numbers, String hand) {

        StringBuilder sb = new StringBuilder();
        int left = 10, right = 12;
        int leftLth, rightLth;
        for(int n : numbers){
            if (n == 1 || n == 4 || n == 7){
                sb.append("L");
                left = n;
            }
            else if (n == 3 || n == 6 || n == 9){
                sb.append("R");
                right = n;
            }
            else if ( n == 2 || n == 5 || n == 8 || n == 0){
                if(n==0) n += 11;
                leftLth = Math.abs(n-left)/3 + Math.abs(n-left)%3;
                rightLth = Math.abs(n-right)/3 + Math.abs(n-right)%3;

                if(leftLth == rightLth){
                    if(hand.equals("left")) {
                        sb.append("L");
                        left = n;
                    }
                    else {
                        sb.append("R");
                        right = n;
                    }
                }
                else if (leftLth < rightLth){
                    sb.append("L");
                    left = n;
                }
                else{
                    sb.append("R");
                    right = n;
                }
            }
        }

        return sb.toString();
    }


}