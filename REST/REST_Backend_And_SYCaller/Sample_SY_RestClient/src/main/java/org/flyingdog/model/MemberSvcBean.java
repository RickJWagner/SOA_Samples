package org.flyingdog.model;

import javax.inject.Inject;

import org.flyingdog.services.MemberResourceRESTService;
import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

@Service(MemberSvc.class)
public class MemberSvcBean implements MemberSvc {
	
    @Inject @Reference
    private MemberResourceRESTService restSvc;	

	@Override
	public Member fetchMember() {

		System.out.println("### Member fetch fires ###");
		
		Member member = restSvc.lookupMemberById(2);
		
		Member ret = new Member();
		ret.setName("John Doe");
		ret.setEmail("abc@123.com");
		ret.setId(new Long(8));
		ret.setPhoneNumber("1234567890");
		
		return member;
	}

}



