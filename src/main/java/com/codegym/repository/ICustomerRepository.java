package com.codegym.repository;

import com.codegym.model.Customer;
import com.codegym.model.Province;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository // đánh dấu @Repository tự động tiêm interface này vào Spring Container quản lý
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    // extends 1 interface nào đó của Spring Data JPA sẽ làm cho interface này
    // có đầy đủ các phương thức crud liên quan đến class Customer
    // mọi người cần chuyền vào class và kiểu dữ liệu của khoá chính của class này
    Iterable<Customer> findAllByProvince(Province province);
    // Spring Data JPA còn hỗ trợ thêm tự truy vấn đến cơ sở dữ liệu theo tên
    // như tên tương đương với câu truy vấn: select * from customer where province_id = ?

    @Query("select c from Customer c where c.firstName = :firstName") // viết theo HQL
    Iterable<Customer> sdhashdjashjdk(String firstName);

    @Query(value = "select * from customers order by firstName", nativeQuery = true) // viết theo csdl tương ứng
    Iterable<Customer> findAllOđấhjdashudrderByFN();

}