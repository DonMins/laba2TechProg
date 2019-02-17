import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "circle")
@XmlType(propOrder = {"radius", "x", "y"})
public class Circle {
    private double radius;
    private double x;
    private  double y;

    public  Circle(){}

    public Circle(double radius,double x,double y){
        this.radius = radius;
        this.x = x;
        this.y = y;
    }
    @XmlElement(name="radius")
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    @XmlElement(name="x")
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }
    @XmlElement(name="y")
    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void newRadius(double newRadios){
        setRadius(this.radius*newRadios);
    }
    public void newPosition(double biosX, double biosY){
        setX(this.x + biosX);
        setY(this.y + biosY);
    }
}

