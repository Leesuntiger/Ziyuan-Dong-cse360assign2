//***************************************************************************
//    Programmer:  Ziyuan Dong          Class ID: #255	Monday session
//	  Assignment:  Assignment 2(Version Control System)
//    Date:        February 27, 2020
//    Description: This program demonstrate the use of version control system
//				   with the practice of github, or Bitbucket, this assignment
//                 include the methods like SimpleList(), add(int),remove(int), 
//                 count(), toString(), search(int), append(int), first(), and 
//                 size().
//    Input:       None
//    Output:      None
//***************************************************************************

package cse360assign2;

public class SimpleList
{
	//variables from class diagram
	private int[] list;
	private int count;
	
	//list constructor method
	public void SimpleList()
	{
		list = new int[10];
		count = 0;
	}
	
	//add n to list at index 0
	public void add(int n)
	{
		int length = list.length;
		if(length > 0)
		{
			if(count >= length)
			{
				int [] temp = new int[(int)Math.round(list.length * 1.5)];
				for(int iterator = 0; iterator < list.length; iterator++)
				{
					temp[iterator] = list[iterator];
				}
				list = new int[temp.length];
				for(int interator = 0; interator < temp.length; interator++)
				{
					list[interator] = temp[interator];
				}
			}
			for(int iterator = count; iterator>0; iterator--)
			{
				list[iterator] = list[iterator-1];
			}
		}
		
			list[0] = n;
			count++;
	}
	
	//remove n if in list and shift left
	public void remove(int n) 
	{
		//call search method first for index
		int index = search(n);

		//if n is actually in the list
		if(index != -1 || index < list.length)
		{
			for(int iterator = index; iterator < count-1; iterator++)
			{
				list[iterator] = list[iterator+1];
			}
			count--;
		}
		
		if (count < list.length*.75)
		{
			int [] temp = new int[(int)Math.round(list.length * .75)];
			for(int iterator = 0; iterator < temp.length; iterator++)
			{
				temp[iterator] = list[iterator];
			}
			list = new int[temp.length];
			for(int interator = 0; interator < temp.length; interator++)
			{
				list[interator] = temp[interator];
			}
		}
	}
	
	public void append(int n) 
	{
		int length = list.length;
		if(length > 0)
		{
			if(count >= length)
			{
				int [] temp = new int[(int)Math.round(list.length * 1.5)];
				for(int iterator = 0; iterator < list.length; iterator++)
				{
					temp[iterator] = list[iterator];
				}
				list = new int[temp.length];
				for(int interator = 0; interator < temp.length; interator++)
				{
					list[interator] = temp[interator];
				}
			}
		}
		list[count] = n;
		count++;
	}
	
	public int first()
	{
		return list[0];
	}
	
	public int size()
	{
		return list.length;
	}
	
	//return private variable count
	public int count()
	{
		return count;
	}
	
	//print the list with spaces
	public String toString()
	{
		String total = "";;
		for(int iterator = 0; iterator < count; iterator++) 
		{
			total += Integer.toString(list[iterator]);
			if(iterator != count-1)
				total += " ";
		}
		return total;
	}
	
	//search for the first instance of n in list, else return -1
	public int search(int n)
	{
		int index = -1;
		for(int iterator = count-1; iterator>=0; iterator--)
		{
			if(list[iterator]==n)
			{
				index = iterator;
			}
		}
		return index;
	}
}