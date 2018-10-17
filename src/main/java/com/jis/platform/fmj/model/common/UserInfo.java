package com.jis.platform.fmj.model.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfo implements Serializable {
    public String id;
    public String username;
    public String password;
    public String name;
    private String description;
    private String avatar;
}
