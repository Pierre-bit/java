package org.eclipse.TP6;

import java.util.Comparator;

public class SortByYear implements Comparator<Machine> {

	@Override
	public int compare(Machine o1, Machine o2) {
		// TODO Auto-generated method stub
		return o1.getYear() - o2.getYear();
	}

}
