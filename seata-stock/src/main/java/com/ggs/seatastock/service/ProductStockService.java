package com.ggs.seatastock.service;

import com.ggs.seatastock.entity.model.ProductStock;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 产品库存 服务类
 * </p>
 *
 * @author starbug
 * @since 2022-12-27
 */
public interface ProductStockService extends IService<ProductStock> {

    boolean decrease(Integer productId, Integer number);

}
