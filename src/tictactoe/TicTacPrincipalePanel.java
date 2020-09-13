/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import Algorithm.Tic2;
import java.awt.Color;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Random;
import java.util.Vector;


public class TicTacPrincipalePanel extends javax.swing.JPanel implements Serializable{
    
    private TicTacFrame ticTacFrame;
    private HashMap<Integer,TicTacPanel> grids=new HashMap<>();
     
    private boolean actif;
    private int winnerValue;
    
    private Color defaultColor;
    
    /**
     * Creates new form PrincipalePanel
     */
    public TicTacPrincipalePanel(TicTacFrame ticTacFrame,int width,int height) {
        initComponents();
        this.actif=true;
        this.ticTacFrame=ticTacFrame;
        
        this.defaultColor=ticTacFrame.getPanel().getBackground();
        
        this.setBounds(3,3,width, height);
        initPanel();
    }
    
    public void initPanel(){
        for (int i = 0; i <= 9; i++) {
            grids.put(i, new TicTacPanel(ticTacFrame,i));
            grids.get(i).setBounds(3,2,this.getWidth()/4+18,this.getHeight()/4+12);
        }
        AddPanels(grids);
        setPanelsBackground();
    }
    
    public void AddPanels(HashMap<Integer,TicTacPanel> gridsMap){
        this.jPanel1.add(gridsMap.get(1));
        this.jPanel2.add(gridsMap.get(2));
        this.jPanel3.add(gridsMap.get(3));
        this.jPanel4.add(gridsMap.get(4));
        this.jPanel5.add(gridsMap.get(5));
        this.jPanel6.add(gridsMap.get(6));
        this.jPanel7.add(gridsMap.get(7));
        this.jPanel8.add(gridsMap.get(8));
        this.jPanel9.add(gridsMap.get(9));
    }
    public void RemovePanels(){
//        this.jPanel1.remove(grids.get(1));
//        this.jPanel2.remove(grids.get(2));
//        this.jPanel3.remove(grids.get(3));
//        this.jPanel4.remove(grids.get(4));
//        this.jPanel5.remove(grids.get(5));
//        this.jPanel6.remove(grids.get(6));
//        this.jPanel7.remove(grids.get(7));
//        this.jPanel8.remove(grids.get(8));
//        this.jPanel9.remove(grids.get(9));
        this.jPanel1.removeAll();
        this.jPanel2.removeAll();
        this.jPanel3.removeAll();
        this.jPanel4.removeAll();
        this.jPanel5.removeAll();
        this.jPanel6.removeAll();
        this.jPanel7.removeAll();
        this.jPanel8.removeAll();
        this.jPanel9.removeAll();
    }
    public void setPanelsBackground(){
        ticTacFrame.getPanel().setBackground(this.defaultColor);
        this.jPanel1.setBackground(this.getBackground());
        this.jPanel2.setBackground(this.getBackground());
        this.jPanel3.setBackground(this.getBackground());
        this.jPanel4.setBackground(this.getBackground());
        this.jPanel5.setBackground(this.getBackground());
        this.jPanel6.setBackground(this.getBackground());
        this.jPanel7.setBackground(this.getBackground());
        this.jPanel8.setBackground(this.getBackground());
        this.jPanel9.setBackground(this.getBackground());

    }
    
    public void setGridsAvailability(){
        for (int i = 1; i < 10; i++) {
            ((TicTacPanel) this.grids.get(i)).setAvailability();
        }
    }
  
    
         
