import java.util.Map;
import java.util.HashMap;

public class p11 {

	static Map <Integer, Integer> vals = new HashMap<Integer, Integer>();

	public static void main(String[] arg) {
		int max = Integer.parseInt(arg[0]);
		// System.out.println("distance - " + walk(max));
		int longestWalkDist = 0;
		int longestWalk = -1;
		for (int i = 1; i <= max; i++) {
			int walkDist = walk(i);
			if (walkDist > longestWalkDist) {
				longestWalkDist = walkDist;
				longestWalk = i;
			}
		}
		System.out.println(longestWalk + " " + longestWalkDist);
 	}

	public static int walk(int start) {
		int steps = 0;
		long curr = start;
		while (curr > 1) {
			// System.out.print(curr + " -> ");
			if (vals.containsKey(curr)) {
				steps += vals.get(curr);
				break;
			}
			else if (curr % 2 == 0) { curr /= 2; }
			else { curr = curr * 3 + 1; }
			steps++;
		}
		vals.put(start, steps);
		// System.out.println("1");
		return steps;
	}
}
