package tst;

public class Animal implements Talking {
    private String name;
    public int age;
    public Animal(String name,int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void say() {
        System.out.println(name + " Animal saying");
    }
}
