import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main  {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Convert");
        JTextField field = new JTextField();
        JLabel label = new JLabel("Enter the amount for convert:");
        JLabel to = new JLabel("convert to");
        JComboBox comboBox = new JComboBox();
        JComboBox comboBox2 = new JComboBox();
        JLabel result = new JLabel("Convert");
        JButton button = new JButton("Convert");
        field.setBounds(100,150,250,50);
        label.setBounds(100,110,250,50);
        comboBox.setBounds(100,220,250,35);
        button.setBounds(100,350,250,30);
        result.setBounds(200,390,250,50);
        to.setBounds(100,250,260,35);
        comboBox2.setBounds(100,290,260,35);
        frame.setLayout(null);
        frame.setSize(500,500);
        frame.add(label);
        frame.add(field);
        frame.add(button);
        frame.add(result);
        frame.add(comboBox);
        frame.add(comboBox2);
        frame.add(to);
        frame.show();

        ArrayList<String> comboboxlist = new ArrayList<>();
        comboboxlist.add("dollor");
        comboboxlist.add("inr");
        comboboxlist.add("dirham");
        comboboxlist.add("ruble");

        for (int i=0;i<comboboxlist.size();i++)
        {
            comboBox.addItem(comboboxlist.get(i));
            comboBox2.addItem(comboboxlist.get(i));
        }

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String convertto = comboBox.getSelectedItem().toString();
                String convertin = comboBox2.getSelectedItem().toString();
                double amount = Double.parseDouble(field.getText());
                double dolloramount = 82.31;
                double inr = 0.012;
                double dirhamtousd = 3.67;
                if (convertto.equals("dollor")|| convertin.equals("inr"))
                {
                    double convertamount = amount*dolloramount;
                    result.setText(String.valueOf("₹"+convertamount));
                }

                if (convertto.equals("inr")|| convertin.equals("dollor"))
                {
                    double convertamount = inr*amount;
                    result.setText(String.valueOf("$"+convertamount));
                }
                if (convertto.equals("dollor")|| convertin.equals("dirham"))
                {
                    double convertamount = dirhamtousd*amount;
                    result.setText(String.valueOf("د.إ"+convertamount));
                }
                if (convertto.equals("dollor")|| convertin.equals("ruble"))
                {
                    double usdtorussian = 90.21;
                    double convertamount = amount*usdtorussian;
                    result.setText(String.valueOf("₽"+convertamount));
                }

                if (convertto.equals("inr")|| convertin.equals("inr"))
                {
                    result.setText(String.valueOf("₹"+amount));
                }


            }
        });

    }
}