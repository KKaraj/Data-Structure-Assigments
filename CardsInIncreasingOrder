public class CardsInIncreasingOrder {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck); //sort the deck in increasing order
        Deque<Integer> deque = new ArrayDeque<>(); //to simulate the reverse reveal process
        
        //Process from largest to smallest
        for (int i = deck.length - 1; i >= 0; i--) {
            if (!deque.isEmpty())
            	//move the last element to the front to simulate 
            	//reverse of "reveal then put next card at bottom"
            	deque.addFirst(deque.removeLast());
            //add the current card to the front
            deque.addFirst(deck[i]);
        }
        
        //convert deque to result array
        int[] result = new int[deque.size()];
        int index = 0;
        for (Integer num : deque) {
            result[index++] = num;
        }
        
        return result;
    }

    public static void main(String[] args) {
        CardsInIncreasingOrder solution = new CardsInIncreasingOrder();
        int[] input = {17, 13, 11, 2, 3, 5, 7};
        System.out.println("Input Deck: " + Arrays.toString(input));
        int[] output = solution.deckRevealedIncreasing(input);
        System.out.println("Output Deck: " + Arrays.toString(output)); 
    }
}
