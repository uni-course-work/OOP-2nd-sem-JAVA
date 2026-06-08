public class Photo implements Printable, Exportable {
    @Override
    public void print () {
        System.out.println("Printing Image");
    }

    @Override
    public void export (String format) {
        System.out.println("Exporting image as " + format);
    }
}