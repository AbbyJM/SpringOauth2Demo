package com.abby.client;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ClientDetailsImp implements ClientDetails {

    private String client_id=null;
    private String client_secret=null;
    private Set<String> resource_ids=null;
    private Collection<GrantedAuthority> authorities=null;
    private Set<String> grant_types=null;
    private Set<String> redirect_urls=null;
    private Integer accessTokenValidateSeconds=null;
    private Integer refreshTokenValidateSeconds=null;
    private boolean isSecretRequired=false;
    private boolean isAutoAprove=false;
    private boolean isScoped=false;
    private Set<String> scope=null;
    private Map<String, Object> additionalInfomation=null;

    public ClientDetailsImp(String client_id,String client_secret,Collection<GrantedAuthority> authorities,Set<String> grant_types,Set<String> scope){
        this.client_id=client_id;
        this.client_secret=client_secret;
        this.authorities=authorities;
        this.grant_types=grant_types;
        isScoped=true;
        this.scope=scope;
    }

    @Override
    public String getClientId() {
        return client_id;
    }

    public void setClientId(String id){
        client_id=id;
    }

    @Override
    public Set<String> getResourceIds() {
        return resource_ids;
    }

    public void setResourceIds(Set<String> ids){
        resource_ids=ids;
    }

    @Override
    public boolean isSecretRequired() {
        return isSecretRequired;
    }

    public void setIdSecretRequired(boolean required){
        isSecretRequired=required;
    }

    @Override
    public String getClientSecret() {
        return client_secret;
    }

    public void setClientScret(String client_secret){
        this.client_secret=client_secret;
    }

    @Override
    public boolean isScoped() {
        return isScoped;
    }

    public void setIsScoped(boolean isScoped){
        this.isScoped=isScoped;
    }

    @Override
    public Set<String> getScope() {
        return scope;
    }

    public void setScope(Set<String> scope){
        this.scope=scope;
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return grant_types;
    }

    public void setGrantTypes(Set<String> grant_types){
        this.grant_types=grant_types;
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return redirect_urls;
    }

    public void setRedirectUrls(Set<String> urls){
        this.redirect_urls=urls;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<GrantedAuthority> authorities){
        this.authorities=authorities;
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return accessTokenValidateSeconds;
    }

    public void setAccessTokenValidateSeconds(Integer seconds){
        this.accessTokenValidateSeconds=seconds;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return refreshTokenValidateSeconds;
    }

    public void setRefreshTokenValidateSeconds(Integer seconds){
        this.refreshTokenValidateSeconds=seconds;
    }

    @Override
    public boolean isAutoApprove(String scope) {
        return isAutoAprove;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return additionalInfomation;
    }

    public void setAdditionalInfomation(Map<String,Object> infomation){
        this.additionalInfomation=infomation;
    }
}
