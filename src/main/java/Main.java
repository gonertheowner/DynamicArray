public class Main {
    public static void main(String[] args) {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>(2);
        System.out.println(dynamicArray.size());
        dynamicArray.add(9);
        dynamicArray.add(10);
        dynamicArray.add(11);
        System.out.println(dynamicArray.size());
        System.out.println(dynamicArray.isEmpty());
        System.out.println(dynamicArray);
        System.out.println(dynamicArray.get(1));
        System.out.println(dynamicArray.contains(122));
        dynamicArray.remove(10);
        System.out.println(dynamicArray);
        dynamicArray.clear();
        System.out.println(dynamicArray);
    }
}
