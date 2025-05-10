import javax.swing.*;

public class Frame extends JFrame {
    Frame(){
        this.setResizable(false);
        this.add(new Panel());
        this.pack();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
