package binary.tree;


public class BinaryTree {
	public static void main(String[] args) throws Exception {
		BTNode root = new BTNode("root");
		BTNode a = root.addNewChild("a");
		BTNode b = root.addNewChild("b");
		BTNode c = a.addNewChild("c");
		BTNode d = a.addNewChild("d");
		BTNode e = b.addNewChild("e");
//		BTNode a = root.addNewLeaf("a");
//		BTNode b = a.addNewLeaf("b");
//		BTNode c = b.addNewLeaf("c");
//		BTNode d = c.addNewLeaf("d");
//		BTNode e = d.addNewLeaf("e");
		root.printTree();
		System.out.println();
		System.out.println();
		e.setAsRoot();
		e.printTree();
		
		System.out.println();
		System.out.println();
	}
}
