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

import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.netbeans.api.settings.ConvertAsProperties;

/**
 * Top component with saved searches viewer
 */
@ConvertAsProperties(dtd = "-//org.sleuthkit.autopsy.keywordsearch//KeywordSearchHistory//EN",
autostore = false)
@TopComponent.Description(preferredID = "KeywordSearchHistoryTopComponent",
//iconBase="SET/PATH/TO/ICON/HERE", 
persistenceType = TopComponent.PERSISTENCE_NEVER)
@TopComponent.Registration(mode = "explorer", openAtStartup = false)
//@ActionID(category = "Window", id = "org.sleuthkit.autopsy.keywordsearch.KeywordSearchHistoryTopComponent")
//@ActionReference(path = "Menu/Window" /*, position = 333 */)
//@TopComponent.OpenActionRegistration(displayName = "#CTL_KeywordSearchHistoryAction",
//preferredID = "KeywordSearchHistoryTopComponent")
public final class KeywordSearchHistoryTopComponent extends TopComponent implements KeywordSearchTopComponentInterface {

    private Logger logger = Logger.getLogger(KeywordSearchHistoryTopComponent.class.getName());

    public KeywordSearchHistoryTopComponent() {
        initComponents();
        customizeComponents();
        setName(NbBundle.getMessage(KeywordSearchHistoryTopComponent.class, "CTL_KeywordSearchHistoryTopComponent"));
        setToolTipText(NbBundle.getMessage(KeywordSearchHistoryTopComponent.class, "HINT_KeywordSearchHistoryTopComponent"));
        putClientProperty(TopComponent.PROP_UNDOCKING_DISABLED, Boolean.TRUE);

    }

    private void customizeComponents() {
        hitsTable.setToolTipText("Saved searches with hits: click on the row to view search results.");
        nohitsTable.setToolTipText("Saved searches without hits.");

        hitsTable.setAutoscrolls(true);
        hitsTable.setShowHorizontalLines(false);
        hitsTable.setShowVerticalLines(false);

        hitsTable.getParent().setBackground(hitsTable.getBackground());

        //customize column witdhs
        hitsTable.setSize(260, 200);
        final int width = hitsTable.getSize().width;
        TableColumn column = null;
        for (int i = 0; i < 2; i++) {
            column = hitsTable.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setCellRenderer(new CellTooltipRenderer());
                    column.setPreferredWidth(((int) (width * 0.80)));
                    column.setResizable(true);
                    break;
                case 1:
                    column.setPreferredWidth(((int) (width * 0.15)));
                    column.setResizable(false);
                    break;
                default:
                    break;

            }

        }
        hitsTable.setCellSelectionEnabled(false);


        nohitsTable.setAutoscrolls(true);
        nohitsTable.setShowHorizontalLines(false);
        nohitsTable.setShowVerticalLines(false);
        nohitsTable.getParent().setBackground(nohitsTable.getBackground());

        //customize column witdhs
        nohitsTable.setSize(260, 200);

        column = nohitsTable.getColumnModel().getColumn(0);
        column.setCellRenderer(new CellTooltipRenderer());
        nohitsTable.setCellSelectionEnabled(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topLabel = new javax.swing.JLabel();
        filesIndexedNameLabel = new javax.swing.JLabel();
        filesIndexedValLabel = new javax.swing.JLabel();
        withHitsLabel = new javax.swing.JLabel();
        noHitsLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        hitsTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        nohitsTable = new javax.swing.JTable();

        org.openide.awt.Mnemonics.setLocalizedText(topLabel, org.openide.util.NbBundle.getMessage(KeywordSearchHistoryTopComponent.class, "KeywordSearchHistoryTopComponent.topLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(filesIndexedNameLabel, org.openide.util.NbBundle.getMessage(KeywordSearchHistoryTopComponent.class, "KeywordSearchHistoryTopComponent.filesIndexedNameLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(filesIndexedValLabel, org.openide.util.NbBundle.getMessage(KeywordSearchHistoryTopComponent.class, "KeywordSearchHistoryTopComponent.filesIndexedValLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(withHitsLabel, org.openide.util.NbBundle.getMessage(KeywordSearchHistoryTopComponent.class, "KeywordSearchHistoryTopComponent.withHitsLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(noHitsLabel, org.openide.util.NbBundle.getMessage(KeywordSearchHistoryTopComponent.class, "KeywordSearchHistoryTopComponent.noHitsLabel.text")); // NOI18N

        hitsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Keyword", "#Hits"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        hitsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(hitsTable);

        nohitsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Keyword"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        nohitsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(nohitsTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(topLabel)
                    .addComponent(withHitsLabel)
                    .addComponent(noHitsLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(filesIndexedNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(filesIndexedValLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(topLabel)
                .addGap(27, 27, 27)
                .addComponent(withHitsLabel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(noHitsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filesIndexedNameLabel)
                    .addComponent(filesIndexedValLabel))
                .addContainerGap(34, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel filesIndexedNameLabel;
    private javax.swing.JLabel filesIndexedValLabel;
    private javax.swing.JTable hitsTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel noHitsLabel;
    private javax.swing.JTable nohitsTable;
    private javax.swing.JLabel topLabel;
    private javax.swing.JLabel withHitsLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void componentOpened() {
    }

    @Override
    public void componentClosed() {
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");

    }

    void readProperties(java.util.Properties p) {
    }

    @Override
    public void addSearchButtonListener(ActionListener l) {
    }

    @Override
    public List<Keyword> getQueryList() {
        return null;
    }

    @Override
    public String getQueryText() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isLuceneQuerySelected() {
        return false;
    }

    @Override
    public boolean isMultiwordQuery() {
        return false;
    }

    @Override
    public boolean isRegexQuerySelected() {
        return false;
    }

    @Override
    public void setFilesIndexed(int filesIndexed) {
        filesIndexedValLabel.setText(Integer.toString(filesIndexed));
    }

    /**
     * tooltips that show text
     */
    private static class CellTooltipRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(
                JTable table, Object value,
                boolean isSelected, boolean hasFocus,
                int row, int column) {

            if (column == 0) {
                String val = (String) table.getModel().getValueAt(row, column);
                setToolTipText(val);
                setText(val);
            } else if (column == 1) {
                Integer ival = (Integer) table.getModel().getValueAt(row, column);
                String val = Integer.toString(ival);
                setToolTipText(val);
                setText(val);
            }
            return this;
        }
    }
}
