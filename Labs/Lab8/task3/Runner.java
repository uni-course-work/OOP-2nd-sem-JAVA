public class Runner {
    public static void main(String[] args) {
        Action act = new Action("KGF");
        Comedy com = new Comedy("Three Idiots");
        Drama drm = new Drama("Hum sath sath hain");
        System.out.println(act + " has late fees of: " + act.caclFees(3));
        System.out.println(com + " has late fees of: " + com.caclFees(4));
        System.out.println(drm + " has late fees of: " + drm.caclFees(5));
    }
}
