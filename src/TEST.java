public class TEST {

    public static void main(String[] args) {
        Room room = new SuiteRoom();
        System.out.println(room.cost());
        System.out.println(room.taxCost());

        Room room2 = new InteriorRoom();
        room2 = new HelicopterExtra(room2);
        room2 = new KlondikeExtra(room2);
        room2 = new ClimbingExtra(room2);
        System.out.println("TOTAL = "+room2.cost());
        System.out.println("TOTAL + TAX = "+room2.taxCost());
        System.out.println("TOTAL GRATUITY = "+room2.gratuity());
        System.out.println("TAX = "+(room2.taxCost()-room2.cost()));
    }
}
