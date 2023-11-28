package HW1.ModelElements;

public class Camera {
    private Point3D location;
    private Angle3D angle;

    
    public Camera(Point3D location, Angle3D angle) {
        this.location = location;
        this.angle = angle;
    }

   
    public void rotate(Angle3D rotation) {
        this.angle = rotation;
    }

    
    public void move(Point3D newPosition) {
        this.location = newPosition;
    }


    public Point3D getLocation() {
        return location;
    }

    public void setLocation(Point3D location) {
        this.location = location;
    }

    public Angle3D getAngle() {
        return angle;
    }

    public void setAngle(Angle3D angle) {
        this.angle = angle;
    }
}
