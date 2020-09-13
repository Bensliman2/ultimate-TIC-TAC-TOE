/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.plaf.metal.MetalBorders;
import static tictactoe.TicTacFrame.Machin_playin;


public class TicTacButton extends JButton implements Serializable ,ActionListener, MouseListener{
    private TicTacFrame ticTacFrame;
    private TicTacPanel ticTacPanel;
    
    private int idButton ;
    private boolean actif;
    private Color defaultColor;
    private Color playerColor;
    
    
    public TicTacButton(TicTacPanel ticTacPanel,TicTacFrame ticTacFrame,int id) {
        this.ticTacPanel=ticTacPanel;
        this.ticTacFrame=ticTacFrame;
        this.idButton=id;
        
        this.setBorder(new MetalBorders.Flush3DBorder());
        
        this.defaultColor=this.getBackground();
        this.playerColor=this.getBackground();

        this.actif=true;
        this.idButton=id;

        this.addMouseListener(this);
        this.addActionListener(this);
    }
    
    public void RefreshButton(){
        this.actif=true;
        this.setEnabled(true);
        this.setBackground(defaultColor);
        this.playerColor=defaultColor;
    }
            
    public void reCreateButton(){
        if(this.isEnabled())
            this.setBackground(playerColor);        
    }
    
    public void setButton(boolean enabled,boolean actif,Color color){
        this.actif=actif;
        this.playerColor=color;
        if(actif)
            this.setEnabled(enabled);
        this.setBackground(playerColor);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        PlayMove();
    }
    
    public void PlayMove(){
        if(actif ){
           if(Users.User1.isPlay){
                this.setBackground(Users.User1.USER1_COLOR);
                this.playerColor=Users.User1.USER1_COLOR;
                Users.User1.isPlay=false;
                if(ticTacFrame.Machin_playin == false)
                    Users.User2.isPlay=true;
                else
                     Users.User2.isPlay=false;
                
                this.actif=false;
                this.setEnabled(false);
                
                if(TicTacFrame.Machin_playin){
                    ticTacFrame.tic2.setBoard_num(ticTacPanel.getIdPanel());
                    ticTacFrame.tic2.setCell_num(idButton);
                    ticTacFrame.tic2.userMove();
//                    ticTacFrame.tic2.saveboardbackup();
                }
                
                ticTacFrame.getPan().EnablePanel(idButton , ticTacPanel.getIdPanel());
            }else if(Users.User2.isPlay ){
                this.setBackground(Users.User2.USER2_COLOR);  
                this.playerColor=Users.User1.USER1_COLOR;
                Users.User1.isPlay=true;
                
                Users.User2.isPlay=false;
//                ticTacFrame.Machin_playin = false;
//                if(ticTacFrame.Machin_playin == false)
//                else
                
                this.actif=false;
                this.setEnabled(false);
                ticTacFrame.getPan().EnablePanel(idButton , 0);
            }
        }
    }
    
    public void PlayMachineMove(){
        this.setBackground(Users.User2.USER2_COLOR);  
        this.playerColor=Users.User2.USER2_COLOR;
        Users.User1.isPlay=true;
//        ticTacFrame.Machin_playin = false;
//                if(ticTacFrame.Machin_playin == false)
//                else

        this.actif=false;
        this.setEnabled(false);
        ticTacFrame.getPan().EnablePanel(idButton , ticTacPanel.getIdPanel());
    }
    
    public boolean isActif() {
        return actif;
    }
    
    public void setActif(boolean actif) {
        this.actif=actif;
        System.out.println("Actif : "+actif );
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(this.isEnabled())
            this.setBackground(playerColor);                
    }

    public void setTicTacFrame(TicTacFrame ticTacFrame) {
        this.ticTacFrame = ticTacFrame;
    }

    public void setTicTacPanel(TicTacPanel ticTacPanel) {
        this.ticTacPanel = ticTacPanel;
    }

    public int getIdButton() {
        return idButton;
    }

    public void setIdButton(int idButton) {
        this.idButton = idButton;
    }

    public Color getDefaultColor() {
        return defaultColor;
    }

    public void setDefaultColor(Color defaultColor) {
        this.defaultColor = defaultColor;
    }

    public Color getPlayerColor() {
        return playerColor;
    }

    public void setPlayerColor(Color playerColor) {
        this.playerColor = playerColor;
    }
    
    
    
    
}
