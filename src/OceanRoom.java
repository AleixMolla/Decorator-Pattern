public class OceanRoom extends Room {

    final double PRICE = 1500;

    public double cost(){
        return PRICE;
    }

    public double taxCost() {
        return PRICE*ROOMTAX;
    }

    public double gratuity(){
        return PRICE*ROOMGRATUITY-PRICE;
    }
}
