
/**
 * ServicioAlmacenLocalMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.3  Built on : Jun 27, 2015 (11:17:49 BST)
 */
        package org.example.www.servicioalmacenlocal;

        /**
        *  ServicioAlmacenLocalMessageReceiverInOut message receiver
        */

        public class ServicioAlmacenLocalMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver{


        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(msgContext);

        ServicioAlmacenLocalSkeleton skel = (ServicioAlmacenLocalSkeleton)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)){


        

            if("actualizarStock".equals(methodName)){
                
                org.example.www.servicioalmacenlocal.ActualizarStockResponse actualizarStockResponse9 = null;
	                        org.example.www.servicioalmacenlocal.ActualizarStock wrappedParam =
                                                             (org.example.www.servicioalmacenlocal.ActualizarStock)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    org.example.www.servicioalmacenlocal.ActualizarStock.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               actualizarStockResponse9 =
                                                   
                                                   
                                                         skel.actualizarStock(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), actualizarStockResponse9, false, new javax.xml.namespace.QName("http://www.example.org/servicioAlmacenLocal/",
                                                    "actualizarStock"));
                                    } else 

            if("comprobarStock".equals(methodName)){
                
                org.example.www.servicioalmacenlocal.ComprobarStockResponse comprobarStockResponse11 = null;
	                        org.example.www.servicioalmacenlocal.ComprobarStock wrappedParam =
                                                             (org.example.www.servicioalmacenlocal.ComprobarStock)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    org.example.www.servicioalmacenlocal.ComprobarStock.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               comprobarStockResponse11 =
                                                   
                                                   
                                                         skel.comprobarStock(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), comprobarStockResponse11, false, new javax.xml.namespace.QName("http://www.example.org/servicioAlmacenLocal/",
                                                    "comprobarStock"));
                                    
            } else {
              throw new java.lang.RuntimeException("method not found");
            }
        

        newMsgContext.setEnvelope(envelope);
        }
        }
        catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
        }
        
        //
            private  org.apache.axiom.om.OMElement  toOM(org.example.www.servicioalmacenlocal.ActualizarStock param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.example.www.servicioalmacenlocal.ActualizarStock.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(org.example.www.servicioalmacenlocal.ActualizarStockResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.example.www.servicioalmacenlocal.ActualizarStockResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(org.example.www.servicioalmacenlocal.ComprobarStock param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.example.www.servicioalmacenlocal.ComprobarStock.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(org.example.www.servicioalmacenlocal.ComprobarStockResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.example.www.servicioalmacenlocal.ComprobarStockResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, org.example.www.servicioalmacenlocal.ActualizarStockResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(org.example.www.servicioalmacenlocal.ActualizarStockResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private org.example.www.servicioalmacenlocal.ActualizarStockResponse wrapActualizarStock(){
                                org.example.www.servicioalmacenlocal.ActualizarStockResponse wrappedElement = new org.example.www.servicioalmacenlocal.ActualizarStockResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, org.example.www.servicioalmacenlocal.ComprobarStockResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(org.example.www.servicioalmacenlocal.ComprobarStockResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private org.example.www.servicioalmacenlocal.ComprobarStockResponse wrapComprobarStock(){
                                org.example.www.servicioalmacenlocal.ComprobarStockResponse wrappedElement = new org.example.www.servicioalmacenlocal.ComprobarStockResponse();
                                return wrappedElement;
                         }
                    


        /**
        *  get the default envelope
        */
        private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory){
        return factory.getDefaultEnvelope();
        }


        private  java.lang.Object fromOM(
        org.apache.axiom.om.OMElement param,
        java.lang.Class type,
        java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault{

        try {
        
                if (org.example.www.servicioalmacenlocal.ActualizarStock.class.equals(type)){
                
                        return org.example.www.servicioalmacenlocal.ActualizarStock.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
            
                if (org.example.www.servicioalmacenlocal.ActualizarStockResponse.class.equals(type)){
                
                        return org.example.www.servicioalmacenlocal.ActualizarStockResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
            
                if (org.example.www.servicioalmacenlocal.ComprobarStock.class.equals(type)){
                
                        return org.example.www.servicioalmacenlocal.ComprobarStock.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
            
                if (org.example.www.servicioalmacenlocal.ComprobarStockResponse.class.equals(type)){
                
                        return org.example.www.servicioalmacenlocal.ComprobarStockResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
            
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    

        /**
        *  A utility method that copies the namepaces from the SOAPEnvelope
        */
        private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env){
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
        org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
        returnMap.put(ns.getPrefix(),ns.getNamespaceURI());
        }
        return returnMap;
        }

        private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();
        if (cause != null) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        } else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }

        }//end of class
    