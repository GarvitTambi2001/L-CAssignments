class Stomach extends DigestiveOrgan {
    public Stomach() {
        super("Stomach");
    }

    @Override
    public void processFood(String foodName) {
        System.out.println(getName() + " is digesting " + foodName + ".");
    }
}