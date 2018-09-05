package 携程;

import java.util.HashMap;
import java.util.Scanner;

class XNode{
	
	XNode pre;
	XNode next;
	int key;
	
	public XNode(int key) {
		this.key = key;
	}
	
}

public class Three {
	
	public static int size;
	public static int count;
	
	public static HashMap<Integer, Integer> map=new HashMap<>();
	public static HashMap<Integer, XNode> nodeMap=new HashMap<>();
	
	public static XNode head;
	public static XNode tail;

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		size=in.nextInt();
		count=0;
		
		in.nextLine();
		while(in.hasNext()){
			String[] str=in.nextLine().split(" ");
			if(str[0].equals("p")){
				put(Integer.parseInt(str[1]),Integer.parseInt(str[2]));
			}else if(str[0].equals("g")){
				System.out.println(get(Integer.parseInt(str[1])));
			}
		}
		
	}
	
	public static int get(int key){
		
		XNode node=nodeMap.get(key);
		if(node!=null){
			if(node!=head){
				node.pre.next=node.next;
				if(node.next!=null){
					node.next.pre=node.pre;
				}
				
				head.pre=node;
				node.next=head;
				head=node;
			}
		}
		
		return map.getOrDefault(key, -1);
		
	}
	
	public static void put(int key,int value){
		if(map.get(key) != null){
			map.put(key, value);
		}
		else{
			if(count<size){
				map.put(key, value);
				XNode node=new XNode(key);
				nodeMap.put(key, node);
				if(count==0){
					head=node;
					tail=node;
				}
				else{
					tail.next=node;
					node.pre=tail;
					tail=node;
				}
				count++;
			}
			else{
				map.put(key, value);
				XNode node=new XNode(key);
				nodeMap.put(key, node);
				
				node.next=head;
				head.pre=node;
				head=node;
				
				map.remove(tail.key);
				nodeMap.remove(tail.key);
				tail=tail.pre;
				tail.next=null;
				
			}
		}
	}
}