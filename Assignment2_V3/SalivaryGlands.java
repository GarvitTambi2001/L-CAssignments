class SalivaryGlands implements DigestiveOrgan {
    private final String location;

    public SalivaryGlands(String location) {
        this.location = location;
    }

    @Override
    public void working() {
        System.out.println("Working :- Salivary glands, located in the " + location +
                ", produce saliva to moisten food and start digesting carbohydrates.");
    }

    @Override
    public void describeStructure() {
        System.out.println("Description :- Salivary glands are composed of various " +
                "glands located in different parts of the mouth.");
        System.out.println();
    }
}
