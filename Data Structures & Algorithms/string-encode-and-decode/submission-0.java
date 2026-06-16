class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb= new StringBuilder();
        for(String str: strs){
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        int i=0;
        ArrayList result= new ArrayList<>();
        while(i<str.length()){
            int j=i;
            while(str.charAt(j)!='#'){
                j++;
            }
            int length= Integer.parseInt(str.substring(i,j));
            i=j+1;
            result.add(str.substring(i, i+length));
            i+=length;
        }
        return result;
    }
}
