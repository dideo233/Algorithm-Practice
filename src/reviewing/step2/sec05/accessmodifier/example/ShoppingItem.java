package reviewing.step2.sec05.accessmodifier.example;

public class ShoppingItem {
    private String name;
    private int price;
    private int quantity;

    public ShoppingItem(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    // 데이터가 있는 곳(Item)에 계산 로직도 두는 것이 좋은 객체지향 설계
    public int getTotalPrice(){
        return price * quantity;
    }
}

