/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.GridLayout;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JOptionPane;


public class TicTacPanel extends javax.swing.JPanel implements Serializable{

    public HashMap<Integer,TicTacButton> buttons=new HashMap<>();
    private TicTacFrame ticTacFrame;
    private boolean isAvailable;
    private int Winner;
    private int idPanel;

    /**
     * Creates new form TicTacPanel
     */
    public TicTacPanel(TicTacFrame ticTacFrame, int idPanel) {
        initComponents();
        this.idPanel=idPanel;
        this.Winner=0;
        this.isAvailable=true;
        
        this.ticTacFrame=ticTacFrame;
        
        this.setLayout(new GridLayout(3, 3));
        for (int i = 1; i <= 9; i++) {
            TicTacButton button=new TicTacButton(this,ticTacFrame,i);
            this.buttons.put(i, button);
            this.add(button);
        }
    }
    
    public void setAvailability(){
        boolean available=false;
        for (int i = 1; i < 10; i++) {
            if(buttons.get(i).isActif()){
                available=true;
                break;
            }
        }
        this.isAvailable=available;
    }
    
    public boolean isSameColor(int i,int j){
        return buttons.get(i).getBackground() == buttons.get(j).getBackground() && buttons.get(i).getBackground() == Users.User1.USER1_COLOR
            || buttons.get(i).getBackground() == buttons.get(j).getBackground() && buttons.get(i).getBackground() == Users.User2.USER2_COLOR;
    }
    
    public void setWinner(int i){
        if(isAvailable){
            DesactifButtons();
            DisableButtons();
            this.isAvailable=false;
            ticTacFrame.getPan().DesableAllPanels();
            ticTacFrame.getPan().DesactifAllPanels();            if(buttons.get(i).getBackground()==Users.User1.USER1_COLOR){
                Winner=1;
                JOptionPane.showMessageDialog(ticTacFrame, "Player 1 has won !!", "Winner", JOptionPane.INFORMATION_MESSAGE);
            }else{
                Winner=2;
                JOptionPane.showMessageDialog(ticTacFrame, "Player 2 has won !!", "Winner", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    public void checkWinner(){
        for (int i = 1; i < 10; i++) {
            if(i==1){
                if( isSameColor(1,2) && isSameColor(1,3) ){
                    setWinner(1);
                }else if( isSameColor(1,4) && isSameColor(1,7) ){
                    setWinner(1);
                }else if( isSameColor(1,5) && isSameColor(1,9) ){
                    setWinner(1);
                }
            }else if(i==2){
                if( isSameColor(2,5) && isSameColor(2,8) ){
                    setWinner(2);
                }
            }else if(i==3){
                if( isSameColor(3,5) && isSameColor(3,7) ){
                    setWinner(3);
                }
            }else if(i==4){
                if( isSameColor(4,5) && isSameColor(4,6) ){
                    setWinner(4);
                }
            }else if(i==9){
                if( isSameColor(9,3) && isSameColor(9,6) ){
                    setWinner(9);
                }else if( isSameColor(9,7) && isSameColor(9,8) ){
                    setWinner(9);
                }
            }
        }
        if(Winner!=0){
            System.out.println("Winner id :"+Winner+" in Panel : "+idPanel);
        }
    }
    
    public void DisableButton(int idButton){
        this.buttons.get(idButton).setEnabled(false);
    }
    public void EnableButton(int idButton){
        this.buttons.get(idButton).setEnabled(true);
    }
    
    public void DesactifButtons(){
        for (int i = 1; i < 10; i++) {
            this.buttons.get(i).setActif(false);
        }
    }
    
    public void DisableButtons(){
        for (int i = 1; i < 10; i++) {
            this.buttons.get(i).setEnabled(false);
        }
    }
    public void EnableButtons(){
        checkWinner();
        for (int i = 1; i < 10; i++) {
            if(getButton(i).isActif())
                this.buttons.get(i).setEnabled(true);
        }
    }
    
    public void RefreshButtons(){
        this.Winner=0;
        this.isAvailable=true;
        for (int i = 1; i < 10; i++) {
            this.buttons.get(i).RefreshButton();
        }
    }
    
     
    public void reCreatePanel(){
        setAvailability();
//        if(isAvailable)
//            EnableButtons();
//        for (int i = 1; i < 10; i++) {
//            buttons.get(i).reCreateButton();
//        }
    }
    public void setPanel(){
    }
    
    //-------------------------Getters And Setters-------------------------
    public TicTacButton getButton(int numButton){
        return buttons.get(numButton);
    }
    
    public HashMap<Integer, TicTacButton> getButtons() {
        return buttons;
    }

    public void setButtons(HashMap<Integer, TicTacButton> buttons) {
        this.buttons = buttons;
    }

    public boolean isAvailable() {
        checkWinner();
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    
    public int getWinner() {
        return Winner;
    }

    public void setWinnerValue(int isWinner) {
        this.Winner = isWinner;
    }

    public int getIdPanel() {
        return idPanel;
    }

    public void setIdPanel(int idPanel) {
        this.idPanel = idPanel;
    }
    
    public void setTicTacFrame(TicTacFrame ticTacFrame) {
        this.ticTacFrame = ticTacFrame;
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    
    public TicTacButton getButtonAt(int i){
        return buttons.get(i);
    }
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
