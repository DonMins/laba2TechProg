import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class SaveStateCircle {

public static void saveInXml(Circle circle) throws JAXBException, FileNotFoundException {
    JAXBContext context = JAXBContext.newInstance(Circle.class);
    Marshaller marshaller = context.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    marshaller.marshal(circle, new FileOutputStream("state.xml"));
}
}
