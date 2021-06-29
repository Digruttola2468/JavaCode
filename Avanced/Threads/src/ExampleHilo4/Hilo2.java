package ExampleHilo4;

public class Hilo2 extends Thread{
	
	@Override
	public void run() {
		for(int i=0 ; i<=5 ; i++) {
			System.out.print("V");
			
			try {
				this.sleep(1015);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}
