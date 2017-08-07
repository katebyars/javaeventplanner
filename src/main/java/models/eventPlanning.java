package models;


public class eventPlanning {
    public String getBeverage() {
        return beverage;
    }

    private String beverage;

    public String getFood() {
        return food;
    }

    private String food;

    public String getEntertainment() {
        return entertainment;
    }

    private String entertainment;

    public int getGuestCount() {
        return guestCount;
    }

    private int guestCount;
    public int totalPrice = 0;


    public eventPlanning (String beverage, String food, String entertainment, int guestCount) {
        this.beverage = beverage;
        this.food = food;
        this.entertainment = entertainment;
        this.guestCount = guestCount;
    }

    public int priceCalculation (String beverage, String food, String entertainment, int guestCount) {
        if (beverage.equals("Kombucha")){
            totalPrice += guestCount*5;
        } else if (beverage.equals("Coffee")){
            totalPrice += guestCount*3;
        } else if (beverage.equals("Tea")){
            totalPrice += guestCount*2;
        } else {
            totalPrice += guestCount*1;
        }
        if (food.equals("Hamburgers")){
            totalPrice += guestCount*7;
        } else if (food.equals("Asian Food")) {
            totalPrice += guestCount*9;
        } else if (food.equals("Indian Buffet")){
            totalPrice += guestCount*11;
        } else {
            totalPrice += guestCount*5;
        }
        if (entertainment.equals("DJ")){
            totalPrice += 1000;
        } else if(entertainment.equals("Live Band")) {
            totalPrice += 2500;
        } else if(entertainment.equals("Fire Eater")){
            totalPrice += 700;
        } else {
            totalPrice += 10000;
        }
        return totalPrice;
    }
}
