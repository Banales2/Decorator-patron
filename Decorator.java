interface Bebida {
    String getDescription();
    double cost();
}

class Espresso implements Bebida {
    @Override
    public String getDescription() {
        return "Espresso";
    }

    @Override
    public double cost() {
        return 2.0;
    }
}

class Americano implements Bebida {
    @Override
    public String getDescription() {
        return "Americano";
    }

    @Override
    public double cost() {
        return 1.5;
    }
}

abstract class BebidaDecorator implements Bebida {
    protected Bebida bebida;
    
    public BebidaDecorator(Bebida bebida) {
        this.bebida = bebida;
    }
    
    @Override
    public String getDescription() {
        return bebida.getDescription();
    }
}

class LecheDecorator extends BebidaDecorator {
    public LecheDecorator(Bebida bebida) {
        super(bebida);
    }
    
    @Override
    public String getDescription() {
        return bebida.getDescription() + " + Leche";
    }
    
    @Override
    public double cost() {
        return bebida.cost() + 0.5;
    }
}

class ChocolateDecorator extends BebidaDecorator {
    public ChocolateDecorator(Bebida bebida) {
        super(bebida);
    }
    
    @Override
    public String getDescription() {
        return bebida.getDescription() + " + Chocolate";
    }
    
    @Override
    public double cost() {
        return bebida.cost() + 0.7;
    }
}

class CanelaDecorator extends BebidaDecorator {
    public CanelaDecorator(Bebida bebida) {
        super(bebida);
    }
    
    @Override
    public String getDescription() {
        return bebida.getDescription() + " + Canela";
    }
    
    @Override
    public double cost() {
        return bebida.cost() + 0.3;
    }
}

public class Decorator {
    public static void main(String[] args) {
        Bebida beverage = new Espresso();
        System.out.println("Pedido: " + beverage.getDescription());
        System.out.println("Precio: $" + beverage.cost());
        
        Bebida specialCoffee = new Espresso();
        specialCoffee = new LecheDecorator(specialCoffee);
        specialCoffee = new CanelaDecorator(specialCoffee);
        
        System.out.println("\nPedido: " + specialCoffee.getDescription());
        System.out.println("Precio: $" + specialCoffee.cost());
        
        Bebida fancyAmericano = new Americano();
        fancyAmericano = new ChocolateDecorator(fancyAmericano);
        fancyAmericano = new LecheDecorator(fancyAmericano);
        
        System.out.println("\nPedido: " + fancyAmericano.getDescription());
        System.out.println("Precio: $" + fancyAmericano.cost());
    }
}