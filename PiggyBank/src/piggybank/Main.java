package piggybank;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Main
{
  public static double subtract(ArrayList<Coin> arr, double totalValue, double subtractValue)
  {
    double leftToSubtract = subtractValue;

    ArrayList<Coin> arrCopy = new ArrayList<Coin>();
    arrCopy.addAll(arr);

    int removeCount = 0;

    for (int i = 0; i < arrCopy.size(); i++)
    {
      Coin c =  arrCopy.get(i);
      int amount = c.getAmount();
      // exit loop if there is nothing left to subtract
      if (leftToSubtract == 0)
      {
        break;
      }

      // if the coin's is less than or equal to the remaining subtract value
      if (c.getValue() <= leftToSubtract)
      {
        // for each coin in the coin's amount
        for (int j = 0; j < amount; j++)
        {
          // exit loop if coin's value is greater than the remaining subtract value
          if (Math.round(c.getValue() * 100.0) / 100.0 > Math.round(leftToSubtract * 100.0) / 100.0)
          {
            break;
          }
          
          // if we've reached the last coin, remove it from the array, else decrement amount by 1
          if (j == amount - 1)
          {
            arr.remove(c);
            removeCount++;
          }
          else
          {
            arr.get(i - removeCount).setAmount(c.getAmount() - 1);
          }

          // subtract the coin's value from the remaining subtract value
          leftToSubtract -= Math.round(c.getValue() * 100.0) / 100.0;
        }
      }
    }

    // return updated total value
    return (totalValue - (subtractValue - leftToSubtract));
  }

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
    double totalValue = 0.00;
    for(int i = 0; i < piggyBank.size(); i++)
    {
      totalValue += piggyBank.get(i).getTotalValue();
    }
    System.out.println("The piggy bank holds " + fp.format(totalValue));

    // remove $1.50 from the piggy bank
    double updatedTotalValue = subtract(piggyBank, totalValue, 1.50);

    piggyBank.forEach(coin -> coin.printAmount());

    System.out.println("The piggy bank holds " + fp.format(updatedTotalValue));
  }
}