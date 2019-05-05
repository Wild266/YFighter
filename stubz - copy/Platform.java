public class Platform
{
    double y;
    Platform(double newY)
    {
        this.y = newY;
        System.out.println("made new platform at y: " + this.y);
    }

    public double getY()
    {
        System.out.println("returning y value");
        return this.y;
    }
}