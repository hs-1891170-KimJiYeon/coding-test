public class Solution1 {
    

    public int solution(String s) {

        String result = "";

        HashMap<String, String> numMap = new HashMap<>();
        numMap.put("one", "1");
        numMap.put("two", "2");
        numMap.put("three", "3");
        numMap.put("four", "4");
        numMap.put("five", "5");
        numMap.put("six", "6");
        numMap.put("seven", "7");
        numMap.put("eight", "8");
        numMap.put("nine", "9");
        numMap.put("zero", "0");

        List<String> num = new ArrayList<>();
        List<String> res = new ArrayList<>();
        for(char c : s.toCharArray()){
            if(c>='a' && c <= 'z'){

                num.add(String.valueOf(c));
                int size = num.size();
                if(size>=3){

                    String[] arr = num.toArray(new String[size]);
                    String value = String.join("", arr);
                    if(numMap.containsKey(value)){
                        res.add(numMap.get(value));
                        num.clear();
                    }
                }

            }
            else{

                res.add(String.valueOf(c));
            }
        }
        int size = res.size();
        String[] arr = res.toArray(new String[size]);
        String value = String.join("", arr);

        return Integer.parseInt(value);
    }

}
