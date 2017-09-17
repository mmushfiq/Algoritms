package az.mm.algoritms.arbitrage;

import az.mm.algoritms.arbitrage.currency.AznTodayCurrency;
import az.mm.algoritms.arbitrage.currency.Bank;
import az.mm.algoritms.arbitrage.currency.CurrencyRate;
import az.mm.algoritms.arbitrage.currency.ExcelPOI;
import az.mm.algoritms.arbitrage.currency.OptimalRate;
import edu.princeton.cs.introcs.StdIn;

import edu.princeton.cs.introcs.StdOut;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 *  The <tt>Arbitrage</tt> class provides a client that finds an arbitrage
 *  opportunity in a currency exchange table by constructing a
 *  complete-digraph representation of the exchange table and then finding
 *  a negative cycle in the digraph.
 *  <p>
 *  This implementation uses the Bellman-Ford algorithm to find a
 *  negative cycle in the complete digraph.
 *  The running time is proportional to <em>V</em><sup>3</sup> in the
 *  worst case, where <em>V</em> is the number of currencies.
 *  <p>
 *  For additional documentation,
 *  see <a href="http://algs4.cs.princeton.edu/44sp">Section 4.4</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class Arbitrage3 {

    // this class cannot be instantiated
    private Arbitrage3() { }

    /**
     *  Reads the currency exchange table from standard input and
     *  prints an arbitrage opportunity to standard output (if one exists).
     */
    public static void main(String[] args) {
        
//          String[] currencies = {"USD", "CHF", "GBP", "JPY", "RUB", "TRY", "EUR"};
        String[] currencies = {"AZN", "USD", "EUR", "GBP", "RUB", "TRY",};
        
//        Map<String, Map<String, OptimalRate>> ratesMap = new ExcelPOI().getRates(ExcelPOI.bankList);
        Map<String, Map<String, OptimalRate>> ratesMap = new ExcelPOI().getRates(AznTodayCurrency.bankList);
        
        String bankName;
        
        // V currencies
        int V = currencies.length;
        String[] name = new String[V];

        // create complete network
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(V);
        for (int v = 0; v < V; v++) {
            name[v] = currencies[v];
            System.out.print(name[v]+"\t");
            Map<String, OptimalRate> map = ratesMap.get(currencies[v]);
            for (int w = 0; w < V; w++) {
                
                double rate = (v == w) ? 1 : map.get(currencies[w]).getValue();
                if(v == w) bankName = "";
                else bankName = map.get(currencies[w]).getName();
//                System.out.print(rate+"\t\t");
                System.out.printf("%.4f (%s)\t", rate, bankName);
                DirectedEdge e = new DirectedEdge(v, w, -Math.log(rate), bankName);
                G.addEdge(e);
            }
            System.out.println("");
        }
        System.out.println("");

        // find negative cycle
        BellmanFordSP spt = new BellmanFordSP(G, 0);
        if (spt.hasNegativeCycle()) {
            double stake = 1000.0;
            for (DirectedEdge e : spt.negativeCycle()) {
                StdOut.printf("%10.5f %s ", stake, name[e.from()]);
                stake *= Math.exp(-e.weight());
                StdOut.printf("= %10.5f %s", stake, name[e.to()]);
                System.out.printf(" %s\n", e.getBankName());  //16.09.2017-de elave edildi..
            }
        }
        else {
            StdOut.println("No arbitrage opportunity");
        }
    }

}
