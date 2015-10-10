package com.sr.p2p.security;

import com.sr.p2p.model.Resource;
import com.sr.p2p.model.Role;
import com.sr.p2p.model.RoleResource;
import com.sr.p2p.service.TestService;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import java.util.*;

/**
 * Created by wangpengfei on 2015/10/9.
 */
public class P2PFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    TestService testService;

    public static  Map<Integer,Set<Resource>> roleResouceTemp = new HashMap<Integer,Set<Resource>>();
    private static List<RoleResource> roleResources = null;

    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;




    public P2PFilterInvocationSecurityMetadataSource (TestService testService){
        this.testService = testService;
        loadResourceDefine();
    }


    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }


    private void loadResourceDefine() {

        if(resourceMap == null) {

            resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
            roleResources = this.testService.findRoleResources();

            List<Resource> resources = this.testService.findAll();
            Map<Integer,Resource> resourceTemp = new HashMap<Integer,Resource>();
            for (Resource resource : resources) {
                Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
                ConfigAttribute configAttribute = new SecurityConfig(resource.getName());
                configAttributes.add(configAttribute);
                resourceTemp.put(resource.getId(),resource);
                resourceMap.put(resource.getUrl(), configAttributes);
            }

            for (RoleResource roleResource:roleResources){
                if(roleResouceTemp.get(roleResource.getRoleId()) !=null){
                    roleResouceTemp.get(roleResource.getRoleId()).add(resourceTemp.get(roleResource.getResourceId()));
                }else{
                    Set res  = new HashSet<Resource>();
                    res.add(resourceTemp.get(roleResource.getResourceId()));
                    roleResouceTemp.put(roleResource.getRoleId(),res);
                }
            }

        }
    }


    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        System.out.println("requestUrl is " + requestUrl);
        if(resourceMap == null) {
            loadResourceDefine();
        }
        return resourceMap.get(requestUrl);
    }


}
