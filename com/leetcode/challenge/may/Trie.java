package com.leetcode.challenge.may;

/*
* Day 14
*
* Implement Trie (Prefix Tree)
* Implement a trie with insert, search, and startsWith methods.
*
* Example:
* Trie trie = new Trie();
* trie.insert("apple");
* trie.search("apple");   // returns true
* trie.search("app");     // returns false
* trie.startsWith("app"); // returns true
* trie.insert("app");
* trie.search("app");     // returns true
*
* Note:
* You may assume that all inputs are consist of lowercase letters a-z.
* All inputs are guaranteed to be non-empty strings.
*
* * */

class Trie {

    class Node {
        Node[] child;
        boolean end;

        public Node() {
            this.child = new Node[26];
            this.end = false;
        }
    }

    Node root;

    public Trie() {
        root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            Node tempNode = node.child[index];
            if (tempNode== null) {
                node.child[index]= new Node();
            }
            node = node.child[index];
        }
        node.end = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node tempNode = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (tempNode.child[index] == null) {
                return false;
            }
            tempNode = tempNode.child[index];
        }
        return tempNode.end;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node tempNode = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (tempNode.child[index] == null) {
                return false;
            }
            tempNode = tempNode.child[index];
        }
        return true;
    }


    public static void main(String args[]) {

        Trie trie = new Trie();
        trie.insert("apple");
        if (trie.search("apple")) {
            System.out.println("Search string found");
        } else {
            System.out.println("Search string not found");
        }
        if (trie.startsWith("app")) {
            System.out.println("Starts with string found");
        } else {
            System.out.println("Starts with string not found");
        }

    }
}