package HW1.ModelElements;

public class Flash {
    private Point3D location;
    private Angle3D angle;
    private Color color;
    private float power;

   
    public Flash(Point3D location, Angle3D angle, Color color, float power) {
        this.location = location;
        this.angle = angle;
        this.color = color;
        this.power = power;
    }

    public void rotate(Angle3D newAngle) {
        this.angle = newAngle;
    }
    
    public void move(Point3D newPosition) {
        this.location.setX(newPosition.getX());
        this.location.setY(newPosition.getY());
    }

    public Angle3D getAngle() {
        return angle;
    }
    public Color getColor() {
        return color;
    }
    public Point3D getLocation() {
        return location;
    }
    public float getPower() {
        return power;
    }
}




