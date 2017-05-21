package com.anish.so.q0002;

public class ArrayCountdownTest {
	private static final int maxNum = 8;

	private static int[] updateArray(final int[] array) {
		for (int index = array.length - 1; index >= 0; index--) {
			if (array[index] > 1) {
				array[index]--;
				return array;
			}
			else if (array[index] == 1 && index != 0) {
				int nonOneIndex = index;
				for (; nonOneIndex >= 0; nonOneIndex--) {
					if (array[nonOneIndex] != 1)
						break;
				}
				if (nonOneIndex < 0)
					return array;
				array[nonOneIndex]--;
				for (
						int maxNumId = nonOneIndex + 1;
						maxNumId < array.length;
						maxNumId++)
					array[maxNumId] = maxNum;
				return array;
			}
		}

		return array;
	}

	private static boolean isArrayIndexesAllOnes(final int[] array) {
		for (final int element : array) {
			if (element != 1) {
				return false;
			}
		}
		return true;
	}

	private static void printArrayCountdown(int[] array) {
		boolean downToOne = false;

		while (!downToOne) {
			array = updateArray(array);
			printArray(array);
			if (isArrayIndexesAllOnes(array)) {
				downToOne = true;
			}
		}
	}

	private static void printArray(final int[] array) {
		for (int index = 0; index < array.length; index++) {

			if (index == 0) {
				System.out.print("{" + array[index] + ",");
			}
			else if (index > 0 && index < array.length - 1) {
				System.out.print(array[index] + ",");
			}
			else {
				System.out.println(array[index] + "}");
			}
		}
	}

	public static void main(final String[] args) {
		final int[] firstArray = { maxNum, maxNum };
		final int[] secondArray = { maxNum, maxNum, maxNum, maxNum };

		printArrayCountdown(firstArray);
		// System.out.println();
		// System.out.println();
		printArrayCountdown(secondArray);
	}
}
