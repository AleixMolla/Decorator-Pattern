public class ScientologyExtra extends ExtrasDecorator{

    final double PRICE = 500;
    Room room;

    public ScientologyExtra(Room room) {
        this.room = room;
    }

    public double cost(){
        return room.cost() + PRICE;
    }

    public double taxCost() {
        return room.taxCost() + PRICE*EXTRATAX;
    }

    public double gratuity(){
        return room.gratuity()+(PRICE*EXTRATAX*GRATUITY-PRICE);
    }
}
