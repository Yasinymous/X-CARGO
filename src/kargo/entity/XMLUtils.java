/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kargo.entity;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author ysnak
 */
public class XMLUtils<T> {
    private Class s;

    public XMLUtils(Class s) {
        this.s = s;
    }
    
    public void write(Object o , String path){
        try {
            JAXBContext context = JAXBContext.newInstance(s);
            Marshaller marshaller = context.createMarshaller();
            //marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(o, new File(path +".xml"));
        } catch (JAXBException ex) {
            
        }
    }

    public ObservableList<T> lists(String path, String fileName) {
        ObservableList<T> XMLStream = FXCollections.observableArrayList();
        try {
            Stream<Path> store = Files.list(Paths.get(path));
            JAXBContext context = JAXBContext.newInstance(s);
            store.forEach((t) -> {
                try {
                    Unmarshaller unmarshaller = context.createUnmarshaller();
                    XMLStream.add((T) unmarshaller.unmarshal(new File(t + "/" + fileName + ".xml")));
                } catch (JAXBException ex) {
                    
                }
            });
        } catch (IOException ex) {
           
        } catch (JAXBException ex) {
            
        }
        return XMLStream;
    }

    public T lists(String path) {
        T t = null;
        try {
            JAXBContext context = JAXBContext.newInstance(s);
            try {
                Unmarshaller unmarshaller = context.createUnmarshaller();
                t = (T) unmarshaller.unmarshal(new File(path + ".xml"));
            } catch (JAXBException ex) {
                
            }
        } catch (JAXBException ex) {
            
        }
        return t;
    }
}
