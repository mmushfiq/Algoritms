package az.mm.algoritms.arbitrage.currency;

/**
 *
 * @author MM
 */
public class TestArbitrage {

    public static void main(String[] args) {
//        ExcelPOI exc = new ExcelPOI();
//        OptimalRate opt = exc.getOptimalRates("AZN", "USD");
//        System.out.println("AZN-USD --> " + opt);
//        opt = exc.getOptimalRates("USD", "AZN");
//        System.out.println("USD-AZN --> " + opt);
//        opt = exc.getOptimalRates("USD", "EUR");
//        System.out.println("USD-EUR --> " + opt);
//
//        opt = exc.getOptimalRates("EUR", "USD");
//        System.out.println("EUR-USD --> " + opt);
        
        test();

    }

    public static void test() {
        String[] cur = {"AZN", "USD", "EUR", "GBP", "RUB", "TRY",};
        ExcelPOI exc = new ExcelPOI();
        OptimalRate opt;

        for (int i = 0; i < cur.length; i++) {
            System.out.print(cur[i] + "\t");
            for (int j = 0; j < cur.length; j++) {
                if(i == j) {
                    System.out.print(1 + "\t");
                    continue;
                }
                opt = exc.getOptimalRates(cur[i], cur[j]);
                System.out.print(opt.getValue() + "\t");
            }
            System.out.println("");
        }

    }
}
