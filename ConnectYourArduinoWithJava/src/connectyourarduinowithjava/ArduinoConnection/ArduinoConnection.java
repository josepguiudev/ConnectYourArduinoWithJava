package connectyourarduinowithjava.ArduinoConnection;

import com.fazecast.jSerialComm.SerialPort;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * Class containing a method that will create the connection via serialPort -->
 * SerialPort.getCommPorts()[0] is used by default but you can change it to any
 * port you want. For example in my case I use SerialPort.getCommPort(“COM7”)
 * and the setBaudRate (default 9600).
 * by:
 *
 * @author josep
 */
public class ArduinoConnection {

    public static void conexionArduino() {
        //part already mentioned in the main comment
        //In this case I assign de port in COM7
        SerialPort serialPort = SerialPort.getCommPort("COM7");
        serialPort.setBaudRate(9600);
        //Waiting time before connection can be made
        serialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING, 2000, 0);
        
        //Conditional that controls if the port is opened, if not, the user is informed.
        if (!serialPort.openPort()) {
            System.out.println("Error when opening the port.");
            return;
        }
        
        //Prevents the app from being stopped
        try{
            /**
             * This thread is important because if we don't set it we don't give 
             * time for arduino to receive anything. A thread pauses the execution
             * by the parameter recived (ms)
            **/
            Thread.sleep(2000);
            
            /**
             * With an outputstream, we can send the data in bytes through the buffer.
             * Also we have to use the mettods write() and flush()
             **/
            OutputStream outPut = serialPort.getOutputStream();
            //Var to send
            //Put a sign so that arduino knows where to read to, like \n
            String message = "42\n";
            outPut.write(message.getBytes());
            outPut.flush();
            System.out.println("Sended number: " + message.trim());
            
            //Arduino message reading
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(serialPort.getInputStream())
            );
            String responseLine;
            while ((responseLine = reader.readLine()) != null) {
                System.out.println("Arduino's answer: " + responseLine);
            }
            
        }catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        } finally {
            serialPort.closePort();
            System.out.println("Closed Port.");
        }

    }

}
