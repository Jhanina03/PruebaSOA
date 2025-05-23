/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Controllers.APIs.APICursos;
import Controllers.APIs.APIEstudiantes;
import Controllers.Parsers.Responses.ResponseCurso;
import Controllers.Parsers.Responses.ResponseEstudiante;
import Models.Curso;
import Models.CursoEstudiante;
import Models.Estudiante;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class TablaEstudiantes extends javax.swing.JFrame {

    private ArrayList<Estudiante> estudiantes;

    protected void acualizarTabla() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Cedula");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Direccion");
        model.addColumn("Telefono");
        try {
            APIEstudiantes api = new APIEstudiantes("http://localhost/MVC/Controllers/APIRest.php");
            api.GET(); // llamada GET sin filtros 
            ResponseEstudiante response = new ResponseEstudiante(api);
            this.estudiantes = response.parseResponses(); // lista de estudiantes 
            for (Estudiante estudiante : this.estudiantes) {
                model.addRow(new Object[]{
                    estudiante.cedula,
                    estudiante.nombre,
                    estudiante.apellido,
                    estudiante.direccion,
                    estudiante.telefono
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar los estudiantes");
        }
        this.jTblEstudiantes.setModel(model);
    }

    private Estudiante getSelectedEstudiante() {
        int index = this.jTblEstudiantes.getSelectedRow();
        Estudiante current = this.estudiantes.get(index);
        return current;
    }

    private void cargarCursos() {
        try {
            APICursos api = new APICursos("http://localhost/MVC/Controllers/APIRestCurso.php");
            api.GET();
            ResponseCurso response = new ResponseCurso(api);
            ArrayList<Curso> cursos = response.parseResponses();

            DefaultComboBoxModel<Curso> model = new DefaultComboBoxModel<>();
            for (Curso c : cursos) {
                model.addElement(c);
            }
            this.comboBoxCursos.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar los cursos");
        }
    }

    /**
     * Creates new form TablaEstudiantes
     */
    public TablaEstudiantes() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(2);
        this.acualizarTabla();
        this.cargarCursos();
    }
//    private void cargarCursos() {
//    ArrayList<Curso> cursos = this.facadecurso.getCursos();
//    for (Curso curso : cursos) {
//        comboBoxCursos.addItem(curso); // Suponiendo que tu combo se llama así
//    }
//}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPnl0 = new javax.swing.JPanel();
        jBtnBuscar = new javax.swing.JButton();
        jPnlBotones = new javax.swing.JPanel();
        jBtnAgregar = new javax.swing.JButton();
        jBtnEdit = new javax.swing.JButton();
        jBtnDelete = new javax.swing.JButton();
        jTxtBuscar1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTblEstudiantes = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        comboBoxCursos = new javax.swing.JComboBox<>();
        jTxtAgregarEstudiante = new javax.swing.JTextField();
        jBtnAgregarEstudiante = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jBtnBuscar.setText("Buscar");
        jBtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBuscarActionPerformed(evt);
            }
        });

        jBtnAgregar.setText("Agregar");
        jBtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAgregarActionPerformed(evt);
            }
        });

        jBtnEdit.setText("Editar");
        jBtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditActionPerformed(evt);
            }
        });

        jBtnDelete.setText("Borrar");
        jBtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPnlBotonesLayout = new javax.swing.GroupLayout(jPnlBotones);
        jPnlBotones.setLayout(jPnlBotonesLayout);
        jPnlBotonesLayout.setHorizontalGroup(
            jPnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnlBotonesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jBtnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(61, 61, 61)
                .addComponent(jBtnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(251, 251, 251))
        );
        jPnlBotonesLayout.setVerticalGroup(
            jPnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnlBotonesLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );

        jTblEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTblEstudiantes);

        javax.swing.GroupLayout jPnl0Layout = new javax.swing.GroupLayout(jPnl0);
        jPnl0.setLayout(jPnl0Layout);
        jPnl0Layout.setHorizontalGroup(
            jPnl0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnl0Layout.createSequentialGroup()
                .addGroup(jPnl0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnl0Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jPnlBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPnl0Layout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addComponent(jBtnBuscar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPnl0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPnl0Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jTxtBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(369, Short.MAX_VALUE)))
            .addGroup(jPnl0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPnl0Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2)
                    .addContainerGap()))
        );
        jPnl0Layout.setVerticalGroup(
            jPnl0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnl0Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jBtnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 229, Short.MAX_VALUE)
                .addComponent(jPnlBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPnl0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPnl0Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jTxtBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(301, Short.MAX_VALUE)))
            .addGroup(jPnl0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPnl0Layout.createSequentialGroup()
                    .addGap(51, 51, 51)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(87, Short.MAX_VALUE)))
        );

        comboBoxCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCursosActionPerformed(evt);
            }
        });

        jTxtAgregarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtAgregarEstudianteActionPerformed(evt);
            }
        });

        jBtnAgregarEstudiante.setText("AgregarEstudiante");
        jBtnAgregarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAgregarEstudianteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboBoxCursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jTxtAgregarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jBtnAgregarEstudiante)
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxCursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtAgregarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnAgregarEstudiante))
                .addGap(0, 207, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPnl0, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPnl0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAgregarActionPerformed
        // TODO add your handling code here:
        EstudianteForm modal = new EstudianteForm("Agregar", null, this);
        modal.setVisible(true);
    }//GEN-LAST:event_jBtnAgregarActionPerformed

    private void jBtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDeleteActionPerformed
        // TODO add your handling code here:
        Estudiante current = this.getSelectedEstudiante();
        boolean result = false;
        try {
            String cedula = current.cedula;
            APIEstudiantes api = new APIEstudiantes("http://localhost/MVC/Controllers/APIRest.php?cedula=" + cedula);
            api.DELETE(); // ya no necesitas pasarle nada 
            ResponseEstudiante response = new ResponseEstudiante(api);
            result = response.parseSuccess();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result) {
            JOptionPane.showMessageDialog(null, "Eliminación Exitosa");
        } else {
            JOptionPane.showMessageDialog(null, "Eliminación Fallida");
        }
        this.acualizarTabla();
    }//GEN-LAST:event_jBtnDeleteActionPerformed

    private void jBtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditActionPerformed
        // TODO add your handling code here:
        Estudiante est = getSelectedEstudiante();
        EstudianteForm modal = new EstudianteForm("Editar", est, this);
        modal.setVisible(true);
    }//GEN-LAST:event_jBtnEditActionPerformed

    private void jBtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBuscarActionPerformed
        String cedula = this.jTxtBuscar1.getText().trim();
        if (cedula.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese una cédula");
            return;
        }

        try {
            APIEstudiantes api = new APIEstudiantes("http://localhost/MVC/Controllers/APIRest.php?cedula=" + cedula);
            api.GET(); // llamada GET con parámetro directo en la URL 
            ResponseEstudiante response = new ResponseEstudiante(api);
            ArrayList<Estudiante> encontrados = response.parseResponses();

            if (!encontrados.isEmpty()) {
                Estudiante encontrado = encontrados.get(0);
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("Cedula");
                model.addColumn("Nombre");
                model.addColumn("Apellido");
                model.addColumn("Direccion");
                model.addColumn("Telefono");
                model.addRow(new Object[]{
                    encontrado.cedula,
                    encontrado.nombre,
                    encontrado.apellido,
                    encontrado.direccion,
                    encontrado.telefono
                });
                this.jTblEstudiantes.setModel(model);
                this.estudiantes = new ArrayList<>();
                this.estudiantes.add(encontrado);
            } else {
                JOptionPane.showMessageDialog(this, "Estudiante no encontrado");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al buscar estudiante");
        }
    }//GEN-LAST:event_jBtnBuscarActionPerformed

    private void comboBoxCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCursosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxCursosActionPerformed

    private void jBtnAgregarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAgregarEstudianteActionPerformed

        String cedula = jTxtAgregarEstudiante.getText().trim(); // cédula del estudiante
        Curso cursoSeleccionado = (Curso) comboBoxCursos.getSelectedItem(); // curso del combo box

        if (cedula.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese una cédula");
            return;
        }

        if (cursoSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione un curso");
            return;
        }
        CursoEstudiante ce = new CursoEstudiante();
        ce.id_estudiante = cedula;
        ce.id_curso = cursoSeleccionado.codigo;

        try {
            APICursos apiCursos = new APICursos("http://localhost/MVC/Controllers/APIRestCurso.php");
            apiCursos.POST(ce);
        } catch (Exception e) {
            
        }

    }//GEN-LAST:event_jBtnAgregarEstudianteActionPerformed

    private void jTxtAgregarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtAgregarEstudianteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtAgregarEstudianteActionPerformed

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
            java.util.logging.Logger.getLogger(TablaEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TablaEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TablaEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TablaEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TablaEstudiantes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Curso> comboBoxCursos;
    private javax.swing.JButton jBtnAgregar;
    private javax.swing.JButton jBtnAgregarEstudiante;
    private javax.swing.JButton jBtnBuscar;
    private javax.swing.JButton jBtnDelete;
    private javax.swing.JButton jBtnEdit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPnl0;
    private javax.swing.JPanel jPnlBotones;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTblEstudiantes;
    private javax.swing.JTextField jTxtAgregarEstudiante;
    private javax.swing.JTextField jTxtBuscar1;
    // End of variables declaration//GEN-END:variables
}
