package com.indigoGrafica.service.impl;

import com.indigoGrafica.models.ProductCategory;
import com.indigoGrafica.repository.ProductCategoryRepository;
import com.indigoGrafica.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryRepository.findAll();
    }

    /*public List<Schedule> getAllByUser(User user) {
CriteriaBuilder cb = entityManager.getCriteriaBuilder();
CriteriaQuery<Schedule> criteria = cb.createQuery(Schedule.class);
Root<Schedule> root = criteria.from(Schedule.class);
List<Predicate> predicates = new ArrayList<Predicate>();
predicates.add(cb.equal(root.get("user"), user));
criteria.where(predicates.toArray(new Predicate[predicates.size()])).distinct(true);

List<Schedule> schedules = entityManager.createQuery(criteria)
.getResultList();
logger.info("Schedules ::" + schedules);
return schedules;
}*/
}