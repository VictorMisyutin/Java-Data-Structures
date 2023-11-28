package Lab14;

public class Square extends Shape {
    private double side;
    
    // constructor
    public Square( double s )
    {
        side = ( s < 0 ? 0 : s );
        shapeName = "Square";
    }

    // return the area of a Square
    public double getArea()
    {
        return side * side;
    }

    // return the perimeter of a Square
    public double getPerimeter(){
        return(side*4);
    }

    // return the side of a Square
    public double getSide(){
        return side;
    }

    public double getLength() {
        return getSide();
    }

    public double getWidth() {
        return getSide();
    }
} // end class Square