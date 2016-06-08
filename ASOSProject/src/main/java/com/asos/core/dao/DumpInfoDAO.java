package com.asos.core.dao;

import com.asos.core.entity.DumpInfo;

import java.util.List;

/**
 * Created by Umut on 3.1.2016.
 */
public interface DumpInfoDAO {

    public void addDumpInfo(DumpInfo dumpInfo);

    public List<DumpInfo> getAllDumpInfo();

    public void deleteDumpInfo(Long dumpInfoId);

    public List<DumpInfo> getDumpInfosByGreenHouseId(Long greenHouseId);

}
