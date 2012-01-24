/*
 * Autopsy Forensic Browser
 *
 * Copyright 2011 Basis Technology Corp.
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
package org.sleuthkit.autopsy.keywordsearch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import org.openide.windows.TopComponent;

/**
 * Top component for Simple keyword search
 * 
 */
public class KeywordSearchSimpleTopComponent extends TopComponent implements KeywordSearchTopComponentInterface {

    private Logger logger = Logger.getLogger(KeywordSearchSimpleTopComponent.class.getName());

    /** Creates new form KeywordSearchSimpleTopComponent */
    public KeywordSearchSimpleTopComponent() {
        initComponents();
        customizeComponents();
        setName("Simple");
        searchButton.setEnabled(false);

        putClientProperty(TopComponent.PROP_CLOSING_DISABLED, Boolean.TRUE);
    }

    private void customizeComponents() {
        searchButton.setToolTipText("Execute a keyword search using the query specified.");
        chRegex.setToolTipText("Select if keyword is a regular expression");
        queryTextField.setToolTipText("<html>For non-regex search enter one or more keywords separated by white-space.<br />"
                + "For a regular expression search, enter a valid regular expression.<br />"
                + "Examples (in double-quotes): \"\\d\\d\\d-\\d\\d\\d\" \\d{8,10} \"phone\" \"ftp|sftp|ssh|http|https|www\".<br />"
                + "Note: a word can be also searched using a regex search.<br />Regex containing whitespace [ \\s] matches are currently not supported.</html>");
        
        queryTextField.setComponentPopupMenu(rightClickMenu);
        ActionListener actList = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JMenuItem jmi = (JMenuItem) e.getSource();
                if(jmi.equals(cutMenuItem))
                    queryTextField.cut();
                else if(jmi.equals(copyMenuItem))
                    queryTextField.copy();
                else if(jmi.equals(pasteMenuItem))
                    queryTextField.paste();
                else if(jmi.equals(selectAllMenuItem))
                    queryTextField.selectAll();
            }
        };
        cutMenuItem.addActionListener(actList);
        copyMenuItem.addActionListener(actList);
        pasteMenuItem.addActionListener(actList);
        selectAllMenuItem.addActionListener(actList);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainScrollPane = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();
        filesIndexedValLabel = new javax.swing.JLabel();
        rightClickMenu = new javax.swing.JPopupMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        selectAllMenuItem = new javax.swing.JMenuItem();
        filesIndexedNameLabel = new javax.swing.JLabel();
        searchPanel = new javax.swing.JPanel();
        queryTextField = new javax.swing.JTextField();
        chRegex = new javax.swing.JCheckBox();
        searchButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();

        cutMenuItem.setText(org.openide.util.NbBundle.getMessage(KeywordSearchSimpleTopComponent.class, "KeywordSearchSimpleTopComponent.cutMenuItem.text")); // NOI18N
        rightClickMenu.add(cutMenuItem);

        copyMenuItem.setText(org.openide.util.NbBundle.getMessage(KeywordSearchSimpleTopComponent.class, "KeywordSearchSimpleTopComponent.copyMenuItem.text")); // NOI18N
        rightClickMenu.add(copyMenuItem);

        pasteMenuItem.setText(org.openide.util.NbBundle.getMessage(KeywordSearchSimpleTopComponent.class, "KeywordSearchSimpleTopComponent.pasteMenuItem.text")); // NOI18N
        rightClickMenu.add(pasteMenuItem);

        selectAllMenuItem.setText(org.openide.util.NbBundle.getMessage(KeywordSearchSimpleTopComponent.class, "KeywordSearchSimpleTopComponent.selectAllMenuItem.text")); // NOI18N
        rightClickMenu.add(selectAllMenuItem);

        setAutoscrolls(true);

        mainScrollPane.setPreferredSize(new java.awt.Dimension(351, 249));

        mainPanel.setPreferredSize(new java.awt.Dimension(351, 249));

        filesIndexedValLabel.setText(org.openide.util.NbBundle.getMessage(KeywordSearchSimpleTopComponent.class, "KeywordSearchSimpleTopComponent.filesIndexedValLabel.text")); // NOI18N

        filesIndexedNameLabel.setText(org.openide.util.NbBundle.getMessage(KeywordSearchSimpleTopComponent.class, "KeywordSearchSimpleTopComponent.filesIndexedNameLabel.text")); // NOI18N

        searchPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        queryTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        queryTextField.setText(org.openide.util.NbBundle.getMessage(KeywordSearchSimpleTopComponent.class, "KeywordSearchSimpleTopComponent.queryTextField.text")); // NOI18N
        queryTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queryTextFieldActionPerformed(evt);
            }
        });

        chRegex.setText(org.openide.util.NbBundle.getMessage(KeywordSearchSimpleTopComponent.class, "KeywordSearchSimpleTopComponent.chRegex.text")); // NOI18N
        chRegex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chRegexActionPerformed(evt);
            }
        });

        searchButton.setText(org.openide.util.NbBundle.getMessage(KeywordSearchSimpleTopComponent.class, "KeywordSearchSimpleTopComponent.searchButton.text")); // NOI18N

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chRegex)
                    .addComponent(queryTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                    .addComponent(searchButton))
                .addContainerGap())
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(queryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chRegex)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchButton)
                .addContainerGap())
        );

        titleLabel.setFont(new java.awt.Font("Tahoma", 0, 12));
        titleLabel.setText(org.openide.util.NbBundle.getMessage(KeywordSearchSimpleTopComponent.class, "KeywordSearchSimpleTopComponent.titleLabel.text")); // NOI18N

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(filesIndexedNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filesIndexedValLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(titleLabel)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(searchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(84, 84, 84))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addGap(18, 18, 18)
                .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filesIndexedNameLabel)
                    .addComponent(filesIndexedValLabel))
                .addContainerGap(94, Short.MAX_VALUE))
        );

        filesIndexedValLabel.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(KeywordSearchSimpleTopComponent.class, "KeywordSearchTopComponent.filesIndexedValLabel.AccessibleContext.accessibleName")); // NOI18N
        filesIndexedNameLabel.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(KeywordSearchSimpleTopComponent.class, "KeywordSearchTopComponent.filesIndexedNameLabel.AccessibleContext.accessibleName")); // NOI18N

        mainScrollPane.setViewportView(mainPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void chRegexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chRegexActionPerformed

    }//GEN-LAST:event_chRegexActionPerformed

    private void queryTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queryTextFieldActionPerformed

    }//GEN-LAST:event_queryTextFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chRegex;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JLabel filesIndexedNameLabel;
    private javax.swing.JLabel filesIndexedValLabel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane mainScrollPane;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JTextField queryTextField;
    private javax.swing.JPopupMenu rightClickMenu;
    private javax.swing.JButton searchButton;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JMenuItem selectAllMenuItem;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    protected void componentOpened() {
        // clear old search
        queryTextField.setText("");
    }

    @Override
    public boolean isMultiwordQuery() {
        return false;
    }

    @Override
    public void addSearchButtonListener(ActionListener l) {
        searchButton.addActionListener(l);
        queryTextField.addActionListener(l);
    }

    @Override
    public String getQueryText() {
        return queryTextField.getText().trim();
    }

    @Override
    public List<Keyword> getQueryList() {
        return null;
    }

    @Override
    public boolean isLuceneQuerySelected() {
        return !chRegex.isSelected();
    }

    @Override
    public boolean isRegexQuerySelected() {
        return chRegex.isSelected();
    }

    /**
     * Overwrite when you want to change default persistence type. Default
     * persistence type is PERSISTENCE_ALWAYS
     * 
     * @return TopComponent.PERSISTENCE_NEVER
     */
    @Override
    public int getPersistenceType() {
        return TopComponent.PERSISTENCE_NEVER;
    }

    @Override
    public void setFilesIndexed(int filesIndexed) {
        filesIndexedValLabel.setText(Integer.toString(filesIndexed));
        if (filesIndexed == 0) {
            searchButton.setEnabled(false);
        } else {
            searchButton.setEnabled(true);
        }
    }
}
