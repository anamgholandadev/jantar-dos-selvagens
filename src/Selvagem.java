class Selvagem extends Thread {
  private int id;
  private Cozinheiro cozinheiro;

  public Selvagem(int id, Cozinheiro cozinheiro) {
    this.id = id;
    this.cozinheiro = cozinheiro;
  }

  private void servir() throws InterruptedException {
    JantarDosSelvagens.caldeirao.colher.acquire();

    while (JantarDosSelvagens.caldeirao.porcoes == 0) {
      cozinheiro.acordar();
    }

    System.out.println("Selvagem " + id + " servindo.");
    JantarDosSelvagens.caldeirao.porcoes--;
    Thread.sleep(500);

    JantarDosSelvagens.caldeirao.colher.release();
  }

  private void comer() throws InterruptedException {
    Thread.sleep(1000);
    System.out.println("Selvagem " + id + " comeu.");
  }

  @Override
  public void run() {
    try {
      while (true) {
        servir();
        comer();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}