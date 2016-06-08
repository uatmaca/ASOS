package com.asos.core.bo;

import com.asos.core.dao.DumpInfoDAO;
import com.asos.core.entity.DumpInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Umut on 3.1.2016.
 */
@Service("dumpInfoBO")
public class DumpInfoBOImpl implements DumpInfoBO {

    @Autowired
    private DumpInfoDAO dumpInfoDAO;

    @Override
    @Transactional
    public void addDumpInfo(DumpInfo dumpInfo) {
        dumpInfoDAO.addDumpInfo(dumpInfo);
    }

    @Override
    @Transactional
    public List<DumpInfo> getAllDumpInfo() {
        return dumpInfoDAO.getAllDumpInfo();
    }

    @Override
    @Transactional
    public void deleteDumpInfo(Long dumpInfoId) {
        dumpInfoDAO.deleteDumpInfo(dumpInfoId);
    }

    @Override
    @Transactional
    public List<DumpInfo> getDumpInfosByGreenHouseId(Long greenHouseId) {

        if (greenHouseId == null)
            return null;
        return dumpInfoDAO.getDumpInfosByGreenHouseId(greenHouseId);
    }
}
