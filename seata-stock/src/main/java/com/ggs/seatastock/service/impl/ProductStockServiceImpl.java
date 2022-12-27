package com.ggs.seatastock.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.ggs.seatastock.entity.model.ProductStock;
import com.ggs.seatastock.mapper.ProductStockMapper;
import com.ggs.seatastock.service.ProductStockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品库存 服务实现类
 * </p>
 *
 * @author starbug
 * @since 2022-12-27
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ProductStockServiceImpl extends ServiceImpl<ProductStockMapper, ProductStock> implements ProductStockService {

    private final ProductStockMapper productStockMapper;

    @Override
    public boolean decrease(Integer productId, Integer number) {
        int effectRow = productStockMapper.decrease(productId, number);
        return effectRow > 0;
    }

}
