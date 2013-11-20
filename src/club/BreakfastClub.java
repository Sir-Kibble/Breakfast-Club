package club;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jwvandyke
 */
public class BreakfastClub extends javax.swing.JFrame {
    
    /**
     * Creates new form BreakfastClub
     */
    
    public BreakfastClub() {
        
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

        lblTitle = new javax.swing.JLabel();
        tabStatistics = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaNums = new javax.swing.JTextArea();
        btnDisplay = new javax.swing.JButton();
        pnlCustomize = new javax.swing.JPanel();
        btnDisplayCustomized = new javax.swing.JButton();
        pnlDisplay = new javax.swing.JPanel();
        pnlStats = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        lblMode = new javax.swing.JLabel();
        lblModeData = new javax.swing.JLabel();
        lblMedianData = new javax.swing.JLabel();
        lblMedian = new javax.swing.JLabel();
        lblMean = new javax.swing.JLabel();
        lblMeanData = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        mbFile = new javax.swing.JMenu();
        mnitLoad = new javax.swing.JMenuItem();
        mnitSave = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Brush Script MT", 0, 54)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("The Breakfast Club Histogram");
        lblTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtAreaNums.setColumns(20);
        txtAreaNums.setLineWrap(true);
        txtAreaNums.setRows(5);
        jScrollPane1.setViewportView(txtAreaNums);

        btnDisplay.setText("Display Histogram");
        btnDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisplayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
                    .addComponent(btnDisplay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDisplay)
                .addContainerGap())
        );

        tabStatistics.addTab("Enter Data", jPanel1);

        btnDisplayCustomized.setText("Display Histogram");

        javax.swing.GroupLayout pnlCustomizeLayout = new javax.swing.GroupLayout(pnlCustomize);
        pnlCustomize.setLayout(pnlCustomizeLayout);
        pnlCustomizeLayout.setHorizontalGroup(
            pnlCustomizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCustomizeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDisplayCustomized, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlCustomizeLayout.setVerticalGroup(
            pnlCustomizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCustomizeLayout.createSequentialGroup()
                .addContainerGap(446, Short.MAX_VALUE)
                .addComponent(btnDisplayCustomized)
                .addContainerGap())
        );

        tabStatistics.addTab("Customization", pnlCustomize);

        javax.swing.GroupLayout pnlDisplayLayout = new javax.swing.GroupLayout(pnlDisplay);
        pnlDisplay.setLayout(pnlDisplayLayout);
        pnlDisplayLayout.setHorizontalGroup(
            pnlDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 564, Short.MAX_VALUE)
        );
        pnlDisplayLayout.setVerticalGroup(
            pnlDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        tabStatistics.addTab("Display Histogram", pnlDisplay);

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Class", "Frequency", "Relative Frequency"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblData);

        lblMode.setText("Mode:");

        lblModeData.setText("0.0");

        lblMedianData.setText("0.0");

        lblMedian.setText("Median:");

        lblMean.setText("Mean:");

        lblMeanData.setText("0.0");

        javax.swing.GroupLayout pnlStatsLayout = new javax.swing.GroupLayout(pnlStats);
        pnlStats.setLayout(pnlStatsLayout);
        pnlStatsLayout.setHorizontalGroup(
            pnlStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStatsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(pnlStatsLayout.createSequentialGroup()
                        .addGroup(pnlStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlStatsLayout.createSequentialGroup()
                                .addComponent(lblMean)
                                .addGap(18, 18, 18)
                                .addComponent(lblMeanData, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlStatsLayout.createSequentialGroup()
                                .addComponent(lblMedian)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblMedianData, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlStatsLayout.createSequentialGroup()
                                .addComponent(lblMode)
                                .addGap(18, 18, 18)
                                .addComponent(lblModeData)))
                        .addGap(0, 303, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlStatsLayout.setVerticalGroup(
            pnlStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStatsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMean)
                    .addComponent(lblMeanData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMedian)
                    .addComponent(lblMedianData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMode)
                    .addComponent(lblModeData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        tabStatistics.addTab("Statistics", pnlStats);

        mbFile.setText("File");

        mnitLoad.setText("Load Data File");
        mnitLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnitLoadActionPerformed(evt);
            }
        });
        mbFile.add(mnitLoad);

        mnitSave.setText("Save Data to File");
        mnitSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnitSaveActionPerformed(evt);
            }
        });
        mbFile.add(mnitSave);

        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mbFile.add(jMenuItem1);

        menuBar.add(mbFile);

        jMenu2.setText("Edit");
        menuBar.add(jMenu2);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabStatistics, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabStatistics))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnitLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnitLoadActionPerformed

        JFileChooser fc = new JFileChooser();
        int x = fc.showOpenDialog(fc);

        txtAreaNums.setText("");
        
        ArrayList<Double> al = new ArrayList();

        try {

            FileReader fr = new FileReader(fc.getSelectedFile());
            BufferedReader br = new BufferedReader(fr);
            Scanner in = new Scanner(br);

            while (in.hasNextDouble()) {

                Double num = in.nextDouble();

                txtAreaNums.append(num.toString() + " ");

            }

        }

        catch (FileNotFoundException fnf) {

        }
        
    }//GEN-LAST:event_mnitLoadActionPerformed

    private void mnitSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnitSaveActionPerformed
        
        JFileChooser jfc = new JFileChooser();
        
        int x = jfc.showSaveDialog(null);
        
        if (x == JFileChooser.APPROVE_OPTION) {
            
            try {
                
                FileWriter fw = new FileWriter(jfc.getSelectedFile() + ".txt");
                
                String data = txtAreaNums.getText();

                ArrayList<Double> nums = new ArrayList<Double>();

                Matcher m = Pattern.compile(("\\d+")).matcher(data);

                if (m.find()) {

                    nums.add(Double.parseDouble(m.group(0)));

                }

                m = Pattern.compile(("\\s\\d+")).matcher(data);

                while (m.find()) {

                    nums.add(Double.parseDouble(m.group(0)));

                }
                
                for (int i = 0; i < nums.size(); i++) {
                    
                    fw.write(nums.get(i).toString() + "\n");
                    
                }//end for
                
                fw.flush();
                
                fw.close();
                
            }//end try
            
            catch (Exception ex) {
                
                
                
            }//end catch
            
        }//end if
        
    }//GEN-LAST:event_mnitSaveActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
        System.exit(0);
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisplayActionPerformed
        
        String x = txtAreaNums.getText();

        ArrayList<Double> nums = new ArrayList<Double>();

        Matcher m = Pattern.compile((("\\d+(\\.\\d+)?"))).matcher(x);

        if (m.find()) {

            nums.add(Double.parseDouble(m.group(0)));

        }

        m = Pattern.compile(("\\s\\d+(\\.\\d+)?")).matcher(x);

        while (m.find()) {

            nums.add(Double.parseDouble(m.group(0)));

        }
        
        Statistics s = new Statistics(nums, this);
        
    }//GEN-LAST:event_btnDisplayActionPerformed

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
            java.util.logging.Logger.getLogger(BreakfastClub.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BreakfastClub.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BreakfastClub.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BreakfastClub.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BreakfastClub().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDisplay;
    private javax.swing.JButton btnDisplayCustomized;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel lblMean;
    public javax.swing.JLabel lblMeanData;
    public javax.swing.JLabel lblMedian;
    public javax.swing.JLabel lblMedianData;
    public javax.swing.JLabel lblMode;
    public javax.swing.JLabel lblModeData;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JMenu mbFile;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem mnitLoad;
    private javax.swing.JMenuItem mnitSave;
    private javax.swing.JPanel pnlCustomize;
    private javax.swing.JPanel pnlDisplay;
    private javax.swing.JPanel pnlStats;
    private javax.swing.JTabbedPane tabStatistics;
    public javax.swing.JTable tblData;
    private javax.swing.JTextArea txtAreaNums;
    // End of variables declaration//GEN-END:variables
}
