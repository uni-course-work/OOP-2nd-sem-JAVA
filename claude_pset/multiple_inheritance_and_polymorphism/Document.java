public class Document implements Printable, Saveable, Exportable {
    @Override
    public void print () {
        System.out.println("I'm a document");
    }

    @Override
    public void save (String filename) {
        System.out.println("Saving document as " + filename);
    }

    @Override
    public void export (String format) {
        System.out.println("Exporting document as " + format);
    }
}