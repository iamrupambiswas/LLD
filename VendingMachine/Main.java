package VendingMachine;

public class Main {
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();
        vm.addItems(new Item("Coke", 50.0f, 1));

        vm.insertCoin(100.0f);
        vm.selectItem("Coke");
        vm.selectItem("Coke");
        vm.returnChange();
    }
}
