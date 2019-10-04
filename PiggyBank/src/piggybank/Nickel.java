package piggybank;

public class Nickel extends Coin
{
  // constructor
  public Nickel(int amount)
  {
    super(amount);
    this.value = 0.05;
  }

  public Nickel()
  {
    super();
    this.value = 0.05;
  }

  // methods
  @Override 
  public void printAmount()
  {
    if (amount == 1)
    {
      System.out.println(amount + " Nickel");
    }
    else
    {
      System.out.println(amount + " Nickels");
    }
  }
}