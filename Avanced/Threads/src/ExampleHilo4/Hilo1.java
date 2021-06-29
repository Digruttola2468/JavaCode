package ExampleHilo4;

public class Hilo1 extends Thread{
	
	@Override
	public void run() {
		for(int i=0 ; i<=5 ; i++) {
			System.out.print(i + " I");
			
			try {
				this.sleep(1005);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}
