import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private JLabel description2;
    private JLabel description3;
    private JLabel coughing_label;
    private JSlider coughingSlider;
    private JLabel feverLabel;
    private JSlider feverSlider;
    private JLabel breathingLabel;
    private JButton calculateTheRiskButton;
    private JPanel MainPanel;
    private JSlider breathingSlider;

    public Main(){
        setContentPane(MainPanel);
        setTitle("Covid-19 infection probability based on visible symptoms");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,700);
        setLocationRelativeTo(null);
        setVisible(true);
        calculateTheRiskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

JOptionPane.showMessageDialog(Main.this,breathingSlider.getValue());
            }
        });
    }

    public static void main(String[] args) {
        new Main();
    }
}
