import java.util.*;

import be.ac.ua.ansymo.adbc.annotations.ensures;
import be.ac.ua.ansymo.adbc.annotations.invariant;
import be.ac.ua.ansymo.adbc.annotations.requires;

@invariant({"$this.collection.size() >= 0"})
public class List 
{
	public ArrayList<Node> collection;
	@requires ({ "true" })
	@ensures ({ "true" })
	public List()
	{
		this.collection = new ArrayList<Node>();
	}
	
	@requires({"n != null"})
	@ensures({"$this.collection.size() == 1"})
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
		
		if(this.collection.size() > 1)
		{
			this.get(this.collection.size()-2).setNext(this.get(this.collection.size()-1));
		}
	}
	
	@requires({
			   "((index > 0) && (index <= $this.collection.size())) || (index == 0)",
			   "n != null"
			 })
	@ensures({
			  "$this.collection.size() == $old($this.collection.size()) + 1",
			  "$this.collection.get(index) == n"
			})
	public void add(int index, Node n)
	{
		this.collection.add(index, n);
		
		if(this.collection.size() > 1 && (index == this.collection.size()-1))
		{
			this.get(this.collection.size()-2).setNext(this.get(this.collection.size()-1));
		}
		else if (index > 0 && index < this.collection.size()-1)
		{
			this.get(index-1).setNext(this.get(index));
			this.get(index).setNext(this.get(index+1));
		}
		else if (index == 0 && this.collection.size() > 1)
		{
			this.get(index).setNext(this.get(index+1));
		}
	}
	
	@requires ({ "true" })
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
			  "true",
			})
	public int indexOf(Node n)
	{
		return this.collection.indexOf(n);

	}
	
	@requires ({ "true" })
	@ensures({"$this.collection.size() == $old($this.collection.size())"})
	public boolean isEmpty()
	{
		return this.collection.size()==0;
	}
	
	@requires({"$this.collection.size()!=0",
		"((index > 0) && (index <= $this.collection.size())) || (index == 0)"
	})
	@ensures({"$old($this.collection.get(index).getNext()==null) || $this.collection.get(index) == $old($this.get(index).getNext())"})
	public void remove(int index)
	{
		if(this.collection.size() > 1 && (index == this.collection.size()-1))	//removing last node
		{
			this.get(index-1).next=(this.get(index).getNext());
		}
		else if (this.collection.size() > 1 && (index >= 1 && index < this.collection.size()-1))	//removing node in between
		{			
			this.get(index-1).setNext(this.get(index+1));
		}
		this.collection.remove(index);
	}
	
	@requires({"element!=null",
		"(index >= 0) && (index < $this.collection.size())"
	})
	@ensures({"$this.collection.size() == $old($this.collection.size())"})
	public <T> void set(int index, T element)
	{
		this.collection.get(index).setData(element);
	}
	
	@requires ({ "true" })
	@ensures({"$result>=0"})
	public int size()
	{
		return this.collection.size();
	}
}