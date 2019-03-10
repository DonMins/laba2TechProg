import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class SaveStateCircle {

public static void saveInXml(Circle circle) throws JAXBException, FileNotFoundException {

    //создание объекта Marshaller, который выполняет сериализацию
    JAXBContext context = JAXBContext.newInstance(Circle.class);
    Marshaller marshaller = context.createMarshaller();

    // вывод xml в формотированном виде
      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

    // сама сериализация
    marshaller.marshal(circle, new FileOutputStream("state.xml"));
}
}
