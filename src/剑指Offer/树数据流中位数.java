package 剑指Offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 41 P214 用堆实现，奇数偶数区分
 * 
 * @author Lenovo
 *
 */
public class 树数据流中位数 {
	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}
	});
	int count = 0;

	public void Insert(Integer num) {
		if (count % 2 == 0) {
			maxHeap.offer(num);
			Integer poll = maxHeap.poll();
			minHeap.offer(poll);
		} else {
			minHeap.offer(num);
			Integer poll = minHeap.poll();
			maxHeap.offer(poll);
		}
		count++;
	}

	public Double GetMedian() {
		if (count % 2 == 0) {
			return new Double((maxHeap.peek() + minHeap.peek())) / 2;//重點！如果算完再包裝就不對了，因爲包裝的是整形會丟失double精度
		} else {
			return new Double(minHeap.peek());
		}
	}
}
/**
 * 
 * private int count = 0; private PriorityQueue<Integer> minHeap = new
 * PriorityQueue<>(); private PriorityQueue<Integer> maxHeap = new
 * PriorityQueue<Integer>(15, new Comparator<Integer>() {
 * 
 * @Override public int compare(Integer o1, Integer o2) { return o2 - o1; } });
 * 
 *           public void Insert(Integer num) { if (count %2 == 0)
 *           {//当数据总数为偶数时，新加入的元素，应当进入小根堆 //（注意不是直接进入小根堆，而是经大根堆筛选后取大根堆中最大元素进入小根堆）
 *           //1.新加入的元素先入到大根堆，由大根堆筛选出堆中最大的元素 maxHeap.offer(num); int
 *           filteredMaxNum = maxHeap.poll(); //2.筛选后的【大根堆中的最大元素】进入小根堆
 *           minHeap.offer(filteredMaxNum); } else {//当数据总数为奇数时，新加入的元素，应当进入大根堆
 *           //（注意不是直接进入大根堆，而是经小根堆筛选后取小根堆中最大元素进入大根堆）
 *           //1.新加入的元素先入到小根堆，由小根堆筛选出堆中最小的元素 minHeap.offer(num); int
 *           filteredMinNum = minHeap.poll(); //2.筛选后的【小根堆中的最小元素】进入大根堆
 *           maxHeap.offer(filteredMinNum); } count++; }
 * 
 *           public Double GetMedian() { if (count %2 == 0) { return new
 *           Double((minHeap.peek() + maxHeap.peek())) / 2; } else { return new
 *           Double(minHeap.peek()); } }
 */
