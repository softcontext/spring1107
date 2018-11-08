package com.example.demo.lombok.step1;

//@Data :
//@Getter, @Setter, @RequiredArgsConstructor,
//@ToString, @EqualsAndHashCode 애노테이션들을 붙이는 대신 사용한다.
public class NonLombokModel {
	private String name;
	private int age;
	private String address;

	// @NoArgsConstructor
	public NonLombokModel() {
		
	}

	// @AllArgsConstructor
	// 또는
	// @RequiredArgsConstructor
	// @NonNull String name;
	// @NonNull Integer age;
	// @NonNull String address;
	public NonLombokModel(String name, int age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}

	// @Builder
	public static NonLombokModelBuilder builder() {
		NonLombokModel lombokModel = new NonLombokModel();
		return lombokModel.new NonLombokModelBuilder();
	}

	// @Builder
	class NonLombokModelBuilder {
		public NonLombokModelBuilder name(String name) {
			NonLombokModel.this.name = name;
			return this;
		}

		public NonLombokModelBuilder age(int age) {
			NonLombokModel.this.age = age;
			return this;
		}

		public NonLombokModelBuilder address(String address) {
			NonLombokModel.this.address = address;
			return this;
		}

		public NonLombokModel build() {
			return NonLombokModel.this;
		}
	}

	// @ToString
	@Override
	public String toString() {
		return "NonLombokModel [name=" + name + ", age=" + age + ", address=" + address + "]";
	}

	// @Getter
	public String getName() {
		return name;
	}

	// @Setter
	public void setName(String name) {
		this.name = name;
	}

	// @Getter
	public int getAge() {
		return age;
	}

	// @Setter
	public void setAge(int age) {
		this.age = age;
	}

	// @Getter
	public String getAddress() {
		return address;
	}

	// @Setter
	public void setAddress(String address) {
		this.address = address;
	}

	// @EqualsAndHashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	// @EqualsAndHashCode
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NonLombokModel other = (NonLombokModel) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
