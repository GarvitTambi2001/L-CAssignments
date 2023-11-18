class Mouth {
    private boolean isOpen;

    public void openMouth() {

        isOpen = true;
        System.out.println("Mouth is open.");

    }

    public void closeMouth() {
        isOpen = false;
        System.out.println("Mouth is closed.");
        DigestiveOrgan[] organs = {new Esophagus(), new Stomach(), new SmallIntestine(), new LargeIntestine(), new Rectum(), new Anus()};
        for (DigestiveOrgan organ : organs) {
            organ.working();
            organ.describeStructure();
        }
    }

    public void chew() {
        System.out.println("Chewing food with the mouth.");
        DigestiveOrgan[] organs = {new Teeth("Incisors"), new Teeth("Canines"), new Teeth("Molars"), new Tongue(10000), new SalivaryGlands("front of and below just ear")};
        for (DigestiveOrgan organ : organs) {
            organ.working();
            organ.describeStructure();
        }
    }
}