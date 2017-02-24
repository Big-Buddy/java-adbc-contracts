
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
		//create empty list
		BList eList = new BList(15);
		//add Air Node to empty list eList
		eList.add(airNode);
		//verify that eList contains air, using contains method
		System.out.println("eList contains air node: "+eList.contains(airNode));
		List neList = new List(new Node("firstElement"));
		//insert fire node before air node in eList
		eList.add(0,fireNode);
		//verify contents of ndoe at position 0 in eList using get method 
		System.out.println("node at position 0 in eList: "+(String) eList.get(0).getData());
		//add water and earth nodes to the list
		eList.add(waterNode);
		eList.add(earthNode);
//		System.out.println("earthNode vs Water :"+waterNode.equals(earthNode));
//		System.out.println("waterNode vs Water :"+waterNode.equals(waterNode));
		//get index of water node in eList using indexOf method
		System.out.println("water is at position "+ eList.indexOf(waterNode));
		//verify if list is empty
		System.out.println("is eList empty: " + eList.isEmpty());
		//create new List with one stranger node in it
		neList = new List(strangerNode);
		//add another stranger node to neList
		neList.add(waterNode);
		neList.add(earthNode);
		System.out.println(neList.size());
		//remove the second element of the neList
		neList.remove(2);
		System.out.println(neList.size());
		//get size of the modified neList
		System.out.println("Size of neList: "+neList.size());
		//replace fire node contents in eList with a rogue element
		eList.set(eList.indexOf(fireNode), el5);
		//show contents of eList
		System.out.println("Contents of eList: ");
		for(int i=0;i<eList.size();i++)
			System.out.println(eList.get(i).getData());
		System.out.println("Contents of neList: ");
		for(int i=0;i<neList.size();i++)
			System.out.println(neList.get(i).getData());
	}

}
