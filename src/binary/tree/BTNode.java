package binary.tree;

import java.util.ArrayList;

public class BTNode {
	private BTNode parent;
	private ArrayList<BTNode> children = new ArrayList<BTNode>();
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

	public void addNewChild(BTNode node) {
		if (children.size() < 2){
			node.setParent(this);
			children.add(node);
		}
		else
			new Exception("No space for child");
	}
	
	public BTNode addNewChild(String id) {
		
		BTNode child = new BTNode(id);
		addNewChild(child);
		return child;
	}

	public ArrayList<BTNode> getChildren() {
		return children;
	}

	public BTNode getChild(int index) {
		return children.get(index);
	}

	public BTNode getParent() {
		return parent;
	}

	public void setParent(BTNode parent) {
		this.parent = parent;
	}

	public void putChildToParent(String id) {
		for (BTNode child : children) {
			if (child.getId().equalsIgnoreCase(id)) {
				if (parent == null) {
					parent = child;
					children.remove(child);
					return;
				} else {
					children.remove(child);
					parent.putChildToParent(this.id);
					children.add(parent);
					parent = child;
					continue;
				}
			}
		}
	}

	public void setAsRoot() throws Exception {
		if (!children.isEmpty() || children.size() > 0)
			throw new Exception("I'm not leaf");
		parent.putChildToParent(id);
		addNewChild(parent);
		parent = null;
	}

	public void printTree() {
		System.out.println("parent : "+parent+", id : "+this+", children : ["+children+"]");
		if(children!=null){
			for(BTNode leaf:children){
				leaf.printTree();
			}
		}
			
	}
	
	@Override
	public String toString() {
		return "["+id+"]";
	}

}
