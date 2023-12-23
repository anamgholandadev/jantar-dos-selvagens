
class JantarDosSelvagens {
  private static final int X = 3; // Número de selvagens
  private static final int Y = 3; // Número de porções no caldeirão

  public static Caldeirao caldeirao = new Caldeirao();

  public static void main(String[] args) {
    Cozinheiro cozinheiro = new Cozinheiro(Y);
    cozinheiro.start();

    for (int i = 0; i < X; i++) {
      Selvagem selvagem = new Selvagem(i, cozinheiro);
      selvagem.start();
    }
  }
}
