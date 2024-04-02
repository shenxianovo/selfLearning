public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new ArrayDeque<Character>();
        for (int i = 0; i < word.length(); ++i) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }
    public boolean isPalindrome(String word) {
        if (word.length() == 1 || word.length() == 0) {
            return true;
        } else {
            int front = 0;
            int back = word.length() - 1;
            while (front < back) {
                if (word.charAt(front) != word.charAt(back)) {
                    return false;
                }
                front++;
                back--;
            }
        }
        return true;
    }

    public boolean isPalindrome(Deque deque) {
        if (deque.isEmpty() || deque.size() == 1) {
            return true;
        } else {
            while(!deque.isEmpty()) {
                if (deque.getFirst() != deque.getLast()) {
                    return false;
                }
                if (deque.size() == 1) {
                    return true;
                } else {
                    deque.removeFirst();
                    deque.removeLast();
                }
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() == 1 || word.length() == 0) {
            return false;
        } else {
            int front = 0;
            int back = word.length() - 1;
            while (front < back) {
                if (!cc.equalChars(word.charAt(front), word.charAt(back))) {
                    return false;
                }
                front++;
                back--;
            }
        }
        return true;
    }

}