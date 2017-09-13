package az.mm.algoritms.arbitrage.currency;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author MM
 */
public class AznTodayCurrency {

    public static void main(String[] args) throws IOException {

        Document doc = Jsoup.connect("http://azn.today/").get();
        Elements thead = doc.select("#basic-mezenne > thead th");
        Elements tbody = doc.select("#basic-mezenne > tbody tr");

        System.out.println(thead);
        System.out.println();
        System.out.println(tbody);

        List<Bank> bankList = new ArrayList<>();
        Bank bank;
        for (Element e : tbody) {
            e.select("small").remove();
            String name = e.select("td:nth-child(1) > h4").text();
//            String bUSD = e.select("td:nth-child(2)").text();
//            String sUSD = e.select("td:nth-child(3)").text();
//            String bEUR = e.select("td:nth-child(4)").text();
//            String sEUR = e.select("td:nth-child(5)").text();
//            String bRUB = e.select("td:nth-child(6)").text();
//            String sRUB = e.select("td:nth-child(7)").text();
//            String bTRY = e.select("td:nth-child(8)").text();
//            String sTRY = e.select("td:nth-child(9)").text();
//            String bGBP = e.select("td:nth-child(10)").text();
//            String sGBP = e.select("td:nth-child(11)").text();

            double curRate[] = new double[10];
            for (int i = 0; i < curRate.length; i++) {
                try {
                    curRate[i] = Double.parseDouble(e.select("td:nth-child(" + (i + 2) + ")").text());
                } catch (NumberFormatException ex) {
                    curRate[i] = 0;
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }

            bank = new Bank(name, curRate[0], curRate[1], curRate[2], curRate[3], curRate[4], curRate[5], curRate[6], curRate[7], curRate[8], curRate[9]);
            bankList.add(bank);
        }
        
        System.out.println(bankList);
    }

}
