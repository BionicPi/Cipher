/**
 @author Max Meinhold
 Pd. 4B
 Apr 10, 2015
 */
package Cipher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Cipher
{
	public static Cipher basic;
	private String[][] key;
	private static int rows = 11;
	private static int cols = 10;
	private static String defaultKey = "A B C D E F G H I J"
			+ "Ö _ + ` ~ < , > . K" 
			+ "ö = a p l e c 4 \\ L"
			+ "Ä - [ v w x d 5 ' M" 
			+ "ä ) b u t r f 6 \" N"
			+ "Å ( q 2 3 z h 7 ; O" 
			+ "å * s g y 1 i 8 : P"
			+ "space & o n m k j 9 / Q" 
			+ "{ ^ % $ # @ ! 0 ? R"
			+ "} ] Z Y X W V U T S" 
			+ "enter tab é á í ô î ï ç Ç";

	public Cipher()
	{
		key = new String[rows][cols];
		defaultInput();
	}

	public Cipher(String keyName)
	{
		key = new String[rows][cols];
		basic = new Cipher();
		fileInput(keyName);
	}

	public static void defaultInput()
	{
		basic = new Cipher();
		int i = 0;
		for (int row = 0; row < rows; row++)
		{
			for (int col = 0; col < cols; col++)
			{
				if (defaultKey.substring(i, i + 1).equals(" "))
					i++;
				basic.key[row][col] = defaultKey.substring(i, i + 1);
				try
				{
					if (defaultKey.substring(i, i + 1).equals("e")
							&& defaultKey.substring(i + 1, i + 2).equals("n"))
					{
						basic.key[row][col] = "enter";
						i += 4;
					}
					if (defaultKey.substring(i, i + 1).equals("s")
							&& defaultKey.substring(i + 1, i + 2).equals("p"))
					{
						basic.key[row][col] = "space";
						i += 4;
					}
					if (defaultKey.substring(i, i + 1).equals("t")
							&& defaultKey.substring(i + 1, i + 2).equals("a"))
					{
						basic.key[row][col] = "tab";
						i += 2;
					}
				} catch (Exception e)
				{
					e.printStackTrace();
				}
				if (basic.key[row][col].equals("space"))
					basic.key[row][col] = " ";
				if (basic.key[row][col].equals("enter"))
					basic.key[row][col] = "\n";
				if (basic.key[row][col].equals("tab"))
					basic.key[row][col] = "\t";
				i++;
			}
		}
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
					if (key[row][col].equals("space"))
						key[row][col] = " ";
					if (key[row][col].equals("enter"))
						key[row][col] = "\n";
					if (key[row][col].equals("tab"))
						key[row][col] = "\t";
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
		return in;
	}

	private String swapPairsEncode(String in)
	{
		String encoded = "";
		in = toPairs(in);
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
		}
		return encoded;
	}

	private String toPairs(String in)
	{
		String o = "";
		int x = 0;
		for (int i = 0; i < in.length() - 1; i++)
		{
			if (in.substring(i, i + 1).equals(in.substring(i + 1, i + 2)))
			{
				o += in.substring(i, i + 1) + "X";
				x++;
			} else
			{
				o += in.substring(i, i + 2);
				i++;
			}
		}
		if (x % 2 != 0)
		{
			o += in.substring(in.length() - 1) + "X";
		}
		return o;
	}

	/**
	 * @deprecated
	 * 
	 * @param in
	 * @return
	 */
	@SuppressWarnings("unused")
	private String toFives(String in)
	{
		 String o = "";
		 // in = in.toUpperCase();
		 //in = removeSpaces(in);
		 for (int i = 0; i < in.length(); i++)
		 {
		 if (in.length() - i >= 5)
		 {
		 o += in.substring(i, i + 5) + " ";
		 i += 4;
		 } else
		 {
		 o += in.substring(i);
		 i += in.length();
		 }
		 }
		 return o;
//		return in;
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
			i++;
		}
		return decoded;
	}

	private String fromPairs(String in)
	{
		in = swapPairsDecode(in);
		in = undosplitDuplicates(in);
		if (in.endsWith("X"))
		{
			in = in.substring(0, in.length() - 1);
		}
		return in;
	}

	// Utility
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
				if (key[r][c].equals(" "))
					o += "space";
				else if (key[r][c].equals("\n"))
					o += "line break";
				else if (key[r][c].equals("\t"))
					o += "tab";
				else
					o += key[r][c];
				o += "\t";
			}
			o += "\n";
		}
		return o;
	}

	public static String uiEncode(String original)
	{
		try
		{
			return basic.encode(original);
		} catch (NullPointerException e)
		{
			try
			{
				basic = new Cipher();
				return basic.encode(original);
			} catch (NullPointerException e1)
			{
				try
				{
					defaultInput();
					return basic.encode(original);
				} catch (Exception e2)
				{
					e2.printStackTrace();
					return "Fatal error reached.";
				}
			}
		}
	}

	public static String uiDecode(String encoded)
	{
		try
		{
			return basic.decode(encoded);
		} catch (NullPointerException e)
		{
			try
			{
				basic = new Cipher();
				return basic.decode(encoded);
			} catch (NullPointerException e1)
			{
				try
				{
					defaultInput();
					return basic.decode(encoded);
				} catch (Exception e2)
				{
					e2.printStackTrace();
					return "Fatal error reached.";
				}
			}
		}
	}
}