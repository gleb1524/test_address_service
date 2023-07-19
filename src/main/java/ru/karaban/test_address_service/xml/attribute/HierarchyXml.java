package ru.karaban.test_address_service.xml.attribute;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lombok.Data;
import java.time.LocalDate;

@Data
public class HierarchyXml {

    @XStreamAsAttribute
    private Long ID;
    @XStreamAsAttribute
    private Long OBJECTID;
    @XStreamAsAttribute
    private Long PARENTOBJID;
    @XStreamAsAttribute
    private LocalDate STARTDATE;
    @XStreamAsAttribute
    private LocalDate ENDDATE;
    @XStreamAsAttribute
    private Long ISACTIVE;
}
