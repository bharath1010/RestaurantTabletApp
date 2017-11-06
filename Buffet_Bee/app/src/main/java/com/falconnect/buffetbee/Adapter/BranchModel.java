package com.falconnect.buffetbee.Adapter;

public class BranchModel {

	private String branch_name;
	private String branch_code;

	public BranchModel(String branch_code, String branch_name) {
		this.branch_name = branch_name;
		this.branch_code = branch_code;
	}
	public BranchModel() {
	}

	public String getbranch_name() {
		return branch_name;
	}

	public String getbranch_code() {
		return branch_code;
	}

}
