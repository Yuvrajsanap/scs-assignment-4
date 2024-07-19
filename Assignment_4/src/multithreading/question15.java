package multithreading;

public class question15 {
	public static void main(String[] args) {
		question15 obj = new question15();
		obj = null;
		System.gc();
		System.out.println("Garbage Collection triggered");
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("finalize method called");
	}
}
