class Cozinheiro extends Thread {
  private boolean dormindo = true;
  private int porcoes;

  public Cozinheiro(int porcoes) {
    this.porcoes = porcoes;
  }

  private void encher_caldeirao() throws InterruptedException {
    System.out.println("Cozinheiro enchendo o caldeirão.");
    Thread.sleep(1000);
    System.out.println("Cozinheiro foi dormir.");
    JantarDosSelvagens.caldeirao.porcoes = porcoes;
  }

  private void dormir() throws InterruptedException {
    dormindo = true;
  }

  public synchronized void acordar() {
    dormindo = false;
  }

  @Override
  public void run() {
    try {
      while (true) {
        while (dormindo) {
          Thread.sleep(0);
        }

        encher_caldeirao();
        dormir();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}