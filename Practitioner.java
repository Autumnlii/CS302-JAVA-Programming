package LI;

import java.util.Arrays;// need to use array
import java.util.Random;//need to use random


///////////////////////////////////////////////////////////////////////////////
// Semester: // 2014 Fall
// Author:Qiuying Li
// Email:qli243@wisc.edu
//CS302 Summer 2014
//(your name) Qiuying Li
//(your email address) qli243@wisc.edu
// Lecturer's Name: (name of your lecturer) //Nick Pappas
//
// ANY SOURCE THAT YOU USED BESIDES THE BOOK, TA OR INSTRUCTOR (e.g websites) // google to get help of Regex Match Tracer in mathod 3
// Credits: (list anyone/anything who helped you write your program) //////////////////////////// 80 columns wide //////////////////////////////////

/**
 * This program is designed to practice method and array
 * This class contains 14 public method and several related private method
 * method1 and method 2 can be used to insert string into another string according to the specific requirements;
 * method 3 , method 4 and method 5 are  about the numecial regions in the string.
 * method 6, method 7, and method 8 are about compare one string to another string
 * method 9, method 10 and method 11 are about create the upper part, lower part and base of the "tree"
 * method 12 , method 13 and method 14 are about the create random numbers and related to draw "tree "
 * <p>Bugs: (a list of bugs and other problems) 
 * <p>Bug：swhen create the random number, I do know how to avoid negative number
 * when a negative number appears, the whole program stop running.
 * <p>Bug in the method 6 doesThisStringHasThisOtherStringInIt, 
 * I do not know when "" is valid or when "" is not vali, what is more, 
 * I know how to avoid numbers in the String enhancedSub, I just do have time
 * 
 * 
 * @author Qiuying Li
 *
 */

