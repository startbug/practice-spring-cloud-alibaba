package com.ggs.seatastock.mapper;

import com.ggs.seatastock.entity.model.ProductStock;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 产品库存 Mapper 接口
 * </p>
 *
 * @author starbug
 * @since 2022-12-27
 */
public interface ProductStockMapper extends BaseMapper<ProductStock> {

    int decrease(@Param("productId") Integer productId, @Param("number") Integer number);

}
