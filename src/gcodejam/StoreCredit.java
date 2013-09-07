package gcodejam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class StoreCredit {
	
	public static String solve(int credit, int[] items){
		int[] sorted = items.clone();
		Arrays.sort(sorted);
		
//		int sum = 0, big = max, small = min;
		
		return null;
	}
	
	public static void main(String[] args) throws IOException{
		
		Scanner in = new Scanner(new BufferedReader(new FileReader("in/A-small-practice.in")));
		int cases = in.nextInt();
		
		for(int i = 0; i < cases; i++){
			int credit = in.nextInt();
			int n = in.nextInt();
			int [] items = new int[n];
			for(int j = 0; j < n; j++){
				items[j] = in.nextInt();
			}
			
			System.out.println(solve(credit, items));
		}
		
		in.close();
		
	}

}
