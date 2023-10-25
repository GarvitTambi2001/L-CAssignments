public class AdolescentAge implements Age{
    private final int age;

    public AdolescentAge(int age) {
        this.age = age;
    }

    @Override
    public String describe() {
        return "Teenager: In the third age, the teenager is " + age + " years old and experiences the joys of adolescence.";
    }
}
