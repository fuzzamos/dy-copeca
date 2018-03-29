/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//import static advancecopeca.hextodecimal.testcaseFileGenerator.getDataTypeSequenceof;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

/**
 *
 * @author Sangharatana Godboley
 */
public class TestDataFileGeneratorGUI extends javax.swing.JFrame {
  private Desktop desktop;
    /**
     * Creates new form TestDataFileGeneratorGUI
     */
   void create_dataType_file() throws FileNotFoundException, IOException{
       int intdata=0;
       int intarradata=0;
       int chardata=0;
       int chararradata=0;
       
   String filename=jTextField1.getText();
    BufferedReader fpReadfile = new BufferedReader(new FileReader(filename));
    PrintWriter tckeeper=new PrintWriter("../data_type.txt");
            String r=fpReadfile.readLine();
            while(r!=null){
            if(r.contains("klee_make_symbolic(")){
                if(r.contains("int")&&r.contains("*")){
                  intarradata++;
                tckeeper.println("int_array");
                }
                else if(r.contains("char")&&r.contains("*")){
                    chararradata++;
                 tckeeper.println("char_array");
                }
                else if(r.contains("int")){
                    intdata++;
                tckeeper.println("int");
                }
                else if(r.contains("char")){
                    chardata++;
                tckeeper.println("char");
                }
                
            }
            tckeeper.flush();
            r=fpReadfile.readLine();
            }
            jTextField4.setText(intdata+"");
            jTextField5.setText(intarradata+"");
            jTextField6.setText(chardata+"");
            jTextField7.setText(chararradata+"");
           

   }
   static  String DataTypeSequence[]=new String[100];
   static void getDataTypeSequenceof() throws IOException{
        try {
            BufferedReader fpReadfile = new BufferedReader(new FileReader("../data_type.txt"));
            String r=fpReadfile.readLine();
            int i=0;
            while(r!=null&&r.length()>1){
            DataTypeSequence[i]=r;
            System.out.println("The value of i:"+i+"   "+DataTypeSequence[i]);
            i++;
             r=fpReadfile.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(testcaseFileGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void write_for_charArray(String p1,PrintWriter filewrite){
   String p=p1;
        System.out.println(""+p);
        String pcom="";
        int binnum[] = new int[10000];
        for(int i=0;i<p.length();i++){
            if(p.charAt(i)=='\\'&&p.charAt(i+1)=='x'){
            pcom=pcom+p.substring(i, i+4);
            i=i+3;
            }
            else if(p.charAt(i)=='\\'&&p.charAt(i+1)=='t'){
            pcom=pcom+"\\x09";
            i=i+1;
            }
             else if(p.charAt(i)=='\\'&&p.charAt(i+1)=='r'){
            pcom=pcom+"\\x0d";
            i=i+1;
            }
             else if(p.charAt(i)=='\\'&&p.charAt(i+1)=='n'){
            pcom=pcom+"\\x0a";
            i=i+1;
            }
             else{
             int k=p.charAt(i);
             String str = Integer.toHexString(k);
             System.out.println("\\x"+str);
             pcom=pcom+"\\x"+str;
             }
        }
        System.out.println("*****"+pcom);
        System.out.println(""+pcom.length());
        if(pcom.length()%2==0){
        int numberofbytes=pcom.length()/4;
        String charval="";
        for(int h1=0;h1<1;h1++){
             String pcomcyc=""+pcom;
            System.out.println(""+pcomcyc);
            pcomcyc=pcomcyc.replace("\\x", "");
//            String pcom1="";
//            if(pcomcyc.length()%2==0){
//
//            for(int fc=pcomcyc.length();fc>0;fc=fc-2){
//            pcom1=pcom1+pcomcyc.substring(fc-2, fc);
//                System.out.println(""+pcom1);
//            }
//            }
//            pcomcyc=pcom1;
            int hr1;
            System.out.println("the value here"+pcomcyc);
            for(hr1=0;hr1<pcomcyc.length();hr1=hr1+2){

            String fg=pcomcyc.substring(hr1,hr1+2)+"";
                System.out.println("***"+fg);
            int decnum = hex2decimal(fg);
                System.out.println(""+decnum);
                char po=(char) decnum;
                charval=charval+po;
            }
            }
       filewrite.println(charval);
       filewrite.flush();
    }

   }
    void write_for_intArray(String p1,PrintWriter filewrite, int arraybit){
   String p=p1;
        System.out.println(""+p.length());
        String pcom="";
        int binnum[] = new int[10000];
        for(int i=0;i<p.length();i++){
            if(p.charAt(i)=='\\'&&p.charAt(i+1)=='x'){
            pcom=pcom+p.substring(i, i+4);
            i=i+3;
            }
            else if(p.charAt(i)=='\\'&&p.charAt(i+1)=='t'){
            pcom=pcom+"\\x09";
            i=i+1;
            }
             else if(p.charAt(i)=='\\'&&p.charAt(i+1)=='r'){
            pcom=pcom+"\\x0d";
            i=i+1;
            }
             else if(p.charAt(i)=='\\'&&p.charAt(i+1)=='n'){
            pcom=pcom+"\\x0a";
            i=i+1;
            }
             else{
             int k=p.charAt(i);
             String str = Integer.toHexString(k);
             System.out.println("\\x"+str);
             pcom=pcom+"\\x"+str;
             }
        }
        System.out.println("The pcom value"+pcom);
        System.out.println(""+pcom.length());
        if(pcom.length()%4==0){
        int numberofbytes=pcom.length()/16;

        for(int h1=0;h1<numberofbytes;h1++){
             String pcomcyc="";
        String hu=pcom.substring(h1*16,h1*16+16);
            System.out.println(""+hu);
            for(int h2=15;h2>=0;h2=h2-4){
            pcomcyc=pcomcyc+hu.substring(h2-3, h2+1);
             //System.out.println("***"+pcomcyc);
            }
            System.out.println(""+pcomcyc);
            pcomcyc=pcomcyc.replace("\\x", "");
            System.out.println(""+pcomcyc);
            String bolvalcomplete[];
            bolvalcomplete = new String[8];
            for(int i=0;i<pcomcyc.length();i++){
            switch(pcomcyc.charAt(i)){
                case '0':
                    bolvalcomplete[i]="0000";
                    break;
                case '1':
                    bolvalcomplete[i]="0001";
                    break;
                case '2':
                    bolvalcomplete[i]="0010";
                    break;
                case '3':
                    bolvalcomplete[i]="0011";
                    break;
                case '4':
                    bolvalcomplete[i]="0100";
                    break;
                case '5':
                    bolvalcomplete[i]="0101";
                    break;
                case '6':
                    bolvalcomplete[i]="0110";
                    break;
                case '7':
                    bolvalcomplete[i]="0111";
                    break;
                case '8':
                    bolvalcomplete[i]="1000";
                    break;
                case '9':
                    bolvalcomplete[i]="1001";
                    break;
                case 'a':
                    bolvalcomplete[i]="1010";
                    break;
                case 'b':
                    bolvalcomplete[i]="1011";
                    break;
                case 'c':
                    bolvalcomplete[i]="1100";
                    break;
                case 'd':
                    bolvalcomplete[i]="1101";
                    break;
                case 'e':
                    bolvalcomplete[i]="1110";
                    break;
                case 'f':
                    bolvalcomplete[i]="1111";
                    break;
            }
            }
            int valuepos=0;
            if(bolvalcomplete[0].charAt(0)!='1'){
            int bcvp=-1;
            for(int bcv1=7;bcv1>=0;bcv1--){
               for(int bcv2=3;bcv2>=0;bcv2--){
               bcvp++;
                  // System.out.println(""+bcvp);
                if(bolvalcomplete[bcv1].charAt(bcv2)=='0'){}
                else if(bolvalcomplete[bcv1].charAt(bcv2)=='1'){
                    System.out.println("yes executng"+bcvp);
                    valuepos=(int) (valuepos+Math.pow(2, bcvp));}
                }
               }
            }
            else if(bolvalcomplete[0].charAt(0)=='1'){
            System.out.println("Finding the 2's complement");
            //------Here we are finding the one's complement of the binary number----
             for(int bcv1=7;bcv1>=0;bcv1--){
              bolvalcomplete[bcv1]=bolvalcomplete[bcv1].replaceAll("0", "#");
              bolvalcomplete[bcv1]=bolvalcomplete[bcv1].replaceAll("1", "!");
              bolvalcomplete[bcv1]=bolvalcomplete[bcv1].replaceAll("#", "1");
              bolvalcomplete[bcv1]=bolvalcomplete[bcv1].replaceAll("!", "0");
             }
            System.out.println("after 1's complement"+" "+bolvalcomplete[0]+" "+bolvalcomplete[1]+" "+bolvalcomplete[2]+" "+bolvalcomplete[3]+" "+bolvalcomplete[4]+" "+bolvalcomplete[5]+" "+bolvalcomplete[6]+" "+bolvalcomplete[7]);
            //-----we found the one's complement, now we have to think about the two's complement of the number
             int k=0;
             //Temp commented to check 2's complement
             /*for(int bcv1=7;bcv1>=0&&k==0;bcv1--){
               for(int bcv2=3;bcv2>=0&&k==0;bcv2--){
               if(bolvalcomplete[bcv1].charAt(bcv2)=='1'){
               bolvalcomplete[bcv1]=bolvalcomplete[bcv1].substring(0, bcv2)+"0"+bolvalcomplete[bcv2].substring( bcv2,bolvalcomplete[bcv2].length());
               }else{
               bolvalcomplete[bcv1]=bolvalcomplete[bcv1].substring(0, bcv2)+"1"+bolvalcomplete[bcv2].substring( bcv2,bolvalcomplete[bcv2].length());
               k=1;
               break;

               }

               }}*/
//reverse the for loop
               /*for(int bcv1=7;bcv1>=0&&k==0;bcv1--){
               for(int bcv2=3;bcv2>=0&&k==0;bcv2--){
                
               if(bolvalcomplete[bcv1].charAt(bcv2)=='1'){
               System.out.println("before something"+bolvalcomplete[bcv1]);
               //bolvalcomplete[bcv1]=bolvalcomplete[bcv1].substring(0, bcv2)+"0"+bolvalcomplete[bcv2].substring( bcv2,bolvalcomplete[bcv2].length());
               bolvalcomplete[bcv1]=bolvalcomplete[bcv1].substring(0, bcv2)+bolvalcomplete[bcv2].substring( bcv2,bolvalcomplete[bcv2].length());
              System.out.println("after something"+bolvalcomplete[bcv1]);
               }else{
               System.out.println("before something"+bolvalcomplete[bcv1]);
               //bolvalcomplete[bcv1]=bolvalcomplete[bcv1].substring(0, bcv2)+"1"+bolvalcomplete[bcv2].substring( bcv2,bolvalcomplete[bcv2].length());
               bolvalcomplete[bcv1]=bolvalcomplete[bcv1].substring(0, bcv2)+bolvalcomplete[bcv2].substring( bcv2,bolvalcomplete[bcv2].length());
               System.out.println("after something"+bolvalcomplete[bcv1]);
               k=1;
               //break;

               }
                break;

               }}*/

               System.out.println("after 2's complement"+" "+bolvalcomplete[0]+" "+bolvalcomplete[1]+" "+bolvalcomplete[2]+" "+bolvalcomplete[3]+" "+bolvalcomplete[4]+" "+bolvalcomplete[5]+" "+bolvalcomplete[6]+" "+bolvalcomplete[7]);
             int bcvp=-1;
                //main codding commented
            for(int bcv1=7;bcv1>=0;bcv1--){
               for(int bcv2=3;bcv2>=0;bcv2--){
               ++bcvp;
                  // System.out.println(""+bcvp);
                if(bolvalcomplete[bcv1].charAt(bcv2)=='0'){
                    System.out.println(""+bolvalcomplete[bcv1]);
                   }
                else if(bolvalcomplete[bcv1].charAt(bcv2)=='1'){
                    //System.out.println("yes executng"+bcvp);
                    valuepos=(int)(valuepos+Math.pow(2, bcvp));

                    System.out.println(""+bolvalcomplete[bcv1]);
                    }
                    
                }
               
               }
            valuepos= valuepos + 1; // first we convert hexa to binary and then we take 1's complement after that we convert it to decimal and then add "1" to get the 2's complement result
            valuepos=-valuepos;
            }
            System.out.println(""+valuepos);


              
          


           
            if(arraybit==1){ filewrite.print(valuepos+",");
            filewrite.flush();}
            else{
            filewrite.println(valuepos);
            filewrite.flush();
            }

        }
      }
               //-----------------------------------------
        filewrite.println();
        if(arraybit==1){
       // filewrite.println();
        }
            filewrite.flush();
   }
    void generatefile() throws IOException{
    int filenumber=0;
    BufferedReader fpReadfile1;
      fpReadfile1 = new BufferedReader(new FileReader(jTextField2.getText()));
    PrintWriter tckeeper=new PrintWriter("../tcKeeper.txt");
    String r1=fpReadfile1.readLine();
    while(r1!=null){
    tckeeper.println(r1);
    tckeeper.flush();
    r1=fpReadfile1.readLine();
    }
    tckeeper.println("()");
    tckeeper.flush();
    //____________________________________________________
    BufferedReader fpReadfile = new BufferedReader(new FileReader("../tcKeeper.txt"));
    String r=fpReadfile.readLine();
    int input_file_index=0;
    while(r!=null){
        filenumber++;
        PrintWriter filewrite=new PrintWriter("../src/testcases/input"+filenumber+".txt");
        int j=0;
             while(!r.contains("()")){
             if(r.contains("object")&&r.contains("data:")){
                 if(r.contains(" "+j+":")){
                 if(DataTypeSequence[j].contains("char_array")){
                 String p1=r;
                 if(p1.contains("\"")&&p1.contains("'")){
                 if(p1.indexOf("\"")<p1.indexOf("'")){
                  p1= p1.substring(p1.indexOf("\"")+1, p1.lastIndexOf("\""));
                 }else{ p1= p1.substring(p1.indexOf("'")+1, p1.lastIndexOf("'"));}
                 }else{ p1= p1.substring(p1.indexOf("'")+1, p1.lastIndexOf("'"));}
                     System.out.println("What problem"+p1);
                //p1= p1.substring(p1.indexOf("'")+1, p1.lastIndexOf("'"));
                write_for_charArray(p1,filewrite);
                 }
                 else if(DataTypeSequence[j].contains("int_array")){
                     //System.out.println("Executing");
                     String p1=r;
                     //System.out.println(""+p1);
                     p1=p1.substring(p1.indexOf("'")+1, p1.lastIndexOf("'"));
                    // System.out.println("The p value is:"+p1);
                       write_for_intArray(p1,filewrite,1);
                 }
                 else if(DataTypeSequence[j].contains("int")){
                  String p1=r;
                  p1=  p1.substring(p1.indexOf("'")+1, p1.lastIndexOf("'"));
                  write_for_intArray(p1,filewrite,0);
                 }
                 else if(DataTypeSequence[j].contains("char")){
                 String p1=r;
                  p1=  p1.substring(p1.indexOf("'")+1, p1.lastIndexOf("'"));
                  write_for_intArray(p1,filewrite,0);
                 }
                 j++;
                 }
             }
             r=fpReadfile.readLine();
             }
            // j++;
             System.out.println("The value of j");
              r=fpReadfile.readLine();
    }
    jTextField3.setText(filenumber+"");

    }
     public  int hex2decimal(String s)
    {       System.out.println("The s value"+s);
             String digits = "0123456789ABCDEF";
             s = s.toUpperCase();
             int val = 0;
             for (int i = 0; i < s.length(); i++)
             {
                 char c = s.charAt(i);
                 int d = digits.indexOf(c);
                 val = 16*val + d;
             }

             return val;

    }
    public TestDataFileGeneratorGUI() {
        desktop=Desktop.getDesktop();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Test Data File Generator");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Test Case File Generator");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Browse C program File", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("Browse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jButton1)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Browse Hex Value containing test Data File", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jButton2.setText("Browse");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jButton2)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setText("Execute");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Number of Input Files Generated:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Number of Integer Values Present:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Number of Char Values Present:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Number of Integer Array Present:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Number of Char Array Present:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(jButton3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 JFileChooser fc= new JFileChooser();
        fc.showOpenDialog(null);
        File f= fc.getSelectedFile();
        String fl=f.getAbsolutePath();
        jTextField1.setText(fl);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
 JFileChooser fc= new JFileChooser();
        fc.showOpenDialog(null);
        File f= fc.getSelectedFile();
        String fl=f.getAbsolutePath();
        jTextField2.setText(fl);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      try {
          System.out.println("yes");
          create_dataType_file();getDataTypeSequenceof();
       generatefile();// TODO add your handling code here:
      } catch (IOException ex) {
          Logger.getLogger(TestDataFileGeneratorGUI.class.getName()).log(Level.SEVERE, null, ex);
      }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(TestDataFileGeneratorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestDataFileGeneratorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestDataFileGeneratorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestDataFileGeneratorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestDataFileGeneratorGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
