package com.java.recruitme.duplicateStringProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class UniqueList {
  public static List<String> deDuplicate(List<String> list) {
	
	  if(list.isEmpty())
		  return Collections.emptyList();
	  /*
	  Iterator<String> iterator = list.iterator();
	  while(iterator.hasNext()) {
		  String str = iterator.next();
		  
	  }
	  */
	  List<String> newlist = new ArrayList<String>();
	  for (int i = 0; i < list.size(); i++) {
		if(!newlist.contains(list.get(i)))
			newlist.add(list.get(i));
	  }
	  
    return newlist;
  }
}
