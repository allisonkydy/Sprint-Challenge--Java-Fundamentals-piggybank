package piggybank;

public abstract class Coin
{
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