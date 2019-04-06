package com.yin.xiao.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;


public class JaxbParser {
	
	
	@SuppressWarnings("rawtypes")
	private Class clazz;
	private String[] cdataNode;
	
	public JaxbParser(){
		
	}
	public JaxbParser(@SuppressWarnings("rawtypes") Class clazz){
		this.clazz = clazz;
	}

	/**
	 * 设置需要包含CDATA的节点
	 * @param cdataNode
	 */
	public void setCdataNode(String[] cdataNode) {
		this.cdataNode = cdataNode;
	}

	/**
	 * 转为xml串
	 * @param obj
	 * @return
	 */
	public String toXML(Object obj){
		String result = null;
		try {
			JAXBContext context = JAXBContext.newInstance(obj.getClass());
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.setProperty(Marshaller.JAXB_FRAGMENT, true);// 去掉报文头
			ByteArrayOutputStream  os = new ByteArrayOutputStream ();
			XMLSerializer serializer = getXMLSerializer(os);
			m.marshal(obj, serializer.asContentHandler());
			result = new String(os.toByteArray(),"UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("response text:" + result);
		return result;
	}
	

	/**
	 * 转为对象
	 * @param is
	 * @return
	 */
	public Object toObj(InputStream is){
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(clazz);
			Unmarshaller um = context.createUnmarshaller();
			Object obj = um.unmarshal(is);
			return obj;
		} catch (Exception e) {
			System.out.println("post data parse error");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * XML转为对象
	 * @param xmlStr
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public Object toObj(String xmlStr) throws UnsupportedEncodingException{
		InputStream is = StreamUtils.strToStream(xmlStr, "UTF-8");
		return toObj(is);
	}
	
	
	/**
	 * 设置属性
	 * @param os
	 * @return
	 */
	private XMLSerializer getXMLSerializer(OutputStream os) {
		OutputFormat of = new OutputFormat();
        of.setCDataElements(cdataNode);   
        of.setPreserveSpace(true);
        of.setIndenting(true);
        of.setOmitXMLDeclaration(true);
        XMLSerializer serializer = new XMLSerializer(of);
        serializer.setOutputByteStream(os);
        return serializer;
    }
	
}
