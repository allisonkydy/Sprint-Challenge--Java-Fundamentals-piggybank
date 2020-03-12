package piggybank;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Main
{
  // create collection for piggybank
  public static ArrayList<Coin> piggyBank = new ArrayList<Coin>();

  public static void subtract(double subtractValue)
  {
    piggyBank.sort((c1, c2) -> (int)(c2.getValue() * 100) - (int)(c1.getValue() * 100));

    ArrayList<Coin> fakeBank = new ArrayList<Coin>();
    fakeBank.addAll(piggyBank);

    int removeCount = 0;

    for (int i = 0; i < fakeBank.size(); i++)
    {
      // exit loop if there is nothing left to subtract
      if (Math.round(subtractValue * 100.0) / 100.0 == 0.00)
      {
        break;
      }

      Coin c =  fakeBank.get(i);
      int amount = c.getAmount();

      // if the coin's is less than or equal to the remaining subtract value
      if (c.getValue() <= subtractValue)
      {
        // for each coin in the coin's amount
        for (int j = 0; j < amount; j++)
        {
          // exit loop if coin's value is greater than the remaining subtract value
          if (Math.round(c.getValue() * 100.0) / 100.0 > Math.round(subtractValue * 100.0) / 100.0)
          {
            break;
          }
          
          // if we've reached the last coin, remove it from the array, else decrement amount by 1
          if (j == amount - 1)
          {
            piggyBank.remove(c);
            removeCount++;
          }
          else
          {
            piggyBank.get(i - removeCount).setAmount(c.getAmount() - 1);
          }

          // subtract the coin's value from the remaining subtract value
          subtractValue -= Math.round(c.getValue() * 100.0) / 100.0;
        }
      }
    }
   }

  public static void main(String[] args)
  {
    // decimal formatting
    DecimalFormat fp = new DecimalFormat("$###,##0.00");

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
    double totalValue = 0.00;
    for(int i = 0; i < piggyBank.size(); i++)
    {
      totalValue += piggyBank.get(i).getTotalValue();
    }
    System.out.println("The piggy bank holds " + fp.format(totalValue));

    // remove $1.50 from the piggy bank
    subtract(1.50);

    piggyBank.forEach(coin -> coin.printAmount());

    totalValue = 0.00;
    for(int i = 0; i < piggyBank.size(); i++)
    {
      totalValue += piggyBank.get(i).getTotalValue();
    }

    System.out.println("The piggy bank holds " + fp.format(totalValue));
  }
}