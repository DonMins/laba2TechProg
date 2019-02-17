import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, JAXBException, ParserConfigurationException, SAXException {
        final String COMMAND_YES = "Y";
        final String COMMAND_NO = "N";
        final String MESSAGE_CONTINUE = "Continue? (Y/N)>";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Circle circle = new Circle();

        File f = new File("state.xml");
        if(f.isFile() && !f.isDirectory()) {
            circle = XmlParser.getXmlData();
        }
        else {

            System.out.print("Введите радиус окружности: ");
            String st1 = reader.readLine();
            double radius = Double.parseDouble(st1);

            System.out.print("Введите координату центра по х: ");
            String st2 = reader.readLine();
            int x = Integer.parseInt(st2);

            System.out.print("Введите координату центра по y: ");
            String st3 = reader.readLine();
            int y = Integer.parseInt(st3);

            circle = new Circle(radius, x, y);

            SaveStateCircle.saveInXml(circle);
        }
        System.out.println(MESSAGE_CONTINUE);
        String continu = reader.readLine();

        if (continu.equals(COMMAND_YES)) {
            System.out.print("Умножить радиус ? (Y/N)");
            String newRadius = reader.readLine();
            if (newRadius.equals(COMMAND_YES)) {
                System.out.print("Умножить радиус на: ");
                String st = reader.readLine();
                circle.newRadius(Double.parseDouble(st));
                SaveStateCircle.saveInXml(circle);
            }
            if (newRadius.equals(COMMAND_NO) || newRadius.equals(COMMAND_YES)) {
                System.out.print("Cместить окружность ? (Y/N) ");
                String st = reader.readLine();
                if (st.equals(COMMAND_YES)) {
                    System.out.print("Координата смещения по x: ");
                    String str1 = reader.readLine();
                    Double newX = Double.parseDouble(str1);

                    System.out.print("Координата смещения по y: ");
                    String str2 = reader.readLine();
                    Double newY = Double.parseDouble(str2);
                    circle.newPosition(newX, newY);

                    SaveStateCircle.saveInXml(circle);
                }
            }
        } else {
            System.exit(0);
        }
    }
}