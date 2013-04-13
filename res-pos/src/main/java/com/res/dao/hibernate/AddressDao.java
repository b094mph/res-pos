package com.res.dao.hibernate;

import com.res.model.Address;

public interface AddressDao extends BaseDao{

	public Address findByAddressId(long id);
}
