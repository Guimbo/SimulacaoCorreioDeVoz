package ui_views;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 *
 * @author Guilherme
 */
public class LoginForm extends JFrame {

    private ArrayList<BiConsumer<String, String>> triggerLoginCallbacks;
    private Consumer<String> triggerChangePass;

    /**
     * Creates new form TelaLogin
     */
    public LoginForm() {
        initComponents();
        this.triggerLoginCallbacks = new ArrayList<>();
    }

    public void onLogin(BiConsumer<String, String> predicate) {
        this.triggerLoginCallbacks.add(predicate);
    }

    private void makeLogin(String numberMailbox, String pass){
        this.triggerLoginCallbacks.forEach(c -> c.accept(numberMailbox, pass));
    }

    public void onChangePass(Consumer<String> predicate){
        this.triggerChangePass = predicate;
    }

    public void changePass() {
        btnSubmit.setText("Alterar");
        lblSenha.setText("Nova senha");
    }

    public void setLoginLabels() {
        btnSubmit.setText("Login");
        lblSenha.setText("Digite sua senha");
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtSenha = new JTextField();
        lblSenha = new JLabel();
        btnSubmit = new JButton();
        jLabel3 = new JLabel();
        txtNumero = new JTextField();
        jLabel1 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        txtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSenhaKeyTyped(evt);
            }
        });

        lblSenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSenha.setText("Digite sua senha");

        btnSubmit.setText("Login");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("LOGIN");

        txtNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Numero da caixa de email");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel1)
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(txtSenha, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGap(27, 27, 27)
                                                                        .addComponent(lblSenha))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGap(31, 31, 31)
                                                                        .addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(82, 82, 82)
                                                .addComponent(jLabel3)))
                                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addGap(13, 13, 13)
                                .addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblSenha)
                                .addGap(20, 20, 20)
                                .addComponent(txtSenha, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSenhaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isLetter(c) && !evt.isAltDown()){
            evt.consume();
        }
    }//GEN-LAST:event_jTextField2KeyTyped

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        switch (this.btnSubmit.getText()){
            case "Login":
                this.makeLogin(this.txtNumero.getText(), this.txtSenha.getText());
                break;
            case "Alterar":
                this.triggerChangePass.accept(this.txtSenha.getText());
                break;
            default:
        }

        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtNumeroKeyTyped(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isLetter(c) && !evt.isAltDown()){
            evt.consume();
        }
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnSubmit;
    private JLabel jLabel1;
    private JLabel lblSenha;
    private JLabel jLabel3;
    private JTextField txtSenha;
    private JTextField txtNumero;


    // End of variables declaration//GEN-END:variables
}
