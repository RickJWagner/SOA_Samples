package org.flyingdog.model;

import org.flyingdog.services.MemberResource;
import org.switchyard.component.bean.Service;

@Service(MemberResource.class)
public class MemberResourceBean implements MemberResource {

	@Override
	public Member fetchMember() {
		// TODO Auto-generated method stub
		return null;
	}

}
