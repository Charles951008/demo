package com.charles.demo.data1.pojo;

/**
 * @author Charles
 * @Description 针对原生jdbc返回的数据 由该对象封装 再add进入最后要返回的结果集
 */
public class OriginJdbcObject {
    private String CommunityName;
    private int OBJECTID;
    private String CommunityAddress;
    private String CommunityType;
    private String StreetName;

    public String getCommunityName() {
        return CommunityName;
    }

    public void setCommunityName(String communityName) {
        CommunityName = communityName;
    }

    public int getOBJECTID() {
        return OBJECTID;
    }

    public void setOBJECTID(int OBJECTID) {
        this.OBJECTID = OBJECTID;
    }

    public String getCommunityAddress() {
        return CommunityAddress;
    }

    public void setCommunityAddress(String communityAddress) {
        CommunityAddress = communityAddress;
    }

    public String getCommunityType() {
        return CommunityType;
    }

    public void setCommunityType(String communityType) {
        CommunityType = communityType;
    }

    public String getStreetName() {
        return StreetName;
    }

    public void setStreetName(String streetName) {
        StreetName = streetName;
    }
}
