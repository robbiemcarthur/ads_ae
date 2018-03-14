

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
//import implementing set (eg. TreeSet)
import java.util.TreeSet;




public class WordProcessor {

	private static <E> String displaySet(Set<E> inputSet){
		//implement this static method to create a
		// String representation of set - 5 comma separated elements per line
		// assume that type E has a toString method

		String word = "";
		int n = 0;

		for(E element:inputSet) {
			if(n==5)
			{
				n=0;
				word+="\n";
			}
			word+=element.toString();
			n++;
		}
		return word;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String [] files = new String[] {"file0.txt", "file1.txt", "file2.txt"};
		Set<String> wordSet = new TreeSet<String>();
		Set <CountedElement<String>> countedWordSet = new TreeSet<CountedElement<String>>();
		int instance = 1;
		for(String fin:files)
		{
			File fileIn = new File(fin);
			try {
				Scanner s = new Scanner(fileIn);
				while(s.hasNextLine())
				{
					String[] words = s.nextLine().split(" ");
					for(String w:words)
					{
						if(!wordSet.contains(w)||wordSet.isEmpty())
						{
//							System.out.println("No instance of " + w + "!");        // TESTING
							wordSet.add(w);
							countedWordSet.add(new CountedElement<String>(w, instance));
						}
						else
						{
							for(CountedElement<String>ce:countedWordSet)
							{
								if(ce.getElement().equals(w))
								{
									ce.incrementCount();
								}
							}
						}
					}
				}
				s.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(CountedElement<String> element: countedWordSet)
			{
				element.compareTo(element);
			}
		}

		//create a set of type String called wordSet
		//create a set of type CountedElement<String> called countedWordSet 

		//for each input file (assume 3 arguments, each the name of a file)
		//  for each word w
		//     if wordset doesnt contain w:
		//        add w to wordset
		//        add new element to countedWordSet
		//     else

		//        increment numeric part of element in countedWordSet containing w
		
		// TESTING STRING OUTPUT
//		int c = 0;
//		for(CountedElement<String> wrd:countedWordSet)
//		{
//			if(c!=5)
//			{
//			System.out.print("("+wrd.getElement() + "," + wrd.getCount()+"), ");
//			c++;
//			}
//			else
//			{
//				System.out.print("\n");
//				c=0;
//			}
//		}
		
//		for(CountedElement<String>wrd:countedWordSet)
//		{
//			System.out.println(wrd.toString());
//		}
		System.out.println(displaySet(countedWordSet));
	}
}
