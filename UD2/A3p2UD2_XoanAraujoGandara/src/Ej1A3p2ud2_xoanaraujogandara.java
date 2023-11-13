import util.TransformerManager;

public class Ej1A3p2ud2_xoanaraujogandara {
    private static final String XML = "Hardware.xml";
    private static final String XSLT = "Hardware.xsl";
    public static void main(String[] args) {
        TransformerManager.transformDocument(XML, XSLT, "Hardware2.xml");
    }
}
