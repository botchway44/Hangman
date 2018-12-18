
public class testRandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			String[] numbers = new String[5];
			numbers[0] = "Ama";
			numbers[1] = "Akua";
			numbers[2] = "Abena";
			numbers[3] = "Afia";
			numbers[4] = "Adwoa";
		
			double actual = Math.random();//0 - 1
			int rand = (int) ((actual)*5-1);//0-size
			
			System.out.println(actual);
			System.out.println(actual * 4);
			System.out.println(rand);
			System.out.println(numbers[rand]);
	}

}
