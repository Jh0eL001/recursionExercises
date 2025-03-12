public class RecursiveSum {
  
  public static int mult(int a, int b) {
    int res;
    if (b == 1) {
      res = a;
    }
    else {
      res = mult(a, b- 1) + a; 
    }
    return res;
  }
  public static void main(String[] args) {
    int a = 5, b =3; 
    System.out.println(a + " times " + b + " is equals to: " + mult(a, b));
  }
}