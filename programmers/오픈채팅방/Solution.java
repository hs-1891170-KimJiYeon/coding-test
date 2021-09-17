import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Soultion{

    public String[] solution(String[] record) {

        HashMap<String, String> user = new HashMap<>();
        List<String> commands = new ArrayList<>();
        List<String> ids = new ArrayList<>();
        for(String str : record){
            String[] arr = str.split(" ");
            String cmd = arr[0];
            String uid = arr[1];


            if(cmd.equals("Enter")||cmd.equals("Change")){
                user.put(uid, arr[2]);
            }
            if(cmd.equals("Enter")||cmd.equals("Leave")){
                commands.add(cmd);
                ids.add(uid);
            }



        }
        String[] answer = new String[commands.size()];
        for(int i = 0; i<commands.size(); i++){
            StringBuilder str = new StringBuilder();
            String name = user.get(ids.get(i));
            str.append(name);
            if(commands.get(i).equals("Enter")){
                str.append(" 님이 들어왔습니다.");
            }else{
                str.append(" 님이 나갔습니다.");
            }
            answer[i] = str.toString();
        }

        return answer;
    }


}