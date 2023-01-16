public class Main {
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();
        vm.addProduct(new Product("Яблоко", 20));
        vm.addProduct(new Product("Груша", 30));
        vm.addProduct(new Drink("Lipton", 40, 0.5, TypesOfDrink.COLDTEA));
        vm.addProduct(new Chocolate("Аленка", 40, 50));

        System.out.println(vm);

    }
}