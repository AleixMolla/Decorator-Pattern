public abstract class Room {

    final double ROOMTAX = 1.16;
    final double ROOMGRATUITY = 1.00;

    abstract double cost();

    abstract double taxCost();

    abstract double gratuityDiscount();
}
