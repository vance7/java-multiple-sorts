import java.util.Stack;

public class Sort {

	// bubble sort from small to large
	public static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int trade = array[j];
					array[j] = array[j + 1];
					array[j + 1] = trade;
				}
			}
		}
	}

	// quick sort from small to large
	public static void quickSort(int[] array) {
		quick(array, 0, array.length - 1);
	}

	public static void quick(int[] arr, int left, int right) {
		if (left >= right)
			return;
		int middle = partition(arr, left, right);
		quick(arr, left, middle - 1);
		quick(arr, middle + 1, right);
	}
	
	public static int partition(int[] arr, int left, int right) {
		// int pivot = arr[left];
		// while (left < right) {
		// while (left < right && arr[right] > pivot)
		// right--;
		// if (left < right)
		// arr[left++] = arr[right];
		// while (left < right && arr[left] < pivot)
		// left++;
		// if (left < right)
		// arr[right--] = arr[left];
		// }
		int pivot = arr[right];
		int i = left, j = right;
		while (i < j) {
			if (arr[i++] > pivot)
				swap(arr, --i, --j);
		}
		swap(arr,i,right);
		return i;
	}
	
	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	// select sort from small to large
	public static void selectSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[index])
					index = j;
			}
			int temp = array[index];
			array[index] = array[i];
			array[i] = temp;
		}
	}

	// insert sort from small to large
	public static void insertSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int curr = i;
			for (int j = i - 1; j >= 0; j--) {
				if (array[curr] < array[j]) {
					int temp = array[curr];
					array[curr] = array[j];
					array[j] = temp;
					curr--;
				}
			}

		}
	}

	// merge sort from small to large
	public static void mergeSort(int[] array) {
		mSort(array, 0, array.length - 1);
	}

	public static void mSort(int[] array, int left, int right) {
		if (left == right)
			return;
		int middle = (left + right) / 2;
		mSort(array, left, middle);
		mSort(array, middle + 1, right);
		merge(array, left, middle, right);
	}

	public static void merge(int[] array, int low, int middle, int high) {
		int i = low, j = middle + 1, k = 0;
		int[] temp = new int[high - low + 1];
		while (i <= middle && j <= high) {
			if (array[i] <= array[j])
				temp[k++] = array[i++];
			else
				temp[k++] = array[j++];
		}
		while (i <= middle)
			temp[k++] = array[i++];
		while (j <= high)
			temp[k++] = array[j++];
		for (int index = 0; index < temp.length; index++)
			array[low + index] = temp[index];
	}

	// binary select
	public static int binSearch(int[] array, int target) {
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			int middle = (low + high) / 2;
			if (target < array[middle])
				high = middle - 1;
			else if (target > array[middle])
				low = middle + 1;
			else
				return middle;
		}
		return -1;
	}

	// main
	public static void main(String[] args) {
		int[] array = {1,1,6,3,2,5,8,7,2,3,5,7,4,2,9,7,5,1,2,6};
		// bubbleSort(array);
		quickSort(array);
		// selectSort(array);
		// insertSort(array);
		// mergeSort(array);
		// System.out.println(Sort.binSearch(array, 3131));
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
	}
}
