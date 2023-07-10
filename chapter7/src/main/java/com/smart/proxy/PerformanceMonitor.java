package com.smart.proxy;

public class PerformanceMonitor {

	/**
	 * 保存与调用线程相关的性能监视信息
	 */
	private static ThreadLocal<MethodPerformance> performanceRecord = new ThreadLocal<MethodPerformance>();

	public static void begin(String method) {
		System.out.println("begin monitor...");
		MethodPerformance mp = performanceRecord.get();
		if (mp == null) {
			mp = new MethodPerformance(method);
			performanceRecord.set(mp);
		} else {
		    mp.reset(method);	
		}
	}

	public static void end() {
		System.out.println("end monitor...");
		MethodPerformance mp = performanceRecord.get();
		mp.printPerformance();
	}
}
