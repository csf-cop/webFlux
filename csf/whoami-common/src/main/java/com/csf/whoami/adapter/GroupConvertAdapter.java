/**
 * 
 */
package com.csf.whoami.adapter;

import com.csf.whoami.domain.GroupDomain;
import com.csf.whoami.entity.GroupEntity;

/**
 * @author mba0051
 *
 */
public interface GroupConvertAdapter {
	GroupDomain groupEntityToGroupDtoConvert(GroupEntity group);
}
