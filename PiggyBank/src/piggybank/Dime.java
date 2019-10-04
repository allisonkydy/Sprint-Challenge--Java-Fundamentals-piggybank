package piggybank;

public class Dime extends Coin
{
  // constructor
  public Dime(int amount)
  {
    super(amount);
    this.value = 0.10;
  }

  public Dime()
  {
    super();
    this.value = 0.10;
  }

  // methods
  @Override 
  public void printAmount()
  {
    if (amount == 1)
    {
      System.out.println(amount + " Dime");
    }
    else
    {
      System.out.println(amount + " Dimes");
    }
  }
}