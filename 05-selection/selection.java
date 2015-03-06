import java.util.Arrays;

public class selection {

    public static int[] select(int[] A, int k, int l, int h) {
	int pivotIndex = l + (h - 1) / 2;
	int pivot = A[pivotIndex];
	int low = l;
	int high = h;
	swap(A, A[l+ (h - 1) / 2], A[high]);
	high--;
	while (low < high) {
	    if (A[low] < pivot) {
		low++;
	    } else {
		swap(A, A[low], A[high]);
		high--;
	    }
	}
	if (A[low] > pivot) {
	    swap(A, A[low], A[]);
	} else {
	    swap(A, A[low + 1], A[pivotIndex]);
	}
	return A;
    }

    public static void swap(int[] A, int aIndex, int bIndex) {
	int temp = A[aIndex];
	A[aIndex] = A[bIndex];
	A[bIndex] = temp;
    }

    public static void main(String[] args) {
	int[] test = {3, 34, 6, 2, 1, 6, 43, 8, 23};
	System.out.println(Arrays.toString(selection.select(test, 0, 0, test.length - 1)));
    }
}
