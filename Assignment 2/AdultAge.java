public class AdultAge implements Age{
    private final int age;

    public AdultAge(int age) {
        this.age = age;
    }

    @Override
    public String describe() {
        return "Adult: In the fourth age, the adult is " + age + " years old, working and contributing to society.";
    }

}
