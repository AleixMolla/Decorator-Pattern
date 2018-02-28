public abstract class Room {

    final protected double ROOMTAX = 1.16;
    final protected double ROOMGRATUITY = 1.00;

    abstract double cost();

    abstract double taxCost();

    abstract double gratuity();
}
