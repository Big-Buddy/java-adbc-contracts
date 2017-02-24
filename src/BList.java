import java.util.ArrayList;

import be.ac.ua.ansymo.adbc.annotations.ensures;
import be.ac.ua.ansymo.adbc.annotations.invariant;
import be.ac.ua.ansymo.adbc.annotations.requires;

@invariant({"$super && $this.capacity>=($this.collection.size())"})
public class BList extends List{
	public int capacity;
	@requires ({ "capacity>0" })
	@ensures ({ "true" })
	public BList(int capacity){
		this.capacity=capacity;
		this.collection = new ArrayList<Node>(capacity);
	}
	@requires({"n != null",
		"capacity>0" })
	@ensures({"$this.collection.size() = 1"})
	public BList(int capacity, Node n){
		this.capacity=capacity;
		this.collection = new ArrayList<Node>(capacity);
		this.collection.add(n);
	}
//	
//	@requires ({ "$super && $this.collection.size()<$this.capacity" })
//	@ensures ({ "$super" })
//	public void add(Node n){
//		super.add(n);;
//	}
//	
//	@requires ({ "$super && $this.collection.size()<$this.capacity" })
//	@ensures ({ "$super" })
//	public void add(int index, Node n){
//		super.add(index, n);;
//	}
}
