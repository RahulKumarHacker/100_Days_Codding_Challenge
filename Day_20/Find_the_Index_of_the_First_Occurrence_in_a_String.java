class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length()<needle.length()) return -1;
         return rabinKarp(haystack, needle);
    }
    public int rabinKarp(String s, String b){
        int n=s.length();
        int m=b.length();
        int d=256;
        int q=101;
        int h=1;
        for(int i=0;i<m-1;i++){
            h=(h*d)%q;
        }
        int p=0;
        int t=0;
        for(int i=0;i<m;i++){
            p=(d*p + b.charAt(i))%q;
            t=(d*t + s.charAt(i))%q;
        }
        for(int i=0;i<=n-m;i++){
            if(p==t){
                boolean flag=true;
                for(int j=0;j<m;j++){
                    if(s.charAt(j+i) != b.charAt(j)){
                        flag=false;
                        break;
                    }
                }
                if(flag) return i;
            }
            if(i<n-m){
                t=(d*(t-s.charAt(i)*h) + s.charAt(i+m)) % q;
                if(t<0) t+=q;
            }
        }
        return -1;

    }
    
}