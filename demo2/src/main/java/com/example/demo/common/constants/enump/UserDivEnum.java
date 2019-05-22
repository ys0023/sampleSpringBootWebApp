package com.example.demo.common.constants.enump;

/**
 * ユーザ区分Enum.
 */
public enum UserDivEnum {
	
    MASTER_USER("1", "管理ユーザ"),
    NOMAL_USER("2", "通常ユーザ"),
    ;

    private final String code;
    private final String note;

    private UserDivEnum(final String code, final String id) {
       this.code = code;
       this.note = id;
    }

    public String getCode() {
        return this.code;
    }

    public String getNote() {
        return this.note;
    }

}
