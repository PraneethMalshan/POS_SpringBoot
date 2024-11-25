package lk.kdpm.pos_backend.repo;

import lk.kdpm.pos_backend.dto.queryInterface.OrderDetailsInterface;
import lk.kdpm.pos_backend.dto.response.ResponseOrderDetailsDTO;
import lk.kdpm.pos_backend.entity.Order;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface OrderRepo extends JpaRepository<Order, Integer> {


//    Spring boot wala query ekak gahaddi native query ekak gahaddiee kiyanne api atyhin query ekak gahaddi eekiyanne meeke thiina speck eka use karanne nathuwa api athin gahaddi danawa @Query kiyana annotation eka. meka insert query ekak gahanakota unath daanna puluwan kisi prashnayak nah.
    @Query(value = "select c.customer_name as customerName , c.customer_address as customerAddress , c.contact_numbers as contactNumber , o.order_date as date , o.total as total from customer c, orders o where o.active_status = ?1 and c.customer_id = o.customer_id",nativeQuery = true)
    List<OrderDetailsInterface> getAllOrderDetails(boolean status, Pageable pageable);

    @Query(value = "select count(*) from customer c, orders o where o.active_status = ?1 and c.customer_id = o.customer_id",nativeQuery = true)
    long countAllOrderDetails(boolean status);
}


//Spring wala query ekak gahana piliwela
//    1.@Query annotation eka daa gannawa.
//    2.@Query(value = "",nativeQuery = true)
//    3.@Query(value = "select * from customer c, orders o",nativeQuery = true)
//    4.ResponseOrderDetailsDTO ekata gihin balanawa customer eke thiinne monawada kiyala. eeke mulin thinne customerName eka nisa database eke table ekata gihin balanawa customerName eka thiinne kohomada kiyala.. eeka thiinne mehema -->customer_name
          //@Query(value = "select c.customer_name from customer c, orders o",nativeQuery = true)
//    5.Address ekath thiina widhiha bananawa.
          //@Query(value = "select c.customer_name , c.customer_address from customer c, orders o",nativeQuery = true)
//    6.Contact number ekath thiina widhiha bananawa.
          //@Query(value = "select c.customer_name , c.customer_address , c.contact_numbers from customer c, orders o",nativeQuery = true)
//    7.Iita passe balanawa Order eken aragena thiinnemonawada kiyala. eken mulin aran thiinne OrderDate eka. eekath mehema da gannawa.
          //@Query(value = "select c.customer_name , c.customer_address , c.contact_numbers , o.order_date  from customer c, orders o",nativeQuery = true)
//    8.Total ekath thiina widhiha bananawa.
          //@Query(value = "select c.customer_name , c.customer_address , c.contact_numbers , o.order_date , o.total from customer c, orders o",nativeQuery = true)
//    9.Dn data tika gaththa eeka hari. dn kiyanna oona query ekata active state ekath kiyanna oona. order table eke active_status eka gannawa.
          //1.@Query(value = "select c.customer_name , c.customer_address , c.contact_numbers , o.order_date , o.total from customer c, orders o where o.active_status = ",nativeQuery = true)   //meka thamayi palaweni variable eka apata ewala thiina method ekee parameter eka.
          //2.    @Query(value = "select c.customer_name , c.customer_address , c.contact_numbers , o.order_date , o.total from customer c, orders o where o.active_status = ?1",nativeQuery = true)
//    10.dn order eke thinawa customer id ekak genella dala. ee customer id ekayi, customer ekee customer id ekayi samaana wennath oona.
          //@Query(value = "select c.customer_name , c.customer_address , c.contact_numbers , o.order_date , o.total from customer c, orders o where o.active_status = ?1 and c.customer_id = o.customer_id",nativeQuery = true)
//    11.Me query eken ehema data enne naha. mokada dto eka wenas kalane interface ekak widiyata. eka nisa "as" keyword eka daala entity ekee thibuna name eka denna oona.



