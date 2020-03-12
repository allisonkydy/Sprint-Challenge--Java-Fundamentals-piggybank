package piggybank;

public class Dollar extends Coin
{
  // constructor
  public Dollar(int amount)
  {
    super(amount);
    this.value = 1.00;
  }

  public Dollar()
  {
    super();
    this.value = 1.00;
  }

  // methods
  @Override 
  public void printAmount()
  {
    System.out.println("$" + amount);
  }
}