package com.lyashuk.service.impl;

/*import com.lyashuk.dao.api.ProductGroupDao;
import com.lyashuk.dao.impl.ProductGroupDaoImpl;
import com.lyashuk.service.impl.ProductGroupServiceImpl;
import com.lyashuk.service.api.ProductGroupService;
import com.lyashuk.service.impl.ProductGroupServiceImpl;
import com.lyashuk.service.api.UserService;*/

import com.lyashuk.dao.api.ProductGroupDao;
import com.lyashuk.dao.impl.ProductGroupDaoImpl;
import com.lyashuk.dto.ProductGroupDto;
import com.lyashuk.service.api.ProductGroupService;

/**
 * Created by User on 14.07.2016.
 */
public class ProductGroupServiceImpl implements ProductGroupService {

    private static ProductGroupService productGroupService;
    private ProductGroupDao productGroupDao;

    private ProductGroupServiceImpl() {
        productGroupDao = ProductGroupDaoImpl.getInstance();
    }

    public static ProductGroupService getInstance() {
        if (productGroupService == null) {
            synchronized (ProductGroupServiceImpl.class) {
                if (productGroupService == null) {
                    productGroupService = new ProductGroupServiceImpl();
                }
            }
        }
        return productGroupService;
    }

    @Override
    public ProductGroupDto getProductGroupById(long id) {
        return null;
    }

    @Override
    public boolean deleteProductGroup(long id) {
        return false;
    }
}