class ProductOfNumbers {

    int end = 0;
    List<Integer> products;

    public ProductOfNumbers() {
        products = new ArrayList<>();
        products.add(1);
    }
    
    public void add(int num) {
        if(num == 0){
            for(int i = end; i >= 0 && products.get(i) != 0; i--){
                products.set(i, 0);
            }
            products.add(num);
        }
        else if(products.get(end) == 0) products.add(num);
        else products.add(num * products.get(end));
        end++;
        // System.out.println(end);
        // System.out.println(products.toString());
    }
    
    public int getProduct(int k) {
        // System.out.println();
        // System.out.println(products.get(end));
        // System.out.println(products.get(end - k));
        // System.out.println(products.get(end - k + 1));
        // System.out.println();
        if(products.get(end - k + 1) == 0) return 0;
        return products.get(end - k) == 0 ? products.get(end) : products.get(end)/products.get(end - k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */