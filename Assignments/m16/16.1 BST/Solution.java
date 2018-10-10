import java.util.Scanner;
class Solution {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String[] tokens = scan.nextLine().split(",");
			switch (tokens[0]) {
			case "put":
				bst.put(new Book(tokens[1], tokens[2], tokens[3]), Integer.parseInt(tokens[4]));
				break;
			case "get":
				System.out.println(bst.get(new Book(tokens[1], tokens[2], tokens[3])));
				break;
			default:
			}
		}
	}
}

class Book implements Comparable<Book> {
	private String name;
	private String author;
	private double price;
	Book(String n, String a, String p) {
		this.name = n;
		this.author = a;
		this.price = Double.parseDouble(p);
	}

	public String getName() {
		return name;
	}
	public String getAuthor() {
		return author;
	}
	public double getPrice() {
		return price;
	}
	public void setName(String n) {
		this.name = n;
	}
	public void setAuthor(String a) {
		this.author = a;
	}
	public void setPrice(String p) {
		this.price = Double.parseDouble(p);
	}
	public int compareTo(Book that) {
		return this.getName().compareTo(that.getName());
	}
}

class BinarySearchTree<Book extends Comparable<Book>, Integer> {
	private Node root;

	class Node {
		public Book key;
		public int value;
		public Node left;
		public Node right;
		Node() {
			this.key = null;
			this.value = 0;;
			this.right = null;
			this.left = null;
		}

		Node(Book k, int v) {
			this.key = k;
			this.value = v;
			this.right = null;
			this.left = null;
		}
		public Book getKey() {
			return this.key;
		}
		public int getValue() {
			return this.value;
		}
	}

	BinarySearchTree() {
		this.root = null;
	}

	public void put(Book key, int value) {
		root = put(root, key, value);
	}

	public Node put(Node curr, Book key, int value) {
		Node current = curr;

		if(current == null){
			return new Node(key, value);
		}
		int c = key.compareTo(current.key);
		if (c < 0) {
			current.left = put(current.left, key, value);
		} else if (c > 0) {
			current.right = put(current.right, key, value);
		} else if ( c == 0) {
			current.value = value;
		}
		return current;

	}

	public int get(Book key){
		Node current = root;
		while(current != null){
			int c = key.compareTo(current.key);
			if(c>0){
				current = current.right;
			} else if(c <0){
				current = current.left;
			} else if ( c == 0){
				return current.value;
			}
		}
		return 10101;
	}


}