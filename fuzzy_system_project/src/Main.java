import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

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
    private double result;

    public String getRiskDescription(){
        if(result>=0 && result<=20) return "Risk very low";
        if(result>20 && result<=40) return "Risk low";
        if(result>40 && result<=60) return "Risk medium";
        if(result>60 && result<=80) return "Risk high";
        if(result>80) return "Risk very high";
        return "";
    }

    public Main(){
        setContentPane(MainPanel);
        setTitle("Covid-19 infection probability based on visible symptoms");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,700);
        setLocationRelativeTo(null);
        setVisible(true);
        calculateTheRiskButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                FuzzyClass fuzzyClass = new FuzzyClass(coughingSlider.getValue(),feverSlider.getValue(),breathingSlider.getValue());
                try {
                    result = fuzzyClass.calculateInfectionRisk();
                } catch(Exception ex) {
                    System.out.println(ex.getMessage());
                    result=-1;
                }
                DecimalFormat df = new DecimalFormat("#.##");
                String resultToShow=result>=0 ? df.format(result)+"%\n"+ getRiskDescription() : "An error occurred during risk calculation.";
                JOptionPane.showMessageDialog(Main.this, resultToShow);
            }
        });
    }

    public static void main(String[] args) {
        new Main();
    }
}
