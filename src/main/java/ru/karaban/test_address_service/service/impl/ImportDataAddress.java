package ru.karaban.test_address_service.service.impl;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.karaban.test_address_service.annotation.PostProxy;
import ru.karaban.test_address_service.service.AddressService;
import ru.karaban.test_address_service.service.ImportData;
import ru.karaban.test_address_service.xml.Addresses;
import java.io.File;
import java.io.InputStream;

@Component
@Order(1)
@RequiredArgsConstructor
public class ImportDataAddress implements ImportData {

    @Value("${address_service.addressFilePath}")
    private String addressFilePath;
    private final AddressService addressServiceImpl;

    @Override
    @SneakyThrows
    public void importData() {
        InputStream fileInputStream = this.getClass().getClassLoader().getResourceAsStream(addressFilePath);
        if(fileInputStream!=null){
            XStream xstream = new XStream();
            xstream.addPermission(AnyTypePermission.ANY);
            xstream.allowTypes(new Class[]{Addresses.class});
            xstream.processAnnotations(Addresses.class);
            Addresses element = (Addresses) xstream.fromXML(fileInputStream);
            addressServiceImpl.saveAll(element);
            fileInputStream.close();
        }
    }
}
