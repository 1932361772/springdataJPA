package cn.itmuch.filter;

import java.io.IOException;

import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import cn.itmuch.repository.Use2xtendscrud;

public class IncludeTypeFilter implements TypeFilter{

	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
			throws IOException {//Use2xtendscrud
		//里面可以写任意的逻辑控制.@EnableJpaRepositories里面的@Filter(type=FilterType.CUSTOM,value=IncludeTypeFilter.class)
		if (metadataReader.getAnnotationMetadata().getClassName().equals(Use2xtendscrud.class.getName())) {
		return true;	
		}
		return false;
	}

}
