package models;

import java.util.Objects;

public class Pants extends Product implements Discountable {
    private int waist;

    public Pants(int waist, double price, String color, String brand) {
        super(price, color, brand);
        this.waist = waist;
    }

    public Pants(Pants source) {
        super(source);
        this.waist = source.waist;

    }

    public int getWaist() {
        return this.waist;
    }

    public void setWaist(int waist) {
        this.waist = waist;
    }

    @Override
    public void fold() {
        System.out.println("Hold pant upright");
        System.out.println("Fold 1 leg over the other");
        System.out.println("Fold pant from bottom in thirds");
    }

    @Override
    public void discount() {
        super.setPrice(super.getPrice() / 2);
    }

    /*
     * // it must be sorted in price
     * 
     * @Override
     * public int compareTo(Pants specifiedObject) { // recieves a specified object
     * // we need to compare the price of current object with specified object
     * return (int) Math.round(super.getPrice() - specifiedObject.getPrice());
     * }
     */

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pants)) {
            return false;
        }
        Pants pants = (Pants) o;
        return this.waist == pants.waist
                && super.getBrand().equals(pants.getBrand())
                && super.getPrice() == pants.getPrice()
                && super.getColor().equals(pants.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(waist, super.getBrand(), super.getPrice(), super.getColor());
    }

    @Override
    public String toString() {
        return "Pants [waist=" + waist + super.toString();
    }

}
