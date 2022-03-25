package com.edu.nju.clockcourier.util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PomUtil {

    private static final String pattern = "\\$\\{(.+?)}";

    public static boolean containsVariable(String target) {
        if (target == null) return false;
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(target);
        return m.find();
    }

    public static String parse(String target, HashMap<String, String> propMap) {
        if (target == null) return null;
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(target);
        StringBuilder buffer = new StringBuilder();
        while (m.find()) {
            String key = m.group(1);
            String value = propMap.get(key);
            m.appendReplacement(buffer, (value == null) ? "" : value);
        }
        m.appendTail(buffer);
        String res = buffer.toString();
        if (res.isBlank()) return null;
        return res;
    }

    public static String getNodeValidValue(Node node) {
        if (node == null) return null;
        if (node.getFirstChild() == null) return null;
        return node.getFirstChild().getNodeValue();
    }

    public static HashMap<String, String> readNodes(NodeList list) {
        HashMap<String, String> map = new HashMap<>();
        int len = list.getLength();
        for (int i = 0; i < len; ++i) {
            Node curNode = list.item(i);
            if (curNode.getNodeType() != Node.ELEMENT_NODE) continue;
            String key = curNode.getNodeName();
            String value = getNodeValidValue(curNode);
            map.put(key, value);
        }
        return map;
    }

    public static Node getNodeFromRoot(Document doc, String nodeName) {
        // 根节点元素
        Element e = doc.getDocumentElement();
        NodeList directChildren = e.getChildNodes();
        for (int i = 0; i < directChildren.getLength(); ++i) {
            Node cur = directChildren.item(i);
            if (cur.getNodeType() != Node.ELEMENT_NODE) continue;
            if (cur.getNodeName().equals(nodeName)) return cur;
        }
        return null;
    }

}
