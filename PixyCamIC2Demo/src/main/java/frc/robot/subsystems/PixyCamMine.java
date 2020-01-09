package frc.robot.subsystems;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;

import java.util.ArrayList;
import java.util.List;

public class PixyCamMine {

    public I2C port;
    public int address;
    public List<Byte> data = new ArrayList<>(14);

    /**
     * contains data in the following order:
     * <strong><br>
     * x
     * <br>
     * y
     * <br>
     * width
     * <br>
     * height</strong>
     */
    public List<Integer> formattedData = new ArrayList<>(4);



    public PixyCamMine() {
        address = 0x33;
        port = new I2C(I2C.Port.kMXP, address);

    }

    /**
     * Execute a read transaction with the device.
     *
     * <p>Read bytes from a device. Most I2C devices will auto-increment the register pointer
     * internally allowing you to read consecutive registers on a device in a single transaction.
     *
     * @param registerAddress The register to read first in the transaction.
     * @param count           The number of bytes to read in the transaction.
     * @param buffer          A pointer to the array of bytes to store the data read from the device.
     * @return Transfer Aborted... false for success, true for aborted.
     */
    public void read(int registerAddress, int count, byte[] buffer) {
        formattedData.clear();
        data.clear();
        port.read(registerAddress, count, buffer);
        //System.out.println(buffer[0]);
        /*for(int value: buffer){
            System.out.println(value);
            System.out.println("hex --> " + Constants.getHexadecimalNumber(value));
        }*/
        //SYNC WORDS
        data.add(buffer[0]);
        data.add(buffer[0]);

        //SUM OF ALL BYTES 4-13
        data.add((byte) 0);
        data.add(buffer[4]);

        //SIGNATURE
        data.add(buffer[5]);
        data.add(buffer[6]);

        //X CENTER POSITION
        data.add(buffer[7]);
        data.add(buffer[8]);

        //Y CENTER POSITION
        data.add(buffer[9]);
        data.add(buffer[10]);

        //width
        data.add(buffer[11]);
        data.add(buffer[12]);

        //height
        data.add(buffer[13]);
        data.add(buffer[14]);


        //parse x
        formattedData.add(Constants.getIntegerFrom16bits(data.get(6),data.get(7)));

        //parse y
        formattedData.add(Constants.getIntegerFrom16bits(data.get(8),data.get(9)));

        //parse width
        formattedData.add(Constants.getIntegerFrom16bits(data.get(10),data.get(11)));

        //parse y
        formattedData.add(Constants.getIntegerFrom16bits(data.get(12),data.get(13)));



        /*
        try {
            SmartDashboard.putNumber("width", buffer[12]);
            SmartDashboard.putNumber("height", buffer[14]);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        */
    }

    public List<Byte> getData() {
        return this.data;
    }
    public List<Integer> getFormattedData(){
        return this.formattedData;
    }

        /*
    data	    index	    new index
    sync	    0,1,2,3	    0,1
    sum	4	    2,3
    signature	5,6	        4,5
    x	        7,8	        6,7
    y	        9,10	    8,9
    width	    11,12	    10,11
    height	    13,14	    12,13

     */
}

