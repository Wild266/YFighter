/** The bottommost position that the fighters can go. The platform that they walk on
*/
public class Platform
{
    int y;               //the vertical position on the screen
    Platform(int newY)
    {
        this.y = newY;
    }
    /** Gets the position of the platform
    * @return The Y position of the platform in pixels 
    */
    public int getY()
    {
        return this.y;
    }
}
