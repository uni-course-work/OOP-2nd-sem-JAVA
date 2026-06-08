class Triangle extends Shape {
    private double base;
    private double perpendicular;
    private double hypotenuse;

    public Triangle (double base, double perpendicular, double hypotenuse) {
        this.validateSides(perpendicular, base, hypotenuse);
        this.base  = base;
        this.perpendicular = perpendicular;
        this.hypotenuse = hypotenuse;
    }

    @Override
    public double area () {
        return 0.5 * this.base * this.perpendicular;
    }

    @Override
    public double perimeter () {
        return this.base + this.perpendicular + this.hypotenuse;
    }

    private void validateSides (double a, double b, double c) {
        if (a + b > c) return;
        if (a + c > b) return;
        if (b + c > a) return;
        throw new IllegalArgumentException("Invalid sides for a triangle: " + this.base + " " + this.perpendicular + " " + this.hypotenuse);        
    }

    @Override
    public String toString () {
        return "Triangle with Base: " + this.base + ", Perpendicular: " + this.perpendicular + " and Hypotenuse: " + this.hypotenuse;
    }
}