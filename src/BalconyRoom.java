public class BalconyRoom extends Room {

    final double PRICE = 2000;

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
