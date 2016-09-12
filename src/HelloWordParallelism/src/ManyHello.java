import java.util.Scanner;


public class ManyHello {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("press 1 for sequencial and 2 for parallel");
		int type = sc.nextInt();
		sc.close();
		
		if (type==1){
			ManyHello.printSeq();
		}else{
			ManyHello.printPar();
		}
		
	}
	
	public static void printSeq(){
		System.out.println("Sequential");
//		Start timer
		long startTime = System.currentTimeMillis();
		
		//print hello world
		HelloThread h = new HelloThread(1);
		h.run();
		h.run();
		h.run();
		h.run();
//		end timer
		long endTime = System.currentTimeMillis();
		long time = endTime-startTime;
		System.out.println("Time taken: "+ time+"\n\n");
	}
	public static void printPar(){
		System.out.println("Parallel");
//		Start timer
		long startTime = System.currentTimeMillis();
		
		//print hello world
		HelloThread[] threads = new HelloThread[4];
		for (int i = 0; i < threads.length; i++) {
			threads[i]= new HelloThread(i+1);
			threads[i].start();
		}
		for (int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
//		end timer
		long endTime = System.currentTimeMillis();
		long time = endTime-startTime;
		System.out.println("Time taken: "+ time+"\n\n");
	}
}
