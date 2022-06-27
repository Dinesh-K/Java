package com.explore.java.general;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface disableSysOut {

}

public class CustomAnnotation {

	public static void main(String[] args) {
		disableSysouts();// uses reflections to disable the sysout
		methodWithSysOuts();
	}

	private static void disableSysouts() {
		for(Method method : CustomAnnotation.class.getDeclaredMethods()) {		
			if(method.isAnnotationPresent(disableSysOut.class)) {
				System.setOut(new PrintStream( 
							  new OutputStream() {								
								@Override
								public void write(int b) throws IOException {
									//Override with dummy method to prevent the sysouts.									
								}
							}));				
			}
		}
	}
	@disableSysOut
	private static void methodWithSysOuts() {
		System.out.println("Method Name : methodWithSysOuts");		
	}

}
