package Cipher;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Key
{
	private static String[] order = { "A", "B", "C", "D", "E", "F", "G", "H",
			"I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
			"V", "W", "X", "Y", "Z", "Å", "Ä", "Ö", "a", "b", "c", "d", "e",
			"f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
			"s", "t", "u", "v", "w", "x", "y", "z", "å", "ä", "ö", "(", ")",
			"{", "}", "[", "]", "<", ">", "1", "2", "3", "4", "5", "6", "7",
			"8", "9", "0", "+", "-", "=", "|", "\\", ":", ";", "\"", "'", ".",
			",", "/", "?", "`", "~", "!", "@", "#", "$", "%", "^", "&", "*",
			"_", "é", "á", "í", "ô", "î", "ï", "ç", "Ç", "space", "enter",
			"tab" };
	private static ArrayList<String> tempOrder;

	public static void makeKey(String name, String first, String second,
			String third, String fourth, String fifth, String sixth)
	{
		tempOrder = new ArrayList<String>();
		for (String s : order)
			tempOrder.add(s);

		PrintWriter writer;
		try
		{
			writer = new PrintWriter(name, "UTF-8");
			writer.println("The first line");
			writer.println("The second line");
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		ArrayList<String> L1 = convertString(first);
		ArrayList<String> L2 = convertString(second);
		ArrayList<String> L3 = convertString(third);
		ArrayList<String> L4 = convertString(fourth);
		ArrayList<String> L5 = convertString(fifth);
		ArrayList<String> L6 = convertString(sixth);

		ArrayList[] keywords = { L1, L2, L3, L4, L5, L6 };

		for (int j = 0; j < keywords.length; j++)
			for (int k = 0; k < keywords[j].size(); j++)
				for (int i = 0; i < keywords.length; i++)
				{
					while (keywords[i].contains(keywords[j].get(k)))
						keywords[i].remove(keywords[j].get(k));
					tempOrder.remove(keywords[j].get(k));
				}

		String[][] outkey = new String[11][10];

		for (int i = 0; i < keywords.length; i += 2)
			for (int j = 0; j < keywords[i].size(); i++)
				outkey[i][j] = (String) keywords[i].get(j);

		int c = 0;
		for (int i = 0; i < 11; i++)
		{
			if (i < outkey.length)
			{
				for (int j = i; j < outkey[i].length - i; j++)
					if (outkey[i][j] == null)
					{
						outkey[i][j] = tempOrder.get(c);
						c++;
					}

				for (int k = i + 1; k < outkey.length - i; k++)
					if (outkey[k][outkey[k].length - i - 1] == null)
					{
						outkey[k][outkey[k].length - i - 1] = tempOrder.get(c);
						c++;
					}

				for (int l = outkey[1].length - i - 1; l >= i; l--)
					if (outkey[outkey.length - 1 - i][l] == null)
					{
						outkey[outkey.length - 1 - i][l] = tempOrder.get(c);
						c++;
					}

				for (int m = outkey.length - i - 1; m >= i + 1; m--)
					if (outkey[m][outkey.length - 1 - i] == null)
					{
						outkey[m][outkey.length - 1 - i] = tempOrder.get(c);
						c++;
					}
			}
		}

	}

	private static ArrayList<String> convertString(String in)
	{
		ArrayList<String> ret = new ArrayList<String>();
		for (int i = 0; i < in.length(); i++)
		{
			if (!ret.contains(in.substring(i, i + 1)))
				ret.add(in.substring(i, i + 1));
		}
		return ret;
	}

	/*
	 * ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
	 * "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "Å", "Ä",
	 * "Ö", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
	 * "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "å",
	 * "ä", "ö", "(", ")", "{", "}", "[", "]", "<", ">", "1", "2", "3", "4",
	 * "5", "6", "7", "8", "9", "0", "+", "-", "=", "|", "\", ":", ";", """,
	 * "'", ".", ",", "/", "?", "`", "~", "!", "@", "#", "$", "%", "^", "&",
	 * "*", "_", "é", "á", "í", "ô", "î", "ï", "ç", "Ç", "space", "enter",
	 * "tab"]
	 */

	public static void makeeDeKeyeeOrdeae()
	{
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖabcdefghijklmnopqrstuvwxyzåäö(){}[]<>1234567890+-=|\\:;\"'.,/?`~!@#$%^&*_éáíôîïçÇ";
		ArrayList<String> strs = new ArrayList<String>();
		for (int i = 0; i < str.length(); i++)
		{
			strs.add("\"" + str.substring(i, i + 1) + "\"");
		}
		strs.add("\"space\"");
		strs.add("\"enter\"");
		strs.add("\"tab\"");
		System.out.println(strs);
	}

	public static void main(String[] args)
	{
		Key.makeKey("Key Maker Test", "Hello", "friend,", "how", "are", "you?",
				"I've");
	}
}
