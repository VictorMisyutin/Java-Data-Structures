package Lab14;

public class Rectangle extends Shape {
    private double length, width;
    
    // constructor
    public Rectangle( double s1, double s2 )
    {
        length = ( s1 < 0 ? 0 : s1 );
        width = ( s2 < 0 ? 0 : s2 );
        shapeName = "Rectangle";
    }
    
    // return the area of a Rectangle
    public double getArea()
    {
        return length * width;
    }

    // return the perimeter of a Rectangle
    public double getPerimeter(){
        return (length + width) * 2;
    }

    // return the length of a Rectangle
    public double getLength(){
        return length;
    }

    // return the width of a Rectangle
    public double getWidth(){
        return width;
    }

    public double getSide() {
        return -1;
    }

} // end class Rectangle