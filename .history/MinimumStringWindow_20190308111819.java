public class MinimumStringWindow {
    public String miniWindow(String s1, String s2) {
        int[] charS2Mapping = new int[256];
        int[] charS1Mapping = new int[256];
        int size = 0;
        for(int i = 0; i < s2.length(); i++)
        {
            char cur = s2.charAt(i);
            charS2Mapping[cur]++;
        }  
          
}
    public static void main(String[] args) {
        System.out.println("hello");
    }
}