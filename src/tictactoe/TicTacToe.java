/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;


public class TicTacToe {
        
    public TicTacToe(){
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TicTacFrame main=new TicTacFrame();
        main.setDefaultCloseOperation(main.EXIT_ON_CLOSE);
       // main.getContentPane().add(emptyLabel, BorderLayout.CENTER);
         main.pack();
        main.setVisible(true);
        
    }
    
}
