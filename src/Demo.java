
public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String el1="Air";
		String el2="Fire";
		String el3="Water";
		String el4="Earth";
		String el5="Rogue Element";
		String stranger = "Vacuum";
		//Create element nodes;
		Node airNode = new Node(el1);
		Node fireNode = new Node(el2);
		Node waterNode = new Node(el3);
		Node earthNode = new Node(el4);
		Node strangerNode = new Node(stranger);
		//create empty bounded list with capacity of 5 elements
		BList eList = new BList(5);
		//create bounded list with one element, capacity 5
		List neList = new BList(5, new Node("firstElement"));
		//add node to tail of neList (normal addition)
		neList.add(airNode);
		//add node to the beginning of the neList
		neList.add(0, earthNode);
		//add node in the 2nd position of the neList
		neList.add(1,waterNode);
		//add another node to neList
		neList.add(fireNode);
		//verify size of neList
		System.out.println("Size of neList: "+neList.size());
		//verify that earthNode is in neList
		System.out.println("neList contains earthNode: "+neList.contains(earthNode));
		//get contents of the node at the 3rd position
		System.out.println("contents of node at 3rd position: "+neList.get(2).getData());
		//get index of the waterNode
		System.out.println("index of the waterNode: "+neList.indexOf(waterNode));
		//confirm that eList is empty
		System.out.println("eList is empty: "+eList.isEmpty());
		//remove the first node in neList
		neList.remove(0);
		//remove the last node in neList
		neList.remove(neList.size()-1);
		
		//show contents of eList
		System.out.println("Contents of eList: ");
		for(int i=0;i<eList.size();i++)
			System.out.println(eList.get(i).getData());
		System.out.println("Contents of neList: ");
		for(int i=0;i<neList.size();i++)
			System.out.println(neList.get(i).getData());
	}

}
