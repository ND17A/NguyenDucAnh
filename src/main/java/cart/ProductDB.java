package cart;

public class ProductDB {
    public static Product getProduct(String code) {
        Product p = new Product();
        p.setCode(code);

        switch (code) {
            case "86":
                p.setDescription("86 (the band) - True Life Songs and Pictures");
                p.setPrice(14.95);
                break;
            case "pf01":
                p.setDescription("Paddlefoot - The first CD");
                p.setPrice(12.95);
                break;
            case "pf02":
                p.setDescription("Paddlefoot - The second CD");
                p.setPrice(14.95);
                break;
            case "jr01":
                p.setDescription("Joe Rut - Genuine Wood Grained Finish");
                p.setPrice(14.95);
                break;
            default:
                p.setDescription("Unknown Product");
                p.setPrice(0.0);
        }
        return p;
    }
}