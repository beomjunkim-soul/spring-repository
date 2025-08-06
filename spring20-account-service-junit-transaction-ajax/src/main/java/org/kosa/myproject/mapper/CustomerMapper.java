package org.kosa.myproject.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.kosa.myproject.domain.Customer;
@Mapper
public interface CustomerMapper {

	int register(Customer customer);

	Customer findById(Long customerId);

	Integer getTotalCount();

}
