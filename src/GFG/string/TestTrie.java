package strings;

public class TestTrie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Trie t = new Trie();
		t.insert("a");
		t.insert("ab");
		t.insert("xyz");
		t.insert("lmn");
		t.insert("lmns");
		t.traverse(t.root);
	}

}
