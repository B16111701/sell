package com.imooc.repository;

import static org.junit.jupiter.api.Assertions.*;
import com.imooc.dataobject.ProductCategory;
import org.hibernate.annotations.DynamicUpdate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@DynamicUpdate
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest() {
        Optional<ProductCategory> productCategory = repository.findById(1);
        System.out.println(productCategory.toString());
    }

    @Test
    @Transactional
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory("女生最爱",3);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list = Arrays.asList(2,3,4);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }
}