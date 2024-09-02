package Banco;


public class Main{
    public static void main(String[] args) {
       Banco banco = new Banco("Banco");
	   Menu menu = new Menu(banco);
	   menu.iniciar();
    }
}