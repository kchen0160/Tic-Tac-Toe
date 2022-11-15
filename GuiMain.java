import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GuiMain extends JFrame implements ActionListener {

    private JLabel res;
    private JPanel b_panel;
    private JButton[] b;
    private boolean gameOver = false;
    private Integer counter = 0;
    private String symbol = "X";

    public GuiMain() {
        b = new JButton[9];
        setTitle("Tic Tac Toe");
        setLayout(new BorderLayout());

        res = new JLabel();
        res.setHorizontalAlignment(JLabel.CENTER);
        b_panel = new JPanel();
        b_panel.setLayout(new GridLayout(3,3));
        add(res, BorderLayout.NORTH);
   
        for (int i = 0; i < 9; i++) {
            b[i] = new JButton("");
            b[i].setName("location" + (i / 3) + "" + (i % 3));
            b[i].addActionListener(this);
            b[i].setPreferredSize(new Dimension(100, 100));
            b_panel.add(b[i]);
        }
        res.setName("result");

        add(b_panel, BorderLayout.CENTER);
        pack();
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent event) {
        for (int x = 0; x < 9; x++) {
            if (!gameOver) {
                if(event.getSource().equals(b[x]) && b[x].getText().equals("")) {
                    b[x].setText(symbol);
                    counter += 1;
                    boolean playerWins = check_win(b, symbol);
                    if (playerWins) {
                        res.setText(symbol + " wins");
                        game_over();
                        gameOver = true;
                    }
                    if (!playerWins && counter == 9) {
                        res.setText("Tie");
                        game_over();
                        gameOver = true;
                    } 
                    if (!gameOver) {
                        if (symbol.equals("X")) symbol = "O";
                        else symbol = "X";
                    }
                    return;
                }
            }
        }
    }

    public boolean check_win(JButton[] butt, String player) {
        if (butt[0].getText().equals(player) && butt[1].getText().equals(player) && butt[2].getText().equals(player)) {
            return true;
        } else if (butt[3].getText().equals(player) && butt[4].getText().equals(player) && butt[5].getText().equals(player)) {
            return true;
        } else if (butt[6].getText().equals(player) && butt[7].getText().equals(player) && butt[8].getText().equals(player)) {
            return true;
        } else if (butt[0].getText().equals(player) && butt[3].getText().equals(player) && butt[6].getText().equals(player)) {
            return true;
        } else if (butt[1].getText().equals(player) && butt[4].getText().equals(player) && butt[7].getText().equals(player)) {
            return true;
        } else if (butt[2].getText().equals(player) && butt[5].getText().equals(player) && butt[8].getText().equals(player)) {
            return true;
        } else if (butt[0].getText().equals(player) && butt[4].getText().equals(player) && butt[8].getText().equals(player)) {
            return true;
        } else if (butt[2].getText().equals(player) && butt[4].getText().equals(player) && butt[6].getText().equals(player)) {
            return true;
        } else {
            return false;
        }
    }

    public void game_over() {
        for (int i = 0; i < 9; i++) {
            b[i].setEnabled(false);
        }
    }

	public static void main(String[] args) {
	    GuiMain window = new GuiMain();
        window.setVisible(true);
	}
}