class SmallIntestine extends DigestiveOrgan {
    public SmallIntestine() {
        super("Small Intestine");
    }

    @Override
    public void processFood(String foodName) {
        System.out.println(getName() + " is absorbing nutrients from digested " + foodName + ".");
    }
}