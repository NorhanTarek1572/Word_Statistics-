package GUI;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
// my code 
import Shared_resources.Path;
import static Shared_resources.Path.isEmpty;
import Theads.ConsumeFile;
import Theads.DiscoverFiles;
import Theads.DiscoverSubdirs;
import Operations_on_files.DirectoryContainer;
import Operations_on_files.FileContainer;
// GUI packages 
import java.awt.Toolkit;
import java.io.File;
import javax.swing.JFileChooser;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;

public class ResultFrame extends javax.swing.JFrame {

    private volatile static ResultFrame uniqueIstance; // This ensures that only one instance of the ResultFrame exists at a time

    private ResultFrame() {
        initComponents(); //  initializing the GUI components of the ResultFrame
        this.setLocationRelativeTo(null); // make this window to be centered on the screen

    }

    // this code to prevent race conditions.
    public static ResultFrame getInstance() { // this method implements the singleton pattern
        if (uniqueIstance == null) {
            synchronized (ResultFrame.class) { // This ensures that only one thread can access the code within the block at a time
                uniqueIstance = new ResultFrame();
            }
        }
        return uniqueIstance;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DirectoryTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        FileTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        DirectoryChooser = new javax.swing.JButton();
        ShowBtn = new javax.swing.JButton();
        SubDirsCheckBox = new javax.swing.JCheckBox();
        DirPath = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        DirectoryChooser1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WordStatistics");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 204, 255));
        setBounds(new java.awt.Rectangle(10, 10, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Algerian", 0, 10)); // NOI18N
        setMinimumSize(new java.awt.Dimension(1000, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(1200, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 102));
        jLabel1.setText("File statistics:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 191, 34));

        DirectoryTable.setBackground(new java.awt.Color(153, 153, 153));
        DirectoryTable.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        DirectoryTable.setForeground(new java.awt.Color(102, 0, 102));
        DirectoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N", "Directory name", "Number of words", "Latest Longest word", "Latest Shortest word", "Number of 'is'", "Number of 'are'", "Number of 'you'"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.Long.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DirectoryTable.setShowGrid(true);
        DirectoryTable.getTableHeader().setReorderingAllowed(false);
        DirectoryTable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                DirectoryTablePropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(DirectoryTable);
        if (DirectoryTable.getColumnModel().getColumnCount() > 0) {
            DirectoryTable.getColumnModel().getColumn(0).setResizable(false);
            DirectoryTable.getColumnModel().getColumn(0).setHeaderValue("N");
            DirectoryTable.getColumnModel().getColumn(1).setResizable(false);
            DirectoryTable.getColumnModel().getColumn(2).setResizable(false);
            DirectoryTable.getColumnModel().getColumn(2).setHeaderValue("Number of words");
            DirectoryTable.getColumnModel().getColumn(3).setResizable(false);
            DirectoryTable.getColumnModel().getColumn(4).setResizable(false);
            DirectoryTable.getColumnModel().getColumn(5).setResizable(false);
            DirectoryTable.getColumnModel().getColumn(5).setHeaderValue("Number of 'is'");
            DirectoryTable.getColumnModel().getColumn(6).setResizable(false);
            DirectoryTable.getColumnModel().getColumn(6).setHeaderValue("Number of 'are'");
            DirectoryTable.getColumnModel().getColumn(7).setResizable(false);
            DirectoryTable.getColumnModel().getColumn(7).setHeaderValue("Number of 'you'");
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 950, 80));

        FileTable.setBackground(new java.awt.Color(153, 153, 153));
        FileTable.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(46, 3, 69)));
        FileTable.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        FileTable.setForeground(new java.awt.Color(102, 0, 102));
        FileTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N", "File name", "Number of words", "Latest Longest word", "Latest Shortest word", "Number of 'is'", "Number of 'are'", "Number of 'you'"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.Long.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        FileTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        FileTable.getTableHeader().setReorderingAllowed(false);
        FileTable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                FileTablePropertyChange(evt);
            }
        });
        jScrollPane2.setViewportView(FileTable);
        if (FileTable.getColumnModel().getColumnCount() > 0) {
            FileTable.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 950, 300));

        jLabel3.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 102));
        jLabel3.setText("Directory statistics:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 240, 34));

        DirectoryChooser.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        DirectoryChooser.setForeground(new java.awt.Color(102, 0, 102));
        DirectoryChooser.setText("Browse");
        DirectoryChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DirectoryChooserActionPerformed(evt);
            }
        });
        getContentPane().add(DirectoryChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 150, -1));

        ShowBtn.setFont(new java.awt.Font("Algerian", 0, 18)); // NOI18N
        ShowBtn.setForeground(new java.awt.Color(102, 0, 102));
        ShowBtn.setText("Start processing");
        ShowBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowBtnActionPerformed(evt);
            }
        });
        getContentPane().add(ShowBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 230, 30));

        SubDirsCheckBox.setFont(new java.awt.Font("Algerian", 2, 16)); // NOI18N
        SubDirsCheckBox.setForeground(new java.awt.Color(102, 0, 102));
        SubDirsCheckBox.setText("Include subdirectories?");
        SubDirsCheckBox.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SubDirsCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubDirsCheckBoxActionPerformed(evt);
            }
        });
        getContentPane().add(SubDirsCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        DirPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DirPathActionPerformed(evt);
            }
        });
        getContentPane().add(DirPath, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 500, -1));

        jLabel2.setFont(new java.awt.Font("Algerian", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 102));
        jLabel2.setText("Enter a Directory Path:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        DirectoryChooser1.setFont(new java.awt.Font("Algerian", 0, 16)); // NOI18N
        DirectoryChooser1.setForeground(new java.awt.Color(102, 0, 102));
        DirectoryChooser1.setText("Clear");
        DirectoryChooser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DirectoryChooser1ActionPerformed(evt);
            }
        });
        getContentPane().add(DirectoryChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 50, 150, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void DirectoryTablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_DirectoryTablePropertyChange
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < DirectoryTable.getColumnCount(); ++i) {
            DirectoryTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }//GEN-LAST:event_DirectoryTablePropertyChange

    public javax.swing.JTable getDirectoryTable() {
        return DirectoryTable;
    }

    private void FileTablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_FileTablePropertyChange
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < FileTable.getColumnCount(); ++i) {
            FileTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }//GEN-LAST:event_FileTablePropertyChange
