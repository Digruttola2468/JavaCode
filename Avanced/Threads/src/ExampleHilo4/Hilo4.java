package ExampleHilo4;

public class Hilo4 extends Thread{
	
	@Override
	public void run() {
		for(int i=0 ; i<=5 ; i++) {
			System.out.println("N");
			
			try {
				this.sleep(1035);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}
