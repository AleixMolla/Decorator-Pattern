public class InteriorRoom extends Room {

    final double PRICE = 1000;

    public double cost() {
        return PRICE;
    }

    public double taxCost() {
        return PRICE*ROOMTAX;
    }

    public double gratuity(){
        return PRICE*ROOMGRATUITY-PRICE;
    }
}
