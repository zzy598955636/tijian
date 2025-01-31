package com.example.tijianapi.db.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * 权限表
 * @TableName tb_permission
 */
@Data
public class PermissionEntity implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 权限
     */
    private String permissionName;

    /**
     * 模块ID
     */
    private Integer moduleId;

    /**
     * 行为ID
     */
    private Integer actionId;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PermissionEntity other = (PermissionEntity) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPermissionName() == null ? other.getPermissionName() == null : this.getPermissionName().equals(other.getPermissionName()))
            && (this.getModuleId() == null ? other.getModuleId() == null : this.getModuleId().equals(other.getModuleId()))
            && (this.getActionId() == null ? other.getActionId() == null : this.getActionId().equals(other.getActionId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPermissionName() == null) ? 0 : getPermissionName().hashCode());
        result = prime * result + ((getModuleId() == null) ? 0 : getModuleId().hashCode());
        result = prime * result + ((getActionId() == null) ? 0 : getActionId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", permissionName=").append(permissionName);
        sb.append(", moduleId=").append(moduleId);
        sb.append(", actionId=").append(actionId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}