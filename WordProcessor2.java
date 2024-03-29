import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class WordProcessor2 {

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
			BSTBag test = new BSTBag();
			int count = 0;
			for(CountedElement<String> element: countedWordSet)
			{
				test.add(element);
				System.out.println("Adding "+element+" to " + test);
			}
			for(CountedElement<String> element: countedWordSet)
			{
				if (count==1||count==4||count==7)
				{
					test.remove(element);
					System.out.println("Deleting "+element+" from " + test);
				}
				count++;
			}
			System.out.println(test.size());
			Iterator testIterator = test.iterator();
			while(testIterator.hasNext())
			{
			System.out.println("Printing from iterator... " + testIterator.next().toString());
			}
		}
	}
}
