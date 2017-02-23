import java.util.*;

import be.ac.ua.ansymo.adbc.annotations.ensures;
import be.ac.ua.ansymo.adbc.annotations.invariant;
import be.ac.ua.ansymo.adbc.annotations.requires;

public class Node<T> 
{
	public T data;
	public Node next=null;
	
	@requires({"data != null"}) 
	public Node (T data)
	{
		this.data = data;
	}
	
	@requires({"data != null"})
	public void setData(T data)
	{
		this.data = data;
	}
	
	public T getData()
	{
		return this.data;
	}
	
	@requires({"next != null"})
	@ensures({"$this.next != null"})
	public void setNext(Node next)
	{
		this.next = next;
	}
	
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