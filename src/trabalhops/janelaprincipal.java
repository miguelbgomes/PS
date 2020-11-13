/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhops;

import java.awt.Color;
import static java.awt.Color.red;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author cassi
 */
public class janelaprincipal extends javax.swing.JFrame {
    private Memoria memoria;
    private DefaultListModel<String> model;
    private final int PC,SP,ACC,OPM,IR,IM;
    private Registrador[] regs;
            

    /**
     * Creates new form janelaprincipal
     */
    public janelaprincipal(String nome) throws FileNotFoundException {
        initComponents();
        campo1.setOpaque(false);
        campo1.setBackground(new java.awt.Color(255, 255, 255, 0));
        jButton1.setOpaque(false);
        jButton1.setBackground(new java.awt.Color(255, 255, 255, 0));
        jList1.setOpaque(false);
        jList1.setCellRenderer(new TransparentListCellRenderer());
        jScrollPane3.setOpaque(false);
        jScrollPane3.getViewport().setOpaque(false);
        jButton2.setOpaque(false);
        jButton2.setBackground(new java.awt.Color(255, 255, 255, 0));
        jButton3.setOpaque(false);
        jButton3.setBackground(new java.awt.Color(255, 255, 255, 0));
        jTextArea1.setText("	Olá, "+nome+"! Bem vindo ao Venture! \n Escolha o seu modo de operação para começarmos...\n\n Step - Executa o programa passo a passo\n Run - Executa todo o programa\n Reset - Reset o programa");
        ManipulaArquivo arquivo;
        regs = new Registrador[6];//declaracao dos registradores que serao usados no programa. Nao tem diferenciacao sobre qual registrador eh qual.
        model = new DefaultListModel<String>();
        memoria = new Memoria(regs);
        //criado para referenciar os registradores no vetor regs 
        IM = 5; 
        IR = 4;  
        OPM = 3; 
        ACC = 2; 
        SP = 1; 
        PC = 0;  
        // ex: valorRegistradorAcc = regs[ACC].getRegistrador()
        
        arquivo = new ManipulaArquivo("src/inputs/arquivo.txt", memoria);//pacote com as possiveis entradas
        boolean continua; //variavel de continuidade de loops

        do {
            continua = arquivo.leitor();//faz a leitura do arquivo, guardando o valor de retorno da funçao. Quando for false (0), sai do loop
        } while (continua);
        //while(arquivo.leitor());//sintaxe alternativa

        //Imprime 
//        regs[3].setRegistrador("k");//teste para ver a alteraçao do registrador na memoria
        //memoria.imprimeMemoriaParcial(500, 512);//imprime apenas posicoes selecionadas da memoria(final da memoria para ver os registradores)
        memoria.imprimeMemoria();
        for (int i = 0; i<memoria.getMemoria().size();i++){
            model.addElement(memoria.getMemoria().get(i));
        }
        
        //Seta o vetor memória da interface 
        jList1.setModel(model);
        
        //seta os valores dos registradores da interface
        acc.setText(regs[ACC].getRegistrador());
        im.setText(regs[IM].getRegistrador());
        ir.setText(regs[IR].getRegistrador());
        opm.setText(regs[OPM].getRegistrador());
        sp.setText(regs[SP].getRegistrador());
        pc.setText(regs[PC].getRegistrador());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pc = new javax.swing.JLabel();
        sp = new javax.swing.JLabel();
        acc = new javax.swing.JLabel();
        campo1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        opm = new javax.swing.JLabel();
        ir = new javax.swing.JLabel();
        im = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pc.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        pc.setText("0");
        jPanel1.add(pc, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, -1, -1));

