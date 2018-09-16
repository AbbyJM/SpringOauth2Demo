package com.abby.client;


import com.abby.mapper.OauthClientDetails;
import com.abby.mapper.OauthClientDetailsExample;
import com.abby.mapper.OauthClientDetailsMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class ClientDetailsServiceImp implements ClientDetailsService {

    @Resource
    private OauthClientDetailsMapper oauthClientDetailsMapper;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        OauthClientDetailsExample example=new OauthClientDetailsExample();
        example.createCriteria().andClientIdEqualTo(clientId);
        List<OauthClientDetails> clients=oauthClientDetailsMapper.selectByExample(example);
        OauthClientDetails client=null;
        if(clients!=null&&!clients.isEmpty()){
            client=clients.get(0);
        }

        String[] resourceIds=client.getResourceIds().split(",");
        String[] authorities=client.getAuthorities().split(",");
        String[] grantTypes=client.getAuthorizedGrantTypes().split(",");
        String[] redirectUrls=client.getWebServerRedirectUri().split(",");
        String[] scopes=client.getScope().split(",");

        Set<String> resource_id = new HashSet<>(Arrays.asList(resourceIds));
        Set<String> grant_type=new HashSet<>(Arrays.asList(grantTypes));
        Set<String> redirect_urls=new HashSet<>(Arrays.asList(redirectUrls));
        Set<String> scope=new HashSet<>(Arrays.asList(scopes));
        List<GrantedAuthority> authorityList=new ArrayList<>();
        for(int i=0;i<authorities.length;i++){
            GrantedAuthority authority=new SimpleGrantedAuthority(authorities[i]);
            authorityList.add(authority);
        }

        ClientDetailsImp clientDetails= new ClientDetailsImp(clientId,client.getClientSecret(),authorityList,grant_type,scope);
        clientDetails.setResourceIds(resource_id);
        clientDetails.setRedirectUrls(redirect_urls);
        return clientDetails;
    }
}
