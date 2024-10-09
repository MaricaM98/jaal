package com.example.jaal.m1.s3.ex;

import java.util.Arrays;

public class ExSwapArray {
	public static void main(String[] args) {
		int[] data = { 9, 1, 4, 0, 5 };
		swap(data, 0, 2);
		System.out.println("The swapped array is: " + Arrays.toString(data));
		bubbleSort(data);
		System.out.println("The sorted array is: " + Arrays.toString(data));
		reverse(data);
		System.out.println("The reversed array is:" + Arrays.toString(data));
		reverseCopy(data);
		System.out.println("The reversed/copy array is:" + Arrays.toString(data));
		boolean found = findInArray(data, 10);
		if (found) {
			System.out.println("Found in array");
		} else {
			System.out.println("Not found in array");
		}
		findMax(data);
		System.out.println("The maximum value in the array is: " + findMax(data));
		findPositive(data);
		System.out.println("The positive values in the array are: " + findPositive(data));
		String str = "Hehehehehe";
		System.out.println(giveUpperCase(str));
	}

	public static void swap(int[] data, int i, int j) {
		if (data == null || data.length == 0) {
			System.out.println("Array vuoto");
		} else {
			int tmp = data[i];
			data[i] = data[j];
			data[j] = tmp;
		}
	}

	public static void bubbleSort(int[] array) {
		for (int j = 0; j < array.length-1; j++) {
			for (int i = 0; i < array.length-1; i++) {
				if (array[i] > array[i + 1]) {
					int tmp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = tmp;
				}
			}
		}
	}

	public static void reverse(int[] array) {
		int n = array.length;
		for (int i = 0; i < n / 2; i++) {
			int tmp = array[i];
			array[i] = array[n - 1 - i];
			array[n - 1 - i] = tmp;
		}
	}

	public static int[] reverseCopy(int[] array) {
		int[] copy = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			copy[i] = array[array.length - 1];
		}
		return copy;
	}

	public static boolean findInArray(int[] array, int n) {
		boolean found = true;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == n) {
				break;
			}
			if (array[i] != n) {
				found = false;
			}
		}
		return found;
	}

	public static int findMax(int[] array) {
		int max = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}

	public static int findPositive(int[] array) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > 0) {
				count += 1;
			}
		}
		return count;
	}

	public static String giveUpperCase(String str) {
		String str1 = str;
		StringBuilder strFinal = new StringBuilder();
		if (str1.length() > 3) {
				strFinal.append(str1.substring(0, str.length() - 3)
						+ str.substring(str.length() - 3, str.length()).toUpperCase());
				return strFinal.toString();
			} else {
		}
		return str.toUpperCase();
	}
}
