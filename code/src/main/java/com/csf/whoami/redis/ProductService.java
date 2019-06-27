/**
 * 
 */
package com.csf.whoami.redis;

import java.util.List;

/**
 * @author TuanDQ
 *
 */
public interface ProductService {

    List<Product> listAll();

    Product getById(String id);

    Product saveOrUpdate(Product product);

    void delete(String id);

    Product saveOrUpdateProductForm(ProductForm productForm);
}