/*
 * Central Repository
 *
 * Copyright 2015-2017 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sleuthkit.autopsy.centralrepository.optionspanel;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JFrame;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.WindowManager;
import org.sleuthkit.autopsy.coreutils.Logger;
import org.sleuthkit.autopsy.centralrepository.datamodel.EamArtifact;
import org.sleuthkit.autopsy.centralrepository.datamodel.EamDbException;
import org.sleuthkit.autopsy.centralrepository.datamodel.EamDb;

/**
 * Dialog to handle management of artifact types handled by the Central
 *  Repository
 */
final class ManageCorrelationPropertiesDialog extends javax.swing.JDialog {

    private static final Logger LOGGER = Logger.getLogger(ManageCorrelationPropertiesDialog.class.getName());

    private final List<EamArtifact.Type> eamArtifactTypes;

    /**
     * Displays a dialog that allows a user to select which Type(s) should be
     * used for Correlation during ingest.
     */
    @Messages({"ManageCorrelationPropertiesDialog.title=Manage Correlation Properties"})
    ManageCorrelationPropertiesDialog() {
        super((JFrame) WindowManager.getDefault().getMainWindow(),
                Bundle.ManageCorrelationPropertiesDialog_title(),
                true); // NON-NLS
        this.eamArtifactTypes = new ArrayList<>();
        initComponents();
        customizeComponents();
        display();
        valid();
    }

    private void customizeComponents() {
        lbWarningMsg.setText("");

        loadData();
    }

    private void loadData() {
        DefaultTableModel model = (DefaultTableModel) tbCorrelatableTypes.getModel();
        try {
            EamDb dbManager = EamDb.getInstance();
            eamArtifactTypes.clear();
            eamArtifactTypes.addAll(dbManager.getCorrelationArtifactTypes());
        } catch (EamDbException ex) {
            Exceptions.printStackTrace(ex);
        }

        eamArtifactTypes.forEach((aType) -> {
            model.addRow(new Object[]{aType.getName(), aType.isEnabled()});
        });
        model.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent evt) {
                int row = evt.getFirstRow();
                TableModel model = (TableModel) evt.getSource();
                Object typeName = model.getValueAt(row, 0);
                Boolean enabled = (Boolean) model.getValueAt(row, 1);

                eamArtifactTypes.stream().filter((aType) -> (aType.getName().equals(typeName))).forEachOrdered((aType) -> {
                    aType.setEnabled(enabled);
                });
                valid();
            }
        });
    }

    private void display() {
        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screenDimension.width - getSize().width) / 2, (screenDimension.height - getSize().height) / 2);
        setVisible(true);
    }

    @Messages({"ManageCorrelationPropertiesDialog.noneSelected=There are no correlation properties enabled."})
    private boolean valid() {
        lbWarningMsg.setText("");

        int countEnabled = 0;
        countEnabled = eamArtifactTypes.stream().filter((aType) -> (aType.isEnabled())).map((_item) -> 1).reduce(countEnabled, Integer::sum);

        if (0 == countEnabled) {
            lbWarningMsg.setText(Bundle.ManageCorrelationPropertiesDialog_noneSelected());
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCorrelatableTypes = new javax.swing.JTable();
        lbWarningMsg = new javax.swing.JLabel();
        taInstructions = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        org.openide.awt.Mnemonics.setLocalizedText(okButton, org.openide.util.NbBundle.getMessage(ManageCorrelationPropertiesDialog.class, "ManageCorrelationPropertiesDialog.okButton.text")); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(cancelButton, org.openide.util.NbBundle.getMessage(ManageCorrelationPropertiesDialog.class, "ManageCorrelationPropertiesDialog.cancelButton.text")); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setMinimumSize(new java.awt.Dimension(150, 23));

        tbCorrelatableTypes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Correlation Properties", "Enable"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbCorrelatableTypes.setMaximumSize(new java.awt.Dimension(400, 0));
        tbCorrelatableTypes.setMinimumSize(new java.awt.Dimension(150, 0));
        jScrollPane1.setViewportView(tbCorrelatableTypes);

        lbWarningMsg.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbWarningMsg.setForeground(new java.awt.Color(255, 0, 0));
        org.openide.awt.Mnemonics.setLocalizedText(lbWarningMsg, org.openide.util.NbBundle.getMessage(ManageCorrelationPropertiesDialog.class, "ManageCorrelationPropertiesDialog.lbWarningMsg.text")); // NOI18N

        taInstructions.setEditable(false);
        taInstructions.setBackground(new java.awt.Color(240, 240, 240));
        taInstructions.setColumns(20);
        taInstructions.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        taInstructions.setLineWrap(true);
        taInstructions.setRows(5);
        taInstructions.setText(org.openide.util.NbBundle.getMessage(ManageCorrelationPropertiesDialog.class, "ManageArtifactTypesDialog.taInstructionsMsg.text")); // NOI18N
        taInstructions.setWrapStyleWord(true);
        taInstructions.setAutoscrolls(false);
        taInstructions.setBorder(null);
        taInstructions.setFocusable(false);
        taInstructions.setRequestFocusEnabled(false);
        taInstructions.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(taInstructions)
                    .addComponent(lbWarningMsg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(okButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelButton, okButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(taInstructions, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbWarningMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    @Messages({"ManageCorrelationPropertiesDialog.okbutton.failure=Error saving updated selections."})
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed

        if (0 == eamArtifactTypes.size()) {
            dispose();
        } else {
            EamDb dbManager = EamDb.getInstance();
            eamArtifactTypes.forEach((aType) -> {
                try {
                    dbManager.updateCorrelationArtifactType(aType);
                    dispose();
                } catch (EamDbException ex) {
                    LOGGER.log(Level.SEVERE, "Failed to update correlation properties with selections from dialog.", ex); // NON-NLS
                    lbWarningMsg.setText(Bundle.ManageCorrelationPropertiesDialog_okbutton_failure());
                }
            });
        }
    }//GEN-LAST:event_okButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbWarningMsg;
    private javax.swing.JButton okButton;
    private javax.swing.JTextArea taInstructions;
    private javax.swing.JTable tbCorrelatableTypes;
    // End of variables declaration//GEN-END:variables
}