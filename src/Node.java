import java.util.*;

import be.ac.ua.ansymo.adbc.annotations.ensures;
import be.ac.ua.ansymo.adbc.annotations.invariant;
import be.ac.ua.ansymo.adbc.annotations.requires;

public class Node<T> 
{
	public T data;
	public Node next=null;
	
	@requires({"data != null"}) 
	@ensures({"true"})
	public Node (T data)
	{
		this.data = data;
	}
	
	@requires({"data != null"})
	@ensures({"true"})
	public void setData(T data)
	{
		this.data = data;
	}
	
	@requires({"true"})
	@ensures({"true"})
	public T getData()
	{
		return this.data;
	}
	
	@requires({"next != null"})
	@ensures({"$this.next.equals(next)"})
	public void setNext(Node next)
	{
		this.next = next;
	}
	
	@requires({"true"})
	@ensures({"true"})
	public Node getNext()
	{
		return this.next;
	}
	
//	public boolean equals(Node node){
//		if(this.next.equals(null))
//			return this.getData().equals(node.getData());
//		return this.getData().equals(node.getData())&&
//				this.getNext().equals(node.getNext());
//	}
}