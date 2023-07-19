package ru.karaban.test_address_service.xml.attribute;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lombok.Data;
import java.time.LocalDate;

@Data
public class AddressXml {

    @XStreamAsAttribute
    private Long ID;
    @XStreamAsAttribute
    private Long OBJECTID;
    @XStreamAsAttribute
    private String NAME;
    @XStreamAsAttribute
    private String TYPENAME;
    @XStreamAsAttribute
    private LocalDate STARTDATE;
    @XStreamAsAttribute
    private LocalDate ENDDATE;
    @XStreamAsAttribute
    private Long ISACTIVE;
    @XStreamAsAttribute
    private Long ISACTUAL;
}
