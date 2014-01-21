
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Buttons4 extends JFrame {
    
    private JLabel label1;
    private JButton button1;
    private JButton button2;
    
    public Buttons4() {
        setTitle("Επίδειξη JButton");
        setSize(270, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);        
        
        label1 = new JLabel("Ετικέτα");
        button1 = new JButton();
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label1.setText("Πατήθηκε το κουμπί άλφα");                            
            }
        });
        button1.setText("Κουμπί Άλφα");
        button2 = new JButton("Κουμπί Βήτα");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label1.setText("Πατήθηκε το κουμπί βήτα");            
            }
        });
        
        FlowLayout aLayout = new FlowLayout();
        setLayout(aLayout);
        
        add(button1);
        add(button2);
        add(label1);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        Buttons4 frame = new Buttons4();
    }
}
