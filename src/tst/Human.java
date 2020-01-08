package tst;

public class Human extends Animal {
    private String country;
    private int age;
    public Human(String name, int age, String country) {
        super(name,age);
        this.country = country;
    }

    @Override
    public void say() {
        System.out.println("This is human from " + country);
    }
}
