package railway;

public class Message {

    public Message(String dataFile, String jsNode) {
        this.dataFile = dataFile;
        this.jsNode = jsNode;
    }

    public String getJsNode() {
        return jsNode;
    }

    public String getDataFile() {
        return dataFile;
    }

    public void setJsNode(String jsNode) {
        this.jsNode = jsNode;
    }

    public void setDataFile(String dataFile) {
        this.dataFile = dataFile;
    }

    String jsNode;
    String dataFile;
}


