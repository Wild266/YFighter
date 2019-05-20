public class Platform
{
    int y;
    Platform(int newY)
    {
        this.y = newY;
        System.out.println("made new platform at y: " + this.y);
    }

    public int getY()
    {
        //System.out.println("returning y value");
        return this.y;
    }
}