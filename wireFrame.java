package handle_pcap;

import static handle_pcap.PacketPrinter.i;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import jpcap.packet.IPPacket;

public class wireFrame extends javax.swing.JFrame {

    /**
     * Creates new form wireFrame
     */
    
   
      PacketPrinter x ; 
      static  DefaultTableModel model ;
      static int selectedInterface ; 
      SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    static  Date past =new Date();
     static  Date now = new Date();
    Wireshark wir=new Wireshark();
     Thread t1 ; 
          static int  selecctedRow; 
    public wireFrame() {
        initComponents();
        addValueToList();
       

        
        
    
        model = (DefaultTableModel) TablePacketsView.getModel();
       
    }
    public void addValueToList(){
        DefaultListModel model1=new DefaultListModel();
        int len=wir.getNoDevices();
        for(int i=1;i<len;i++){
          model1.addElement(wir.getNameDevices(i));
        }
       List_devices.setModel(model1);
    }
    
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        List_devices = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablePacketsView = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        label1 = new java.awt.Label();
        textArea1 = new java.awt.TextArea();
        filters = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        resultpacketcontent = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        resultpackethex = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("The WireShark Network Analyzer");

        jLabel1.setText("Devices:");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Select your device:");

        List_devices.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                List_devicesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(List_devices);

        jButton1.setBackground(java.awt.Color.green);
        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setForeground(java.awt.Color.darkGray);
        jButton1.setText("Capture");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(java.awt.Color.red);
        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setText("pause");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("save ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        TablePacketsView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "no", "Time", "source", "destination", "Protocal", "length", "info"
            }
        ));
        TablePacketsView.setToolTipText("iugiu");
        TablePacketsView.setColumnSelectionAllowed(true);
        TablePacketsView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablePacketsViewMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TablePacketsViewMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(TablePacketsView);
        TablePacketsView.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jLabel3.setText("selected device ");

        jLabel4.setText("Packetage contents ");

        label1.setBackground(java.awt.Color.lightGray);
        label1.setText("filters");

        textArea1.setBackground(java.awt.Color.lightGray);
        textArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textArea1.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N

        filters.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "TCP", "IP", "ICMP", "IP and TCP", " " }));
        filters.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtersActionPerformed(evt);
            }
        });

        jLabel5.setText("Packetage contents hex ");

        resultpacketcontent.setColumns(20);
        resultpacketcontent.setRows(5);
        jScrollPane3.setViewportView(resultpacketcontent);

        resultpackethex.setColumns(20);
        resultpackethex.setRows(5);
        jScrollPane4.setViewportView(resultpackethex);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addGap(29, 29, 29)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(filters, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(364, 364, 364))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(666, 666, 666))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(textArea1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3)))
                .addGap(147, 147, 147))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
 
                 t1 = new Thread(new Runnable() {
         public void run() {
              try {
                while(!Thread.currentThread().isInterrupted())
                {
                    
                    if (filters.getSelectedItem() == "None"){
                     wir.OpenDeviceTocaptureALLNonContinous(List_devices.getSelectedIndex(),10);
                     
                    }
                    else if (filters.getSelectedItem() == "IP and TCP"){
                    
                       wir.capturefilterNonContinous(List_devices.getSelectedIndex(),10,"ip and tcp");
                    }
                    else if (filters.getSelectedItem() == "UDP"){
                    
                      wir.capturefilterNonContinous(List_devices.getSelectedIndex(),10,"UDP") ;
                     }
                    else if (filters.getSelectedItem() =="ICMP"){
                    
                       wir.capturefilterNonContinous(List_devices.getSelectedIndex(),10,"ICMP");

                    }
                    else{ 
                        wir.capturefilterNonContinous(List_devices.getSelectedIndex(),10,"TCP");
                         
                       }
                }// InsertTntoTable();
              // TODO add your handling code here:
          } catch (IOException ex) {
              infoBox("filter doesn't supported yet " , "waring ") ; 
              Logger.getLogger(wireFrame.class.getName()).log(Level.SEVERE, null, ex);
             
          }
         }
    }); 
                t1.start();
                
                
          
            
        
       
      
    }//GEN-LAST:event_jButton1ActionPerformed
 public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public  String convertoHex(String  str) {
     String Hex="";
     int len =str.length();
     char ch;
     for(int i=0;i<len;i++){
        ch=str.charAt(i); 
        Hex+=String.format("%04x", (int) ch);
     }

   return Hex;
 }
    
    
    
    
    
    
    
    
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     //wir.close(); 
          t1.interrupt();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void TablePacketsViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePacketsViewMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TablePacketsViewMouseClicked

    private void TablePacketsViewMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePacketsViewMousePressed
 //resultpackethex.setText(Integer.toString(TablePacketsView.getSelectedRow()));
  
resultpackethex.setText(convertoHex(getContent(PacketPrinter.packetslist.get(TablePacketsView.getSelectedRow()))));
resultpacketcontent.setText( PacketPrinter.packetslist.get(TablePacketsView.getSelectedRow()).toString() );
// TODO add your handling code here:
    }//GEN-LAST:event_TablePacketsViewMousePressed

    public String getContent(IPPacket pack) {
        byte[] bytes = pack.data;
        String ss = "";
        ss = new String(bytes);
        return ss;
    }
    private void List_devicesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_List_devicesMouseClicked
          try {
              textArea1.setText( wir.printAvailableDevices(List_devices.getSelectedIndex())) ;
              
// TODO add your handling code here:
          } catch (IOException ex) {
              Logger.getLogger(wireFrame.class.getName()).log(Level.SEVERE, null, ex);
          }
    }//GEN-LAST:event_List_devicesMouseClicked

    private void filtersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filtersActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
 infoBox("saving to file  doesn't supported now    will fix it later   " , "error ") ;           
    }//GEN-LAST:event_jButton3ActionPerformed
     public static  void  InsertTntoTable()
     {
 
//System.out.println(from gui );
//for (int i =0 ; i< x.packetslist.size() ; i++);

 //System.out.println(x.packetslist.get(i).src_ip.toString());

          //for (int i =0 ; i< PacketPrinter.packetslist.size() ; i++)
          //{ 
        // System.out.println(PacketPrinter.packetslist.get(PacketPrinter.i).src_ip.toString());
         System.out.println("from gui");
        Object[] row  = {Integer.toString(PacketPrinter.i) ,Long.toString(new Date().getTime()) ,PacketPrinter.packetslist.get(PacketPrinter.i).src_ip.toString(),PacketPrinter.packetslist.get(PacketPrinter.i).dst_ip.toString(),PacketPrinter.packetType.get(PacketPrinter.i),Integer.toString(PacketPrinter.packetslist.get(PacketPrinter.i).len) };
       //  Object[] row  = {1 ,2,3,4,5,6 ,7};
         
         model.addRow(row);
         // }
     
     
     
     
     
     } 

     
     
     
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(wireFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(wireFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(wireFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(wireFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new wireFrame().setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> List_devices;
    private javax.swing.JTable TablePacketsView;
    private javax.swing.JComboBox<String> filters;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private java.awt.Label label1;
    private javax.swing.JTextArea resultpacketcontent;
    private javax.swing.JTextArea resultpackethex;
    private java.awt.TextArea textArea1;
    // End of variables declaration//GEN-END:variables
 
}
