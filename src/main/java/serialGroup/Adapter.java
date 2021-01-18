package serialGroup;
import com.fazecast.jSerialComm.* ;
interface ISerial
{
    void send(String s);
    void close();

}
public class Adapter implements ISerial
{
    SerialPort comPort;
    public Adapter(String port) {
        comPort =  SerialPort.getCommPort(port);
    }

    @Override
    public void send(String s) {
        comPort.openPort();
        comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 100, 0);
        try {
            while (true)
            {
                byte[] readBuffer = new byte[1024];
                int numRead = comPort.readBytes(readBuffer, readBuffer.length);
                System.out.println("Read " + numRead + " bytes.");
            }
        } catch (Exception e) { e.printStackTrace(); }
    }
    @Override
    public void close()
    {
        comPort.closePort();
    }
}
