
package handle_pcap;

import java.util.ArrayList;
import jpcap.PacketReceiver;
import jpcap.packet.Packet;
import jpcap.*;
import jpcap.NetworkInterface;

import jpcap.packet.DatalinkPacket;
import jpcap.packet.EthernetPacket;
import jpcap.packet.ICMPPacket;
import jpcap.packet.IPPacket;
import jpcap.packet.Packet;
import jpcap.packet.TCPPacket;
import jpcap.packet.UDPPacket;
 
public  class  PacketPrinter implements PacketReceiver{
  wireFrame print ;

 static ArrayList<IPPacket> packetslist = new ArrayList<IPPacket> () ; 
  static   int i = 0;
 static ArrayList<String> packetType = new ArrayList<String> () ;  
    String protocoll[] = {"HOPOPT", "ICMP", "IGMP", "GGP", "IPV4", "ST", "TCP", "CBT", "EGP", "IGP", "BBN", "NV2", "PUP", "ARGUS", "EMCON", "XNET", "CHAOS", "UDP", "mux"};
    ArrayList<String> PacketData = new ArrayList<String>() ;  
    static IPPacket tpt ; 
 static TCPPacket x;
    @Override
    public  void  receivePacket(Packet packet) {
        
       // System.out.println("this is packet " + i + " :" + "\n");
      
         System.out.println(packet);
         
       //  System.out.println((TCPPacket)packet);
        
       System.out.println(x);
     tpt=(IPPacket)packet;
 if (packet != null) {
packetslist.add(tpt) ; 
int ppp=tpt.protocol;
String proto=protocoll[ppp];
System.out.println("about the ip packet in network layer : \n");
System.out.println("******************************************************************");
if(tpt.dont_frag){
    System.out.println("dft bi is set. packet will not be fragmented \n");

}else{
    System.out.println("dft bi is not set. packet will  be fragmented \n");
}
System.out.println(" \n destination ip is :"+tpt.dst_ip);
System.out.println("\n this is source ip :"+tpt.src_ip);
System.out.println("\n this is hop limit :"+tpt.hop_limit);
System.out.println(" \n this is identification field  :"+tpt.ident);
System.out.println(" \npacket length :"+tpt.length);
System.out.println("\n packet priority  :"+(int)tpt.priority);
System.out.println("type of service field"+tpt.rsv_tos);
if(tpt.r_flag){
    System.out.println("releiable transmission");
}else{
    System.out.println("not reliable");
}
System.out.println("protocol version is : "+(int)tpt.version);
System.out.println("flow label field"+tpt.flow_label);

System.out.println("**********************************************************************");

System.out.println("datalink lavel analysis");
System.out.println("********************************************************************");
 DatalinkPacket dp = packet.datalink;


            EthernetPacket ept=(EthernetPacket)dp;
            System.out.println("this is destination mac address :"+ept.getDestinationAddress());
            System.out.println("\n this is source mac address"+ept.getSourceAddress());
            


System.out.println("*********************************************************************");
System.out.println("this is about type of packet");
System.out.println("******************************************************************************");
              
                if (proto.equals(("TCP"))) {
                    System.out.println(" /n this is TCP packet");
                    packetType.add( "TCP"); 
                    TCPPacket tp = (TCPPacket) packet;
                    System.out.println("this is destination port of tcp :" + tp.dst_port);
                    if (tp.ack) {
                        System.out.println("\n" + "this is an acknowledgement");
                    } else {
                        System.out.println("this is not an acknowledgment packet");
                    }

                    if (tp.rst) {
                        System.out.println("reset connection ");
                    }
                    System.out.println(" \n protocol version is :" + tp.version);
                    System.out.println("\n this is destination ip " + tp.dst_ip);
                    System.out.println("this is source ip"+tp.src_ip);
                   if(tp.fin){
                       System.out.println("sender does not have more data to transfer");
                   }
                    if(tp.syn){
                        System.out.println("\n request for connection");
                    }

                }else if(proto.equals("ICMP")){
                    ICMPPacket ipc=(ICMPPacket)packet;
                    
                    packetType.add( "ICMP");
             // java.net.InetAddress[] routers=ipc.router_ip;
              //for(int t=0;t
                //  System.out.println("\n"+routers[t]);
             // }
              System.out.println(" \n this is alive time :"+ipc.alive_time);
              System.out.println("\n number of advertised address :"+(int)ipc.addr_num);
              System.out.println("mtu of the packet is :"+(int)ipc.mtu);
              System.out.println("subnet mask :"+ipc.subnetmask);
              System.out.println("\n source ip :"+ipc.src_ip);
              System.out.println("\n destination ip:"+ipc.dst_ip);
              System.out.println("\n check sum :"+ipc.checksum);
              System.out.println("\n icmp type :"+ipc.type);
              System.out.println("");


                }else if(proto.equals("UDP")){
                    UDPPacket pac=(UDPPacket)packet;
           
                     packetType.add( "UDP");
                    System.out.println("this is udp packet \n");
                    System.out.println("this is source port :"+pac.src_port);
                    System.out.println("this is destination port :"+pac.dst_port);

                }
                
//            Thread t1 = new Thread(new Runnable() {
//                public void run() {
//             wireFrame.InsertTntoTable(); 
//         }
//   });  
//  t1.start();
wireFrame.InsertTntoTable(); 
                i++;

              System.out.println("******************************************************");
            }



        }

   public static String getSrcIp(){
        return tpt.src_ip.toString() ; 
}
   public static String getdesIp(){
        return tpt.dst_ip.toString() ; 
}
   public static String getCurrentPacketNumber(){
        return Integer.toString(i) ; 
}
 //  public static String getProtocolType(){
   //     return packetType+"v"+tpt.version ; 
//}
   public static  String getLenght(){
        return Integer.toString(tpt.length) ; 
}

   
}