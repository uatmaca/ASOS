package com.asos.core.beancontroller;

import com.asos.core.bo.DumpInfoBO;
import com.asos.core.entity.DumpInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Umut on 5.3.2016.
 */
@Component
public class DumpInfoBeanController {

    @Autowired
    private DumpInfoBO dumpInfoBO;

    public List<DumpInfo> getAllDumpInfos() {
        return dumpInfoBO.getAllDumpInfo();
    }

    public List<DumpInfo> getDumpInfosByGreenHouseId(Long greenHouseId) {
        return dumpInfoBO.getDumpInfosByGreenHouseId(greenHouseId);
    }

}
