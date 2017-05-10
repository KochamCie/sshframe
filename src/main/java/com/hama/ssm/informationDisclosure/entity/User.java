package com.hama.ssm.informationDisclosure.entity;/**
 * Created by Administrator on 2017/4/17.
 */

import java.util.Date;

/**
 * tb_user
 *
 * @author Administrator
 * @create 2017-04-17 16:56
 */
public class User {

    private String id;
    private String channel;
    private String clientcode;
    private String email;
    private String employeeid;
    private Integer enabled;
    private Integer enterprise;
    private String groupid;
    private String idnumber;
    private Date lastlogindate;
    private String lastmodifiedby;
    private String loginname;
    private String mobile;
    private String name;
    private Integer needchangepassword;
    private String passphrase;
    private Integer referralrewarded;
    private Date registerdate;
    private Integer registryrewarded;
    private String salt;
    private String source;
    private String referral_id;
    private String referral_realm;
    private String referralurl;
    private String registerurl;
    private Integer checkidnumbercount;
    private Integer checkidnumberlimit;
    private Integer coreenterprise;
    private String openid;//微信openid
    private String scene_id;//二维码场景值id
    private Integer subscribe;//是否关注微信公众号 0未关注 1关注 2已取消
    private Integer deposit;
    private String mercustid;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getClientcode() {
        return clientcode;
    }

    public void setClientcode(String clientcode) {
        this.clientcode = clientcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Integer getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Integer enterprise) {
        this.enterprise = enterprise;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public Date getLastlogindate() {
        return lastlogindate;
    }

    public void setLastlogindate(Date lastlogindate) {
        this.lastlogindate = lastlogindate;
    }

    public String getLastmodifiedby() {
        return lastmodifiedby;
    }

    public void setLastmodifiedby(String lastmodifiedby) {
        this.lastmodifiedby = lastmodifiedby;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNeedchangepassword() {
        return needchangepassword;
    }

    public void setNeedchangepassword(Integer needchangepassword) {
        this.needchangepassword = needchangepassword;
    }

    public String getPassphrase() {
        return passphrase;
    }

    public void setPassphrase(String passphrase) {
        this.passphrase = passphrase;
    }

    public Integer getReferralrewarded() {
        return referralrewarded;
    }

    public void setReferralrewarded(Integer referralrewarded) {
        this.referralrewarded = referralrewarded;
    }

    public Date getRegisterdate() {
        return registerdate;
    }

    public void setRegisterdate(Date registerdate) {
        this.registerdate = registerdate;
    }

    public Integer getRegistryrewarded() {
        return registryrewarded;
    }

    public void setRegistryrewarded(Integer registryrewarded) {
        this.registryrewarded = registryrewarded;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getReferral_id() {
        return referral_id;
    }

    public void setReferral_id(String referral_id) {
        this.referral_id = referral_id;
    }

    public String getReferral_realm() {
        return referral_realm;
    }

    public void setReferral_realm(String referral_realm) {
        this.referral_realm = referral_realm;
    }

    public String getReferralurl() {
        return referralurl;
    }

    public void setReferralurl(String referralurl) {
        this.referralurl = referralurl;
    }

    public String getRegisterurl() {
        return registerurl;
    }

    public void setRegisterurl(String registerurl) {
        this.registerurl = registerurl;
    }

    public Integer getCheckidnumbercount() {
        return checkidnumbercount;
    }

    public void setCheckidnumbercount(Integer checkidnumbercount) {
        this.checkidnumbercount = checkidnumbercount;
    }

    public Integer getCheckidnumberlimit() {
        return checkidnumberlimit;
    }

    public void setCheckidnumberlimit(Integer checkidnumberlimit) {
        this.checkidnumberlimit = checkidnumberlimit;
    }

    public Integer getCoreenterprise() {
        return coreenterprise;
    }

    public void setCoreenterprise(Integer coreenterprise) {
        this.coreenterprise = coreenterprise;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getScene_id() {
        return scene_id;
    }

    public void setScene_id(String scene_id) {
        this.scene_id = scene_id;
    }

    public Integer getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(Integer subscribe) {
        this.subscribe = subscribe;
    }

    public Integer getDeposit() {
        return deposit;
    }

    public void setDeposit(Integer deposit) {
        this.deposit = deposit;
    }

    public String getMercustid() {
        return mercustid;
    }

    public void setMercustid(String mercustid) {
        this.mercustid = mercustid;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", channel='" + channel + '\'' +
                ", clientcode='" + clientcode + '\'' +
                ", email='" + email + '\'' +
                ", employeeid='" + employeeid + '\'' +
                ", enabled=" + enabled +
                ", enterprise=" + enterprise +
                ", groupid='" + groupid + '\'' +
                ", idnumber='" + idnumber + '\'' +
                ", lastlogindate=" + lastlogindate +
                ", lastmodifiedby='" + lastmodifiedby + '\'' +
                ", loginname='" + loginname + '\'' +
                ", mobile='" + mobile + '\'' +
                ", name='" + name + '\'' +
                ", needchangepassword=" + needchangepassword +
                ", passphrase='" + passphrase + '\'' +
                ", referralrewarded=" + referralrewarded +
                ", registerdate=" + registerdate +
                ", registryrewarded=" + registryrewarded +
                ", salt='" + salt + '\'' +
                ", source='" + source + '\'' +
                ", referral_id='" + referral_id + '\'' +
                ", referral_realm='" + referral_realm + '\'' +
                ", referralurl='" + referralurl + '\'' +
                ", registerurl='" + registerurl + '\'' +
                ", checkidnumbercount=" + checkidnumbercount +
                ", checkidnumberlimit=" + checkidnumberlimit +
                ", coreenterprise=" + coreenterprise +
                ", openid='" + openid + '\'' +
                ", scene_id='" + scene_id + '\'' +
                ", subscribe=" + subscribe +
                ", deposit=" + deposit +
                ", mercustid='" + mercustid + '\'' +
                '}';
    }
}
