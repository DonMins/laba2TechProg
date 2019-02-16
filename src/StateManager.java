import javax.xml.bind.*;
import java.io.File;
public class StateManager {
    public static final String STATE_FILENAME =
            "state.xml";
    private File file;
    private JAXBContext context;
    public StateManager() throws JAXBException {
        this.file = new File(STATE_FILENAME);
        this.context =
                JAXBContext.newInstance(IntState.class);
    }
    public int getState() throws JAXBException {
        Unmarshaller unmarshaller =
                context.createUnmarshaller();
        return
                ((IntState)unmarshaller.unmarshal(file)).getState();
    }
    public void setState(int state) throws
            JAXBException {
        Marshaller marshaller =
                context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT
                , true);
        marshaller.marshal(new IntState(state), file);
    }
}