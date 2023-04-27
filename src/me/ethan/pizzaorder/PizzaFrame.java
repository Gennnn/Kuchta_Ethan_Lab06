package me.ethan.pizzaorder;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class PizzaFrame extends JFrame {
    JPanel mainPnl;
    public static JPanel crustPnl;
    public static JPanel sizePnl;
    public static JPanel toppingsPnl;
    public static JPanel outputPnl;
    public static JPanel actionPnl;

    public static JRadioButton thinBtn;
    public static JRadioButton regularBtn;
    public static JRadioButton deepdishBtn;

    public static JComboBox sizeBox;

    public static JCheckBox pepperoniBox;
    public static JCheckBox sausageBox;
    public static JCheckBox pineappleBox;
    public static JCheckBox anchovieBox;
    public static JCheckBox hamBox;
    public static JCheckBox baconBox;

    public static JScrollPane outScroller;
    public static JTextArea outArea;

    public static DecimalFormat df = new DecimalFormat("0.00");

    public PizzaFrame() {
        mainPnl = new JPanel();
        mainPnl.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy= 0;
        c.weighty = 0.5;
        c.weightx = 0.5;
        c.ipadx = 0;
        c.ipady = 0;
        c.insets = new Insets(0,0,0,0);
        createCrustPnl();
        mainPnl.add(crustPnl, c);
        createSizePnl();
        c.anchor = GridBagConstraints.FIRST_LINE_END;
        c.gridx = 1;
        mainPnl.add(sizePnl,c );
        c.gridx = 0;
        c.gridy = 1;
        createToppingsPnl();
        c.anchor = GridBagConstraints.LINE_START;
        mainPnl.add(toppingsPnl, c);
        c.anchor = GridBagConstraints.LINE_END;
        c.gridx = 1;
        createOutputPnl();
        mainPnl.add(outputPnl, c);
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        createActionPnl();
        c.anchor = GridBagConstraints.SOUTH;
        c.fill = GridBagConstraints.BOTH;
        mainPnl.add(actionPnl, c);
        add(mainPnl);
        setSize(new Dimension(400,800));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void createCrustPnl() {
        crustPnl = new JPanel();
        JPanel crustPnlInternal = new JPanel();
        crustPnlInternal.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        thinBtn = new JRadioButton("Thin Crust");
        regularBtn = new JRadioButton("Regular Crust");
        deepdishBtn = new JRadioButton("Deep Dish Crust");
        crustPnlInternal.setBorder(new TitledBorder("Crust Options"));
        ((TitledBorder) crustPnlInternal.getBorder()).setTitleJustification(TitledBorder.CENTER);
        crustPnlInternal.setPreferredSize(new Dimension(190,150));
        ButtonGroup group = new ButtonGroup();
        group.add(thinBtn);
        group.add(regularBtn);
        group.add(deepdishBtn);
        c.gridy = 0;
        c.ipady = 10;
        crustPnlInternal.add(thinBtn, c);
        c.gridy = 2;

        crustPnlInternal.add(regularBtn, c);
        c.gridy = 4;

        crustPnlInternal.add(deepdishBtn, c);
        crustPnl.add(crustPnlInternal);
    }

    public void createSizePnl() {
        sizePnl = new JPanel();
        JPanel sizePnlInternal = new JPanel();
        sizePnlInternal.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        sizeBox = new JComboBox();
        sizeBox.addItem("Small - $8.00");
        sizeBox.addItem("Medium - $12.00");
        sizeBox.addItem("Large - $16.00");
        sizeBox.addItem("Super - $20.00");
        sizeBox.setSelectedItem("Medium - $12.00");
        sizePnlInternal.setBorder(new TitledBorder("Size Options"));
        ((TitledBorder) sizePnlInternal.getBorder()).setTitleJustification(TitledBorder.CENTER);
        c.anchor = GridBagConstraints.NORTH;
        c.insets = new Insets(0 , 0, 50 , 0);
        sizePnlInternal.add(sizeBox, c);
        sizePnl.add(sizePnlInternal);
        sizePnlInternal.setPreferredSize(new Dimension(190, 150));
    }

    public void createToppingsPnl() {
        toppingsPnl = new JPanel();
        JPanel toppingsPnlInternal = new JPanel();
        toppingsPnlInternal.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        pepperoniBox = new JCheckBox("Pepperoni");
        sausageBox = new JCheckBox("Sausage");
        pineappleBox = new JCheckBox("Pineapple");
        baconBox = new JCheckBox("Bacon");
        hamBox = new JCheckBox("Ham");
        anchovieBox = new JCheckBox("Anchovies");
        c.ipadx = 10;
        c.ipady = 10;
        c.insets = new Insets( 2,2,2,2);
        c.gridx = 0;
        c.gridy= 0;
        toppingsPnlInternal.add(pepperoniBox, c);
        c.gridy = 1;
        toppingsPnlInternal.add(sausageBox, c);
        c.gridy = 2;
        toppingsPnlInternal.add(pineappleBox, c);
        c.gridy = 3;
        toppingsPnlInternal.add(baconBox, c);
        c.gridy = 4;
        toppingsPnlInternal.add(hamBox, c);
        c.gridy = 5;
        toppingsPnlInternal.add(anchovieBox, c);
        toppingsPnlInternal.setBorder(new TitledBorder("Topping Options"));
        ((TitledBorder) toppingsPnlInternal.getBorder()).setTitleJustification(TitledBorder.CENTER);
        toppingsPnlInternal.setPreferredSize(new Dimension(190,365));
        toppingsPnl.add(toppingsPnlInternal);

    }

    public void createOutputPnl() {
        outputPnl = new JPanel();
        JPanel outputPnlInternal = new JPanel();
        outputPnlInternal.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        outArea = new JTextArea();
        outArea.setEditable(false);
        outScroller = new JScrollPane();
        outArea.add(outScroller);
        outArea.setPreferredSize(new Dimension(170,340));
        outScroller.setPreferredSize(new Dimension(170,340));
        outputPnlInternal.add(outArea);
        c.anchor = GridBagConstraints.CENTER;
        outputPnlInternal.setBorder( new TitledBorder("Receipt"));
        ((TitledBorder) outputPnlInternal.getBorder()).setTitleJustification(TitledBorder.CENTER);
        outArea.setFont(new Font("SansSerif", Font.PLAIN, 10));
        outputPnl.add(outputPnlInternal, c);
        outputPnlInternal.setPreferredSize(new Dimension(190, 365));

    }

    public void createActionPnl() {
        actionPnl = new JPanel();
        JPanel actionPnlInternal = new JPanel();
        actionPnlInternal.setLayout(new GridBagLayout());
        actionPnl.setLayout(new BorderLayout());
        GridBagConstraints c = new GridBagConstraints();
        JButton orderBtn = new JButton();
        JButton clearBtn = new JButton();
        JButton quitBtn = new JButton();
        clearBtn.addActionListener(
                (ActionEvent ae) ->
                {
                    thinBtn.setSelected(false);
                    regularBtn.setSelected(false);
                    deepdishBtn.setSelected(false);
                    sizeBox.setSelectedItem("Medium - $12.00");
                    pepperoniBox.setSelected(false);
                    sausageBox.setSelected(false);
                    pineappleBox.setSelected(false);
                    hamBox.setSelected(false);
                    anchovieBox.setSelected(false);
                    baconBox.setSelected(false);
                    outScroller.removeAll();
                }

        );
        orderBtn.addActionListener(
                (ActionEvent ae) ->
                {
                    String crustType = "";
                    String size = "";
                    ArrayList<String> toppings = new ArrayList<>();
                    int price = 0;
                    outArea.setText("");
                    if (!thinBtn.isSelected() && !regularBtn.isSelected() && !deepdishBtn.isSelected()) {
                        JOptionPane.showMessageDialog(null, "You must select a crust type!", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        if (thinBtn.isSelected()) {
                            crustType = "Thin Crust";
                        } else if (regularBtn.isSelected()) {
                            crustType = "Regular Crust";
                        } else if (deepdishBtn.isSelected()) {
                            crustType = "Deep Dish";
                        }
                        int sizeInt = sizeBox.getSelectedIndex();
                        if (sizeInt == 0) {
                            size = "Small";
                            price = price + 8;
                        } else if (sizeInt == 1) {
                            size = "Medium";
                            price = price + 12;
                        } else if (sizeInt == 2) {
                            size = "Large";
                            price = price + 16;
                        } else if (sizeInt == 3) {
                            size = "Super";
                            price = price + 20;
                        }
                        if (pepperoniBox.isSelected()) {
                            toppings.add("Pepperoni");
                            price = price + 1;
                        }
                        if (pineappleBox.isSelected()) {
                            toppings.add("Pineapple");
                            price = price + 1;
                        }
                        if (hamBox.isSelected()) {
                            toppings.add("Ham");
                            price = price + 1;
                        }
                        if (sausageBox.isSelected()) {
                            toppings.add("Sausage");
                            price = price + 1;
                        }
                        if (baconBox.isSelected()) {
                            toppings.add("Bacon");
                            price = price + 1;
                        }
                        if (anchovieBox.isSelected()) {
                            toppings.add("Anchovies");
                            price = price + 1;
                        }
                        String toppingsString = "    ";
                        for (int i = 0; i < toppings.size(); i++) {
                            if (i != toppings.size() - 1) {
                                toppingsString = toppingsString + toppings.get(i) + "\n    ";
                            } else {
                                toppingsString = toppingsString + toppings.get(i);
                            }
                        }
                        if (toppings.size() == 0) {
                            toppingsString = toppingsString + "None";
                        }
                        outArea.append("=====================\n" + "Crust: " + crustType + "\n\nSize: " + size + "\n\nToppings: \n" + toppingsString + "\n\nSub-Total: $" + df.format(price) + "\nTax: $" + df.format(price * .07) + "\n\n----------------------------\n\n" + "Total: $" + df.format(price * 1.07) + "\n=====================");
                    }
                }

        );
    quitBtn.addActionListener(
            (ActionEvent ae) ->
            {
                int result = JOptionPane.showConfirmDialog(null, "Are you sure you would like to exit?", "Confrim Exit", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    System.exit(1);
                }
            }
    );
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(10,5,10,5);
        c.gridx = 0;
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.anchor = GridBagConstraints.WEST;

        actionPnlInternal.add(orderBtn, c);
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 1;
        actionPnlInternal.add(clearBtn, c);
        c.anchor = GridBagConstraints.EAST;
        c.gridx = 2;
        actionPnlInternal.add(quitBtn, c);
        clearBtn.setText("Clear");
        orderBtn.setText("Order");
        quitBtn.setText("Quit");

        actionPnl.add(actionPnlInternal, BorderLayout.CENTER);




    }
}
