package sorters;

import java.util.Comparator;

import structures.SwapList;

public class InsertionSorter<T> extends AbstractSorter<T> {

	public InsertionSorter(SwapList<T> list, Comparator<T> comparator) {
		super(list, comparator);
	}

	@Override
	public SwapList<T> sort() {
		for (int i = 0; i < list.size(); i++){
			if (i != 0){
				int j = i;
				while (j >0 && list.compare(j, j-1, comparator) < 0){
					list.swap(j, j-1);
					j--;
				}
			}
		}
		return list;
	}
}
