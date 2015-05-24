/**
 @author Max Meinhold
 Pd. 4B
 Apr 10, 2015
 */
package Cipher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Cipher
{
	private static Cipher basic;
	private String[][] key;
	private static int rows = 10;
	private static int cols = 10;

	public Cipher()
	{
		key = new String[rows][cols];
		fileInput("Capitalization Key");
	}

	public Cipher(String keyName, int numRows, int numCols)
	{
		fileInput(keyName);
		rows = numRows;
		cols = numCols;
	}

	private void fileInput(String fileName)
	{
		File inputFile = new File(fileName);
		Scanner scf;
		try
		{
			scf = new Scanner(inputFile);
			for (int row = 0; row < rows; row++)
			{
				for (int col = 0; col < cols; col++)
				{
					key[row][col] = scf.next();
					if(key[row][col].equals("space"))
						key[row][col] = " ";
					//System.out.println(key[row][col]);
				}
			}
			scf.close();
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	// Encoding
	private String encode(String in)
	{
		in = swapPairsEncode(in);
		in = toFives(in);
		return in;
	}

	private String swapPairsEncode(String in)
	{
		String encoded = "";
		in = toPairs(in);
		//in = this.removeSpaces(in);
		for (int i = 0; i < in.length() - 1; i++)
		{
			String sub = in.substring(i, i + 2);
			String sub1 = sub.substring(0, 1);
			String sub2 = sub.substring(1);
			int r1 = -1;
			int r2 = -1;
			int c1 = -1;
			int c2 = -1;

			for (int r = 0; r < rows; r++)
			{
				for (int c = 0; c < cols; c++)
				{
					if (key[r][c].equals(sub1))
					{
						r1 = r;
						c1 = c;
					}
					if (key[r][c].equals(sub2))
					{
						r2 = r;
						c2 = c;
					}
				}
			}
			if (r1 == r2)
			{
				sub1 = key[r1][(c1 + 1) % cols];
				sub2 = key[r2][(c2 + 1) % cols];
			} else if (c1 == c2)
			{
				sub1 = key[(r1 + 1) % rows][c1];
				sub2 = key[(r2 + 1) % rows][c2];
			} else if ((r1 > r2 && c1 > c2) || (r1 < r2 && c1 < c2))
			{
				sub1 = key[r1][c2];
				sub2 = key[r2][c1];
			} else if ((r1 > r2 && c1 < c2) || (r1 < r2 && c1 > c2))
			{
				sub1 = key[r2][c1];
				sub2 = key[r1][c2];
			}

			encoded += sub1 + sub2;
			i++;
			//System.out.println(encoded);
		}
		return encoded;
	}

	private String toPairs(String in)
	{
		String o = "";
		// in = in.toUpperCase(); //TODO Make it keep capitalization//TODO Make
		// it keep capitalization
		////in = removeSpaces(in);
		// in = splitDuplicates(in);
		for (int i = 0; i < in.length() - 1; i++)
		{
			if (in.substring(i, i + 1).equals(in.substring(i + 1, i + 2)))
			{
				o += in.substring(i, i + 1) + "X";
			} else
			{
				o += in.substring(i, i + 2);
				i++;
			}
		}
		if (in.length() % 2 != 0)
		{
			o += in.substring(in.length() - 1) + "X";
		}
		//System.out.println(o);
		return o;
	}

	private String toFives(String in)
	{
//		String o = "";
//		// in = in.toUpperCase(); //TODO Make it keep capitalization
//		//in = removeSpaces(in);
//		for (int i = 0; i < in.length(); i++)
//		{
//			if (in.length() - i >= 5)
//			{
//				o += in.substring(i, i + 5) + " ";
//				i += 4;
//			} else
//			{
//				o += in.substring(i);
//				i += in.length();
//			}
//		}
//		return o;
		return in;
	}

	// Decoding
	private String decode(String in)
	{
		in = fromPairs(in);
		return in;
	}

	private String swapPairsDecode(String in)
	{
		String decoded = "";
		//System.out.println(in);
		//in = this.removeSpaces(in);
		for (int i = 0; i < in.length() - 1; i++)
		{
			String sub = in.substring(i, i + 2);
			String sub1 = sub.substring(0, 1);
			String sub2 = sub.substring(1);
			int r1 = -1;
			int r2 = -1;
			int c1 = -1;
			int c2 = -1;

			for (int r = 0; r < key.length; r++)
			{
				for (int c = 0; c < key[r].length; c++)
				{
					if (key[r][c].equals(sub1))
					{
						r1 = r;
						c1 = c;
					}
					if (key[r][c].equals(sub2))
					{
						r2 = r;
						c2 = c;
					}
				}
			}
			if (r1 == r2)
			{
				sub1 = key[r1][(c1 - 1 + cols) % cols];
				sub2 = key[r2][(c2 - 1 + cols) % cols];
			} else if (c1 == c2)
			{
				sub1 = key[(r1 - 1 + rows) % rows][c1];
				sub2 = key[(r2 - 1 + rows) % rows][c2];
			} else if ((r1 > r2 && c1 > c2) || (r1 < r2 && c1 < c2))
			{
				sub2 = key[r1][c2];
				sub1 = key[r2][c1];
			} else if ((r1 > r2 && c1 < c2) || (r1 < r2 && c1 > c2))
			{
				sub2 = key[r2][c1];
				sub1 = key[r1][c2];
			}

			decoded += sub1 + sub2;
			//System.out.println(decoded);
			i++;
			//i++;
		}
		return decoded;
	}

	private String fromPairs(String in)
	{
		in = swapPairsDecode(in);
		//in = removeSpaces(in);
		in = undosplitDuplicates(in);
		// in = in.toLowerCase(); //TODO make it keep capitalization.
		if (in.endsWith("X"))
		{
			in = in.substring(0, in.length() - 1);
		}
		return in;// .toUpperCase(); //TODO Make it keep capitalization
	}

	// Utility
	private String removeSpaces(String in)
	{
		return in;//.replace(new String(" "), new String());
	}

	private String undosplitDuplicates(String in)
	{
		while (in.indexOf("X") != -1)
		{
			int i = in.lastIndexOf("X");
			if (i == in.length() - 1)
				in = in.substring(0, i) + "x";
			else if (i >= 1
					&& i < in.length()
					&& in.substring(i - 1, i)
					.equals(in.substring(i + 1, i + 2)))
			{
				in = in.substring(0, i) + in.substring(i + 1);
			} else
				in = in.substring(0, i) + "x" + in.substring(i + 1);
		}
		return in;
	}

	public String toString()
	{
		String o = "";
		for (int r = 0; r < rows; r++)
		{
			for (int c = 0; c < cols; c++)
			{
				o += key[r][c];
				o += "\t";
			}
			o += "\n";
		}
		return o;
	}

	// UI
	// public static void run()
	// {
	// //System.out.println("Would you like to encode or decode?");
	// String choice = sc.nextLine();
	// if(choice.equals("decode"))
	// uiDecode();
	// else
	// uiEncode();
	// //System.out.println("Would you like to continue?");
	// choice = sc.nextLine();
	// if(choice.equals("yes"))
	// run();
	// }

	public static String uiEncode(String original)
	{
		basic = new Cipher();
		// //System.out.println("Input text to be encoded." /*No punctuation."*/);
		// String original = sc.nextLine();
		return basic.encode(original); // .toLowerCase(); //TODO make it keep
		// capitalization.
		// //System.out.println("Original: " + original + "\n Encoded: " +
		// encoded);
	}

	public static String uiDecode(String encoded)
	{
		basic = new Cipher();
		// //System.out.println("Input text to be decoded");
		// String encoded = sc.nextLine();
		return basic.decode(encoded); // .toLowerCase(); //TODO make it keep
		// capitalization.
		// //System.out.println("Encoded: " + encoded + "\n Decoded: " + decoded);
	}

	// public static void main(String [] args)
	// {
	// //System.out.println(uiEncode("at at at"));
	// //System.out.println(uiDecode("tototo"));
	// //System.out.println(uiEncode("as as as"));
	// //System.out.println(uiDecode(uiEncode("as as as")));
	// //System.out.println(basic);
	// }
}