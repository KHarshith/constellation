

public class HashTable {
	private Entry[] table;
	private int capacity;
	private int size;
	public HashTable()
	{
		capacity = 101;
		table = new Entry[101];
		size =0;
	}
	public HashTable(int initCap)
	{
		table = new Entry[initCap];
		capacity = initCap;
		size = 0;
	}
	public Object put(Object key, Object value)
	{
		if(size == capacity)
		{
			return null;
		}
		
		int hashCode = key.hashCode();
		if(hashCode < 0)
		{
			hashCode = -1 * hashCode;
		}
		//System.out.println("Hash code for " + key + " is " + hashCode);
		Entry entry = new Entry(key, value);
		int index = hashCode % capacity;
		//System.out.println(key + "\t" + index);
	    
				
		//Find the next available open slot to store the the element
		int searchIndex = index;
		boolean storedEntry = false;
		while (storedEntry == false)
		{		
			if (searchIndex == capacity)
			{
				searchIndex = 0;
			}
			Entry searchEntry = table[searchIndex];
			if(searchEntry == null || searchEntry.isRemove() == true)
			{
				table[searchIndex] = entry;
				storedEntry = true;
			}
			else if (searchEntry.getKey().equals(key))
			{
				table[searchIndex] = entry;
				return searchEntry.getValue();
			}
			searchIndex++;
		}
		
		//Check if the the key exists till the end of the table 
		while (searchIndex < capacity)
		{
			
			Entry searchEntry = table[searchIndex];
			if (searchEntry != null && searchEntry.isRemove() == false && searchEntry.getKey().equals(key))
			{
				searchEntry.setRemoved(true);
				return searchEntry.getValue();
			}
			searchIndex++;
		}
		
		//Check if the element exists from the begenning of the table
		searchIndex = 0;
		while (searchIndex < index)
		{
			Entry searchEntry = table[searchIndex];
			if (searchEntry != null && searchEntry.isRemove() == false && searchEntry.getKey().equals(key))
			{
				searchEntry.setRemoved(true);
				return searchEntry.getValue();
			}
			searchIndex++;
		}
		size++;
		return null;		
	}
	
	public Object get (Object key)
	{
		Entry returnValue = null;
		int hashCode = key.hashCode();
		//System.out.println("Hash code for " + key + " is " + hashCode);
		
		if(hashCode < 0)
		{
			hashCode = -1 * hashCode;
		}
		int index = hashCode % capacity;
		returnValue = table[index];
		//System.out.println("The value of index is " + index);
		if(returnValue != null)
		{
			if(returnValue.isRemove() == false && returnValue.getKey().equals(key))
			{
				return returnValue.getValue();
			}
		}
		for ( int i = 0; i< capacity; i++)
		{
			returnValue = table[i];
			if(returnValue != null)
			{
				if(returnValue.isRemove() == false && returnValue.getKey().equals(key))
				{
					return returnValue.getValue();
				}
			}
			
		}
		return null;
	}
	public String toString()
	{
		String returnValue = "";
		for(int i = 0; i<capacity; i++)
		{
			String indexValue = i + "";
			if(indexValue.length() == 1)
			{
				indexValue = "00" + indexValue;
			}
			else if(indexValue.length() == 2)
			{
				indexValue = "0" + indexValue;
			}
			if(returnValue.length() != 0)
			{
				returnValue =returnValue + "\n" ;
			}
			
			Entry entry = table[i];
			if(entry != null)
			{
				
				
				returnValue =returnValue  + indexValue + " : "+ entry.toString();
			}
			else
			{
				returnValue = returnValue  + indexValue;
			}
			
		}
		return returnValue;
	}
	public Object remove(Object key)
	{
		Entry removeValue = null;
		int hashCode = key.hashCode();
		if(hashCode < 0)
		{
			hashCode = -1 * hashCode;
		}
		int index = hashCode % capacity;
		removeValue  = table[index];
		
		
		if(removeValue != null)
		{
			if(removeValue.isRemove() == false && removeValue.getKey().equals(key))
			{
				removeValue.setRemoved(true);
				size--;
				return removeValue.getValue();
			}
		}
		
		
		for(int i =0; i < capacity; i++)
		{
			
			removeValue = table[i];
			if(removeValue != null)
			{
				if(removeValue.isRemove()== false && removeValue.getKey().equals(key))
				{

					removeValue.setRemoved(true);
					size--;
					return removeValue.getValue();
				}
			}
			
		}
		return null;
		
	}
	
	
	private class Entry
	{
		private Object key;
		private Object value;
		private boolean removed;
		public Entry()
		{
			removed  = false;
		}
		public Entry(Object key, Object value)
		{
			this.key = key;
			this.value = value;
			this.removed = false;
		}
		public boolean isRemove()
		{
			return removed;
		}
		public void setRemoved(boolean removed)
		{
			this.removed = removed;
		}
		public String toString()
		{
			if(removed == true)
			{
				return "dummy";
			}
			return key+ " " + value; 
		}
		public Object getKey()
		{
			return key;
		}
		public Object getValue()
		{
			return value;
		}
	}
	
}
