
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
 
public class Judge {
 
	public int findJudge(int n, int[][] trust) {
 
		if (n == 1)
			return n;
 
		Set<Integer> trustedSet = new HashSet<>();     //the set of those that trust others 
		Map<Integer, Set<Integer>> jMap = new HashMap<>();  //Map of trusted people, Key and Value gives person trusted by others
 
 		//for each set, add to trust the person at index 0
		for (int[] a : trust) {
			trustedSet.add(a[0]);
 
			if (jMap.containsKey(a[1])) {
				jMap.get(a[1]).add(a[0]);
			} else {
				Set<Integer> set = new HashSet<Integer>();
				set.add(a[0]);
				jMap.put(a[1], set);
			}
		}
 
		for (int key : jMap.keySet()) {
			if (jMap.get(key).size() == n - 1 && !trustedSet.contains(key))
				return key;
		}
 
		return -1;
	}
 
	public static void main(String[] args) {


		//This was my attempt to make it user friendly, but I just couldn't get it to work
		//Scanner input = new Scanner(System.in);

		// System.out.println("How many people are in the town?");
		// int n = input.nextInt();


		// int [][]trust= new int [n][];

		// for (int i = 1; i < n+1; i++) {
  // 			System.out.println("How many people does " + i + " trust?");
  // 				int x = input.nextInt();
  // 				int trustArray[] = new int[x];
  // 				//int total = 0;
  // 				//total = total = (i*x);

  // 				for (int j = 0; j < x; j++) {
  // 					System.out.println("Which person do they trust. Please enter a number: ");
  					
  // 					int tr = input.nextInt();
  // 					trustArray[j] = tr;
  // 					//int [][]trust= new int [n][total];
  // 					trust[i][j] = tr;
  						
  // 					}

		

		int n=6;
		int [][]trust={{1,3},{1,4},{2,3},{2,4},{5,6},{3,6}, {3,4}, {5,4}, {6,4}};

  	

		Judge findTJ=new Judge();	
		System.out.println(findTJ.findJudge(n, trust));

	}
}
 