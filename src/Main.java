//Código Actividad n8
//Calculadora de área, potencia y perímetro con clases
import java.util.Scanner;

// Interfaz para operaciones matemáticas
interface Operacion {
    void calcular(); // Método abstracto para calcular área o perímetro
}

// Clase abstracta Figura que será la base para todas las figuras
abstract class Figura {
    protected Scanner entrada = new Scanner(System.in);

    public abstract void menu(); // Menú específico de cada figura
}

// Clase Círculo
class Circulo extends Figura implements Operacion {
    private double radio;

    @Override
    public void menu() {
        System.out.print("Digite el radio del círculo: ");
        radio = entrada.nextDouble();
    }

    @Override
    public void calcular() {
        System.out.println("1. Área del círculo");
        System.out.println("2. Perímetro del círculo");
        int opcion = entrada.nextInt();

        if (opcion == 1) {
            double area = Math.PI * Math.pow(radio, 2);
            System.out.printf("El área del círculo es: %.2f\n", area);
        } else if (opcion == 2) {
            double perimetro = 2 * Math.PI * radio;
            System.out.printf("El perímetro del círculo es: %.2f\n", perimetro);
        } else {
            System.out.println("Opción no válida.");
        }
    }
}

// Clase Cuadrado
class Cuadrado extends Figura implements Operacion {
    private double lado;

    @Override
    public void menu() {
        System.out.print("Digite el lado del cuadrado: ");
        lado = entrada.nextDouble();
    }

    @Override
    public void calcular() {
        System.out.println("1. Área del cuadrado");
        System.out.println("2. Perímetro del cuadrado");
        int opcion = entrada.nextInt();

        if (opcion == 1) {
            double area = lado * lado;
            System.out.printf("El área del cuadrado es: %.2f\n", area);
        } else if (opcion == 2) {
            double perimetro = 4 * lado;
            System.out.printf("El perímetro del cuadrado es: %.2f\n", perimetro);
        } else {
            System.out.println("Opción no válida.");
        }
    }
}

// Clase Triángulo
class Triangulo extends Figura implements Operacion {
    private double base, altura, lado1, lado2, lado3;

    @Override
    public void menu() {
        System.out.println("Digite la base y altura del triángulo:");
        base = entrada.nextDouble();
        altura = entrada.nextDouble();
    }

    @Override
    public void calcular() {
        System.out.println("1. Área del triángulo");
        System.out.println("2. Perímetro del triángulo");
        int opcion = entrada.nextInt();

        if (opcion == 1) {
            double area = (base * altura) / 2;
            System.out.printf("El área del triángulo es: %.2f\n", area);
        } else if (opcion == 2) {
            System.out.println("Digite los tres lados del triángulo:");
            lado1 = entrada.nextDouble();
            lado2 = entrada.nextDouble();
            lado3 = entrada.nextDouble();
            double perimetro = lado1 + lado2 + lado3;
            System.out.printf("El perímetro del triángulo es: %.2f\n", perimetro);
        } else {
            System.out.println("Opción no válida.");
        }
    }
}

// Clase Rectángulo
class Rectangulo extends Figura implements Operacion {
    private double largo, ancho;

    @Override
    public void menu() {
        System.out.println("Digite el largo y el ancho del rectángulo:");
        largo = entrada.nextDouble();
        ancho = entrada.nextDouble();
    }

    @Override
    public void calcular() {
        System.out.println("1. Área del rectángulo");
        System.out.println("2. Perímetro del rectángulo");
        int opcion = entrada.nextInt();

        if (opcion == 1) {
            double area = largo * ancho;
            System.out.printf("El área del rectángulo es: %.2f\n", area);
        } else if (opcion == 2) {
            double perimetro = 2 * (largo + ancho);
            System.out.printf("El perímetro del rectángulo es: %.2f\n", perimetro);
        } else {
            System.out.println("Opción no válida.");
        }
    }
}

// Clase Potencia
class Potencia implements Operacion {
    private double base;
    private int exponente;

    public Potencia(Scanner entrada) {
        System.out.print("Digite la base: ");
        this.base = entrada.nextDouble();
        System.out.print("Digite el exponente: ");
        this.exponente = entrada.nextInt();
    }

    @Override
    public void calcular() {
        double resultado = calcularPotencia(base, exponente);
        System.out.printf("El resultado de %.2f^%d es: %.2f\n", base, exponente, resultado);
    }

    private double calcularPotencia(double base, int exp) {
        if (exp == 0) return 1;
        return exp > 0 ? base * calcularPotencia(base, exp - 1) : 1 / calcularPotencia(base, -exp);
    }
}

// Clase principal Calculadora
public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("=== Calculadora Matemática ===");
            System.out.println("1. Círculo");
            System.out.println("2. Cuadrado");
            System.out.println("3. Triángulo");
            System.out.println("4. Rectángulo");
            System.out.println("5. Potencia");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = entrada.nextInt();

            Figura figura = null;

            switch (opcion) {
                case 1: figura = new Circulo(); break;
                case 2: figura = new Cuadrado(); break;
                case 3: figura = new Triangulo(); break;
                case 4: figura = new Rectangulo(); break;
                case 5:
                    Operacion potencia = new Potencia(entrada);
                    potencia.calcular();
                    continue;
                case 6:
                    continuar = false;
                    System.out.println("¡Gracias por usar la calculadora!");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    continue;
            }

            if (figura != null) {
                figura.menu();
                ((Operacion) figura).calcular();
            }
        }
        entrada.close();
    }
}

