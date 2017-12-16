import java.util.Arrays;

/**
 * @author dsuepke
 */
public class MergeSort {

	private static int comparisons;


	public static int[] sort(int[] toSort) {
		System.out.println("\n## Sorting with Merge-Sort: " + Arrays.toString(toSort));
		comparisons = 0;
		int r = toSort.length - 1;
		int p = 0;

		mergeSort(toSort, p, r);

		System.out.format("O(n): %d*log(%d)=%d, actual comparisons: %d%n", toSort.length, toSort.length, (int)Math.ceil(toSort.length * log2(toSort.length)), comparisons);
		comparisons = 0;
		return toSort;
	}


	private static void mergeSort(int[] toSort, int p, int r) {
		System.out.println("mergeSort(A=" + Arrays.toString(toSort) + ", p=" + p + ", r=" + r + "), q=" + ((p + r) / 2));
		if (p < r) {
			int q = (p + r) / 2;
			// Sort left side
			mergeSort(toSort, p, q);
			// Sort right side
			mergeSort(toSort, q + 1, r);
			System.out.print("\n");
			merge(toSort, p, q, r);
		}
	}


	/**
	 * Merges two sorted sub-array
	 *
	 * @param toSort Array to sort (complete array)
	 * @param p      Left most element to work with (index)
	 * @param q      End of left array, start of right array (index)
	 * @param r      Right most element to work with(index)
	 */
	private static void merge(int[] toSort, int p, int q, int r) {
		System.out.println("merge    (A=" + Arrays.toString(toSort) + ", p=" + p + ", q=" + q + ", r=" + r + ")");
		System.out.println("         Merging "
				+ Arrays.toString(Arrays.copyOfRange(toSort, p, q + 1)) + ", "
				+ Arrays.toString(Arrays.copyOfRange(toSort, q + 1, r + 1)));
		int i = p;
		int j = q + 1;
		int k = 0;

		int[] sorted = new int[toSort.length];

		while (i <= q && j <= r) {
			System.out.format("         A[%d] ≤ A[%d]: %2d  ≤ %2d: %5s", i, j, toSort[i], toSort[j], (toSort[i] <= toSort[j]));
			comparisons++;
			if (toSort[i] <= toSort[j]) {
				System.out.format("   →   B[%d] = B[%d]: %2d := %2d%n", k, i, sorted[k], toSort[i]);
				sorted[k] = toSort[i];
				i++;
			}
			else {
				System.out.format("   →   B[%d] = A[%d]: %2d := %2d%n", k, j, sorted[k], toSort[j]);
				sorted[k] = toSort[j];
				j++;
			}
			k++;
		}


		while (i <= q || j <= r) {
			System.out.format("         i ≤ q: %d ≤ %d: %5s", i, q, (i <= q));
			comparisons++;
			if (i <= q) {
				System.out.format("   →   B[%d] := A[%d]: %2d := %2d%n", k, i, sorted[k], toSort[i]);
				sorted[k] = toSort[i];
				i++;
			}
			else {
				System.out.format("   →   B[%d] := A[%d]: %2d := %2d%n", k, j, sorted[k], toSort[j]);
				sorted[k] = toSort[j];
				j++;
			}
			k++;
		}

//		 Alternative implementation of above loop
//		while (i <= q) {
//			comparisons++;
//			sorted[k] = toSort[i];
//			i++;
//			k++;
//		}


		for (int a = 0; a < k; a++) {
			toSort[p + a] = sorted[a];
		}

		System.out.println("         -> " + Arrays.toString(Arrays.copyOfRange(toSort, p, q + 2)) + " (overall: " + Arrays.toString(toSort) + ")%n");
	}


	private static double log2(int x) {
		return Math.log10(x) / Math.log10(2);
	}
}
