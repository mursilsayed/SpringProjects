package com.mursilsayed.sessionobject;

import org.springframework.data.repository.CrudRepository;



interface ApplicationParametersRepository extends CrudRepository<ApplicationParameters, Long> {

	public ApplicationParameters findByParamKey(String key);
		 
}
