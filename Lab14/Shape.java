package Lab14;
public abstract class Shape
{
    protected String shapeName;
    // abstract getArea method must be implemented by concrete subclasses
    
    public abstract double getArea();
    
    public abstract double getPerimeter();
    
    public abstract double getSide();

    public abstract double getLength();

    public abstract double getWidth();

    public String getName()
    {
        return shapeName;
    }
} // end class Shape
