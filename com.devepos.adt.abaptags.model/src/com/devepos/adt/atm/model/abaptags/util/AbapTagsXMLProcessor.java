/**
 */
package com.devepos.adt.atm.model.abaptags.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import com.devepos.adt.atm.model.abaptags.IAbapTagsPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class AbapTagsXMLProcessor extends XMLProcessor {

    /**
     * Public constructor to instantiate the helper. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public AbapTagsXMLProcessor() {
        super(EPackage.Registry.INSTANCE);
        IAbapTagsPackage.eINSTANCE.eClass();
    }

    /**
     * Register for "*" and "xml" file extensions the AbapTagsResourceFactory
     * factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected Map<String, Resource.Factory> getRegistrations() {
        if (registrations == null) {
            super.getRegistrations();
            registrations.put(XML_EXTENSION, new AbapTagsResourceFactory());
            registrations.put(STAR_EXTENSION, new AbapTagsResourceFactory());
        }
        return registrations;
    }

} // AbapTagsXMLProcessor
