package Cipher;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

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

	public static void makeKey(String name, String first, String second, String third, String fourth, String fifth, String sixth)
	{
		tempOrder = new ArrayList<String>();
		for(String s:order)
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
		}catch(Exception e)
		{
			e.printStackTrace();
		}

		ArrayList<String> L1 = convertString(first);
		ArrayList<String> L2 = convertString(second);
		ArrayList<String> L3 = convertString(third);
		ArrayList<String> L4 = convertString(fourth);
		ArrayList<String> L5 = convertString(fifth);
		ArrayList<String> L6 = convertString(sixth);

		ArrayList[] keywords = {L1, L2, L3, L4, L5, L6};

		for(ArrayList<String> l:keywords)
			for(String s:l)
				for(int i = 0; i<keywords.length; i++)
				{
					while(keywords[i].contains(s))
						keywords[i].remove(s);
					tempOrder.remove(s);
				}
		
		String[][] outkey = new String[11][10];
		
		for(int i = 0; i<keywords.length;i+=2)
			for(int j = 0; j<keywords[i].size(); i++)
				outkey[i][j] = keywords[i].get(j);
		
		int c = 0;
		for(int i = 0; i<11; i++)
		{
			for(int j = i; j<outkey[i].length; j++)
				if(outkey[i][j] == null)
				{
					outkey[i][j] = tempOrder.get(c);
					c++
				}
			
			for()
		}


	}

	private static ArrayList<String> convertString(String in)
	{
		ArrayList<String> ret = new ArrayList<String>();
		for(int i = 0; i<in.length(); i++)
		{
			if(!ret.contains(in.substring(i, i+1)))
				ret.add(in.substring(i, i+1));
		}
		return ret;
	}

	// ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
	// "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "Å", "Ä",
	// "Ö", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
	// "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "å",
	// "ä", "ö", "(", ")", "{", "}", "[", "]", "<", ">", "1", "2", "3", "4",
	// "5", "6", "7", "8", "9", "0", "+", "-", "=", "|", "\", ":", ";", """,
	// "'", ".", ",", "/", "?", "`", "~", "!", "@", "#", "$", "%", "^", "&",
	// "*", "_", "é", "á", "í", "ô", "î", "ï", "ç", "Ç", "space", "enter",
	// "tab"]

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

	}
}
