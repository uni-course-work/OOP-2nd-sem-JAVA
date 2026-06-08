public class Main {
    public static void main(String[] args) {
        Document doc = new Document();
        Photo photo = new Photo();

        Printable [] items = {doc, photo};
        processAll(items);
    }

    public static void processAll (Printable [] items) {
        for(Printable itm : items) {
            itm.print();
        }
    }
}
