public class Palindrome {
    //the class start

    /* Given a String, wordToDeque should return a Deque
    *  where the characters appear in the same order as in the String
    * */
    public Deque<Character> wordToDeque(String word) {
        char[] c= word.toCharArray();
        Deque<Character> d= new ArrayDeque<>();
        for(int i=c.length-1;i>=0;--i) {
            d.addFirst(c[i]);
        }
        return d;
    }

    /**
     * The isPalindrome method should return true if the given word is a palindrome, and false otherwise.
     * */
    public boolean isPalindrome(String word) {
        char[] c= word.toCharArray();
        int i= 0;
        int j= c.length-1;
        return helper(c, i, j);
    }
    private boolean helper(char[] c, int start, int end) {
        //base case
        if(start>end) return true;
        //recursion
        if(c[start]!=c[end]) {
            return false;
        }
        else return helper(c, start+1, end-1);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> d= wordToDeque(word);
        int start= 1;
        int end= d.size();
        for(int i=0;i<d.size()/2;++i) {
            if(!cc.equalChars(d.get(start), d.get(end))) {
                return false;
            }
            start+=1;
            end-=1;
        }
        return true;
    }
    //the class end

}
