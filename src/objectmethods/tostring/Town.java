package objectmethods.tostring;

class Town {

    static void main() {
        Town town = new Town("Варашитского", 23);
        System.out.println(town);
    }

    String street;
    int number;

    public Town(String street, int number) {
        this.street = street;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Town{"
                + "street='" + street + "', "
                + "number='" + number
                + "'}";
    }
}
