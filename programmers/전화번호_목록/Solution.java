import java.util.HashMap;
class Solution {
    public boolean solution(String[] phone_book) {

        HashMap<String, String> map = new HashMap<>();
        for(String str: phone_book){
            map.put(str,"");
        }


        for(int i = 0; i< phone_book.length; i++){
            for(int j = 0; j < phone_book[i].length(); j++)
                if (map.containsKey(phone_book[i].substring(0,j))){
                    return false;
                }
        }
        return true;

    }
}