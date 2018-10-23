import java.util.Scanner;
class Solution{
	public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        BST bst = new BST();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            switch (tokens[0]) {
            case "put":
                bst.put(new BookInfo(tokens[1], tokens[2],
                tokens[2 + 1]), Integer.parseInt(tokens[2 + 2]));
                break;
            case "get":
                int output = bst.get(new BookInfo(tokens[1],
                    tokens[2],
                                   tokens[2 + 1]));
                if (output == 0) {
                    System.out.println("null");
                } else {
                    System.out.println(output);
                }
                break;
            case "max":
                Comparable maxbook = bst.max();
                System.out.println(maxbook.toString());
                break;
            case "min":
                Comparable minbook = bst.min();
                System.out.println(minbook.toString());
                break;
            case "select":
                Comparable select = bst.select(Integer.
                        parseInt(tokens[1]));
                System.out.println(select.toString());
                break;
            case "floor":
                Comparable floor = bst.floor(new BookInfo(
                        tokens[1], tokens[2], tokens[2 + 1]));
                if (floor == null) {
                    System.out.println("null");
                } else {
                    System.out.println(floor.toString());
                }
                break;
            case "ceiling":
                Comparable ceiling = bst.ceiling(new BookInfo(
                            tokens[1], tokens[2], tokens[2 + 1]));
                if (ceiling == null) {
                    System.out.println("null");
                } else {
                    System.out.println(ceiling.toString());
                }
                break;
            case "delete":
                bst.delete(new BookInfo(tokens[1], tokens[2],
                                        tokens[2 + 1]));
                break;
            case "deleteMin":
                bst.deleteMin();
                break;
            case "deleteMax":
                bst.deleteMax();
                break;
            default:
                break;
            }
        }
    }
}

class BookInfo implements Comparable<BookInfo> {
	String bookName;
	String bookAuthor;
	String bookPrice;
	BookInfo(String n, String a, String p){
		this.bookName = n;
		this.bookAuthor = a;
		this.bookPrice = p;
	}

	public String getName(){
		return this.bookName;
	}
	public String getAuthor(){
		return this.bookAuthor;
	}
	public String getPrice(){
		return this.bookPrice;
	}
	public String toString() {
        return this.getName() + ", "
               + this.getAuthor() + ", "
               + Float.parseFloat(this.getPrice());
    }
    public int compareTo(final BookInfo that) {
        return this.getName().compareTo(that.getName());
    }
}

