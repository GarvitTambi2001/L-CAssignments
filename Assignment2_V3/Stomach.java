class Stomach implements DigestiveOrgan {

    @Override
    public void working() {
        System.out.println("Working :- The stomach mixes and grinds food " +
                "with digestive juices to form a liquid called chyme. The stomach also " +
                "secretes enzymes that help break down proteins.");
    }

    @Override
    public void describeStructure() {
        System.out.println("Description :- The stomach is a muscular sac.");
        System.out.println();
    }

}