        sp.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        sp.setText("0");
        jPanel1.add(sp, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, -1, -1));

        acc.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        acc.setText("ADD");
        jPanel1.add(acc, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, -1, -1));

        campo1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        campo1.setBorder(null);
        campo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo1ActionPerformed(evt);
            }
        });
        jPanel1.add(campo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 560, 220, 30));

        jButton1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Step");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 400, 90, 30));

        jButton2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Reset");
        jButton2.setToolTipText("");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 400, 90, 30));

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("0");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(832, 464, 288, 112));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("\t      Olá! Bem vindo ao Venture! \nEscolha o seu modo de operação para começarmos...\n\nStep - Executa o programa passo a passo\nRun - Executa todo o programa\nReset - Reset o programa");
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 520, 330, 110));

        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jList1.setForeground(new java.awt.Color(255, 255, 255));
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.setToolTipText("");
        jScrollPane3.setViewportView(jList1);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 48, 150, 600));

        opm.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        opm.setText("0");
        jPanel1.add(opm, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, -1, -1));

        ir.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        ir.setText("0");
        jPanel1.add(ir, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 240, -1, -1));

        im.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        im.setText("0");
        jPanel1.add(im, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 300, -1, -1));

        jButton3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Run");
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 400, 80, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalhops/background ps.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1152, -1));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1152, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo1ActionPerformed
        // TODO add your handling code here:
        jLabel5.setText(campo1.getText());
    }//GEN-LAST:event_campo1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        pc.setText("Olá mundo");
        short teste = Short.parseShort(campo1.getText());
        System.out.println(teste);
        //jLabel5.setText();
       //jList1.set
        DefaultListModel<String> model = new DefaultListModel<String>();
        for (int i = 0; i<memoria.getMemoria().size();i++){
            model.addElement(memoria.getMemoria().get(i));
        }
        jList1.setModel(model);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Fechando jf = new Fechando();
        jf.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    public JList<String> getLista() {
        return jList1;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {
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
            java.util.logging.Logger.getLogger(janelaprincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(janelaprincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(janelaprincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(janelaprincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */

        
        
  

  
       
        

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel acc;
    private javax.swing.JTextField campo1;
    private javax.swing.JLabel im;
    private javax.swing.JLabel ir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel opm;
    private javax.swing.JLabel pc;
    private javax.swing.JLabel sp;
    // End of variables declaration//GEN-END:variables

    public void executarOperacao() {
        int posicao, operacao, aux; // aux = valor auxiliar para operações aritméticas
        String opcode, operando1, operando2;
        
        posicao = regs[PC].getRegistradorInt(); // pega a posição da instrução de PC
        opcode = memoria.getMemoriaPosicao(posicao);        // pega a instrução da memória
        regs[IR].setRegistrador(opcode);                    // guarda no registrador de instrução
        operacao = FuncoesUteis.binaryStringToInt(opcode);  // converte para int para ficar fácil de operar
        
        // realiza a operação
        switch (operacao) {
            // ADD
            case 2:   // add direto
            case 34:  // add indireto
            case 130: // add imediato
                // pega operando
                if (opcode.charAt(10) == '1') { // operando indireto
                    operando1 = memoria.getMemoriaPosicao(
                                memoria.getMemoriaPosicaoInt(
                                memoria.getMemoriaPosicaoInt(posicao+1)
                                )
                                ); 
                } else if (opcode.charAt(8) == '1') { // operando imediato
                    operando1 = memoria.getMemoriaPosicao(posicao+1);
                } else { // operando direto
                    operando1 = memoria.getMemoriaPosicao(
                                memoria.getMemoriaPosicaoInt(posicao+1)
                                );
                }
                
                // executa operação
                regs[ACC].add(operando1);
                regs[PC].add(2);
                break;
                
            // BR
            case 0:  // br direto
            case 32: // br indireto
                // pega operando
                if (opcode.charAt(10) == '1') { // operando indireto
                    operando1 = memoria.getMemoriaPosicao(
                                memoria.getMemoriaPosicaoInt(posicao+1)
                                );
                } else { // operando direto
                    operando1 = memoria.getMemoriaPosicao(posicao+1);
                }
                
                // executa operação
                regs[PC].setRegistrador(operando1);
                break;
                
            // BRNEG
            case 5:  // brneg direto
            case 37: // brneg indireto
                // pega operando
                if (opcode.charAt(10) == '1') { // operando indireto
                    operando1 = memoria.getMemoriaPosicao(
                                memoria.getMemoriaPosicaoInt(posicao+1)
                                );
                } else { // operando direto
                    operando1 = memoria.getMemoriaPosicao(posicao+1);
                }
                
                // executa operação
                if (regs[ACC].getRegistradorInt() < 0)
                    regs[PC].setRegistrador(operando1);
                else
                    regs[PC].add(2);
                break;
            
            // BRPOS
            case 1:  // brpos direto
            case 33: // brpos indireto
                // pega operando
                if (opcode.charAt(10) == '1') { // operando indireto
                    operando1 = memoria.getMemoriaPosicao(
                                memoria.getMemoriaPosicaoInt(posicao+1)
                                );
                } else { // operando direto
                    operando1 = memoria.getMemoriaPosicao(posicao+1);
                }
                
                // executa operação
                if (regs[ACC].getRegistradorInt() > 0)
                    regs[PC].setRegistrador(operando1);
                else
                    regs[PC].add(2);
                break;
                
            // BRZERO
            case 4:  // brzero direto
            case 36: // brzero indireto
                // pega operando
                if (opcode.charAt(10) == '1') { // operando indireto
                    operando1 = memoria.getMemoriaPosicao(
                                memoria.getMemoriaPosicaoInt(posicao+1)
                                );
                } else { // operando direto
                    operando1 = memoria.getMemoriaPosicao(posicao+1);
                }
                
                // executa operação
                if (regs[ACC].getRegistradorInt() == 0)
                    regs[PC].setRegistrador(operando1);
                else
                    regs[PC].add(2);
                break;
            
            // CALL
            case 15: // call direto
            case 47: // call indireto
                // pega operando
                if (opcode.charAt(10) == '1') { // operando indireto
                    operando1 = memoria.getMemoriaPosicao(
                                memoria.getMemoriaPosicaoInt(posicao+1)
                                );
                } else { // operando direto
                    operando1 = memoria.getMemoriaPosicao(posicao+1);
                }
                
                // executa operação
                if (regs[SP].getRegistradorInt() + 1 < memoria.getINICIO_INS_DADOS()) { // verifica se está dentro dos limites da pilha
                    regs[SP].add(1);
                    memoria.setMemoriaPosicao(regs[SP].getRegistradorInt(), regs[PC].getRegistrador());
                    regs[PC].setRegistrador(operando1);
                } else {
                    // stack overflow
                }
                break;
                
            // COPY
            case 13:  // copy direto-direto
            case 45:  // copy indireto-direto
            case 77:  // copy direto-indireto
            case 109: // copy indireto-indireto
            case 141: // copy direto-imediato
            case 173: // copy indireto-imediato
                // pega operandos
                if (opcode.charAt(10) == '1') { // operando 1 indireto
                    operando1 = memoria.getMemoriaPosicao(
                                memoria.getMemoriaPosicaoInt(posicao+1)
                                );
                } else { // operando 1 direto
                    operando1 = memoria.getMemoriaPosicao(posicao+1);
                }
                if (opcode.charAt(9) == '1') { // operando 2 indireto
                    operando2 = memoria.getMemoriaPosicao(
                                memoria.getMemoriaPosicaoInt(
                                memoria.getMemoriaPosicaoInt(posicao+2)
                                )
                                ); 
                } else if (opcode.charAt(8) == '1') { // operando 2 imediato
                    operando2 = memoria.getMemoriaPosicao(posicao+2);
                } else { // operando 2 direto
                    operando2 = memoria.getMemoriaPosicao(
                                memoria.getMemoriaPosicaoInt(posicao+2)
                                );
                }
                
                // executa operação
                memoria.setMemoriaPosicao(FuncoesUteis.binaryStringToInt(operando1), operando2);
                regs[PC].add(3);
                break;
                
            // DIVIDE
            case 10:  // divide direto
            case 42:  // divide indireto
            case 138: // divide imediato
                // pega operando
                if (opcode.charAt(10) == '1') { // operando indireto
                    operando1 = memoria.getMemoriaPosicao(
                                memoria.getMemoriaPosicaoInt(
                                memoria.getMemoriaPosicaoInt(posicao+1)
                                )
                                ); 
                } else if (opcode.charAt(8) == '1') { // operando imediato
                    operando1 = memoria.getMemoriaPosicao(posicao+1);
                } else { // operando direto
                    operando1 = memoria.getMemoriaPosicao(
                                memoria.getMemoriaPosicaoInt(posicao+1)
                                );
                }
                
                // executa operação
                aux = FuncoesUteis.binaryStringToInt(operando1);
                if (aux != 0) // não pode fazer divisão por 0
                    regs[ACC].setRegistrador(FuncoesUteis.intToBinaryString((int)regs[ACC].getRegistradorInt() / aux, 16));
                // else erro divisão por 0?
                regs[PC].add(2);
                break;
                
            // LOAD
            case 3:   // load direto
            case 35:  // load indireto
            case 131: // load imediato
                // pega operando
                if (opcode.charAt(10) == '1') { // operando indireto
                    operando1 = memoria.getMemoriaPosicao(
                                memoria.getMemoriaPosicaoInt(
                                memoria.getMemoriaPosicaoInt(posicao+1)
                                )
                                ); 
                } else if (opcode.charAt(8) == '1') { // operando imediato
                    operando1 = memoria.getMemoriaPosicao(posicao+1);
                } else { // operando direto
                    operando1 = memoria.getMemoriaPosicao(
                                memoria.getMemoriaPosicaoInt(posicao+1)
                                );
                }
                
                // executa operação
                regs[ACC].setRegistrador(operando1);
                regs[PC].add(2);
                break;
                
            // MULT
            case 14:  // mult direto
            case 46:  // mult indireto
            case 142: // mult imediato
                // pega operando
                if (opcode.charAt(10) == '1') { // operando indireto
                    operando1 = memoria.getMemoriaPosicao(
                                memoria.getMemoriaPosicaoInt(
                                memoria.getMemoriaPosicaoInt(posicao+1)
                                )
                                ); 
                } else if (opcode.charAt(8) == '1') { // operando imediato
                    operando1 = memoria.getMemoriaPosicao(posicao+1);
                } else { // operando direto
                    operando1 = memoria.getMemoriaPosicao(
                                memoria.getMemoriaPosicaoInt(posicao+1)
                                );
                }
                
                // executa operação
                aux = FuncoesUteis.binaryStringToInt(operando1);
                regs[ACC].setRegistrador(FuncoesUteis.intToBinaryString(regs[ACC].getRegistradorInt() * aux, 16));
                regs[PC].add(2);
                break;
                
            // READ (TODO)
            case 12: // read direto
            case 44: // read indireto
                // pega operando
                if (opcode.charAt(10) == '1') { // operando indireto
                    operando1 = memoria.getMemoriaPosicao(
                                memoria.getMemoriaPosicaoInt(posicao+1)
                                );
                } else { // operando direto
                    operando1 = memoria.getMemoriaPosicao(posicao+1);
                }
                
                // executa operação
                // !<código de leitura aqui>!
                // memoria.setMemoriaPosicao(FuncoesUteis.binaryStringToInt(operando1), !<DADO LIDO>!);
                regs[PC].add(2);
                break;
                
            // RET
            case 9: // ret
                if (regs[SP].getRegistradorInt() >= 2) { // verifica se está dentro dos limites da pilha
                    regs[PC].setRegistrador(memoria.getMemoriaPosicao(regs[SP].getRegistradorInt()));
                    regs[SP].add(-1);
                } else {
                    // stack underflow
                }
                break;
                
            // STOP (TODO)
            case 11: // stop
                // fimExecucao();
                break;
                
            // STORE
            case 7:  // store direto
            case 39: // store indireto
                // pega operando
                if (opcode.charAt(10) == '1') { // operando indireto
                    operando1 = memoria.getMemoriaPosicao(
                                memoria.getMemoriaPosicaoInt(posicao+1)
                                );
                } else { // operando direto
                    operando1 = memoria.getMemoriaPosicao(posicao+1);
                }
                
                // executa operação
                memoria.setMemoriaPosicao(FuncoesUteis.binaryStringToInt(operando1), regs[ACC].getRegistrador());
                regs[PC].add(2);
                break;
                
            // SUB
            case 6:   // sub direto
            case 38:  // sub indireto
            case 134: // sub imediato
                // pega operando
                if (opcode.charAt(10) == '1') { // operando indireto
                    operando1 = memoria.getMemoriaPosicao(
                                memoria.getMemoriaPosicaoInt(
                                memoria.getMemoriaPosicaoInt(posicao+1)
                                )
                                ); 
                } else if (opcode.charAt(8) == '1') { // operando imediato
                    operando1 = memoria.getMemoriaPosicao(posicao+1);
                } else { // operando direto
                    operando1 = memoria.getMemoriaPosicao(
                                memoria.getMemoriaPosicaoInt(posicao+1)
                                );
                }
                
                // executa operação
                aux = FuncoesUteis.binaryStringToInt(operando1);
                regs[ACC].add(-aux);
                regs[PC].add(2);
                break;
                
            // WRITE
            case 8:   // write direto
            case 40:  // write indireto
            case 136: // write imediato
                // pega operando
                if (opcode.charAt(10) == '1') { // operando indireto
                    operando1 = memoria.getMemoriaPosicao(
                                memoria.getMemoriaPosicaoInt(
                                memoria.getMemoriaPosicaoInt(posicao+1)
                                )
                                ); 
                } else if (opcode.charAt(8) == '1') { // operando imediato
                    operando1 = memoria.getMemoriaPosicao(posicao+1);
                } else { // operando direto
                    operando1 = memoria.getMemoriaPosicao(
                                memoria.getMemoriaPosicaoInt(posicao+1)
                                );
                }
                
                // executa operação
                // !<código de escrita aqui>!
                // tela <- operando1
                regs[PC].add(2);
                break;
            
            default: // operação inválida
                break;
        }
        /*
        switch (opcao){
	case “00000000 00001100”: // read direto
		PC +=2;
		memoria[memoria[PC-1]] = getInput;
		break;
	case “00000000 00101100”: // read indireto
		PC +=2;
		memoria[memoria[memoria[PC-1]]] = getInput;
		break;
	case “00000000 00001000”: // write direto
                PC += 2;
		outPut = memoria[memoria[PC-1]];
		break;
	case “00000000 00101000”: // write indireto
		PC += 2;
		setOutput = memoria[memoria[memoria[PC-1]]];
		break;
	case “00000000 10001000”: // write imediato
		PC += 2;
		outPut = memoria[PC-1];
		break
        }
        */
    }
}
