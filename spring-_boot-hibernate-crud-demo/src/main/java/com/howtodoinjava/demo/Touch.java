
// Run a class file in java
package com.howtodoinjava.demo;

import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.nio.file.Files;
import java.util.stream.Stream;

class Touch {
	
	
	private class ReportDetail {
		private Map<String, Object> agent;

		public Map<String, Object> getAgent() {
			return agent;
		}

		public void setAgent(Map<String, Object> agent) {
			this.agent = agent;
		}
	
	}
	
	public static void main(String[] args) {
		
		
		List<Integer> data = new ArrayList();

		for( int i=1; i<=350; i++) {
			data.add(i);	
		}
		
		int start = 0, end = 0, psize = 900;  
		while( end <= data.size()-1 ) {
//			start = ;
			end = (start+1)*psize <=data.size()?(start+1)*psize:data.size() ;


			System.out.println( data.subList(start* psize, end) );
			start++;
		}
		
		
		/**
		long startTime = System.currentTimeMillis();
		String dirname = args[0];
		String outpath = args[1];
		
		Path start = Paths.get(dirname);
		try (Stream<Path> stream = Files.walk(start, Integer.MAX_VALUE)) {
			Set<String> collect = stream
					.map(f->f.toString() )
					.filter(f -> f.endsWith("pdf") || f.endsWith("xls") || f.endsWith("xlsx"))
					.collect(Collectors.toSet());
			
			 PrintWriter pw = new PrintWriter(new FileOutputStream(outpath));
			 collect.parallelStream().forEach( f -> pw.println(f.split(".")[0]));
			 pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		long endTime = System.currentTimeMillis();
//		 for(int i=0; i<10; i++){
//		      new Thread("" + i){
//		        public void run(){
//		          System.out.println("Thread: " + getName() + " running");
//		        }
//		      }.start();
//		    }
		System.out.println("Time to execute: " + (endTime - startTime)/1000L );
*/
	}
}
