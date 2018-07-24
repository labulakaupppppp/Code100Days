package stack_and_queue;

import java.util.LinkedList;
import java.util.Queue;


public class DogCatQueue_4 {
//实现add，pollAll，pollCat，pollDog，isEmpty，isDogEmpty，isCatEmpty
	private Queue<PetEnterQueue_4> catQ;
	private Queue<PetEnterQueue_4> dogQ;
	private long count;

	public DogCatQueue_4() {
		this.catQ = new LinkedList<>();
		this.dogQ = new LinkedList<>();
		this.count = 0;
	}

	public void add(Pet pet) {
		if (pet.getPetType().equals("dog")) {
			this.dogQ.add(new PetEnterQueue_4(pet, this.count++));
		} else if (pet.getPetType().equals("cat")) {
			this.catQ.add(new PetEnterQueue_4(pet, this.count++));
		} else {
			throw new RuntimeException("The pet what you add has a wrong type");
		}
	}

	public Pet pollAll() {
		if (!this.dogQ.isEmpty() && !this.catQ.isEmpty()) {
			if (this.dogQ.peek().getCount() < this.catQ.peek().getCount()) {
				return this.dogQ.poll().getPet();
			} else {
				return this.catQ.poll().getPet();
			}
		} else if (!this.dogQ.isEmpty()) {
			return this.dogQ.poll().getPet();
		} else if (!this.catQ.isEmpty()) {
			return this.catQ.poll().getPet();
		} else {
			throw new RuntimeException("queue is empty");
		}
	}

	public Dog pollDog() {
		if (!this.isDogEmpty()) {
			return (Dog) this.dogQ.poll().getPet();
		} else {
			throw new RuntimeException("dog queue is empty");
		}
	}

	public Cat pollCat() {
		if (!this.isCatEmpty()) {
			System.out.println(this.catQ.poll().getPet() instanceof Pet);
//			if(this.catQ.poll().getPet() instanceof Pet) {
//				return (Cat) this.catQ.poll().getPet();
//			}else {
//				throw new RuntimeException("type error");
//			}
			return (Cat) this.catQ.poll().getPet();
		} else {
			throw new RuntimeException("cat queue is empty");
		}
	}

	public boolean isEmpty() {
		return this.dogQ.isEmpty() && this.catQ.isEmpty();
	}

	public boolean isDogEmpty() {
		return this.dogQ.isEmpty();
	}

	public boolean isCatEmpty() {
		return this.catQ.isEmpty();
	}

	public static void main(String[] args) {
		Pet pet = new Pet("cat");
		Pet pet1 = new Pet("cat");
		Pet pet2 = new Pet("dog");
		Pet pet3 = new Pet("cat");
		Pet pet4 = new Pet("dog");
		Pet pet5 = new Pet("cat");
		Pet pet6 = new Pet("dog");
		Pet pet7 = new Pet("cat");
		Pet pet8 = new Pet("cat");
		Pet pet9 = new Pet("cat");
		DogCatQueue_4 ans = new DogCatQueue_4();
		ans.add(pet);
		ans.add(pet1);
		ans.add(pet2);
		ans.add(pet3);
		ans.add(pet4);

		System.out.println(ans.pollAll().getPetType());
		System.out.println(ans.pollAll().getPetType());
		System.out.println(ans.pollAll().getPetType());
		ans.add(pet5);
		System.out.println(ans.pollCat().getPetType());
	}
}
