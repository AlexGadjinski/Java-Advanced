package word;

public class CutTransform implements TextTransform {
    private String cutPart;
    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
        String cutPart = text.substring(startIndex, endIndex);
        setCutPart(cutPart);
        text.delete(startIndex, endIndex);
    }

    public void setCutPart(String cutPart) {
        this.cutPart = cutPart;
    }

    public String getCutPart() {
        return cutPart;
    }
}
