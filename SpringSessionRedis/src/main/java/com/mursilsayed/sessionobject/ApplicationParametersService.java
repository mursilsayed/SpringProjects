package com.mursilsayed.sessionobject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

@Service
@ManagedResource
public class ApplicationParametersService {


	private static final Logger logger = 
			LoggerFactory.getLogger(ApplicationParametersService.class);
	

	

		@Autowired
		protected ApplicationParametersRepository applicationParametersRepository;
		
		@Cacheable("params")
		@ManagedOperation
		public ApplicationParameters GetParameterValueInString(String Key)
		{
			logger.debug("GetParameterValueInString called with key: "+Key);
			return applicationParametersRepository.findByParamKey(Key);
			
		}
		
		@Cacheable("params")
		@ManagedOperation
		public String GetParameterValue(String Key)
		{
			logger.debug("GetParameterValue called with key: "+Key);
			ApplicationParameters params= applicationParametersRepository.findByParamKey(Key);
			return params.getParam_value();
			
		}
		
		
		
		
		public void SetParameterValue(ApplicationParameters param)
		{
			applicationParametersRepository.save(param);
			
		}
		/**
		 * This method is only for internal use from JMX console. 
		 * This will be used to flush all the Application Parameters
		 * values that are loaded in the Cache.
		 * 
		 */
		@CacheEvict(cacheNames="params", allEntries=true)
		@ManagedOperation
		public void evictAllApplicationParametersFromCache()
		{
			
		}
		
		
		@ManagedOperation
		public void SetParameterValueInString(String Key,String jsonValue)
		{
			ApplicationParameters params =new ApplicationParameters();
			params.setParam_key(Key);
			params.setParam_value(jsonValue);
			applicationParametersRepository.save(params);
			
			
			
		}
		
		
		
}