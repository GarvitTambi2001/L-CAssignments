public class MiddleAge implements Age{
    private final int age;

    public MiddleAge(int age) {
        this.age = age;
    }

    @Override
    public String describe() {
        return "Middle-Aged: In the fifth age, the individual is " + age + " years old, and might experience a midlife crisis.";
    }

}
