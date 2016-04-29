package sorters;

import java.util.ArrayList;
import java.util.Comparator;

import structures.SwapList;

public class HeapSorter<T> extends AbstractSorter<T> {

	private SwapList<T> heap;

	public HeapSorter(SwapList<T> list, Comparator<T> comparator) {
		super(list, comparator);
	}

	@Override
	public SwapList<T> sort() {

		for (int i = (list.size()-2) / 2; i >= 0; i--) { // heapify
			bubbleDown(i, list.size() - 1);
		}
		for (int i = list.size() - 1; i >= 1; i--) {
			list.swap(0, i);
			bubbleDown(0, i - 1);
		}
		return list;
	}

	private void bubbleDown(int start, int end) {
		while ((start * 2) + 1 <= end) {
			int child1 = (start * 2) + 1;
			int child2 = (start * 2) + 2;
			int big = child1;
			if (child2 <= end && list.compare(child2, child1, comparator) > 0) {
				big = child2;
			}
			if (list.compare(start, big, comparator) < 0) {
				list.swap(big, start);
				start = big;
			} else {
				start = end;
			}
		}

	}

}
