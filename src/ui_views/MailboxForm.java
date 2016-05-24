package ui_views;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import jdk.nashorn.internal.codegen.CompilerConstants;

import javax.swing.*;
import java.awt.event.*;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

/**
 *
 * @author Guilherme
 */
public class MailboxForm extends JFrame {

    private Callable<String> getCurrentMessage;
    private Runnable triggerArchiveCurrentMessage;
    private Runnable triggerDeleteCurrentMessage;
    private Runnable triggerLogout;
    private Runnable triggerOpenChangePass;
    private Runnable triggerOpenChangeGreeting;
    private Callable<String> getCurrentGreeting;

    public MailboxForm() {
        initComponents();
    }

    public void onRequestCurrentMessage(Callable<String> predicate){
        getCurrentMessage = predicate;
    }

    public void onArchiveMessage(Runnable predicate){
        this.triggerArchiveCurrentMessage = predicate;
    }

    public void onDeleteMessage(Runnable predicate){
        this.triggerDeleteCurrentMessage = predicate;
    }

    public void onLogout(Runnable predicate){
        this.triggerLogout = predicate;
    }

    public void onOpenChangePass(Runnable predicate) {
        this.triggerOpenChangePass = predicate;
    }

    public void onOpenChangeGreeting(Runnable predicate){
        this.triggerOpenChangeGreeting = predicate;
    }

    public void onRequestCurrentGreeting(Callable<String> predicate){
        this.getCurrentGreeting = predicate;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSaudacao = new JLabel();
        lblMensagem = new JLabel();
        btnArquivar = new JButton();
        btnDeletar = new JButton();
        btnMudaSenha = new JButton();
        btnMudaSaudacao = new JButton();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        btnLogout = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lblSaudacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSaudacao.setForeground(new java.awt.Color(0, 0, 204));
        lblSaudacao.setText("BEM-VINDO A SUA CAIXA DE MENSAGENS");

        lblMensagem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblMensagem.setToolTipText("");
        lblMensagem.setVerticalAlignment(SwingConstants.TOP);

        btnArquivar.setText("Arquivar");
        btnArquivar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnArquivarActionPerformed(evt);
            }
        });

        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        btnMudaSenha.setText("Mudar senha");
        btnMudaSenha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnMudaSenhaActionPerformed(evt);
            }
        });

        btnMudaSaudacao.setText("Mudar Saudação");
        btnMudaSaudacao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnMudaSaudacaoActionPerformed(evt);
            }
        });

        jLabel2.setText(" Opções de mensagens");

        jLabel3.setText("Opções de usuário");

        btnLogout.setBackground(new java.awt.Color(255, 0, 0));
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(lblMensagem, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(30, 30, 30)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(btnDeletar, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(btnArquivar, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jLabel2))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(btnMudaSenha, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnMudaSaudacao)
                                                                .addGap(16, 16, 16)
                                                                .addComponent(btnLogout))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(99, 99, 99)
                                                                .addComponent(jLabel3))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addComponent(lblSaudacao)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblSaudacao)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(lblMensagem, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel2)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(btnArquivar)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(29, 29, 29)
                                                                .addComponent(btnDeletar)))))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnLogout)
                                        .addComponent(btnMudaSaudacao)
                                        .addComponent(btnMudaSenha))
                                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void showMessages(){
        try {
            String message = this.getCurrentMessage.call();
            lblMensagem.setText(message);
            String greeting = this.getCurrentGreeting.call();
            lblSaudacao.setText(greeting);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void btnArquivarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnArquivarActionPerformed
        this.triggerArchiveCurrentMessage.run();
        this.showMessages();
    }//GEN-LAST:event_btnArquivarActionPerformed

    private void btnDeletarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        this.triggerDeleteCurrentMessage.run();
        this.showMessages();
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnMudaSenhaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnMudaSenhaActionPerformed
        this.triggerOpenChangePass.run();
    }

    private void btnMudaSaudacaoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnMudaSaudacaoActionPerformed
        this.triggerOpenChangeGreeting.run();
    }

    private void btnLogoutActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        this.triggerLogout.run();
        this.setVisible(false);
    }//GEN-LAST:event_btnLogoutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnArquivar;
    private JButton btnDeletar;
    private JButton btnLogout;
    private JButton btnMudaSaudacao;
    private JButton btnMudaSenha;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel lblMensagem;
    private JLabel lblSaudacao;


    // End of variables declaration//GEN-END:variables
}
