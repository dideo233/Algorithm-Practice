package reviewing.step2.sec05accessmodifier.example;

public class ShoppingCart {
    private ShoppingItem[] items = new ShoppingItem[10];
    private int itemCount;

    public void addItem(ShoppingItem item) {
        if (itemCount >= items.length) {
            System.out.println("장바구니가 가득 찼습니다.");
            return;
        }
        items[itemCount] = item;
        itemCount++;
    }

    public void displayItems() {
        System.out.println("장바구니 상품 목록");
        for(int i = 0; i < itemCount; i++) {
            System.out.println("상품명: " + items[i].getName() + ", 상품 총액: " + items[i].getTotalPrice());
        }
        // item.price에 직접 접근하는 게 아니라, item이 제공하는 기능(getTotalPrice)을 사용

        System.out.println("전체 가격 합: " + calculateTotalPrice());
    }

    // 내부 계산 로직 -> private
    private int calculateTotalPrice() {
        int totalPrice = 0;
        for(int i = 0; i < itemCount; i++) {
            totalPrice += items[i].getTotalPrice();
        }
        return totalPrice;
    }
}
