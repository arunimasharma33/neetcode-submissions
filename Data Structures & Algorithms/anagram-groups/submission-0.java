class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map= new HashMap<>();
        int n=strs.length;
        for(String str: strs){
            String freq= getFreq(str);
            if(map.containsKey(freq)){
                
                map.get(freq).add(str);
            }else{
                List<String> newList= new ArrayList<>();
                newList.add(str);
                map.put(freq, newList);
            }
        }
        return new ArrayList<>(map.values());
    }
    String getFreq(String str){
        char frequency[] = new char[26];
        for(char c: str.toCharArray()){
            frequency[c-'a']++;
        }
        char c='a';
        
        StringBuilder sb= new StringBuilder();
        for(int i=0; i<26; i++){
            sb.append(c);
            sb.append(frequency[c-'a']);
            c++;
        }
        return sb.toString();
    }
}
