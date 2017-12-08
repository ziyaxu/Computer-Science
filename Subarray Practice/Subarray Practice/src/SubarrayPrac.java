
public class SubarrayPrac {
	
	public SubarrayPrac() {
	}
	
	public int[] arrayOne(int[] list) {
		
		int last = list[0];
		
		int value;
		for (int i = 1; i < list.length; i++) {
			value = list[i];
			list[i - 1] = value;
		}
		
		list[list.length - 1] = last;
		
		return list;
	}
	
	public int[] arrayTwo(int[] list, int numFilled, int target) {
		
		for (int i = 0; i < numFilled; i++) {
			if (list[i] == target) {
				System.out.println(target + " already in position " + i + ".");
				i = numFilled;
			} else if (list[i] > target) {
				int index = i - 1;
				list[index] = target;
				System.out.println(target + " inserted into position " + index);
				for (int j = numFilled - 1; j > i; j--) {
					list[j] = list [j -1];
				}
				i = numFilled;
			}
		}
		
		return list;
	}
	
	public int[] arrayThree(int[] list) {
		
		int backIndex;
		int frontValue;
		int backValue;
		for (int i = 0; i < list.length / 2; i++) {
			backIndex = list.length - 1 - i;
			
			frontValue = list[i];
			backValue = list[backIndex];
			list[i] = backValue;
			list[backIndex] = frontValue;
		}
		
		return list;
	}
	
	public int[] compactArray(int[] list, int numFilled, int target) {
		
		for (int i = 0; i < numFilled; i++) {
			if (list[i] == target) {
				for (int j = i + 1; j <= numFilled; j++) {
					list[i] = list[j];
				}
			}
		}
		
		return list;
	}
	
	public boolean arrayFiveSorted(int[] G, int[] H) {
		boolean equal = false;
		int indexG = 0;
		int indexH = 0;
		
		while (indexG < G.length - 1 && indexH < H.length - 1) {
			
			if (G[indexG] == H[indexH]) {
				return true;
			} else if (G[indexG] < H[indexH]) {
				indexG++;
			} else {
				indexH++;
			}
			
		}
		
		return equal;
	}
	
	//You would have to compare every single value 
	//in G with every single value in H 
	//(begin second loop at 0 instead of index of G
	public boolean arrayFiveUnsorted(int[] G, int[] H) {
		boolean valid = false;
		int K;
		
		for (int i = 0; i < G.length; i++) {
			K = G[i];
			for (int j = 0; j < H.length; j++) {
				if (K == H[j])
					return true;
			}
		}
		
		return valid;
	}
	
	public void printArray(int[] list) {
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}
	}
	
	public static void main (String args[]) {
		SubarrayPrac empty = new SubarrayPrac();
		
		int[] list = {2, 3, 4, 5, 6};
		int[] modified = empty.arrayThree(list);
		empty.printArray(modified);
	}

}
