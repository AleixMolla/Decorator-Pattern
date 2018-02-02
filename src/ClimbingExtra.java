public class ClimbingExtra extends ExtrasDecorator{

    final double PRICE = 60;
    Room room;

    public ClimbingExtra(Room room) {
        this.room = room;
    }

    public double cost(){
        return room.cost() + PRICE;
    }

    public double taxCost() {
        return room.taxCost() + (PRICE*GRATUITY)*EXTRATAX;
    }

    public double gratuityDiscount(){
        return room.gratuityDiscount()+(PRICE-(PRICE*GRATUITY));
    }
}
