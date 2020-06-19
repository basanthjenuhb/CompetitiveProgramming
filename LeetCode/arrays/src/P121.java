/**
 * @author bjenuhb
 */

public class P121 {

    public int maxProfit(int[] prices) {
        int maxPrice = Integer.MIN_VALUE;
        int minPrice = Integer.MAX_VALUE;
        for (int price: prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice < maxPrice) {
                maxPrice = price - minPrice;
            }
        }
        return maxPrice;
    }

}
