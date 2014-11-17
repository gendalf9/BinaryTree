package binary.tree;


public class BinaryTree {
	public static void main(String[] args) throws Exception {
		BTNode root = new BTNode("root");
		BTNode a = root.addNewLeaf("a");
		BTNode b = root.addNewLeaf("b");
		BTNode c = a.addNewLeaf("c");
		BTNode d = a.addNewLeaf("d");
		BTNode e = b.addNewLeaf("e");
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
