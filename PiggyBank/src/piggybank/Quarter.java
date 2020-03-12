package piggybank;

public class Quarter extends Coin
{
  // constructor
  public Quarter(int amount)
  {
    super(amount);
    this.value = 0.25;
  }

  public Quarter()
  {
    super();
    this.value = 0.25;
  }

  // methods
  @Override 
  public void printAmount()
  {
    if (amount == 1)
    {
      System.out.println(amount + " Quarter");
    }
    else
    {
      System.out.println(amount + " Quarters");
    }
  }
}