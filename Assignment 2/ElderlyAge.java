public class ElderlyAge implements Age{
    private final int age;

    public ElderlyAge(int age) {
        this.age = age;
    }

    @Override
    public String describe() {
        return "Elderly: In the seventh age, the elderly person is " + age + " years old, reflecting on life.";
    }

}
