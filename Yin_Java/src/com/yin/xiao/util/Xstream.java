package com.yin.xiao.util;

import java.io.Writer;

import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class Xstream {


	public static com.thoughtworks.xstream.XStream xstream = new com.thoughtworks.xstream.XStream(
			new XppDriver() {

				public HierarchicalStreamWriter createWriter(Writer out) {
					return new PrettyPrintWriter(out) {

						boolean cdata = true;

						public void startNode(String name, Class clazz) {
							super.startNode(name, clazz);
						}

						protected void writeText(QuickWriter writer, String text) {
							if (cdata) {
								writer.write("<![CDATA[");
								writer.write(text);
								writer.write("]]>");
							} else {
								writer.write(text);
							}
						}
					};
				}
			});


}
