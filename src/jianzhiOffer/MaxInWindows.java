package jianzhiOffer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class MaxInWindows {
	public ArrayList<Integer> maxInWindows(int[] num, int size) {
		ArrayList<Integer> list = new ArrayList<>();
        if(num==null || size<=0) return list;
        for (int i = 0; i < num.length - size + 1; i++) {
            int max = num[i];
            for (int j = 0; j < size; j++) {
                if (i + j < num.length && num[i + j] > max) {
                    max = num[i + j];
                }
            }
            list.add(max);
        }
        return list;
	}

	public ArrayList<Integer> maxInWindows1(int[] num, int size) {
		ArrayList<Integer> list = new ArrayList<>();
		Deque<Integer> deque= new LinkedList<>();
		if(num==null || num.length<size || size<=0)return list;
		for(int i=0;i<num.length;i++) {
			while(!deque.isEmpty() && num[i]>=num[deque.getLast()]) {
				deque.removeLast();
			}
			while(!deque.isEmpty() && i-deque.getFirst()>size-1) {
				deque.removeFirst();
			}
			deque.addLast(i);
			if(i+1>=size)
				list.add(num[deque.getFirst()]);
		}
		return list;
	}
	public static void main(String[] args) {
		int[] num = { 2, 3, 4, 2, 6, 2, 5, 1 };
		int size = 3;
		MaxInWindows m = new MaxInWindows();
		System.out.println(m.maxInWindows(num, size).toString());
		System.out.println(m.maxInWindows1(num, size).toString());
	}
}
