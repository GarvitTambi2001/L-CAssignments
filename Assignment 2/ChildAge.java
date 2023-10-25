public class ChildAge implements Age{
    private final int age;

    public ChildAge(int age) {
        this.age = age;
    }

    public String describe() {
        return age + " is Infant: In the first age";
    }

}
