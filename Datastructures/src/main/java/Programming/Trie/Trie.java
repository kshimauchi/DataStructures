package Programming.Trie;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    public TrieNode root;

    public Trie(){
        root = new TrieNode(' ');
    }
    public void insert(String word){
        if(search(word)== true)
            return;
        TrieNode current = root;
        TrieNode pre;
        for(char ch : word.toCharArray()){
            pre = current;
            TrieNode child = current.getChild(ch);
            if(child != null){
                current = child;
                child.parent = pre;
            }else {
                current.children.add(new TrieNode(ch));
                current = current.getChild(ch);
                current.parent = pre;
            }
        }
        current.isEnd = true;
    }
    public boolean search(String word){
        TrieNode current = root;
        for(char ch : word.toCharArray()){
            if(current.getChild(ch)== null)
                return false;
            else {
                current = current.getChild(ch);
            }
        }
        if(current.isEnd == true){
            return true;
        }
        return false;
    }
    // O(n) Time complexity where n is the longest string the prefix is in
    // m is the number of words in the trie
    // O(n + m) space
    public List<String> autocomplete(String prefix){
        //(1) find the last node of the prefix
        //(2) find all the words associated with this node
        TrieNode lastNode = root;
        for(int i = 0 ; i < prefix.length(); i++){
            lastNode = lastNode.getChild(prefix.charAt(i));
            if(lastNode == null)
                return new ArrayList<String>();
        }
        return lastNode.getWords();

    }
    public static void main(String [] args){
        Trie t = new Trie();
        t.insert("amazon");
        t.insert("amazon prime");
        t.insert("amazing");
        t.insert("alibaba");
        t.insert("ali express");
        t.insert("ebay");
        t.insert("walmart");
        t.insert("Armageddon");


        List<String> a = t.autocomplete("ama");

        for(int i = 0 ; i < a.size(); i++){
            System.out.println(a.get(i));
        }

    }
}
