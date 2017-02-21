import java.util.*;

import be.ac.ua.ansymo.adbc.annotations.ensures;
import be.ac.ua.ansymo.adbc.annotations.invariant;
import be.ac.ua.ansymo.adbc.annotations.requires;

@invariant({"this.collection.size() >= 0"})
class List 
{
	public ArrayList<Node> collection;
	
	public List()
	{
		this.collection = new ArrayList<Node>();
	}
	
	@requires({"n != null"})
	@ensures({"$this.collection.size() = 1"})
	public List(Node n)
	{
		this.collection = new ArrayList<Node>();
		this.collection.add(n);
	}
	
	@requires({"n != null"})
	@ensures({
			  "$this.collection.size() == $old($this.collection.size()) + 1",
			  "$this.collection.get($this.collection.size() - 1) == n"
			})
	public void add(Node n)
	{
		this.collection.add(n);
	}
	
	//***********
	//NOTE: For the first pre-condition - if the size of list is currently 0 then it will always fail, needs better logic
	//The capacity of the ArrayList is not related to its size (I think) so a solution can be related to that
	//**********
	@requires({
			   "(index >= 0) && (index < this.collection.size())",
			   "n != null"
			 })
	@ensures({
			  "$this.collection.size() == $old($this.collection.size()) + 1",
			  "$this.collection.get(index) == n"
			})
	public void add(int index, Node n)
	{
		this.collection.add(index, n);
	}
	
	@ensures({"$this.collection.isEmpty()"})
	public void clear()
	{
		this.collection.clear();
	}
	
	@requires({"n != null"})
	@ensures({"$this.collection.size() == $old($this.collection.size())"})
	public boolean contains(Node n)
	{
		if (this.collection.contains(n))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@requires({"index >= 0"})
	@ensures({"$this.collection.size() == $old($this.collection.size())"})
	public Node get(int index)
	{
		return this.collection.get(index);
	}
	
	
	//NOTE: First post-condition may require an if-else statement, is that possible with adbc?
	@requires({"n != null"})
	@ensures({
			  "",
			})
	public int indexOf(Node n)
	{
		return this.collection.indexOf(n);

	}
}