package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Trie implements TrieIntereface {

	class TrieNode {
		Map<Character, TrieNode> children;
		boolean endOfWord;

		TrieNode() {
			children = new HashMap();
			endOfWord = false;
		}
	}

	TrieNode root;

	@Override
	public void insert(String word) {
		// we need to insert each char in the trie
		// if trie.root == null; that means we are inserting the first character4
		// we will initialize the root and put first char there.
		if (root == null) {
			root = new TrieNode();
		}
		TrieNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			if (cur.children.get(word.charAt(i)) == null) {
				final TrieNode newnode = new TrieNode();
				cur.children.put(word.charAt(i), newnode);
			}
			cur = cur.children.get(word.charAt(i));
		}
		cur.endOfWord = true;
	}

	@Override
	public void traverse(TrieNode root) {
		if (root == null) {
			// System.out.println("empty");
			return;
		}
		// single char case
		if (root.endOfWord == true && root.children.size() == 0) {
			System.out.println();
			return;
		}
		/*
		 * else { for(Entry<Character, TrieNode> e :root.children.entrySet()) {
		 * if(e.getValue()) } //if for any child we have endiof word
		 * System.out.println(); return; }
		 */
		// the idea is to dfs traverse all children key value pair present in root.
		final TrieNode cur = root;
		final Map<Character, TrieNode> child = cur.children;
		for (final Entry<Character, TrieNode> c : child.entrySet()) {
			// System.out.print(c.getKey());
			System.out.print(c.getKey());
			/*
			 * if (c.getValue().endOfWord == true) { System.out.println(); return; }
			 */
			traverse(c.getValue());
			/*
			 * if (root.endOfWord == true) { System.out.println(); return; }
			 */
		}
	}

	private void traverseDFS(Entry<Character, TrieNode> c) {
		System.out.print(c.getKey());
		traverse(c.getValue());
	}
}
