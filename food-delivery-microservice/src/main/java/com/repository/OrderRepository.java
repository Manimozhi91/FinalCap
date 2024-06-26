package com.repository;
import com.entity.Orders;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Integer>{
	@Query(value = "SELECT o.*, f.*"
			  + " from Orders o, Food f"
			  + " where o.fid=?1 "
			  , nativeQuery = true)
			List<Object> findByOrder(int oid);
	
	@Query(value = "SELECT o.*, f.*"
			  + " from Orders o, Food f"
			  + " where o.fid=f.fid and o.fid=:oid "
			  , nativeQuery = true)
	List<java.util.Map<String, Object>> findMyOrders(int oid);
	
	@Query(value = "SELECT o.*, f.*"
			  + " from Orders o, Food f"
			  + " where o.fid=f.fid and o.contactno=:contactno "
			  , nativeQuery = true)
	List<java.util.Map<String, Object>> findCustomerOrder(Long contactno);
	
	@Query(value = "DELETE from Orders o where o.contactno=:contactno "
			  , nativeQuery = true)

	Optional<Orders> cancelCustomerOrder(@Param("contactno") Long contactno);
	void deleteByContactno(Long contactno);
	@Modifying
	@Query("UPDATE Orders o SET o.status = :status WHERE o.oid = :oid")
	  Integer setNewStatusForOrder(@Param("status") String status, @Param("oid") int oid);   

}
