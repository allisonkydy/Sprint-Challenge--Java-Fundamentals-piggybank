package piggybank;

import java.text.DecimalFormat;

public abstract class Coin
{
  DecimalFormat fp = new DecimalFormat("$###,###.00");

  // fields
  protected double value;
  protected int amount;

  // constructor
  public Coin(int amount)
  {
    this.amount = amount;
  }

  public Coin()
  {
    amount = 1;
  }

  // abstract methods
  public abstract void printAmount();
  
  // default methods
  public void printTotalValue()
  {
    System.out.println(fp.format(value * amount));
  }

  // getters and setters
  public double getValue()
  {
    return value;
  }

  public void setValue(double value)
  {
    this.value = value;
  }

  public int getAmount()
  {
    return amount;
  }

  public void setAmount(int amount)
  {
    this.amount = amount;
  }
}