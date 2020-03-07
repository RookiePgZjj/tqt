package com.yaorange.tqt.vo;


import com.yaorange.tqt.pojo.Role;

import java.util.List;

public class MIdsRole extends Role {
    private List<String> moduleIds;

    public List<String> getModuleIds() {
        return moduleIds;
    }

    public void setModuleIds(List<String> moduleIds) {
        this.moduleIds = moduleIds;
    }

}
