public class Car {
    public double length;
    public double width;
    public double height;
    public Wheel[] wheel;
    public Engine engine;
    public double msrp;
    
    public double getLength() {
        return length;
    }
    public double getWidth() {
        return width;
    }
    public double getHeight() {
        return height;
    }
    public Wheel[] getWheel(){
        return wheel;
    }
    public Engine getEngine() {
        return engine;
    }
    public double getMsrp() {
        return msrp;
    }
    public void setLength(double length) {
        this.length = length;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public void setWheel(int size, int pressure, boolean winterReady) {
       // this.size = size;
    }
    public void setEngine() {
        
    }
    public void setMsrp(double msrp) {
        this.msrp = msrp;
    }
}
