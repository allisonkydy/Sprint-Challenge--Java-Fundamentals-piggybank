package piggybank;

public abstract class Coin
{
  // fields
  protected double value;
  protected int amount;

  // constructor
  public Coin(double value, int amount)
  {
    this.value = value;
    this.amount = amount;
  }

  public Coin(double value)
  {
    this.value = value;
    amount = 1;
  }

  // abstract methods
  public abstract void printTotal();

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