package Cipher;

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
	// space enter tab
	// ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
	// "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "Å", "Ä",
	// "Ö", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
	// "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "å",
	// "ä", "ö", "(", ")", "{", "}", "[", "]", "<", ">", "1", "2", "3", "4",
	// "5", "6", "7", "8", "9", "0", "+", "-", "=", "|", "\", ":", ";", """,
	// "'", ".", ",", "/", "?", "`", "~", "!", "@", "#", "$", "%", "^", "&",
	// "*", "_", "é", "á", "í", "ô", "î", "ï", "ç", "Ç", "space", "enter",
	// "tab"]
	
	public static void makeeDeKeyee()
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
