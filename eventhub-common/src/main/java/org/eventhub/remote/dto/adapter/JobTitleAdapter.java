package org.eventhub.remote.dto.adapter;

import java.util.Arrays;
import java.util.List;

import org.eventhub.common.model.entity.JobTitle;
import org.eventhub.remote.dto.JobTitleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobTitleAdapter extends GenericAdapter<JobTitle, JobTitleDTO> {
	
	@Autowired
	SystemUserAdapter systemUserAdapter;
	@Autowired
	VipAdapter vipAdapter;
	
	@Override
	protected List<GenericAdapter> getAdapters() {
		return Arrays.asList(systemUserAdapter, vipAdapter);
	}
	
	public JobTitleDTO toJobTitleDTO(JobTitle jobTitle) {
		return toDTO(jobTitle);
	}
	
	public JobTitle fromJobTitleDTO(JobTitleDTO jobTitleDTO) {
		return fromDTO(jobTitleDTO);
	}

}
