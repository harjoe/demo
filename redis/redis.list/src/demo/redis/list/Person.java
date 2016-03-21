package demo.redis.list;

import java.io.Serializable;

public interface Person extends Serializable {

	public int getId();
	public String getName();
	public int getAge();
}
