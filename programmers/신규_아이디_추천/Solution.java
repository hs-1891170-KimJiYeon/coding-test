class Solution {
    public String solution(String new_id) {

        new_id = new_id.toLowerCase(); //1단계
        new_id = new_id.replaceAll("[^0-9a-z-._]","");//2단계

//        while(new_id.contains("..")){//3단계
//            new_id = new_id.replace("..", ".");
//        }
        new_id = new_id.replaceAll("[.]{2,}",".");

//        if(new_id.charAt(0)=='.'){//4단계
//            new_id = new_id.replaceFirst(".","");
//        }
//        if(new_id.length()>0 && new_id.charAt(new_id.length()-1)=='.'){
//            new_id = new_id.substring(0,new_id.length()-1);
//        }
        new_id = new_id.replaceAll("^[.]|[.]$",""); // ^: 문자열 시작, $: 문자열 끝

        if(new_id.length()<1)//5단계
            new_id = "a";
        if(new_id.length()>15){ //6단계
            new_id = new_id.substring(0,15);
            new_id = new_id.replaceAll("^[.]|[.]$","");
        }
        else if(new_id.length()<3){//7단계
//            char add = new_id.charAt(new_id.length()-1);
//            StringBuilder new_idBuilder = new StringBuilder(new_id);
//            while(new_idBuilder.length()!=3){
//                new_idBuilder.append(add);
//            }
//            new_id = new_idBuilder.toString();
            while(new_id.length()<3)
                new_id += new_id.charAt(new_id.length()-1);
        }




        return new_id;
    }
    
}
