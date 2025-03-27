//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Fix 1: Renamed variable from `humanIMB` to `person` for clarity (Line 8)
        HumanIMB person = new HumanIMB(80, 1.52);
        System.out.println(person.Result());
    }
}

class HumanIMB {
    // Fix 2: Renamed `W` to `weight` and `H` to `height` for better readability (Lines 13, 14)
    public double weight; 
    public double height; 
    // Fix 3: Removed `static` 
    private double imb;

    public HumanIMB(double weight, double height) {
        // Fix 4: `height != 0` 
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be greater than 0");
        }
        this.weight = weight;
        this.height = height;
        this.imb = weight / (height * height);
    }

    public double takeWeight() { // Renamed
        return weight;
    }

    // Fix 5: Added validation for negative
    public void putWeight(double weight) { // Renamed from `putW`
        if (weight < 0) {
            throw new IllegalArgumentException("Weight cannot be negative");
        }
        this.weight = weight;
        this.imb = weight / (height * height);
    }

    public double takeHeight() { // Renamed from `takeH` 
        return height;
    }

    // Fix 6: Added validation for `height <= 0` in `putH`
    public void putHeight(double height) { // Renamed from `putH`
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be greater than 0");
        }
        this.height = height;
        this.imb = weight / (height * height);
    }

    // Fix 7: Renamed to `getImb` and removed `static` 
    public double getImb() {
        return imb;
    }

    public static String Result() {
        // Fix 8: Renamed `string` to `result` 
        String result = null;
        // Fix 9: Replaced `&` with `&&` 
        if (imb >= 18.5 && imb < 25) {
            result = "Norm";
        }
        // Fix 10: Replaced `&` with `&&` 
        if (imb >= 25 && imb < 30) {
            result = "Warning!";
        }
        // Fix 11
        if (imb >= 30) { // No upper bound 
            result = "Fat";
        }
        if (imb < 18.5) {
            result = "Deficit";
        }
        // Fix 12:  avoid null 
        return result != null ? result : "Unknown"; 
    }
}
