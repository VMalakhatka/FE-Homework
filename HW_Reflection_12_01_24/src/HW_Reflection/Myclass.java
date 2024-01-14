package HW_Reflection;

class myClass {
    private int intValue;
    private double doubleValue;
    private String stringValue;
    private boolean booleanValue;

    public myClass(int intValue, double doubleValue, String stringValue, boolean booleanValue) {
        this.intValue = intValue;
        this.doubleValue = doubleValue;
        this.stringValue = stringValue;
        this.booleanValue = booleanValue;
    }

    public void method1() {
        System.out.println("Метод 1 вызван");
    }

    public void method2() {
        System.out.println("Метод 2 вызван");
    }

    public void method3() {
        System.out.println("Метод 3 вызван");
    }

    public void method4() {System.out.println("Метод 4 вызван");}

    public void method5() {
        System.out.println("Метод 5 вызван");
    }

    public void method6() {
        System.out.println("Метод 6 вызван");
    }

    public void method7() {
        System.out.println("Метод 7 вызван");
    }

    public void method8() {
        System.out.println("Метод 8 вызван");
    }

    public void method9() {
        System.out.println("Метод 9 вызван");
    }

    public void method10() {
        System.out.println("Метод 10 вызван");
    }

    @Override
    public String toString() {
        return "myClass{" +
                "intValue=" + intValue +
                ", doubleValue=" + doubleValue +
                ", stringValue='" + stringValue + '\'' +
                ", booleanValue=" + booleanValue +
                '}';
    }

    public void nowIs(){
        System.out.println(this.toString());
    }
}
