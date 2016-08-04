package com.lyashuk.service.api;

import com.lyashuk.dto.ProductGroupDto;



public interface ProductGroupService {
    ProductGroupDto getProductGroupById(long id);
    boolean deleteProductGroup(long id);

}
