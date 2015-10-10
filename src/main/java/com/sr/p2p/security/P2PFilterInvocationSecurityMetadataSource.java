package com.sr.p2p.security;

import com.sr.p2p.model.Resource;
import com.sr.p2p.model.RoleResource;
import com.sr.p2p.service.RoleResourcesService;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import java.util.*;

/**
 * Created by wangpengfei on 2015/10/9.
 */
public class P2PFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    private RoleResourcesService roleResourcesService;

    //角色-资源数据
    public static  Map<Integer,Set<Resource>> roleResouces = null;

    //资源数据
    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;


    public P2PFilterInvocationSecurityMetadataSource (RoleResourcesService roleResourcesService){
        this.roleResourcesService = roleResourcesService;
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

    //系统启动时默认加载全部资源和 资源和角色的对应关系
    private void loadResourceDefine() {

        if(resourceMap == null) {

            resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
            roleResouces = new HashMap<Integer,Set<Resource>>();

            //全部资源
            List<Resource> resources = this.roleResourcesService.findAll();
            //key = 角色id ,value = 角色详情
            Map<Integer,Resource> temp = new HashMap<Integer,Resource>();

            for (Resource resource : resources) {
                Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
                ConfigAttribute configAttribute = new SecurityConfig(resource.getName());
                configAttributes.add(configAttribute);
                temp.put(resource.getId(),resource);
                resourceMap.put(resource.getUrl(), configAttributes);
            }
            //全部角色对应资源
            List<RoleResource> roleResources = this.roleResourcesService.findRoleResources();

            for (RoleResource roleResource:roleResources){
                if(roleResouces.get(roleResource.getRoleId()) !=null){
                    roleResouces.get(roleResource.getRoleId()).add(temp.get(roleResource.getResourceId()));
                }else{
                    Set res  = new HashSet<Resource>();
                    res.add(temp.get(roleResource.getResourceId()));
                    roleResouces.put(roleResource.getRoleId(),res);
                }
            }

        }
    }


    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        if(resourceMap == null) {
            loadResourceDefine();
        }
        return resourceMap.get(requestUrl);
    }


}
