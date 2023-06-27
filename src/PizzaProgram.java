//our imports
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//our Pizzaclass
public class PizzaProgram extends JFrame implements ActionListener {

    //our instance variables
    private JButton buttonOk;
    private JRadioButton small, medium, large;
    private JCheckBox Pepperoni, Mushroom, Spice;

//constructor
    public PizzaProgram() {

        //basic Jframe methods
        this.setSize(320, 200);
        this.setTitle("Pizza Order");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //creating objects
        JPanel mainpanel = new JPanel();
        JPanel sizePanel = new JPanel();
        JPanel topPanel = new JPanel();
        Border b1 = BorderFactory.createTitledBorder("Size");
        sizePanel.setBorder(b1); //adding border to size panel
        ButtonGroup sizeGroup = new ButtonGroup();

        //using the objects
        small = new JRadioButton("Small");
        small.setSelected(true);
        sizePanel.add(small);
        sizeGroup.add(small);
        medium = new JRadioButton("Medium");
        sizePanel.add(medium);
        sizeGroup.add(medium);
        large = new JRadioButton("Large");
        sizePanel.add(large);
        sizeGroup.add(large);
        mainpanel.add(sizePanel); //adding size panel to mainPanel
        Border b2 = BorderFactory.createTitledBorder("Toppings");
        topPanel.setBorder(b2); //adding border to topPanel
        Pepperoni = new JCheckBox("Pepperoni");
        topPanel.add(Pepperoni);
        Mushroom = new JCheckBox("Mushroom");
        topPanel.add(Mushroom);
        Spice = new JCheckBox("Stew");
        topPanel.add(Spice);
        mainpanel.add(topPanel); //adding topPanel to mainPanel
        buttonOk = new JButton("OK");
        buttonOk.addActionListener(this::actionPerformed); //adding action listener
        mainpanel.add(buttonOk); //adding button to mainPanel

        //some other regular JFrame setup
        this.add(mainpanel);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

    }
    //action performed by the buttonOK
    @Override
    public void actionPerformed(ActionEvent e) {
        String tops = "";
        if (Pepperoni.isSelected()) {
            tops += "Pepperoni; ";
        }
        if (Mushroom.isSelected()) {
            tops += " Mushroom;";
        }
        if (Spice.isSelected()) {
            tops += " Stew.";
        }
        String msg = "You Ordered: ";
        if (small.isSelected()) {
            msg += "Small Pizza with ";
        }
        if (medium.isSelected()) {
            msg += "Medium Pizza with ";
        }
        if (large.isSelected()) {
            msg += "Large Pizza with ";
        } if (tops.equals("")) {
            msg += "No Toppings ";
        } else {
            msg += "the following toppings: " + tops;
            JOptionPane.showMessageDialog(buttonOk, msg, "Your Order", JOptionPane.INFORMATION_MESSAGE);
            }
            Pepperoni.setSelected(false);
            Mushroom.setSelected(false);
            Spice.setSelected(false);
            small.setSelected(true);
    }
}


