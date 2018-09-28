package com.java.recruitme.comparator;

public class ComparatorImpl<T> implements Comparator<T> {

	@SuppressWarnings("unchecked")
	public T findGreater(T parameterOne, T parameterTwo) throws Exception {
		
		
		/*if (parameterOne instanceof Integer && parameterTwo instanceof Integer) {
			return (T) compareInt(parameterOne.getClass(), parameterTwo.getClass());
		}
		if (parameterOne instanceof Double && parameterTwo instanceof Double) {
			return (T) compare(parameterOne.getClass().getSimpleName(), parameterTwo.getClass().getSimpleName());
		}
		if (parameterOne instanceof String && parameterTwo instanceof String) {
			return (T) compare(parameterOne.getClass().getSimpleName(), parameterTwo.getClass().getSimpleName());
		}
		if (parameterOne instanceof Character && parameterTwo instanceof Character) {
			return (T) compare(parameterOne.getClass().getSimpleName(), parameterTwo.getClass().getSimpleName());
		}*/

		throw new IllegalArgumentException();
	}

//	private int compareInt(Class<? extends Object> class1, Class<? extends Object> class2) {
//		int k = (class1 > class2) ? class1 : (class1 == class2) ? class1 : class2;
//		System.out.println(k);
//		return k;
//	}

	private double compare(Double i1, Double i2) {
		return (i1 > i2) ? i1 : (i1 == i2) ? i1 : i2;
	}

	private String compare(String i1, String i2) {
		return (i1.hashCode() > i2.hashCode()) ? i1 : (i1 == i2) ? i1 : i2;
	}

	private char compare(Character i1, Character i2) {
		return (i1.hashCode() > i2.hashCode()) ? i1 : (i1 == i2) ? i1 : i2;
	}
	
	public static void main(String[] args) {
		Comparator comparator = new ComparatorImpl();
		try {
			comparator.findGreater(10, 10);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
