import java.lang.Math;
//Required Class Shape
abstract class Shape {
    public abstract String getName();
}
//Required abstract class 2D
abstract class Shape2D extends Shape{
    public abstract double getArea();
}
//Required abstract class Shape3D
abstract class Shape3D extends Shape2D{

    public abstract double getVolume();
}

//All of the 2D shapes
class Square extends Shape2D{

    double i;
    String square = "square";

    Square(double i) {
        this.i = i * i;//Area formula for a square
    }

    public String getName() {
        return this.square;
    }


    public double getArea() {
        return this.i;
    }
}

   class Triangle extends Shape2D{

    double z;
    String tri = "triangle";

     Triangle (double x, double y){
        z = (x*y)/2;//Formula of a triangle

    }
    public String getName(){
        return this.tri;
    }

    @Override
    public double getArea(){
        return this.z;
    }


}

class Circle extends Shape2D{

    double r;//diameter
    String circle = "circle";

    Circle(double r) {
        this.r = Math.PI * Math.pow(r,2);//Area formula for circle
    }

    public String getName() {
        return this.circle;
    }


    public double getArea() {

        double rounded = Math.round(this.r * 100)/100.0;
        return rounded;
    }
}

//All of the 3D shapes
class Cube extends Shape3D{

    double i, j;//"j" for storing passing variables
    String cube = "cube";

    Cube(double i) {
        j = i;
        this.i = 6 * i * i;//Area formula for a cube
    }

    public String getName() {
        return this.cube;
    }


    public double getArea() {

        return this.i;
    }

    @Override
    public double getVolume() {
        this.i = Math.pow(j,3);
        double rounded = Math.round(this.i * 100)/100.0;
        return rounded;
    }
}

class Pyramid extends Shape3D{

    double x, y, z, p;//"a b c" for storing passing variables to calculate volume
    String pyramid = "pyramid";

    Pyramid(double x, double y, double z) {
        this.x = x; //length
        this.y = y; //width
        this.z = z; //height
        this.p = x*y+(x*Math.sqrt(Math.pow(y/2,2)+Math.pow(z,2)))+(y*Math.sqrt(Math.pow(x/2,2)+Math.pow(z,2)));//Area formula for a pyramid
    }

    public String getName() {
        return this.pyramid;
    }


    public double getArea() {
        double rounded = Math.round(this.p * 100)/100.0;
        return rounded;
    }

    @Override
    public double getVolume() {
        this.p = (x*y*z)/3;
        return this.p;
    }
}

class Sphere extends Shape3D{

    double r, j;//"j" for storing passing variables
    String sphere = "sphere";

    Sphere(double i) {
        j = i;//storing radius
        this.r = 4*Math.PI*Math.pow(i, 2);//Area formula for a cube
    }

    public String getName() {
        return this.sphere;
    }


    public double getArea() {

        return this.r;
    }

    @Override
    public double getVolume() {
        this.r = (4 * Math.PI * Math.pow(j, 3))/3;//Volume of a sphere
        return this.r;
    }
}

