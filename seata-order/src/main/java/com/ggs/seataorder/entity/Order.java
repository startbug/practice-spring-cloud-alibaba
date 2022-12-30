package com.ggs.seataorder.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author starbug
 * @since 2022-12-29
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("order")
@ApiModel(value = "Order对象", description = "订单表")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("订单编号")
    private String orderNo;

    @ApiModelProperty("产品数量")
    private Integer productNum;

    @ApiModelProperty("订单总额")
    private Integer orderAmount;

    @ApiModelProperty("订单状态 100:待支付 200:已支付 300:配送中 400:已收货 500:已退款 ")
    private Integer orderState;

    @ApiModelProperty("订单标题")
    private String subject;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

}
