package cz.stepanbohm.moneta.numberformater;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Service;

@Service
public class NumberFormater {

	private int input;

	public int getInput() {
		return input;
	}

	// Convert number to Array of Digits
	private int[] convertToArray(Long input) {
		String temp = Long.toString(input);
		int[] numbers = new int[temp.length()];

		for (int i = 0; i < temp.length(); i++) {
			numbers[i] = temp.charAt(i) - '0';
		}

		return numbers;
	}

	// Convert Array back to number
	private Long convertToLong(StringBuilder strNum) {
		String res = strNum.toString();
		Long result = Long.parseLong(res);
		return result;
	}

	// všechny číslice menší 3 (včetně) posune o jednu pozici doprava.
	private Long three(Long input) {
		int[] numbers = convertToArray(input);
		StringBuilder strNum = new StringBuilder();

		for (int i = numbers.length - 2; i >= 0; i--) {
			if (numbers[i] <= 3) {
				ArrayUtils.swap(numbers, i, i + 1);
			}
		}
		for (int n : numbers) {
			strNum.append(n);
		}
		Long result = convertToLong(strNum);
		return result;
	}

	// všechny číslice 8 a 9 vynásobí 2
	private Long eightNine(Long input) {
		StringBuilder strNum = new StringBuilder();
		int[] numbers = convertToArray(input);
		for (int n : numbers) {
			if (n == 8 || n == 9) {
				n = n * 2;
			}
			strNum.append(n);
		}
		Long result = convertToLong(strNum);
		return result;
	}

	// všechny číslice 7 smaže
	private Long seven(Long input) {
		StringBuilder strNum = new StringBuilder();
		int[] numbers = convertToArray(input);
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == 7) {
				numbers = ArrayUtils.remove(numbers, i);
			}
		}
		for (int n : numbers) {
			strNum.append(n);
		}
		Long result = convertToLong(strNum);
		return result;
	}

	// ve výsledném čísle spočte počet sudých číslic a tímto počtem výsledné číslo vydělí a zaokrouhlí dolů na celá čísla
	private Long even(Long input) {
		int[] numebrs = convertToArray(input);
		int numberOfEven = 0;
		for (int n : numebrs) {
			if (n % 2 == 0) {
				numberOfEven++;
			}
		}

		return (long) Math.floor(input / numberOfEven);
	}

	public Long formatNumberLong(Long input) {
		input = three(input);
		input = eightNine(input);
		input = seven(input);
		input = even(input);
		
		return input;
	}

	public FormatedNumber formatNumber(InputNumber input) {
		Long number = input.getNumber();
		number = three(number);
		number = eightNine(number);
		number = seven(number);
		number = even(number);

		return new FormatedNumber(number);
	}

}
