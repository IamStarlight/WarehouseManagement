package com.bjtu.warehousemanagebackend.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品库存表
 * </p>
 *
 * @author Jinxuan Chen
 * @since 2024-04-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("inventory")
@ApiModel(value="Inventory对象", description="商品库存表")
public class Inventory implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "库存id")
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @ApiModelProperty(value = "商品id")
    private String cid;

    @ApiModelProperty(value = "仓库id")
    private String wid;

    @ApiModelProperty(value = "备注")
    private String description;

    @ApiModelProperty(value = "库存数量")
    private Integer count;
}
