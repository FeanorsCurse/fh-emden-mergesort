import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;

/**
 * @author dsuepke
 */
public class MergeSortTest extends Assert {

	private static final int[] SORTED = {1, 2, 2, 3, 3, 4, 5, 6, 7};


	public static void main(String[] args) {
		new JUnitCore().run(MergeSortTest.class);
	}


	@Test
	public void sortScriptTest() {
		int[] toSort = {5, 3, 4, 7, 3, 2};
		int[] sorted = {2, 3, 3, 4, 5, 7};

		assertArrayEquals(sorted, MergeSort.sort(toSort));
	}


	@Test
	public void sortHomeworkTest() {
		int[] toSort = {10, 13, 6, 8, 3, 15, 9, 12};
		int[] sorted = {3, 6, 8, 9, 10, 12, 13, 15};

		assertArrayEquals(sorted, MergeSort.sort(toSort));
	}


	@Test
	public void sortSortedTest() {
		int[] toSort = {1, 2, 2, 3, 3, 4, 5, 6, 7};

		assertArrayEquals(SORTED, MergeSort.sort(toSort));
	}


	@Test
	public void sortInverseSortedTest() {
		int[] toSort = {7, 6, 5, 4, 3, 3, 2, 2, 1};

		assertArrayEquals(SORTED, MergeSort.sort(toSort));
	}


	@Test
	public void sortRandomTest() {
		int[] toSort = {3, 1, 7, 2, 2, 5, 6, 3, 4};

		assertArrayEquals(SORTED, MergeSort.sort(toSort));
	}


}
