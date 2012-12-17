package combatlogparser.mutator.helpers;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import combatlogparser.Constants;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.*;

public class XmlInfoParser {
	private Document doc;
	private Node rootNode;

	public XmlInfoParser(String region) {
		try {
			DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			this.doc = db.parse(new FileInputStream(new File(Constants.BOSS_XML_BASE.replace("REGION", region))));
			this.rootNode = this.doc.getDocumentElement();
		}
		catch (FileNotFoundException fnfe) {
			this.rootNode = null;
			this.doc = null;
			throw new RuntimeException("Could not open BossList XML file");
		}
		catch (Exception e) {
			this.rootNode = null;
			this.doc = null;
			e.printStackTrace();
		}
	}

	public Node getChildNode(String name) {
		List<Node> nodes = getChildNodes(name);

		if (nodes.size() > 0)
			return nodes.get(0);

		return null;
	}

	public List<Node> getChildNodes(String name) {
		ArrayList<Node> returnNodes = new ArrayList<Node>();

		if (this.rootNode.hasChildNodes()) {
			NodeList nList = this.rootNode.getChildNodes();

			for (int i = 0; i < nList.getLength(); ++i) {
				Node n = nList.item(i);

				if (n.getNodeName().equalsIgnoreCase(name))
					returnNodes.add(n);
			}
		}

		return returnNodes;
	}
}