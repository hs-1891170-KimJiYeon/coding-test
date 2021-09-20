import java.util.Arrays;
import java.util.Comparator;

class Soultion{

    public String solution(int[] numbers) {

        StringBuilder sb = new StringBuilder();
        String[] arr = new String[numbers.length];
        for(int i = 0; i< arr.length; i++){
            arr[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1 + o2);
            }
        });
        for(String s : arr){
            sb.append(s);
        }
        String answer = sb.toString();
        if(answer.charAt(0) == '0') {
            return "0";
        }


        return answer;
    }


}
