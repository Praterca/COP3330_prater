abstract class Shape {

    public abstract double getArea();

    public abstract String getName();


}

abstract class Shape2D extends Shape{

}

abstract class Shape3D extends Shape{

    public abstract double getVolume();
}

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
/*
   class Triangle extends Shape2D{

    double z;
    String tri = "triangle";

    private Triangle (double x, double y){
        z = (x*y)/2;//Formula of a square

    }
    public String getName(){
        return this.tri;
    }

    @Override
    public double getArea(){
        return this.z;
    }


    }

}*/

