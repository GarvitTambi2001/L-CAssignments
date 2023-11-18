class Teeth implements DigestiveOrgan {
    private final String type;

    public Teeth(String type) {
        this.type = type;
    }

    @Override
    public void working() {
        System.out.println("Working :- " + type + " teeth are used for chewing.");
    }

    @Override
    public void describeStructure() {
        System.out.println("Description :- " + type + " teeth have a hard enamel surface.");
        System.out.println();
    }
}