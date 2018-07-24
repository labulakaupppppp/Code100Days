package stack_and_queue;

public class PetEnterQueue_4 {
	private Pet pet;
	private long count;
	//构造函数
	public PetEnterQueue_4(Pet pet,long count) {
		this.pet=pet;
		this.count = count;
	}
	public Pet getPet() {
		return this.pet;
	}
	public long getCount() {
		return this.count;
	}
	public String getPetType() {
		return this.pet.getPetType();
	}

}
