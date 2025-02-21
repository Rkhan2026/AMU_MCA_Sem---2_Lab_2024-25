package week_6;

interface Interface1 {
    void method1();
}

interface Interface2 {
    void method2();
}

class MyClass implements Interface1, Interface2 {
    @Override
    public void method1() {
        System.out.println("Implementation Of Method1");
    }

    @Override
    public void method2() {
        System.out.println("Implementation Of Method2");
    }
}

public class Problem2 {
	public static void main(String[] args) {
            // Create an instance of child class
            MyClass obj = new MyClass();
            // Call methods from both interfaces
            obj.method1();
            obj.method2();
	}
}
