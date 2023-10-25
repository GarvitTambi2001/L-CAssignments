public class SchoolAge implements Age{
    private final int age;

    public SchoolAge(int age) {
        this.age = age;
    }

    @Override
    public String describe() {
        return "Child: In the second age, the child is " + age + " years old and goes to school.";
    }
}
