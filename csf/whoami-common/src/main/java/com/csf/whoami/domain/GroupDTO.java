/**
 * 
 */
package com.csf.whoami.domain;

/**
 * @author mba0051
 *
 */
public class GroupDTO {

	private String groupId;
	private String groupName;

	/**
	 * @return the groupId
	 */
	public String getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @param groupName the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	/**
	 * 
	 */
	public GroupDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param groupId
	 * @param groupName
	 */
	public GroupDTO(String groupId, String groupName) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
	}
}
