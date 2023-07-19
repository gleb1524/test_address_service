package ru.karaban.test_address_service.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.Data;
import ru.karaban.test_address_service.xml.attribute.AddressXml;


import java.util.List;


@XStreamAlias("ADDRESSOBJECTS")
@Data
public class Addresses {


    @XStreamImplicit(itemFieldName = "OBJECT")
    private List<AddressXml> addressXmls;
}
