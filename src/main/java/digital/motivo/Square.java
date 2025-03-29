package digital.motivo;

public class Square {    
    private int value;
    private boolean fixed; 

    public Square() {
        this.value = 0;
        this.fixed = false;
    }
    
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isFixed() {
        return fixed;
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }

    public void setFixedValue(int value) {
        this.value =value;
        this.fixed = true;
    }

    @Override
    public String toString() {        
        return "0";
    }
}