public class Practitioner {
	public static void main(String[] args) {
		System.out.println("-------------PICTURE--------------");
		printArray(drawTop((byte)1,(byte)5)); 
		printArray(drawBody((byte) 9, 12345679));
		printArray(drawBase((byte)9, (byte) 8));
		printArray(drawTop((byte)2,(byte)4)); 
		printArray(drawBody((byte) 5, 123456));
		printArray(drawBase((byte)6, (byte) 2));
	
		System.out.println("-------------Random PICTURE--------------");
		printArray(Practitioner.drawTop(System.currentTimeMillis()));
		printArray(Practitioner.drawBase(System.currentTimeMillis()));
		printArray(Practitioner.drawBody(System.currentTimeMillis()));
		
		System.out.println("-------------insertAt--------------");
		String swissCheese = "swissCheese"; 
		System.out.println(swissCheese); 
		String swissCheese1 = "swissChess";
		System.out.println(swissCheese1);
		swissCheese1 = insertAt(swissCheese1, -2, 0.0, true);
		System.out.println(swissCheese1);
		swissCheese1 = insertAt(swissCheese1, 0, 0.0, true);
		System.out.println(swissCheese1);
		swissCheese1 = insertAt(swissCheese1, 90, 0.0, true);
		System.out.println(swissCheese1);
		swissCheese1 = insertAt(swissCheese1, 1, 0.0, false);
		System.out.println(swissCheese1);
		swissCheese1 = insertAt(swissCheese1, 5, "WOOT");
		System.out.println(swissCheese1);
		swissCheese1 = insertAt(swissCheese1, 14, "00");
		System.out.println(swissCheese1);
		swissCheese1 = insertAt(swissCheese1, 1900, "WOOT");
		System.out.println(swissCheese1);
		swissCheese1 = insertAt(swissCheese1, 3, "");
		System.out.println(swissCheese1);
		
		System.out.println("-------------hasSingleNumericalRegionInIt--------------");
		System.out.println(hasSingleNumericalRegionInIt("89.45.4"));
		System.out.println(hasSingleNumericalRegionInIt(""));
		System.out.println(hasSingleNumericalRegionInIt("  "));
		System.out.println(hasSingleNumericalRegionInIt("89.45"));
		System.out.println(hasSingleNumericalRegionInIt("sdsdsd89.45sdhsudsh"));
		System.out.println(hasSingleNumericalRegionInIt("89."));
		System.out.println(hasSingleNumericalRegionInIt("78hhh"));
		System.out.println(hasSingleNumericalRegionInIt("89"));
		System.out.println(hasSingleNumericalRegionInIt("8 4"));
		System.out.println("------------getNumericalRegionsIn-------------");
		String[] ar = getNumericalRegionsIn("sad");
		System.out.println(Arrays.toString(ar));
		ar = getNumericalRegionsIn("34.5.6");
		System.out.println(Arrays.toString(ar));
		ar = getNumericalRegionsIn("34.5.6.7");
		System.out.println(Arrays.toString(ar));
		ar = getNumericalRegionsIn(".34Hi4.5.6There4");
		System.out.println(Arrays.toString(ar));
		ar = getNumericalRegionsIn(".34Hi-4.5.6There4");
		System.out.println(Arrays.toString(ar));
		System.out.println(Arrays.toString(ar));
		System.out.println("------------extractFirstNumericalArea-------------");
		System.out.println(extractFirstNumericalArea(".34.4.4.4"));
		System.out.println(extractFirstNumericalArea(".34..4.4.4"));
		System.out.println(extractFirstNumericalArea("sdsdsgeded34.  fd4"));
		System.out.println("------------doesThisStringHasThisOtherStringInIt-------------");
		System.out.println(doesThisStringHasThisOtherStringInIt("banana", "banana"));
		System.out.println(doesThisStringHasThisOtherStringInIt("abababa", "aba"));
		System.out.println(doesThisStringHasThisOtherStringInIt("abababa", "babab"));
		System.out.println(doesThisStringHasThisOtherStringInIt("banana", "bna"));
		System.out.println(doesThisStringHasThisOtherStringInIt("sssfgWsigSbssdCfdhesdEfsse", 
		"swissCheese"));
		System.out.println(doesThisStringHasThisOtherStringInIt("sssfgWsigSbssdCfdhesdEfsse", 
		"SWISSCHEESE"));
		System.out.println(doesThisStringHasThisOtherStringInIt("sssfgWsigSbssdCfdhesdEfsse", 
		"swisscheesse"));
		System.out.println(doesThisStringHasThisOtherStringInIt("sssfgWsigSbssdCfdhesdEfsse", 
		"ssswssssse"));
		System.out.println(doesThisStringHasThisOtherStringInIt("sssfgWsigSbssdCfdhesdEfsse", ""));
		System.out.println(doesThisStringHasThisOtherStringInIt("sssfg WsigSbss dCfdasd hesdEfsse", ""));
		System.out.println(doesThisStringHasThisOtherStringInIt("sssfg WsigSbss dCfdasd hesdEfsse", 
		"sbfe"));
		System.out.println(doesThisStringHasThisOtherStringInIt("he ll o th e r e", "banana"));
		System.out.println(doesThisStringHasThisOtherStringInIt("1i2c3what4is5going6on", "123456"));
		System.out.println(doesThisStringHasThisOtherStringInIt("1i2c3what4is5going6on", 
		"icwhatisgoingon"));
		System.out.println("------------doesThisStringHasThisOtherStringInItReversed-------------");
		System.out.println(doesThisStringHasThisOtherStringInItReversed("somey", "yes"));
		System.out.println(doesThisStringHasThisOtherStringInItReversed("yemos", "yes")); 
		System.out.println(doesThisStringHasThisOtherStringInItReversed("yemos", "SOme"));
		System.out.println("------------highlightWordInString-------------");
		System.out.println(highlightWordInString("efohd453fsaYHSHbbhy777GS%#cafddn d66:.4.5ydsofdsusadcHAEdsde", "ohsaycanyousee", 1));

		
	}
	
	

	/**method 1
	 * This method inserts a numerical value given as a double inside a String at the
     *position specified by the parameter indexP.
     * if the last parameter is set to true, it is inserting the number as a double
	 *
	 * @param (sP) (store the string)
	 * @param (index) (to specify the position)
	 * @param(valueP) (the numerical value need to be inserted into the string)
	 * @param(shouldKeepDecimal)( to estimate if the statement is true or false)
	 * @return (return the string which has been inserted a numerical values into it)
	 */
	public static String insertAt(String sP, int indexP, double valueP,
			boolean shouldKeepDecimal) {
		if(indexP<0||indexP>sP.length())
		{
			return sP;
		}//negative numbers and number longer than the length of sP leave sP unaltered.
		else if (shouldKeepDecimal) {
			sP = sP.substring(0, indexP) + valueP
					+ sP.substring(indexP, sP.length());//true return double
		} else {
			sP = sP.substring(0, indexP) + (int) valueP
					+ sP.substring(indexP, sP.length());
		}// false return int and need to cast double into int
		return sP;
	}// done!

