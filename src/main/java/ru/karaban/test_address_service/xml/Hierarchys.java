package ru.karaban.test_address_service.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.Data;
import ru.karaban.test_address_service.xml.attribute.HierarchyXml;

import java.util.List;

@XStreamAlias("ITEMS")
@Data
public class Hierarchys {

    @XStreamImplicit(itemFieldName = "ITEM")
    private List<HierarchyXml> hierarchyXmls;
}
