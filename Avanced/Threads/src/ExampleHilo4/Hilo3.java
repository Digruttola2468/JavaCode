package ExampleHilo4;

public class Hilo3 extends Thread{
	
	@Override
	public void run() {
		for(int i=0 ; i<=5 ; i++) {
			System.out.print("A");
			
			try {
				this.sleep(1025);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}