// Browse
    private void DirectoryChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DirectoryChooserActionPerformed
     
            JFileChooser folderChooser = new JFileChooser(); // to display the file selection dialog.
            folderChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

            folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            folderChooser.setAcceptAllFileFilterUsed(false); //only select directories
            if (folderChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File selectedFolder = folderChooser.getSelectedFile();
                if (selectedFolder != null) {
                    DirPath.setText(""); // Clear the existing text before setting the new path
                    DirPath.setText(selectedFolder.getAbsolutePath());
                    // DirPath.setText(selectedFolder.getAbsolutePath())
                } else {
                    Toolkit.getDefaultToolkit().beep();
                    showMessageDialog(null, "Please select a valid directory.");
                }
            } else {
                Toolkit.getDefaultToolkit().beep();
                showMessageDialog(null, "Please select a path.");
            }
     


    }//GEN-LAST:event_DirectoryChooserActionPerformed
//Start processing
    private void ShowBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowBtnActionPerformed
    
       String path = DirPath.getText();
        if (Path.isValid(path)) {
            ShowBtn.setEnabled(false);
            if (Shared_resources.Path.isEmpty(path) == false) { 
                DirectoryContainer.add(path);
                if (SubDirsCheckBox.isSelected()) {

                    Thread t = new Thread(new DiscoverSubdirs(path));
                    t.start();
                }
                Thread t = new Thread(new DiscoverFiles(path));
                t.start();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {}
                        ConsumeFile.consume();} }).start();
            }
        }
        else{
             Toolkit.getDefaultToolkit().beep();
            showMessageDialog(null, "Please select a valid directory.");
        }


    }//GEN-LAST:event_ShowBtnActionPerformed

    private void SubDirsCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubDirsCheckBoxActionPerformed

    }//GEN-LAST:event_SubDirsCheckBoxActionPerformed

    private void DirPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DirPathActionPerformed

    }//GEN-LAST:event_DirPathActionPerformed
// restart 
    private void DirectoryChooser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DirectoryChooser1ActionPerformed
        try {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    // Clear tables and internal state
                    uniqueIstance = null;
                    DirectoryContainer.clearTablesAndInternalState();
                    FileContainer.clearTablesAndInternalState();
                    ((DefaultTableModel) DirectoryTable.getModel()).setRowCount(0);
                    ((DefaultTableModel) FileTable.getModel()).setRowCount(0);

                    ShowBtn.setEnabled(true);
                    DirPath.setText("");

                }
            });

        } catch (Exception e) {
            Toolkit.getDefaultToolkit().beep();
            showMessageDialog(null, "Please Run the program again.");
        }


    }//GEN-LAST:event_DirectoryChooser1ActionPerformed
    public javax.swing.JTable getFileTable() {
        return FileTable;
    }

    // allowing the creation of a new ResultFrame instance
    private static void clear() {

        uniqueIstance = null;
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                getInstance().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DirPath;
    private javax.swing.JButton DirectoryChooser;
    private javax.swing.JButton DirectoryChooser1;
    private javax.swing.JTable DirectoryTable;
    private javax.swing.JTable FileTable;
    private javax.swing.JButton ShowBtn;
    private javax.swing.JCheckBox SubDirsCheckBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

}
