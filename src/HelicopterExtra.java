public class HelicopterExtra extends ExtrasDecorator{

    final double PRICE = 200;
    Room room;

    public HelicopterExtra(Room room) {
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
