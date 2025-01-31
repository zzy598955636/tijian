package com.example.tijianapi.db.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * 行为表
 * @TableName tb_action
 */
@Data
public class ActionEntity implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 行为编号
     */
    private String actionCode;

    /**
     * 行为名称
     */
    private String actionName;

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
        ActionEntity other = (ActionEntity) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getActionCode() == null ? other.getActionCode() == null : this.getActionCode().equals(other.getActionCode()))
            && (this.getActionName() == null ? other.getActionName() == null : this.getActionName().equals(other.getActionName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getActionCode() == null) ? 0 : getActionCode().hashCode());
        result = prime * result + ((getActionName() == null) ? 0 : getActionName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", actionCode=").append(actionCode);
        sb.append(", actionName=").append(actionName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}