    public void EnablePanel(int numPanel, int idPanel){
        setGridsAvailability();
        EnableAllPanels();
//        grids.get(numPanel).checkWinner();
        if(((TicTacPanel)this.grids.get(numPanel)).isAvailable()){
            if(numPanel>=1 && numPanel<=9){ 
                for (int i = 0; i < 10; i++) {
                    if(numPanel != i)
                        ((TicTacPanel) this.grids.get(i)).DisableButtons();
                }
            }
        }
        
        System.out.println("Hheer");
        
        if(TicTacFrame.Machin_playin == true && Users.User1.isPlay == false){
            ticTacFrame.tic2.computerMove();
//            while(true){
//                int k = new Random().nextInt(10);
//                if(k == 0) k++;
//                if(((TicTacPanel) this.grids.get(numPanel)).buttons.get(Tic2.idButt+1).isActif() == true){
                    ((TicTacPanel) this.grids.get(Tic2.idPan+1)).buttons.get(Tic2.idButt+1).PlayMachineMove();
                    ((TicTacPanel) this.grids.get(Tic2.idPan+1)).checkWinner();
//                    System.out.println("Hheer");
//                    break;
//                }
//            }
        }
        
//        this.validate();
    }
    
    public void EnableAllPanels(){
        for (int i = 1; i < 10; i++) {
            ((TicTacPanel) this.grids.get(i)).EnableButtons();                        
        }
    }
    
    public void DesableAllPanels(){
        for (int i = 1; i < 10; i++) {
            ((TicTacPanel) this.grids.get(i)).DisableButtons();                        
        }
    }
    
    public void RefreshAllPanels(){
        setPanelsBackground();
        for (int i = 1; i < 10; i++) {
            ((TicTacPanel) this.grids.get(i)).RefreshButtons();                        
        }
    }
    
    public void DesactifAllPanels(){
        for (int i = 1; i < 10; i++) {
            ( (TicTacPanel )this.grids.get(i)).DesactifButtons();
        }
    }
    
//    public void getPreviousGame(Vector<Vector> gameUndoVector,User1 user1, User2 user2, JTable jTablle_historique){
//        int size=gameUndoVector.size();
//        Vector tmp=new Vector();
//        if(size>1){
//            tmp=gameUndoVector.get(size-2);
//            this.RemovePanels();
//            this.AddPanels((HashMap<Integer,TicTacPanel>) tmp.get(0));
//            user1=(User1) tmp.get(1);
//            user2=(User2) tmp.get(2);
////            this.jTablle_historique.removeRowSelectionInterval(0, 2);
//            jTablle_historique.clearSelection();
//            jTablle_historique.setModel((TableModel) tmp.get(3));
////            this.jTabbedPane1.setMo
//            this.repaint();
//            gameUndoVector.removeElementAt(size-1);
//            System.out.println("Entered");
//        }
//    }    
    
    public void reCreateAllPanels(){
        for (int i = 1; i < 10; i++) {
            grids.get(i).reCreatePanel();
        }
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
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(102, 102, 102));

        jPanel1.setForeground(new java.awt.Color(153, 204, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(153, 255, 255));
        jPanel4.setForeground(new java.awt.Color(153, 204, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(153, 255, 255));
        jPanel7.setForeground(new java.awt.Color(153, 204, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 152, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(153, 255, 255));
        jPanel8.setForeground(new java.awt.Color(153, 204, 255));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(153, 255, 255));
        jPanel5.setForeground(new java.awt.Color(153, 204, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 152, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );

        jPanel2.setForeground(new java.awt.Color(153, 204, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );

        jPanel3.setForeground(new java.awt.Color(153, 204, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 153, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(153, 255, 255));
        jPanel6.setForeground(new java.awt.Color(153, 204, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );

        jPanel9.setBackground(new java.awt.Color(153, 255, 255));
        jPanel9.setForeground(new java.awt.Color(153, 204, 255));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(15, 15, 15)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(15, 15, 15)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(15, 15, 15)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(15, 15, 15)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(15, 15, 15)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(15, 15, 15)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables
    
    
    public HashMap getGrids() {
        return this.grids; //To change body of generated methods, choose Tools | Templates.
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public Color getDefaultColor() {
        return defaultColor;
    }

    public void setDefaultColor(Color defaultColor) {
        this.defaultColor = defaultColor;
    }
    
    
    public TicTacPanel getPanelAt(int i){
        return grids.get(i);
    }

    public int getWinnerValue() {
        return winnerValue;
    }

    public void setWinnerValue(int winnerValue) {
        this.winnerValue = winnerValue;
    }
    
    
}
