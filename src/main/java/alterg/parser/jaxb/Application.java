package alterg.parser.jaxb;

import alterg.Main;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Application {

    public static void main(String[] args) {
        String filename = "studs.xml";
        Student student = new Student(1, "Ivan", 23, "Russian");
        convertObjectToXml(student, filename);
        student = convertXmlToObject(filename);
        System.out.println(student);
    }

    private static Student convertXmlToObject(String filename) {
        Student student = null;
        try {
            JAXBContext ctx = JAXBContext.newInstance(Student.class);
            Unmarshaller unmarshaller = ctx.createUnmarshaller();
            student = (Student) unmarshaller.unmarshal(new File(filename));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return student;
    }


    private static void convertObjectToXml(Student student, String filename) {
        try {
            JAXBContext ctx = JAXBContext.newInstance(Student.class);
            Marshaller marshaller = ctx.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(student, new File(filename));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
