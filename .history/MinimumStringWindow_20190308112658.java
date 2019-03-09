public class MinimumStringWindow {
    public String miniWindow(String s1, String s2) {
        int[] charS2Mapping = new int[256];
        int[] charS1Mapping = new int[256];
        int size = s2.length();
        for(int i = 0; i < s2.length(); i++)
        {
            char cur = s2.charAt(i);
            charS2Mapping[cur]++;
        }  
        int start = 0;
        for(int i = 0; i < s1.length(); i++) {
            char cur = s1.charAt(i);
            if(charS2Mapping[cur] == 0) continue;
            charS2Mapping[cur]++;
            if(charS2Mapping[cur] <= charS1Mapping[cur]) {
                size--;
            }
            if(size == 0) {
                while(charS2Mapping[s1.charAt(start) - 'a'] == 0 || charS1Mapping[s1.charAt(start) - 'a'] > charS2Mapping[s1.charAt(start) - 'a']) {
                    start++;
                }
            }
        }  
}
    public static void main(String[] args) {
        System.out.println("hello");
    }
}