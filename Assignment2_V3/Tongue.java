class Tongue implements DigestiveOrgan {
    private final int tasteBudsCount;

    public Tongue(int tasteBudsCount) {
        this.tasteBudsCount = tasteBudsCount;
    }

    @Override
    public void working() {
        System.out.println("Working  :- The tongue manipulates food in the mouth and contains " +
                tasteBudsCount + " taste buds.");
    }

    @Override
    public void describeStructure() {
        System.out.println("Description :- The tongue is a muscular organ " +
                "covered in taste buds, which are responsible for detecting flavors.");
        System.out.println();
    }
}
