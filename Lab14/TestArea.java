package Lab14;

public class TestArea
{
    public static void main( String args[] ) {
        // double side = 5.0 ; double length = 10.0; double width = 12.0;
        int size = 5;
        Shape arrayOfShapes[] = new Shape[size];
        // fill in your array to reference five various shapes from your
        // child classes. Include differing data points (i.e., length,
        // width, etc) for each object
        Square square1 = new Square(3);
        Square square2 = new Square(5);
        Rectangle rectangle1 = new Rectangle(4, 6);
        Rectangle rectangle2 = new Rectangle(5, 3);
        Rectangle rectangle3 = new Rectangle(7, 6);
        
        arrayOfShapes[0] = square1;
        arrayOfShapes[1] = rectangle1;
        arrayOfShapes[2] = rectangle2;
        arrayOfShapes[3] = square2;
        arrayOfShapes[4] = rectangle3;


        /* create a for - enhanced loop to iterate over each
        arrayofShapes to display the shape name and associated area for
        each object*/

        int rectangleCount = 0;
        System.out.printf("%-14s %-10s %-10s %-10s %-10s %-10s\n", "Shape", "Area", "Perimeter", "Length", "Width", "Side");

        for(Shape shape : arrayOfShapes){
            if(shape.getName() == "Rectangle") {
                System.out.printf("%-14s %-10s %-10s %-10s %-10s %-10s\n", shape.getName(), shape.getArea(), shape.getPerimeter(), shape.getLength(), shape.getWidth(), " ");
                rectangleCount++;
            }
            else{
                System.out.printf("%-14s %-10s %-10s %-10s %-10s %-10s\n", shape.getName(), shape.getArea(), shape.getPerimeter(), " ", " ", shape.getSide());
            }
        }

        System.out.println("Number of rectangles: " + rectangleCount);
        System.out.println("Number of squares: " + (size -rectangleCount));

    } // end main
} // end class TestArea