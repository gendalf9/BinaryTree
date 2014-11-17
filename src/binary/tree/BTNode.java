package binary.tree;

import java.util.ArrayList;

public class BTNode {
	private BTNode parent;
	private ArrayList<BTNode> leafs = new ArrayList<BTNode>();
	private String id;

	public BTNode(String id){
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isRoot() {
		return (parent==null);
	}

	public void addNewLeaf(BTNode node) {
		if (leafs.size() < 2){
			node.setParent(this);
			leafs.add(node);
		}
		else
			new Exception("No space for leaf");
	}
	
	public BTNode addNewLeaf(String id) {
		
		if (leafs.size() < 2){
			BTNode leaf = new BTNode(id);
			leaf.setParent(this);
			leafs.add(leaf);
			return leaf;
		}
		else
			new Exception("No space for leaf");
		return null;
	}

	public ArrayList<BTNode> getLeafs() {
		return leafs;
	}

	public BTNode getLeaf(int index) {
		return leafs.get(index);
	}

	public BTNode getParent() {
		return parent;
	}

	public void setParent(BTNode parent) {
		this.parent = parent;
	}

	public void leafToParent(String id) {
		for (BTNode leaf : leafs) {
			if (leaf.getId().equalsIgnoreCase(id)) {
				if (parent == null) {
					parent = leaf;
					leafs.remove(leaf);
					return;
				} else {
					leafs.remove(leaf);
					parent.leafToParent(this.id);
					leafs.add(parent);
					parent = leaf;
					continue;
				}
			}
		}
	}

	public void setAsRoot() throws Exception {
		if (!leafs.isEmpty() || leafs.size() > 0)
			throw new Exception("I'm not leaf");
		parent.leafToParent(id);
		addNewLeaf(parent);
		parent = null;
	}

	public void printTree() {
		System.out.println("parent : "+parent+", id : "+this+", leafs : ["+leafs+"]");
		if(leafs!=null){
			for(BTNode leaf:leafs){
				leaf.printTree();
			}
		}
			
	}
	
	@Override
	public String toString() {
		return "["+id+"]";
	}

}
