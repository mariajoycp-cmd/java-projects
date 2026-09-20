class MethodOverloadingAndStaticVariable {
    int a = 10;
    int b = 20;
    int c;
    static int count;


    MethodOverloadingAndStaticVariable() {
        System.out.println("Inside default Constructor of MethodOverloadingAndStaticVariable class");
        count++;
    }


    MethodOverloadingAndStaticVariable(int p, int q) {
        a = p;
        b = q;
        System.out.println("Inside parameterized Constructor of MethodOverloadingAndStaticVariable class");
        count++;
    }

  
    void classMethod() {
        c = a + b;
        System.out.println("Sum: " + c);
    }


    void display() {
        System.out.println("The value of c: " + c);
    }

    static void showCount() {
        System.out.println("Count: " + count);
    }

    public static void main(String[] args) {

        MethodOverloadingAndStaticVariable o1 = new MethodOverloadingAndStaticVariable();
        o1.classMethod();
        o1.display();

        MethodOverloadingAndStaticVariable o2 = new MethodOverloadingAndStaticVariable(30, 40);
        o2.classMethod();
        o2.display();

        MethodOverloadingAndStaticVariable.showCount();
    }
}