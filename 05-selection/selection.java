import java.util.Arrays;

public class selection {

    public static int select(int[] A, int k, int l, int h) {
	int pivotIndex = l + (h - 1) / 2;
	int pivot = A[pivotIndex];
	int pivotHigh = h;
	int low = l;
	int high = h;
	swap(A, (l + h) / 2, high);
	high--;
	while (low < high) {
	    if (A[low] <= pivot) {
		low++;
	    } else {
		swap(A, low, high);
		high--;
	    }
	}
	if (A[low] > pivot) {
	    swap(A, low, pivotHigh);
	    pivotIndex = low;
	} else {
	    swap(A, low + 1, pivotHigh);
	    pivotIndex = low + 1;
	}
	if (pivotIndex == k) {
	    return A[k];
	} else if (pivotIndex > k) {
	    return select(A, k, l, pivotIndex - 1);
	} else {
	    return select(A, k, pivotIndex + 1, h);
	}
    }

    public static void swap(int[] A, int aIndex, int bIndex) {
	int temp = A[aIndex];
	A[aIndex] = A[bIndex];
	A[bIndex] = temp;
    }

    public static void main(String[] args) {
	int[] test = {3, 34, 0, 2, 1, 6, 43, 8, 23};
	System.out.println(select(test, 3, 0, test.length - 1));
    }
}
