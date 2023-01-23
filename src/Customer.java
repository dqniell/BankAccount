public class Customer {
    private String name;
    private int pin;

    //creates a customer object
    public Customer(String name, int pin){
        this.name = name;
        this.pin = pin;
    }

    //getter methods
    public String getName() {
        return name;
    }

    public int getPin(){
        return pin;
    }

    //setter methods
    public void updatePin(int newPin){
        pin = newPin;
    }

    //allows check if pin is entered correctly
    public boolean pinCheck(int pin){
        if(pin == getPin()){
            return true;
        } else {
            return false;
        }
    }





}
