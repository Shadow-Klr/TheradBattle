import java.util.Random;

public class NaveEstelar implements Runnable {
    private String nombre;
    private String civilizacion;
    private int posicion;
    private static final int MAX_TIRADAS = 200;
    private static final Object lock = new Object();
    private static Random random = new Random();

    public NaveEstelar(String civilizacion, String nombre) {
        this.civilizacion = civilizacion;
        this.nombre = nombre;
        this.posicion = 0;
    }

    @Override
    public void run() {
        for (int i = 1; i <= MAX_TIRADAS; i++) {
            avanzar(i);
            try {
                Thread.sleep(50); // simula tiempo entre tiradas
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        synchronized (lock) {
            System.out.println(nombre + ": Batalla espacial concluida.");
        }
    }

    private void avanzar(int tirada) {
        synchronized (lock) {
            int paso = random.nextInt(10) + 1; // entre 1 y 10 metros
            posicion += paso;
            System.out.println(nombre + ": Tirada " + tirada + " - He avanzado " + posicion + " metros!");
        }
    }

    public int getPosicion() {
        return posicion;
    }

    public String getCivilizacion() {
        return civilizacion;
    }

    public String getNombre() {
        return nombre;
    }
}
