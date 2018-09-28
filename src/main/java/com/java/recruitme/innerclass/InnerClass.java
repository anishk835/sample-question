package com.java.recruitme.innerclass;

import java.security.Permission;

public class InnerClass {

	public static void main(String[] args) {
		DoNotTerminate.forBidExit();
		
		InnerClass.Inner.Private private1 = new InnerClass.Inner().new Private();
		String val = private1.powerOf2(0);
		System.out.println("The value of val is - " + val);
	}

	static class Inner {
		private class Private {
			private String powerOf2(int num) {
				return ((num & num - 1) == 0) ? "power of 2" : "not a power of 2";
			}
		}
	}
}

class DoNotTerminate {

	public static class ExitTrappedException extends Exception {

		private static final long serialVersionUID = 1L;

	}

	public static void forBidExit() {
		SecurityManager securityManager = new SecurityManager() {
			@Override
			public void checkPermission(Permission perm)  {
				System.out.println("get name of permission - " + perm.getName());
				if (perm.getName().contains("exitVM")) {
					System.out.println(" Exxception throwing is not permissible ");
					//throw new ExitTrappedException();
				}
			}
		};
		System.setSecurityManager(securityManager);

	}

}