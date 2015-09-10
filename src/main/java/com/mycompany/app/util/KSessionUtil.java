package com.mycompany.app.util;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.Resource;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatelessKnowledgeSession;

public class KSessionUtil {


    public static StatelessKnowledgeSession getSession(String drlFile){
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        Resource resource = ResourceFactory.newClassPathResource(drlFile);
        kbuilder.add(resource, ResourceType.DRL);
        KnowledgeBase kbase = kbuilder.newKnowledgeBase();
        StatelessKnowledgeSession ksession = kbase.newStatelessKnowledgeSession();
        return ksession;
    }

    public static StatelessKnowledgeSession getSession(String dslFile, String dsrlFile){

        KnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        Resource dsl = ResourceFactory.newClassPathResource(dslFile);
        kbuilder.add( dsl, ResourceType.DSL );
        Resource dslr = ResourceFactory.newClassPathResource(dsrlFile);
        kbuilder.add( dslr, ResourceType.DSLR );
        if( kbuilder.hasErrors() ){
            // error exit
        }
        knowledgeBase.addKnowledgePackages( kbuilder.getKnowledgePackages() );
        return knowledgeBase.newStatelessKnowledgeSession();
    }
}