	/**
	 * Method 2
	 * Inserts a string valueP at position indexP in string sP.
	 *
	 * @param (sP) (The string need to be inserted with another string)
	 * @param (index) (string need to be inserted into another string)
	 * @param(The position where two string inserted)
	 * @return (the string complete the insert)
	 */
	public static String insertAt(String sP, int indexP, String valueP) {
		if (indexP<0||indexP>sP.length())
		{
			return sP;
		}//negative numbers and number longer than the length of sP leave sP unaltered.
		else
		{
		return sP.substring(0, indexP) + valueP
				+ sP.substring(indexP, sP.length());
		}
	      }// done!
	

/**
 * Method 3
 * returns true if the String provided contains a single numerical region in it.
 *
 * @param (sP) (The string need to be checked)
 * 
 * @return (true if the string only contains a numerical region)
 *///请写注释
	public static boolean hasSingleNumericalRegionInIt(String sP) {
		 sP.replace("]", "");//
		 sP = sP.replaceAll("[1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*", "]");// get the help from the Regex Match Tracer;
		 sP = sP.replaceAll("[0-9]+", "]");//
		 int k = sP.length() - sP.replace("]", "").length();//
		 return (k % 2) != 0;
	}


/**
 * Method 4
 * Returns a String array that contains the numerical regions detected in a String,
 *as Strings.
 * A numerical region is a region that consists of digits, or digits with a single
 ‘.’ in between them, in which case the region is a decimal number.
 *
 * @param (sP) (The string need to be checked)
 * 
 * @return (the numerical regions in the string)
 */
	public static String[] getNumericalRegionsIn(String sP) {
		String string = "";
		for (int i = 0; i < sP.length(); i++) {
			if (CharAtIisANum(sP, i)) {
				while (CharAtIisANum(sP, i)) {
					string += sP.charAt(i);
					i++;
				}
				if ((sP.charAt(i) + "").equals(".") && CharAtIisANum(sP, i + 1)) {
					string += ".";
					i++;
					while (CharAtIisANum(sP, i)) {
						string += sP.charAt(i);
						i++;
					}
					string += ",";
					break;
				}
				string += ",";
				break;
			}
		}
		String[] s = string.split(",");
		return s;
	}

