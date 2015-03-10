import java.util.Arrays;

public class selection {

    private int sizeCounter;
    private int[] array;

    public selection() {
	sizeCounter = 0;
    }

    public static int select(int[] A, int k, int l, int h) {
	int pivotIndex = l + (h - 1) / 2;
	int pivot = A[pivotIndex];
	int pivotHigh = h;
	int low = l;
	int high = h;
	swap(A, (l + h) / 2, high);
	high--;
	while (low < high) {
	    if (A[low] < pivot) {
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

    public void selectQuickSort(int[] A, int l, int h) {
	if (sizeCounter == 0) {
	    array = A;
	}
	if (sizeCounter >= array.length) {
	    sizeCounter = 0;
	    return;
	}
	if (h >= array.length || l < 0 ||
	    l == h) {
	    return;
	}

	int pivotIndex = (l + h) / 2;
	int pivot = array[pivotIndex];
	int pivotHigh = h;
	int low = l;
	int high = h;
	swap(array, (l + h) / 2, high);
	high--;
	
	while (low < high) {
	    if (array[low] < pivot) {
		low++;
	    } else {
		swap(array, low, high);
		high--;
	    }
	}
	
	if (array[low] >= pivot) {
	    swap(array, low, pivotHigh);
	    pivotIndex = low;
	} else {
	    swap(array, low + 1, pivotHigh);
	    pivotIndex = low + 1;
	}

	sizeCounter++;
	
	selectQuickSort(array, pivotIndex, h);
	selectQuickSort(array, l, pivotIndex);
    }

    public String toString() {
	return Arrays.toString(array);
    }

    public static void main(String[] args) {
	int[] test = {3, 34, 0, 2, 1, 6, 43, 8, 23};
	selection s = new selection();
	s.selectQuickSort(test, 0, test.length - 1);
	System.out.println(s.toString());
    }
}
