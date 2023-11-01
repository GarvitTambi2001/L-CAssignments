abstract class DigestiveOrgan {

    private final String name;

    public DigestiveOrgan(String name) {
        this.name = name;
    }

    @SuppressWarnings("unused")
    public abstract void processFood(String foodName);

    public String getName() {
        return name;
    }

}