	/**
     * private method for method 4
     * @param string 
     * @param i
     * @return (true, if the 麻烦写一下注释
     * 
     */
	private static Boolean CharAtIisANum(String string, int i) {
		try {
			Integer.parseInt(string.charAt(i) + "");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}


/**
 * Method 5
 * returns the first numerical region detected in a String sP as a String.
 *
 * @param (sP) (The string need to be inserted with another string)
 * @param (index) (string need to be inserted into another string)
 * @param(The position where two string inserted)
 * @return (the string complete the insert)
 *
 */
	//find the number first,and find a '.' then keep going
	public static String extractFirstNumericalArea(String sP) {
		String string = "";
		for (int i = 0; i < sP.length(); i++) {
			if (CharAtIisANum(sP, i)) {
				while (CharAtIisANum(sP, i)) {
					string += sP.charAt(i);
					i++;
				}
				if ((sP.charAt(i) + "").equals(".") && CharAtIisANum(sP, i + 1)) {
					string += ".";
					i++;
					while (CharAtIisANum(sP, i)) {
						string += sP.charAt(i);
						i++;
					}
					break;
				}
				break;
			}
		}
		return string;
	}


/**
 * Method 6
 * returns true if a String named enhancedSub can be formed by parsing string s from
 *left to right and keeping only the necessary LETTER characters to form enhancedSub 
 *(and of course use them just once, and in order).
 *
 * @param (sP) (The string need to be checked)
 * @param (enhancedSub) (string need to be compared with some of characters  of string sP)
 * @return (true means stringsP contains string enhancedSub)
 */
public static boolean doesThisStringHasThisOtherStringInIt(String sP,String enhancedSub )	
{
	// TODO Auto-generated method stub
	
	String rightWord="";
	sP = sP.toUpperCase();
	enhancedSub = enhancedSub.toUpperCase();
	if(enhancedSub.length()==0||sP.length()==0)
		{return false;
		}
	
	int i = 0;// i is how many times the for loop is been executed to go over all the char in the sP
	int m =0;//to memorize the position where char in the sP find its match char in the enhancedSub.
	int j = 0;//j is how many times the for loop is been executed so that go over the char in enhancedSub
	
	
	for(j=0;j<enhancedSub.length();j++)
	{
		
	char rightPosition = enhancedSub.charAt(j);
	   for (i=m; i<sP.length();i++)
	   {
		   char rightLetter =  sP.charAt(i);
		
		if(rightLetter==rightPosition)//if the letter equals to the first letter;
		{
			rightWord=rightWord+rightLetter;
		     m=i;
		     break;// as long as we find the matchable char, the inner for loop stops
		   
		}
	   }
	}
	
	if(rightWord.equalsIgnoreCase(enhancedSub))
	{
		return true;
	}
	return false;
	
}

/**
 * Method 7
 * returns true if a string named enhancedSub can be formed by parsing string s from
 *right to left and keeping only the necessary characters to form enhancedSub (and of course use
 *them just once, and in order)
 *
 * @param (sP) (The string need to be checked)
 * @param (enhancedSub) (string need to be compared with some of characters  of string sP)
 * @return (true means the string has this other string in it reversed)
 */
public static boolean doesThisStringHasThisOtherStringInItReversed(
		String sP, String enhancedSub) {
	sP = sP.toLowerCase();
	enhancedSub = enhancedSub.toLowerCase();// to avoid case sensitive
	int NUM = enhancedSub.length() - 1;// from the last char to the first char
	int k = 0;
	for (int i = 0; i < sP.length(); i++) {
		if (enhancedSub.charAt(NUM) == sP.charAt(i)) {
			NUM--;
			k++;
			continue;
		}
		if (NUM < 0) {
			break;// it menas the for loop go over all the chars in the enhancedSub
		}
	}
	if (k == enhancedSub.length()) {
		return true;//if k==enhancedSub.length(), we find the right word in the right order
	}else {
		return false;
	}
}

/**
 * Method 8
 * Highlights an enhancedSub that consists of LETTERS in a string sP.
 * It converts everything in the string to lower case and converts all the characters * of the enhanceSub to 
 * capitals (they must be letters). Consecutive sequences of capital letters will be further standing our 
 * by adding howManySpacesP spaces on each of their side.
 *
 * @param (sP) (The string need to be checked)
 * @param (enhancedSub) (string need to be compared with some of characters  of string sP)
 * @return (highlightWordInStringsP)
 */
public static String highlightWordInString(String sP, String enhancedSub,
		int howManySpacesP) {
	sP = sP.toLowerCase().replace(" ", "");//change the all the characters in the string into lower cases
	int NUM = 0;
	String spaces = createSpaces(howManySpacesP);
	for (int i = 0; i < sP.length(); i++) {
		// System.out.println(NUM+":"+enhancedSub.charAt(NUM));
		if (sP.charAt(i) == enhancedSub.charAt(NUM)) {//if two characters from different strings are equal.
			sP = sP.substring(0, i) + spaces
					+ (enhancedSub.charAt(NUM) + "").toUpperCase() + spaces//transfer char in to string to use toupperCase
					+ sP.substring(i + 1, sP.length());
			NUM++;
		}
		if (NUM == enhancedSub.length()) {
			break;//the for loop goes over all the characters in the enchancedSub, so it should stop;
		}
	}
	sP = sP.replace(spaces + spaces, "");
	return sP;
}

/**
 * Method 8-private method
 * To create the space by using for loop
 *
 * @param (howManySpaces) (How many spaces the users want)
 *
 * @return (Spcaces after for loop)
 */
private static String createSpaces(int howManySpaces) {
	String spaces = "";
	for (int i = 0; i < howManySpaces; i++) {
		spaces += " ";// get the space in the increase order
	}
	return spaces;
}
/**
 * Method 9
 * This method constructs a fun ASCII picture and then it is storing it in a 2D char array, 
 * and it does so by getting an input of two bytes.To build the top of the picture.
 *
 * @param (whichDigitP) (the repeat number)
 * @param (howManyTimesP) (columns)
 * @return (picture)
 */
public static char[][] drawTop(byte whichDigitP, byte howManyTimesP) {
	// To avoid numbers larger than 9 and numbers smaller than 1;
	if (whichDigitP > 9) {
		whichDigitP = 9;
	}
	if (whichDigitP < 1) {
		whichDigitP = 1;
	}
	if (howManyTimesP > 9) {
		howManyTimesP = 9;
	}
	if (howManyTimesP < 1) {
		howManyTimesP = 1;
	}
	// To build the structure the the left tree
	int leftSize = 2 * howManyTimesP + 1;//by calculating, I find the digits of the row 
	char[][] leftTree = new char[howManyTimesP][leftSize];//To build the columns and the rows of the left tree.
	// To create the specific spaces in the left tree. 
	for (int i = 0; i < leftTree.length; i++) {
		for (int j = 0; j < leftTree[0].length; j++) {
			leftTree[i][j] = ' ';
		}
	}
	for (int i = 0; i < howManyTimesP; i++) {
		int mid = leftSize / 2;
		leftTree[i][mid] = '*';// to calculate the position of the '*' and put '*'
		for (int j = 1; j <= i + 1; j++) {
			leftTree[i][mid - j] = (char) (whichDigitP + '0');
			leftTree[i][mid + j] = (char) (whichDigitP + '0');
		}
	}

	// To build the right tree;
	int rightSize = howManyTimesP * 2 -1;//Build the row of the right tree, to calculate the digits of the right tree;
	char[][] rightTree = new char[howManyTimesP][rightSize];// build the columns and rows of the right tree;
	
	for (int i = 0; i < rightTree.length; i++) {
		for (int j = 0; j < rightTree[0].length; j++) {
			rightTree[i][j] = ' ';// To build the specific spaces for the right tree;
		}
	}
	// calculate the value of the right tree
	for (int i = 0; i < howManyTimesP; i++) {
		
		long value = 0;
		for (int j = 0; j < i + 1; j++) {
			value += whichDigitP * Math.pow(10, j);//to get each numerical value match the left tree;
		}
		Long result = new Long(value * value);//get the right values for the right tree;
		String resString = result.toString();//change integer into string
		//if (result.toString().length() % 2 != 0) {
			//resString = "0" + resString;
		//}>>>>>>>>>>>>>貌似不需要0 在开头

		int mid = rightSize / 2 - resString.length() / 2;
		for (int m = mid; m < mid + resString.length(); m++) {
			rightTree[i][m] = resString.charAt(m - mid);
		}
	}

	// put left tree and right tree together
	int pSize = leftSize + 3 + rightSize;//3=" "+"="+" "
	char[][] pictures = new char[howManyTimesP][pSize];
	char[] split = { ' ', '=', ' ' };//insert " "+"="+" " into the array
	for (int i = 0; i < howManyTimesP; i++) {
		// put left tree into it 
		for (int m = 0; m < leftSize; m++) {
			pictures[i][m] = leftTree[i][m];
		}
		
		for (int m = leftSize; m < leftSize + 3; m++) {
			pictures[i][m] = split[m - leftSize];
		}
		// put the right tree into it；
		for (int m = leftSize + 3; m < pSize; m++) {
			pictures[i][m] = rightTree[i][m - leftSize - 3];
		}
	}
	return pictures;
}


/**
 * Method 10
 * This method constructs a fun ASCII picture and then it is storing it in a 2D char array, 
 * and it does so by getting an input of two bytes.
 *
 * @param (howManyTimesP) (column)
 * @param (factorP) (numbers that repeat)
 * @return (picture)
 */
public static char[][] drawBase(byte howManyTimesP, byte factorP) {
	if (howManyTimesP > 14) {
		howManyTimesP = 14;
	}
	if (howManyTimesP < 1) {
		howManyTimesP = 1;
	}
	if (factorP > 14) {
		factorP = 14;
	}
	if (factorP < 1) {
		factorP = 1;
	}
	// To initialize 
	int leftSize;
	int numSize = 0;
	long[] numValue = new long[howManyTimesP];
	if (howManyTimesP < 10) {
		numSize = howManyTimesP;
		if (factorP > 10) {
			leftSize = numSize + 5;
		} else {
			leftSize = numSize + 4;
		}

	} else {
		numSize = 9 + (howManyTimesP - 9) * 2;
		if (factorP > 10) {
			leftSize = numSize + 6;
		} else {
			leftSize = numSize + 5;
		}
	}
	char[][] leftTree = new char[howManyTimesP][leftSize];
	//To build the primary structure of the left tree
	initToSpace(leftTree);//>>>>>>>There is a private method 
	// 1313+2
	// To build the left tree;
	for (int i = 0; i < howManyTimesP; i++) {
		// To build numerical string
		String numString = "";
		for (int m = 1; m <= i + 1; m++) {
			Integer num = new Integer(m);
			numString += num.toString();
		}
		numValue[i] = Long.parseLong(numString);
		// To make sure the starting position of the numString
		int s1 = new Integer(howManyTimesP).toString().length();
		int s2 = new Integer(factorP).toString().length();
		int st = s1 + s2 + 2;
		int start = leftSize - st - numString.length();
		for (int m = start; m < start + numString.length(); m++) {
			leftTree[i][m] = numString.charAt(m - start);
		}// 1+1*14
		int newStart = start + numString.length();
		// To add '+' into it
		leftTree[i][newStart] = '+';
		// To add factoryP
		String factoryPs = new Integer(factorP).toString();
		for (int m = 0; m < factoryPs.length(); m++) {
			leftTree[i][newStart + 1 + m] = factoryPs.charAt(m);
		}
		newStart = newStart + factoryPs.length() + 1;
		leftTree[i][newStart] = '*';
		String tPs = new Integer(i + 1).toString();
		for (int m = 0; m < tPs.length(); m++) {
			leftTree[i][newStart + 1 + m] = tPs.charAt(m);
		}
	}

	// To build the right tree
	long[] results = new long[howManyTimesP];
	for (int i = 0; i < results.length; i++) {
		results[i] = numValue[i] + factorP * (i + 1);
	}

	// combine left tree and right tree together
	int rightSize = new Long(results[howManyTimesP - 1]).toString()
			.length();
	int totalSize = leftSize + 3 + rightSize;

	char[][] pictures = new char[howManyTimesP][totalSize];
	char[] split = { ' ', '=', ' ' };
	initToSpace(pictures);

	for (int i = 0; i < howManyTimesP; i++) {
		for (int m = 0; m < leftSize; m++) {
			pictures[i][m] = leftTree[i][m];
		}
		for (int m = leftSize; m < leftSize + 3; m++) {
			pictures[i][m] = split[m - leftSize];
		}
		String rstr = new Long(results[i]).toString();
		for (int m = leftSize + 3; m < leftSize + 3 + rstr.length(); m++) {
			pictures[i][m] = rstr.charAt(m - leftSize - 3);
		}
	}
	return pictures;
	
}
/**
 * Method 11
 * This method constructs a fun ASCII picture and then it is storing it in a 2D char array, 
 * and it does so by getting an input of two bytes.
 *
 * @param (howManyTimesP) (column)
 * @param (theNumberP) (number repeat)
 * @return (pictures)
 */
public static char[][] drawBody(byte howManyTimesP, int theNumberP) {
	if (howManyTimesP > 9) {
		howManyTimesP = 9;
	}
	if (howManyTimesP < 1) {
		howManyTimesP = 1;
	}
	if (theNumberP > 99999999) {
		theNumberP = 99999999;
	}
	if (theNumberP < 1) {
		theNumberP = 1;
	}
	// To build left tree;
	String theNumberPStr = new Integer(theNumberP).toString();
	int leftSize = theNumberPStr.length() + 3;//get the formula for the left size
	char[][] leftTree = new char[howManyTimesP][leftSize];
	long[] numbers = new long[howManyTimesP];//create a long array
	initToSpace(leftTree);//create a new private method 

	for (int i = 0; i < howManyTimesP; i++) {
		for (int m = 0; m < theNumberPStr.length(); m++) {
			leftTree[i][m] = theNumberPStr.charAt(m);
		}
		leftTree[i][theNumberPStr.length()] = '*';

		// Get the number match the left tree and will be used to be multiplied
		numbers[i] = (i * 10) + (howManyTimesP - i);

		// add the number into the string numStr
		String numStr = new Long(numbers[i]).toString();
		if (numStr.length() < 2) {
			numStr = "0" + numStr;
		}

		for (int k = 0; k < numStr.length(); k++) {
			leftTree[i][theNumberPStr.length() + 1 + k] = numStr.charAt(k);
		}
	}

	// To build right tree
	long max = Long.MIN_VALUE;

	for (int i = 0; i < numbers.length; i++) {
		if (numbers[i] > max) {
			max = numbers[i];
		}
	}
	long rightMax = max * theNumberP;
	int rightSize = new Long(rightMax).toString().length();
	char[][] rightTree = new char[howManyTimesP][rightSize];
	initToSpace(rightTree);
	for (int i = 0; i < howManyTimesP; i++) {
		long result = theNumberP * numbers[i];
		String reStr = new Long(result).toString();
		int result_size = reStr.length();
		int start = rightSize - result_size;
		for (int m = start; m < result_size; m++) {
			rightTree[i][m] = reStr.charAt(m - start);
		}
	}

	// combine left tree and right tree together
	int totalSize = leftSize + 3 + rightSize;
	char[][] pictures = new char[howManyTimesP][totalSize];
	char[] split = new char[] { ' ', '=', ' ' };
	initToSpace(pictures);

	for (int i = 0; i < howManyTimesP; i++) {
		for (int m = 0; m < leftSize; m++) {
			pictures[i][m] = leftTree[i][m];
		}
		for (int m = leftSize; m < leftSize + 3; m++) {
			pictures[i][m] = split[m - leftSize];
		}
		for (int m = leftSize + 3; m < totalSize; m++) {
			pictures[i][m] = rightTree[i][m - leftSize - 3];
		}
	}
	return pictures;
}
/**
 * Method 12
 *To create random number for the drawtop
 *
* @param (seedP) 
 * @return (drawTop(bytes[0], bytes[1]))(the random number)
 */
public static char[][] drawTop(long seedP) {
	Random random = new Random();
	random.setSeed(seedP);
	byte[] bytes = new byte[2];
	random.nextBytes(bytes);
	return drawTop(bytes[0], bytes[1]);
}
/**
 * Method 13
 *To create random number for the draw base
 *
* @param (seedP) (column)
 * @return (drawBase(bytes[0], bytes[1])(the random number)
 */
public static char[][] drawBase(long seedP) {
	Random random = new Random();
	random.setSeed(seedP);
	byte[] bytes = new byte[2];
	random.nextBytes(bytes);
	return drawBase(bytes[0], bytes[1]);
}
/**
 * Method 14
 *To create random number for the draw body
 *
 * @param (seedP) (column)
 * @return (drawBody(bytes[0], random.nextInt()))(the random number)
 */

public static char[][] drawBody(long seedP) {
	Random random = new Random();
	random.setSeed(seedP);
	byte[] bytes = new byte[1];
	random.nextBytes(bytes);
	return drawBody(bytes[0], random.nextInt());
}

/**
 * private method for method 9
 * @param c 
 * 
 * @param ch
 * @return chs
 * 
 */
    private static char[][] initToSpace(char[][] chs) {
    	initToSpace(chs, ' ');
    return chs;
}

    /**
     * private method for method 9
     * @param c 
     * 
     * @param ch
     * @return chs
     * 
     */
    private static char[][] initToSpace(char[][] chs, char ch) {
		for (int i = 0; i < chs.length; i++) {
			for (int j = 0; j < chs[i].length; j++) {
				chs[i][j] = ch;
			}
		}
		return chs;
	}
    /**
     * private method for method 9
     * @param c 
     * 
     * @param ch
     * @return chs
     * 
     */
   
	private static void printArray(char[][] chs) {
		for (int i = 0; i < chs.length; i++) {
			for (int j = 0; j < chs[i].length; j++) {
				System.out.print(chs[i][j]);
			}
			System.out.println();
		}
	}


}
