import java.util.*;
class Solution {
    public int[] solution(String[] words, String[] queries) {
        // 길이별로 Trie 분리 저장
        HashMap<Integer, Trie> forwardTries = new HashMap<>();
        HashMap<Integer, Trie> backwardTries = new HashMap<>();
        
        // words를 Trie에 삽입
        for(String word: words) {
            int len = word.length();
            
            // 정방향 Trie
            forwardTries.putIfAbsent(len, new Trie());
            forwardTries.get(len).insert(word);
            
            // 역방향 Trie
            backwardTries.putIfAbsent(len, new Trie());
            backwardTries.get(len).insert(reverse(word));
            
        }
        
        int[] answer = new int[queries.length];
        // queries 처리
        for(int i =0; i<queries.length; i++) {
            String query = queries[i];
            int len = query.length();
            
            if(query.charAt(0) == '?') {
                // 접두사가 와일드카드 -> 역방향
                Trie trie = backwardTries.get(len);
                
                if(trie != null) {
                    answer[i] = trie.search(reverse(query));    
                } else {
                    answer[i] = 0;
                }
                
            } else {
                // 접미사가 와일드카드 -> 정방향
                Trie trie = forwardTries.get(len);
                
                if(trie != null) {
                    answer[i] = trie.search(query);    
                } else {
                    answer[i] = 0;
                }
            }
        }
        
        
        return answer;
    }
    
    // 트라이 노드
    class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<>();
        int count = 0; // 노드를 지나는 단어의 개수
    }
    
    // 트라이
    class Trie {
        TrieNode root = new TrieNode();
        
        void insert(String word) {
            TrieNode node = root;
            node.count++;
            
            for(char c: word.toCharArray()) {
                node.children.putIfAbsent(c, new TrieNode());
                node = node.children.get(c);
                node.count++; // 경로 상의 모든 노드 카운트 증가
            }
        }
        
        int search(String query) {
            TrieNode node = root;
            for(char c: query.toCharArray()) {
                if(c == '?') {
                    // 와일드 카드면 현재까지의 카운트 반환
                    return node.count;
                }
                
                if(!node.children.containsKey(c)) {
                    return 0; // 매칭 실패
                }
                
                node = node.children.get(c);
            }
            
            return node.count;
        } 
    }
    
    // 문자열 뒤집기
    String reverse(String word) {
        return new StringBuilder(word).reverse().toString();
    }
}
