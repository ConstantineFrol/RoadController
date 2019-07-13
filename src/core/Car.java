package core;

public class Car {
    // String number
    public String number;
    // int height
    public int height;
    // double weight
    public double weight;
    // boolean hasVehicle;
    public boolean hasVehicle;
    // boolean isSpecial
    public boolean isSpecial;

    public void setNumber(String number) {
        this.number = number;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHasVehicle(boolean hasVehicle) {
        this.hasVehicle = hasVehicle;
    }

    public void setSpecial(boolean special) {
        isSpecial = special;
    }

    public String getNumber() {
        return number;
    }

    public int getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isVehicle() {
        return hasVehicle;
    }

    public boolean isSpecial() {
        return isSpecial;
    }

    public String toString() {
        // String special + тернарный оператор
        String special = isSpecial ? "СПЕЦТРАНСПОРТ " : "";
        return "\n=========================================\n" +
                special + "Автомобиль с номером " + number +
                ":\n\tВысота: " + height + " мм\n\tМасса: " + weight + " кг";
    }
}