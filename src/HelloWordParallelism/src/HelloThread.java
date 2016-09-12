
public class HelloThread extends java.lang.Thread {
	int threadNum;
	public HelloThread(int i){
		threadNum = i;
	}
	public void run(){
		for (int j = 0; j < 100000; j++) {
			System.out.println("Thread "+threadNum+" says hi");
		}
	}
}
