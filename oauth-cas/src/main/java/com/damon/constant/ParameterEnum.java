package com.damon.constant;

/**
 * @author  wangshoufa 
 * @date 2018年11月15日 下午1:15:36
 *
 */

public enum ParameterEnum {
	
	PARAMETER_NULL(-2,"参数为空");
	
	private Integer seq;

    private String desc;

    ParameterEnum(Integer seq, String desc) {
        this.seq = seq;
        this.desc = desc;
    }

	public int getSeq() {
		return seq;
	}

	public String getDesc() {
		return desc;
	}

}
