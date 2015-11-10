package validator;

import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Schema;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import javax.xml.validation.Validator;
import javax.xml.transform.dom.DOMSource;
import java.io.File;

class ValidatorDOM {
  public static void main(String[] a) {
      System.out.println("XsdSchemaValidator");
      String schemaName = "src/OldCardXMLSchema.xsd";
      String xmlName = "src/OldCard.xml";
      Schema schema = loadSchema(schemaName);
      Document document = parseXmlDom(xmlName);
      validateXml(schema, document);
  }

  public static void validateXml(Schema schema, Document document) {
    try {
      // creating a Validator instance
      Validator validator = schema.newValidator();

      // validating the document against the schema
      validator.validate(new DOMSource(document));
      System.out.println("Validation passed.");

    } catch (Exception e) {
      System.out.println("Validation exception:\n\t" + e.toString());
    }
  }

  public static Schema loadSchema(String name) {
    Schema schema = null;
    try {
      String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
      SchemaFactory factory = SchemaFactory.newInstance(language);
      schema = factory.newSchema(new File(name));
      System.out.println("Schema loaded");
    } catch (Exception e) {
      System.out.println("Schema is not loaded:\n\t" + e.toString());
    }
    return schema;
  }

  public static Document parseXmlDom(String name) {
    Document document = null;
    try {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      document = builder.parse(new File(name));
      System.out.println("XmlDom parsed");
    } catch (Exception e) {
      System.out.println("XmlDom is not parsed:\n\t" + e.toString());
    }
    return document;
  }
}
