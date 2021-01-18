package serialGroup;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ISerial adapter = new Adapter("/dev/ttyUSB0");
        adapter.send("dddddddddddddddddddd");
        adapter.close();
    }
}
