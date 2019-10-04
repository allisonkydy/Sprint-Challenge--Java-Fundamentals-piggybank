package piggybank;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Main
{
  public static void main(String[] args)
  {
    // decimal formatting
    DecimalFormat fp = new DecimalFormat("$###,###.00");

    // create collection for piggybank
    ArrayList<Coin> piggyBank = new ArrayList<Coin>();

    // add coins to piggybank
    piggyBank.add(new Quarter());
    piggyBank.add(new Dime());
    piggyBank.add(new Dollar(5));
    piggyBank.add(new Nickel(3));
    piggyBank.add(new Dime(7));
    piggyBank.add(new Dollar());
    piggyBank.add(new Penny(10));

    // print contents of piggybank
    piggyBank.forEach(coin -> coin.printAmount());

    // print value of piggybank
    double totalValue = 0;
    for(int i = 0; i < piggyBank.size(); i++)
    {
      totalValue += piggyBank.get(i).getTotalValue();
    }
    System.out.println("The piggy bank holds " + fp.format(totalValue));
  }
}