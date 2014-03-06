package br.com.dojo.component;

/**
 * Arma utilizada no jogo
 * @author afng
 *
 * @param <T>
 */
public class Weapon<T> {
	
	private T name;

	public Weapon() {
		super();
	}

	public Weapon(T name) {
		super();
		this.name = name;
	}

	public T getName() {
		return name;
	}

	public void setName(T name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Weapon other = (Weapon) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Weapon [name = " + name + "]";
	}

}