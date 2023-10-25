public class SeniorAge implements Age{
    private final int age;

    public SeniorAge(int age) {
        this.age = age;
    }

    @Override
    public String describe() {
        return "Senior Citizen: In the sixth age, the senior citizen is " + age + " years old, enjoying retirement.";
    }

}
