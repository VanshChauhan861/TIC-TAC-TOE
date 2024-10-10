package TICTACTOE;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
class TICTACTOE implements ActionListener {
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;

    TICTACTOE(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Color(25, 25 ,25));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("Calibri",Font.BOLD,60)); // type of font, (name,style,size)
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("TIC - TAC - TOE GAME !!!"); // text to showup
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100); // x,y,height,width

        button_panel.setLayout(new GridLayout(3,3)); // makes the grid for the tic tac toe gameh
        button_panel.setBackground(new Color(150,150,150));

        for(int i = 0;i<9;i++) {
            buttons[i] = new JButton(); // creates buttons
            button_panel.add(buttons[i]); // adds the buttons to the grid
            buttons[i].setFont(new Font("Bookman Old Style",Font.ITALIC,120)); // sets the font for the buttons
            buttons[i].setFocusable(false); // makes them non-focusable
            buttons[i].addActionListener(this);
        }

        title_panel.add(textfield); // adds the text to the panel
        frame.add(title_panel,BorderLayout.NORTH); // to make the title panel stick to the top and not showup in the middle
        frame.add(button_panel); //adds the button panel the main output

        turn(); // decides whose turn it is


    };

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0;i<9;i++) {
            if(e.getSource() == buttons[i]) {   //checks where the input is 
                if(player1_turn) {
                    if(buttons[i].getText() =="") { //checks if it is empty or not
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X"); //print x
                        player1_turn = false; //set turn to O
                        textfield.setText("Turn - O");
                        check();
                    }
                }
                else {
                    if(buttons[i].getText() =="") {
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        player1_turn = true;
                        textfield.setText("Turn - X");
                        check();
                    }
                }
            }
        }

    }


    public void turn(){

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        // to make some delay to show the turn
        if(random.nextInt(2) == 0) {
            player1_turn = true;
            textfield.setText("Turn - X"); // shows text that it is the turn of X
        }
        else {
            player1_turn = false;
            textfield.setText("Turn - O"); // shows the turn of O
        }
    }


    public void check() {
        // to check whether X wins
        if((buttons[0].getText() == "X" )&& (buttons[1].getText() == "X" ) && (buttons[2].getText() == "X" )) {
            xwins(0,1,2);
        }
        if((buttons[3].getText() == "X" )&& (buttons[4].getText() == "X" ) && (buttons[5].getText() == "X" )) {
            xwins(3, 4, 5);
        }
        if((buttons[6].getText() == "X" )&& (buttons[7].getText() == "X" ) && (buttons[8].getText() == "X" )) {
            xwins(6, 7, 8);
        }
        if((buttons[0].getText() == "X" )&& (buttons[3].getText() == "X" ) && (buttons[6].getText() == "X" )) {
            xwins(0, 3, 6);
        }
        if((buttons[1].getText() == "X" )&& (buttons[4].getText() == "X" ) && (buttons[7].getText() == "X" )) {
            xwins(1, 4, 7);
        }
        if((buttons[2].getText() == "X" )&& (buttons[5].getText() == "X" ) && (buttons[8].getText() == "X" )) {
            xwins(2, 5, 8);
        }
        if((buttons[0].getText() == "X" )&& (buttons[4].getText() == "X" ) && (buttons[8].getText() == "X" )) {
            xwins(0, 4, 8);
        }
        if((buttons[2].getText() == "X" )&& (buttons[4].getText() == "X" ) && (buttons[6].getText() == "X" )) {
            xwins(2, 4, 6);
        }
         // to check whether O wins
        if((buttons[0].getText() == "O" )&& (buttons[1].getText() == "O" ) && (buttons[2].getText() == "O" )) {
            owins(0, 1, 2);
        }
        if((buttons[3].getText() == "O" )&& (buttons[4].getText() == "O" ) && (buttons[5].getText() == "O" )) {
            owins(3, 4, 5);
        }
        if((buttons[6].getText() == "O" )&& (buttons[7].getText() == "O" ) && (buttons[8].getText() == "O" )) {
            owins(6, 7, 8);
        }
        if((buttons[0].getText() == "O" )&& (buttons[3].getText() == "O" ) && (buttons[6].getText() == "O" )) {
            owins(0, 3, 6);
        }
        if((buttons[1].getText() == "O" )&& (buttons[4].getText() == "O" ) && (buttons[7].getText() == "O" )) {
            owins(1, 4, 7);
        }
        if((buttons[2].getText() == "O" )&& (buttons[5].getText() == "O" ) && (buttons[8].getText() == "O" )) {
            owins(2, 5, 8);
        }
        if((buttons[0].getText() == "O" )&& (buttons[4].getText() == "O" ) && (buttons[8].getText() == "O" )) {
            owins(0, 4, 8);
        }
        if((buttons[2].getText() == "O" )&& (buttons[4].getText() == "O" ) && (buttons[6].getText() == "O" )) {
            owins(2, 4, 6);
        }

    }


    public void xwins(int a , int b , int c) {
        buttons[a].setBackground(Color.green); // highlights the winning grids.
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        for(int i = 0;i<9;i++) {
            buttons[i].setEnabled(false);     // disables all the buttons.
        }
        textfield.setText("X WINS !!"); // displays the winner.

    }

    // for O
    public void owins(int a , int b , int c) {
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        for(int i = 0;i<9;i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("O WINS !!");

    }


}

public class Main{
    public static void main(String[] args){
        TICTACTOE t = new TICTACTOE();
    }
}
