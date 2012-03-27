/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * reportFilter.java
 *
 * Created on Feb 22, 2012, 11:12:12 AM
 */
package org.sleuthkit.autopsy.report;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import org.sleuthkit.autopsy.casemodule.Case;
import org.sleuthkit.datamodel.SleuthkitCase;
import org.sleuthkit.datamodel.TskException;
/**
 *
 * @author Alex
 */
public class reportFilter extends javax.swing.JPanel {
  public static ArrayList<Integer> filters = new ArrayList();
  public final reportFilter panel = this;
  reportPanelAction rpa = new reportPanelAction();
  public static boolean cancel = false;
  Case currentCase = Case.getCurrentCase(); // get the most updated case
  SleuthkitCase skCase = currentCase.getSleuthkitCase();
    /** Creates new form reportFilter */
    public reportFilter() { 
        initComponents();
        cancel = false;
       
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        progBar = new javax.swing.JProgressBar();
        cancelButton = new javax.swing.JButton();

        jButton2.setText(org.openide.util.NbBundle.getMessage(reportFilter.class, "reportFilter.jButton2.text")); // NOI18N
        jButton2.setActionCommand(org.openide.util.NbBundle.getMessage(reportFilter.class, "reportFilter.jButton2.actionCommand")); // NOI18N
        jButton2.setLabel(org.openide.util.NbBundle.getMessage(reportFilter.class, "reportFilter.jButton2.label")); // NOI18N

        setPreferredSize(new java.awt.Dimension(250, 193));

        jCheckBox1.setSelected(true);
        jCheckBox1.setText(org.openide.util.NbBundle.getMessage(reportFilter.class, "reportFilter.jCheckBox1.text")); // NOI18N
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setSelected(true);
        jCheckBox2.setText(org.openide.util.NbBundle.getMessage(reportFilter.class, "reportFilter.jCheckBox2.text")); // NOI18N

        jCheckBox3.setSelected(true);
        jCheckBox3.setText(org.openide.util.NbBundle.getMessage(reportFilter.class, "reportFilter.jCheckBox3.text")); // NOI18N

        jCheckBox4.setSelected(true);
        jCheckBox4.setText(org.openide.util.NbBundle.getMessage(reportFilter.class, "reportFilter.jCheckBox4.text")); // NOI18N

        jCheckBox5.setSelected(true);
        jCheckBox5.setText(org.openide.util.NbBundle.getMessage(reportFilter.class, "reportFilter.jCheckBox5.text")); // NOI18N

        jButton1.setText(org.openide.util.NbBundle.getMessage(reportFilter.class, "reportFilter.jButton1.text")); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        progBar.setDoubleBuffered(true);
        progBar.setEnabled(false);
        progBar.setName(""); // NOI18N
        progBar.setPreferredSize(new java.awt.Dimension(146, 15));
        progBar.setStringPainted(true);

        cancelButton.setText(org.openide.util.NbBundle.getMessage(reportFilter.class, "reportFilter.cancelButton.text")); // NOI18N
        cancelButton.setActionCommand(org.openide.util.NbBundle.getMessage(reportFilter.class, "reportFilter.cancelButton.actionCommand")); // NOI18N
        cancelButton.setEnabled(false);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCheckBox2)
                                            .addComponent(jCheckBox1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCheckBox5)
                                            .addComponent(jCheckBox4))))
                                .addGap(69, 69, 69))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cancelButton)
                                .addGap(156, 156, 156)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(progBar, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(109, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox5))
                .addGap(18, 18, 18)
                .addComponent(jCheckBox3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progBar, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
           
}//GEN-LAST:event_jCheckBox1ActionPerformed

public void getfilters(java.awt.event.ActionEvent evt)
{
    jButton1ActionPerformed(evt);
}

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   
      jButton1.setEnabled(false);
    progBar.setEnabled(true);
    cancelButton.setEnabled(true);
    progBar.setStringPainted(true);
    progBar.setValue(0); 
    filters.clear();
    if(jCheckBox1.isSelected())
    {
        filters.add(2);
        filters.add(3);
        filters.add(4);
        filters.add(5);
    }
    if(jCheckBox2.isSelected())
    {
        filters.add(1);
    }
    if(jCheckBox3.isSelected())
    {
        filters.add(9);
    }
    if(jCheckBox4.isSelected())
    {
        filters.add(10);
    }
    if(jCheckBox5.isSelected())
    {
        filters.add(6);
        filters.add(8);
    }
   getReports();
}//GEN-LAST:event_jButton1ActionPerformed

public void getReports() {
  new SwingWorker<Void, Void>() {
     protected Void doInBackground() throws Exception {
        rpa.reportGenerate(filters, panel);
        return null;
     };

     // this is called when the SwingWorker's doInBackground finishes
     protected void done() {
        progBar.setVisible(false); // hide my progress bar JFrame
     };
  }.execute();
  progBar.setVisible(true);
}

private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
    cancelButton.setText("Cancelled!");
    cancel = true;
}//GEN-LAST:event_cancelButtonActionPerformed

private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased

}//GEN-LAST:event_jButton1MouseReleased

public void progBarSet(int cc)
{
    final int count = cc;
     SwingUtilities.invokeLater(new Runnable() {
    public void run() {
       int start = progBar.getValue();
       int end = start + count;
       progBar.setValue(end);
               }});
}

public void progBarDone(){
   int max = progBar.getMaximum();
   progBar.setValue(max);
   jButton2.doClick();
}

public void progBarText(){
    progBar.setString("Populating Report - Please wait...");
    progBar.setIndeterminate(true);
}

public void progBarCount(int count){
    progBar.setMaximum(count);
}

public void setjButton1ActionListener(ActionListener e){
      jButton1.addActionListener(e);
      
    }

public void setjButton2ActionListener(ActionListener e){
      jButton2.addActionListener(e);
      cancelButton.addActionListener(e);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JProgressBar progBar;
    // End of variables declaration//GEN-END:variables

}
