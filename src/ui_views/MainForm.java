package ui_views;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;

/**
 *
 * @author Guilherme
 */
public class MainForm extends JFrame {

    private final LoginForm login;
    private final SenderForm sender;
    private final MailboxForm mailbox;
    private final ChangeGreetingDialog changeGreetingDialog;

    public MainForm() {
        this.login = new LoginForm();
        this.sender = new SenderForm();
        this.mailbox = new MailboxForm();
        this.changeGreetingDialog = new ChangeGreetingDialog();

        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAdmin = new JButton();
        btnEnvio = new JButton();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        btnAdmin.setText("Administrador");
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });

        btnEnvio.setText("Enviar Mensagem");
        btnEnvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnvioActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Correio de Voz");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Escolha uma opção");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(68, 68, 68)
                                                .addComponent(jLabel1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(100, 100, 100)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnAdmin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnEnvio, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel1)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel2)
                                .addGap(26, 26, 26)
                                .addComponent(btnAdmin, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEnvio, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
        this.login.setLoginLabels();
        this.login.setVisible(true);
    }//GEN-LAST:event_btnAdminActionPerformed

    private void btnEnvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnvioActionPerformed
        this.sender.setVisible(true);
    }//GEN-LAST:event_btnEnvioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnAdmin;
    private JButton btnEnvio;
    private JLabel jLabel1;
    private JLabel jLabel2;

    public LoginForm getLoginForm() {
        return this.login;
    }

    public SenderForm getSenderForm() {
        return this.sender;
    }

    public MailboxForm getManagerMessages() { return this.mailbox; }

    public ChangeGreetingDialog getChangeGreetingDialog() { return changeGreetingDialog; }
    // End of variables declaration//GEN-END:variables
}
