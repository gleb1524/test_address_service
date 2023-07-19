package ru.karaban.test_address_service.service.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.karaban.test_address_service.annotation.PostProxy;
import ru.karaban.test_address_service.service.ImportData;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Init {

    private final List<ImportData> importDataList;
    @PostProxy
    public void init() {
        for (ImportData importData : importDataList) {
            importData.importData();
        }
    }
}
