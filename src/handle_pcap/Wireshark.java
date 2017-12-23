package handle_pcap;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpcap.JpcapCaptor;
import jpcap.JpcapWriter;
import jpcap.NetworkInterface;
import jpcap.NetworkInterfaceAddress;
import jpcap.packet.Packet;

import jpcap.*;

public class Wireshark  {

    private NetworkInterface[] devices;
    private int noDevices;
    private JpcapCaptor captor;
    private static final int INFINITE = -1;
    private static final int PACKET_COUNT = 10;
    private static final String FILTER = "";
  
    private String m_device;
    
   

    public Wireshark() {
        devices = JpcapCaptor.getDeviceList();
        noDevices = devices.length;
    }
   
    
    
    
    
  //  import net.sourceforge.jpcap.capture.*;
//import net.sourceforge.jpcap.net.*;
    

    public void printAvailableDevices() throws IOException {
        System.out.println("Available Interfaces: ");
        noDevices = devices.length;
        for (int i = 1; i < devices.length; i++) {
            System.out.println(i + ": " + devices[i].name + "(" + devices[i].description + ")");
            System.out.println("datalink: " + devices[i].datalink_name + "(" + devices[i].datalink_description + ")");
            for (byte b = 0; b < devices[i].mac_address.length; b++) {
                System.out.print(Integer.toHexString(b & 0xff) + ":");
            }
            System.out.println();
            for (NetworkInterfaceAddress a : devices[i].addresses) {
                System.out.println(" address:" + a.address + " " + a.subnet + " " + a.broadcast);
            }
            
        }      
           

 
}
        public String  printAvailableDevices(int selected ) throws IOException {
        String result="" ; 
          //  System.out.println("Available Interfaces: ");
        
        noDevices = devices.length;
       
            result = Integer.toString(selected) + ": " + devices[selected].name + "(" + devices[selected].description + ")";
             result += System.lineSeparator() ; 
            result += "datalink: " + devices[selected].datalink_name + "(" + devices[selected].datalink_description + ")";
            result += System.lineSeparator() ; 
            for (byte b = 0; b < devices[selected].mac_address.length; b++) {
                result += Integer.toHexString(b & 0xff) + ":";
            }
            //System.out.println();
//            for (NetworkInterfaceAddress a : devices[selected].addresses) {
//                System.out.println(" address:" + a.address + " " + a.subnet + " " + a.broadcast);
//            }
            
              
          return result;  

 
}
    
public void OpenDeviceTocaptureALLContinous(int DeviceNumber ) throws IOException
        
{
JpcapCaptor captor=JpcapCaptor.openDevice(devices[DeviceNumber], 65535, false, 20);
captor.loopPacket(-1,new PacketPrinter());
//for(int i=0;i<1000;i++){
//  //capture a single packet and print it out
//  System.out.println(devices[DeviceNumber].description);
//  System.out.println(captor.getPacket());
// 
//}

//captor.close();


}
public void OpenDeviceTocaptureALLNonContinous(int DeviceNumber,int NumberPackets ) throws IOException
        
{
    
    
JpcapCaptor captor=JpcapCaptor.openDevice(devices[DeviceNumber], 65535, false, 20);
captor.loopPacket(NumberPackets,new PacketPrinter());
//for(int i=0;i<NumberPackets;i++){
//  //capture a single packet and print it out
// System.out.println(devices[DeviceNumber].description);
  //System.out.println(captor.getPacket());
 
//}

//captor.close();


}
public void capturefilterNonContinous(int DeviceNumber,int NumberPackets ,String filter) throws IOException
{

JpcapCaptor captor=JpcapCaptor.openDevice(devices[DeviceNumber], 65535, false, 20);
captor.setFilter(filter, true);
captor.loopPacket(NumberPackets,new PacketPrinter());
//for(int i=0;i<NumberPackets;i++){
//  //capture a single packet and print it out

// System.out.println(captor.getPacket());
 //}

}





// doesnt work right now // 
public void printpackets(int DeviceNumber , int numberpackets ) throws IOException
{
JpcapCaptor captor=JpcapCaptor.openDevice(devices[DeviceNumber], 65535, false, 20);

for(int i=0;i<numberpackets;i++){


 Packet packet=captor.getPacket();

  System.out.println(captor.getPacket());
 
 

 
}

}



    public NetworkInterface[] getAvailableDevices() {
        return devices;
    }

    public String getNameDevices(int index) {
        return devices[index].description;
    }

    public int getNoDevices() {
        return noDevices;
    }

    public void openWireDevices(int index, int size_packet, boolean promisc, int timout) throws IOException {
        captor = JpcapCaptor.openDevice(devices[index], size_packet, promisc, timout);
    }

    public Packet getWirePecket() {
        return captor.getPacket();
    }

    public Packet getWirePecketFilter(String str) throws IOException {
        captor.setFilter(str, true);
        return captor.getPacket();
    }

    public void printWirePecket() {
        System.out.println(captor.getPacket());
    }
// doesnt work // 
    public void printListWirePecket(int number, boolean ProcessOrLoop) {
        if (ProcessOrLoop) {
            System.out.println(captor.processPacket(number, new PacketPrinter()));
        } else {
            for (int i = 0; i < number; i++) {
                System.out.println(captor.getPacket());
            }
        }
    }
// not tested // 
    public Packet[] getListWirePecket(int number) {
        Packet[] pack = new Packet[100];
        for (int i = 0; i < number; i++) {
            pack[i] = captor.getPacket();

        }
        return pack;
    }

    public Packet[] getListPecketFilter(int number, String str) throws IOException {
        captor.setFilter(str, true);
        Packet[] pack = new Packet[100];
        for (int i = 0; i < number; i++) {
            pack[i] = captor.getPacket();

        }
        return pack;
    }
public void close()
{
               //  captor.breakLoop();
                    captor.close();
                    // InsertTntoTable();
                    // TODO add your handling code here:
   


}
   
    
    
    
   

}
