package generator.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 体检套餐表
 * @TableName tb_goods
 */
@Data
public class GoodsEntity implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 编号
     */
    private String code;

    /**
     * 商品标题
     */
    private String title;

    /**
     * 商品描述
     */
    private String description;

    /**
     * 科室检查
     */
    private String checkup1;

    /**
     * 实验室检查
     */
    private String checkup2;

    /**
     * 医技检查
     */
    private String checkup3;

    /**
     * 其他检查
     */
    private String checkup4;

    /**
     * 检查内容
     */
    private String checkup;

    /**
     * 商品封面
     */
    private String image;

    /**
     * 原价
     */
    private BigDecimal initialPrice;

    /**
     * 现价
     */
    private BigDecimal currentPrice;

    /**
     * 销量
     */
    private Integer salesVolume;

    /**
     * 套餐类型
     */
    private String type;

    /**
     * 套餐标签
     */
    private String tag;

    /**
     * 1活动专区，2热卖套餐，3新品推荐，4孝敬父母，5,白领精英
     */
    private Integer partId;

    /**
     * 促销优惠规则的ID
     */
    private Integer ruleId;

    /**
     * 状态(1上架，0下架)
     */
    private Integer status;

    /**
     * MD5信息
     */
    private String md5;

    /**
     * 最后修改时间
     */
    private String updateTime;

    /**
     * 创建时间
     */
    private String createTime;

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
        GoodsEntity other = (GoodsEntity) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getCheckup1() == null ? other.getCheckup1() == null : this.getCheckup1().equals(other.getCheckup1()))
            && (this.getCheckup2() == null ? other.getCheckup2() == null : this.getCheckup2().equals(other.getCheckup2()))
            && (this.getCheckup3() == null ? other.getCheckup3() == null : this.getCheckup3().equals(other.getCheckup3()))
            && (this.getCheckup4() == null ? other.getCheckup4() == null : this.getCheckup4().equals(other.getCheckup4()))
            && (this.getCheckup() == null ? other.getCheckup() == null : this.getCheckup().equals(other.getCheckup()))
            && (this.getImage() == null ? other.getImage() == null : this.getImage().equals(other.getImage()))
            && (this.getInitialPrice() == null ? other.getInitialPrice() == null : this.getInitialPrice().equals(other.getInitialPrice()))
            && (this.getCurrentPrice() == null ? other.getCurrentPrice() == null : this.getCurrentPrice().equals(other.getCurrentPrice()))
            && (this.getSalesVolume() == null ? other.getSalesVolume() == null : this.getSalesVolume().equals(other.getSalesVolume()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getTag() == null ? other.getTag() == null : this.getTag().equals(other.getTag()))
            && (this.getPartId() == null ? other.getPartId() == null : this.getPartId().equals(other.getPartId()))
            && (this.getRuleId() == null ? other.getRuleId() == null : this.getRuleId().equals(other.getRuleId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getMd5() == null ? other.getMd5() == null : this.getMd5().equals(other.getMd5()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getCheckup1() == null) ? 0 : getCheckup1().hashCode());
        result = prime * result + ((getCheckup2() == null) ? 0 : getCheckup2().hashCode());
        result = prime * result + ((getCheckup3() == null) ? 0 : getCheckup3().hashCode());
        result = prime * result + ((getCheckup4() == null) ? 0 : getCheckup4().hashCode());
        result = prime * result + ((getCheckup() == null) ? 0 : getCheckup().hashCode());
        result = prime * result + ((getImage() == null) ? 0 : getImage().hashCode());
        result = prime * result + ((getInitialPrice() == null) ? 0 : getInitialPrice().hashCode());
        result = prime * result + ((getCurrentPrice() == null) ? 0 : getCurrentPrice().hashCode());
        result = prime * result + ((getSalesVolume() == null) ? 0 : getSalesVolume().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getTag() == null) ? 0 : getTag().hashCode());
        result = prime * result + ((getPartId() == null) ? 0 : getPartId().hashCode());
        result = prime * result + ((getRuleId() == null) ? 0 : getRuleId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getMd5() == null) ? 0 : getMd5().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", code=").append(code);
        sb.append(", title=").append(title);
        sb.append(", description=").append(description);
        sb.append(", checkup1=").append(checkup1);
        sb.append(", checkup2=").append(checkup2);
        sb.append(", checkup3=").append(checkup3);
        sb.append(", checkup4=").append(checkup4);
        sb.append(", checkup=").append(checkup);
        sb.append(", image=").append(image);
        sb.append(", initialPrice=").append(initialPrice);
        sb.append(", currentPrice=").append(currentPrice);
        sb.append(", salesVolume=").append(salesVolume);
        sb.append(", type=").append(type);
        sb.append(", tag=").append(tag);
        sb.append(", partId=").append(partId);
        sb.append(", ruleId=").append(ruleId);
        sb.append(", status=").append(status);
        sb.append(", md5=").append(md5);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}