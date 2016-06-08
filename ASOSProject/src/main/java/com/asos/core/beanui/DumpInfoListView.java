package com.asos.core.beanui;

import com.asos.core.beancontroller.DumpInfoBeanController;
import com.asos.core.entity.DumpInfo;
import com.asos.core.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;
import java.util.Map;

/**
 * Created by Umut on 5.3.2016.
 */
@Component
@ManagedBean(name = "dumpInfoListView")
@ViewScoped
public class DumpInfoListView {

    List<DumpInfo> dumpInfos;

    @Autowired
    private DumpInfoBeanController dumpInfoBeanController;

    @PostConstruct
    public void init() {
        dumpInfos = dumpInfoBeanController.getDumpInfosByGreenHouseId(null);
    }

    public List<DumpInfo> getDumpInfos() {

        Map<String,String> params = HttpUtil.getExternalContext().getRequestParameterMap();
        String paramGreenHouseId = params.get("paramGreenHouseId");

        Long greenHouseId = Long.parseLong(paramGreenHouseId);

        dumpInfos = dumpInfoBeanController.getDumpInfosByGreenHouseId(greenHouseId);

        return dumpInfos;
    }

    public void setDumpInfos(List<DumpInfo> dumpInfos) {
        this.dumpInfos = dumpInfos;
    }
}
