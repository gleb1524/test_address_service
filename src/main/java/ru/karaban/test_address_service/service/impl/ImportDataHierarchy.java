package ru.karaban.test_address_service.service.impl;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.karaban.test_address_service.service.HierarchyService;
import ru.karaban.test_address_service.service.ImportData;
import ru.karaban.test_address_service.xml.Hierarchys;
import java.io.File;
import java.io.InputStream;

@Component
@Order(2)
@RequiredArgsConstructor
public class ImportDataHierarchy implements ImportData {


    @Value("${address_service.hierarchyFilePath}")
    private String hierarchyFilePath;
    private final HierarchyService hierarchyService;
    @Override
    @SneakyThrows
    public void importData() {
        InputStream fileInputStream = this.getClass().getClassLoader().getResourceAsStream(hierarchyFilePath);
        if(fileInputStream!=null){
            XStream xstream = new XStream();
            xstream.addPermission(AnyTypePermission.ANY);
            xstream.allowTypes(new Class[]{Hierarchys.class});
            xstream.processAnnotations(Hierarchys.class);
            Hierarchys hierarchys = (Hierarchys) xstream.fromXML(fileInputStream);
            hierarchyService.saveAll(hierarchys);
            fileInputStream.close();
        }
    }
}
