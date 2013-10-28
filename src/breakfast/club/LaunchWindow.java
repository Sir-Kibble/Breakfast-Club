/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 
package breakfast.club;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.swing.JFileChooser;
import java.util.*;

/**
 *
 * @author jwvandyke
 
public class LaunchWindow extends javax.swing.JFrame {

    public LaunchWindow() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLoad = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDisplay = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaNums = new javax.swing.JTextArea();
        lblTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btnLoad.setText("Load");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        btnSave.setText("Save");

        btnDisplay.setText("Display Histogram");
        btnDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisplayActionPerformed(evt);
            }
        });

        txtAreaNums.setColumns(20);
        txtAreaNums.setLineWrap(true);
        txtAreaNums.setRows(5);
        jScrollPane1.setViewportView(txtAreaNums);

        lblTitle.setFont(new java.awt.Font("Brush Script MT", 0, 54)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("The Breakfast Club Histogram");
        lblTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLoad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(btnLoad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDisplay)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        
        JFileChooser fc = new JFileChooser();
        int x = fc.showOpenDialog(fc);
        
        ArrayList al = new ArrayList();
        
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
        
    }//GEN-LAST:event_btnLoadActionPerformed

    private void btnDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisplayActionPerformed
        
        HistogramDisplay hd = new HistogramDisplay(this);
        hd.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_btnDisplayActionPerformed

    /**
     * @param args the command line arguments
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDisplay;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnSave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextArea txtAreaNums;
    // End of variables declaration//GEN-END:variables
}
*/








/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package breakfast.club;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import java.util.*;
import java.io.*;

/**
 *
 * @author jwvandyke
 */
public class LaunchWindow extends javax.swing.JFrame {

    public LaunchWindow() {
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

        btnLoad = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDisplay = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaNums = new javax.swing.JTextArea();
        lblTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btnLoad.setText("Load");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDisplay.setText("Display Histogram");
        btnDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisplayActionPerformed(evt);
            }
        });

        txtAreaNums.setColumns(20);
        txtAreaNums.setLineWrap(true);
        txtAreaNums.setRows(5);
        jScrollPane1.setViewportView(txtAreaNums);

        lblTitle.setFont(new java.awt.Font("Brush Script MT", 0, 54)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("The Breakfast Club Histogram");
        lblTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 552, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLoad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(btnLoad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDisplay)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        FileReader fr = null;
        BufferedReader br = null;
        JFileChooser fc = new JFileChooser();
        int x = fc.showOpenDialog(fc);
        
        ArrayList al = new ArrayList();
        
        
        try {
        
            fr = new FileReader(fc.getSelectedFile());
            br = new BufferedReader(fr);
            Scanner in = new Scanner(br);
            
            while (in.hasNextDouble()) {
                
                Double num = in.nextDouble();
                
                txtAreaNums.append(num.toString() + " ");
                
            }
            
            
        }
        
        catch (FileNotFoundException fnf) {
            
            
            
        }
        try
        {
            
            br.close();
            fr.close(); 
        }
        catch(IOException e)
        {
        
        }

        
    }//GEN-LAST:event_btnLoadActionPerformed
 
    private void btnDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisplayActionPerformed
        
        HistogramDisplay hd = new HistogramDisplay(this);
        hd.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_btnDisplayActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        BufferedWriter fBuffWriter = null;
        FileWriter fw = null;
        JFileChooser fcw = new JFileChooser();
        int x = fcw.showSaveDialog(fcw);
        //if (x == JFileChooser.APPROVE_OPTION) {
        
        try{
            fw = new FileWriter(fcw.getSelectedFile());
            fBuffWriter = new BufferedWriter(fw);
            fBuffWriter.write(txtAreaNums.getText());
            
            fBuffWriter.flush();
            fBuffWriter.close();
            fw.flush();
            fw.close();

        }
        catch(IOException e)
        {
            //JOptionPane.showMessageDialog(this, "The Text could not be Saved!", "Error!", JOptionPane.INFORMATION_MESSAGE);
        }

        
    }//GEN-LAST:event_btnSaveActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDisplay;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnSave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextArea txtAreaNums;
    // End of variables declaration//GEN-END:variables
}







