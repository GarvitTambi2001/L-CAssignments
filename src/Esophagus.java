class Esophagus implements DigestiveOrgan {

    @Override
    public void working() {
        System.out.println("Working :- The esophagus uses rhythmic contractions " +
                "to move food down to the stomach.");
    }

    @Override
    public void describeStructure() {
        System.out.println("Description :- The esophagus is a muscular tube that connects " +
                "the mouth to the stomach.");
        System.out.println();
    }

}
