package case3;

public class Principal {

	public static void main(String[] args) throws InterruptedException {		
		
		Thread t1 = new Thread(new ProgramaA());
		t1.setPriority(Thread.MAX_PRIORITY);
		
		t1.start();
		
		Thread t2 = new Thread(new ProgramaB());
		t2.setPriority(Thread.NORM_PRIORITY);
		
		t2.start();
		
		Thread t3 = new Thread(new ProgramaC());
		t3.setPriority(Thread.MIN_PRIORITY);
		
		t3.start();
		
	}
}
