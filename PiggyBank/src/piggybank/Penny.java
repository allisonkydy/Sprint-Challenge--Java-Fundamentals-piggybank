package piggybank;

public class Penny extends Coin
{
  // constructor
  public Penny(int amount)
  {
    super(amount);
    this.value = 0.01;
  }

  public Penny()
  {
    super();
    this.value = 0.01;
  }

  // methods
  @Override 
  public void printAmount()
  {
    if (amount == 1)
    {
      System.out.println(amount + " Penny");
    }
    else
    {
      System.out.println(amount + " Pennies");
    }
  }
}