package com.terralcode.gestion.business.example;

import com.terralcode.gestion.domain.example.product.TestProduct;
import com.naoset.framework.business.commons.crud.CRUD;
import javax.ejb.Stateless;

/**
 *
 * @author Ezequiel
 */
@Stateless
public class ProductService extends CRUD<TestProduct> {
}
