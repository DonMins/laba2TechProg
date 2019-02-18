import org.xml.sax.SAXException;

import javax.swing.*;
import javax.swing.event.AncestorListener;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class table {
    private JPanel panelmain;
    private JButton saveXml;
    private JTextField textFieldRadius;
    private JTextField textFieldY;
    private JTextField textFieldX;
    private JLabel radius;
    private JLabel x;
    private JLabel y;
    private JButton getXml;
    private JButton updateButton;
    private JTextField textFieldnewRadius;
    private JTextField textFieldnewX;
    private JTextField textFieldnewY;


    public table(JFrame frame) {

        saveXml.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String st = textFieldRadius.getText();
                double radius = 0;
                try {
                    radius = Double.parseDouble(st);
                } catch (java.lang.NumberFormatException e1) {
                    textFieldRadius.setText("Введите цифры!");
                }

                st = textFieldX.getText();
                double x = 0;
                try {
                    x = Double.parseDouble(st);
                } catch (java.lang.NumberFormatException e1) {
                    textFieldX.setText("Введите цифры!");
                }


                st = textFieldY.getText();
                double y = 0;
                try {
                    y = Double.parseDouble(st);
                } catch (java.lang.NumberFormatException e1) {
                    textFieldY.setText("Введите цифры!");
                }

                Circle circle = new Circle();
                circle = new Circle(radius, x, y);
                try {
                    SaveStateCircle.saveInXml(circle);
                } catch (JAXBException ex) {
                    ex.printStackTrace();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
        getXml.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File f = new File("state.xml");
                if (f.isFile() && !f.isDirectory()) {
                    Circle circle = new Circle();
                    try {
                        circle = XmlParser.getXmlData();
                        textFieldRadius.setText(String.valueOf(circle.getRadius()));
                        textFieldX.setText(String.valueOf(circle.getX()));
                        textFieldY.setText(String.valueOf(circle.getY()));
                    } catch (ParserConfigurationException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (SAXException ex) {
                        ex.printStackTrace();

                    }
                } else {
                    textFieldRadius.setText("Файл не найден!");
                    textFieldX.setText("Файл не найден!");
                    textFieldY.setText("Файл не найден!");

                }
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String st = null;
                double newRadius = 1.0;
                st = textFieldnewRadius.getText();
                if (st.contentEquals("")) {
                    st = "1";
                    textFieldnewRadius.setText(String.valueOf(newRadius));
                }
                try {
                    newRadius = Double.parseDouble(st);
                } catch (java.lang.NumberFormatException e1) {
                    textFieldnewRadius.setText("Введите цифры!");
                }


                double xNew = 0.0;
                st = textFieldnewX.getText();
                if (st.contentEquals("")) {
                    st = "0";
                    textFieldnewX.setText(String.valueOf(xNew));
                }

                try {
                    xNew = Double.parseDouble(st);
                } catch (java.lang.NumberFormatException e1) {
                    textFieldnewX.setText("Введите цифры!");
                }


                double yNew = 0.0;
                st = textFieldnewY.getText();
                if (st.contentEquals("")) {
                    st = "0";
                    textFieldnewY.setText(String.valueOf(yNew));
                }
                try {
                    yNew = Double.parseDouble(st);
                } catch (java.lang.NumberFormatException e1) {
                    textFieldnewY.setText("Введите цифры!");
                }
                Circle circle = new Circle();
                try {
                    circle = XmlParser.getXmlData();
                } catch (ParserConfigurationException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (SAXException ex) {
                    ex.printStackTrace();
                }
                double radius = circle.getRadius();
                st = textFieldRadius.getText();
                if (st.contentEquals("")) {
                    st = String.valueOf(circle.getRadius());
                    textFieldRadius.setText(String.valueOf(circle.getRadius()));
                }
                try {
                    radius = Double.parseDouble(st);
                } catch (java.lang.NumberFormatException e1) {
                    textFieldRadius.setText("Введите цифры!");
                }


                double x = circle.getX();
                st = textFieldX.getText();
                if (st.contentEquals("")) {
                    st = String.valueOf(circle.getX());
                    textFieldX.setText(String.valueOf(circle.getX()));
                }
                try {
                    x = Double.parseDouble(st);
                } catch (java.lang.NumberFormatException e1) {
                    textFieldX.setText("Введите цифры!");
                }

                double y = circle.getY();
                st = textFieldY.getText();
                if (st.contentEquals("")) {
                    st = String.valueOf(circle.getY());
                    textFieldY.setText(String.valueOf(circle.getY()));
                }
                try {
                    y = Double.parseDouble(st);
                } catch (java.lang.NumberFormatException e1) {
                    textFieldY.setText("Введите цифры!");
                }


                circle = new Circle(radius * newRadius, x + xNew, y + yNew);
                try {
                    SaveStateCircle.saveInXml(circle);
                } catch (JAXBException ex) {
                    ex.printStackTrace();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                try {
                    circle = XmlParser.getXmlData();
                } catch (ParserConfigurationException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (SAXException ex) {
                    ex.printStackTrace();
                }

                textFieldRadius.setText(String.valueOf(circle.getRadius()));
                textFieldX.setText(String.valueOf(circle.getX()));
                textFieldY.setText(String.valueOf(circle.getY()));
            }
        });

        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            public void windowClosing(WindowEvent event) {


                String st = textFieldRadius.getText();
                double radius = 0;
                try {
                    radius = Double.parseDouble(st);
                } catch (java.lang.NumberFormatException e1) {
                    textFieldRadius.setText("Введите цифры!");
                }

                st = textFieldX.getText();
                double x = 0;
                try {
                    x = Double.parseDouble(st);
                } catch (java.lang.NumberFormatException e1) {
                    textFieldX.setText("Введите цифры!");
                }


                st = textFieldY.getText();
                double y = 0;
                try {
                    y = Double.parseDouble(st);
                } catch (java.lang.NumberFormatException e1) {
                    textFieldY.setText("Введите цифры!");
                }

                Circle circle = new Circle();
                circle = new Circle(radius, x, y);
                try {
                    SaveStateCircle.saveInXml(circle);
                } catch (JAXBException ex) {
                    ex.printStackTrace();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });


    }

    public static void main(String[] args) {



        JFrame frame = new JFrame("Окружность");

        frame.setContentPane(new table(frame).panelmain);
        frame.setResizable(false);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }


}
