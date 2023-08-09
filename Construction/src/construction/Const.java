package construction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Const {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the total number of floors in the building: ");
		int n = scanner.nextInt();
		
		List<Integer> sizes = new ArrayList<>();
		
		for(int i = 0; i<n; i++) {
			System.out.print("Enter the floor size giver on day "+ (i+1) + "  : ");
			sizes.add(scanner.nextInt());
		}
		
		
		List<Integer> constructionOrder = new ArrayList<>();
		Stack<Integer> remainingSizes = new Stack<>();
		
		for(int i = 0; i < n; i++) {
			int size = sizes.get(i);
			
			while(!remainingSizes.isEmpty() && size > remainingSizes.peek()) {
				constructionOrder.add(remainingSizes.pop());
			}
			
			remainingSizes.push(size);
			
			System.out.print("Day: " + (i+1));
			for(int j = constructionOrder.size() - 1; j >= 0; j--) {
				System.out.print(" " + constructionOrder.get(j));
			}
			
			System.out.println();
		}
		
		scanner.close();
	}

}
