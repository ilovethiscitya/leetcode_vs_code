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
        for(int i = 0; i < s1.length(); i++) {
            char cur = s1.charAt(i);
            if(charS2Mapping[cur] == 0) continue;
            charS2Mapping[cur]++;
            
            if(size == 0) {

            }
        }  
}
    public static void main(String[] args) {
        System.out.println("hello");
    }
}