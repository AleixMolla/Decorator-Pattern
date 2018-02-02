public class BeverageExtra extends ExtrasDecorator {

    final double PRICE = 700;
    Room room;

    public BeverageExtra(Room room) {
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
