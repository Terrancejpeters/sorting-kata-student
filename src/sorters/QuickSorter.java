package sorters;

import java.util.Comparator;

import structures.SwapList;

public class QuickSorter<T> extends AbstractSorter<T> {

	public QuickSorter(SwapList<T> list, Comparator<T> comparator) {
		super(list, comparator);
	}

	@Override
	public SwapList<T> sort() {

		recQuickSort(0, list.size() - 1);
		//quickSort(0,list.size()-1);
		// TODO

		/*
		 * Note: When choosing a pivot, choose the element in the middle of the
		 * sub-array. That is,
		 * 
		 * pivotIndex = (firstIndex + lastIndex) / 2;
		 */

		return list;
	}

	protected void recQuickSort(int low, int high) {
		if (low < high) {
			int p = partition(low, high); // p is split point
			recQuickSort(low, p - 1);
			recQuickSort(p + 1, high);
		}
	}
	
	// assume the array being considered for partition
		// is in the range [low, high]
		public int partition(int low, int high) {
			list.swap((high+low)/2, high);
			int pivot = high; // the mid element as pivot
			int storeIndex = low;
			int j;
			for (j = low; j <= high - 1; j++) {
				//a[j].compareTo(pivot)
				if (list.compare(j, pivot, comparator) < 0) {
					list.swap(j, storeIndex);
					storeIndex++;
				}
			}
			list.swap(storeIndex, high);
			return storeIndex;
		}
		


	
}