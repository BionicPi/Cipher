package Cipher;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Key
{
	private static String[] order = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
			"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y",
			"Z", "Å", "Ä", "Ö", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
			"l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
			"å", "ä", "ö", "(", ")", "{", "}", "[", "]", "<", ">", "1", "2", "3", "4",
			"5", "6", "7", "8", "9", "0", "+", "-", "=", "|", "\\", ":", ";", "\"", "'",
			".", ",", "/", "?", "`", "~", "!", "@", "#", "$", "%", "^", "&", "*", "_",
			"é", "á", "í", "ô", "î", "ï", "ç", "space", "enter", "tab" };

	private static ArrayList<String> tempOrder;
	private static int rows = 11;
	private static int cols = 10;

	public static void makeKey(String name, String first, String second, String third,
			String fourth, String fifth/* , String sixth */)
	{
		tempOrder = new ArrayList<String>();
		for (String s : order)
			tempOrder.add(s);

		ArrayList<String> L1 = convertString(first);
		ArrayList<String> L2 = convertString(second);
		ArrayList<String> L3 = convertString(third);
		ArrayList<String> L4 = convertString(fourth);
		ArrayList<String> L5 = convertString(fifth);
		// ArrayList<String> L6 = convertString(sixth);

		@SuppressWarnings("rawtypes")
		ArrayList[] keywords = { L1, L2, L3, L4, L5 /* , L6 */};

		for (int j = 0; j < keywords.length - 1; j++)
			for (int k = 0; k < keywords[j].size(); k++)
				for (int i = j + 1; i < keywords.length; i++)
					if (keywords[j].size() >= 1)
					{
						while (keywords[i].contains(keywords[j].get(k)))
							keywords[i].remove(keywords[j].get(k));
						tempOrder.remove(keywords[j].get(k));
						for(int l = 0; l<keywords[i].size(); l++)
							tempOrder.remove(keywords[i].get(l));
							
					}

		String[][] outkey = new String[rows][cols];

		for (int i = 0; i < keywords.length; i++)
			for (int j = 0; j < keywords[i].size(); j++)
				outkey[i * 2][j] = (String) keywords[i].get(j);

		int c = 0;
		for (int i = 0; i < rows; i++)
		{
			if (i < rows)
			{
				for (int j = i; j < cols - i; j++)
					if (outkey[i][j] == null)
					{
						outkey[i][j] = tempOrder.get(c);
						c++;
					}

				for (int k = i + 1; k < rows - 1 - i; k++)
					if (outkey[k][cols - i - 1] == null)
					{
						outkey[k][cols - i - 1] = tempOrder.get(c);
						c++;
					}

				for (int l = cols - i - 1; l >= i; l--)
					if (outkey[rows - 1 - i][l] == null)
					{
						outkey[rows - 1 - i][l] = tempOrder.get(c);
						c++;
					}

				for (int m = rows - i - 1; m >= i + 1; m--)
					if (i < cols && outkey[m][i] == null)
					{
						outkey[m][i] = tempOrder.get(c);
						c++;
					}
			}
		}

		try
		{
			writeFile(printOut(outkey), name);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private static void writeFile(String in, String name) throws IOException
	{
		PrintWriter pw = new PrintWriter(new FileWriter(name));
		//pw.print(in);
		pw.close();
	}

	private static String printOut(String[][] outkey)
	{
		String o = "";
		for (int r = 0; r < rows; r++)
		{
			for (int col = 0; col < cols; col++)
			{
				if (outkey[r][col] != null)
					if (outkey[r][col].equals(" "))
						o += "space";
					else if (outkey[r][col].equals("\n"))
						o += "line break";
					else if (outkey[r][col].equals("\t"))
						o += "tab";
					else
						o += outkey[r][col];
				o += "\t";
			}
			o += "\n";
		}
		 //System.out.println(outkey.length + "," + outkey[1].length);
		//System.out.println(o);
		return o;
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
	 * "*", "_", "é", "á", "í", "ô", "î", "ï", "ç", "space", "enter",
	 * "tab"]
	 */

	public static void makeeDeKeyeeOrdeae()
	{
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖabcdefghijklmnopqrstuvwxyzåäö(){}[]<>1234567890+-=|\\:;\"'.,/?`~!@#$%^&*_éáíôîïç";
		ArrayList<String> strs = new ArrayList<String>();
		for (int i = 0; i < str.length(); i++)
		{
			strs.add("\"" + str.substring(i, i + 1) + "\"");
		}
		strs.add("\"space\"");
		strs.add("\"enter\"");
		strs.add("\"tab\"");
		System.out.println(strs);
		System.out.println(strs.size());
	}

	public static void main(String[] args)
	{
//		Key.makeKey("Key Maker Test", "I", "hate", "dealing", "with", "output");
//		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖabcdefghijklmnopqrstuvwxyzåäö(){}[]<>1234567890+-=|\\:;\"'.,/?`~!@#$%^&*_éáíôîïçÇ";
//		System.out.println(str.length());
//		System.out.println(order.length);
//		makeeDeKeyeeOrdeae();
	}
}
