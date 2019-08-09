import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {
	
	 List<Integer> cardList=new ArrayList<>();
//	 static List<Integer> perList1=new ArrayList<>();
//	 static List<Integer> perList2=new ArrayList<>();
//	 static List<Integer> perList3=new ArrayList<>();
	
	
	static List<Integer> perList1=null;
	static List<Integer> perList2=null;
	static List<Integer> perList3=null;
	
	static{
		perList1=new ArrayList<>();
		perList2=new ArrayList<>();
		perList3=new ArrayList<>();
	}
	

	public static void main(String[] args) {
		Test t=new Test();
		t.initCard();
		
		t.sendCard();
		
		t.getPerCard(perList1, 1);
		t.getPerCard(perList2, 2);
		t.getPerCard(perList3, 3);
		
		t.getZhadan(perList1, 1);
		t.getZhadan(perList2, 2);
		t.getZhadan(perList3, 3);
		
	}
	private void initCard()
	{
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j <=13; j++) {
				cardList.add(j);
			}
		}
		cardList.add(100);
		cardList.add(100);
		for (Integer i:cardList) {
			System.out.print(i+" ");
		}
	}
	private void sendCard()
	{
		System.out.println();
		Random random=new Random();
		for (int i = 0; i < 17; i++) {
			int index=random.nextInt(cardList.size());
			perList1.add(cardList.get(index));
			cardList.remove(index);
			
			index=random.nextInt(cardList.size());
			perList2.add(cardList.get(index));
			cardList.remove(index);
			
			index=random.nextInt(cardList.size());
			perList3.add(cardList.get(index));
			cardList.remove(index);
			
		}
	}
	
	private void getPerCard(List<Integer> list,int index)
	{
		System.out.println("第"+index+"个人的牌：");
		for (Integer i:list) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	private void getZhadan(List<Integer> list,int index)
	{
		System.out.println();
		for (int i = 0; i < list.size(); i++) {
			int count=0;
			for (int j = 0; j < list.size(); j++) {
				if(list.get(i)==list.get(j))
				{
					count++;
				}
			}
			if(count==4&&list.get(i)!=100)
			{
				System.out.println("第"+index+"个人有炸弹:"+list.get(i));
				list.add(list.get(i));
			}
			if(count==2&&list.get(i)==100)
			{
				System.out.println("第"+index+"个人有王炸");
				list.add(list.get(i));
			}
			
		}
	}

}
