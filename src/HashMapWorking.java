import java.util.HashMap;
import java.util.Map;

public class HashMapWorking {

	public static void main(final String[] args) {
		final HashMapWorking test = new HashMapWorking();
		test.testMap();
	}

	public void testMap() {
		final Map<Student, Teacher> map = new HashMap<>();
		map.put(new Student(1, "Vishal"), new Teacher());
		System.out.println(map.get(new Student(1, "Vishal")));
		map.put(new Student(1, "Vishal"), new Teacher());
		System.out.println(map.size());

	}

	class Student {
		int id;
		String name;

		Student(final int id, final String name) {
			super();
			this.id = id;
			this.name = name;
		}

		@Override
		public int hashCode() {

			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + id;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;

		}

		@Override
		public boolean equals(final Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final Student other = (Student) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			if (id != other.id)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

		private HashMapWorking getEnclosingInstance() {
			return HashMapWorking.this;
		}

	}

	class Teacher {
		int id;
		String dept;
	}

}
